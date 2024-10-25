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

select id, salary,
    case
        when salary > 7000 then "Above $7000"
        else 'Below or Equal to $7000'
    end as salary_note
from Employees;

select * from Projects
where start_date >= current_date - interval 6 month;

select * from Projects
where start_date >= date_sub(curdate(), interval 6 month);

select * from Projects p
right join EmployeeProjects ep on p.id = ep.project_id;

# truncate table EmployeeProjects;
# drop table EmployeeProjects;