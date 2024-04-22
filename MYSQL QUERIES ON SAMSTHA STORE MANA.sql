MYSQL QUERIES ON SAMSTHA STORE MANAGEMENT SYSTEM
1.Describe &Show all tables
mysql> use trial;
Database changed
mysql> show tables;
+-----------------+
| Tables_in_trial |
+-----------------+
| admin |
| customer |
| log |
| product |
| transaction |
+-----------------+
5 rows in set (0.00 sec)
mysql> desc admin;
+----------+-------------+------+-----+---------+-------+
| Field | Type | Null | Key | Default | Extra |
+----------+-------------+------+-----+---------+-------+
| Admin_id | int | NO | PRI | NULL | |
| Username | varchar(30) | NO | | NULL | |
| Password | varchar(15) | NO | | NULL | |
+----------+-------------+------+-----+---------+-------+
3 rows in set (0.00 sec)
mysql> desc customer;
+--------------+--------------+------+-----+---------+-------+
| Field | Type | Null | Key | Default | Extra |
+--------------+--------------+------+-----+---------+-------+
| roll_number | varchar(10) | NO | PRI | NULL | |
| Student_name | varchar(255) | YES | | NULL | |
| phno | varchar(10) | YES | | NULL | |
| department | varchar(255) | YES | | NULL | |
+--------------+--------------+------+-----+---------+-------+
4 rows in set (0.00 sec)
mysql> desc log;
+-------------+-------------+------+-----+---------+----------------+
| Field | Type | Null | Key | Default | Extra |
+-------------+-------------+------+-----+---------+----------------+
| sr_no | int | NO | PRI | NULL | auto_increment |
| roll_number | varchar(10) | YES | | NULL | |
| phno | varchar(10) | YES | | NULL | |
+-------------+-------------+------+-----+---------+----------------+
3 rows in set (0.00 sec)
mysql> desc product;
+----------+-------------+------+-----+---------+-------+
| Field | Type | Null | Key | Default | Extra |
+----------+-------------+------+-----+---------+-------+
| P_Id | int | NO | PRI | NULL | |
| P_Name | varchar(50) | NO | | NULL | |
| Price | int | NO | | NULL | |
| Category | varchar(50) | NO | | NULL | |
| Quantity | int | NO | | NULL | |
| Admin_id | int | YES | MUL | NULL | |
+----------+-------------+------+-----+---------+-------+
6 rows in set (0.00 sec)
mysql> desc transaction;
+-------------+---------------+------+-----+---------+----------------+
| Field | Type | Null | Key | Default | Extra |
+-------------+---------------+------+-----+---------+----------------+
| t_id | int | NO | PRI | NULL | auto_increment |
| P_Id | int | NO | | NULL | |
| P_name | varchar(50) | NO | | NULL | |
| quantity | int | NO | | NULL | |
| time_date | date | NO | | NULL | |
| Total_Price | decimal(10,2) | YES | | NULL | |
| roll_number | varchar(10) | YES | | NULL | |
+-------------+---------------+------+-----+---------+----------------+
7 rows in set (0.00 sec)
mysql> select* from admin;
+----------+------------------+----------+
| Admin_id | Username | Password |
+----------+------------------+----------+
| 101 | Divya Pardeshi | Div123 |
| 102 | Divya Ganeshwala | Div456 |
| 103 | Rutuja Dhirde | Rutu456 |
+----------+------------------+----------+
3 rows in set (0.00 sec)
mysql> select * from customer;
+-------------+---------------+------------+------------+
| roll_number | Student_name | phno | department |
+-------------+---------------+------------+------------+
| 1 | Rose | NULL | NULL |
| 2 | Harry | NULL | NULL |
| 3 | Divya | 2 | computer |
| uce2022447 | Khyati shetty | 6666677777 | computer |
| uce2022448 | k | 6666655555 | computer |
| uce2022451 | Shrutika | 5151515151 | computer |
| uce2022452 | avani | 5252525252 | computer |
| uce2022453 | rutuja d | 5555566667 | computer |
| uce2022454 | bhakti | 5454545454 | computer |
| uce2022455 | divya p | 9890200573 | computer |
| uce2022456 | divya | 776040097 | computer |
| uce2022457 | ketaki dixit | 5757575757 | computer |
+-------------+---------------+------------+------------+
12 rows in set (0.00 sec)
mysql> select * from log;
+-------+-------------+------------+
| sr_no | roll_number | phno |
+-------+-------------+------------+
| 1 | uce2022447 | 6666677777 |
| 2 | uce2022447 | 6666677777 |
| 3 | uce2022447 | 6666677777 |
| 4 | uce2022447 | 6666677777 |
| 5 | uce2022447 | 6666677777 |
| 6 | uce2022447 | 6666677777 |
| 7 | uce2022447 | 6666677777 |
| 8 | uce2022447 | 6666677777 |
| 9 | uce2022447 | 6666677777 |
| 10 | uce2022447 | 6666677777 |
| 11 | uce2022447 | 6666677777 |
| 12 | uce2022447 | 6666677777 |
| 13 | uce2022447 | 6666677777 |
| 14 | uce2022447 | 6666677777 |
| 15 | uce2022447 | 6666677777 |
| 16 | uce2022447 | 6666677777 |
| 17 | uce2022447 | 6666677777 |
| 18 | uce2022447 | 6666677777 |
| 19 | uce2022447 | 6666677777 |
| 20 | uce2022447 | 6666677777 |
| 21 | uce2022447 | 6666677777 |
| 22 | uce2022447 | 6666677777 |
| 23 | uce2022447 | 6666677777 |
| 24 | uce2022456 | 6666677777 |
| 25 | uce2022447 | 6666677777 |
| 26 | UCE2022447 | 6666677777 |
| 27 | uce2022447 | 6666677777 |
| 28 | uce2022451 | 5151515151 |
| 29 | uce2022454 | 5454545454 |
| 30 | uce2022457 | 5757575757 |
| 31 | uce2022447 | 4747474747 |
| 32 | uce2022447 | 6666677777 |
| 33 | uce2022447 | 6666677777 |
| 34 | uce2022447 | 6666677777 |
| 35 | uce2022447 | 6666677777 |
| 36 | uce2022447 | 6666677777 |
| 37 | UCE2022447 | 6666677777 |
| 38 | uce2022447 | 6666677777 |
| 39 | uce2022447 | 6666677777 |
| 40 | uce2022447 | 6666677777 |
+-------+-------------+------------+
40 rows in set (0.00 sec)
mysql> select * from product;
+------+--------------------------+-------+------------+----------+----------+
| P_Id | P_Name | Price | Category | Quantity | Admin_id |
+------+--------------------------+-------+------------+----------+----------+
| 1 | Plain sheet | 1 | stationery | 100 | 101 |
| 2 | One sided Ruled sheet | 2 | stationery | 100 | 102 |
| 3 | Double sided Ruled sheet | 2 | stationery | 100 | 102 |
| 4 | Index sheet | 2 | stationery | 100 | 102 |
| 5 | Graph paper | 3 | stationery | 100 | 103 |
| 6 | Logarithmic Graph paper | 3 | stationery | 100 | 103 |
| 7 | FY file | 1 | stationery | 100 | 103 |
| 8 | SY file | 1 | stationery | 100 | 103 |
| 9 | TY file | 1 | stationery | 100 | 103 |
| 10 | BTech file | 1 | stationery | 100 | 103 |
+------+--------------------------+-------+------------+----------+----------+
10 rows in set (0.00 sec)
mysql> select * from transaction;
+------+------+---------------+----------+------------+-------------+-------------+
| t_id | P_Id | P_name | quantity | time_date | Total_Price | roll_number |
+------+------+---------------+----------+------------+-------------+-------------+
| 1 | 1 | Index Sheets | 2 | 2024-04-02 | 10.00 | NULL |
| 2 | 2 | Ruled Sheets | 3 | 2024-04-02 | 30.00 | NULL |
| 3 | 3 | Plain Sheets | 5 | 2024-04-02 | 25.00 | NULL |
| 4 | 1 | Index Sheets | 1 | 2024-04-02 | 5.00 | NULL |
| 5 | 1 | Index Sheets | 12 | 2024-04-04 | 60.00 | NULL |
| 6 | 1 | Index Sheets | 12 | 2024-04-04 | 60.00 | NULL |
| 7 | 1 | Index Sheets | 12 | 2024-04-04 | 60.00 | NULL |
| 8 | 1 | Index Sheets | 12 | 2024-04-04 | 60.00 | NULL |
| 9 | 1 | Index Sheets | 12 | 2024-04-04 | 60.00 | NULL |
| 11 | 1 | Index Sheets | 23 | 2024-04-05 | 69.00 | uce2022456 |
| 12 | 1 | Index Sheets | 23 | 2024-04-05 | 69.00 | uce2022456 |
| 13 | 1 | Index Sheets | 23 | 2024-04-05 | 69.00 | uce2022456 |
| 14 | 1 | Index Sheets | 23 | 2024-04-05 | 69.00 | 1 |
| 16 | 1 | Index Sheets | 15 | 2024-04-05 | 45.00 | uce2022455 |
| 23 | 2 | Ruled Sheets | 2 | 2024-04-07 | 20.00 | 111 |
| 24 | 1 | plain sheets | 4 | 2024-04-07 | 12.00 | 111 |
| 25 | 1 | plain sheets | 4 | 2024-04-07 | 12.00 | 111 |
| 31 | 4 | graph | 4 | 2024-04-07 | 16.00 | uce2022447 |
| 32 | 1 | plain sheets | 1 | 2024-04-08 | 3.00 | u |
| 33 | 1 | plain sheets | 1 | 2024-04-08 | 3.00 | uce2022453 |
| 34 | 1 | plain sheets | 3 | 2024-04-08 | 9.00 | a
|
| 35 | 1 | plain sheets | 1 | 2024-04-08 | 3.00 | uce2022448 |
| 37 | 2 | Ruled Sheets | 5 | 2024-04-08 | 50.00 | uce2022453 |
| 38 | 1 | plain sheets | 4 | 2024-04-08 | 12.00 | abs |
| 39 | 3 | index page | 3 | 2024-04-13 | 9.00 | uce2022447 |
| 41 | 7 | SY comp file | 4 | 2024-04-13 | 4.00 | uce2022447 |
| 42 | 4 | graph | 5 | 2024-04-13 | 25.00 | uce2022447 |
| 43 | 4 | graph | 5 | 2024-04-13 | 25.00 | uce2022447 |
| 44 | 4 | graph | 5 | 2024-04-13 | 25.00 | uce2022454 |
| 46 | 4 | graph | 4 | 2024-04-14 | 20.00 | uce2022447 |
+------+------+---------------+----------+------------+-------------+-------------+
30 rows in set (0.00 sec)
2.Select * from Admin where Username = '"+username+"' and Password = '"+password
SELECT * FROM admin WHERE Username = 'Divya Pardeshi' AND Password = 'Div123';
+----------+------------------+----------+
| Admin_id | Username | Password |
+----------+------------------+----------+
| 101 | Divya Pardeshi | Div123 |
+----------+------------------+----------+
3."Select t_id from transaction order by t_id DESC LIMIT 1
+------+
| t_id |
+------+
| 46 |
+------+
4.Select roll_number from transaction order by t_id DESC LIMIT 1
+-------------+
| roll_number |
+-------------+
| uce2022447 |
+-------------+
5.Select Student_name from customer where roll_number = '"+rno+"'
SELECT Student_name FROM customer WHERE roll_number = '2';
+---------------+
| Student_name |
+---------------+
| Harry |
+---------------+
6.Select P_name from transaction order by t_id DESC LIMIT 1
+---------------+
| P_name |
+---------------+
| graph |
+---------------+
7.Select quantity from transaction order by t_id DESC LIMIT 1
+----------+
| quantity |
+----------+
| 4 |
+----------+
8.Select Total_price from transaction order by t_id DESC LIMIT 1
+-------------+
| Total_Price |
+-------------+
| 20.00 |
+-------------+
9.select roll_number from log order by sr_no desc limit 1";
+-------------+
| roll_number |
+-------------+
| uce2022447 |
+-------------+
10.Select quantity from transaction where roll_number= uce2022447 order by t_id DESC limit 1"
+----------+
| quantity |
+----------+
| 4 |
+----------+
11.Select p_Id from transaction where roll_number= '"uce2022457"'order by t_id DESC limit 1
+------+
| p_Id |
+------+
| 2 |
+------+
12.DELETE FROM transaction WHERE roll_number = 'uce2022457' ORDER BY t_id DESC LIMIT 1;
Query OK, 1 row affected
13.Select * from customer where roll_number='"+tt1+"'and phno='"+tt2+"'"
SELECT * FROM customer WHERE roll_number = 'uce2022458' AND phno = '1234567890';
+-------------+------------+------------+----------------+
| roll_number | Student_name | phno | department |
+-------------+------------+------------+----------------+
| uce2022458 | John Doe | 1234567890 | Computer Science |
+-------------+------------+------------+----------------+
14.SELECT Quantity FROM Product WHERE P_Id = 3;
+----------+
| Quantity |
+----------+
| 100 |
+----------+
15.SELECT Price FROM Product WHERE P_Id = 3;
+-------+
| Price |
+-------+
| 2 |
+-------+
16.select roll_number from log order by sr_no desc limit 1
+-------------+
| roll_number |
+-------------+
| uce2022447 |
+-------------+
17.INSERT INTO Product (P_Id, P_Name, Price, Category, Quantity, Admin_id)
VALUES (11, 'easer', 1, 'stationery', 100, 103);
+------+--------------------------+-------+------------+----------+----------+
| P_Id | P_Name | Price | Category | Quantity | Admin_id |
+------+--------------------------+-------+------------+----------+----------+
| 1 | Plain sheet | 1 | stationery | 100 | 101 |
| 2 | One sided Ruled sheet | 2 | stationery | 100 | 102 |
| 3 | Double sided Ruled sheet | 2 | stationery | 100 | 102 |
| 4 | Index sheet | 2 | stationery | 100 | 102 |
| 5 | Graph paper | 3 | stationery | 100 | 103 |
| 6 | Logarithmic Graph paper | 3 | stationery | 100 | 103 |
| 7 | FY file | 1 | stationery | 100 | 103 |
| 8 | SY file | 1 | stationery | 100 | 103 |
| 9 | TY file | 1 | stationery | 100 | 103 |
| 10 | BTech file | 1 | stationery | 100 | 103 |
| 11 | easer | 1 | stationery | 100 | 103 |
+------+--------------------------+-------+------------+----------+----------+
18.DELETE FROM Product WHERE P_Id = '11';
+------+--------------------------+-------+------------+----------+----------+
| P_Id | P_Name | Price | Category | Quantity | Admin_id |
+------+--------------------------+-------+------------+----------+----------+
| 1 | Plain sheet | 1 | stationery | 100 | 101 |
| 2 | One sided Ruled sheet | 2 | stationery | 100 | 102 |
| 3 | Double sided Ruled sheet | 2 | stationery | 100 | 102 |
| 4 | Index sheet | 2 | stationery | 100 | 102 |
| 5 | Graph paper | 3 | stationery | 100 | 103 |
| 6 | Logarithmic Graph paper | 3 | stationery | 100 | 103 |
| 7 | FY file | 1 | stationery | 100 | 103 |
| 8 | SY file | 1 | stationery | 100 | 103 |
| 9 | TY file | 1 | stationery | 100 | 103 |
| 10 | BTech file | 1 | stationery | 100 | 103 |
+------+--------------------------+-------+------------+----------+----------+
19.SELECT department, COUNT(*) AS total_students
FROM customer
GROUP BY department
ORDER BY total_students DESC;
+------------+----------------+
| department | total_students |
+------------+----------------+
| computer | 11 |
| NULL | 2 |
+------------+----------------+
20.SELECT Category, SUM(Quantity) AS total_quantity
FROM product
GROUP BY Category
ORDER BY total_quantity DESC;
+------------+----------------+
| Category | total_quantity |
+------------+----------------+
| stationery | 1100 |
+------------+----------------+
21.SELECT c.roll_number, c.Student_name, t.t_id
FROM customer c
LEFT OUTER JOIN transaction t ON c.roll_number = t.roll_number;
+-------------+---------------+------+
| roll_number | Student_name | t_id |
+-------------+---------------+------+
| 1 | Rose | NULL |
| 2 | Harry | NULL |
| 3 | Divya | NULL |
| uce2022447 | Khyati shetty | 1 |
| uce2022447 | Khyati shetty | 2 |
| uce2022448 | k | NULL |
| uce2022451 | Shrutika | NULL |
| uce2022454 | bhakti | NULL |
| uce2022455 | divya p | NULL |
| uce2022456 | divya | 11 |
| uce2022457 | ketaki dixit | NULL |
+-------------+---------------+------+
22.All transactions from Khyati
SELECT *
FROM transaction
WHERE roll_number IN (SELECT roll_number FROM customer WHERE Student_name = 'Khyati Shetty');
| t_id | P_Id | P_name | quantity | time_date | Total_Price | roll_number |
|------|------|--------------|----------|------------|-------------|-------------|
| 31 | 4 | graph | 4 | 2024-04-07 | 16.00 | uce2022447 |
| 39 | 3 | index page | 3 | 2024-04-13 | 9.00 | uce2022447 |
| 41 | 7 | SY comp file | 4 | 2024-04-13 | 4.00 | uce2022447 |
| 42 | 4 | graph | 5 | 2024-04-13 | 25.00 | uce2022447 |
| 43 | 4 | graph | 5 | 2024-04-13 | 25.00 | uce2022447 |
| 44 | 4 | graph | 5 | 2024-04-13 | 25.00 | uce2022454 |
| 46 | 4 | graph | 4 | 2024-04-14 | 20.00 | uce2022447 |
23.SELECT *
FROM transaction
WHERE time_date BETWEEN '2024-04-02' AND '2024-04-10';
+------+------+---------------+----------+------------+-------------+-------------+
| t_id | P_Id | P_name | quantity | time_date | Total_Price | roll_number |
+------+------+---------------+----------+------------+-------------+-------------+
| 1 | 1 | Index Sheets | 2 | 2024-04-02 | 10.00 | NULL |
| 2 | 2 | Ruled Sheets | 3 | 2024-04-02 | 30.00 | NULL |
| 3 | 3 | Plain Sheets | 5 | 2024-04-02 | 25.00 | NULL |
| 4 | 1 | Index Sheets | 1 | 2024-04-02 | 5.00 | NULL |
| 5 | 1 | Index Sheets | 12 | 2024-04-04 | 60.00 | NULL |
| 6 | 1 | Index Sheets | 12 | 2024-04-04 | 60.00 | NULL |
| 7 | 1 | Index Sheets | 12 | 2024-04-04 | 60.00 | NULL |
| 8 | 1 | Index Sheets | 12 | 2024-04-04 | 60.00 | NULL |
| 9 | 1 | Index Sheets | 12 | 2024-04-04 | 60.00 | NULL |
| 11 | 1 | Index Sheets | 23 | 2024-04-05 | 69.00 | uce2022456 |
| 12 | 1 | Index Sheets | 23 | 2024-04-05 | 69.00 | uce2022456 |
| 13 | 1 | Index Sheets | 23 | 2024-04-05 | 69.00 | uce2022456 |
| 14 | 1 | Index Sheets | 23 | 2024-04-05 | 69.00 | 1 |
| 16 | 1 | Index Sheets | 15 | 2024-04-05 | 45.00 | uce2022455 |
| 23 | 2 | Ruled Sheets | 2 | 2024-04-07 | 20.00 | 111 |
| 24 | 1 | plain sheets | 4 | 2024-04-07 | 12.00 | 111 |
| 25 | 1 | plain sheets | 4 | 2024-04-07 | 12.00 | 111 |
| 31 | 4 | graph | 4 | 2024-04-07 | 16.00 | uce2022447 |
| 32 | 1 | plain sheets | 1 | 2024-04-08 | 3.00 | u |
| 33 | 1 | plain sheets | 1 | 2024-04-08 | 3.00 | uce2022453 |
| 34 | 1 | plain sheets | 3 | 2024-04-08 | 9.00 | a
|
| 35 | 1 | plain sheets | 1 | 2024-04-08 | 3.00 | uce2022448 |
| 37 | 2 | Ruled Sheets | 5 | 2024-04-08 | 50.00 | uce2022453 |
| 38 | 1 | plain sheets | 4 | 2024-04-08 | 12.00 | abs |