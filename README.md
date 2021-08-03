**Build and Deploy**

* Requires Maven 3.8+ and Java 1.8+
* Go to the root directory of the package and run:```mvn clean package  -DskipTests```
* Then ```java -jar target/PalindromeRestService-1.0-SNAPSHOT.jar```

**Test**

* Go to your browser and test. Following is an example
  ```
  http://localhost:8080/is_palindrome/level
  ``` 
  Response: ```{"palindrome":true}```

  ```
  http://localhost:8080/is_palindrome/kayak
  ``` 
  Response: `{"palindrome":true}`

  ```
  http://localhost:8080/is_palindrome/level&
  ```
  Response : `{"message":"String level& given in the input is invalid"}` 

  ```
  http://localhost:8080/palindrome_counts
  ```
  Response: `{"level":1,"kayak":1}`

**Project Structure**
```
.
├── ./README.md
├── ./list.txt
├── ./palindromerestservice.iml
├── ./pom.xml
├── ./src
 ├── ./src/main
 ├── ./src/main/java
 └── ./src/main/java/com
     └── ./src/main/java/com/qlik
         ├── ./src/main/java/com/qlik/ApplicationLoader.java
         ├── ./src/main/java/com/qlik/controller
         |  ├── ./src/main/java/com/qlik/controller/PalindromeController.java 
         |  └── ./src/main/java/com/qlik/controller/RestAPIExceptionHandler.java
         ├── ./src/main/java/com/qlik/dto
         |  └── ./src/main/java/com/qlik/dto/BooleanDTO.java
         ├── ./src/main/java/com/qlik/exceptions
         │  └── ./src/main/java/com/qlik/exceptions/InvalidStringInputException.java
         └── ./src/main/java/com/qlik/services
             ├── ./src/main/java/com/qlik/services/PalindromeService.java
             └── ./src/main/java/com/qlik/services/impl
                 └── ./src/main/java/com/qlik/services/impl/PalindromeServiceImpl.java
 └── ./src/main/resources
 └── ./src/test
     └── ./src/test/java
         └── ./src/test/java/com
             └── ./src/test/java/com/qlik
                 ├── ./src/test/java/com/qlik/controller
                 └── ./src/test/java/com/qlik/controller/PalindromeControllerTest.java
                 └── ./src/test/java/com/qlik/services
                     └── ./src/test/java/com/qlik/services/impl
                         └── ./src/test/java/com/qlik/services/impl/PalindromeServiceImplTest.java

```
**Controllers**

* _PalindromeController.java_ - RestController which specifies handler methods for two endpoints as below:
  * GET is_palindrome/&lt;String&gt;
  * GET palindrome_counts

* _RestAPIExceptionHandler.java_ - @ControllerAdvice for Spring based Exception handling for API endpoints

**Services**

* _PalindromeService.java_ - Interface which states two methods to handle each of the endpoints.

* _PalindromeServiceImpl.java_ - Implementation of the service.

**DTO**

* _BooleanDTO.java_ - Structures the response of the API

**Exceptions**

* _InvalidStringInputException.java_ - Custom exception to handle wrong input string


