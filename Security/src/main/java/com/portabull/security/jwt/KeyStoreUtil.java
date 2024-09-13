package com.portabull.security.jwt;

import com.portabull.exception.HRMSException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.FileInputStream;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.security.PublicKey;

@Component
public class KeyStoreUtil {


    private final String alias;
    private final String password;
    private final PrivateKey privateKey;
    private final PublicKey publicKey;

    public KeyStoreUtil(@Value("${jwt.portabull.keystore.alias}") String alias,
                        @Value("${jwt.portabull.keystore.password}") String password,
                        @Value("${jwt.portabull.keystore.file}") String fileLocation) {
        try (InputStream is = new FileInputStream(fileLocation)) {
            this.alias = alias;
            this.password = password;
            KeyStore keyStore = KeyStore.getInstance("PKCS12");
            keyStore.load(is, this.password.toCharArray());
            this.privateKey = (PrivateKey) keyStore.getKey(this.alias, this.password.toCharArray());
            this.publicKey = keyStore.getCertificate(this.alias).getPublicKey();
        } catch (Exception e) {
            throw new HRMSException("KeyStore Loading Failed...", e);
        }
    }

    public PrivateKey getPrivateKey() {
        return privateKey;
    }

    public PublicKey getPublicKey() {
        return this.publicKey;
    }
}
