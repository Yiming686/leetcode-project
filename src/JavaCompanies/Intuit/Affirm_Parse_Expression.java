package JavaCompanies.Intuit;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 *
 Recruiter������ϵ��. ����͹���. ��Ŀ����
�����µı��ʽ. add��ʾ+, mult��ʾ*
(add 1 2)
(mult 3 (add 2 3))
(let x 2 (mult x 5)
(let x 2 (mult x (let x 3 y 4 (add x y)))
������ʽ���, ǰ��������3 �� 15
������ʽ�ӱ�ʾ��x=2, ����x * 5
���ĸ�ʽ����������ֵ, x��y, ���ڲ�ͬǶ�����в�ͬ�ĸ�ֵ
������ʮ����,Ҫ�����ͨ��. ����parse���ʽ��û��д��... ����let�������δ�
 
 
 */
public class Affirm_Parse_Expression {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	

}


//recursion�Ƚ�robust���Ƕ�ʱ���ڲ���д. ��Ϊ��û�п����õ��﷨��������Ҫ����
//����tokenize. ֻ����Stack����ϣ���ڹ涨ʱ����д�꣬��Ȼ�����ĳ�����ȫû���á�

class EvalExpression {
    private Stack<Integer> results = new Stack<Integer>();
    private Stack<String> operators = new Stack<String>();
    private Stack<Map<String, Integer>> vars = new Stack<Map<String, Integer
>>();

    private static final String ADD = "add";
    private static final String MULT = "mult";
    private static final String LET = "let";
    private static final String LPAREN = "(";
    private static final String RPAREN = ")";

    public int calcExpression(String expr) {
//    	String [] exprs = tokenizeExpr(expr);
        String [] exprs = null;
        for (int i = 0; i < exprs.length; i++) {
            String token = exprs[i];
            if (ADD.equals(token) || MULT.equals(token)) {
                operators.push(token);
            } else if (LET.equals(token)) {
                operators.push(token);
                Map<String, Integer> map = new HashMap<String, Integer>();
                i++;
                while (!LPAREN.equals(exprs[i])) {
                    map.put(exprs[i], Integer.valueOf(exprs[i + 1]));
                    i += 2;
                }
                vars.push(map);
            } else if (LPAREN.equals(token)) {
                continue;
            }
            else if (RPAREN.equals(token)) {
                if (LET.equals(operators.peek())) {
                    operators.pop();
                } else {
                    calcValue();
                }
            } else {
                results.push(getValue(token));
            }
        }
        return results.peek();
    }

    private void calcValue() {
        int temp1 = results.pop();
        int temp2 = results.pop();
        String operation = operators.pop();
        if (ADD.equals(operation)) {
            results.push(temp1 + temp2);
        }
        if (MULT.equals(operation)) {
            results.push(temp1 * temp2);
        }
    }

    private int getValue(String token) {
        if (token.matches("\\d+")) {
            return Integer.parseInt(token);
        }
        return searchTable(token);
    }

    private int searchTable(String token) {
        return vars.peek().get(token);
    }

}

/*
 *  
 *  
 import re
class Solution:
    def evaluate(self, expr):
        tokens = re.split('[ ()]', expr)
        tokens = [token for token in tokens if token]
        var, stack, i = {}, [], 0
        keywords = set(['add', 'mult', 'let'])
        while i < len(tokens):
            if tokens[i] == 'add' or tokens[i] == 'mult':
                stack.append(tokens[i])
                i += 1
            elif tokens[i] == 'let':
                i += 1
                while i < len(tokens) and tokens[i] not in keywords:
                    var[tokens[i]] = int(tokens[i+1])
                    i += 2
            else:
                if tokens[i].isdigit():
                    stack.append(int(tokens[i]))
                else:
                    stack.append(var[tokens[i]])
                while len(stack) > 2 and isinstance(stack[-1], int) and 
isinstance(stack[-2], int):
                    num2, num1, op = stack.pop(), stack.pop(), stack.pop()
                    stack.append(self.compute(op, num1, num2))
        i += 1
        return stack[0]
        
    def compute(self, op, num1, num2):
        if op == 'add': return num1 + num2
        if op == 'mult': return num1 * num2

sol = Solution()
exprs = {
    '(add 1 2)': 3,
    '(mult 3 (add 2 3))': 15,
    '(let x 2 (mult x 5)': 10,
    '(let x 2 (mult x (let x 3 y 4 (add x y)))': 14,
    '(let a 2 (add a 2))': 4,
    '(let a 2 (add a let b 3 (mult b 3)))': 11
}
for expr, val in exprs.items():
    print(expr, val, sol.evaluate(expr))
 
  
 * 
 * */
