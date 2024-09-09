## Project Structure

```bash
sauceDemo/
│
├── src/
│   ├── main/              # Application code (if any)
│   └── test/              # Test-related files
│       ├── java/
│       │   └── stepDefinitions/  # Java step definitions
│       │       └── TestRunner.java   # JUnit test runner for Cucumber
│       └── resources/
│           └── features/  # Gherkin feature files
│               └── your_feature_file.feature
│
├── target/                # Generated files (reports, compiled classes)
└── pom.xml                # Maven configuration file

Prerequisites:-

Java 8+ installed on your system.
Maven installed for managing dependencies and running tests.
ChromeDriver & firefox other WebDriver binaries added to your system's PATH.
A compatible IDE (e.g., Eclipse) or terminal to run the tests.

Note :
To run specific scenario, you need to run one of these on src/test/java/runners/FirstScenarioRunner.java or OrderFlow.java
To run both Scenario's just execute this src/test/java/runners/TestRunners.java

