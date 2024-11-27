# FitPeo_Assignment
# FitPeo Assignment Automation Script

## Overview

This is a Java Selenium-based script designed to automate specific tasks on the FitPeo website. The script performs various actions, including navigating to pages, adjusting sliders, validating inputs, selecting checkboxes, and verifying calculated results. It provides a structured approach to test the functionality of the FitPeo website's Revenue Calculator feature.

## Prerequisites

- **Java Development Kit (JDK):** Ensure JDK is installed and set up.
- **Selenium WebDriver:** Download the Selenium WebDriver library and add it to your project.
- **ChromeDriver:** Download the ChromeDriver executable for your version of Chrome and provide its path in the script.
- **Browser:** Google Chrome (ensure it matches the ChromeDriver version).

## Features

The script includes the following tasks:
1. Navigate to the FitPeo homepage.
2. Access the Revenue Calculator page.
3. Scroll to specific sections on the page.
4. Adjust sliders dynamically to specific values.
5. Update and validate text field inputs for slider synchronization.
6. Select specific CPT codes using checkboxes.
7. Validate total recurring reimbursement against expected values.
8. Verify header text displays accurate information.

## How to Run

1. **Set up your environment:**
   - Install Java JDK if not already installed.
   - Include the Selenium WebDriver JAR files in your project’s classpath.
   - Place the ChromeDriver executable on your system and note its path.

2. **Update the script:**
   - Replace the `chrome.driver` path in the script with the actual path of your ChromeDriver executable.

3. **Run the script:**
   - Compile and execute the script using any Java IDE (e.g., IntelliJ IDEA, Eclipse) or the command line.

   Example command-line execution:
   ```bash
   javac FitPeo_Assignment.java
   java FitPeo_Assignment
