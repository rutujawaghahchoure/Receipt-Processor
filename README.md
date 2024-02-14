# Receipt Processor<br>
<br>

## Approach Used
### Overview
The approach used in the project involves building a Spring Boot application to implement a RESTful web service for processing receipts and calculating points based on predefined rules. 
The application is designed to be modular, maintainable, and scalable, following best practices in software development.

### Key Components<br>
1. Spring Boot: The project utilizes the Spring Boot framework to simplify the setup and development of the web service. Spring Boot provides features like auto-configuration, embedded servlet containers, and dependency management, making it easier to build robust and production-ready applications.<br>

2. RESTful Architecture: The application follows the principles of Representational State Transfer (REST) to design the API. It uses HTTP methods (GET, POST) and URIs to expose resources and perform operations, providing a clear and standardized interface for clients to interact with.<br>

3. Persistence Layer: The project uses an in-memory H2 database to store receipt data temporarily. This choice allows for quick setup and testing without the need for an external database. However, for production use, it's recommended to replace the in-memory database with a persistent database like MySQL or PostgreSQL.<br>

4. Entity-Repository Pattern: The application implements the Entity-Repository pattern for database interactions. Entities (e.g., Receipt) represent data models mapped to database tables, while repositories (e.g., ReceiptRepository) provide CRUD operations for managing entities. This separation of concerns promotes modularity and maintainability.<br>

5. Stream processing: Utilize Java Streams API for more concise and potentially more efficient processing of collections. Streams provide higher-level abstractions for working with collections, allowing you to express computations in a declarative manner.<br>


## Setup Instructions
Follow these instructions to set up the project environment and run the application on any operating system.

### Prerequisites
1. Java Development Kit (JDK) installed (version 8 or later)<br>
   You can check the installation steps here: https://docs.oracle.com/en/java/javase/21/install/overview-jdk-installation.html#GUID-8677A77F-231A-40F7-98B9-1FD0B48C346A
2. Apache Maven installed (for building the project)<br>
   Download maven from here: https://maven.apache.org/download.cgi <br>
   You can check the installation steps here: https://maven.apache.org/install.html <br>
   After installing maven and adding the PATH variable system should be restarted. <br>
5. Git installed (for cloning the project repository) <br>


#### Steps
1. Clone the Repository
   ```
   git clone https://github.com/rutujawaghahchoure/Receipt-Processor.git
   ```
2. Navigate to the Project Directory:
   ```
   cd Receipt-Processor
   ```
3. Build the Project
   ```
   mvn clean package
   ```

4. Run the Application
   ```
   java -jar target/receipt-processor.jar
   ```

6. Access the Application:<br>
   Once the application is running, you can access it at http://localhost:8080.

#### Usage
1. Processing Receipts<br>
    Endpoint: POST /receipts/process<br>
   Payload: JSON representation of a receipt<br>
   Example:
   ```
   curl -X POST -H "Content-Type: application/json" -d '{"retailer":"Target","purchaseDate":"2022-01-01","purchaseTime":"13:01","total":35.35,"items":[{"shortDescription":"Mountain Dew 12PK","price":"6.49"},{"shortDescription":"Emils Cheese Pizza","price":"12.25"},{"shortDescription":"Knorr Creamy Chicken","price":"1.26"},{"shortDescription":"Doritos Nacho Cheese","price":"3.35"},{"shortDescription":"Klarbrunn 12-PK 12 FL OZ","price":"12.00"}]}' http://localhost:8080/receipts/process
   ```

2. Retrieving Points<br>
   Endpoint: GET /receipts/{id}/points<br>
   Here, id is the id you get after executing the above command.
   Example:
   ```
   curl -X GET http://localhost:8080/receipts/{id}/points
   ```
