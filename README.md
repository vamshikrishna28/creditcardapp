Required Softwares :
- JDK 1.8
- Maven 3.x

Installation and Getting Started
Steps for running the application
- Check out the source from git hub
- Run the command "mvn hsqldb:start"(start hsql in memory database)
- Run the command "mvn spring-boot:run"(start spring boot application)

Pending
- User authentication
- Encrypting the credit card numbers while saving in the database
- Test cases for ui,api, dao, service layer
- Comments where required
- Update the credit card information
- Ability to show the end user card information like card type and sub type as soon the user enters card number.
- update, delete operations on a credit card
- UI design and alignment

This is a small credit card application that lets the user perform basic crud operations for credit cards.
It is a spring boot based application and uses HSQL in memory database to persist the credit card information
Also the UI is designed with plain html and javascript.

Once the application is up and running, 
To add a new credit card use the following link :http://localhost:8080/CreditCardPage.html
Further in order to view the existing credit cards use the following link http://localhost:8080/ViewCreditCardsPage.html
