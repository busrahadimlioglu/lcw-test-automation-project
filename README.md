# LC Waikiki Selenium Test Automation Project

## Project Overview

This project automates key test cases for the LC Waikiki e-commerce website using Selenium WebDriver with Java. The automation includes scenarios such as filtering products, sorting results, selecting product details, verifying cart information, and handling pop-ups.

## Features

* Product Filtering: Apply color and category filters.

* Sorting: Sort products by criteria such as "Best Sellers".

* Product Details: Select product size and verify product details.

* Cart Validation: Validate product name, color, and quantity in the cart.

* Pop-Up Handling: Manage and dismiss cookie and promotional pop-ups.

## Technologies Used

* Programming Language: Java

* Testing Framework: JUnit / TestNG

* Automation Tool: Selenium WebDriver

* Build Tool: Maven

* Design Pattern: POM (Page Object Model)

* Reporting Tool: Allure Report

* Version Control: Git

## Prerequisites

To run this project, ensure you have the following installed:

* Java Development Kit (JDK) (version 8 or higher)

* Maven

* Google Chrome (latest version)

* ChromeDriver (compatible with your Chrome version)

* Allure Commandline (for generating and viewing reports)

## Setup and Installation

*1.* Clone the Repository:

```
git clone https://github.com/busrahadimlioglu/lcw-test-automation-project.git
cd selenium-lcw-automation
```

*2.* Install Dependencies:
Maven will automatically handle dependencies. To install:
```
mvn clean install
```

*3.* Configure ChromeDriver:

Download the appropriate version of ChromeDriver: https://chromedriver.chromium.org/downloads

Set the ``` webdriver.chrome.driver ``` system property in the code or environment.

*4.* Setup Allure:

Install Allure Commandline: Installation Guide

Ensure Allure is added to your system's PATH variable.

## How to Run Tests

Open the project in your favorite IDE (e.g., IntelliJ IDEA or Eclipse).

Run the test classes using JUnit or TestNG.

Alternatively, execute all tests using Maven:
```
mvn test
```
Generate Allure Report:
```
allure serve allure-results
```

## Test Scenarios

*1.* Filtering Products

Navigate to the LC Waikiki product listing page.

Apply a filter for the color "Beige".

Verify that the filtered products match the selected color.

*2.* Sorting Products

Select the "Best Sellers" option from the sorting dropdown.

Verify that products are displayed in the expected order.

*3.* Product Selection

Click on a product to navigate to the product detail page.

Select a size and add the product to the cart.

*4.* Cart Validation

Verify the product name, color, and quantity in the cart.

Example Assertion:
```
assertEquals("Color: Beige", actualProductColor);
assertEquals("1", actualProductQuantity);
```

*5.* Pop-Up Handling

Dismiss cookie consent and promotional pop-ups using JavaScript:
```
((JavascriptExecutor) driver).executeScript("document.querySelector('.popup-selector').style.display='none';");
```
## Folder Structure

```
selenium-lcw-automation/
|-- src/main/java
|   |-- utils/         # Utility classes (e.g., WebDriver setup)
|-- src/test/java
|   |-- tests/         # Test classes for each scenario
|-- pom.xml            # Maven dependencies and build configuration
|-- allure-results/    # Allure report results
```
