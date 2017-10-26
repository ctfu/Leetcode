/*
LIMIT a - a is number of record to return
LIMIT a, b - a is the offset, b is number of record to return */
CREATE FUNCTION getNthHighestSalary(N INT) RETURNS INT
BEGIN
DECLARE M INT;
SET M = N - 1;
  RETURN (
      # Write your MySQL query statement below.
      SELECT DISTINCT Salary
        FROM Employee
        ORDER BY Salary DESC
        LIMIT M, 1
  );
END
