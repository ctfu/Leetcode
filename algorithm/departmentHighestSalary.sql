# Write your MySQL query statement below
select D.Name as Department, E.Name as Employee, E.Salary
    from Department D, (select DepartmentId, max(Salary) as HighestSalary from Employee group by DepartmentId) Temp, Employee E
    where E.DepartmentId = Temp.DepartmentId
    and E.Salary = Temp.HighestSalary
    and E.DepartmentId = D.Id
