create database db_7_apexon;
use db_7_apexon;

CREATE TABLE Departments (
    department_id INT AUTO_INCREMENT PRIMARY KEY,
    department_name VARCHAR(50)
);

CREATE TABLE Employees (
    employee_id INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(50),
    last_name VARCHAR(50),
    salary DECIMAL(10, 2),
    department_id INT,
    FOREIGN KEY (department_id) REFERENCES Departments(department_id)
);

CREATE TABLE Projects (
    project_id INT AUTO_INCREMENT PRIMARY KEY,
    project_name VARCHAR(100),
    start_date DATE,
    end_date DATE,
    budget DECIMAL(15, 2)
);

CREATE TABLE EmployeeProjects (
    employee_id INT,
    project_id INT,
    hours_worked INT,
    PRIMARY KEY (employee_id, project_id),
    FOREIGN KEY (employee_id) REFERENCES Employees(employee_id),
    FOREIGN KEY (project_id) REFERENCES Projects(project_id)
);

INSERT INTO Departments (department_name)
VALUES 
('HR'),
('IT'),
('Finance'),
('Operations'),
('Sales'),
('Marketing'),
('Admin'),
('Legal'),
('R&D'),
('Procurement');

INSERT INTO Employees (first_name, last_name, salary, department_id)
VALUES
('John', 'Doe', 5000, 1),
('Jane', 'Smith', 6200, 2),
('Michael', 'Johnson', 5500, 3),
('Emma', 'Williams', 4800, 4),
('Liam', 'Brown', 7100, 5),
('Olivia', 'Jones', 6400, 6),
('Noah', 'Miller', 7500, 7),
('Sophia', 'Davis', 8000, 8),
('William', 'Garcia', 4700, 9),
('James', 'Martinez', 7200, 10),
('Isabella', 'Robinson', 6300, 1),
('Benjamin', 'Clark', 6700, 2),
('Lucas', 'Rodriguez', 5100, 3),
('Mason', 'Lewis', 4600, 4),
('Ethan', 'Lee', 7000, 5),
('Harper', 'Walker', 6900, 6),
('Ava', 'Hall', 7700, 7),
('Elijah', 'Young', 8200, 8),
('Alexander', 'Allen', 5300, 9),
('Mia', 'King', 7100, 10);

INSERT INTO Projects (project_name, start_date, end_date, budget)
VALUES
('Project Alpha', '2024-01-01', '2024-06-30', 200000),
('Project Beta', '2024-02-15', '2024-09-30', 300000),
('Project Gamma', '2024-03-01', '2024-12-31', 150000),
('Project Delta', '2024-04-01', '2024-11-30', 250000),
('Project Epsilon', '2024-05-01', '2024-10-31', 350000),
('Project Zeta', '2024-06-15', '2024-12-15', 180000),
('Project Eta', '2024-07-01', '2024-12-01', 120000),
('Project Theta', '2024-08-01', '2024-12-31', 400000),
('Project Iota', '2024-09-01', '2024-12-31', 220000),
('Project Kappa', '2024-10-01', '2024-12-31', 320000);

INSERT INTO EmployeeProjects (employee_id, project_id, hours_worked)
VALUES
(1, 1, 120),
(2, 1, 160),
(3, 2, 140),
(4, 3, 100),
(5, 4, 180),
(6, 5, 130),
(7, 6, 150),
(8, 7, 170),
(9, 8, 200),
(10, 9, 90),
# (11, 10, 110),
(12, 1, 80),
(13, 2, 95),
(14, 3, 125),
(15, 4, 105),
(16, 5, 85),
(17, 6, 120),
(18, 7, 150),
(19, 8, 110),
(20, 9, 75);
