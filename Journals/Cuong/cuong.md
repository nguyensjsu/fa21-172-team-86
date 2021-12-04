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


## 11/30/21
* Implemented H2 Database to test registration page
* Fixed registration HTML to render CSS
* User was able to create an account and it was able to save H2 DB
    * Just have to implement MySQL
![created-account](./images/account-created.png)

## 11/31 - 12/3
* Had trouble implementing MySQL so I asked Richard for help
    * Return query for user registration kept returning null values for ID and Role
* Implemented Spring Security to give authorization to users and admin after logging into the application
    * Still having trouble as the application does not bring the user to the user page after logging in
