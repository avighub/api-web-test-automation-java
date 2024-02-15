### API and WEB UI Test Automation Framework

[![stars - test-automation-java-restassured-selenide](https://img.shields.io/github/stars/avighub/test-automation-java-restassured-selenide?style=social)](https://github.com/avighub/test-automation-java-restassured-selenide)
[![forks - test-automation-java-restassured-selenide](https://img.shields.io/github/forks/avighub/test-automation-java-restassured-selenide?style=social)](https://github.com/avighub/test-automation-java-restassured-selenide)
[![License](https://img.shields.io/badge/License-MIT-blue)](#license)
[![issues - test-automation-java-restassured-selenide](https://img.shields.io/github/issues/avighub/test-automation-java-restassured-selenide)](https://github.com/avighub/test-automation-java-restassured-selenide/issues)
<br>[![pages-build-deployment](https://github.com/avighub/api-web-test-automation-java/actions/workflows/pages/pages-build-deployment/badge.svg)](https://github.com/avighub/api-web-test-automation-java/actions/workflows/pages/pages-build-deployment)
![GitHub Actions Workflow Status](https://img.shields.io/github/actions/workflow/status/avighub/test-automation-java-restassured-selenide/run-tests-on-pr-or-push.yml)
<br>[![View site - GH Pages](https://img.shields.io/badge/View_site-GH_Pages-2ea44f?style=for-the-badge)](https://avighub.github.io/test-automation-java-restassured-selenide/)

- This framework is built for the purpose of automating API services and WEB applications.
- This can also be used as a base framework to automate any application that has API and WEB interfaces.
- However the main intention of this framework is not just to create yet another framework on GitHub,<br> but to solve
  some of the below problems that I feel most of the ones I know of, do not solve
    - It uses a real world application that has meaningful user flows and use cases.<br> Thanks
      to [Cypress](https://github.com/cypress-io/cypress-realworld-app) for open sourcing their RWA ( Real World App)
      for the community. Copyright (c) 2020 Cypress.io
    - Most frameworks do have all the features that we need but there is lack of "How to Apply" it for a real
      application.
    - Dummy APIs or Web Apps are used for demonstration lacking detailed user flows and use cases, so that people can
      relate to it.
    - In real, applications keep changing in different fronts, API, UI ( Web, Mobile ) and <br>our Tests within
      framework must be able to detect changes, this part is missing as to how will our tests behave when there is a
      change in application itself.
    - Also having access to API for the same Web Application makes it a close to real scenario, where we can leverage
      good test design strategy. <br>Without API access, testing Web application is an anti-pattern.
    - Cypress App solves all above problems, thus is a good fit to be used as AUT ( Application Under Test)

### Tech Stack

|                              |                                                                                         |
|------------------------------|-----------------------------------------------------------------------------------------|
| Programming Language         | [Java](https://www.oracle.com/in/java/technologies/javase/jdk11-archive-downloads.html) |
| Build and Library management | [Maven](https://maven.apache.org/)                                                      |
| WEB automation Library       | [Selenium](https://www.selenium.dev/)    , [Selenide](https://selenide.org/)            |
| API automation Library       | [Rest Assured](https://rest-assured.io/)                                                |
| Assertion Library            | [AssertJ](https://assertj.github.io/doc/#assertj-overview)                              |
| Test runner  Library         | [Junit5](https://junit.org/junit5/)                                                     |
| CI                           | Github Actions                                                                          |
| Optimize boilerplate code    | [Lombok](https://projectlombok.org/)                                                    |
| JSON Parser                  | [Jackson](https://github.com/FasterXML/jackson)                                         |
| Secret manager               | [git-crypt](https://github.com/AGWA/git-crypt)                                          |
| Fake Test data generator     | [datafaker](https://github.com/datafaker-net/datafaker)                                 |
| Configuration manager        | [OWNER](https://matteobaccan.github.io/owner/docs/welcome/)                             |
| Logging                      | [logback](https://logback.qos.ch/)                                                      |

### Framework features

- Cross browser automation
- Page object model for easier management of pages and tests
- API Automation
- Fluent Assertion wrappers
- Environment switching
- Manage environment specific configurations or framework configurations
- Test grouping, tagging
- Parallel execution of tests with auto scaling
- Generate dynamic test data
- Logs and Report Dashboard
- Integration with CI tool like Jenkins/Github actions
- Secrete management
- Automatic Code formatting
- Slack notification (via CI tool)

### How to setup ?

1. Install Java JDK 17 or above
2. Clone repository: `git@github.com:avighub/test-automation-java-restassured-selenide.git`
3. Unlock Secret:
    - [git-crypt](https://github.com/AGWA/git-crypt) is used to manage secrets in this framework
    - It needs a secret file to unlock the encrypted files such as properties files that contains credentials and urls
      of the application
    - In general this secret file should be kept in a secured vault (Not exposed to public) within organization.
    - However since this framework is meant to be publicly accessed, I have added the secret key to git but ,<br> in
      general it should be kept in secured location and to be shared securely
    - Install git-crypt in your system , follow the doc [here](https://github.com/AGWA/git-crypt/blob/master/INSTALL.md)
    - Once done, `run git-crypt unlock git-crypt-secret-public`
    - Now you should be able to see configurations file (properties files) contents
4. Install and setup pre-commit hook locally
    - Install [pre-commit](https://pre-commit.com/#install) package manager
    - Install the git hook scripts in project: ```pre-commit install```
    - That is it, next time you make any commit from local or CI, it will prevent pushing bad formatted code
5. Run Unit Tests to ensure a sanity check passes: ``` mvn clean test -Dgroups={"UnitTest"}```

### How to write test?

- Add relevant meta annotations at test level (Avoid adding at class level as it is easy to miss the annotation)
- You may use multiple annotations, example :
- ```
  @Test : Mandatory for all tests
  @SkipBeforeEach : Skips running @BeforeEach
  @Login : Login feature tag
  @Sanity : Sanity Test type
  @Flaky : Marks Flaky and disables, add comment to explain
  @Failing: Marks as failing and disables, add comment to explain
  ```

### Best practices

- Follow meaningful naming standards across the framework
- Follow naming convention for test
    - Should {do something} if {given a state or performed an action}
- Make sure to add annotation to each test or test class based on their category
    - Example:
        - Login feature tests , we can mark class with @Login
        - If it is specific to a test we can mark annotation to individual test too
    - To run via commandline <b>  ``` mvn clean test -Dgroups=login```
      or ``` mvn clean test -Dgroups={"login","inventory"}```
    - Check test/annotations for more meta annotations list
- Follow commit message format
    - Ask below questions while thinking of meaningful commit message
        - Why have I made these changes?
        - What effect have my changes made?
        - Why was the change needed?
        - What are the changes in reference to?
    <details>
       <summary>Use below prefix for each commit type to follow a standard</summary>
        feat – a new feature is introduced with the changes
        <br>fix – a bug fix has occurred
        <br>chore – changes that do not relate to a fix or feature and don't modify src or test files (for example
          updating dependencies)
        <br>refactor – refactored code that neither fixes a bug nor adds a feature
        <br>docs – updates to documentation such as a the README or other markdown files
        <br>style – changes that do not affect the meaning of the code, likely related to code formatting such as
          white-space, missing semi-colons, and so on.
        <br>test – including new or correcting previous tests
        <br>perf – performance improvements
        <br>ci – continuous integration related
        <br>build – changes that affect the build system or external dependencies
        <br>revert – reverts a previous commit
        </details>

### References

- Commit message [best practices](https://www.freecodecamp.org/news/how-to-write-better-git-commit-messages/)

### Credits

- Credit (Copyright (c) 2020 Cypress.io) to Cypress for the AUT (Application Under
  Test) : [Real World App](https://github.com/cypress-io/cypress-realworld-app)
- Shout out to amazing friends and colleagues with whom I worked and learned lots of stuffs. Do checkout their contents.
    - Amuthan Saktivel: [Testing Mini Bytes Youtube channel](https://www.youtube.com/@TestingMiniBytes)
    - Pramod Yadav : [Power Tester Youtube channel](https://www.youtube.com/@powertester5596)
