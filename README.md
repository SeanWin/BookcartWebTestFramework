# Bookcart Web Test Framework

## Overview
This repository contains the automated test framework for the [Bookcart web application.](https://bookcart.azurewebsites.net/)
It covers end-to-end scenarios from authentication, user management, shopping cart, wishlist, to checkout.
Additionally, the tests can be run in various browsers including chrome, firefox and edge.

## Features

-  **Cucumber Integration** – Enables BDD-style testing and readable scenarios for cross-team collaboration
-  **Data-Driven Testing** – Supports parameterised test cases to handle multiple input variations
-  **Selenium WebDriver** – For implementing automated web tests
-  **JUnit** – For test execution and lifecycle management
-  **Automated Test Reporting** – Generates cucumber Extent reports
-  **GitHub Actions Integration** – Automatically runs tests and uploads reports as build artifacts

## Prerequisites
- Java 21
- Maven
- Chrome, Firefox, and Edge installed
- Git

## Setup
1. Clone this repository:
   ```sh
   git clone https://github.com/SeanWin/BookcartWebTestFramework.git
   cd BookcartWebTestFramework
   ```
2. Install dependencies:
   ```sh
   mvn clean install  
   ```
3. (optional) Open `src/test/resources/global.properties` and set preferred browser (default is chrome)


## Running The Tests
- Run all tests locally
  ```sh
  mvn test
  ```
- Run specific suite
  ```sh
  mvn test -Dcucumber.filter.tags="@Checkout"
  ```
- Run tests in a specific browser
  ```sh
  mvn test -Dbrowser=chrome
  ```
## Test Reports
Cucumber Extent reports are generated automatically under the `test-output/` folder

## CI Integration
This framework is integrated with GitHub Actions.
You can trigger it manually via the Actions tab or automatically with pull requests targeting the `main` branch

- Checks out code
- Sets up Java and Chrome
- Runs tests in Chrome
- Uploads Cucumber Extent report as an artifact.

Workflow file is located at `.github/workflows/Run_tests.yml`

## Framework Architecture

<details>
<summary>Click to expand directory structure</summary>

```text
├── README.md                     # Project overview and instructions
├── defects/                      # Defect reports 
├── manual/                       # Manual test cases 
├── pom.xml                       # Maven configuration file
├── src/
│   ├── main/
│   │   ├── java/                
│   │   └── resources/           
│   └── test/
│       ├── java/
│       │   ├── cucumberoptions/  # JUnit runner
│       │   ├── pageobjects/      # POM classes (BookDetailsPage, HomePage, etc.)
│       │   ├── stepdefinitions/  # Cucumber step defs linked to features
│       │   └── utils/            # Shared utilities and context setup
│       └── resources/
│           ├── features/         # Feature files (BDD scenarios)
│           ├── global.properties # Test environment configs
│           └── extent.properties # Report configurations
├── test-output/                  # Generated Extent reports 
```
</details> 

## Contributing
1. Clone the repository.
2. Create a feature branch:
   ```sh
   git checkout -b feature/your-feature
   ```
3. Commit your changes:
   ```sh
   git commit -m "Add your feature"
   ```
4. Push to the branch:
   ```sh
   git push origin feature/your-feature
   ```
5. Create a Pull Request.

## Defect Reports
All defects I found have been noted down as a defect report in the `defects/` folder. If
you find anymore, please log them following the naming convention and use the existing reports as examples.

## Manual Test Cases

Manual tests can be found in the `manual/` folder.
They are designed to cover scenarios not suitable for automation or to complement automated tests.

## Useful Links
- [Scrum board](https://trello.com/b/5AgNIYwZ/bookcart-web-test-project)
- [PowerPoint presentation](https://testingcircle-my.sharepoint.com/:p:/r/personal/swinston_spartaglobal_com/_layouts/15/Doc.aspx?sourcedoc=%7B0461B56F-AE46-4E8D-9FD6-D3A1ADC67512%7D&file=Bookcart%20Web%20Test%20Presentation.pptx&action=edit&mobileredirect=true&DefaultItemOpen=1&wdOrigin=WAC.POWERPOINT.HOME-BUTTON%2CAPPHOME-WEB.FILEBROWSER.RECENT&wdPreviousSession=124f64d4-1a46-46eb-9aad-d78883996288&wdPreviousSessionSrc=AppHomeWeb&ct=1748008302469)