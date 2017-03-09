package SQL_Query;

/**

178. Rank Scores

 Write a SQL query to rank scores. If there is a tie between two scores, both should have the same ranking. Note that after a tie, the next ranking number should be the next consecutive integer value. In other words, there should be no "holes" between ranks.

+----+-------+
| Id | Score |
+----+-------+
| 1  | 3.50  |
| 2  | 3.65  |
| 3  | 4.00  |
| 4  | 3.85  |
| 5  | 4.00  |
| 6  | 3.65  |
+----+-------+
For example, given the above Scores table, your query should generate the following report 
(order by highest score):

//join后，每一行在右边找到大于等于它的distinct的个数就是它的排名Rank
// 有几个Distinct分数大于等于当前分数 (Distinct分数排序)
+-------+------+
| Score | Rank |
+-------+------+
| 4.00  | 1    |
| 4.00  | 1    |
| 3.85  | 2    |
| 3.65  | 3    |
| 3.65  | 3    |
| 3.50  | 4    |
+-------+------+
Subscribe to see which companies asked this question

//join后，每一行在右边找到大于等于它的的个数就是它的排名Rank
// 有几个人取得的分数在当前人的分数前面+1(人员排序)
Follow Up：
+-------+------+
| Score | Rank |
+-------+------+
| 4.00  | 1    |
| 4.00  | 1    |
| 3.85  | 3    |
| 3.65  | 4    |
| 3.65  | 4    |
| 3.50  | 6    |
+-------+------+

================================================================================
 Solution:

解法一：

SELECT
  Score,
  (SELECT count(distinct Score) FROM Scores WHERE Score >= s.Score) Rank
FROM Scores s
ORDER BY Score desc
------------------------------------------------------------------------------------
 解法二：

SELECT Score,
(SELECT COUNT(*) FROM (SELECT DISTINCT Score s FROM Scores) t WHERE s >= Score) Rank
FROM Scores ORDER BY Score DESC;

------------------------------------------------------------------------------------
下面这种解法使用了内交，Join是Inner Join的简写形式，自己和自己内交，条件是右表的分数大于等于左表，然后群组起来根据分数的降序排列，
十分巧妙的解法：
解法三：

SELECT s.Score, COUNT(DISTINCT t.Score) Rank
FROM Scores s JOIN Scores t ON s.Score <= t.Score
GROUP BY s.Id ORDER BY s.Score DESC;
 
select s.Id, s.Score, c.Id, count( distinct c.Score) Rank FROM Scores s JOIN Scores c on  s.score <= c.score
group by s.Id
order by s.score desc;

------------------------------------------------------------------------------------
 下面这种解法跟上面三种的画风就不太一样了，这里用了两个变量，变量使用时其前面需要加@，这里的：= 是赋值的意思，如果前面有Set关键字，则可以直接用=号来赋值，如果没有，则必须要使用:=来赋值，两个变量rank和pre，其中rank表示当前的排名，pre表示之前的分数，下面代码中的<>表示不等于，如果左右两边不相等，则返回true或1，若相等，则返回false或0。初始化rank为0，pre为-1，然后按降序排列分数，对于分数4来说，pre赋为4，和之前的pre值-1不同，所以rank要加1，那么分数4的rank就为1，下面一个分数还是4，那么pre赋值为4和之前的4相同，所以rank要加0，所以这个分数4的rank也是1，以此类推就可以计算出所有分数的rank了。
解法四：

SELECT Score,
@rank := @rank + (@pre <> (@pre := Score)) Rank
FROM Scores, (SELECT @rank := 0, @pre := -1) INIT 
ORDER BY Score DESC;


----------------------------------------------------------------------------------
 Solution to Follow up:
  
select s.Id, s.Score,  count(c.score)+1 Rank FROM Scores s LEFT JOIN Scores c on  s.score < c.score
group by s.Id 
order by s.score desc ;


 
 
 
 *
 */
public class LC_178_Rank_Scores {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
