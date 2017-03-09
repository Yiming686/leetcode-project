package SQL_Query;

import java.util.Random;

/**
 
184. Department Highest Salary

The Employee table holds all employees. Every employee has an Id, a salary, and there is also a column for the department Id.

+----+-------+--------+--------------+
| Id | Name  | Salary | DepartmentId |
+----+-------+--------+--------------+
| 1  | Joe   | 70000  | 1            |
| 2  | Henry | 80000  | 2            |
| 3  | Sam   | 60000  | 2            |
| 4  | Max   | 90000  | 1            |
+----+-------+--------+--------------+
The Department table holds all departments of the company.

+----+----------+
| Id | Name     |
+----+----------+
| 1  | IT       |
| 2  | Sales    |
+----+----------+
Write a SQL query to find employees who have the highest salary in each of the departments. 
For the above tables, Max has the highest salary in the IT department and Henry has the highest salary 
in the Sales department.

+------------+----------+--------+
| Department | Employee | Salary |
+------------+----------+--------+
| IT         | Max      | 90000  |
| Sales      | Henry    | 80000  |
+------------+----------+--------+
Subscribe to see which companies asked this question.

========================================================================================== 
 Solution:
 
 select m.DepartmentName Department, e.Name Employee, m.Salary
from
(
    select d.id DepartmentId,d.Name DepartmentName, max(e.Salary) Salary
    from Employee e
    join Department d 
    on e.DepartmentId = d.Id
    group by d.id
) m
join Employee e
on m.DepartmentId = e.DepartmentId and m.Salary = e.Salary

--------------------------------------------------------------------------------------------------------
我们也可以不用Join关键字，直接用Where将两表连起来，然后找最高薪水的方法和上面相同：
解法二：

SELECT d.Name AS Department, e.Name AS Employee, e.Salary FROM Employee e, Department d
WHERE e.DepartmentId = d.Id AND e.Salary = (SELECT MAX(Salary) FROM Employee e2 WHERE e2.DepartmentId = d.Id);

--------------------------------------------------------------------------------------------------------
下面这种方法没用用到Max关键字，而是用了>=符号，实现的效果跟Max关键字相同，参见代码如下：

解法三：

SELECT d.Name AS Department, e.Name AS Employee, e.Salary 
FROM Employee e, Department d
WHERE e.DepartmentId = d.Id AND e.Salary >= ALL (SELECT Salary FROM Employee e2 WHERE e2.DepartmentId = d.Id);

 
 *
 */
public class LC_184_Department_Highest_Salary {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int index = new Random().nextInt(14);
        System.out.println(""+index);
	}

}
