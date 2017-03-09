package SQL_Query;

/**
Write a SQL query to find all duplicate emails in a table named Person.

+----+---------+
| Id | Email   |
+----+---------+
| 1  | a@b.com |
| 2  | c@d.com |
| 3  | a@b.com |
+----+---------+
For example, your query should return the following for the above table:

+---------+
| Email   |
+---------+
| a@b.com |
+---------+
Note: All emails are in lowercase.


Solution:

Select p.Email
from Person p
group by p.Email
having count(p.Email) > 1;



 *
 *
 */
public class LC_182_Duplicate_Emails {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		Select p.Email
		from Person p
		group by p.Email
		having count(p.Email) > 1;
		*/
	}

}
