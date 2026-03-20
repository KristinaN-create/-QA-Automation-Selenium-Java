# SauceDemo Test Automation Project

This project contains automated E2E (End-to-End) tests for the [SauceDemo](https://www.saucedemo.com/) e-commerce website.

## Tech Stack & Tools
* *Java* (JDK 11+)
* *Selenium WebDriver* (UI Automation)
* *TestNG* (Test Runner & Assertions)
* *Maven* (Dependency Management)
* *Page Object Model (POM)* (Architecture)

## Project Structure
The project follows the POM design pattern for better maintainability:
- src/main/java/pages/ - Contains Page Object classes with locators and methods.
- src/test/java/tests/ - Contains test cases grouped by functionality (Login, Cart, Checkout).
- src/test/java/base/ - Contains the BaseTest class for driver initialization.

## How to Run the Tests
Tests are configured to run via the TestNG XML file.
1. Open the project in IntelliJ IDEA.
2. Locate the testing.xml file in the root directory.
3. Right-click on the file and select *'Run.../testing.xml'*.

All 7 tests are expected to pass (Status: Pass).