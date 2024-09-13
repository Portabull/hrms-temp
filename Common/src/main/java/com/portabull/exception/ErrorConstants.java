package com.portabull.exception;

public class ErrorConstants {

    //200-HTTP STATUS CODE
    public static final String GDP200000_MESSAGE = "OK";
    public static final String GDP200000_DETAILS = "GDP200000: The request was successful and the response body contains the representation requested.";

    //201-HTTP STATUS CODE
    public static final String GDP201000_MESSAGE = "Created";
    public static final String GDP201000_DETAILS = "GDP201000: The request has been fulfilled and resulted in a new resource being created.";

    //204-HTTP STATUS CODE
    public static final String GDP204000_MESSAGE = "No Content";
    public static final String GDP204000_DETAILS = "GDP204000: The server successfully processed the request and is not returning any content";

    //400-HTTP STATUS CODE
    public static final String GDP400000_MESSAGE = "Bad Request";
    public static final String GDP400000_DETAILS = "GDP400000: The request was invalid or cannot be otherwise served.";

    //401-HTTP STATUS CODE
    public static final String GDP401000_MESSAGE = "Unauthorized";
    public static final String GDP401000_DETAILS = "GDP401000: The authentication credentials are missing, or if supplied are not valid or not sufficient to access the resource";
    public static final String GDP401001_DETAILS = "GDP401001 : Cannot perform login with disabled user";
    public static final String GDP401002_DETAILS = "GDP401002 : User not found";
    public static final String GDP401003_DETAILS = "GDP401003 : The Ldap authentication credentials are not valid or not sufficient to access the resource";
    public static final String GDP401004_DETAILS = "GDP401004 : Maximum limit reached for active logins";
    public static final String GDP401005_DETAILS = "GDP401005 : License details not available";
    public static final String GDP401006_DETAILS = "GDP401006 : Please login using SSO";
    public static final String GDP401007_DETAILS = "GDP401007 : The authentication credentials are not valid or not sufficient to access the resource";
    public static final String GDP401008_DETAILS = "GDP401008 : Session expired or another login detected for the same user. Please login again";
    public static final String GDP401009_DETAILS = "GDP401009 : Subscription is not valid. Please upgrade your subscription to avail this feature.";

    public static final String GDP401013_DETAILS = "GDP401013 : Failed to update user detail json";
    public static final String GDP401010_DETAILS = "GDP401010 : Missing mandatory attributes while creating sso user.";
    public static final String GDP401011_DETAILS = "GDP401011 : The REST API access privileges are disabled. Please check with the administrator.";

    public static final String GDP404011_DETAILS = "GDP404011 : User is not assigned any role. Please check with the administrator.";
    public static final String GDP404012_DETAILS = "GDP404012 : Role with name \"%s\", could not be mapped to a defined role in DataOps Suite. Please check with the administrator.";
    public static final String GDP404020_DETAILS = "GDP404020 : Role with id \"%s\", could not be mapped to a defined role in DataOps Suite. Please check with the administrator.";

    //SSO
    public static final String GDP400501_DETAILS = "GDP400501 : Invalid value for 'client_id' or 'service_principal_id' parameter.";
    public static final String GDP400502_DETAILS = "GDP400502 : Invalid value for 'client-secret' parameter.";

    public static final String GDP400503_DETAILS = "GDP400503 : Invalid value for 'client_id' parameter.";
    public static final String GDP400504_DETAILS = "GDP400504 : Invalid value for 'client_secret' or 'api_token' parameter.";
    public static final String GDP400505_DETAILS = "GDP400505 : Unable to test SSO Server configuration Details";


    //403-HTTP STATUS CODE
    public static final String GDP403000_MESSAGE = "Forbidden";
    public static final String GDP403000_DETAILS = "GDP403000: Indicates that the request is valid and the client is authenticated, but the client is not allowed access the page or resource for any reason. " +
            "E.g sometimes the authorized client is not allowed to access the directory on the server.";
    public static final String GDP403001_DETAILS = "GDP403001 : You don't have required privilege to access this feature."
            + " Please contact your administrator.";
    public static final String GDP403002_DETAILS = "GDP403002 : The request encountered issues due to null values or invalid arguments";

    //404-HTTP STATUS CODE
    public static final String GDP404000_MESSAGE = "Not Found";
    public static final String GDP404000_DETAILS = "GDP404000: The URI requested is invalid or the resource requested does not exist.";

    public static final String GDP404030_DETAILS = "GDP404030: Unable to connect datasource with given Details";
    public static final String GDP404031_DETAILS = "GDP404031: The connection not found.";

    //405-HTTP STATUS CODE
    public static final String GDP405000_MESSAGE = "Method not allowed";
    public static final String GDP405000_DETAILS = "GDP405000: The method specified in the request is not allowed for the resource identified by the request URI.";

    //406-HTTP STATUS CODE
    public static final String GDP406000_MESSAGE = "Not Acceptable";
    public static final String GDP406000_DETAILS = "GDP406000: The request specified an invalid format.";

    //409-HTTP STATUS CODE
    public static final String GDP409000_MESSAGE = "Conflict";
    public static final String GDP409000_DETAILS = "GDP409000: Resource already exists.";

    //410-HTTP STATUS CODE
    public static final String GDP410000_MESSAGE = "Gone";
    public static final String GDP410000_DETAILS = "GDP410000: Indicates that the requested resource is no longer available which has been intentionally moved.";

    //500-HTTP STATUS CODE
    public static final String GDP500000_MESSAGE = "Internal Server Error";
    public static final String GDP500000_DETAILS = "GDP500000: Indicates that the request is valid, but the server is totally confused and the server is asked to serve some unexpected condition.";
    public static final String GDP500010_DETAILS = "No more active licenses available. Please contact the administrator.";
    public static final String GDP500020_MESSAGE = "Unable to delete metdata";
    public static final String GDP500030_MESSAGE = "Unable to get metdata";
    public static final String GDP500040_MESSAGE = "No Pipeline Found";
    public static final String GDP500121_DETAILS = "GDP500121: Unable to retrieve livy Details";
    public static final String GDP500122_MESSAGE = "You're out of license.";
    public static final String GDP500123_MESSAGE = "Error Occurred while updating cookie";

    //502-HTTP STATUS CODE
    public static final String GDP502000_MESSAGE = "Bad Gateway";
    public static final String GDP502000_DETAILS = "GDP502000: Because the problem is with a different server.";

    //503-HTTP STATUS CODE
    public static final String GDP503000_MESSAGE = "Service Unavailable";
    public static final String GDP503000_DETAILS = "GDP503000: Indicates that the server is down or unavailable to receive and process the request. Mostly if the server is undergoing maintenance.";

    public static final String GDP504000_MESSAGE = "UnknownHost";

    public static final String GDP500011_DETAILS = "GDP500011: Invalid License File";

    public static final String GDP500012_DETAILS = "GDP500012: Authentication failed for LDAP server";

    public static final String GDP500013_DETAILS = "GDP500013: Unable to connect the email server with given Details";

    public static final String GDP500407_MESSAGE = "Invalid Server URL/Port";

    public static final String GDP500408_MESSAGE = "Invalid Server Username/Password";

    public static final String GDP500016_DETAILS = "GDP500016: License doesn't exist";

    public static final String GDP500017_DETAILS = "GDP500017: Unable to process report Service.";


    /***************************************************  Common Error Codes *******************************************/
    //Repository
    public static final String GDP404002_MESSAGE = "No properties found.";
    public static final String GDP4040021_DETAILS = "GDP4040021: Properties file not found.";
    public static final String GDP4040022_DETAILS = "GDP4040022: JDBC url not found.";
    public static final String GDP4040023_DETAILS = "GDP4040023: Username not found.";
    public static final String GDP4040024_DETAILS = "GDP4040024: Password not found.";
    public static final String GDP4040025_DETAILS = "GDP4040025: JDBC driver not found.";
    public static final String GDP4040026_DETAILS = "GDP4040026: DataSource type not found.";

    public static final String GDP400006_MESSAGE = "Invalid Properties.";
    public static final String GDP4000061_DETAILS = "GDP4000061: JDBC url should not be null or empty.";
    public static final String GDP4000062_DETAILS = "GDP4000062: Username should not be null or empty.";
    public static final String GDP4000063_DETAILS = "GDP4000063: Password should not be null or empty.";
    public static final String GDP4000064_DETAILS = "GDP4000064: JDBC driver should not be null or empty.";
    public static final String GDP4000065_DETAILS = "GDP4000065: DataSource type should not be null or empty.";

    public static final String GDP400005_MESSAGE = "Invalid repository";
    public static final String GDP400005_DETAILS = "GDP400005: Repository unavailable";


    public static final String GDP400001_MESSAGE = "Invalid request";
    public static final String GDP4000010_DETAILS = "GDP4000010: Required request body is missing.";

    public static final String GDP400007_MESSAGE = "Unable to proccess delete";
    public static final String GDP4000070_DETAILS = "GDP4000070:There are dependencies to delete this datasystem";

    public static final String GDP400008_MESSAGE = "Invalid Expression";
    public static final String GDP4000080_DETAILS = "GDP4000080: Please verify the expression";
    public static final String GDP4000081_DETAILS = "GDP4000081: SQLQuery/SqlExpression should return only one Row";
    public static final String GDP4000082_DETAILS = "GDP4000082: SQLQuery/SqlExpression should return only one Column";
    public static final String GDP4000083_DETAILS = "GDP4000083: Source dataset not found in current session.Please run the source component to validate the expression.";
    public static final String GDP4000084_DETAILS = "GDP4000084: Source dataset not found in current session.Please run the source component to download the dataset.";


    public static final String GDP400091_MESSAGE = "Invalid request.";
    public static final String GDP4000910_DETAILS = "GDP400091: Please provide all required fields.";
    public static final String GDP4000911_DETAILS = "GDP4000911: No Rule Found with give RuleId.";
    public static final String GDP400092_MESSAGE = "No values found for selected domain.";
    public static final String GDP4000912_DETAILS = "GDP4000912: Add values to domain.";
    public static final String GDP4000913_DETAILS = "GDP4000913: Unable to find component to delete.";
    public static final String GDP4000914_DETAILS = "GDP4000914: Table name should not be empty.";
    public static final String GDP4000915_DETAILS = "GDP4000915: Unable to find workschema details.";
    public static final String GDP4000916_DETAILS = "GDP4000915:  Workschema is not available to export the bad records in delta rule.";

    //common generic codes

    //405-HTTP STATUS CODE
    public static final String GDP4050100_DETAILS = "GDP4050100: Method is not supported for this request.";

    //415-HTTP STATUS CODE
    public static final String GDP4150100_DETAILS = "GDP4150100: Media type is not supported.";

    //conatiner
//400-HTTP STATUS CODE
    public static final String GDP400003_MESSAGE = "Invalid container id: ";
    public static final String GDP4000030_DETAILS = "GDP4000030: Container id must not be negative or zero.";
    public static final String GDP4000031_DETAILS = "GDP4000031: Container id must not be negative.";
    public static final String GDP4000032_DETAILS = "Access denied. You don't have permission to access this container";

    public static final String GDP400009_MESSAGE = "Unable to save/update role ";
    public static final String GDP4000090_DETAILS = "GDP4000090: Roles must not be empty or null.";
    public static final String GDP4000091_DETAILS = "GDP4000091: Role id should not be 0.";
    public static final String GDP4000092_DETAILS = "GDP4000092: Invalid roles: ";
    public static final String GDP4000093_DETAILS = "GDP4000093: Role Name should not be empty or null.";

    public static final String GDP4060094_DETAILS = "GDP4060094: Not acceptable to delete role, User(s) is configured to given role.";
    public static final String GDP4090095_DETAILS = "GDP4090095: Role name already exists.";


    public static final String GDP404009_MESSAGE = "Unable to delete role.";

    public static final String GDP400004_MESSAGE = "Unable to save/update container ";
    public static final String GDP4000040_DETAILS = "GDP4000040: Containers must not be empty or null.";
    public static final String GDP4000041_DETAILS = "GDP4000041: Container id should be 0.";
    public static final String GDP4000042_DETAILS = "GDP4000042: Invalid containers: ";

    public static final String GDP400043_DETAILS = "GDP400043: Unable to copy datasources, please check log for more details";
    public static final String GDP400044_DETAILS = "GDP400044: Container ID must be a positive integer.";

    //404-HTTP STATUS CODE
    public static final String GDP4040001_DETAILS = "GDP4040001: URL doesn't correspond to an existing API";

    public static final String GDP404003_MESSAGE = "No containers found.";
    public static final String GDP4040030_DETAILS = "GDP4040030: No containers were found for given container id.";
    public static final String GDP4040031_DETAILS = "GDP4040031: Configure Dataset Download location datasource for the container to download dataset.";


    public static final String GDP404004_MESSAGE = "Unable to delete container";
    //409-HTTP STATUS CODE
    public static final String GDP4090040_DETAILS = "GDP4090040: Container name already exist in the repository.";

    //user
    //400-HTTP STATUS CODE
    public static final String GDP400010_MESSAGE = "Invalid user id: ";
    public static final String GDP4000100_DETAILS = "GDP4000100: User id must not be negative or zero.";

    public static final String GDP400011_MESSAGE = "Unable to save/update user. ";
    public static final String GDP4000110_DETAILS = "GDP4000110: First name must not be empty or null.";
    public static final String GDP4000111_DETAILS = "GDP4000111: User name must not be empty or null.";
    public static final String GDP4000112_DETAILS = "GDP4000112: Password must not be empty or null.";
    public static final String GDP4000113_DETAILS = "GDP4000113: Containers must not be empty or null.";
    public static final String GDP4000114_DETAILS = "GDP4000114: Products must not be empty or null.";
    public static final String GDP4000115_DETAILS = "GDP4000115: Invalid products.";
    public static final String GDP4000116_DETAILS = "GDP4000116: Not allow to add more users for given product/products :";
    public static final String GDP4000117_DETAILS = "GDP4000117: No available licenses for ";

    // User - KeyTab related error codes
    public static final String GDP400012_MESSAGE = "Unable to save/update user keytab ";
    public static final String GDP4000121_DETAILS = "GDP4000121: User name must not be empty or null.";
    public static final String GDP4000122_DETAILS = "GDP4000122: Keytab location must not be empty or null";
    public static final String GDP4000123_DETAILS = "GDP4000123: User principal must not be empty or null";

    public static final String GDP400071_MESSAGE = "Malformed JSON request";
    //404-HTTP STATUS CODE
    public static final String GDP404010_MESSAGE = "No Users found.";
    public static final String GDP4040100_DETAILS = "GDP4040100: No users were found for given user id.";
    public static final String GDP4040101_DETAILS = "GDP4040101: Unable to update user.";
    public static final String GDP2040102_DETAILS = "GDP2040102: No deleted Users found.";

    public static final String GDP4040102_DETAILS = "GDP4040102: No version information is found.";

    public static final String GDP404011_MESSAGE = "Unable to delete user.";
    public static final String GDP500014_MESSAGE = "Unable to delete Container";
    public static final String GDP400014_DETAILS = "GDP400014: Container is assigned to users.";
    public static final String GDP400015_DETAILS = "GDP400015: Container is mapped with git branch. ";


    public static final String GDP404012_MESSAGE = "No type found for user activities";
    public static final String GDP404013_DETAILS = "GDP404013_MESSAGE: Please provide the type";

    public static final String GDP404014_DETAILS = "GDP404014 : Unable to sync users for provider \"%s\" .";
    public static final String GDP404015_DETAILS = "GDP404015 : User sync option is not enabled , please enable at security configuration.";
    public static final String GDP404016_DETAILS = "GDP404016 : Unable to sync users.";
    public static final String GDP404017_DETAILS = "GDP404017 : Invalid provider type \"%s\" for sync users.";
    public static final String GDP404018_DETAILS = "GDP404018 : Invalid inputs to get the provider.";
    public static final String GDP404019_DETAILS = "GDP404019 : Invalid inputs to connect SSO application.";


    //409-HTTP STATUS CODE
    public static final String GDP4090100_DETAILS = "GDP4090100: User name already exist in the repository.";
    public static final String GDP400061_MESSAGE = "Unable to update the users containers.";
    public static final String GDP4000610_DETAILS = "GDP4000610: Invalid request, No users, containers were found for given containerId or containers";

    //404
    public static final String GDP404051_MESSAGE = "Unable to get users, containers and products";
    public static final String GDP4040510_DETAILS = "GDP4040510: Users, containers and products information not available in database";

    //file datasource
    public static final String GDP4040000_MESSAGE = "File not found ";
    public static final String GDP40400001_DETAILS = "GDP4040001: There is no file available in the directory.";

    //500-HTTP STATUS CODE
    public static final int DB_STATUS = 500;

    //public static final String GDP500003_MESSAGE = "Unable to get the license information";
    public static final String GDP5000029_MESSAGE = "Insufficient authorities";
    public static final String GDP5000030_DETAILS = "GDP5000030: Update a new license to get license details";
    public static final String GDP5005060_DETAILS = "GDP5005060 : Problem while parsing JSON";
    public static final String GDP5005061_DETAILS = "GDP5005061 : License expired, please register with new license.";

    // RuleTypes
    public static final String GDP5005062_DETAILS = "GDP5005062 : Unable to save/update Rules";
    public static final String GDP5005063_DETAILS = "GDP5005063 : Unable to Delete Rules";
    public static final String GDP5005064_DETAILS = "GDP5005064 : Unable to retrieve Rules";

    // Server Config
    public static final String GDP5005065_DETAILS = "GDP5005065 : Unable to save/update server configuration";
    public static final String GDP5005066_DETAILS = "GDP5005066 : Unable to Delete server configuration";
    public static final String GDP5005067_DETAILS = "GDP5005067 : Unable to retrieve server configuration";
    public static final String GDP5004068_DETAILS = "GDP5004068 : Server type already exist";
    //Access Management
    public static final String GDP5005068_DETAILS = "GDP5005068 : Not enough  users are subscribed in new license. Please upgrade the license or delete few existing  users from DataOps Suite.";
    public static final String GDP5005069_DETAILS = "GDP5005069 : Not enough read only users are subscribed in new license. Please upgrade the license or delete few existing read only users from DataOps Suite.";

    //400
    public static final String GDP400041_MESSAGE = "Unable to get users.";
    public static final String GDP4000410_DETAILS = "GDP4000210: Invalid value for query parameter, isDeleted should be 1.";
    public static final String GDP4000411_DETAILS = "GDP4000211: IsDeleted must not be negative.";
    public static final String GDP4000412_DETAILS = "GDP4000212: Invalid value for path param.";

    public static final String GDP400051_MESSAGE = "Unable to restore the user/users.";
    public static final String GDP4000510_DETAILS = "GDP4000510: Invalid value for path parameter, isDeleted should be 0.";

    //dataSource
//400-HTTP STATUS CODE
    public static final String GDP400020_MESSAGE = "Invalid dataSource id: ";
    public static final String GDP40020_MESSAGE = "Unable to get snowflake private key : ";
    public static final String GDP4000200_DETAILS = "GDP4000200: DataSource id must not be negative or zero.";
    public static final String GDP4000201_DETAILS = "GDP4000201: Fetchsize must not be negative or zero.";
    public static final String GDP4000202_DETAILS = "GDP4000202: Unable to delete dataSource, as dataSource using in the environment configuration";

    public static final String GDP400021_MESSAGE = "Unable to save/ update Data Source. ";
    public static final String GDP4000210_DETAILS = "GDP4000210: DataSource name must not be empty or null.";
    public static final String GDP4000211_DETAILS = "GDP4000211: DataSource Model must not be null.";
    public static final String GDP4000212_DETAILS = "GDP4000212: Atleast set saveDatasource/testDatasource to true.";
    public static final String GDP4000213_DETAILS = "GDP4000213: Schema name must not be empty or null.";
    public static final String GDP4000214_DETAILS = "GDP4000214: User name must not be empty or null.";
    public static final String GDP4000215_DETAILS = "GDP4000215: Password must not be empty or null.";
    public static final String GDP4000216_DETAILS = "GDP4000216: Jdbc URL must not be empty or null.";
    public static final String GDP4000217_DETAILS = "GDP4000217: DataSource Type must not be empty or null.";
    public static final String GDP4000218_DETAILS = "GDP4000218: Please add read options to continue.";
    public static final String GDP4000219_DETAILS = "GDP4000219: Driver should not be null or empty.";
    public static final String GDP400220_DETAILS = "GDP400220: Snowflake private key file should not be null or empty.";
    public static final String GDP400221_DETAILS = "GDP400221: Pat token must not be empty or null.";
    public static final String GDP400222_DETAILS = "GDP400222: Unable to get user keys.";
    public static final String GDP400223_DETAILS = "GDP400223: Key name already exists.";
    public static final String GDP400224_DETAILS = "GDP400224: Unable to create user key.";
    public static final String GDP400225_DETAILS = "GDP400225: Unable to delete user key.";
    public static final String GDP400226_DETAILS = "GDP400226: Unable to get user profile keys.";
    public static final String GDP400227_DETAILS = "GDP400227: Key name is not available.";
    public static final String GDP400228_DETAILS = "GDP400228: Key already exists for the user.";
    public static final String GDP400229_DETAILS = "GDP400229: Unable to upload user profile key.";
    public static final String GDP400230_DETAILS = "GDP400230: Unable to delete user profile key.";
    public static final String GDP400231_DETAILS = "GDP400231: Unable to update %s.";

    public static final String GDP4000220_DETAILS = "GDP4000220: Path should not be null or empty.";
    public static final String GDP4000221_DETAILS = "GDP4000221: Read options should not be null or empty.";
    public static final String GDP4000222_DETAILS = "GDP4000222: Write options should not be null or empty.";

    public static final String GDP400022_MESSAGE = "Invalid dataSource model: ";

    public static final String GDP400320_DETAILS = "GDP400320: SecretId must not be empty or null";
    public static final String GDP400321_DETAILS = "GDP400321: SecretKey must not be empty or null";
    public static final String GDP400322_DETAILS = "GDP400322: ClientId must not be empty or null";

    // CouchDB related..
    public static final String GDP4000223_DETAILS = "GDP4000223: Protocol type should not be null or empty.";
    public static final String GDP4000224_DETAILS = "GDP4000224: Host should not be null or empty.";
    public static final String GDP4000225_DETAILS = "GDP4000225: Port should not be null or empty.";
    public static final String GDP4000226_DETAILS = "GDP4000226: Database name should not be null or empty.";
    public static final String GDP4000227_DETAILS = "GDP4000227: Project Id must not be empty or null.";
    public static final String GDP4000228_DETAILS = "GDP4000228: Dataset Id must not be empty or null.";
    public static final String GDP4000229_DETAILS = "GDP4000229: Credentials file path must not be empty or null.";
    public static final String GDP4000230_DETAILS = "GDP4000230: Credentials file path or Project id must not be empty or null.";
    public static final String GDP4000231_DETAILS = "GDP4000231: Application Id should not be null or empty.";
    public static final String GDP4000232_DETAILS = "GDP4000232: Application Secret should not be null or empty.";
    public static final String GDP4000233_DETAILS = "GDP4000233: Tenant Id should not be null or empty.";
    public static final String GDP4000234_DETAILS = "GDP4000234: Data Center must not be empty or null.";


    //404-HTTP STATUS CODE
    public static final String GDP404020_MESSAGE = "No dataSources found.";
    public static final String GDP4040200_DETAILS = "GDP4040200: No dataSources were found for given container id.";
    public static final String GDP4040201_DETAILS = "GDP4040201: No dataSource or workschema found for given dataSource name.";
    public static final String GDP4040202_DETAILS = "GDP4040202: Data Source should not be empty or null for Component %s.";
    public static final String GDP4040203_DETAILS = "GDP4040203: No dataSource found for given dataSource Name %s.";

    public static final String GDP404204_DETAILS = "GDP404204: Data Source should not be empty or null for Component.";

    public static final String GDP404021_MESSAGE = "Unable to delete dataSource.";

    public static final String GDP404022_MESSAGE = "No schemas found.";
    public static final String GDP4040220_DETAILS = "GDP4040220: No schemas were found for given details.";
    //409-HTTP STATUS CODE
    public static final String GDP4090200_DETAILS = "GDP4090200: Data Source name already exists in the repository.";

    // added datasources in repository
    public static final String GDP404023_MESSAGE = "No datasource types found.";
    public static final String GDP4040230_DETAILS = "GDP4040230: No datasource types were found.";

    //get Schemas
    public static final String GDP404024_MESSAGE = "Unable to Retrieve Schemas";

    //dataSystem
//400-HTTP STATUS CODE
    public static final String GDP400030_MESSAGE = "Invalid dataSystem id: ";
    public static final String GDP4000300_DETAILS = "GDP4000300: DataSystem id must not be negative or zero.";

    public static final String GDP400031_MESSAGE = "Unable to save/update dataSystem. ";
    public static final String GDP4000310_DETAILS = "GDP4000310: DatasystemModel must not be null.";

    public static final String GDP4000315_DETAILS = "GDP4000315: The requested execute query is null or empty.";
    //404-HTTP STATUS CODE
    public static final String GDP404030_MESSAGE = "No datasystems found.";
    public static final String GDP4040300_DETAILS = "GDP4040300: No datasystems were found for given container id.";
    public static final String GDP4040301_DETAILS = "GDP4040301: No datasystems were found for given datasystem id.";

    public static final String GDP404031_MESSAGE = "Unable to delete datasystems.";
    //409-HTTP STATUS CODE
    public static final String GDP4090300_DETAILS = "GDP4090300: Datasystem name already exist in the repository.";

    //500
    public static final String GDP5000300_DETAILS = "GDP5000300: The Network Adapter could not establish the connection.";

    //Execute Query
    //400
    public static final String GDP400130_MESSAGE = "Unable to save/update SavedQuery.";
    public static final String GDP4001300_DETAILS = "GDP4001300: SavedQuery must not be null.";

    public static final String GDP400131_MESSAGE = "Unable to execute query.";
    public static final String GDP400131_DETAILS = "GDP400131: Unable to execute query. Query is wrong or Table/Column doesn't exists or any other database issue.";
    public static final String GDP4001311_DETAILS = "GDP4001311: Unable to execute query due to : ";
    public static final String GDP4001310_DETAILS = "GDP4001310: Query must not be null or empty.";
    public static final String GDP400142_MESSAGE = "Query is wrong, it should return a number.";
    public static final String GDP400132_MESSAGE = "Invalid savedQueryID.";
    public static final String GDP4001320_DETAILS = "GDP4001320: savedQueryID must be greater than 0.";
    public static final String GDP400143_MESSAGE = "query returns more than one row";
    //404
    public static final String GDP404130_MESSAGE = "No savedQuery found.";
    public static final String GDP4041300_DETAILS = "GDP4041300: No savedQuery list found.";
    public static final String GDP4041301_DETAILS = "GDP4041301: No savedQuery found.";

    public static final String GDP404131_MESSAGE = "No Data found.";
    public static final String GDP4041310_DETAILS = "GDP4041310: No Data found for the given query.";

    public static final String GDP404132_MESSAGE = "Unable to delete saved query.";
    public static final String GDP4041320_DETAILS = "GDP4041320: No saved queries found for the given savedQueryID.";
    public static final String GDP4041321_DETAILS = "GDP4041321: Unable to get all savedQueries list";


    //409
    public static final String GDP4091300_DETAILS = "GDP4091300: Saved query name already exist in the repository.";

    //SMTPSettings
    //400
    public static final String GDP400120_MESSAGE = "Unable to save/update SMTP settings. ";
    public static final String GDP4001200_DETAILS = "GDP4001200: SMTPDetails model must not be null.";

    //404
    public static final String GDP404120_MESSAGE = "No SMTP Details Model found. ";
    public static final String GDP4041200_DETAILS = "GDP4041200: No SMTP Details model were found.";

    //Metadata
    //400
    public static final String GDP400080_MESSAGE = "Invalid schemas: ";
    public static final String GDP4000800_DETAILS = "GDP4000800: Schemas must not be null or empty.";
    public static final String GDP400081_MESSAGE = "Invalid tables: ";
    public static final String GDP4000810_DETAILS = "GDP4000810: Tables must not be null or empty.";
    public static final String GDP400082_MESSAGE = "Unable to refresh metadata: ";
    public static final String GDP4000820_DETAILS = "GDP4000820: Unable to retrieve metadata. Error details are: ";
    public static final String GDP4000821_DETAILS = "GDP4000821: There is no metadata available to view. Please click on Retrieve Metadata.";


    //404
    public static final String GDP404080_MESSAGE = "No metadata found.";
    public static final String GDP4040800_DETAILS = "GDP4040800: No metadata found for given datasource id.";

    //500
    public static final String GDP500800_DETAILS = "GDP500800: No datasource found.";
    public static final String GDP40300_MESSAGE = "Failed to connect datasource";
    public static final String GDP40301_MESSAGE = "Repository doesn't have query for selected operation";

    public static final String GDP500801_DETAILS = "GDP500801: Unable to retrieve the metadata summary.";
    public static final String GDP500802_DETAILS = "GDP500802: Unable to retrieve the metadata differences.";
    // UserPreferences
    //400
    public static final String GDP400090_MESSAGE = "Unable to save/update user preferences.";
    public static final String GDP400090_DETAILS = "GDP400090: UserDetailsModel must not be null.";

    //404
    public static final String GDP404090_DETAILS = "GDP404090: No Data found.";

    //License
    //400
    public static final String GDP400100_MESSAGE = "Unable to register license.";
    public static final String GDP400100_DETAILS = "GDP400100: License information is must not be null or empty.";

    public static final String GDP400101_MESSAGE = "Invalid License Model.";
    public static final String GDP400101_DETAILS = "GDP400101: License Model must not be null or empty.";

    //404
    public static final String GDP404100_MESSAGE = "Unable to get license details";
    public static final String GDP404100_DETAILS = "GDP404100: No License Model found.";


    public static final String GDP404800_MESSAGE = "Unable to get the product details.";
    public static final String GDP404801_DETAILS = "GDP404801: Update a new license to get license details.";

    //500
    public static final String GDP500001_MESSAGE = "Unable to add user";
    public static final String GDP500015_DETAILS = "GDP500015: Unable to decrypt.";

    //Login
    //400
    public static final String GDP400110_MESSAGE = "Unable to login with given credentials.";
    public static final String GDP404110_DETAILS = "GDP404110: No userName and password found with given credentials.";
    public static final String GDP404111_DETAILS = "GDP404111: Connection not found or database not started.";
    public static final String GDP400302_DETAILS = "GDP400302: Table name should not be empty";
    public static final String GDP404112_DETAILS = "GDP404112: Invalid role for the user.";

    //Template
    public static final String GDP400201_MESSAGE = "Invalid template id: ";
    public static final String GDP4002010_DETAILS = "GDP4002010: Template id must not be negative or zero.";

    public static final String GDP400202_MESSAGE = "Unable to save template.";
    public static final String GDP4002020_DETAILS = "GDP4002020: Template name cannot be null or empty.";
    public static final String GDP4002021_DETAILS = "GDP4002021: Data Source is not selected to save Template.";

    public static final String GDP400203_MESSAGE = "Unable to delete template.";
    public static final String GDP400202_DETAILS = "GDP400202: Username or password should not be null or empty.";
    public static final String GDP400204_DETAILS = "GDP400204: Problem while processing templates for export.";


    //Template Group
    public static final String GDP400221_MESSAGE = "Invalid notification template group";
    public static final String GDP4002210_DETAILS = "GDP4002210: Unable to save or update notification template group.";
    public static final String GDP4002211_DETAILS = "GDP4002211: Unable to delete notification template group";
    public static final String GDP4002212_DETAILS = "GDP4002212: Unable to get notification template group";
    public static final String GDP4002213_DETAILS = "GDP4002211: Unable to delete notification preference";
    public static final String GDP4002214_DETAILS = "GDP4002214: Unable to save templates";

    //404-HTTP STATUS CODE
    public static final String GDP404201_MESSAGE = "No templates found.";
    public static final String GDP4042010_DETAILS = "GDP4042010: No templates were found for given template id.";
    public static final String GDP4042011_DETAILS = "GDP4042011: No templates were found for given container id.";
    public static final String GDP4042012_DETAILS = "GDP4042012: No datamodels were found for given datamodel id.";


    //409-HTTP STATUS CODE
    public static final String GDP4092010_DETAILS = "GDP4092010: Template name already exist in the Repository.";
    //dataSet
    public static final String GDP400211_MESSAGE = "Unable to save Dataset.";
    public static final String GDP400212_MESSAGE = "Unable to delete Dataset.";

    public static final String GDP400213_MESSAGE = "Invalid data set id.";
    public static final String GDP4002130_DETAILS = "GDP4002130: Dataset id must not be negative or zero.";
    public static final String GDP4002131_DETAILS = "GDP4002131: Data source options must not be null or empty.";
    public static final String GDP4040040_DETAILS = "GDP4040040: No data source found for given connection id.";


    public static final String GDP400214_MESSAGE = "Unable to Generate data for given data set.";
    public static final String GDP4002140_DETAILS = "GDP4002140: Generate id must not be negative.";

    public static final String GDP400215_MESSAGE = "Unable to retrieve generate history.";

    public static final String GDP400216_MESSAGE = "Unable to retrieve generate status.";
    public static final String GDP4002160_DETAILS = "GDP4002160: Generate id must not be negative or zero.";


    //400
    public static final String GDP4002170_DETAILS = "GDP4002170: Data set id must not be negative.";
    public static final String GDP500201_MESSAGE = "Unable to generate preview.";

    public static final String GDP400220_MESSAGE = "Invalid load id: ";
    public static final String GDP4002200_DETAILS = "GDP4002120: Load id must not be negative.";

    public static final String GDP204031_DETAILS = "GDP204031: The server successfully processed the request is not returning any content";


    public static final String GDP404211_MESSAGE = "No Datasets found.";
    public static final String GDP4042110_DETAILS = "GDP4042110: No Datasets were found for given dataset id.";
    public static final String GDP4042111_DETAILS = "GDP4042111: No Datasets were found for given container id.";
    public static final String GDP4042112_DETAILS = "GDP4042112: No Datasets were found for given dataflow id.";

    public static final String GDP404212_MESSAGE = "No generate history found.";
    public static final String GDP4042120_DETAILS = "GDP4042110: No generate history were found for given dataset id.";

    public static final String GDP404213_MESSAGE = "No generated tables found.";
    public static final String GDP4042130_DETAILS = "GDP4042130: No generated tables were found for given dataset id.";
    public static final String GDP4042131_DETAILS = "GDP4042131: No generated tables were found for given generated id.";

    public static final String GDP404214_MESSAGE = "No generation status  found ";
    public static final String GDP4042140_DETAILS = "GDP404214: No generation status were found for the given generation Id.";

    public static final String GDP404215_MESSAGE = "No load history found.";
    public static final String GDP4042150_DETAILS = "GDP4042110: No load history were found for given dataset id.";

    public static final String GDP404216_MESSAGE = "No load tables found";
    public static final String GDP4042160_DETAILS = "GDP4042160: No load tables found for given load id";

    public static final String GDP4092100_DETAILS = "GDP4092100: Data set name already exist in the Repository.";

    public static final String GDP5001000_MESSAGE = "GDP5001000: Could not establish connection to the target data source";
    public static final String GDP5001001_MESSAGE = "GDP5001001: Error while loading the target datasource.";

    //livy configuration exceptions
    public static final String GDP40050_MESSAGE = "Unable to save/update Livy Server. ";
    public static final String GDP400500_DETAILS = "GDP4000500: Livy Server Id must not be negative or greater then zero.";

    public static final String GDP40060_MESSAGE = "Unable to test Livy Server. ";
    public static final String GDP400600_DETAILS = "GDP4000600: Livy server not started or dead.";
    public static final String GDP400601_DETAILS = "GDP4000601: Required livy server details are invalid.";


    public static final String GDP40070_MESSAGE = "Unable to delete the Livy Server.";
    public static final String GDP400700_DETAILS = "GDP4000700: Livy Server id must not be negative or zero. ";
    public static final String GDP400701_DETAILS = "GDP4000701: Unable to delete cluster, as cluster using in the environment configuration in current container or other container";
    public static final String GDP400703_DETAILS = "GDP4000703: The selected Engine is configured in Session Pool. To delete, disable the Engine from the Session Pool.";

    public static final String GDP4090700_DETAILS = "GDP4090700: Livy Server name already exists in the repository.";
    public static final String GDP4040700_DETAILS = "GDP4040700: No livy server found for given livy server id.";

    public static final String GDP400702_MESSAGE = "Livy lite not found";
    public static final String GDP400702_DETAILS = "GDP400702: Livy lite url is not configured. ";

    public static final String GDP4040111_MESSAGE = "GDP4040111: Invalid livy url";

    //livy service Exceptions
    public static final String GDP4040700_MESSAGE = "Engine session is not available/server is down";
    public static final String GDP40407000_DETAILS = "GDP40407000: Unable to get or create the Livy sesssion";

    public static final String GDP40407001_MESSAGE = "Unable to get the status of livy session";
    public static final String GDP404070001_DETAILS = "GDP404070001: The  livy session id not exist/Session is dead, Please clicks on 'Run DataFlow' to run it.";
    public static final String GDP4040700001_DETAILS = "GDP404070001: The  livy session id must be possitive.";
    public static final String GDP4040700002_MESSAGE = "GDP4040700002: Unable to get the files from given location.";
    public static final String GDP500616_DETAILS = "GDP500616: The engine server is down or Session is dead";


    public static final String GDP40407002_MESSAGE = "Requested URI was not found";
    public static final String GDP404070002_DETAILS = "GDP404070002: Given Livy server details are invalid ";

    public static final String GDP40407003_MESSAGE = "Malformed URL Found ";
    public static final String GDP404070003_DETAILS = "GDP404070003: Required livy server details are invalid.";

    public static final String GDP40407004_MESSAGE = "the status of livy session is dead";
    public static final String GDP404070004_DETAILS = "GDP404070004: Please create a new session";


    //Email Template
    public static final String GDP404056_MESSAGE = "Unable to create email template";
    public static final String GDP4040521_DETAILS = "GDP4040521: Error occured while creating template for Data Quality Rule Completed.";
    public static final String GDP4040522_DETAILS = "GDP4040522: Error occured while creating template for Data Quality Rule Failed.";
    public static final String GDP4040523_DETAILS = "GDP4040523: Error occured while creating template for pipeline Started.";
    public static final String GDP4040524_DETAILS = "GDP4040524: Error occured while creating template for Pipeline Completed.";
    public static final String GDP4040525_DETAILS = "GDP4040525: Error occured while creating template for Pipeline Failed.";
    public static final String GDP4040526_DETAILS = "GDP4040526: Error occured while creating template for Pipeline Delayed.";
    public static final String GDP4040527_DETAILS = "GDP4040527: Error while preparing notification message.";
    public static final String GDP4040528_DETAILS = "GDP4040528: Email subject is empty.";
    public static final String GDP4040529_DETAILS = "GDP4040529: Email Body is empty.";
    public static final String GDP4040531_DETAILS = "GDP4040531: HTML message is empty or null.";


    // Email notification
    public static final String GDP404052_MESSAGE = "Unable to get email templates";
    public static final String GDP4040520_DETAILS = "GDP4040520: Email templates are not available in database";

    public static final String GDP404053_MESSAGE = "Unable to get server";
    public static final String GDP4040530_DETAILS = "GDP4040530: Server details are not available in database";

    public static final String GDP404054_MESSAGE = "Unable to get user emails";
    public static final String GDP4040540_DETAILS = "GDP4040540 : user emails are not available in database";

    public static final String GDP40307002_MESSAGE = "Requested URI was not fulfilled";
    public static final String GDP403070002_DETAILS = "GDP403070002: Given Livy server details are invalid ";

    public static final String GDP50007002_MESSAGE = "Not Found";
    public static final String GDP500070002_DETAILS = "GDP500070002: Required livy server details are invalid/ Livy server not started or down ";
    public static final String GDP500070003_DETAILS = "GDP500070003: Error occured while getting the livy sessions ";
    public static final String GDP500070004_DETAILS = "GDP500070004: Unable to clear memory in spark";

    public static final String GDP404055_MESSAGE = "Unable to execute component";
    public static final String GDP4040556_DETAILS = "GDP4040556: No LivyServer Found";

    public static final String GDP4040557_DETAILS = "GDP4040557: Unable to find the engine details to run a dataflow";
    public static final String GDP404558_DETAILS = "GDP404558: Unable to update engine while setting default engine";
    public static final String GDP404559_DETAILS = "GDP404559: Unable to update workschema while setting default workschema";
    public static final String GDP404560_DETAILS = "GDP404560: Mark another workschema as default before proceeding to delete this workschema";
    public static final String GDP404561_DETAILS = "GDP404561: Mark another engine as default before proceeding to delete this engine";
    public static final String GDP404562_DETAILS = "GDP404562: Error occured while getting the default %s";
    public static final String GDP404563_DETAILS = "GDP404563: Mark atleast one engine as default while importing the dataflow";
    public static final String GDP404564_DETAILS = "GDP404564: Mark atleast one workschema as default while importing the DB flow";
    public static final String GDP404565_DETAILS = "GDP404565: Error occured while getting the default clusters";
    public static final String GDP404566_DETAILS = "GDP404566: No tables found for provided report";

    public static final String INFO_MESSAGE = "INFO";
    public static final String ACCESS_DENIED_HEADER = "AccessDenied";

    //Error codes
    public static final int NO_CONTENT_ERROR_CODE = 204;
    public static final int INTERNAL_SERVER_CODE = 500;
    public static final int FORBIDDEN_CODE = 403;
    public static final int BADREQUEST_CODE = 404;
    public static final int UNAUTHORIZED_CODE = 401;
    public static final int SERVICE_UNAVAILABLE = 503;

    public static final int INTERNAL_SERVER_ERROR_CODE = 500;
    public static final int FORBIDDEN_ERROR_CODE = 403;
    public static final int BAD_REQUEST_ERROR_CODE = 400;
    public static final int NOT_FOUND_ERROR_CODE = 404;
    public static final int NOT_ACCEPTABLE_ERROR_CODE = 406;
    public static final int CONFLICT_ERROR_CODE = 409;

    public static final Integer INFORMATION_CODE = 999;

    public static final int SESSION_DEAD_CODE = 900;

    /***************************************************  Dataflow Error Codes *******************************************/
    public static final String GDP400301_DETAILS = "GDP400301: Invalid DataFlow Id: ";
    public static final String GDP400307_DETAILS = "GDP400307: DataFlow is deleted or not available";
    public static final String GDP400308_DETAILS = "GDP400308: DB Flow is deleted or not available";
    public static final String GDP400310_DETAILS = "GDP4003010: DataFlow Id must not be negative or zero.";
    public static final String GDP400315_DETAILS = "GDP400315: DataFlow is not active.";

    public static final String GDP400302_MESSAGE = "Unable to save/update DataFlow.";

    public static final String GDP400304_MESSAGE = "Users list is empty";
    public static final String GDP4003040_DETAILS = "GDP4003040: No Users to Show";

    public static final String GDP400309_MESSAGE = "Dataflow id list is empty";
    public static final String GDP400309_DETAILS = "Received Dataflow id list is must not be empty ";

    public static final String GDP4003020_DETAILS = "GDP4002020: DataFlow  name cannot be null or empty.";
    public static final String GDP4003021_DETAILS = "GDP4002021: DataFlow  definition cannot be null or empty.";
    public static final String GDP4003023_DETAILS = "GDP4002023: DataFlow  version must not be negative or zero.";
    public static final String GDP4003024_DETAILS = "GDP4002023: DataFlow  engine name cannot be null or empty.";

    public static final String GDP400303_MESSAGE = "Unable to delete DataFlow.";
    public static final String GDP40030300_DETAILS = "GDP40030300:Unable to delete DataFlow.";

    public static final String GDP400305_MESSAGE = "Unable to reRun DataFlow";
    public static final String GDP4003050_DETAILS = "GDP4003050: All components are already ran";

    public static final String GDP400306_DETAILS = "GDP400306 Component request body is manadatory";

    public static final String GDP404301_MESSAGE = "No DataFlows found.";
    public static final String GDP404302_MESSAGE = "No DataFlows or DB Flows found.";
    public static final String GDP4043010_DETAILS = "GDP4043010: No DataFlows or DB Flows were found for given DataFlow or DB Flow Id.";
    public static final String GDP4043011_DETAILS = "GDP4043011: No DataFlows were found for given container Id.";

    public static final String GDP4093010_DETAILS = "DataFlow name already exists in the given container.";

    public static final String GDP4093011_MESSAGE = "DataFlowRun Id not found.";
    public static final String GDP4093011_DETAILS = "GDP4093011: Unable to serve the request.";
    public static final String GDP4043012_DETAILS = "GDP4043012: No DataFlows were found for given DataFlow Id.";
    public static final String GDP4043013_DETAILS = "GDP4043013: No DataFlows were found for given DataFlow: %s.";
    public static final String GDP4043014_DETAILS = "GDP4043014: Unable to open the DataFlow or DB Flow, Please make sure to restore the DataFlow or DB Flow to proceed further.";

    public static final String GDP5005001_DETAILS = "GDP5005001 : Problem while saving dataFlow run details";
    public static final String GDP5005002_DETAILS = "GDP5005002 : Problem while updating dataFlow run details";
    public static final String GDP5005003_DETAILS = "GDP5005003 : Problem while updating statements";
    public static final String GDP5005004_DETAILS = "GDP5005004 : Problem while saving component";
    public static final String GDP5005005_DETAILS = "GDP5005005 : Problem while saving connections";
    public static final String GDP5005006_DETAILS = "GDP5005006 : Problem while saving statements";
    public static final String GDP5005007_DETAILS = "GDP5005007 : Problem while updating component";
    public static final String GDP500508_DETAILS = "GDP5005008 : Problem while saving session details";
    public static final String GDP5005009_DETAILS = "GDP5005009 : Problem while updating session details";
    public static final String GDP5005010_DETAILS = "GDP5005010 : Problem while retrieving dataFlow run details";
    public static final String GDP5005011_DETAILS = "GDP5005011 : Problem while saving dataFlow logs";
    public static final String GDP5005012_DETAILS = "GDP5005012 : Problem while retrieving component details";
    public static final String GDP5005013_DETAILS = "GDP5005013 : Problem while updating dataFlow details";
    public static final String GDP5005014_DETAILS = "GDP5005014 : Problem while retrieving dataFlow details";
    public static final String GDP5005015_DETAILS = "GDP5005015 : Problem while aborting dataFlow";
    public static final String GDP5005016_DETAILS = "GDP5005016 : Problem while saving custom rules";
    public static final String GDP5005017_DETAILS = "GDP5005017 : Problem while retrieving session details";
    public static final String GDP5005018_DETAILS = "GDP5005018 : Problem while retrieving statements";
    public static final String GDP5005019_DETAILS = "GDP5005019 : Problem while updating user activities";
    public static final String GDP5005020_DETAILS = "GDP5005020 : Problem while retrieving user activities";

    public static final String GDP5005021_DETAILS = "GDP5005021 : Sorry, problem while retrieving the dataSources";

    public static final String GDP5005022_DETAILS = "GDP5005022 : Sorry, problem while retrieving the users";

    public static final String GDP5005023_DETAILS = "GDP5005023 : Sorry, problem while retrieving the livy sources";
    public static final String GDP5005024_DETAILS = "GDP5005024 : Unable to connect with Data Source using the given details.";
    public static final String GDP5005025_DETAILS = "GDP5005025 : Datarule type is invalid.";
    public static final String GDP5005026_DETAILS = "GDP5005026 : Livy server options are invalid or can not be processed.";
    public static final String GDP5005027_DETAILS = "GDP5005027 : Problem while executing statment in respective livy session.";

    public static final String GDP5005028_DETAILS = "GDP5005028 : Problem while executing DB Scripts.";
    public static final String GDP5005029_DETAILS = "GDP5005028 : problem while updating component status";
    public static final String GDP5005030_DETAILS = "GDP5005030 : Problem while retrieving run history";

    public static final String GDP5005031_DETAILS = "GDP5005031 : Problem while retrieving checkpoint count";

    public static final String GDP5005032_MESSAE = "Problem while aborting Dataflow";

    public static final String GDP5005032_DETAILS = "GDP5005032 : Could not abort the Dataflow, please try again";
    public static final String GDP5005033_DETAILS = "GDP5005033 : The specific run is not available or deleted";

    public static final String GDP5005034_DETAILS = "GDP5005034 : Unable to process Dataflow";

    public static final String GDP5005035_DETAILS = "GDP5005035 : Unable to fetch deleted dataflows/DB Flows";

    public static final String GDP5005036_DETAILS = "GDP5005036 : Unable to delete dataflows/DBFlows permanently";

    public static final String GDP5005037_DETAILS = "GDP5005037 : Unable to restore dataflows/DBFlows ";

    public static final String GDP5005038_DETAILS = "GDP5005038 : Unable to delete columns assigned with rules";


    public static final String GDP5005039_DETAILS = "GDP5005039 : Unable to save local parameters ";

    public static final String GDP5005040_DETAILS = "GDP5005040 :Unable to save columns";

    public static final String GDP5005041_DETAILS = "GDP5005041 :Unable to save rules";

    public static final String GDP5005042_DETAILS = "GDP5005042 :Unable to retrieve rules";

    public static final String GDP505043_DETAILS = "GDP505043 : Failed generate queries for rules defined";

    public static final String GDP5005044_DETAILS = "GDP5005044 :Unable to update rules status";

    public static final String GDP5005045_DETAILS = "GDP5005045 :Problem while deleting dataflow component";

    public static final String GDP5005046_DETAILS = "GDP5005046 :Unable to delete workschema table,please delete manually";

    public static final String GDP5005047_DETAILS = "GDP5005047 :Unable to delete DB Flow component";

    public static final String GDP5005048_DETAILS = "GDP5005048 :Unable to download DataComapre report";

    public static final String GDP5005049_DETAILS = "GDP5005049 :Report details not found for the component";

    public static final String GDP5005050_DETAILS = "GDP5005050: Unable to retrieve additional information from dm table group";

    public static final String GDP5005051_DETAILS = "GDP5005051: Unable to retrieve bad data file location";

    public static final String GDP5005052_DETAILS = "GDP5005052: Unable to import or copy dataflow or DB Flow";

    public static final String GDP5005053_DETAILS = "GDP5005053: Unable to retrieve the dataSource Id";

    public static final String GDP5005054_DETAILS = "GDP5005054: Falied to retrieve the engine or datasource value";

    public static final String GDP5005055_DETAILS = "GDP5005055: Unable to find engine details with variable name";

    public static final String GDP5005056_DETAILS = "GDP5005056: Unable to retrieve the dataSource name";

    public static final String GDP5005057_DETAILS = "GDP5005057: Unable to retrieve the dataSource";

    public static final String GDP5005058_DETAILS = "GDP5005058: Unable to sync headers for api component";

    public static final String GDP5005059_DETAILS = "GDP5005059: Unable to get the default environment value";

    public static final String GDP500606_MESSAGE = "GDP500604 : Error occured while preparing zip file";
    public static final String GDP5006025_DETAILS = "GDP5006025 : Something went wrong while preparing zip file";

    public static final String GDP400311_DETAILS = "GDP400311: %s already exist in the active or deleted %s";

    public static final String GDP400312_DETAILS = "GDP400312: Unable to write the bad data into work schema";

    public static final String GDP400313_DETAILS = "GDP400313: No datasource/workschema found for the given name";

    public static final String GDP5005070_DETAILS = "GDP5005070: Problem while getting dataflow info";

    public static final String GDP5005071_DETAILS = "GDP5005071: Please select run type as all or recent";

    public static final String GDP505071_DETAILS = "GDP505071: No DataFlows or DB Flows were found for given DataFlow/DB Flow Name and Container Name.";

    /* ********************************************* Execute Component Error codes **********************************************/

    //   400 status codes

    public static final String GDP400500_MESSAGE = "Unable to execute Component";
    public static final String GDP4005000_DETAILS = "GDP4005000 : Dataflow Id cannot be null or empty";
    public static final String GDP4005001_DETAILS = "GDP4005000 : Component definition cannot be null or empty";
    public static final String GDP4005002_DETAILS = "GDP4005002 : Component type cannot be empty or null";
    public static final String GDP4005003_DETAILS = "GDP4005003 : ComponentName cannot be null or Empty";
    public static final String GDP4005004_DETAILS = "GDP4005004 : DataFlow definition cannot be empty or null";
    public static final String GDP4005005_DETAILS = "GDP4005005 : ComponentId  cannot be empty or null";
    public static final String GDP4005006_DETAILS = "GDP4005006 : ComponentName mismatch or Component doesn't exist";
    public static final String GDP4005007_DETAILS = "GDP4005007 : Invalid component type";
    public static final String GDP4005008_DETAILS = "GDP4005008 : Components cannot be null";
    public static final String GDP4005009_DETAILS = "GDP4005009 : ContainerID cannot be null or empty";
    public static final String GDP4005010_DETAILS = "GDP4005010 : No components are added in dataflow for execution";
    public static final String GDP4005012_DETAILS = "GDP4005012 : unable to arrange components order by dependencies";

    public static final String GDP400501_MESSAGE = "Unable to execute dataflow";
    public static final String GDP4005011_DETAILS = "GDP4005011 : No engine is assigned to dataflow";


    public static final String GDP400503_MESSAGE = " Unable to update livy session";
    public static final String GDP4005030_DETAILS = "GDP4005030 : DataFlow not found for the respective session";

    public static final String GDP400504_MESSAGE = " Unable to update component";
    public static final String GDP4005040_DETAILS = "GDP4045030 : DataFlow Run or session not found respective component";


    public static final String GDP400505_MESSAGE = "Unable to process the request";
    public static final String GDP4005050_DETAILS = "GDP4005050 : No runs found for this dataflow";

    public static final String GDP400506_MESSAGE = "No RunTime Files";
    public static final String GDP4005051_DETAILS = "GDP4005051 :Please select the Data source for Target : ";

    public static final String GDP4005052_DETAILS = "GDP4005052 : Invalid page size";
    public static final String GDP4005053_MESSAGE = "Unable to get parameter";
    public static final String GDP4005053_DETAILS = "GDP4005052 : Problem while get parameter map object";

    public static final String GDP4005054_DETAILS = "GDP4005054 :Please select the Data source logical name for : ";

    public static final String GDP4005055_DETAILS = "GDP4005055 : Input dataset name should not be empty";
    public static final String GDP4005056_DETAILS = "GDP4005056 : Batch size should not be empty or less than 1";


    // 404 status codes

    public static final String GDP404501_MESSAGE = "Unable to get livy session";
    public static final String GDP4045010_DETAILS = "GDP4045010 : livy session might be unavailable or livy server is down";

    public static final String GDP404502_MESSAGE = "Unable to create livy session";
    public static final String GDP4045020_DETAILS = "GDP4045010 : livy server might be unavailable or livy server is down";

    public static final String GDP404503_MESSAGE = "Livysession not found";
    public static final String GDP4045030_DETAILS = "GDP4045030: No entries were found for given session";


    public static final String GDP404504_MESSAGE = " Unable to update component";
    public static final String GDP4045040_DETAILS = "GDP4045030 : No entries found for the component";
    public static final String GDP4045041_DETAILS = "GDP4045041 : Definition not  found for the given DataFlow";


    public static final String GDP404505_MESSAGE = " Unable to update statement";
    public static final String GDP4045050_DETAILS = "GDP4045030 : statement not found";

    public static final String GDP404506_MESSAGE = "Unable to execute Component";
    public static final String GDP4045061_MESSAGE = "No sessions found for the given DataFlow Id";
    public static final String GDP4045060_MESSAGE = "No Connections found for the given conatainerID";


    public static final String GDP404507_MESSAGE = "Unable to execute Component";
    public static final String GDP4045071_DETAILS = "GDP4045071 : No engine found for the given DataFlow";


    public static final String GDP404508_MESSAGE = "Unable to execute Component";
    public static final String GDP4045080_DETAILS = "GDP4045080 : No DataFlows found for the given DataFlow Id";
    public static final String GDP4045081_DETAILS = "GDP4045081: UDF's table doesn't have records with the selected UDF's";
    public static final String GDP4045089_MESSAGE = "Query not found";
    public static final String GDP404082_DETAILS = "GDP404082: DataFlow or DB Flow is deleted or not available";
    public static final String GDP404510_MESSAGE = "Unable to set custom fields";


    public static final String GDP404509_MESSAGE = " No components found";
    public static final String GDP4045090_DETAILS = "GDP4045090: No Components were found for given Component Id.";


    public static final String GDP500603_MESSAGE = "GDP500603 : Error occured while password encryption/decryption";

    public static final String GDP500605_MESSAGE = "GDP500605 : Error occured while updating parameters";

    public static final String GDP500606_DETAILS = "GDP500606 : Work schema is not present";

    public static final String GDP500607_DETAILS = "GDP500607 : Invalid DataSource type";

    public static final String GDP500608_DETAILS = "GDP500608 : Unable to get DataSource information";

    public static final String GDP500609_DETAILS = "GDP500609 : Problem while getting dbscript result";

    public static final String GDP500610_DETAILS = "GDP500610 : Problem while getting count compare result";

    public static final String GDP500611_DETAILS = "GDP500611 : Problem while creating and inserting result";

    public static final String GDP500612_DETAILS = "GDP500612 : Unable to delete table from workschema";

    public static final String GDP500613_DETAILS = "GDP500613 : Unable to save metrics compare";

    public static final String GDP500614_DETAILS = "GDP500614 : Unable to save meta data compare";

    public static final String GDP500615_DETAILS = "GDP500615 : Problem while getting  meta data count compare result";

    public static final String GDP500617_DETAILS = "GDP500617 : Unable to add read options to api component statement";

    public static final String GDP500618_DETAILS = "GDP500618 : Unable to populate dataflow details";
    public static final String GDP500618_MESSAGE = "Error while populating dataflow details";
    public static final String GDP500619_MESSAGE = "GDP500619 : Failed while executing Query";


    /********************************************************** Livy Service Exceptions ************************************************************/

    public static final String GDP404600_MESSAGE = "Unable to process the request";
    public static final String GDP4046000_DETAILS = "GDP4046000 : Session is currently unavailable";

    public static final String GDP400600_MESSAGE = "Unable to process the request";
    public static final String GDP4006000_DETAILS = "GDP4006000 : The request is improper Please supply appropriate options";

    public static final String GDP500600_MESSAGE = "Unable to process the request";
    public static final String GDP5006000_DETAILS = "GDP5006000 : Server is currently unavailable.";
    public static final String GDP5006011_DETAILS = "GDP5006011 : Session is currently unavailable.";


    public static final String GDP500601_MESSAGE = "Unable to process the request";
    public static final String GDP5006010_DEATAILS = "GDP5006010 : Something got interrupted Please run once again";

    public static final String GDP500604_MESSAGE = "GDP500604 : Error occured while generating livy options";

    public static final String GDP500602_MESSAGE = "Unable to process the request";
    public static final String GDP5006020_DETAILS = "GDP5006020 : Something went wrong while generating PDF report ";
    public static final String GDP5006021_DETAILS = "GDP5006021: Unable to process spark UI";
    public static final String GDP500615_MESSAGE = "Databricks Token test failed";

    public static final String GDP5006022_DETAILS = "GDP5006022: Unable to load clusters. Token credential is invalid in the 'Profile -> User Wallet' or 'Configure -> Manage Clusters' setting for a secure authentication to Databricks API.";

    public static final String GDP5006023_DETAILS = "GDP5006023: The URL '{URL}' might be wrong or current system doesn't have access to azure databricks portal";

    public static final String GDP5006024_DETAILS = "GDP5006024: Unable to get livy servers,please check core service log for more details";

    public static final String GDP5006026_DETAILS = "GDP5006026: Unable to load clusters. Token credential is missing in the 'Profile -> User Wallet' or 'Configure -> Manage Clusters' setting for a secure authentication to Databricks API.";

    public static final String GDP5006027_DETAILS = "GDP5006027 :Please enter valid Token credential in Profile -> User Wallet' or 'Configure -> Manage Clusters";

    public static final String GDP5006028_DETAILS = "GDP5006028: Unable to save workSpace, Workspace with same URL already present";

    public static final String GDP5006030_DETAILS = "GDP5006030: Current token doesn't have privilege for this operation, please provide appropriate permissions";

    public static final String GDP5006031_DETAILS = "GDP5006031: Unable to save master url; the combination of master url & namespace is already present";

    public static final String GDP5006032_DETAILS = "GDP5006032: Unable to check for duplicate workspaces/masterURL configurations";

    public static final String GDP5006033_DETAILS = "GDP5006033: Token and workspace mismatch, provide valid token for the workspace mapped to the current user.";

    /********************************************************** Livy Service Exceptions ************************************************************/
    /********************************************************** EMR Cluster Service Exceptions ************************************************************/
    public static final String GDP5006050_MESSAGE = "Could not get Region from any provider";
    public static final String GDP50060501_DETAILS = "GDP50060501 : Stack name can include letters (A-Z and a-z), numbers (0-9), and dashes (-)";
    public static final String GDP50060502_DETAILS = "GDP50060502 : Stack name already exists";
    public static final String GDP50060503_DETAILS = "GDP50060503 : Invalid ACCESS KEY ID";
    public static final String GDP50060504_DETAILS = "GDP50060504 : Invalid SECRET ACCESS KEY";
    public static final String GDP50060505_DETAILS = "GDP50060505 : Stack name cannot exceed 128 characters";
    public static final String GDP50060506_DETAILS = "GDP50060506 : Either instance or user doesn't have permission to start emr cluster";
    public static final String GDP500821_DETAILS = "GDP500821: Problem while getting aws accesskey and secretekey from userprofile";
    public static final String GDP500822_DETAILS = "GDP500822: Problem while getting clusters";
    public static final String GDP500823_DETAILS = "GDP500823: Unable to retrieve the MasterIp";
    public static final String GDP500824_DETAILS = "GDP500824: Region should not be null or empty";
    public static final String GDP5007075_DETAILS = "GDP5007075: Unable to list the clusters";
    public static final String GDP5006051_DETAILS = "GDP5006051: Invalid EMR Token, AWS secret key in profile screen is invalid.";
    public static final String GDP5006052_DETAILS = "GDP5006052: Invalid EMR Token, AWS access token or both AWS secret key and AWS access token in profile screen is invalid.";

    /********************************************************** application configuration  ************************************************************/
    public static final String GDP400013_MESSAGE = "Unable to save/update app property";
    public static final String GDP4000131_DETAILS = "GDP4000131: Key must not be empty or null.";
    public static final String GDP4000132_DETAILS = "GDP4000132: Value must not be empty or null";
    public static final String GDP4000133_DETAILS = "GDP4000133: Category must not be empty or null";
    public static final String GDP400014_MESSAGE = "Unable to upload the selected file";
    public static final String GDP4000141_DETAILS = "GDP4000141: Please select a file to upload";
    public static final String GDP4000142_DETAILS = "GDP4000142:Unable to retrieve TDM temp file location ";


    /********************************************************** EMR Cluster Service Exceptions ************************************************************/


    /********************************************************** application configuration  ************************************************************/
    public static final String GDP500023_MESSAGE = "Unable to save/update Cluster";
    public static final String GDP500024_MESSAGE = "Unable to Delete Cluster";
    public static final String GDP500025_MESSAGE = "Unable to find Cluster";

    /*********************************************************** Email Notification Events***************************************************************/

    public static final String GDP500701_MESSAGE = "Unable to get notification events";
    public static final String GDP500801_MESSAGE = "Unable to get notification preferences";
    public static final String GDP500901_MESSAGE = "Unable to save/update notification preference";

    /*********************************************************** Email Template Exceptions ****************************************************************/
    public static final String GDP500902_MESSAGE = "Unable to get email templates";
    public static final String GDP500903_MESSAGE = "Unable to save/update email template";

    /*********************************************************** piper/cluster service Exceptions ****************************************************************/

    public static final String GDP5007001_DETAILS = "GDP5007001: Unable to retrieve pipelines";

    public static final String GDP5007002_DETAILS = "GDP5007002: Unable to retrieve latest runs";

    public static final String GDP5007003_DETAILS = "GDP5007003: Unable to retrieve details for the input pipeline";

    public static final String GDP5007004_DETAILS = "GDP5007004: Unable to save pipeline";

    public static final String GDP5007005_DETAILS = "GDP5007005: Unable to update pipeline";

    public static final String GDP5007006_DETAILS = "GDP5007006: Unable to delete pipeline";

    public static final String GDP5007007_DETAILS = "GDP5007007: Unable to retrieve jobs for the given pipeline";

    public static final String GDP5007008_DETAILS = "GDP5007008 : Unable to retrieve jobs";

    public static final String GDP5007009_DETAILS = "GDP5007009 : Unable to create the job";

    public static final String GDP5007010_DETAILS = "GDP5007010 : Unable to start the job";

    public static final String GDP5007011_DETAILS = "GDP5007011 : Unable to stop the job";

    public static final String GDP5007012_DETAILS = "GDP5007012 : Unable to resume the job";

    public static final String GDP5007013_DETAILS = "GDP5007013 : Unable to retrieve the cloudFormation template for the given id";

    public static final String GDP5007014_DETAILS = "GDP5007014 : Unable to save cloudFormation template";

    public static final String GDP5007015_DETAILS = "GDP5007015 : Unable to update cloudFormation template";

    public static final String GDP5007016_DETAILS = "GDP5007016 : Unable to delete cloudFormation template";

    public static final String GDP5007017_DETAILS = "GDP5007017 : Unable to retrieve cloudFormation templates";

    public static final String GDP5007018_DETAILS = "GDP5007018 : Unable to perform actions on cluster";

    public static final String GDP5007019_DETAILS = "GDP5007019 : Unable to retrieve clusters";

    public static final String GDP5007020_DETAILS = "GDP5007020 : Unable to save livy server";

    public static final String GDP5007027_DETAILS = "GDP5007027 : Unable to update livy server";

    public static final String GDP5007021_DETAILS = "GDP5007021 : Unable to save cluster";

    public static final String GDP5007022_DETAILS = "GDP5007022 : Unable to update cluster";

    public static final String GDP5007023_DETAILS = "GDP5007023 : Unable to delete cluster";

    public static final String GDP5007024_DETAILS = "GDP5007024 : Unable to delete livy server";

    public static final String GDP5007025_DETAILS = "GDP5007025 : Unable to run dataFlow in cluster/pipeline";

    public static final String GDP5007028_DETAILS = "GDP5007028 : Unable to create/start cluster";

    public static final String GDP5007029_DETAILS = "GDP5007029 : Unable to terminate cluster";

    public static final String GDP5007030_DETAILS = "GDP5007030 : Unable to create context in cluster";

    public static final String GDP5007031_DETAILS = "GDP5007031 : Unable to get context status in cluster";

    public static final String GDP5007032_DETAILS = "GDP5007032 : Unable to destroy context in cluster";

    public static final String GDP5007033_DETAILS = "GDP5007033 : Unable to execute command in cluster";

    public static final String GDP5007034_DETAILS = "GDP5007034 : Unable to retrieve command status from cluster";

    public static final String GDP5007035_DETAILS = "GDP5007035 : Unable to cancel command in cluster";

    public static final String GDP4007001_DETAILS = "GDP4007001 : Number of tasks in the request are invalid.";

    public static final String GDP4007002_DETAILS = "GDP4007002 : Task in the start is invalid.";

    public static final String GDP5007026_DETAILS = "GDP5007026 : Cannot load the credentials from the credential profiles file OR Environment variables Please make sure that your credentials file is at the correct location (~/.aws/credentials), and is in valid format OR Environment variables are set.";

    public static final String GDP4007003_DETAILS = "GDP4007003 : containerId is manadatory";

    public static final String GDP5007036_DETAILS = "GDP5007036 : Unable to retrieve user preferences";

    public static final String GDP5007037_DETAILS = "GDP5007037 : Unable to save user preferences";

    public static final String GDP5007038_DETAILS = "GDP5007038 : Unable to update user preferences";

    public static final String GDP5007039_DETAILS = "GDP5007039 : Unable to retrieve workspaces";

    public static final String GDP5007040_DETAILS = "GDP5007040 : Unable to save workspace";

    public static final String GDP5007041_DETAILS = "GDP5007041 : Unable to update workspace";

    public static final String GDP5007042_DETAILS = "GDP5007042 : Unable to delete workspace";

    public static final String GDP5007043_DETAILS = "GDP5007043 : No workspace mapped to the current user.";

    public static final String GDP5007044_DETAILS = "GDP5007044 : Unable to create/start cluster , Cluster got terminated";

    public static final String GDP5007045_DETAILS = "GDP5007045 : Error in Dataflow Execution. Please check the dataflow run history for more information";

    public static final String GDP5007046_DETAILS = "GDP5007046 : Unable to skip the task";

    public static final String GDP5007047_DETAILS = "GDP5007047 : Unable to save commonwallet";

    public static final String GDP5007048_DETAILS = "GDP5007048 : Unable to retrieve commonwallet";

    public static final String GDP5007049_DETAILS = "GDP5007049 : Unable to delete commonwallet";

    public static final String GDP4000403_DETAILS = "GDP4000403:The specific job is not available or deleted ";

    public static final String GDP507051_DETAILS = "GDP507051: Name already exists either in the active or deleted piplelines";

    public static final String GDP5007052_DETAILS = "GDP5007052: No Pipeline is found with given id";

    public static final String GDP5007053_DETAILS = "GDP5007053: Unable to execute Pipeline with invalid task type";

    public static final String GDP5007054_DETAILS = "GDP5007054: Error in TDM Dataset Execution. Please check the TDM Dataset run history for more information";

    public static final String GDP5007055_DETAILS = "GDP5007055: User doesn't have access to S3 bucket to read template";

    public static final String GDP5007056_DETAILS = "GDP5007056: Unable to retrieve job details by jobId";

    public static final String GDP5007057_DETAILS = "GDP5007057: Unable to get Databricks workspaces assigned to user";

    public static final String GDP5007058_DETAILS = "GDP5007058: No Pipeline found for given pipelineId and conatinerId ";

    public static final String GDP5007059_DETAILS = "GDP5007059: No workspaces are mapped to the Current user ";

    public static final String GDP5007060_DETAILS = "GDP5007060: No workspace found with given workspace Id ";

    public static final String GDP5007061_DETAILS = "GDP5007061: Mark atleast one engine as default while importing the pipeline";

    public static final String GDP5007062_MESSAGE = "Unable to import";

    public static final String GDP507063_DETAILS = "GDP507063: Unable to retrive pipeline recent runs";

    public static final String GDP507064_DETAILS = "GDP507064: Unable to find mapping Id";

    public static final String GDP507067_DETAILS = "GDP507067: Unable to test databricks token.";

    public static final String GDP507068_DETAILS = "GDP507068: More than one workspace mapped to the current user.";

    public static final String GDP507069_DETAILS = "GDP507069: Unable to retrieve monitor screen pipeline runs";

    public static final String GDP507070_DETAILS = "GDP507070: Livy server selected is invalid, can not be set as default.";

    public static final String GDP507071_DETAILS = "GDP507071: No pipelines were found for given pipeline name and container name.";

    /***********************************************************Kubernetes*****************************************************************/
    public static final String GDP508000_DETAILS = "GDP508000: Could not find template with id : ";

    public static final String GDP508001_DETAILS = "GDP508001: Could not find workspace with id : ";

    public static final String GDP508002_DETAILS = "GDP508002: Unable to start kubernetes cluster";

    public static final String GDP508003_DETAILS = "GDP508003: Unable to get image version";

    public static final String GDP508004_DETAILS = "GDP508004: CATALINA_HOME environment variable is not set";

    public static final String GDP508005_DETAILS = "GDP508005: Unable to get kubernetes token";

    public static final String GDP508006_DETAILS = "GDP508006: Unable to trust certificates and skip ssl verification";

    public static final String GDP508007_DETAILS = "GDP508007: Unable to save kubernetes engine details";

    public static final String GDP508008_DETAILS = "GDP508008: Unable to stop kubernetes cluster";

    public static final String GDP508009_DETAILS = "GDP508009: Please provide valid token to access Kubernetes";

    public static final String GDP508010_DETAILS = "GDP508010: App name {$APP_NAME} already exists, Please provide different app name";

    public static final String GDP508011_DETAILS = "GDP508011: Invalid action provided,It should be either start or stop";

    public static final String GDP508012_DETAILS = "GDP508012: Failed to {action} Kubernetes Cluster";

    public static final String GDP508013_DETAILS = "GDP508013: Unable to wait for pod and service to be running";

    public static final String GDP508014_DETAILS = "GDP508014: Unable to delete kubernetes livy";

    /*********************************************************** Scheduler ****************************************************************/

    public static final String GDP400900_DETAILS = "GDP400900: Job name must not be empty or null.";
    public static final String GDP500900_DETAILS = "GDP500900: Unable to save/ update Schedule job. ";
    public static final String GDP409900_DETAILS = "GDP409900: Job name already exists.";
    public static final String GDP204901_DETAILS = "GDP204901: Selected job is running.";
    public static final String GDP204902_DETAILS = "GDP204901: Selected job is not in paused state.";
    public static final String GDP204900_DETAILS = "GDP204900: Job name not found.";
    public static final String GDP500001_DETAILS = "GDP500001: Unable to decrypt password.";
    public static final String GDP500002_DETAILS = "GDP500002: Unable to fetch scheduler jobs.";
    public static final String GDP500003_DETAILS = "GDP500003: Unable to check the job name is present.";
    public static final String GDP500004_DETAILS = "GDP500004: Unable to schedule one time job.";
    public static final String GDP500005_DETAILS = "GDP500005: Unable to schedule recurring job.";
    public static final String GDP500006_DETAILS = "GDP500006: Unable to update job.";
    public static final String GDP500007_DETAILS = "GDP500007: Unable to unSchedule job.";
    public static final String GDP500008_DETAILS = "GDP500008: Unable to delete job.";
    public static final String GDP500009_DETAILS = "GDP500009: Unable to check the selected job is running.";
    public static final String GDP500021_DETAILS = "GDP500021: Unable to schedule custom job.";

    /*******************************************dataops-upgrade********************************************************/

    public static final String GDP500910_MESSAGE = "Repository update failure";
    public static final String GDP500910_DETAILS = "GDP500910: Error occured while retreiving the file path using class path";
    public static final String GDP500911_DETAILS = "GDP500911: DB-Upgrade Installation Directory not found";
    public static final String GDP500912_DETAILS = "GDP500912: Error occured while writing to the properties file";

    /***************************************** folders *****************************************************************/

    public static final String GDP4041000_DETAILS = "GDP4041000 : Folder doesn't exist";

    public static final String GDP4001119_DETAILS = "GDP4001105 : Folder Name already exists";

    public static final String GDP5001000_DETAILS = "GDP5001000 : Unable to retrieve folders";

    public static final String GDP5001001_DETAILS = "GDP5001001 : Unable to retrieve folder";

    public static final String GDP500103_MESSAGE = "Unable to save folder";

    public static final String GDP5001003_DETAILS = "GDP5001003 : Unable to update folder";

    public static final String GDP5001004_DETAILS = "GDP5001004 : Unable to delete folder";

    public static final String GDP500105_DETAILS = "GDP500105 : Could not find folder with id";

    public static final String GDP500106_DETAILS = "GDP500106 : Root folder cannot be deleted";

    public static final String GDP500107_DETAILS = "GDP500107 : Folder name should not contain special characters other than hyphen( - ) or underscore( _ ) or space( ) ";

    public static final String GDP500108_DETAILS = "GDP500108 : Folder name cannot be empty or null";

    public static final String GDP500150_DETAILS = "GDP500150 : Folder path cannot be empty or null in the request";

    /***************************************** validations *******************************************************/

    public static final String GDP4001100_DETAILS = "GDP4001100 : DataSourceName cannot be empty or null for component %s";

    public static final String GDP4001101_DETAILS = "GDP4001101 : DatasetName/(source/target datasets) cannot be empty for component %s";

    public static final String GDP4001102_DETAILS = "GDP4001102 : Code cannot be empty";

    public static final String GDP4001103_DETAILS = "GDP4001103 : SyncFolder cannot be empty";

    public static final String GDP4001104_DETAILS = "GDP4001104 : SubFolderName cannot be empty";

    public static final String GDP4001105_DETAILS = "GDP4001105 : SqlExpression cannot be empty";

    public static final String GDP400105_DETAILS = "GDP400105 : SqlQuery cannot be empty";

    public static final String GDP4001106_DETAILS = "GDP4001106 : FileName cannot be empty";

    public static final String GDP4001107_DETAILS = "GDP4001107 : Unique key is mandatory while applying threshold";

    public static final String GDP4001108_DETAILS = "GDP4001108 : FileName is invalid";

    public static final String GDP4001109_DETAILS = "GDP4001109 : Column details cannot be empty";

    public static final String GDP4001110_DETAILS = "GDP4001110 : Plugin Name/ Id cannot be empty";

    public static final String GDP4001111_DETAILS = "GDP4001111 : API component name cannot be empty";

    public static final String GDP4001112_DETAILS = "GDP4001112 : URL cannot be empty in API component";

    public static final String GDP4001113_DETAILS = "GDP4001113 : Unable to retrieve the plugin details";

    public static final String GDP4001114_DETAILS = "GDP4001114 : Metadatacompare component name cannot be empty";

    public static final String GDP4001115_DETAILS = "GDP4001115 : Source and Target schema cannot be empty in Metadatacompare component";

    public static final String GDP4001116_DETAILS = "GDP4001116 : Unable to retrieve component run deatils";

    public static final String GDP4001117_DETAILS = "GDP4001117: Dataset name should not contain only Digits";

    public static final String GDP4001118_DETAILS = "GDP4001118: Plugin data source name cannot be empty";

    /***************************************** CDM *******************************************************/
    public static final String GDP400015_MESSAGE = "Unable to save/update Subject Area";
    public static final String GDP4000151_DETAILS = "GDP4000151: Name must not be empty or null.";
    public static final String GDP4000152_DETAILS = "GDP4000152: SubjectAreaId cannot not be empty or null.";
    public static final String GDP4090150_DETAILS = "GDP4090150: Subject area name already exist.";
    public static final String GDP4040150_DETAILS = "GDP4040150: No subject areas found for given id.";
    public static final String GDP40015_MESSAGE = "Unable to delete the Subject area.";

    public static final String GDP400016_MESSAGE = "Unable to save/update Entity";
    public static final String GDP4000161_DETAILS = "GDP4000161: Name must not be empty or null.";
    public static final String GDP4000162_DETAILS = "GDP4000162: EntityId cannot not be empty or null.";
    public static final String GDP4090160_DETAILS = "GDP4090160: Entity name already exist.";
    public static final String GDP4040160_DETAILS = "GDP4040160: No subject areas found for given id.";
    public static final String GDP40016_MESSAGE = "Unable to delete Entity.";

    public static final String GDP400017_MESSAGE = "Unable to save/update Attribute";
    public static final String GDP4000171_DETAILS = "GDP4000171: Name must not be empty or null.";
    public static final String GDP4000172_DETAILS = "GDP4000172: AttributeId cannot not be empty or null.";
    public static final String GDP4090170_DETAILS = "GDP4090170: Attribute name already exist.";
    public static final String GDP4040170_DETAILS = "GDP4040170: No subject areas found for given id.";
    public static final String GDP40017_MESSAGE = "Unable to delete Attribute.";

    /******************************************* DATAMODEL **********************************************/
    public static final String GDP5000151_DETAILS = "GDP5000151: Unable to retrieve DataModel";
    public static final String GDP5000152_DETAILS = "GDP5000152: Unable to save DataModel";
    public static final String GDP5000153_DETAILS = "GDP5000153: Unable to save DataModelTable details";
    public static final String GDP5000154_DETAILS = "GDP5000154: Unable to update DataModelTable details";
    public static final String GDP5000155_DETAILS = "GDP5000155: Unable to save column details";
    public static final String GDP5000156_DETAILS = "GDP5000156: Unable to retrieve column details,please refresh page";
    public static final String GDP5000157_DETAILS = "GDP5000157: Unable to save DataModelRules details";
    public static final String GDP5000158_DETAILS = "GDP5000158: Unable to retrieve DataModelTable details";
    public static final String GDP5000159_DETAILS = "GDP5000159: Unable to retrieve DataModelRules details";
    public static final String GDP5000160_DETAILS = "GDP5000160: Unable to update DataModel";
    public static final String GDP5000161_DETAILS = "GDP5000161: Unable to delete DataModel";
    public static final String GDP5000162_DETAILS = "GDP5000162: Unable to delete DataModelColumn details";
    public static final String GDP5000163_DETAILS = "GDP5000163: Unable to save DataModel details";
    public static final String GDP5000164_DETAILS = "GDP5000164: Unable to save DefaultTableGroup";
    public static final String GDP5000165_DETAILS = "GDP5000165: Unable to save DefaultTableGroup details";
    public static final String GDP5000166_DETAILS = "GDP5000166: Unable to delete DefaultTableGroup details";
    public static final String GDP5000167_DETAILS = "GDP5000167: Unable to save DataModelRuleRun";
    public static final String GDP5000168_DETAILS = "GDP5000168: Unable to retrieve DataModel TableGroup";
    public static final String GDP5000169_DETAILS = "GDP5000169: Unable to generate Query for Rule ";
    public static final String GDP5000170_DETAILS = "GDP5000170: Unable to update DataModelRuleRun";
    public static final String GDP5000171_DETAILS = "GDP5000171: Unable to delete DataModel TableGroup";
    public static final String GDP5000172_DETAILS = "GDP5000172: Unable to retrieve DataModel RuleRun";
    public static final String GDP5000173_DETAILS = "GDP5000173: Unable to retrieve table details from TableGroup";
    public static final String GDP400018_MESSAGE = "Could not establish connection to the target data source";
    public static final String GDP400019_MESSAGE = "Invalid rule details";
    public static final String GDP5000174_DETAILS = "GDP5000174: Unable to delete Tables";
    public static final String GDP5000175_DETAILS = "GDP5000175: Unable to delete Rules";
    public static final String GDP5000176_DETAILS = "GDP5000176: Unable to retrieve DefaultTableGroup";
    public static final String GDP5000177_DETAILS = "GDP5000176: Unable to retrieve Datamodel count";
    public static final String GDP5000178_DETAILS = "GDP5000178: Unable to retrieve schemas ";
    public static final String GDP5000179_DETAILS = "GDP5000179: Unable to retrieve tables ";
    public static final String GDP5000206_DETAILS = "GDP5000206: Unable to save saveCustomFieldValues";
    public static final String GDP5000207_DETAILS = "GDP5000207: No datamodel were found for given datamodel name and container name.";

    public static final String GDP5000600_DETAILS = "GDP5000600: Unable to save relations";
    public static final String GDP5000601_DETAILS = "GDP5000601: Unable to retrieve relations";
    public static final String GDP5000602_DETAILS = "GDP5000602: Unable to delete relations";
    public static final String GDP5000603_DETAILS = "GDP5000603: Unable to retrieve scores";
    public static final String GDP5000604_DETAILS = "GDP5000604: Unable to generate scores";
    public static final String GDP5000605_DETAILS = "GDP5000605: Unable to download CSV";
    public static final String GDP5000606_DETAILS = "GDP5000600: Unable to run rules";
    public static final String GDP5000607_DETAILS = "GDP5000607: Unable to delete Rules Run";
    public static final String GDP5000608_DETAILS = "GDP5000608: Unable to add template";
    public static final String GDP5000609_DETAILS = "GDP5000609: Unable to delete column";
    public static final String GDP5000610_DETAILS = "GDP5000610: Unable to process the import request due to invalid input";
    public static final String GDP5000611_DETAILS = "GDP5000611: Unable to save synthetic data for table";
    public static final String GDP5000612_DETAILS = "GDP5000612: Unable to process the request, imported/saved datamodel has invalid relations";
    public static final String GDP5000613_DETAILS = "GDP5000613 : Unable to import data model";
    public static final String GDP5000614_DETAILS = "GDP5000614 : Please retrieve sample data";
    public static final String GDP5000615_DETAILS = "GDP5000615 : Relation already exist";
    public static final String GDP5000616_DETAILS = "GDP5000616 :  Unable to retrive datamodel recent runs";
    public static final String GDP500621_DETAILS = "GDP5000616 : Problem while processing relations for export";
    public static final String GDP500622_DETAILS = "GDP5000617 : Problem while processing rules for export";
    public static final String GDP400044_MESSAGE = "bad or good records Query/condition resulting to negative number of records";


    public static final String GDP400040_MESSAGE = "No tables found";
    public static final String GDP4000400_DETAILS = "GDP4000400:No tables found to run rules";
    public static final String GDP400050_MESSAGE = "No rules found";
    public static final String GDP4000501_DETAILS = "GDP4000501:No active rules found for selected group";
    public static final String GDP50070010_DETAILS = "GDP50070010 : Unable to run etl validator testcase";
    public static final String GDP4000401_DETAILS = "GDP4000401:The specific run is not available or deleted ";
    public static final String GDP4000402_DETAILS = "GDP4000402:The specific Datamodel is not available or deleted ";
    public static final String GDP4000403_MESSAGE = "GDP4000403:Invalid table group id";
    public static final String GDP4000404_DETAILS = "GDP4000404:This table Group id is not belongs to the datamodel";
    public static final String GDP4000405_MESSAGE = "Unable to process the request, table has unsupported datatypes";
    public static final String GDP4000408_DETAILS = "GDP4000408:The specific table group is not available or deleted ";

    public static final String GDP400042_MESSAGE = "Unable to import the datamodel";
    public static final String GDP4000406_DETAILS = "GDP4000406: Datamodel with id is deleted";

    public static final String GDP400043_MESSAGE = "Unable to import the datamodel as id exists with the imported datamodel id";
    public static final String GDP4000407_DETAILS = "GDP4000407: No datamodel associated with this table group id";

    public static final String GDP4000409_DETAILS = "GDP4000409: Selected DataSource is not available to run rule(s) in the data model";
    public static final String GDP4000413_DETAILS = "GDP4000413: Selected Workschema is not available to run rule(s) in the data model";


    public static final String GDP400052_MESSAGE = " Unable to get Testcases";
    public static final String GDP4000520_DETAILS = "GDP4000520 :  Configure valid ETL Validator Server in Server settings screen";

    public static final String GDP400053_MESSAGE = "Unable to preview";
    public static final String GDP4000530_DETAILS = "GDP4000530 : Error in compare json";
    public static final String GDP4000531_DETAILS = "GDP4000531 : Error in generating sample data";
    public static final String GDP4000532_DETAILS = "GDP4000532 : Error in compare json and generate sample data";
    public static final String GDP4000533_DETAILS = "GDP4000533 : Error in generating file path for sample data";
    public static final String GDP4000534_DETAILS = "GDP4000534 : Error in saving sample data";
    public static final String GDP4000535_DETAILS = "GDP4000535 : Unable to preview";
    public static final String GDP4000536_MESSAGE = "No WorkSchema found";
    public static final String GDP4000537_DETAILS = "GDP4000537 : No active WorkSchema found for selected Datamodel";
    public static final String GDP4000538_DETAILS = "GDP4000538 : Error occured in auto detection";
    public static final String GDP4000539_DETAILS = "GDP4000539 : Unable to create the directory structure";

    public static final String GDP400054_MESSAGE = "Unable to get Testplans";
    public static final String GDP4000540_DETAILS = "GDP4000540 :  Configure valid BI Validator Server in Server settings screen";
    public static final String GDP4000541_DETAILS = "GDP4000541 :  Credentials file is mandatory";


    public static final String GDP4000550_DETAILS = "GDP4000550 : Unable to upload the sample file";
    public static final String GDP4000551_DETAILS = "GDP4000551 : Auto detect got failed";
    public static final String GDP4000552_DETAILS = "GDP4000552 : Auto Recommend got failed";
    public static final String GDP4000553_DETAILS = "GDP4000553 : Error occured in auto recommendation";
    public static final String GDP4000554_DETAILS = "GDP4000554 : Sample file is not present for the current table,Please retrieve or upload sample data";
    public static final String GDP4000555_DETAILS = "GDP4000555 : Error occured while reading sample file data";
    public static final String GDP4000556_DETAILS = "GDP4000556 : Unable to get auto update value from sample data setting json";
    public static final String GDP4000557_DETAILS = "GDP4000557 : Unable to get entities";
    public static final String GDP4000558_DETAILS = "GDP4000558 : Table Not Found";
    public static final String GDP4000559_DETAILS = "GDP4000559 : Dataset could not be found";
    public static final String GDP4000560_DETAILS = "GDP4000560 : Unable to delete table";
    public static final String GDP4000561_DETAILS = "GDP4000561 : Unable to get generation history";
    public static final String GDP4000562_DETAILS = "GDP4000562 : Unable to get generate tables";
    public static final String GDP4000563_DETAILS = "GDP4000563 : Unable to get generate status";

    public static final String GDP4000564_DETAILS = "GDP4000564 : Unable to export datamodel columns";
    public static final String GDP4000565_DETAILS = "GDP4000565 : Unable to import datamodel columns";
    public static final String GDP5007050_DETAILS = "GDP5007050 : Unable to run datamodel";
    public static final String GDP4000502_DETAILS = "GDP4000502 : Unable to get rules";
    public static final String GDP4000566_DETAILS = "GDP4000566 : No tables are added in datamodel for run";

    public static final String GDP4000567_DETAILS = "GDP4000567 : Unable to sync catalog for datamodel";

    public static final String GDP4000568_DETAILS = "GDP4000568 : Add tdm temp file location in app config properties";

    public static final String GDP4000569_DETAILS = "GDP4000569 : Unable to access TDM Service, It should be up and running or verify configured TDM URL";

    public static final String GDP5000100_MESSAGE = "WARNING";

    public static final String GDP500101_MESSAGE = "Unable to export columns";

    public static final String GDP500102_MESSAGE = "Unable to export relations";

    public static final String GDP500104_MESSAGE = "Unable to export templates";

    public static final String GDP500109_DETAILS = "Unable to export datamodel";

    public static final String GDP500110_MESSAGE = "Unable to export rules";

    public static final String GDP400102_DETAILS = "GDP400102 : Something went wrong while saving the bad records. More details : ";

    public static final String GDP400103_DETAILS = "GDP400103 : Something went wrong while execting rule.";

    public static final String GDP400104_DETAILS = "GDP4000104 : Problem while processing columns for export";

    /******************************************Datasets******************************************************/
    public static final String GDP5000701_DETAILS = "GDP5000701 : Unable to save dataset";
    public static final String GDP5000702_DETAILS = "GDP5000702 : Unable to update dataset";
    public static final String GDP5000703_DETAILS = "GDP5000703 : Unable to get datasets,Please refresh";
    public static final String GDP5000704_DETAILS = "GDP5000704 : Unable to get dataset";
    public static final String GDP5000705_DETAILS = "GDP5000705 : Unable to delete dataset";
    public static final String GDP5000706_DETAILS = "GDP5000706 : Unable to save generate details";
    public static final String GDP5000707_DETAILS = "GDP5000707 : Unable to save load details";
    public static final String GDP5000708_DETAILS = "GDP5000708 : Unable to save write details";
    public static final String GDP5000709_DETAILS = "GDP5000709 : Unable to get dataset count";
    public static final String GDP5000710_DETAILS = "GDP5000710 : Unable to process write due to incorrect write options";

    /******************************************* CodeLib **********************************************/

    public static final String GDP5001100_DETAILS = "GDP501100: Unable to retrieve code snippet";
    public static final String GDP5001101_DETAILS = "GDP501101: Unable to save code snippet";
    public static final String GDP5001102_DETAILS = "GDP501102: Unable to update code snippet";
    public static final String GDP5001103_DETAILS = "GDP501103: Unable to delete code snippet";
    public static final String GDP5001104_DETAILS = "GDP501104: Unable to find code snippet";
    public static final String GDP500104_DETAILS = "GDP500104: Problem while saving the group";
    public static final String GDP500110_DETAILS = "GDP500110: Problem while updating the code library group";
    public static final String GDP500111_DETAILS = "GDP500111: unable to delete code library group";

    /******************************************* Environment Variables **********************************************/

    public static final String GDP5001200_DETAILS = "GDP501200: Unable to retrieve environments";
    public static final String GDP5001201_DETAILS = "GDP501201: Unable to save environment details";
    public static final String GDP5001202_DETAILS = "GDP501202: Unable to update environment details";
    public static final String GDP5001203_DETAILS = "GDP501203: Unable to delete environment";
    public static final String GDP5001204_DETAILS = "GDP501204: Unable to find environment";

    public static final String GDP5001210_DETAILS = "GDP501210: Unable to retrieve environment variables";
    public static final String GDP5001211_DETAILS = "GDP501211: Unable to save environment variables";
    public static final String GDP5001212_DETAILS = "GDP501212: Unable to update environment variables";
    public static final String GDP5001213_DETAILS = "GDP501213: Unable to delete environment variables";
    public static final String GDP5001214_DETAILS = "GDP501214: Unable to find environment variables";
    public static final String GDP5001215_DETAILS = "GDP501215: Unable to retrieve environment variable Id's";
    public static final String GDP5001216_DETAILS = "GDP501216: Unable to retrieve environment variable name which is already exist";
    public static final String GDP5001217_DETAILS = "GDP501217: Logical name already exist in Data Sources/Clusters";
    public static final String GDP5001218_DETAILS = "GDP501218: Unable to find default environment variable name";

    public static final String GDP5001220_DETAILS = "GDP501220: Unable to retrieve environment values";
    public static final String GDP5001221_DETAILS = "GDP501221: Unable to save environment values";
    public static final String GDP5001222_DETAILS = "GDP501222: Unable to update environment values";
    public static final String GDP5001223_DETAILS = "GDP501223: Unable to delete environment values";
    public static final String GDP5001224_DETAILS = "GDP501224: Unable to find environment values";
    public static final String GDP5001225_DETAILS = "GDP501225: Unable to update data source names in environment values";

    public static final String GDP5001226_MESSAGE = "Unable to delete environment";
    public static final String GDP5001226_DETAILS = "GDP501226: Make another environment as default before proceeding to delete this environment";

    /******************************************* Plugin **********************************************/
    public static final String GDP5001301_MESSAGE = "GDP5001301: Plugins not found";
    public static final String GDP5001301_DETAILS = "GDP5001301: Unable to save Plugin";
    public static final String GDP5001302_DETAILS = "GDP5001302: Unable to retrieve Plugins";
    public static final String GDP5001303_DETAILS = "GDP5001303: Unable to delete Plugin";
    public static final String GDP5001305_DETAILS = "GDP5001305: Unable to import Plugins";
    public static final String GDP5001306_DETAILS = "GDP5001306: Plugin not found or deleted with pluginId";
    public static final String GDP5001308_DETAILS = "GDP5001308: Plugin not found";


    /******************************************* BI **********************************************/
    public static final String GDP4001401_MESSAGE = "Path cannot be empty";
    public static final String GDP4001401_DETAILS = "GDP4001401: Unable to get the path";
    public static final String GDP4001402_DETAILS = "GDP4001402: Unable to save in statements table";
    public static final String GDP4001404_DETAILS = "GDP4001404: Worksheet name cannot be empty";
    public static final String GDP4001405_DETAILS = "GDP4001405: Parameter name cannot be empty";
    public static final String GDP4001406_DETAILS = "GDP4001406: Unable to get View type";
    public static final String GDP4001407_DETAILS = "GDP4001407: Unable to get View title";
    public static final String GDP4001408_DETAILS = "GDP4001404: Worksheets cannot be empty";
    public static final String GDP5001401_DETAILS = "GDP5001401: No snapshot available";
    public static final String GDP5001402_DETAILS = "GDP5001402: unable retrieve snapshot";
    public static final String GDP5001403_DETAILS = "GDP5001403: No baseline report available";
    public static final String GDP5001404_DETAILS = "GDP5001404: No regression run report available";
    public static final String GDP5001405_DETAILS = "GDP5001405: No regression steps available";

    public static final String GDP4001409_DETAILS = "GDP4001409: Compare mode cannot be empty";
    public static final String GDP4001410_DETAILS = "GDP4001410: Color cannot be empty for text/appearance mode";
    public static final String GDP4001411_DETAILS = "GDP4001411: Opacity cannot be empty for text/appearance mode";
    public static final String GDP4001412_DETAILS = "GDP4001410: DPI cannot be empty for appearance mode";

    public static final String GDP500706_DETAILS = "GDP500706: Unable to retrieve benchmark duration for baseline report";
    public static final String GDP500711_DETAILS = "GDP500711: Unable to retrieve run report duration";
    public static final String GDP500720_DETAILS = "GDP500720: Report-A is not  available";
    public static final String GDP500721_DETAILS = "GDP500721: Report-B is not  available";
    public static final String GDP500722_DETAILS = "GDP500722: Unable to retrieve upgrade report duration";
    public static final String GDP500733_DETAILS = "GDP500733: Error while getting engine status";


    /******************************************* POWER BI **********************************************/
    public static final String GDP4001501_DETAILS = "GDP4001501: Unable to get the page name";
    public static final String GDP4001502_DETAILS = "GDP4001502: Unable to get the report id";
    public static final String GDP4001503_DETAILS = "GDP4001503: Unable to get the embeded url";
    public static final String GDP4001504_DETAILS = "GDP4001504: Unable to get the report name";
    public static final String GDP4001505_DETAILS = "GDP4001505: Unable to get the visuals";

    public static final String GDP4001511_DETAILS = "GDP4001511: Unable to get groups";
    public static final String GDP4001512_DETAILS = "GDP4001512: Unable to get reports";
    public static final String GDP4001513_DETAILS = "GDP4001513: Unable to get pages";

    public static final String GDP4001520_DETAILS = "GDP4001520: Tenant Id is empty";
    public static final String GDP4001521_DETAILS = "GDP4001521: Invalid authentication type: ";

    public static final String GDP4001531_DETAILS = "GDP4001531: Failed to create statements for PowerBI component";

    public static final String GDP4001541_MESSAGE = "Failed to get the embeded token";

    public static final String GDP500232_DETAILS = "GDP500232: Unable to get power bi datasets";
    public static final String GDP500233_DETAILS = "GDP500233: Unable to get power bi tables";


    /******************************************* Server Logs **********************************************/

    public static final String GDP5001307_DETAILS = "GDP5001307: Unable to retrieve Logs";


    /******************************************* DataBase DBtype **********************************************/
    public static final String GDP5002100_DETAILS = "GDP50002100 unable to retrieve dataSource datatype";

    /******************************************* FormSchema **********************************************/
    public static final String GDP5002110_DETAILS = "GDP5002110 unable to retrieve from schemas";

    /******************************************* CDM **********************************************/
    public static final String GDP5000180_DETAILS = "GDP5000180 : Unable to save subjectArea";
    public static final String GDP5000181_DETAILS = "GDP5000181 : Unable to retrieve subjectArea";
    public static final String GDP5000182_DETAILS = "GDP5000182 : Unable to save entities";
    public static final String GDP5000183_DETAILS = "GDP5000183 : Unable to save attributes";
    public static final String GDP5000184_DETAILS = "GDP5000184 : Unable to save business rules";
    public static final String GDP5000185_DETAILS = "GDP5000185 : Unable to retrieve entities";
    public static final String GDP5000186_DETAILS = "GDP5000186 : Unable to retrieve attributes";
    public static final String GDP5000187_DETAILS = "GDP5000187 : Unable to retrieve business rules";
    public static final String GDP5000188_DETAILS = "GDP5000188 : Unable to retrieve data owners";
    public static final String GDP5000189_DETAILS = "GDP5000189 : Unable to save data owners";
    public static final String GDP5000194_DETAILS = "GDP5000194 : Unable to delete data owners";
    public static final String GDP5000195_DETAILS = "GDP5000195 : Unable to delete entities";
    public static final String GDP5000196_DETAILS = "GDP5000196 : Unable to delete atrributes";
    public static final String GDP5000197_DETAILS = "GDP5000197 : Unable to delete business rules";
    public static final String GDP5000198_DETAILS = "GDP5000198 : Unable to retrieve subjectArea count";
    public static final String GDP5000199_DETAILS = "GDP5000199 : Unable to retrieve subjectArea count";
    public static final String GDP5000200_DETAILS = "GDP5000200 : Unable to save mapping details";
    public static final String GDP5000201_DETAILS = "GDP5000201 : Unable to retrieve mapping details";
    public static final String GDP5000202_DETAILS = "GDP5000202 : Unable to retrieve mapping details";
    public static final String GDP5000303_DETAILS = "GDP5000303 : The provided mapping validation list is empty.";
    /******************************************* Domains **********************************************/
    public static final String GDP5000190_DETAILS = "GDP5000190 : Unable to save domain";

    public static final String GDP5000191_DETAILS = "GDP5000191 : Unable to retrieve domains";

    public static final String GDP5000192_DETAILS = "GDP5000192 : Unable to delete domains";

    /******************************************* Favourites **********************************************/

    public static final String GDP5000203_DETAILS = "GDP5000203 : Unable to save favourites";
    public static final String GDP5000204_DETAILS = "GDP5000204 : Unable to retrieve favourites";
    public static final String GDP5000205_DETAILS = "GDP5000205 : Unable to delete favourites";

    /******************************************* Configure **********************************************/
    public static final String GDP5003001_DETAILS = "GDP5003001: Unable to get application keys";

    public static final String GDP5003002_DETAILS = "GDP5003002: Unable to get the data model operators";

    public static final String GDP5003003_DETAILS = "GDP5003003: Unable to save the data model operators";

    public static final String GDP5003004_DETAILS = "GDP5003004: Unable to delete the data model operators";

    public static final String GDP5003005_DETAILS = "GDP5003005: Invalid operator id";

    public static final String GDP5003006_DETAILS = "GDP5003006: Unable to get the databases";

    public static final String GDP5003007_DETAILS = "GDP5003007: Unable to get the mapped data type";

    public static final String GDP5003008_DETAILS = "GDP5003008: Unable to get operator";

    public static final String GDP5003009_DETAILS = "GDP5003009: Unable to get datatypes";

    public static final String GDP5003010_DETAILS = "GDP5003010: No operator found by name";

    public static final String GDP5003011_DETAILS = "GDP5003011: Unable to get mapped OperatorId";

    public static final String GDP5003012_DETAILS = "GDP5003012: Operator name already exists.";

    public static final String GDP5003013_DETAILS = "GDP5003013: Operator name cannot be null or empty";

    public static final String GDP5003014_DETAILS = "GDP5003014: Invalid Expression Format";

    /******************************************* Analysis **********************************************/
    public static final String GDP5000400_DETAILS = "GDP5000400: Unable to retrieve Aggregates";
    public static final String GDP5000401_DETAILS = "GDP5000401 : Unable to retrieving Measures";
    public static final String GDP5000402_DETAILS = "GDP5000402 : Unable to save Analysis";
    public static final String GDP5000403_DETAILS = "GDP5000403: Unable to retrieve Analysis";
    public static final String GDP5000404_DETAILS = "GDP5000404: Unable to retrieve Analysis Runs";
    public static final String GDP5000405_DETAILS = "GDP5000405: Unable to retrieve Analysis Run Details";
    public static final String GDP5000406_DETAILS = "GDP5000406: Unable to update ignoreAnalysisForPrediction";

    /******************************************* Observability **********************************************/
    public static final String GDP5000407_DETAILS = "GDP5000407 : Observability details not available";
    public static final String GDP5000409_DETAILS = "GDP5000409: Unable to retrieve Observability Runs";
    public static final String GDP5000410_DETAILS = "GDP5000410: Unable to retrieve Observability Run Details";
    public static final String GDP5000411_MESSAGE = "Unable to connect workschema";

    /******************************************* Prediction **********************************************/
    public static final String GDP5000500_DETAILS = "GDP5000500: Unable to retrieve Predictions";
    public static final String GDP5000501_DETAILS = "GDP5000501: Unable to retrieve Predictions Details";

    /******************************************* Delta Rule **********************************************/
    public static final String GDP5000502_DETAILS = "GDP5000502: Problem while comparing DeltaRule metadata";
    public static final String GDP5000503_DETAILS = "GDP5000503: Problem while Reading table data from Source";
    public static final String GDP5000504_DETAILS = "GDP5000504: Problem while Writing table data to WorkSchema";
    public static final String GDP5000505_DETAILS = "GDP5000505: Problem while rename Workschema tables";
    public static final String GDP5000506_DETAILS = "GDP5000506: Problem while checking table in Workschema";
    public static final String GDP5000507_DETAILS = "GDP5000507: Problem while checking table from last rule run";
    public static final String GDP5000508_DETAILS = "GDP5000508: Problem while retrieve metadata";
    public static final String GDP5000515_DETAILS = "GDP5000515: Problem while delete metadata";
    public static final String GDP5000509_DETAILS = "GDP5000509: Problem while update metadata";
    public static final String GDP5000510_DETAILS = "GDP5000510: Problem while delete workschema table";
    public static final String GDP5000511_DETAILS = "GDP5000511: unable to retrieve delta rule table";
    public static final String GDP5000512_DETAILS = "GDP5000512: Unable to connect with Workschema using the given details.";
    public static final String GDP5000513_DETAILS = "GDP5000513: Error in Delta Rule";
    public static final String GDP5000514_DETAILS = "GDP5000514: Table/View already exist in Workschema";

    /***************************************DB Flows***********************************************/
    public static final String GDP6000600_DETAILS = "GDP6000600: Problem while getting DB Flow result";
    public static final String GDP6000601_MESSAGE = "Unable to save DB Flow.";
    public static final String GDP6000602_DETAILS = "DB Flow name already exists in the given container.";
    public static final String GDP6000603_DETAILS = "GDP6000603 : No components are added in DB Flow for execution";
    public static final String GDP6000604_DETAILS = "GDP6000604: Problem while getting workschema mapping";
    public static final String GDP6000605_DETAILS = "GDP6000605: Problem while getting DDL";
    public static final String GDP6000606_DETAILS = "GDP6000606: Unable to get column details";
    public static final String GDP6000607_DETAILS = "GDP6000607: Unable to read the file";
    public static final String GDP6000608_DETAILS = "GDP6000608: Problem while checking table or View in Workschema";
    public static final String GDP6000609_DETAILS = "GDP6000609: Problem while drop workschema table";
    public static final String GDP6000610_DETAILS = "GDP6000610: Problem while drop workschema VIEW";
    public static final String GDP6000611_DETAILS = "GDP6000611: Problem while get check table/view query";
    public static final String GDP6000612_DETAILS = "GDP6000612: Warehouse is suspended.Please resume warehouse.";
    public static final String GDP6000613_DETAILS = "GDP6000613: Selected Data source or Workschema is not available,please verify datasource or workschema details";

    public static final String GDP6000614_DETAILS = "GDP6000614: DB Flow already running with different runId";
    public static final String GDP6000615_DETAILS = "GDP6000615: In current DB Flow some component already running, please wait until run complete";

    public static final String GDP6000616_DETAILS = "GDP6000616: Unable to Connect DataSource or Workschema";
    public static final String GDP6000617_DETAILS = "GDP6000617: Unable to Connect Workschema or Warehouse is suspended or not active.Please verify connection details and warehouse activation.";
    public static final String GDP6000618_DETAILS = "GDP6000618: Unable to process columns details, please check the logs";


    /***************************************Jira****************************************************/
    public static final String GDP7000700_DETAILS = "GDP7000700: Could not get projects from jira server";
    public static final String GDP7000701_DETAILS = "GDP7000701: Could not get issue types from jira server";
    public static final String GDP7000702_DETAILS = "GDP7000702: Could not create jira issue";
    public static final String GDP7000703_DETAILS = "GDP7000703: Error occured while getting issue types";
    public static final String GDP7000704_DETAILS = "GDP7000704: Need to configure JIRA details in Integration section of Configure menu";
    public static final String GDP7000705_DETAILS = "GDP7000705: Please enter valid api token and user name in user wallet of profile page or common wallet in Integration section of configure menu";
    public static final String GDP7000706_DETAILS = "GDP7000706: Unable to access the jira url -> {url} Please enter valid domain url in integration section";
    public static final String GDP7000707_DETAILS = "GDP7000707: Please enter valid jira credentials in user wallet section of profile page or integration menu of configure section.";
    public static final String GDP7000708_DETAILS = "GDP7000708: Username can not be empty,please provide valid username in integration section";
    public static final String GDP7000709_DETAILS = "GDP7000709: Password can not be empty,please provide valid password in integration section";
    public static final String GDP7000710_DETAILS = "GDP7000710: Url can not be empty,please provide valid url in integration section";
    public static final String GDP7000711_DETAILS = "GDP7000711: Unable to reach jira url ,please provide valid url in integration section";
    public static final String GDP7000712_DETAILS = "GDP7000712: Jira server details are not configured, Please add in integration section";
    public static final String GDP700713_DETAILS = "GDP700713: Please enter valid jira configuration details in integration section";
    public static final String GDP700714_DETAILS = "GDP700714: Problem while validating jira configuration details";
    public static final String GDP700715_MESSAGE = "Jira integration test failed";
    public static final String GDP700716_DETAILS = "GDP700716: Connection Timed Out";
    public static final String GDP700717_DETAILS = "GDP700717: Could not get assignee list from jira server";
    public static final String GDP700718_DETAILS = "GDP700718: Could not get custom fields from jira server";
    public static final String GDP700719_DETAILS = "GDP700719: Could not get priorities from jira server";
    public static final String GDP700720_DETAILS = "GDP700720: Could not get boards from jira server";
    public static final String GDP700721_DETAILS = "GDP700721: Could not get sprint values from jira server";
    public static final String GDP700722_DETAILS = "GDP700722: Could not create issue";
    public static final String GDP700723_DETAILS = "GDP700723: Jira Url should not be empty";
    public static final String GDP700724_DETAILS = "GDP700724: Problem while listing issues in a Jira project";
    /***************************************Global Parameter****************************************************/
    public static final String GDP8000800_DETAILS = "GDP8000800: Unable to fetch global parameters for container id : ";
    public static final String GDP8000801_DETAILS = "GDP8000801: Unable to save global parameter";
    public static final String GDP8000802_DETAILS = "GDP8000802: Unable to delete global parameter";
    public static final String GDP8000803_DETAILS = "GDP8000803: Save is success but fetching ran into a problem";
    public static final String GDP8000804_DETAILS = "GDP8000804: Delete is success but fetching ran into a problem";
    public static final String GDP8000805_DETAILS = "GDP8000805: failed to get cli version contact support team";
    public static final String GDP8000806_DETAILS = "GDP8000806: Error while setting parameters";
    public static final String GDP8000807_DETAILS = "GDP8000807: Unable to import global parameters";
    public static final String GDP8000809_DETAILS = "GDP8000809: Global parameter cannot be null or empty";
    public static final String GDP8000808_DETAILS = "GDP8000808: Global parameter already exists";


    /* ************************************** LoadTables ******************************************* */

    public static final String GDP7000001_DETAILS = "GDP7000001: unable to process Load";
    public static final String GDP7000002_DETAILS = "GDP7000002: unable to retrieve Load Details";
    public static final String GDP7000003_DETAILS = "GDP7000003: unable to update load status";

    public static final String GDP7000004_DETAILS = "GDP7000004 : Source datasource type and target datasource type should be same to use drop functionality";
    public static final String GDP7000005_DETAILS = "GDP7000005 : Unable to create new table in target datasource";
    public static final String GDP7000006_DETAILS = "GDP7000006 : No datamodel column is present with column name : ";
    public static final String GDP7000007_DETAILS = "GDP7000007 : datamodel columns are not present for the given datamodel table";
    public static final String GDP7000008_DETAILS = "GDP7000008 : Could not found target schema";

    public static final String GDP5000711_DETAILS = "GDP5000711 : Unable to find root Temp file Location";
    public static final String GDP5000712_DETAILS = "GDP5000712 : Unable to find object id by run id";
    public static final String GDP5000713_DETAILS = "GDP5000713 : Metric rule result value should be single and numeric";
    public static final String GDP5000714_MESSAGE = "Invalid metric rule query";

    /* ************************************** Password Vault ******************************************* */
    public static final String GDP500018_MESSAGE = "Invalid Details.";
    public static final String GDP500018_DETAILS = "GDP500018: Unable to get password vault details.";
    public static final String GDP400018_DETAILS = "GDP400018: Vault name or password key is missing in data source details.";
    public static final String GDP500019_DETAILS = "GDP500019: Error while getting the password from CyberArk Vault.";
    public static final String GDP500020_DETAILS = "GDP500020: Error while getting the password from Azure Vault.";
    public static final String GDP400021_DETAILS = "GDP400021: Invalid vault type in data source.";
    public static final String GDP500022_DETAILS = "GDP500022: Error while getting the password from Hashicorp Vault";
    public static final String GDP500023_DETAILS = "GDP500023: Error while getting Hashicorp Vault properties";
    public static final String GDP500024_DETAILS = "GDP500024: Error while getting the password from Vault";
    public static final String GDP500025_DETAILS = "GDP500025: Unable to find the password key in hashicorp vault";
    public static final String GDP500026_DETAILS = "GDP500026: Unable to save azure devops server details";
    public static final String GDP500027_DETAILS = "GDP500027: Unable to retrieve azure devops server details";

    public static final String GDP500028_DETAILS = "GDP500028: Unable to save jira server details,please check core service log for more details";
    public static final String GDP500029_DETAILS = "GDP500029: Unable to retrieve jira server details,please check core service log for more details";

    public static final String GDP500030_DETAILS = "GDP500030: Unable to save server details";
    public static final String GDP500031_DETAILS = "GDP500031: Unable to retrieve server details";
    public static final String GDP500032_DETAILS = "GDP500032: Unable to get password from internal vault";

    public static final String GDP4090701_DETAILS = "GDP4090701: App property name already exists.";
    public static final String GDP4040702_DETAILS = "GDP4040702: No App Property found.";
    public static final String GDP4040703_MESSAGE = "Unable to save/update App property. ";

    public static final String GDP4040705_MESSAGE = "Unable to test/run rule";
    public static final String GDP4040704_DETAILS = "GDP4040704: Rule query can not be null or empty.";
    public static final String GDP4040706_DETAILS = "GDP4040706: Metric rule query can not be null or empty.";
    public static final String GDP4040707_DETAILS = "GDP4040707: Delta rule query can not be null or empty.";
    public static final String GDP4040708_DETAILS = "GDP4040708: Required fields are missed.";
    public static final String GDP4040709_DETAILS = "GDP4040709: Rule query condition can not be null or empty.";
    public static final String GDP404070_DETAILS = "GDP404070: count query can not be null or empty.";
    public static final String GDP404071_DETAILS = "GDP404071: Error while getting the password from Aws-Secret Manager.";

    /* ****************************** Meta Data Compare ********************************************* */

    public static final String GDP4040710_DETAILS = "GDP4040710: Unable to get database mappings";
    public static final String GDP4040711_DETAILS = "GDP4040711: Unable to get datatype mappings";
    public static final String GDP4040712_DETAILS = "GDP4040712: Unable to save database mapping";
    public static final String GDP4040713_DETAILS = "GDP4040713: Unable to save datatype mapping";
    public static final String GDP4040714_DETAILS = "GDP4040714: Unable to delete database mapping";
    public static final String GDP4040715_DETAILS = "GDP4040715: Unable to delete datatype mapping";
    public static final String GDP4040716_DETAILS = "GDP4040716: Unable to update database mapping";
    public static final String GDP4040717_DETAILS = "GDP4040717: Unable to update datatype mapping";
    public static final String GDP4040718_DETAILS = "GDP4040718: Database Mapping Already Exists";
    public static final String GDP4040719_DETAILS = "GDP4040719: DataType Mapping Already Exists";
    public static final String GDP4040720_DETAILS = "GDP4040720: Unable to check the datatype mapping";
    public static final String GDP4040721_DETAILS = "GDP4040721: Unable to check the database mapping";
    public static final String GDP4040722_DETAILS = "GDP4040722: Unable to delete datatype mappings by dbmapping id";
    public static final String GDP4040723_DETAILS = "GDP4040723: Unable to get datatype mapping for given map id";

    /* ************************************** Profile Page ******************************************* */
    public static final String GDP4040730_DETAILS = "GDP4040730: Unable to save user wallet";
    public static final String GDP4040731_DETAILS = "GDP4040731: Unable to save user preference";
    public static final String GDP4040732_DETAILS = "GDP4040732: Unable to update user details";
    public static final String GDP404001_DETAILS = "GDP404001: Unable to save user datasource wallet";
    public static final String GDP404002_DETAILS = "GDP404002: Wallet details already exists for the datasource.";
    public static final String GDP404003_DETAILS = "GDP404003: No wallet details available for the user.";
    public static final String GDP404004_DETAILS = "GDP404004: Unable to delete user datasource wallet";
    public static final String GDP404005_DETAILS = "GDP404005: Wallet details should not be empty";
    public static final String GDP404006_DETAILS = "GDP404006: Unable to update user datasource wallet";
    public static final String GDP404007_DETAILS = "GDP404007: Unable to get user datasource wallet details";

    public static final String GDP404014_MESSAGE = "Duplicate Record";
    public static final String GDP404015_MESSAGE = "Invalid Old Password";
    public static final String GDP404016_MESSAGE = "Missing password details";

    /* ************************************** Temp Staging ******************************************* */
    public static final String GDP500051_DETAILS = "GDP500051: Unable to get details from stagging table";

    /* ************************************** File Manager ******************************************* */
    public static final String GDP400022_DETAILS = "GDP400022: Found invalid datasource type for file explorer.";
    public static final String GDP500002_MESSAGE = "Unable to get files";
    public static final String GDP500100_DETAILS = "GDP500100: Error while getting files from the source.";
    public static final String GDP500101_DETAILS = "GDP500101: Error while decrypting the key.";
    public static final String GDP500003_MESSAGE = "Unable to upload file";
    public static final String GDP500102_DETAILS = "GDP500102: Error while uploading into the source.";
    public static final String GDP400023_DETAILS = "GDP400023: Error while getting files from the source.";

    /* ************************************** Azure-Devops ******************************************* */
    public static final String GDP500201_DETAILS = "GDP500201: Unable to list the projects";
    public static final String GDP500202_DETAILS = "GDP500202: Unable to list test plans";
    public static final String GDP500203_DETAILS = "GDP500203: Unable to add test plans";
    public static final String GDP500204_DETAILS = "GDP500204: Unable to list test suites";
    public static final String GDP500205_DETAILS = "GDP500205: Unable to add test suites";
    public static final String GDP500206_DETAILS = "GDP500206: Unable to add test cases";
    public static final String GDP500207_DETAILS = "GDP500207: Unable to retrieve test cases,please try again";
    public static final String GDP500208_DETAILS = "GDP500208: Unable to add test steps";
    public static final String GDP500209_DETAILS = "GDP500209: Unable to retrieve test steps,Please try again";
    public static final String GDP500210_DETAILS = "GDP500210: Unable to map steps";
    public static final String GDP500211_DETAILS = "GDP500211: Please enter valid access token in user wallet section of Profile screen";
    public static final String GDP500212_DETAILS = "GDP500212: Unable to perform operations on azure devops";
    public static final String GDP500213_DETAILS = "GDP500213: Unable to publish test results";
    public static final String GDP500230_DETAILS = "GDP500230 : Dataflow is not mapped to any azure testcase";
    public static final String GDP500406_DETAILS = "GDP500406 : Please add Azure-DevOps user name in user wallet section of profile page";
    public static final String GDP500407_DETAILS = "GDP500407 : Please add Azure-DevOps access token in user wallet section of profile page";
    public static final String GDP500408_DETAILS = "GDP500408 : Please add Azure-DevOps organization name in Integration section of configure menu";
    public static final String GDP500409_DETAILS = "GDP500409 : Unable to connect Integration Service application url - ";
    public static final String GDP500412_DETAILS = "GDP500412: Please enter Azure-DevOps password in user wallet section of profile page or add Azure-DevOps password in Integration section of configure menu.";
    public static final String GDP500413_DETAILS = "GDP500413: Please enter Azure-DevOps user name in user wallet section of profile page or add Azure-DevOps user name in Integration section of configure menu.";
    public static final String GDP500414_DETAILS = "GDP500414: Please enter valid access token in user wallet of profile page or common wallet in Integration section of configure menu.";

    public static final String GDP500421_DETAILS = "GDP500421: AzureDevops organization name is wrong, please provide valid organization name in integration section";
    public static final String GDP500422_DETAILS = "GDP500422: AzureDevops url is wrong, please provide valid url in integration section";
    public static final String GDP500423_DETAILS = "GDP500423: Unable to test AzureDevops Server Details";
    public static final String GDP500424_DETAILS = "GDP500424: Please enter valid Azure devops credentials in user wallet section of profile page or integration menu of configure section.";
    public static final String GDP500426_DETAILS = "GDP500426: Azure devops token is empty, please enter azure devops token";
    public static final String GDP500427_DETAILS = "GDP500427: Unable to delete testsuites";
    public static final String GDP500428_DETAILS = "GDP500428: Unable to fetch testcases";
    public static final String GDP500429_DETAILS = "GDP500429: Unable to delete testcases";
    public static final String GDP500430_DETAILS = "GDP500430: Unable to delete test steps";
    public static final String GDP500431_DETAILS = "GDP500431: Could not found test suites with given ids";
    public static final String GDP500432_DETAILS = "GDP500432: Could not found test cases with given ids";
    public static final String GDP500433_DETAILS = "GDP500433: Unable to add child test suite ids";
    public static final String GDP500434_DETAILS = "GDP500434: Unable to fetch test suite ids";
    public static final String GDP500435_DETAILS = "GDP500435: Unable to delete test plans";
    public static final String GDP500436_DETAILS = "GDP500436: Could not found test plans with given ids";
    public static final String GDP500437_DETAILS = "GDP500437: Unable to fetch test plan ids";
    public static final String GDP500438_DETAILS = "GDP500438: Unable to delete azure projects";
    public static final String GDP500439_DETAILS = "GDP500439: Could not found azure projects with given ids";
    public static final String GDP500440_MESSAGE = "Azure devops test failed";
    public static final String GDP500440_DETAILS = "GDP500442: Problem while validating Azure Devops configuration details";
    public static final String GDP500441_MESSAGE = "Ai integration test failed";
    public static final String GDP500441_DETAILS = "GDP500441: Problem while validating Ai integration configuration details";
    public static final String GDP500442_DETAILS = "GDP500442: AI returned an empty response";

    /* ************************************** Tableau ******************************************* */
    public static final String GDP500218_MESSAGE = "Unable to retrieve metadata";
    public static final String GDP500214_DETAILS = "GDP500214: Retrieve metadata in progress";
    public static final String GDP500215_DETAILS = "GDP500215: Tableau signin failed";
    public static final String GDP500217_DETAILS = "GDP500217: Unable to save metadata";
    public static final String GDP500219_DETAILS = "GDP500219: Unable to update metadata";
    public static final String GDP500220_DETAILS = "GDP500220: Unable to delete old metadata";
    public static final String GDP500218_DETAILS = "GDP500218: Unable to get metadata";
    public static final String GDP500221_DETAILS = "GDP500221: Unable to get power bi urls";
    public static final String GDP500222_DETAILS = "GDP500222: Unable to get tableau sites";


    public static final String GDP500223_DETAILS = "GDP500223: Unable to get projects";
    public static final String GDP500224_DETAILS = "GDP500224: Unable to get workbooks";
    public static final String GDP500225_DETAILS = "GDP500225: Unable to get views";
    public static final String GDP500226_MESSAGE = "Problem while get bi metadata";
    public static final String GDP500227_DETAILS = "GDP500227: Unable to get version";
    public static final String GDP500228_DETAILS = "GDP500228: Invalid tableau connection url";
    public static final String GDP500229_DETAILS = "GDP500229: Rest api version must not be empty or null.";
    public static final String GDP500231_DETAILS = "GDP500231: Tableau connection url must not be empty or null.";


    public static final String GDP4004024_DETAILS = "GDP4004024 : Unable to connect with Data Source using the given details";
    public static final String GDP4004025_MESSAGE = "Execution Skipped";
    public static final String GDP4004025_DETAILS = "GDP4004025 : Components selected to run all are in run mode ,but we are in design mode";
    public static final String GDP4004026_DETAILS = "GDP4004026 : Components selected to run all are in design mode ,but we are in run mode";
    public static final String GDP4004027_DETAILS = "GDP4004027 : Invalid AWS access key or secret key or both.";
    public static final String GDP4004028_DETAILS = "GDP4004028 : Tableau token name must not be empty or null.";
    public static final String GDP4004029_DETAILS = "GDP4004029 : Tableau token value must not be empty or null.";
    public static final String GDP400403_DETAILS = "GDP400403 : Failed to create statements for Tableau component";
    public static final String GDP4004030_DETAILS = "GDP4004030 : Unable to create cookies";
    public static final String GDP4004031_DETAILS = "GDP4004031 : Cookie is not available for this datasource";

    /************ Api-JsonDataFlow-create************/

    public static final String GDP400232_DETAILS = "GDP400232: dataflowName should not be empty or null";
    public static final String GDP400233_DETAILS = "GDP400233: containerName should not be empty or null";
    public static final String GDP400234_DETAILS = "GDP400234: folderName should not be empty or null";
    public static final String GDP400235_DETAILS = "GDP400235: engineName should not be empty or null";
    public static final String GDP400236_DETAILS = "GDP400236: sparkSessionId should not be empty or null";

    public static final String GDP500237_DETAILS = "GDP500237: Sources componentName should not be empty or null";
    public static final String GDP500242_DETAILS = "GDP500242: DataSourceName should not be empty or null %s %s";

    public static final String GDP500244_DETAILS = "GDP500244: Mapping componentName should not be empty or null";
    public static final String GDP500245_DETAILS = "GDP500245: Mapping datasetName should not be empty or null";
    public static final String GDP500246_DETAILS = "GDP500246: Mapping type should not be empty or null";
    public static final String GDP500247_DETAILS = "GDP500247: Mapping sourceDatasetName should not be empty or null";
    public static final String GDP500248_DETAILS = "GDP500248: Mapping targetDatasetName should not be empty or null";
    public static final String GDP500249_DETAILS = "GDP500249: No containers were found for given container name";
    public static final String GDP500250_DETAILS = "GDP500250: Unable to create dataflow due to some wrong property or some mandatory property missed";

    public static final String GDP500251_DETAILS = "GDP500251: Temporary datasource should not be empty or null";
    public static final String GDP400252_DETAILS = "GDP500252: Dataflow level type should not be empty or null";
    public static final String GDP500253_DETAILS = "GDP500253: DataFlow name already exist in the current list or deleted list";
    public static final String GDP500254_DETAILS = "GDP500254: In dataFlow name special characters are not allowed except underscore ( _ )";
    public static final String GDP400255_DETAILS = "GDP400255: Component dataset name should not be duplicate";
    public static final String GDP400256_DETAILS = "GDP400256: Component name should not be duplicate";

    public static final String GDP400257_DETAILS = "GDP400257: %s should not be empty or null";
    public static final String GDP400258_DETAILS = "GDP400258: Datasource profile key is not available for this user, add it in the profile section.";
    public static final String GDP400259_DETAILS = "GDP400259: Profile Key is not type of %s ";


    public static final String GDP500257_DETAILS = "GDP500257: No details were found for the %s with the given id: ";


    /****** License Model ******/

    public static final String GDP500356_MESSAGE = "Limit on users has been reached";
    public static final String GDP500357_DETAILS = "GDP500357: Reached the maximum number of users";
    public static final String GDP500358_MESSAGE = "No available licences";
    public static final String GDP500359_DETAILS = "GDP500359: Unable to add a Regular user as the user license limit is reached. Contact the administrator to upgrade the license.";
    public static final String GDP500360_DETAILS = "GDP500360: Unable to add a Read Only user as the user license limit is reached. Contact the administrator to upgrade the license.";
    public static final String GDP500361_DETAILS = "GDP500361: Number of active read-only users is greater than total number of read-only users specified in license";


    public static final String GDP500258_DETAILS = "GDP500258: DataRule componentName should not be empty or null";
    public static final String GDP500259_DETAILS = "GDP500259: DataRule datasetName should not be empty or null";
    public static final String GDP500260_DETAILS = "GDP500260: DataRule type should not be empty or null";
    public static final String GDP500261_DETAILS = "GDP500261: DataRule sourceDatasetName should not be empty or null";
    public static final String GDP500262_DETAILS = "GDP500262: Rules should not be empty or null";
    public static final String GDP500263_DETAILS = "GDP500263: Rules column name is not available in source dataset,please pass correct column name %s %s";
    public static final String GDP500264_DETAILS = "GDP500264: Unsupported operator, pass the correct operator.Expected operators are less than or equal/less than or equal %s %s";
    public static final String GDP500265_DETAILS = "GDP500265: Threshold should not be empty or null %s %s";
    public static final String GDP500266_DETAILS = "GDP500266: Percentage should not be empty or null %s %s";
    public static final String GDP500267_DETAILS = "GDP500267: Rule name should not be empty or null";
    public static final String GDP500268_DETAILS = "GDP500268: Rule type should not be empty or null";

    public static final String GDP500269_DETAILS = "GDP500269: Could not find environment value with logical name ";
    public static final String GDP500270_DETAILS = "GDP500270: Cluster logical name should not be empty";
    public static final String GDP500271_DETAILS = "GDP500271: Data source logical name should not be empty for component : {}";
    public static final String GDP500272_DETAILS = "GDP500272: In Component name special characters are not allowed except underscore ( _ )";
    public static final String GDP400273_DETAILS = "GDP400273: Dataflow or Dbflow level type is wrong, it should be dataflow or dbflow";
    public static final String GDP500274_DETAILS = "GDP500274: displayColumns should not be empty or null %s %s";
    public static final String GDP500275_DETAILS = "GDP500275: In Sql query ruleQuery should not be empty or null %s %s";
    public static final String GDP500276_DETAILS = "GDP500276: In Sql Expression ruleQueryCondition should not be empty or null %s %s";
    public static final String GDP500277_DETAILS = "GDP500277: Unable to create dataflow with file component";
    public static final String GDP500278_DETAILS = "GDP500278: Unable to get schema for file component";
    public static final String GDP500279_DETAILS = "GDP500279: Could not find the data source {datasourcename} in container";
    public static final String GDP500280_DETAILS = "GDP500280: PrimaryColumnName should not be empty or null %s %s";
    public static final String GDP500281_DETAILS = "GDP500281: ColumnName should not be empty or null %s %s";
    public static final String GDP500282_DETAILS = "GDP500282: Expression is incomplete, %s %s %s %s %s";
    public static final String GDP500283_DETAILS = "GDP500283: %s operator is not supporting %s %s";
    public static final String GDP500284_DETAILS = "GDP500284: Operator does not exist %s %s %s %s";
    public static final String GDP500285_DETAILS = "GDP500285: OperatorName should not be empty or null %s %s";
    public static final String GDP500286_DETAILS = "GDP500286: Unable to get operator %s %s";
    public static final String GDP500287_DETAILS = "GDP500287: Duplicate rule name not allowed, please try with different rule name %s %s";
    public static final String GDP500288_DETAILS = "GDP500288: No livy server found";
    public static final String GDP500289_DETAILS = "GDP500289: Unable to find engine name";
    public static final String GDP500290_DETAILS = "GDP500290 : Unable to create the dataflow or dbflow, Folder doesn't exist %s %s";
    public static final String GDP500291_DETAILS = "GDP500291 : Could not found dataflow with id : ";
    public static final String GDP500292_DETAILS = "GDP500292 : File component name could be not be empty ";

    public static final String GDP4040801_DETAILS = "GDP4040801: Transforms componentName should not be empty or null";
    public static final String GDP4040802_DETAILS = "GDP4040802: DatasetName should not be empty or null %s %s ";
    public static final String GDP4040803_DETAILS = "GDP4040803: Format should not be empty or null";
    public static final String GDP4040804_DETAILS = "GDP4040804: TableName should not be empty or null";
    public static final String GDP4040805_DETAILS = "GDP4040805: Query should not be empty or null";
    public static final String GDP4040806_DETAILS = "GDP4040806: Type should not be empty or null %s %s";

    public static final String GDP4040807_DETAILS = "GDP4040807: Incorrect dimension,please check and pass correct dimension %s %s";
    public static final String GDP4040808_DETAILS = "GDP4040808: Incorrect severity,please check and pass correct severity %s %s";
    public static final String GDP4040809_DETAILS = "GDP4040809: Incorrect successCriteria,please check and pass correct successCriteria %s %s";
    public static final String GDP4040810_DETAILS = "GDP4040810: sourceDataset should be used only once in datarule component ,sourceDataset with name %s is using in more than one data rule component";

    public static final String GDP4040811_DETAILS = "GDP4040811: ColumnMappings sourceColumnName should not be empty or null";
    public static final String GDP4040812_DETAILS = "GDP4040812: ColumnMappings targetColumnName should not be empty or null";
    public static final String GDP4040813_DETAILS = "GDP4040813: ColumnMappings sourceColumnName should not be duplicate ";
    public static final String GDP4040814_DETAILS = "GDP4040814: ColumnMappings targetColumnName should not be duplicate";
    public static final String GDP4040815_DETAILS = "GDP4040815: In source dataset, sourceColumnName does not exist that passed in ColumnMappings list,column name is %s ";
    public static final String GDP4040816_DETAILS = "GDP4040816: In target dataset, targetColumnName does not exist that passed in ColumnMappings list,column name is %s ";

    public static final String GDP4040817_DETAILS = "GDP4040817: Only numeric value allowed in threshold %s %s";
    public static final String GDP4040818_DETAILS = "GDP4040818: Only numeric value allowed in percentage %s %s";
    public static final String GDP4040819_DETAILS = "GDP4040819: Only numeric value allowed in numberOfRecords %s %s";
    public static final String GDP4040820_DETAILS = "GDP4040820: numberOfRecords should not be empty or null %s %s";


    public static final String GDP4040821_DETAILS = "GDP4040821: Dataflow name can not be more than 100 characters";
    public static final String GDP4040822_DETAILS = "GDP4040822: %s value should not be empty or null %s %s";
    public static final String GDP4040823_DETAILS = "GDP4040823: Expression is missing %s %s";
    public static final String GDP4040824_DETAILS = "GDP4040824: Incorrect expression name %s %s %s %s %s %s";

    public static final String GDP404825_DETAILS = "GDP404825: Format should not be empty or null %s %s";
    public static final String GDP4040826_DETAILS = "GDP4040826: ColumnMappings should not be empty or null %s %s";
    public static final String GDP4040827_DETAILS = "GDP4040827: Unsupported operator, pass the correct operator.Expected operators are greater than or equal/greater than or equal %s %s";
    public static final String GDP4040828_DETAILS = "GDP4040828: Unsupported rule query condition.Expected rule query are bad records or good records %s %s";

    public static final String GDP500293_DETAILS = "GDP500293: Error while running plugin";

    public static final String GDP4040829_DETAILS = "GDP4040829: Plugin parameters should not be empty or null %s %s";
    public static final String GDP4040830_DETAILS = "GDP4040830: Plugin parameter is missing, its required %s %s %s";
    public static final String GDP4040831_DETAILS = "GDP4040831: Plugin inputDataSets should not be empty or null %s %s";
    public static final String GDP4040832_DETAILS = "GDP4040832: Plugin inputDataSet is missing, its required %s %s %s";
    public static final String GDP4040833_DETAILS = "GDP4040833: Plugin outputDataSets should not be empty or null %s %s";
    public static final String GDP4040834_DETAILS = "GDP4040834: Plugin outputDataSet is missing, its required %s %s %s";
    public static final String GDP4040835_DETAILS = "GDP4040835: Plugin dataSources should not be empty or null %s %s";
    public static final String GDP4040836_DETAILS = "GDP4040836: Plugin dataSource is missing, its required %s %s %s";

    public static final String GDP4040837_DETAILS = "GDP4040837: Parameter value should not be empty or null %s %s";
    public static final String GDP4040838_DETAILS = "GDP4040838: Inputdataset value should not be empty or null %s %s";
    public static final String GDP4040839_DETAILS = "GDP4040839: Outputdataset value should not be empty or null %s %s";
    public static final String GDP4040840_DETAILS = "GDP4040840: Datasource value should not be empty or null %s %s";

    public static final String GDP404841_DETAILS = "GDP404841: OriginalSourceDataType or originalTargeteDataType should not be empty or null";
    public static final String GDP404842_DETAILS = "GDP404842: ConvertToSourceDataType or convertToTargetDataType should not be empty or null";
    public static final String GDP4040843_DETAILS = "GDP4040843 : Invalid component type %s";
    public static final String GDP4040844_DETAILS = "GDP4040844 : Invalid format, Expected format is Table or query %s %s";
    public static final String GDP4040845_DETAILS = "GDP4040845 : Columns should not be empty or null %s %s";
    public static final String GDP4040846_DETAILS = "GDP4040846: In datasetName only numbers or special characters are not allowed except underscore ( _ )";
    public static final String GDP4040847_DETAILS = "GDP4040847: No container available or don't have access of container with name %s";
    public static final String GDP4040848_DETAILS = "GDP4040848: Don't have authority to create component  %s";
    public static final String GDP4040849_DETAILS = "GDP4040849: DataRule sourceDatasetName does not exist %s %s";
    public static final String GDP4040850_DETAILS = "GDP4040850: Unsupported rule type %s %s";
    public static final String GDP4040851_DETAILS = "GDP4040851: Unsupported ignoreColumn value in columnMappings, expected values are true or false";
    public static final String GDP4040852_DETAILS = "GDP4040852: Unable to get authorities";
    public static final String GDP4040853_DETAILS = "GDP4040853: Dependency not allow for same component";
    public static final String GDP4040854_DETAILS = "GDP4040854: Parameter does not exist in plugin, pass correct parameterName %s %s";
    public static final String GDP4040855_DETAILS = "GDP4040855: InputDataset does not exist in plugin, pass correct inputDatasetName %s %s";
    public static final String GDP4040856_DETAILS = "GDP4040856: OutputDataset does not exist in plugin, pass correct outputDatasetName %s %s";
    public static final String GDP4040857_DETAILS = "GDP4040857: Datasource does not exist in plugin, pass correct dataSourceName %s %s";
    public static final String GDP4040858_DETAILS = "GDP4040858: Incorrect sourceDatasetName %s %s";
    public static final String GDP4040859_DETAILS = "GDP4040859: Incorrect targetDatasetName %s %s";
    public static final String GDP4040860_DETAILS = "GDP4040860: Incorrect dependency %s %s";

    public static final String GDP404861_DETAILS = "GDP404861 : Invalid executionOptions %s %s";
    public static final String GDP404862_DETAILS = "GDP404862 : In datasetName spaces are not allowed";

    public static final String GDP400861_DETAILS = "GDP400861: FileMetadata columnName should not be duplicate";
    public static final String GDP400862_DETAILS = "GDP400862: FileMetadata columnName should not be empty or null";
    public static final String GDP400863_DETAILS = "GDP400863: MappingBy value is wrong, supported values are name or order %s %s";
    public static final String GDP400864_DETAILS = "GDP400864: workSchemaName should not be empty or null";
    public static final String GDP400865_DETAILS = "GDP400865: dbflowName should not be empty or null";
    public static final String GDP400866_DETAILS = "GDP400866: Invalid dataSetType, supported types are table or view";
    public static final String GDP400867_DETAILS = "GDP400867: Columns list should not be empty or null";
    public static final String GDP400868_DETAILS = "GDP400868: Dependency is missing %s %s";
    public static final String GDP400869_DETAILS = "GDP400869: Unable to find workschema in given container";
    public static final String GDP400872_DETAILS = "GDP400872: Invalid format, supported format are table or query";
    public static final String GDP400873_DETAILS = "GDP400873: DatasetName and query tableName should not be same";
    public static final String GDP400874_DETAILS = "GDP400874: DatasetName and tableName should not be same";


    public static final String GDP400870_DETAILS = "GDP400870: error while updating the livyProperites";

    public static final String GDP400871_DETAILS = "GDP400871: Invalid deleteWorkschemaTable value, expected values are enabled or disabled";
    public static final String GDP400877_DETAILS = "GDP400877: Table or view already exist in workschema with datasetname %s";
    public static final String GDP400886_DETAILS = "GDP400886: No datasource found with given name %s";
    public static final String GDP400887_DETAILS = "GDP400887: Datasource does not exist";
    public static final String GDP400888_DETAILS = "GDP400888: Unable to find %s with %s";
    public static final String GDP400889_DETAILS = "GDP400889: Problem while getting %s with %s";
    public static final String GDP400890_DETAILS = "GDP400890: Environment is not found";
    public static final String GDP400891_DETAILS = "GDP400891: Unable to get Environment";
    public static final String GDP400893_DETAILS = "GDP400893: goodBadDataSetName should not be null or empty";
    public static final String GDP400894_DETAILS = "GDP400894: keyColumnName should not be null or empty";
    public static final String GDP400895_DETAILS = "GDP400895: enableGoodBadDatasets value should  be Enabled or Disabled %s";
    public static final String GDP400896_DETAILS = "GDP400896: In keyColumnName at least one alphabet, numbers will allowed and special characters are not allowed except underscore ( _ )";
    public static final String GDP400897_DETAILS = "GDP400897: In DataSetName at least one alphabet, numbers will allowed and special characters are not allowed except underscore ( _ )";
    public static final String GDP400898_DETAILS = "GDP400898: Incorrect InputDatasetValue %s, pass correct inputDatasetValue in %s";
    public static final String GDP400899_DETAILS = "GDP400899: Invalid ExcludeInNotification value,expected values are enabled or disabled";

    public static final String GDP400920_DETAILS = "GDP400920: Unsupported convertTo datatype %s %s";
    public static final String GDP400921_DETAILS = "GDP400921: Source convertTo datatype should not be empty or null %s %s ";
    public static final String GDP400922_DETAILS = "GDP400922: Target convertTo datatype should not be empty or null %s %s ";
    public static final String GDP400923_DETAILS = "GDP400923: Problem while setting convertTo datatype";
    public static final String GDP400924_DETAILS = "GDP400924: Problem while setting custom expression";
    public static final String GDP400925_DETAILS = "GDP400925: Source and Target datatype mismatched %s %s ";


    /*************reports************/
    public static final String GDP500400_DETAILS = "GDP500400: Unable to find the widget: ";
    public static final String GDP500401_DETAILS = "GDP500401: Invalid widgetId or pageId: ";
    public static final String GDP500402_DETAILS = "GDP500402: Unable to find widget details: ";

    public static final String GDP500403_DETAILS = "GDP500403: Unable to find the featurePage: ";
    public static final String GDP500404_DETAILS = "GDP500404: Invalid featurePageId or objectId: ";
    public static final String GDP500405_DETAILS = "GDP500405: Unable to find featurePage details: ";
    public static final String GDP500410_DETAILS = "GDP500410: Invalid isShared or isDeleted values: ";
    public static final String GDP500411_DETAILS = "GDP500411: Unable to Link or Un-link widget details: ";
    public static final String GDP500415_DETAILS = "GDP500415: Unable to Export Report details ";
    public static final String GDP500416_DETAILS = "GDP500416: Unable to Import Report details ";
    public static final String GDP500417_DETAILS = "GDP500417: Unable to find the reportId in the conatiner ";
    public static final String GDP500418_DETAILS = "GDP500418: Invalid reportId ";
    public static final String GDP500419_DETAILS = "GDP500419: Invalid Widget details for  : %s ";

    public static final String GDP400875_DETAILS = "GDP400875: Unable to import %s as id exists with the %s id";
    public static final String GDP400876_DETAILS = "GDP400876: Problem while generating externalization message";

    public static final String GDP400878_DETAILS = "GDP400878: Problem while getting engine details";

    public static final String GDP402000_DETAILS = "GDP402000_DETAILS: Unable to retrieve pipelines that contain iteration tasks.";
    public static final String GDP402001_DETAILS = "GDP402001_DETAILS: Unable to retrieve the latest job iteration task details in the pipeline :%s";
    public static final String GDP402002_DETAILS = "GDP402002_DETAILS: Unable to retrieve iteration task details in jobId :%s.";
    public static final String GDP402003_DETAILS = "GDP402003_DETAILS: Unable to retrieve  iterations task details for jobId :%s and parentTaskId :%s .";

    /**************Tags****************/
    public static final String GDP400879_DETAILS = "GDP400879: Unable to find tag";
    public static final String GDP400880_DETAILS = "GDP400880: Problem while adding the tag";
    public static final String GDP400881_DETAILS = "GDP400881: Problem while retrieving tags";
    public static final String GDP400882_DETAILS = "GDP400882: Tag already exists with given name";
    public static final String GDP400883_DETAILS = "GDP400883: Problem while mapping tags";
    public static final String GDP400884_DETAILS = "GDP400884: Problem while unmapping tags";
    public static final String GDP400885_DETAILS = "GDP400885: Problem while getting mapped tags";
    public static final String GDP400892_DETAILS = "GDP400892: Unable to check tag existence";


    /********************Purge*********************/
    public static final String GDP400901_DETAILS = "GDP400901 : Problem while purge dataCompareDataset";

    public static final String GDP400904_DETAILS = "GDP400904 : Problem while purge dataflowSessionLogs";

    public static final String GDP400905_MESSAGE = "Unable to purge dataflowSessionLogs";

    public static final String GDP400906_MESSAGE = "Unable to delete dataflow component";
    public static final String GDP400930_MESSAGE = "Unable to purge multiDataCompare";
    public static final String GDP400931_DETAILS = "GDP400931 : Problem while purge multiDataCompareDataset";


    /******************** GIT ****************************/
    public static final String GDP500700_MESSAGE = "Unable to process the request.";
    public static final String GDP500700_DETAILS = "GDP500700: Unable to get list of branches";
    public static final String GDP500701_DETAILS = "GDP500701: Problem while saving container branch mapping details.";
    public static final String GDP500702_DETAILS = "GDP500702: Problem while getting container branch mapping details.";
    public static final String GDP500703_DETAILS = "GDP500703: Invalid access token for Git Integration, please enter valid token in user wallet section of profile page or integration menu of configure section.";
    public static final String GDP500704_DETAILS = "GDP500704: Problem while getting Git Integration token details.";
    public static final String GDP500705_DETAILS = "GDP500705: Please enter valid user credentials in user wallet section of profile page or integration menu of configure section.";
    public static final String GDP500707_DETAILS = "GDP500707: Problem in setting HttpHeader. Please check the details given in user wallet section of profile page or Git integration menu of configure section.";
    public static final String GDP500708_DETAILS = "GDP500708: Problem while decoding data";
    public static final String GDP500709_DETAILS = "GDP500709: Problem while fetching datas from database.";
    public static final String GDP500710_DETAILS = "GDP500709: Problem while deleting container branch mapping details.";
    public static final String GDP500712_DETAILS = "GDP500712: Problem while saving the staging details after successful commit.";
    public static final String GDP500713_DETAILS = "GDP500713: Problem while saving gitstaging details.";
    public static final String GDP500714_DETAILS = "GDP500714: Problem while saving details in database.";
    public static final String GDP500715_DETAILS = "GDP500715: Problem while generating staging data.";
    public static final String GDP500716_DETAILS = "GDP500716: Problem while importing dataflow.";
    public static final String GDP500717_DETAILS = "GDP500717: Problem while saving dataflow.";
    public static final String GDP500718_DETAILS = "GDP500718: Problem while updating dataflow.";
    public static final String GDP500719_DETAILS = "GDP500719: Problem while discarding %s.";
    public static final String GDP500723_DETAILS = "GDP500723: Problem while encoding data.";
    public static final String GDP500724_DETAILS = "GDP500724: Container is not mapped to any branch in git repository";
    public static final String GDP500725_DETAILS = "GDP500725: No file is selected for this commit.";
    public static final String GDP500726_DETAILS = "GDP500726: There is no local change to discard or dataflow is not yet committed.";
    public static final String GDP500727_DETAILS = "GDP500727: There is no staging detail for this dataflow.";
    public static final String GDP500728_DETAILS = "GDP500728: Please enter valid email id in user configure page.";
    public static final String GDP500729_DETAILS = "GDP500729: Please enter valid details in git configure page.";
    public static final String GDP500730_DETAILS = "GDP500730: Dataflow details are already synchronized with git staging details.";
    public static final String GDP500731_DETAILS = "GDP500731: unable to synchronize with git.";
    public static final String GDP500732_DETAILS = "GDP500732: Error while fetching container feature details.";
    public static final String GDP500734_DETAILS = "GDP500734: Please enter authorized user name and token for git in user wallet section of profile page or integration menu of configure section.";
    public static final String GDP500735_DETAILS = "GDP500735: Please click on Sync button to map with git staging";
    public static final String GDP500736_DETAILS = "GDP500736: No Staging detail present for the given StagingId";
    public static final String GDP500737_DETAILS = "GDP500737: No pipeline is selected for commit";
    public static final String GDP500738_MESSAGE = "GDP500738: Unable to discard pipeline";
    public static final String GDP500739_DETAILS = "GDP500739: Problem while discarding pipeline";
    public static final String GDP500740_DETAILS = "GDP500740: Unable to commit pipeline to git repository";
    public static final String GDP500741_DETAILS = "GDP500741: Please enter valid token of git";
    public static final String GDP500742_DETAILS = "GDP500742: DB Flow details are already synchronized with git staging details.";
    public static final String GDP500743_DETAILS = "GDP500743: Pipeline details are already synchronized with git staging details.";
    public static final String GDP500744_DETAILS = "GDP500744: Problem while getting latest commit sha.";
    public static final String GDP500745_DETAILS = "GDP500745: Problem while getting latest differences files from git.";
    public static final String GDP500746_DETAILS = "GDP500746: Unable to retrieve commit history.";
    public static final String GDP500747_DETAILS = "GDP500747: You have uncommited changes. Either commit or discard the changes.";
    public static final String GDP500748_DETAILS = "GDP500748: Status type not found";
    public static final String GDP500749_DETAILS = "GDP500749: Datamodel details are already synchronized with git staging details.";
    public static final String GDP500750_DETAILS = "GDP500751: Please try again later.";
    public static final String GDP500751_MESSAGE = "GIT OPERATION IN PROGRESS";
    public static final String GDP500752_DETAILS = "GDP500752: Unable to pull latest changes from remote for %s.";
    public static final String GDP500753_DETAILS = "GDP500753: Please click on Sync button before you commit.";
    public static final String GDP500754_DETAILS = "GDP500754: Problem while deleting files from git conflict table.";
    public static final String GDP500755_DETAILS = "GDP500755: Files are already synchronized with git staging details.";
    public static final String GDP500756_DETAILS = "GDP500756: Problem in committing file to git repository.";
    public static final String GDP500757_DETAILS = "GDP500757:  %s service is down to perform git operations.";
    public static final String GDP500758_DETAILS = "GDP500758: File size for commit request exceeds the maximum limit (20MB). Please deselect some files or identify the large file(s) and commit them separately.";
    public static final String GDP500789_MESSAGE = "Git integration test failed";
    public static final String GDP500790_DETAILS = "GDP500790: Problem while validating Git integration configuration details.";
    public static final String GDP500791_DETAILS = "GDP500790: Custom field name already exists.";
    /******************** Livy ****************************/
    public static final String GDP500803_DETAILS = "GDP500803: Engine is down or not reachable currently.";

    /******************** Engine session Logs ****************************/
    public static final String GDP500800_MESSAGE = "Unable to view session log";
    public static final String GDP500804_DETAILS = "GDP500804: Problem while retreiving the engine session logs.";
    public static final String GDP500805_DETAILS = "GDP500805: Problem while saving the engine session logs.";
    public static final String GDP500806_DETAILS = "GDP500806: Problem while fetching the engine session logs from database.";
    public static final String GDP500809_DETAILS = "GDP500809: Collecting logs from session, please wait for 20 seconds and try again.";
    public static final String GDP500810_DETAILS = "GDP500810: Logs are not available due to session expired or dead.";
    public static final String GDP500812_DETAILS = "GDP500812: The Engine log has been purged for the requested dataflow execution.";

    public static final String GDP500807_DETAILS = "GDP500807: Problem while testing repository connection";

    public static final String GDP500808_DETAILS = "GDP500808: Problem while retreiving the dataops external url value";

    /****************SessionPool**********/
    public static final String GDP400900_MESSAGE = "Session pool not configured";
    public static final String GDP400902_DETAILS = "GDP400902: Problem while configure session pool";
    public static final String GDP400903_DETAILS = "GDP400903: Please configure the session pool in configuration screen";

    /****************DataCompare Report **********/
    public static final String GDP500811_DETAILS = "GDP500811: Unable to download the %s report. Data might have purged or not available";

    public static final String GDP400904_MESSAGE = "Unable to import or copy";
    public static final String GDP400905_DETAILS = "GDP400905: Problem while importing or copying the %s ";
    public static final String GDP400906_DETAILS = "GDP400906: Problem while import validating %s ";
    public static final String GDP400907_MESSAGE = "Unable to export";
    public static final String GDP400908_DETAILS = "GDP400908: Problem while export %s ";
    public static final String GDP400909_DETAILS = "GDP400909: Problem while overwrite %s ";

    public static final String GDP400910_DETAILS = "GDP400910: Problem while setting componentMessage";

    public static final String GDP400911_DETAILS = "GDP400911: Problem while retrieving %s details";


    /******************************************** Teams ***********************************************/

    public static final String GDP700101_DETAILS = "GDP700101: Unable to save/update channel";

    public static final String GDP700102_DETAILS = "GDP700102: Unable to retrieve channel";

    public static final String GDP700103_DETAILS = "GDP700103: Unable to delete channel";

    public static final String GDP700104_DETAILS = "GDP700104: channelId cannot be null or empty";


    /**************************************** CopyDataFlowOrDbFlow ********************************/


    public static final String GDP405001_DETAILS = "GDP405001: Problem while copy dataflow/DBFlow for the give dataflow/DBFlow Id";

    public static final String GDP405002_MESSAGE = "Unable to copy dataflow/DBFlow";

    public static final String GDP405003_DETAILS = "GDP405003: Unable to get the analysisDetails for the given dataflow/DBFlow Id";

    public static final String GDP405004_MESSAGE = "Unable to get the analysisDetails";

    public static final String GDP405005_DETAILS = "GDP405003: Problem while saving the LivySession";

    public static final String GDP405006_MESSAGE = "Unable to save livySession";

    public static final String GDP405007_MESSAGE = "GDP405007 : Problem while validating and setting dataframeId for components in dataflow or DB Flow";

    /**************************************** Download Reports ********************************/
    public static final String GDP500813_DETAILS = "GDP500813: Problem while generating Excel sheet for column wise mismatches";

    /******************Engine resource allocation*************/

    public static final String GDP407000_MESSAGE = "Unable to estimate resource";
    public static final String GDP407001_DETAILS = "GDP407001 : Problem while calculate engine resource";
    public static final String GDP407002_DETAILS = "GDP407002 : Problem while validate engine resource";
    public static final String GDP407003_DETAILS = "GDP407003 : No previous run available to estimate resource";

    public static final String GDP500814_DETAILS = "GDP500814: Problem while generating dataset id";
    public static final String GDP500815_DETAILS = "GDP500815: Problem while generating scriptId";

    /***************** pipeline permanent delete and restore **********/
    public static final String GDP407001_MESSAGE = "Unable to delete pipeline";
    public static final String GDP500820_DETAILS = "GDP500820: Problem while deleting  pipeline";

    public static final String GDP407002_MESSAGE = "Unable to restore pipeline";
    public static final String GDP500830_DETAILS = "GDP500830: Problem while restoring pipeline";

    //MultiData compare
    public static final String GDP500600_DETAILS = "GDP500600: Problem while getting dataframes";
    public static final String GDP500601_DETAILS = "GDP500601: Problem while getting multiple data compare mappings";
    public static final String GDP500602_DETAILS = "GDP500602: Problem while saving multiple data compare component";

    //sessionPool
    public static final String GDP500603_DETAILS = "GDP500603: Error occured while updating sessionpool status";
    public static final String GDP500605_DETAILS = "GDP500605: Invalid input for updating session pool status";

    public static final String GDP500619_DETAILS = "GDP500619: Please make sure to select the dataflow which has atleast one regression component for benchmark run";
    public static final String GDP500620_DETAILS = "GDP500620: Engine logs are not supported for Azure Databricks cluster";
    public static final String GDP500802_MESSAGE = "Unsupported";
    public static final String GDP4040897_DETAILS = "GDP4040897: Unable to save cluster status in database";
    public static final String GDP4040898_DETAILS = "GDP4040898: An error occurred while retrieving the Databricks clusters";
    public static final String GDP4040899_DETAILS = "GDP4040899: Unable to save Databricks clusters";

    //Bad Data Rule Tracking
    public static final String GDP500920_DETAILS = "GDP500920: Unable insert rule tracking meta data : ";
    public static final String GDP500921_DETAILS = "GDP500921: Unable to Create the rule tracking meta data table";
    public static final String GDP500922_DETAILS = "GDP500922: Unable to create rule tracking meta data table constraint";
    public static final String GDP500923_DETAILS = "GDP500923: Rule tracking metadata save failed due to : ";
    public static final String GDP500925_DETAILS = "GDP500923: Unable to remove rule tracking metadata due to : ";


    public static final String GDP405009_DETAILS = "GDP405009: Error occurred while retrieving filter differences by Component Run ID";
    public static final String GDP405010_DETAILS = "GDP405010: Error occurred while retrieving filter differences";
    public static final String GDP405012_DETAILS = "GDP405012: Error occurred while retrieving AI ReportSummaryDifferences";

    //StressTestPlan
    public static final String GDP500501_MESSAGE = "Unable to save stressTestPlan";
    public static final String GDP500502_MESSAGE = "Unable to get stress test plan details";
    public static final String GDP500503_MESSAGE = "Unable to get getStressTestPlans ";
    public static final String GDP500504_MESSAGE = "Page entity is null";
    public static final String GDP500504_DETAILS = "GDP500504: No data found in given pageKey";
    public static final String GDP500505_MESSAGE = "Internal Server Error";
    public static final String GDP500506_MESSAGE = "Unable to save test plan reports";
    public static final String GDP500507_MESSAGE = "Unable to update bookmarkText";
    public static final String GDP500508_MESSAGE = "Unable to retrieve stress test plan options";
    public static final String GDP500509_MESSAGE = "Unable to update dataset";
    public static final String GDP500510_MESSAGE = "Unable to update stress test plan";
    public static final String GDP500511_MESSAGE = "Unable to delete stress test plan id";
    public static final String GDP500512_MESSAGE = "Unable to delete page";
    // BiDevops
    public static final String GDP500803_MESSAGE = "Unable to save/update reports";
    public static final String GDP500623_DETAILS = "GDP500623: Problem while saving reports";
    public static final String GDP500624_DETAILS = "GDP500624: Report name or reportId should not be empty or null";
    public static final String GDP500804_MESSAGE = "Unable to retrieve workspace details";
    public static final String GDP500625_DETAILS = "GDP500625: Problem while fetching workspace details";
    public static final String GDP500805_MESSAGE = "Unable to retrieve reports details";
    public static final String GDP500626_DETAILS = "GDP500626: Problem while fetching reports information";
    public static final String GDP500806_MESSAGE = "Unable to delete report";
    public static final String GDP500627_DETAILS = "GDP500627: Problem while deleting reports details";
    public static final String GDP500807_MESSAGE = "Unable to save/update pipeline mappings";
    public static final String GDP500628_DETAILS = "GDP500628: Problem while saving pipeline mapping details";
    public static final String GDP500808_MESSAGE = "Unable to delete";
    public static final String GDP500629_DETAILS = "GDP500629: Problem while deleting pipeline mapping";
    public static final String GDP500809_MESSAGE = "Unable to retrieve mapped pipelines";
    public static final String GDP500630_DETAILS = "GDP500630: Problem while fetching mapped pipelines";
    public static final String GDP500810_MESSAGE = "Unable to retrieve";
    public static final String GDP500811_MESSAGE = "Unable to save/update";
    public static final String GDP500631_DETAILS = "GDP500631: Problem while fetching datasets information";
    public static final String GDP500632_DETAILS = "GDP500632: Problem while constructing dataset data";
    public static final String GDP500633_DETAILS = "GDP500633: Problem while fetching filtered datasets data";
    public static final String GDP500634_DETAILS = "GDP500634: Problem while saving filtered dataset";
    public static final String GDP500635_DETAILS = "GDP500635: Problem while fetching page filtere values";
    public static final String GDP500636_DETAILS = "GDP500636: Problem while saving filtered pages";
    public static final String GDP500637_DETAILS = "GDP500637: Problem while saving pages";
    public static final String GDP500638_DETAILS = "GDP500638: Problem while fetching page names";
    public static final String GDP500639_DETAILS = "GDP500639: Problem while fetching pages information";
    public static final String GDP500640_DETAILS = "GDP500640: Problem while deleting dataset details";
    public static final String GDP500641_DETAILS = "GDP500641: Problem while deleting page details";
    public static final String GDP500642_DETAILS = "GDP500642: Problem while capturing bookmark";
    public static final String GDP500643_DETAILS = "GDP500643: Problem while updating dataset name";
    public static final String GDP500644_DETAILS = "GDP500644: Problem while generating filter combinations";
    public static final String GDP500645_DETAILS = "GDP500645: Problem while deleting filters information";
    public static final String GDP500646_DETAILS = "GDP500646: Unable to sync reports";
    public static final String GDP500647_DETAILS = "GDP500647: Problem while deleting filter values";
    public static final String GDP500648_DETAILS = "GDP500648: Problem while fetching  filter values";
    public static final String GDP500649_DETAILS = "GDP500649: Problem while updating filter dataset values";
    public static final String GDP500651_DETAILS = "GDP500651: Problem while fetching  filters";

    //DAXQComponent
    public static final String GDP405006_DETAILS = "GDP405006: PowerBi Dataset name cannot be empty";
    public static final String GDP405007_DETAILS = "GDP405007: PowerBi Dataset Id cannot be empty";
    public static final String GDP500650_DETAILS = "GDP500650: Problem while saving DAXQ statements";

    //BiPageExclusion
    public static final String GDP500901_DETAILS = "GDP500901: No logs available with given pageId %s";
    public static final String GDP500902_DETAILS = "GDP500902: Problem while retrieving logs";
    public static final String GDP500903_DETAILS = "GDP500903: Unable to get pdf report with given pageId %s";
    public static final String GDP500904_DETAILS = "GDP500904: Problem while retrieving pdf report";
    public static final String GDP500905_DETAILS = "GDP500905: Unable to save page exclusion reports check logs for more information";
    public static final String GDP500906_DETAILS = "GDP500906: Problem while retrieve report status with given pageId %s";
    public static final String GDP500907_DETAILS = "GDP500907: Problem while saving page exclusion statements";

    public static final String GDP500908_DETAILS = "GDP500908: Unable to get the dataSourceName";
    public static final String GDP500909_DETAILS = "GDP500909: Problem while getting DataSource details";
    public static final String GDP500930_DETAILS = "GDP500930: Unable to save Bi statements";
    public static final String GDP500931_DETAILS = "GDP500931: Problem while saving page exclusion details";


    public static final String GDP405008_DETAILS = "GDP405008: Problem while validating dataset name";
    public static final String GDP405011_DETAILS = "GDP405011: Problem while validating source or target query";


    //OBIEE
    public static final String GDP409001_DETAILS = "GDP409001: Oracle analytics URL must not be empty or null";
    public static final String GDP409002_DETAILS = "GDP409002: additionalUser should not be empty or null";
    public static final String GDP409003_DETAILS = "GDP409003: problem while setting properties for oracle analytics";
    public static final String GDP409004_DETAILS = "GDP409004: sessionId should not be empty or null";
    public static final String GDP409005_MESSAGE = "GDP409005: OBIEE sign in failed";
    public static final String GDP409006_DETAILS = "GDP409006: error occurred while setting obiee details ";
    public static final String GDP409007_MESSAGE = "GDP409007: error occurred while getting Items from catalog";
    public static final String GDP409008_DETAILS = "GDP409008: error occurred while updating the metadata status";
    public static final String GDP409009_DETAILS = "GDP409009: unable to get obiee report";
    public static final String GDP409010_DETAILS = "GDP409010: problem while retrieving obiee folders";
    public static final String GDP409011_DETAILS = "GDP409011: problem while retrieving obiee dashboards";
    public static final String GDP409012_DETAILS = "GDP409012: problem while retrieving obiee parent folders";


    //GENAI
    public static final String GDP501201_MESSAGE = "An error occurred while generating the query.";
    public static final String GDP501201_DETAILS = "GDP501201: Please check your input parameters and try again.";
    public static final String GDP501202_MESSAGE = "Failed to update mapping details.";
    public static final String GDP501202_DETAILS = "GDP501202: Please verify the input data and try again.";
    public static final String GDP501203_MESSAGE = "Failed to delete mapping details.";
    public static final String GDP501203_DETAILS = "GDP501203: The specified mapping detail ID does not exist.";
    public static final String GDP501204_MESSAGE = "Failed to retrieve mapping details.";
    public static final String GDP501204_DETAILS = "GDP501204: Mapping queries not found for the specified mapping ID.";
    public static final String GDP501701_DETAILS = "GDP501701: Access denied due to invalid API key. Make sure to provide a valid API key for an active subscription.";
    public static final String GDP501702_DETAILS = "GDP501702: Access denied due to invalid subscription key or wrong API endpoint.Make sure to provide a valid key for an active subscription and use a correct regional API endpoint for your resource.";
    public static final String GDP501703_DETAILS = "GDP501703: Key credentials require HTTPS to prevent leaking the key.";
    public static final String GDP501704_DETAILS = "GDP501704: The API deployment for this resource does not exist. If you created the deployment within the last 5 minutes, please wait a moment and try again.";

    public static final String GDP5000201_MESSAGE = "Mapping detail request cannot be null";
    public static final String GDP5000202_MESSAGE = "MappingDetail not found for the given Id";
    public static final String GDP5000203_MESSAGE = "Unable to save/update mapping details";
    public static final String GDP5000204_MESSAGE = "Mapping details saved successfully";
    public static final String GDP5000205_MESSAGE = "MappingDetail has been deleted successfully.";
    public static final String GDP5000206_MESSAGE = "Mapping has been deleted successfully.";

    public static final String GDP400404_DETAILS = "GDP400404 : Failed to create statements for cross bi component";
    public static final String GDP400405_DETAILS = "GDP400405 : Unable to get the source report";
    public static final String GDP400406_DETAILS = "GDP400406 : Unable to get the target report";
    public static final String GDP400407_DETAILS = "GDP400407 : Problem while retrieving report summary differences";
    public static final String GDP400408_DETAILS = "GDP400408 : Error occurred while retrieving cross bi filter differences";
    public static final String GDP400409_DETAILS = "GDP400409 : Problem while constructing bi datasource";
    public static final String GDP400410_DETAILS = "GDP400410 : Problem while saving the time variation details";
    public static final String GDP400411_DETAILS = "GDP400411 : Problem while updating the component run status";
    public static final String GDP400412_DETAILS = "GDP400412 : Problem while setting data source details for cross bi";
    public static final String GDP400413_DETAILS = "GDP400413 : Problem while calculating run duration";

    public static final String GDP501705_DETAILS = "GDP501705: Please provide the AI details in integration section of configure menu to connect to it..";
    public static final String GDP501706_DETAILS = "GDP501706: Error generating queries";
    public static final String GDP501707_DETAILS = "GDP501707: Error occurred while fetching mappings.";

    //900 status messages related to Sessions

    public static final String GDP900001_MESSAGE = "Session not allow to create";
    public static final String GDP900001_DETAILS = "GDP900001: Engine is not able to create the session as maximum active sessions in use";
    public static final String GDP900002_DETAILS = "GDP900002: Problem while checking active sessions";

    //Dynamic parameters
    public static final String GDP404844_DETAILS = "GDP404844: Dynamic parameter query returning more than one result, parameter name is %s";
    public static final String GDP404845_DETAILS = "GDP404845: Problem while setting dynamic parameters";
    public static final String GDP404846_DETAILS = "GDP404846: Problem while setting pipeline parameters";
    public static final String GDP404847_DETAILS = "GDP404847: Dynamic parameter query returning empty result, parameter name is %s";
    public static final String GDP404848_DETAILS = "GDP404848: Problem while setting parameters";

    public static final String ERROR_MESSAGE = "ERROR";
    public static final String GDP404955_DETAILS = "GDP404955: Selected datamodels do not exist,please select a different one.";
    public static final String GDP404956_DETAILS = "GDP404956: Datasource have been deleted for the selected datamodels";
    public static final String GDP404957_DETAILS = "GDP404957: Selected data model got deleted for selected mapping.";
    public static final String GDP404962_DETAILS = "GDP404962: Table have been deleted for the selected datamodels";

    public static final String GDP404959_MESSAGE = "Connection Error";
    public static final String GDP404959_DETAILS = "GDP404959: Couldn't connect to the repository at this moment. Please try again later or contact the system administrator.";
    public static final String GDP404960_DETAILS = "GDP404960: Unable to establish a connection to the repository at this time. Please check your connection settings and try again later.";
    public static final String GDP404961_DETAILS = "GDP404961: The schema/table you requested does not exist in our database. Please verify the name and try again.";


    /******************Externalization*************/
    public static final String GDP408000_DETAILS = "GDP408000: Parameter type cannot be empty";
    public static final String GDP408001_DETAILS = "GDP408001: Parameter name cannot be empty";
    public static final String GDP408002_DETAILS = "GDP408002: Interactive mode value cannot be empty for type static";
    public static final String GDP408003_DETAILS = "GDP408003: Batch mode value cannot be empty for type static";
    public static final String GDP408004_DETAILS = "GDP408004: Datasource name cannot be empty for type dynamic";
    public static final String GDP408005_DETAILS = "GDP408005: Query cannot be empty for type dynamic";

    public static final String GDP401905_DETAILS = "GDP401905: Your password has expired. Please reset your password to continue using your account.";

    public static final int METHOD_NOT_FOUND = 405;
    public static final int UNSUPPORTED_MEDIA_TYPE = 415;
    public static final String GDP405100_MESSAGE = "Method Not Allowed";
    public static final String GDP415100_MESSAGE = "Unsupported Media Type";
    public static final String GDP500999_DETAILS = "GDP500999: Repository tables/columns are not in sync with the app version, please upgrade the repository.";
    public static final String GDP500977_DETAILS = "GDP500977 : Something went wrong. Please try again later.";
    public static final String GDP500652_DETAILS = "GDP500652 : Problem while importing filter dataset";
    public static final String GDP500653_DETAILS = "GDP500653 : Problem while retrieving counts of filter datasets and stress test plans.";

}
