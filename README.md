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
1. Java Development Kit (JDK) installed (version 8 or later)
2. Apache Maven installed (for building the project)
3. Git installed (for cloning the project repository)


#### Steps
1. Clone the Repository
   ```
   git clone https://github.com/rutujawaghahchoure/FetchApplication.git
   ```
2. Navigate to the Project Directory:
   ```
   cd Receipt-Processor
   ```
3. Build the Project
   mvn clean install

4. Run the Application
   ```
   java -jar target/receipt-service-1.0.0.jar
   ```
