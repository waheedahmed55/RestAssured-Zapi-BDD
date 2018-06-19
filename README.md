![alt text](https://github.com/rest-assured/rest-assured.github.io/raw/master/img/logo-transparent.png "Logo") ![](https://github.com/rest-assured/rest-assured.github.io/raw/master/img/name-transparent.png "Title")

# RestAssured - Zapi - BDD Framework

End to end testing framework:
* Uses RestAssured to make API requests and retrieve API responses from endpoints on sample software under test.
* Also uses RestAssured in combination with TestNG to make API calls to Zephyr for JIRA API (ZAPI) in order to generate a report of end to end test execution pass and failure results.
* Each end to end test class implemented in the sample project may be selectively marked as linked to a Zephyr for JIRA test case ticket.
* Each runtime execution of a end to end test method implemented in the sample project will appear as a Zephyr test execution of a test case ticket, when the specific test method is part of a test class selected to be linked to a JIRA test case.
* Tests can be run by running `mvn clean install` on a command prompt from within the project folder. This allows for the suite of end to end tests to be run in an automated continuous integration pipeline.
* Tests may also be run through the TestNG Eclipse IDE plug-in. This enables for more rapid end to end test case development and execution.
* Each test should be designed with the intention to create test data, clean up test data and run independently to allow for parallel execution.
* Continuous effort should be made to ensure test data is created and cleaned up in the backend database of the software under test without the use of the endpoints of the software under test. This is achieved through the implementation of utility classes and methods.
* Methods for test verification and assertions are also created in the project to promote code reuse and reduce code duplication. 

Integration of the following software systems:
* Atlassian JIRA - Issue and bug tracking
* Zephyr for JIRA with ZAPI included - test management solution inside JIRA with API providing access to test assets - https://github.com/zfjdeveloper/zapi-docs
* Software application under test - set of RESTful / HTTP endpoints with backend database

Using the following tools and Java libraries:
* Eclipse IDE
* Java Development Kit 8 (JDK)
* Apache Maven 3.x - including build plugins
* TestNG - Java testing framework
* RestAssured - Java DSL for testing of REST services - including hamcrest https://github.com/rest-assured/rest-assured
* Oracle JDBC driver

# Getting Started

## Download and install JDK 8

* Go to the Oracle website to download the JDK. At time of writing instructions were available here on the Oracle website: https://docs.oracle.com/javase/8/docs/technotes/guides/install/install_overview.html
* Set the `JAVA_HOME` environment variable to point to the folder the JDK was installed at. For example in Windows running the command `echo %JAVAHOME%` may return `C:\Program Files\Java\jdk1.8.0_45`

## Download, extract and install Apache Maven 3.x

* Steps to download Apache Maven may be found here: https://maven.apache.org/download.cgi
* Steps to install Apache Maven may be found here:
https://maven.apache.org/install.html

## Download and Install Eclipse

* Latest version of Eclipse may be downloaded here: http://www.eclipse.org/downloads/
* Configure Eclipse to use JDK 8 as an Installed JRE
* Configure Eclipse to use above external Maven installation
* Install TestNG Eclipse plug-in https://testng.org/doc/eclipse.html

## Download the source code and compile the project

* Download the source code and import into Eclipse IDE
* Install the Oracle JDBC driver to local maven repository: `mvn install:install-file -Dfile=ojdbc6.jar -DgroupId=oracle -DartifactId=ojdbc6 -Dversion=11.2.0.3 -Dpackaging=jar`
* Compile the project using the command: `mvn clean test-compile`

# Code structure

The code base features the following types of classes by package

* `com.restassured.common` Java interfaces and classes containing common methods and constants available to use across many other classes
* `com.restassured.common.util` Contains Java 8 'functional interface' ExceptionalRunnable which defines a method used to compare a ResultSet object to a Java POJO using assertions. This package also contains utilities to generate a random string and obtain an Oracle database connection
* `com.restassured.pojo` Contains a POJO class, a class following the Builder pattern and a Java interface
* Each of these packages contain a test base class for a REST endpoint and a set of TestNG test case classes
    * `com.restassured.create.POST`
    * `com.restassured.delete.DELETE`
    * `com.restassured.getAll.GET`
    * `com.restassured.update.PUT`
    * `com.restassured.validate.POST`
* `com.restassured.util` super base class for all TestNG test cases and common utility methods used across most test cases
* `com.restassured.zapi` Contains the base class `ZapiTestBase` and utility class``ZapiTestCaseCreator` used to capture TestNG test results into JIRA Zephyr test cases through ZAPI. Also contains class 

```
│   ojdbc6.jar
│   pom.xml
│   README.md
│
├───src
│   ├───main
│   │   └───java
│   │       └───com
│   │           └───restassured
│   │               ├───common
│   │               │   │   CommonAdd.java
│   │               │   │   CommonRecord.java
│   │               │   │   EndpointConstants.java
│   │               │   │
│   │               │   └───util
│   │               │           CommonAddressUtility.java
│   │               │           ExceptionalRunnable.java
│   │               │           OracleConnection.java
│   │               │
│   │               └───pojo
│   │                       UnacceptableAddBuilder.java
│   │                       UnacceptableAddPojo.java
│   │                       UnacceptableSpecific.java
│   │
│   └───test
│       └───java
│           └───com
│               └───restassured
│                   ├───create
│                   │   └───POST
│                   │           ApplicableAddressValidationsTest.java
│                   │           AppTestBaseRest17.java
│                   │           DuplicateAddressValidationsTest.java
│                   │           InvalidFieldsValidationsTest.java
│                   │           SchemaValidationsTest.java
│                   │           UnacceptableAdMandatoryFieldsTest.java
│                   │           UnitRangeValidationsTest.java
│                   │
│                   ├───delete
│                   │   └───DELETE
│                   │           AppTestBaseRest19.java
│                   │           DeleteAddressMandatoryFields.java
│                   │
│                   ├───getAll
│                   │   └───GET
│                   │           AppTestBaseRest16.java
│                   │           GetAllUnacceptableAddressTest.java
│                   │
│                   ├───update
│                   │   └───PUT
│                   │           ApplicableAddressFieldsUpdateTest.java
│                   │           AppTestBaseRest18.java
│                   │           ChangeAddressTypeValidationTest.java
│                   │           DuplicateAddressValidationsTest.java
│                   │           InvalidFieldsValidationsTest.java
│                   │           MandatoryFieldsValidationsTest.java
│                   │           UnitRangeValidationsTest.java
│                   │
│                   ├───util
│                   │       AppTestBase.java
│                   │       Utility.java
│                   │
│                   ├───validate
│                   │   └───POST
│                   │           AppTestBaseRest15.java
│                   │           CivicAddressValidationTest.java
│                   │           EntirePostalCdAddressValidationTest.java
│                   │           GDAddressValidationTest.java
│                   │           POBoxAddressValidationTest.java
│                   │           RuralAddressValidationTest.java
│                   │           UnitRangeValidationsTest.java
│                   │
│                   └───zapi
│                           ZapiTestBase.java
│                           ZapiTestCaseCreator.java
│
```

# Key features

## Test suite RestAssured health check

```java
@BeforeSuite
public void testhealthcheck() {
    given().baseUri(BASE_URI).request().auth().basic("userName", "pwd").expect().statusCode(200);
}
```

## Builder pattern

```java
final UnacceptableAddPojo pojo = new UnacceptableAddBuilder()
    			.addresstypecode(1)
    			.entirepostalcodeInd(false)
    			.postalcode(postalcd)
    			.provincecode("ON")
    			.municipalityname("Bollywood")
    			.streetnbr(999)
    			.streetname("McDonald")
    			.StreetNbrSuffix("4")
    			.StreetTypeCd(11)
    			.StreetDirectionCd(5)
    			.EntireUnitRangeInd(false)
    			.UnitNbr("10")
    			.ToUnitNbr("25")
    			.note("this is civic address")
    			.build();
```

## Test structure

```java
@Test
public void createCivicAddressMandatoryFields() throws Exception {
    
    // Test Set Up
    String postalcd = Utility.generateUnacceptableAddPostalCd();

    // Builder pattern for POJO
    final UnacceptableAddPojo pojo = new UnacceptableAddBuilder()
            .addresstypecode(1)
            .entirepostalcodeInd(false)
            .postalcode(postalcd)
            .provincecode("BC")
            .municipalityname("HillTop")
            .streetnbr(163)
            .streetname("Elm")
            .note("this is hospistal")
            .EntireUnitRangeInd(true)
            .build();

    // Test running and verification
    // RestAssured BDD syntax
    result = given().baseUri(BASE_URI)
    .contentType("application/json")
    .body(pojo)
    .auth().basic("userName", "pwd")
    .when()
    .post()
    .then()
    .assertThat().body("$", hasKey("id")).and().statusCode(200)
    .extract()
    .path("id");

    try {
        //Validate the record with assertions against DB
        Utility.queryUnacceptableAd(result, this::assertUnacceptableAdd, pojo);	
    } finally {
        // Test clean up
        //Delete the record
        Utility.queryUnacceptableAdDelete(result);
    }
}
```

```java
@Test
public void updateCivicAddressMandatoryFieldsPostalCodeMissing() throws Exception {
    String postalcd = Utility.generateUnacceptableAddPostalCd();

    // Test Set Up
    // Builder pattern for POJO
    final UnacceptableAddPojo pojo = new UnacceptableAddBuilder()
            .addresstypecode(1)
            .entirepostalcodeInd(false)
            .postalcode(postalcd)
            .provincecode("AB")
            .municipalityname("Foxwood")
            .streetnbr(963)
            .streetname("Sparks")
            .StreetNbrSuffix("4")
            .StreetTypeCd(11)
            .StreetDirectionCd(5)
            .EntireUnitRangeInd(true)
            .note("this is hospistal")
            .build();
    
    int recordID = Utility.queryAddressCreation(pojo);

    pojo.setPostalCode(null);
        
    // Test running and verification
    // RestAssured BDD syntax
    String ResponseBody = given().baseUri(BASE_URI+"/"+recordID)
    .contentType("application/json")
    .body(pojo)
    .auth().basic("userName", "pwd")
    .when()
    .put()
    .then()
    .assertThat().statusCode(400).and()
    .extract().body().asString();
        Assert.assertTrue(ResponseBody.contains("schemaValidation"));
        Assert.assertTrue(ResponseBody.contains("Schema validation failed: $.postalCode: is missing but it is required"));
        pojo.setPostalCode(postalcd);
        
    try {
        //Validate the record with assertions against DB
        Utility.queryUnacceptableAd(recordID, this::assertUnacceptableAdd, pojo);
    } finally {
        // Test clean up
        //Delete the record
        Utility.queryUnacceptableAdDelete(recordID);
    }

    
}
```

## Database record creation methods

```java
public static int queryAddressCreation(UnacceptableAddPojo pojo) throws Exception {

    StringBuilder sbquery = new StringBuilder();
    StringBuilder sbvalues = new StringBuilder();
    
    sbquery.append("INSERT INTO SCHEMA.POJO_ADDRESS ( ");
    
    if(pojo.getPostalCode()!=null)
    {
        sbvalues.append("?,");
        sbquery.append("POSTAL_CODE,");
    }

    // ...

    try ( Connection connection = getOracleConnection()) { 
        try (PreparedStatement statement = connection.prepareStatement(sbquery.toString(), new String[] { "POJO_ADDRESS_ID" })) {
            
            int counter = 1
            if (pojo.getPostalCode()!=null)
            {
                statement.setString(counter, pojo.getPostalCode().toUpperCase().replace('-' , ' '));
                counter++;
            } else {
                throw new Exception("Postal code missing");
            }

            // ...

            int affectedRows = statement.executeUpdate();
            if (affectedRows == 0) {
                throw new SQLException("Creating address failed, no rows affected.");
            }
            // Retrieve the generated primary key ID from the inserted row
            Integer primaryKey = null;
            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (null != generatedKeys && generatedKeys.next()) {
                    primaryKey = generatedKeys.getInt(1);
                }
            }
            return primaryKey;

        }
    } catch (SQLException e) {
        // ...
    }
}
```

## Database record clean up methods

```java
public static void queryUnacceptableAdDelete(int adID) {
    
    String selectTableSQL = "DELETE FROM SCHEMA.POJO_ADDRESS WHERE POJO_ADDRESS_ID="+adID;
    
    try ( Connection connection = getOracleConnection()) {

        try (Statement statement = connection.createStatement()) {
            
            // execute the query to remove data
            statement.executeUpdate(selectTableSQL);
            
        }
    } catch (SQLException e) {
        // ...
    }
}
```

## Database and POJO Assertion methods

### Java 8 Functional interface

```java
@FunctionalInterface
public interface ExceptionalRunnable {
	void run(final ResultSet rs, Object o) throws Exception;
}
```

### Method implementing above Java 8 Functional interface

```java
protected void assertUnacceptableAdd(ResultSet rs, Object o) throws Exception {
    UnacceptableAddPojo pojo = (UnacceptableAddPojo)o;
    
    if(pojo.isEntirePostalCodeInd())
    {
        Assert.assertEquals(rs.getString("POSTAL_CODE"),pojo.getPostalCode();

        // ...

        return;
    }
    // ...
}
```

### Assertion method using Functional Interface

```java
public static void queryUnacceptableAd(int adID, ExceptionalRunnable assertions, UnacceptableAddPojo pojo) throws Exception {
    
    String selectTableSQL = "SELECT * FROM SCHEMA.POJO_ADDRESS WHERE POJO_ADDRESS_ID="+adID;
    
    try ( Connection connection = getOracleConnection()) {
        try (Statement statement = connection.createStatement()) {
            
            // get data from DB
            try (ResultSet rs = statement.executeQuery(selectTableSQL)) {
    
                // fetch data
                while (rs.next()) {
                    assertions.run(rs, pojo);
                }
            }
        }
    } // ...
}
```

### Usage of assertion method and method implementing functional interface

```java
//Validate the record with assertions against DB
Utility.queryUnacceptableAd(recordID, this::assertUnacceptableAdd, pojo);
```

 ## ZapiTestCaseCreator.java

```
Overall description of class: utility class responsible for mapping TestNG test case status to Zephyr test case status and for creating Zephyr test cases and executions in JRIA and linking them to existing JIRA stories.
```

### Methods
	
1.	`ZapiTestCaseCreator()`
2.	Default constructor to create an instance of ZapiTestCaseCreator class without setting any initial values
3.	`ZapiTestCaseCreator(issueID, projectID) `
4.	Constructor with two parameters issue ID and project ID are the IDs of the JIRA issue and project to be used when making calls to the JIRA and ZAPI APIs. Invoking this constructor will create an instance of ZapiTesCaseCreator class and set initial values.
5.	`afterInvocation(Method, ITestResult)`
6.	After a TestNG method is executed, this method calls ZAPI API to update corresponding Zephyr test execution status with TestNG test result.
7.	`deleteJiraIssueTestExecutions()`
8.	Before a TestNG test class is executed, this method calls ZAPI API to delete all Zephyr test executions in a Zephyr test case. This allows us to keep the existing Zephyr test case in JIRA without recreating it every time a TestNG class runs.
9.	`beforeInvocation(Method, ITestResult)`
10.	Before a TestNG method is executed, this method calls ZAPI API to create a Zephyr test execution inside a corresponding Zephyr test case.
11.	`createTestcase(projKey, summary, descp, issueTypeID, storyID)`
12.	Before a TestNG class is executed, this method calls JIRA API to create a Zephyr test case if it does not already exist and links it to a selected JIRA user story. The code will check if the Zephyr test case exists by checking if it is mentioned in the code.

### Fields

1.	`auth : String`  –A string containing the word “Basic” followed by a space and then a Base64 encoded string that represents username:password (username followed by colon character followed by password)
2.	`createTestcaseEndPoint : String` – URI for the JIRA API specific endpoint for creating JIRA issues. Used to create JIRA issue where type of issue is a Zephyr test case.
Navigate to Login page of Jira. Then copy the URL from address until/jira . Now append /rest/api/2/issue . Assign this value to createTestcaseEndPoint variable in ZapiTestCaseCreator
3.	`executionEndPoint : String` – URI for the ZAPI API specific endpoint for creation and deletion of Zephyr test executions against a Zephyr test case.
d.	statusMap : Map<Integer, Integer> - Mapping between TestNG test result status and Zephyr test execution result status
4.	`updateexecutionEndPoint : String` – URI for the ZAPI API specific endpoint for update of Zephyr test executions to set pass or fail or other result status codes as well as setting a comment against a test execution. The comment is based on TestNG method being executed for a particular Zephyr test execution.
5.	`zapiurl : String` -  Base URL used to access ZAPI API specific endpoints, for example https://jiraInstanceUrl/jira/rest/zapi - Navigate to Login page of Jira. Then copy the URL from address until/jira . Now append /rest/zapi. Assign this value to zapiurl variable in ZapiTestCaseCreator
6.	`executionId : String` – obtained from creation of Zephyr test execution via calling of beforeInvocation(Method, ITestResult) method. The execution ID is used for making calls to the ZAPI update execution endpoint. This value will be setup on runtime .
7.	`issueID : String` - the issue ID of Zephyr test case if already created otherwise if not created will be null.  If null, issue ID will store the value assigned by calling the createTestcase method. Once assigned or if was not initially null (already assigned a value) this is used to reference which JIRA Zephyr test case to create test executions under. This value is setup in overriding test classes.
8.	`projectID : String` – the JIRA project ID for which the Zephyr test case indicated by assigned issue ID and all its corresponding test executions exist under. This value is setup by ZapiTestBase class


## ZapiTestBase.java

```
Overall description of class – This is the base class used to capture TestNG test results into JIRA Zephyr test cases through ZAPI. Extend this class in a TestNG test class to use it.
```

### Methods
	
1.	`afterMethod(Method, ITestResult)`
2.	After a TestNG method is executed, this method just calls ZapiTestCaseCreator.afterInvocation and passes Method and ITestResult as provided by TestNG framework.
3.	`beforeclass()`
4.	Before a TestNG class is executed, this method gathers data including:
	JIRA project key and project ID
    1.	JIRA Zephyr test case issue type ID
    2.	the name of TestNG class  
    3.	which Zephyr test case to use, 
    4.	which JIRA user story to use
    5.	Description of the Zephyr test case. 
5.	If after gathering the data, a Zephyr test case to use was not found, this method will call ZapiTestCaseCreator.createTestcase static method passing in some of the data above, which will create a Zephyr test case in JIRA and link it to the specified JIRA user story.
6.	Then this method will create an instance of ZapiTestCaseCreator using the Zephyr test case issue ID and JIRA project ID. It will then call ZapiTestCaseCreator. beforeClass to delete all Zephyr test executions in a Zephyr test case if they already were present.
7.	`beforeMethod(Method, ITestResult) `
8.	Before a TestNG method is executed this method just calls ZapiTestCaseCreator.beforeInvocation and passes Method and ITestResult as provided by TestNG framework.
9.	`setJiraStoryID()`
10.	This method is called in beforeclass above and gathers data about the JIRA user story ID. Override this method in your specific TestNG subclass (for example DuplicateAddressValidationsTest or AppTestBaseRest17) to set the JIRA user story ID that a created Zephyr test case will be linked to.
11.	`setJiraTestCaseParamters()`
12.	This method is called in beforeclass above and gathers data about the Zephyr test case issue ID and description to set on the Zephyr test case when it is first created. Override this method in your specific TestNG subclass (for example DuplicateAddressValidationsTest or AppTestBaseRest17) to set the Zephyr test case issue ID or description of Zephyr test case to be created.


### Fields

1.	`desc : String` - description of Zephyr test case to be created. This is based on the name of the TestNG test class.
2.	`issueID : String` – store the issue ID of Zephyr test case if already created otherwise if not created will be null
3.	`issueTypeID : String` – the specific type ID assigned for a Zephyr test case – an explaination of how to get this ID will be provided
4.	`projectID : String` – the JIRA project ID for which the Zephyr test cases are to be created
5.	`projectkey : String` – the JIRA project key for the corresponding JIRA project ID
Navigate to User Story from backlog 
6.	`storyID : String` – the JIRA issue ID for the user story that contains the Zephyr test cases . Navigate to User story in full detail view. Hover your mouse over the Edit button and you will find it in left corner bottom of the page in IE.
7. `zapi : ZapiTestCaseCreator` – the instance of the class ZapiTestCaseCreator used to make API calls to create Zephr test case ‘test executions’ and set the status of the ‘test executions’ to pass or fail or some other ‘mapped’ status.

