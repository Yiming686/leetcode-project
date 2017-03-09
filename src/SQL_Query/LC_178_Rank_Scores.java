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

//join��ÿһ�����ұ��ҵ����ڵ�������distinct�ĸ���������������Rank
// �м���Distinct�������ڵ��ڵ�ǰ���� (Distinct��������)
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

//join��ÿһ�����ұ��ҵ����ڵ������ĵĸ���������������Rank
// �м�����ȡ�õķ����ڵ�ǰ�˵ķ���ǰ��+1(��Ա����)
Follow Up��
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

�ⷨһ��

SELECT
  Score,
  (SELECT count(distinct Score) FROM Scores WHERE Score >= s.Score) Rank
FROM Scores s
ORDER BY Score desc
------------------------------------------------------------------------------------
 �ⷨ����

SELECT Score,
(SELECT COUNT(*) FROM (SELECT DISTINCT Score s FROM Scores) t WHERE s >= Score) Rank
FROM Scores ORDER BY Score DESC;

------------------------------------------------------------------------------------
�������ֽⷨʹ�����ڽ���Join��Inner Join�ļ�д��ʽ���Լ����Լ��ڽ����������ұ�ķ������ڵ������Ȼ��Ⱥ���������ݷ����Ľ������У�
ʮ������Ľⷨ��
�ⷨ����

SELECT s.Score, COUNT(DISTINCT t.Score) Rank
FROM Scores s JOIN Scores t ON s.Score <= t.Score
GROUP BY s.Id ORDER BY s.Score DESC;
 
select s.Id, s.Score, c.Id, count( distinct c.Score) Rank FROM Scores s JOIN Scores c on  s.score <= c.score
group by s.Id
order by s.score desc;

------------------------------------------------------------------------------------
 �������ֽⷨ���������ֵĻ���Ͳ�̫һ���ˣ�����������������������ʹ��ʱ��ǰ����Ҫ��@������ģ�= �Ǹ�ֵ����˼�����ǰ����Set�ؼ��֣������ֱ����=������ֵ�����û�У������Ҫʹ��:=����ֵ����������rank��pre������rank��ʾ��ǰ��������pre��ʾ֮ǰ�ķ�������������е�<>��ʾ�����ڣ�����������߲���ȣ��򷵻�true��1������ȣ��򷵻�false��0����ʼ��rankΪ0��preΪ-1��Ȼ�󰴽������з��������ڷ���4��˵��pre��Ϊ4����֮ǰ��preֵ-1��ͬ������rankҪ��1����ô����4��rank��Ϊ1������һ����������4����ôpre��ֵΪ4��֮ǰ��4��ͬ������rankҪ��0�������������4��rankҲ��1���Դ����ƾͿ��Լ�������з�����rank�ˡ�
�ⷨ�ģ�

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
