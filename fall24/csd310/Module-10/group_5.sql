-- Group 5 Bacchus sql script

-- Create Bacchus database
CREATE DATABASE bacchus
    DEFAULT CHARACTER SET = 'utf8mb4';

USE bacchus

-- Create Department table
CREATE TABLE Department (
    department_id INT PRIMARY KEY AUTO_INCREMENT,
    department_name VARCHAR(50) NOT NULL
);

-- Create Position table
CREATE TABLE Position (
    position_id INT PRIMARY KEY AUTO_INCREMENT,
    position_name VARCHAR(50) NOT NULL,
    department_id INT,
    FOREIGN KEY (department_id) REFERENCES Department(department_id)
);

-- Create Employee table
CREATE TABLE Employee (
    employee_id INT PRIMARY KEY AUTO_INCREMENT,
    employee_first_name VARCHAR(50) NOT NULL,
    employee_last_name VARCHAR(50) NOT NULL,
    position_id INT,
    department_id INT,
    FOREIGN KEY (position_id) REFERENCES Position(position_id),
    FOREIGN KEY (department_id) REFERENCES Department(department_id)
);

-- Create WorkHours table
CREATE TABLE WorkHours (
    work_hours_id INT PRIMARY KEY AUTO_INCREMENT,
    employee_id INT,
    work_date DATE,
    hours_worked DECIMAL(5,2),
    hourly_rate DECIMAL(6,2),
    FOREIGN KEY (employee_id) REFERENCES Employee(employee_id)
);

-- Create Supplier table
CREATE TABLE Supplier (
    supplier_id INT PRIMARY KEY AUTO_INCREMENT,
    supplier_name VARCHAR(100) NOT NULL,
    supply_type VARCHAR(50)
);

-- Create Inventory table
CREATE TABLE Inventory (
    inventory_id INT PRIMARY KEY AUTO_INCREMENT,
    item_name VARCHAR(100) NOT NULL,
    current_quantity INT,
    supplier_id INT,
    last_delivery_date DATE,
    FOREIGN KEY (supplier_id) REFERENCES Supplier(supplier_id)
);

-- Create Wine table
CREATE TABLE Wine (
    wine_id INT PRIMARY KEY AUTO_INCREMENT,
    wine_name VARCHAR(100) NOT NULL,
    wine_type VARCHAR(50),
    inventory_id INT,
    FOREIGN KEY (inventory_id) REFERENCES Inventory(inventory_id)
);

-- Create Distributor table
CREATE TABLE Distributor (
    distributor_id INT PRIMARY KEY AUTO_INCREMENT,
    distributor_name VARCHAR(100) NOT NULL,
    wine_id INT,
    FOREIGN KEY (wine_id) REFERENCES Wine(wine_id)
);

-- Create Order table
CREATE TABLE `Order` (
    order_id INT PRIMARY KEY AUTO_INCREMENT,
    distributor_id INT,
    wine_id INT,
    order_date DATE,
    shipment_date DATE,
    quantity_ordered INT,
    order_status VARCHAR(20),
    FOREIGN KEY (distributor_id) REFERENCES Distributor(distributor_id),
    FOREIGN KEY (wine_id) REFERENCES Wine(wine_id)
);

-- Create Delivery table
CREATE TABLE Delivery (
    delivery_id INT PRIMARY KEY AUTO_INCREMENT,
    supplier_id INT,
    expected_delivery_date DATE,
    actual_delivery_date DATE,
    delivery_status VARCHAR(20),
    tracking_number VARCHAR(50),
    FOREIGN KEY (supplier_id) REFERENCES Supplier(supplier_id)
);

-- Insert sample data

-- Department
INSERT INTO Department (department_name) VALUES 
('Finance'), ('Marketing'), ('Production'), ('Distribution'), ('Sales'), ('Technology');

-- Position
INSERT INTO Position (position_name, department_id) VALUES 
('Finance Manager', 1),
('Marketing Director', 2),
('Administrative Assistant', 2),
('Production Manager', 3),
('Warehouse Manager', 4),
('Sales Associate', 5);

