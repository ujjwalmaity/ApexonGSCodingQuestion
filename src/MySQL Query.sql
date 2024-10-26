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
having total_salary > 15000;

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

select e.id, e.salary, (e.salary * 1.12) as increased_salary, d.id, d.name from Employees e
join Departments d on e.department_id = d.id
where d.name = 'Finance';

update Employees e
join Departments d on e.department_id = d.id
set e.salary = e.salary * 1.12
where d.name = 'Finance';

select * from Employees
where last_name like 'S%';

select e.department_id, d.name, count(e.department_id) as count from Employees e
join Departments d on e.department_id = d.id
group by e.department_id;

select id, title, sum(hours_worked) as total_hours_worked from EmployeeProjects
join Projects on project_id = id
group by project_id;

select * from Employees
where salary > (select avg(salary) from Employees);

select id, title, date_format(start_date,'%M %d, %Y') as formatted_start_date from Projects;

# select * from Employees e
# select e.id, e.first_name, e.last_name, d.name as department_name, p.title as project_title from Employees e
select e.id, concat(e.first_name, ' ', e.last_name) as full_name, d.name as department_name, p.title as project_title from Employees e
join Departments d on e.department_id = d.id
left join EmployeeProjects ep on e.id = ep.employee_id
left join Projects p on ep.project_id = p.id
order by e.id asc;

# select * from Projects p
select p.id, p.title,
	case
		# when ep.project_id then 'Assigned'
		# when p.id = ep.project_id then 'Assigned'
        when ep.project_id is not null then 'Assigned'
        else 'Unassigned'
    end as status
from Projects p
left join EmployeeProjects ep on p.id = ep.project_id
group by p.id;

select e.department_id, d.name as department_name, round(avg(e.salary), 2) as average_salary from Employees e
join Departments d on e.department_id = d.id
group by e.department_id
having count(e.id) > 1;

select id, concat(first_name, ' ', last_name) as full_name from Employees;

select * from Employees e
join Departments d on e.department_id = d.id
where e.salary > 5000 and d.name = 'IT';

update Employees e
join Departments d on e.department_id = d.id
set e.salary = 7000
where e.salary > 6500 and d.name = 'IT';

select * from Employees
where department_id = 
	(select id from Departments where name = 'HR')
and salary = 
	(select max(salary) from Employees e
    join Departments d on e.department_id = d.id
    where name = 'HR');

select * from Employees e
join Departments d on e.department_id = d.id
where d.name = 'HR' and e.salary = 
	(select max(salary) from Employees e
	join Departments d on e.department_id = d.id
	where d.name = 'HR');

select * from Employees e
join Departments d on e.department_id = d.id
where d.name = 'HR'
order by salary desc
limit 1;

select * from Employees e
join EmployeeProjects ep on e.id = ep.employee_id
join Projects p on ep.project_id = p.id
# where p.end_date between current_date and (current_date + interval 2 month);
where p.end_date between curdate() and date_add(curdate(), interval 2 month);

select p.id as project_id, p.title as project_title, p.budget as project_budget, 
       sum(e.salary * ep.hours_worked) as total_billed,
       # row_number() over(order by project_id asc) as line_number
       # row_number() over(order by project_id) as line_number
       row_number() over() as line_number
from Projects p
join EmployeeProjects ep on p.id = ep.project_id
join Employees e on ep.employee_id = e.id
group by p.id
having total_billed > 10000;

# truncate table EmployeeProjects;
# drop table EmployeeProjects;
