# i3Digit OS

i3Digit OS is a powerful application designed to streamline various aspects of managing 3D printing and modeling services. It simplifies the process of handling materials, pricing, and database management, optimizing efficiency and accuracy.

**About i3Digit**

At i3Digit, we specialize in 3D printing and modeling services, dealing with a vast array of materials essential for the printing process. With numerous filament types available, each with its unique price and weight, manually calculating costs becomes labor-intensive. i3Digit OS resolves this challenge by providing a suite of user-friendly functions, significantly reducing time spent on routine calculations. By storing all material information in a MySQL database, users can effortlessly access data without the need for repetitive manual inputs of material details.

**Key Functions & Roadmap**

i3Digit OS offers three primary functions which is divided into development phases:

- **PHASE 1 - PRESENT VERSION** - Data Management: Easily write, read, and delete filament data within the database. Simplify the handling of various materials used in 3D printing.

- PHASE 2 - Price Calculation: Seamlessly calculate the end price of 3D printed products based on user selections. Efficiently manage cost estimations and optimize pricing strategies.

- PHASE 3 - Printer Integration: The application features a dedicated Printer tab, aiming to streamline the integration of different 3D printers. Each printer can be configured individually, catering to their unique functionalities.

### Back-End Overview

i3Digit OS uses pure Java Spring Boot back-end part which uses MySQL database for storing and reading the data. For front-end part Angular framework is used and whole communication will be done through REST application programming interface.

- Spring boot back-end is developed on Java 17 language version.
- Version 8 of MySQL is used.

**Setting up back-end for use**

- Look for application.yml file in .../operatingSystem/src/main/resources folder and enter your correct MySQL username and password. 
- No need for changing other database settings by default. When launching Spring Boot back-end, filamentdb table will be created automatically into your MySQL database and if it already exists then previous data is not deleted or overwritten. All data will be untouched when application is launched or terminated. *To reset database user has to drop table in MySQL Workbench.*
- That is all for back-end part!