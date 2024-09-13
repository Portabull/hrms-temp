package com.portabull.utils;

import com.portabull.exception.ErrorConstants;
import com.portabull.exception.GreatDataException;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.security.crypto.encrypt.TextEncryptor;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.*;
import java.util.Arrays;

public class CodecUtil {
    private static Logger logger = LoggerFactory.getLogger(CodecUtil.class);
    private static final String ALGORITHM = "AES/CBC/PKCS5Padding";
    private static SecretKeySpec secretKey;
    private static final String REPOSITORY_SECRET_KEY = "aWEyUU==!!!!768Ghjuy";
    private static SecureRandom random = new SecureRandom();
    private static final String UTF_8_ENCODING = "UTF-8";
    private static String cryptoKey;
    private static final String SALT = "90696b9a48eea697";

    private CodecUtil() {
    }

    public static void initalize(String secreteKeyEncriptedValue, String encrKey) {
        if (StringUtils.isEmpty(cryptoKey)) {
            cryptoKey = generateKey(secreteKeyEncriptedValue, encrKey);
        }
    }

    // Added this method to avoid passing secret key as method input parameter
    public static String encrypt(String strToEncrypt) throws GreatDataException {
        try {
            setKey(cryptoKey);
            return encryptText(strToEncrypt);
        } catch (InvalidKeyException | NoSuchAlgorithmException | NoSuchPaddingException
                 | InvalidAlgorithmParameterException | IllegalBlockSizeException | BadPaddingException
                 | UnsupportedEncodingException e) {
            logger.error("Encryption Failed. Error occured {}", e.getMessage());
            throw new GreatDataException(500, ErrorConstants.GDP500000_MESSAGE, ErrorConstants.GDP500015_DETAILS);
        }
    }

    // Added this method to avoid passing secret key as method input parameter
    public static String pwdDecrypt(String encryptedPassword) throws GreatDataException {
        //String secreteKey = getSecreteKey();
        return pwdDecrypt(cryptoKey, encryptedPassword);
    }

    public static String decryptPassword(String pass) throws GreatDataException {
        String pwd = "";
        try {
            setKey(cryptoKey);
            pwd = decrypt(pass);
        } catch (InvalidKeyException | NoSuchPaddingException | InvalidAlgorithmParameterException
                 | NoSuchAlgorithmException | BadPaddingException | IllegalBlockSizeException
                 | UnsupportedEncodingException e) {
            logger.error("Decryption Failed. Error occured {}", e);
            throw new GreatDataException(500, ErrorConstants.GDP500000_MESSAGE, ErrorConstants.GDP500015_DETAILS);
        }
        return pwd;
    }

    /*
     * public static String getRepositorySecretKey() { return REPOSITORY_SECRET_KEY;
     * }
     */

    private static void setKey(String myKey) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest sha = null;
        byte[] key = null;
        try {
            key = myKey.getBytes(UTF_8_ENCODING);
            sha = MessageDigest.getInstance("SHA-1");
            key = sha.digest(key);
            key = Arrays.copyOf(key, 16);
            secretKey = new SecretKeySpec(key, "AES");
        } catch (NoSuchAlgorithmException e) {
            logger.error("", e);
            throw e;
        } catch (UnsupportedEncodingException e) {
            logger.error("", e);
            throw e;
        }
    }

    private static String encryptText(String strToEncrypt) throws NoSuchAlgorithmException, NoSuchPaddingException,
            InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException,
            UnsupportedEncodingException {
        String retVal = "";
        String encString = "";
        try {
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            byte[] bytesIV = new byte[16];
            // random.nextBytes(bytesIV);
            IvParameterSpec iv = new IvParameterSpec(bytesIV);
            cipher.init(Cipher.ENCRYPT_MODE, secretKey, iv);
            retVal = Base64.encodeBase64String(cipher.doFinal(strToEncrypt.getBytes(UTF_8_ENCODING)));
            encString = new String(retVal);

        } catch (Exception e) {
            logger.error("Error while encrypting: " + e.toString());
            throw e;
        }
        return encString;
    }

    private static String decrypt(String strToDecrypt) throws NoSuchPaddingException, InvalidAlgorithmParameterException,
            InvalidKeyException, BadPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException {
        String retVal = "";
        try {
            if (strToDecrypt != null) {
                Cipher cipher = Cipher.getInstance(ALGORITHM);
                byte[] bytesIV = new byte[16];
                // random.nextBytes(bytesIV);
                IvParameterSpec iv = new IvParameterSpec(bytesIV);
                cipher.init(Cipher.DECRYPT_MODE, secretKey, iv);
                byte[] decodebyte = Base64.decodeBase64(strToDecrypt.getBytes());
                byte[] decValue = cipher.doFinal(decodebyte);
                retVal = new String(decValue);
            }
        } catch (NoSuchPaddingException nspe) {
            logger.error("Error while decrypting: " + nspe.toString());
            throw nspe;
        } catch (InvalidAlgorithmParameterException iape) {
            logger.error("Error while decrypting: " + iape.toString());
            throw iape;
        } catch (InvalidKeyException ike) {
            logger.error("Error while decrypting: " + ike.toString());
            throw ike;
        } catch (BadPaddingException bpe) {
            logger.error("Error while decrypting: " + bpe.toString());
            throw bpe;
        } catch (IllegalBlockSizeException ibse) {
            logger.error("Error while decrypting: " + ibse.toString());
            throw ibse;
        } catch (NoSuchAlgorithmException nsae) {
            logger.error("Error while decrypting: " + nsae.toString());
            throw nsae;
        }
        return retVal;
    }

    private static String pwdDecrypt(String secret, String encryptedPassword) throws GreatDataException {
        byte[] decryptedData = null;
        String decryptedText = null;
        try {
            decryptedText = passwordDecryptAES(secret, encryptedPassword);

            // Try different decryption if first decryption fails
            if (decryptedText == null || decryptedText.equals("")) {
                decryptedText = decryptPassword(encryptedPassword);
            }
        } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidAlgorithmParameterException
                 | InvalidKeyException | BadPaddingException | IllegalBlockSizeException nsae) {
            logger.error("Error Occured while password decryption {}", nsae);

            throw new GreatDataException(500, ErrorConstants.GDP500000_MESSAGE, ErrorConstants.GDP500603_MESSAGE);

        }
        return decryptedText;
    }

    private static String passwordDecryptAES(String secret, String encryptedPassword)
            throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException,
            InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
        byte[] decryptedData = null;
        String decryptedText = null;
        try {
            byte[] cipherData = java.util.Base64.getDecoder().decode(encryptedPassword);
            byte[] saltData = Arrays.copyOfRange(cipherData, 8, 16);
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            final byte[][] keyAndIV = GenerateKeyAndIV(32, 16, 1, saltData, secret.getBytes(StandardCharsets.UTF_8),
                    md5);
            // random.nextBytes(keyAndIV[0]);
            SecretKeySpec key = new SecretKeySpec(keyAndIV[0], "AES");
            // random.nextBytes(keyAndIV[1]);
            IvParameterSpec iv = new IvParameterSpec(keyAndIV[1]);

            byte[] encrypted = Arrays.copyOfRange(cipherData, 16, cipherData.length);
            Cipher aesCBC = Cipher.getInstance(ALGORITHM);
            aesCBC.init(Cipher.DECRYPT_MODE, key, iv);
            decryptedData = aesCBC.doFinal(encrypted);
            decryptedText = new String(decryptedData, StandardCharsets.UTF_8);

        } catch (InvalidKeyException | NoSuchAlgorithmException | NoSuchPaddingException
                 | InvalidAlgorithmParameterException | IllegalBlockSizeException | BadPaddingException e) {
            logger.error("Decryption Failed. Error occured {}", e);
        }
        return decryptedText;
    }

    private static byte[][] GenerateKeyAndIV(int keyLength, int ivLength, int iterations, byte[] salt, byte[] password,
                                             MessageDigest md) {

        int digestLength = md.getDigestLength();
        int requiredLength = (keyLength + ivLength + digestLength - 1) / digestLength * digestLength;
        byte[] generatedData = new byte[requiredLength];
        int generatedLength = 0;

        try {
            md.reset();

            // Repeat process until sufficient data has been generated
            while (generatedLength < keyLength + ivLength) {

                // Digest data (last digest if available, password data, salt if available)
                if (generatedLength > 0)
                    md.update(generatedData, generatedLength - digestLength, digestLength);
                md.update(password);
                if (salt != null)
                    md.update(salt, 0, 8);
                md.digest(generatedData, generatedLength, digestLength);

                // additional rounds
                for (int i = 1; i < iterations; i++) {
                    md.update(generatedData, generatedLength, digestLength);
                    md.digest(generatedData, generatedLength, digestLength);
                }

                generatedLength += digestLength;
            }

            // Copy key and IV into separate byte arrays
            byte[][] result = new byte[2][];
            result[0] = Arrays.copyOfRange(generatedData, 0, keyLength);
            if (ivLength > 0)
                result[1] = Arrays.copyOfRange(generatedData, keyLength, keyLength + ivLength);

            return result;

        } catch (DigestException e) {
            throw new RuntimeException(e);
        } finally {
            // Clean out temporary data
            Arrays.fill(generatedData, (byte) 0);
        }
    }

    /*
     * This encrypt method to pass the password for scala project This is used in
     * functionality of the saving parquet file columns Here we are sending secret
     * key and password
     */


    /*
     * public static String encryptToAES(String strToEncrypt) { String
     * repositorySecretKey = getRepositorySecretKey(); return
     * encryptRepoToAES(strToEncrypt, repositorySecretKey); } private static String
     * encryptRepoToAES(String strToEncrypt, String secret) { try { setKey(secret);
     * Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
     * cipher.init(Cipher.ENCRYPT_MODE, secretKey); return
     * java.util.Base64.getEncoder().encodeToString(cipher.doFinal(strToEncrypt.
     * getBytes(UTF_8_ENCODING))); } catch (Exception e) {
     * logger.error("Error while encrypting:{} ", e.getMessage()); } return null; }
     */

    /**
     * Method to decrypt the secrete key
     *
     * @param secreteKeyEncriptedValue
     * @param encrKey
     * @return
     */
    private static String generateKey(String secreteKeyEncriptedValue, String encrKey) {
        TextEncryptor textEncryptor = Encryptors.text(encrKey, SALT);
        return textEncryptor.decrypt(secreteKeyEncriptedValue);
    }


    /**
     * Decrypt method for CLI which will pass the message and the secretString
     *
     * @param secreteKeyEncriptedValue
     * @param encryptedSecrete
     * @return
     * @throws GreatDataException
     */
    public static String decrypt(String secreteKeyEncriptedValue, String encryptedSecrete, String hintText) throws GreatDataException {
        try {
            String secret = generateKey(encryptedSecrete, hintText);
            setKey(secret);
            return decrypt(secreteKeyEncriptedValue);
        } catch (InvalidKeyException | NoSuchPaddingException | InvalidAlgorithmParameterException
                 | NoSuchAlgorithmException | BadPaddingException | IllegalBlockSizeException
                 | UnsupportedEncodingException e) {
            logger.error("Decryption Failed. Error occured {}", e.getMessage());
            throw new GreatDataException(500, ErrorConstants.GDP500000_MESSAGE, ErrorConstants.GDP500015_DETAILS);
        }
    }

    //Added a decrypt method for CLI which will pass the message and the encrypted secretString

    /**
     * Encryption method which will pass the message and secretString
     *
     * @param secreteKeyEncriptedValue
     * @param encryptedSecret
     * @return
     * @throws GreatDataException
     */
    public static String encrypt(String secreteKeyEncriptedValue, String encryptedSecrete, String hintText) throws GreatDataException {
        try {
            String secrete = generateKey(encryptedSecrete, hintText);
            setKey(secrete);
            return encryptText(secreteKeyEncriptedValue);
        } catch (InvalidKeyException | NoSuchAlgorithmException | NoSuchPaddingException
                 | InvalidAlgorithmParameterException | IllegalBlockSizeException | BadPaddingException
                 | UnsupportedEncodingException e) {
            logger.error("Encryption Failed. Error occured {}", e.getMessage());
            throw new GreatDataException(500, ErrorConstants.GDP500000_MESSAGE, ErrorConstants.GDP500015_DETAILS);
        }
    }
}

