## LIT Server DEMO project
LIT (*Live Inventory Tracking*) project is a fictive demonstration of a Real-Time Inventory Management System. 
This DEMO contains a mix of simulated data representing food inventory. 
For the project I have used:

*- Please note that the data relationships are fabricated! -*
- MySQL 8.0
- Spring Boot 3.3.1 (Maven)
- Java 17
- IntellJ Ultimate


- Clean Architecture - domain layer, application layer, an infrastructure layer, and an API layer.
- Repositories (persisting to database using JPA)


### Setup LIT Server DEMO
I use IntellJ as IDE. To setup the DEMO I recommend to follow these if you are unfamiliar with IntellJ:
- Clone the project (e.g. in terminal *git clone {repo}*)
- In *src/main/resources* make an application.properties file

The application.properties should contain:

*spring.application.name=lit.server*
*server.port=8080*
*lit.security.demo.login.username={username_for_access_api}*
*lit.security.demo.login.pwd={password_for_access_api}*

*spring.profiles.active=: dev*
*spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver*
*spring.datasource.url=jdbc:mysql://localhost:8336/{database_name}*
*spring.datasource.username={database_role_name}*
*spring.datasource.password={database_role_password}!*

*hibernate.dialect=org.hibernate.dialect.MySQLDialect*
*hibernate.show_sql=false*
*hibernate.format_sql=true*

*spring.jpa.show-sql=true*
*spring.jpa.hibernate.ddl-auto={update/create/drop_create/ect.}* 


#### (More explanation to come...)
There will be  uploaded a docker container with 'dummy data' as you can use for these project as soon as possible.

### User Stories
The functionalities of this project are detailed as User Stories. 
These User Stories are documented within [this agile development board](https://github.com/users/ACHChristensen/projects/1) to facilitate tracking and implementation. 

These tasks are done...
#### US - Track of Food Inventory and Expiry Date
"Employees can access a full list of food with expiration dates, ID, type, or brand, displaying all relevant details."
& "Employees can access a list of food and order by expiration dates, ID, type, or brand, displaying all relevant details."


Checkout the endpoint while running: */all-food/{amountPerPage}/{pageIndex}/{sortByDetail}* 

### ... MORE COMING UP SOON....






