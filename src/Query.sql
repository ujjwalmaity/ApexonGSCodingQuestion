create database db_7_apexon;
use db_7_apexon;

select * from Departments;
select * from Employees;
select * from Projects;
select * from EmployeeProjects;

select * from Employees
order by salary desc
limit 5;

select * from Employees
order by salary ASC
limit 5 offset 10;

select department_id, SUM(salary) as total_salary from Employees
group by department_id
having total_salary > 30000;

SELECT employee_id, salary,
    CASE 
        WHEN salary > 7000 THEN 'Above $7000'
        ELSE 'Below or Equal to $7000'
    END AS salary_note
FROM employees;

# truncate table Departments;
# drop table Departments;