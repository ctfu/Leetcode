Kinds of joins in SQL:
Inner Join: return records that have matched in both tables (intersection)
Left (Outer) Join: retrun all records from the left table, and the matched records from the right tables
Right (Outer) Join: return all records from the right table, and the matched records from teh left table
Full (Outer) Join: return all records when there is a match in either table

# Write your MySQL query statement below
/* since the question states that there might not be an address for each people in the Person table
* we can use left join */
select Person.FirstName, Person.LastName, Address.City, Address.State
from Person left join Address on Person.PersonId=Address.PersonId
