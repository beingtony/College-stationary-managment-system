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
   
3. **Update User Details**:
   - Customers can update their profile details, including email, phone number, and address.
   
## Database Schema
The system uses the following tables:

### 1. **Admin Table**
Stores admin user details.
```sql
CREATE TABLE Admin (
    Admin_id INT PRIMARY KEY,
    Admin_name VARCHAR(255),
    Password VARCHAR(255)
);