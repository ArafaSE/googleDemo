## GoogleSearch UI test suite :wave:
- The project contains 1 feature file and 1 Runner and 1 steps definition class
- You can run the googleSearch Ui test cases by running the uiTestSuite from IDE directly or from command line as
  ```
  mvn clean test -DsuiteXmlFile=uiTestSuite.xml
  ```

- I added only chrome browser for running UI but with both normal and headless mode
- You can run UI test cases in Headless mode with chrome by edit the browser name in
  uiTestSuite.xml file in line 5 to be 'chrome-headles' instead of 'chrome'

- Tech Stack: Selenium JAVA, TestNG, Cucumber and Page Object Model pattern.

## api test Suite  :upside_down_face:
- All api test cases added into 1 test class "tests/ApiTest"

- You can run API test suite from terminal as
 ```
 mvn clean test -DsuiteXmlFile=apiTestSuite.xml
 ```

- tech Stack: restAssured with java


## The logger in the project  :smiley:
- I Only log the error level when test cases failed in the test bas,
also I take a screenshot for it and save them in /screenshots folder


## The Reports :tada:
- The project use the **Allure** report for generating the reports after running
- The reports files located in project root file under /allure-results folder
- but you need to install Allure in your local machine to be able to read these reports

- If you are on **windows** you can execute the bellow commands to install Allure:  :shipit:
```
 Set-ExecutionPolicy RemoteSigned -scope CurrentUser
 iwr -useb get.scoop.sh | iex
 scoop install allure
```
- if you run on **Linux**:
```
 sudo apt-add-repository ppa:qameta/allure
 sudo apt-get update
 sudo apt-get install allure
```
- If you are a lucky man and run on **Mac** it's only one command:
```
 brew install allure
```
- After install the Allure on your machine and run the one testSuites API or UI justrun this command to open the report:
 ```
 allure serve allure-results
 ```
