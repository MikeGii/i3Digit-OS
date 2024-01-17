# i3Digit OS "SPRING BOOT BACK-END"

### Back-End Overview

i3Digit OS uses Java Spring Boot back-end part which uses MySQL for database to store and read the data. Front-end is done on Angular Framework and whole communication will be done through REST application programming interface.

- Spring boot back-end is developed on Java 17 language version.
- Version 8 of MySQL is used.

### Setting up back-end for use

1. Look for application.yml file in .../operatingSystem/src/main/resources folder and enter your correct MySQL username and password. 
2. Check if MySQL service is operational - *If MySQL service is stopped then Spring Boot application won't start and gives an error!*
3. Run Spring app through main function in OperatingSystemApplication. 

**Note** - Application will create new table "filamentdb" by default if such table don't exist 
in MySQL database already. If "filamentdb" table is already existing then all data will be taken 
from there which means previous table will be not overwritten. <br>
- *To clear and reset database user has to drop table in MySQL Workbench.*

#### Dependencies that i3Digit OS Spring will use

- Spring Web
- Spring Data JPA
- MySQL Driver
- Validation
- Lombok

<br>

*--Phase 1--* <br>
*Version 0.21* <br>
*17.01.2024*
