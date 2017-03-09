package SQL_Query;

/**

Write a SQL query to get the second highest salary from the Employee table.

+----+--------+
| Id | Salary |
+----+--------+
| 1  | 100    |
| 2  | 200    |
| 3  | 300    |
+----+--------+
For example, given the above Employee table, the second highest salary is 200. 
If there is no second highest salary, then the query should return null

==============================================================================================
Solution:

-- worked
SELECT MAX(Salary) SecondHighestSalary FROM Employee
  WHERE Salary NOT IN (SELECT MAX(Salary) FROM Employee )

-- worked
SELECT MAX(Salary) SecondHighestSalary FROM Employee
  WHERE Salary != (SELECT MAX(Salary) FROM Employee )
  
-- worked
SELECT MAX(Salary) SecondHighestSalary FROM Employee
WHERE Salary < (SELECT MAX(Salary) FROM Employee)


-- BEST, worked
SELECT (SELECT Salary FROM Employee GROUP BY Salary ORDER BY Salary DESC LIMIT 1,1) SecondHighestSalary

-- BEST, worked
SELECT (SELECT Salary FROM Employee GROUP BY Salary ORDER BY Salary DESC LIMIT 1 offset 1) SecondHighestSalary


 
 *
 */
public class LC_176_Second_Highest_Salary {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
