
```markdown
# Product Inventory Management System

## Overview
The **Product Inventory Management System** is a Java-based desktop application designed for store administrators and customers to manage product inventories efficiently. The system enables admins to perform CRUD operations on products, view product analytics, generate notifications for low stock, and more. Customers can also view available products, search for products, and generate receipts for their purchases. The application uses **Java Swing** for the GUI and **MySQL** for database management.

## Features
### Admin Features
1. **CRUD Operations on Products**:
   - **Create**: Add new products to the inventory.
   - **Read**: View all products with detailed information.
   - **Update**: Modify existing product details.
   - **Delete**: Remove products from the inventory.
   
2. **Product Analytics**: 
   - View statistics such as total number of products, average price, maximum price, and minimum price.

3. **Notifications for Low Stock**: 
   - Receive notifications for products with stock below 10 units.

4. **Transaction Management**:
   - Generate receipts for customer purchases.

5. **Product Management**:
   - View and manage product data, including inventory levels.

### Customer Features
1. **View Available Products**:
   - View products with details such as name, price, and category.

2. **Generate Receipts**:
   - Generate receipts based on their purchase.

3. **Product Query**:
   - Customers can query product availability and prices.

4. **Search Products**:
   - Customers can search for products by name or category.

### User Operations
1. **User Registration**:
   - Customers can register for an account to manage their purchase history and personal details.
   
2. **User Login**:
   - Registered customers can log in with their email and password to access their account.
   
## Database Schema
The system uses the following tables:

### 1. **Admin Table**
Stores admin user details.
CREATE TABLE Admin (
    Admin_id INT PRIMARY KEY,
    Admin_name VARCHAR(255),
    Password VARCHAR(255)
);

### 2. **Product Table**
Stores product details.
```sql
CREATE TABLE Product (
    P_Id INT PRIMARY KEY,
    P_Name VARCHAR(255),
    Price INT,
    Category VARCHAR(255),
    Quantity INT,
    Admin_id INT,
    FOREIGN KEY (Admin_id) REFERENCES Admin(Admin_id)
);
```

### 3. **Notifications Table**
Stores products with low stock (below 10).
```sql
CREATE TABLE Notifications (
    P_Name VARCHAR(255),
    Quantity INT
);
```

### 4. **Customer Table**
Stores customer details.
```sql
CREATE TABLE Customer (
    C_Id INT PRIMARY KEY,
    C_Name VARCHAR(255),
    Email VARCHAR(255),
    Phone VARCHAR(20),
    Password VARCHAR(255),
    Address VARCHAR(255)
);
```

### 5. **Transaction Table**
Stores purchase transactions.
```sql
CREATE TABLE Transaction (
    T_Id INT PRIMARY KEY,
    C_Id INT,
    P_Id INT,
    Quantity INT,
    Total_Price INT,
    Transaction_Date DATETIME,
    FOREIGN KEY (C_Id) REFERENCES Customer(C_Id),
    FOREIGN KEY (P_Id) REFERENCES Product(P_Id)
);
```


### 6. **Order Table**
Stores order details after checkout.
```sql
CREATE TABLE Order (
    O_Id INT PRIMARY KEY,
    C_Id INT,
    Order_Date DATETIME,
    Total_Price INT,
    Status VARCHAR(255),
    FOREIGN KEY (C_Id) REFERENCES Customer(C_Id)
);
```

## Admin Functionalities
### 1. **CRUD Operations on Products**:
   - **Create Product**: Admins can add new products to the system, providing details like product name, price, category, and quantity.
   
   ```java
   String query = "INSERT INTO Product (P_Name, Price, Category, Quantity, Admin_id) VALUES (?, ?, ?, ?, ?)";
   ```
   
   - **Read Product**: Admins can view all product information in a table format.
   
   ```java
   String query = "SELECT * FROM Product";
   PreparedStatement ps = conn.prepareStatement(query);
   ResultSet rs = ps.executeQuery();
   ```
   
   - **Update Product**: Admins can modify product details (price, quantity, etc.).
   
   ```java
   String query = "UPDATE Product SET Price = ?, Quantity = ? WHERE P_Id = ?";
   ```
   
   - **Delete Product**: Admins can delete a product from the inventory.
   
   ```java
   String query = "DELETE FROM Product WHERE P_Id = ?";
   ```

### 2. **Product Analytics**:
Admins can view product-related statistics:
   - **Total number of products**
   - **Maximum price of products**
   - **Minimum price of products**

   Example query for total product count and price analytics:
   
   ```java
   String query = "SELECT COUNT(*) AS totalProducts, AVG(Price) AS avgPrice, MAX(Price) AS maxPrice, MIN(Price) AS minPrice FROM Product";
   ```

### 3. **Notifications for Low Stock**:
Admins can view notifications for products with a quantity less than 10.
   
   ```java
   String query = "SELECT P_Name, Quantity FROM Product WHERE Quantity < 10";
   ```

### 4. **Transaction Management**:
Admins can generate receipts for customer purchases by recording the product, quantity, total price, and transaction date.

   ```java
   String query = "INSERT INTO Transaction (C_Id, P_Id, Quantity, Total_Price, Transaction_Date) VALUES (?, ?, ?, ?, NOW())";
   ```

## Customer Functionalities
### 1. **View Available Products**:
Customers can view the list of available products with information like:
   - Product name
   - Price
   - Category
   
### 2. **Generate Receipts**:
Customers can generate a receipt for their purchase, which includes:
   - Product name
   - Quantity
   - Total price

### 3. **Product Query**:
Customers can search for products by name or category to see if they are available.

### 4. **User Registration**:
Customers can register with their email, phone number, and address to create an account.

### 5. **User Login**:
Customers can log in with their email and password to access their account and manage their purchases.

### 6. **Update User Details**:
Customers can update their profile details, such as email, phone number, and address.


## How to Use

### 1. **Load Data Button (Admin)**:
   - The **Load Data** button fetches all product data from the `Product` table and displays it in a table on the GUI.
   - It queries the `Product` table and updates the table view with product details such as `P_Id`, `P_Name`, `Price`, `Category`, `Quantity`, and `Admin_id`.

### 2. **CRUD Operations on Products (Admin)**:
   - **Add Product**: Admin can click the "Add Product" button to input new product data and insert it into the database.
   - **Update Product**: Admin can modify product data by selecting an item from the list and updating its fields.
   - **Delete Product**: Admin can delete selected products from the inventory.

### 3. **Show Analytics (Admin)**:
   - The **Show Analytics** button displays key statistics about products such as total number, average price, maximum price, and minimum price.
   
   Example output:
   ```
   Total Products: 100
   Average Price: 150.5
   Highest Price: 300
   Lowest Price: 50
   ```

### 4. **Show Notifications (Admin)**:
   - The **Show Notifications** button shows products that are low in stock (quantity below 10).
   
   Example output:
   ```
   Low Stock Products:
   Product: Item A, Quantity: 5
   Product: Item B, Quantity: 3
   ```

### 5. **Generate Receipt (Customer)**:
   - Customers can generate receipts for their purchases, including the product name, quantity, and total price.

### 6. **View Products (Customer)**:
   - Customers can browse available products by viewing the list in the table.

### 7. **Search for Products (Customer)**:
   - Customers can search for products by name or category to see if they are available.

### 8. **User Registration and Login**:
   - Customers can register and log in to access their personal information and purchase history.

### 9. **Update User Details**:
   - Customers can update their profile information such as email, phone number, and address.

### 10. **Add to Cart and Checkout**:
   - Customers can add products to their cart and proceed to checkout.

## How to Run

1. **Clone the Repository**:
   Clone the repository to your local machine.

```bash
git clone https://github.com/your-username/product-inventory-management.git
```

2. **Setup Database**:
   Create a MySQL database with the following structure:

```sql
CREATE DATABASE project;
USE project;

CREATE TABLE Admin (
    Admin_id INT PRIMARY KEY,
    Admin_name VARCHAR(255),
    Password VARCHAR(255)
);

CREATE TABLE Product (
    P_Id INT PRIMARY KEY,
    P_Name VARCHAR(255),
    Price INT,
    Category VARCHAR(255),
    Quantity INT,
    Admin_id INT,
    FOREIGN KEY (Admin_id) REFERENCES Admin(Admin_id)
);

CREATE TABLE Notifications (
    P_Name VARCHAR(255),
    Quantity INT
);

CREATE TABLE Customer (
    C_Id INT PRIMARY KEY,
    C_Name VARCHAR(255),
    Email VARCHAR(255),
    Phone VARCHAR(20),
    Password VARCHAR(255),
    Address VARCHAR(255)
);

CREATE TABLE Transaction (
    T_Id INT PRIMARY KEY,
    C_Id INT,
    P_Id INT,
    Quantity INT,
    Total_Price INT,
    Transaction_Date DATETIME,
    FOREIGN KEY (C_Id) REFERENCES Customer(C_Id),
    FOREIGN KEY (P_Id) REFERENCES Product(P_Id)
);

CREATE TABLE Cart (
    C_Id INT,
    P_Id INT,
    Quantity INT,
    FOREIGN KEY (C_Id) REFERENCES Customer(C_Id),
    FOREIGN KEY (P_Id) REFERENCES Product(P_Id)
);

CREATE TABLE Order (
    O_Id INT PRIMARY KEY,
    C_Id INT,
    Order_Date DATETIME,
    Total_Price INT,
    Status VARCHAR(255),
    FOREIGN KEY (C_Id) REFERENCES Customer(C_Id)
);
```

3. **Configure JDBC**:
   Ensure you have the **MySQL JDBC Driver** in your project’s classpath.
