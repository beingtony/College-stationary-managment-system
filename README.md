Here's the code for the `README.md` file, formatted for Markdown:

```markdown
# Product Inventory Management System

## Overview
This project is designed to manage the inventory of products in a store. It includes features for displaying product data, generating analytics, handling notifications for low stock products, and more. The application is built using Java Swing for the user interface and MySQL for the backend database.

## Features
- **Load Data**: Load product data from the database into the table.
- **Show Analytics**: Display analytics on products, including total products, average price, maximum price, and minimum price.
- **Show Notifications**: Display notifications about products that have a stock quantity of less than 10.
- **Back**: Navigate back to the introductory page.

## Prerequisites
Ensure that the following software is installed:
- Java Development Kit (JDK)
- MySQL Database Server
- JDBC Driver for MySQL

## Database Schema
The project uses the following MySQL tables:
- **Product**: Contains product details like `P_Id`, `P_Name`, `Price`, `Category`, `Quantity`, and `Admin_id`.
- **Notifications**: Contains low stock products with `P_Name` and `Quantity`.

## Application Flow
1. **Load Data Button**:
   - This button retrieves all the products from the `Product` table in the database and displays them in a table.
   
2. **Show Analytics Button**:
   - This button displays the following product analytics:
     - Total number of products
     - Average product price
     - Highest and lowest product price
   - The analytics are fetched from the `Product` table.

3. **Show Notifications Button**:
   - This button retrieves the products with quantities less than 10 from the `Notifications` table and displays them in a notification format.
   
4. **Back Button**:
   - This button allows the user to navigate back to the introductory page.

## Code Explanation
### 1. **`btnLoad`**:
   - Fetches product data from the `Product` table and displays it in the table.
   
### 2. **`btnAnalytics`**:
   - Fetches and displays product analytics:
     - Total products
     - Average price
     - Maximum and minimum prices
     
### 3. **`btnShowNotifications`**:
   - Fetches and displays products with low stock from the `Notifications` table.
   
### 4. **`btnBack`**:
   - Navigates the user back to the introduction page.

## How to Run
1. Clone the repository.
2. Set up a MySQL database with the necessary tables (`Product`, `Notifications`).
3. Ensure the JDBC driver is set up in your project.
4. Compile and run the project in your Java IDE (e.g., IntelliJ IDEA, Eclipse).

```bash
javac ProductInventoryManagement.java
java ProductInventoryManagement
```

## Sample Output
### Product Data
The table will display product details such as:
| P_Id | P_Name | Price | Category | Quantity | Admin_id |
|------|--------|-------|----------|----------|----------|
| 1    | Item A | 100   | Electronics | 50      | 1        |

### Analytics
A dialog box will show:
```
Total Products: 100
Average Price: 150.5
Highest Price: 300
Lowest Price: 50
```

### Notifications
A dialog box will show:
```
Low Stock Products:

Product: Item A, Quantity: 5
Product: Item B, Quantity: 3
```
