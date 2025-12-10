# Write your MySQL query statement below
select name, unique_id from Employees e left join
EmployeeUNI u
on e.id=u.id