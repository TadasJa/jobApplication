# README

Project for job application in FSCC

Chosen web page : https://www.demoblaze.com/

Whole project was created using IntelliJ

### For new users prerequisites:

 - Java 17
 - Maven
 - ChromeDriver

### Setup:

- Clone the repository
- Open Terminal
- Install dependencies: mvn clean install
- Run tests: mvn test


### 1. I chose Selenium WebDriver framework because:
- Selenium supports multiple browsers, which is crucial for testing a web application on different environments.
- Selenium is widely used with a vast community, providing ample resources and support for troubleshooting and enhancements.
### 2. To integrate these tests into a CI/CD pipeline:

Version Control: 
- Push the test scripts to a GitHub repository.

CI/CD Tool: 
- Use GitHub Actions or Jenkins to automate the execution of these tests.

Triggering:
- Set up the tests to run automatically on every push to the main branch, or on pull requests.
Parallel Execution: Leverage TestNG’s parallel execution capabilities to run tests in parallel, optimizing execution time.

Reports:
- Generate HTML/XML reports using TestNG's built-in reporting capabilities and store these as build artifacts.


### 3. Prioritization of Tests to optimize execution time:

Smoke Tests First: 
- Prioritize running smoke tests, which cover the most critical functionalities like login and checkout. This ensures that any major breakages are detected early.

Regression Tests: 
- Run full regression tests during non-peak hours or as part of nightly builds to cover all scenarios.

### 4. In the Software Development Life Cycle (SDLC):

Smoke Testing: 
- Integrate smoke tests into the CI pipeline, running them on every code commit. This ensures that the most critical functionalities are always working as expected.

Regression Testing: 
- Schedule regression tests to run in a separate build, typically overnight, to ensure that new code changes have not affected existing functionalities.



### Since I didn't have a lot of time to do this task (it took me much more than I expected), I didn't add some of the test scenarios, for example:

- Test login with an unregistered email.
- Check if items have the correct amount in the cart.
- Check if deleting a product from the cart updates the amount correctly.
- Check if the correct values are displayed when the order is placed (amount, email, order number, etc.).
- Check different fields in the checkout (password, card numbers, emails, etc.).

I hardcoded user credentials, and I know it’s not the right thing to do. These could be set as environment variables instead.
