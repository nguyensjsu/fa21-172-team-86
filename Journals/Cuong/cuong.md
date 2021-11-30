# Cuong's Journal

## 11/29/21
* Added more templates for registration, login, checkout, credit card, catalogs, and reset password.

* I decided to split the application into 5 parts
    * spring-frontend
        * Contains Templates and CSS
    * spring-payments
        * CyberSource API
    * spring-manga
        * Contains data of numerous manga
    * spring-employee
        * I assumes that an employee profile has already been made, so Employee won't have a registration page.
        * Able to reset customer's password
    * spring-customer
        * Registers for an account
        * Browse catalog and add into cart
        * Check out and input payment information

* I started to work on the registration page so that the customer can register for an account
* I was able to get the registration template, but I wasn't able to test it yet

![register-page](./images/register-page.png)