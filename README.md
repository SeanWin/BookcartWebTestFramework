# Bookcart Web Test Framework

## Overview
This repository contains the automated test framework for the [Bookcart web application.](https://bookcart.azurewebsites.net/)
It covers end-to-end scenarios from authentication, user management, shopping cart, wishlist, to checkout.
Additionally, the tests can be run in various browsers including chrome, firefox and edge.

## Features

-  **Cucumber Integration** – Enables BDD-style testing and readable scenarios for cross-team collaboration
-  **Data-Driven Testing** – Supports parameterised test cases to handle multiple input variations
-  **Selenium** – For implementing automated web tests
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
3. (optional) Open `src/main/resources/global.properties` and set preferred browser (default is chrome)


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
Cucumber Extent reports are generated automatically under `test-output/` folder

## CI Integration
This framework is integrated with GitHub Actions.
You can trigger it manually via the Actions tab or automatically pull requests to `main`

- Checks out code
- Sets up Java and Chrome
- Runs tests in Chrome
- Uploads Cucumber Extent report as an artifact.

Workflow file is located at `.github/workflows/Run_tests.yml`

## Framework

```text
├── README.md
├── defects
│   ├── DEF-BOOKCART-001.md
│   ├── DEF-BOOKCART-002.md
│   ├── DEF-BOOKCART-003.md
│   ├── DEF-BOOKCART-004.md
│   ├── DEF-BOOKCART-005.md
│   ├── DEF-BOOKCART-006.md
│   ├── DEF-BOOKCART-007.md
│   ├── DEF-BOOKCART-008.md
│   └── DEF-BOOKCART-009.md
├── manual
│   └── USER-REGISTRATION.md
├── pom.xml
├── src
│   ├── main
│   │   ├── java
│   │   └── resources
│   └── test
│       ├── java
│       │   ├── cucumberoptions
│       │   │   └── JunitTestRunnerTest.java
│       │   ├── pageobjects
│       │   │   ├── BookDetailsPage.java
│       │   │   ├── CheckoutPage.java
│       │   │   ├── HomePage.java
│       │   │   ├── LoginPage.java
│       │   │   ├── MyOrderDetailsPage.java
│       │   │   ├── PageObjectManager.java
│       │   │   ├── RegisterPage.java
│       │   │   ├── ShoppingCartPage.java
│       │   │   └── WishlistPage.java
│       │   ├── stepdefinitions
│       │   │   ├── BookDetailsPageStepDefinition.java
│       │   │   ├── CheckoutPageStepDefinition.java
│       │   │   ├── HomePageStepDefinition.java
│       │   │   ├── Hooks.java
│       │   │   ├── LoginPageStepDefinition.java
│       │   │   ├── MyOrderDetailsPageStepDefinition.java
│       │   │   ├── RegisterPageStepDefinition.java
│       │   │   ├── ShoppingCartPageStepDefinition.java
│       │   │   ├── UserFlowStepDefinition.java
│       │   │   └── WishlistPageStepDefinition.java
│       │   └── utils
│       │       ├── GenericUtils.java
│       │       ├── TestBase.java
│       │       └── TestContextSetup.java
│       └── resources
│           ├── extent.properties
│           ├── features
│           │   ├── addItemToCart.feature
│           │   ├── checkout.feature
│           │   ├── filterBooks.feature
│           │   ├── getBookDetails.feature
│           │   ├── login.feature
│           │   ├── logout.feature
│           │   ├── register.feature
│           │   ├── updateCart.feature
│           │   ├── viewCartContents.feature
│           │   └── wishlist.feature
│           └── global.properties
└── test-output

```
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