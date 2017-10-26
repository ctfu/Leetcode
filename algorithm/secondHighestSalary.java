/* use temp table to avoid if there is no second highest salary */
# Write your MySQL query statement below
select
    (select DISTINCT Salary
        from Employee
        order by Salary DESC
        limit 1 offset 1) as SecondHighestSalary
