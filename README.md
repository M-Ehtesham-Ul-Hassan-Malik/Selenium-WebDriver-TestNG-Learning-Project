# Selenium WebDriver & TestNG Learning Project

This project is part of the "Automation With Selenium WebDriver & TestNG" course at 10Pearls University. It includes automated tests for a web application using Selenium WebDriver and TestNG.

## Project Structure

- **src/main/java/pages**: Contains the Page Object Model (POM) classes.
    - `LoginPage.java`: Contains methods to interact with the login page elements.
    - `DashboardPage.java`: Contains methods to interact with the dashboard page elements.
- **src/main/java/tests**: Contains the test classes.
    - `LoginTests.java`: Contains the test methods for login functionality.
- **src/test/resources**: Contains the test resources.
    - `config.properties`: Configuration file with key-value pairs for data-driven testing.
- **Runner.xml**: TestNG suite configuration file.

## Prerequisites

- Java Development Kit (JDK) 8 or higher
- Maven 3.6.3 or higher
- Google Chrome browser
- ChromeDriver
- IntelliJ IDEA or any other IDE


## Setup

1. **Clone the repository:**
    ```sh
    git clone https://github.com/M-Ehtesham-Ul-Hassan-Malik/Selenium-WebDriver-TestNG-Learning-Project.git
    cd src
    ```

2. **Install dependencies:**
    ```sh
    mvn clean install
    ```

3. **Update WebDriver path:**
   Ensure that the ChromeDriver executable is in your system's PATH or update the path in the test classes.

## Running Tests

### Using Maven

You can run the tests using Maven:

```sh
mvn test
```

### Using TestNG

You can run the tests directly through the TestNG suite file:

```sh
mvn -Dsurefire.suiteXmlFiles=testng.xml test
```

### Using IDE

You can also run the tests directly from your IDE (e.g., IntelliJ IDEA or Eclipse).

1. Right-click on the `testng.xml` file.
2. Select `Run` or `Run As > TestNG Suite`.

## Test Classes

- **tests.LoginTests**: Contains test methods for the login functionality.

## Test Scenarios

- **LoginTests**:
    - Valid login
    - Invalid login
    - Valid logout
    - Invalid logout

## Author

- [M Ehtesham Ul Hassan Malik](https://github.com/M-Ehtesham-Ul-Hassan-Malik/Selenium-WebDriver-TestNG-Learning-Project.git)

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.


