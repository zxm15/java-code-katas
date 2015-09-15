package Strings;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Write a function to evaluate expression.
 * <p/>
 * The expression contains only non-negative integers, +, -, *, and / operatorMap. The division should truncation toward zero.
 * <p/>
 * For example, given 3 + 2 * 2, return 7.
 */
public class ExpressionEvaluation {
    interface Operator {
        public int eval(int x, int y);
    }

    private static final Map<Character, Operator> operatorMap = new HashMap<Character, Operator>() {{

        put('+', new Operator() {
            @Override
            public int eval(int x, int y)
            {
                return x + y;
            }
        });
        put('-', new Operator() {
            @Override
            public int eval(int x, int y)
            {
                return x - y;
            }
        });
        put('*', new Operator() {
            @Override
            public int eval(int x, int y)
            {
                return x * y;
            }
        });
        put('/', new Operator() {
            @Override
            public int eval(int x, int y)
            {
                if (y == 0) return 0;
                return x / y;
            }
        });
    }};

    public int evalExp(String exp) throws Exception
    {
        if (exp.length() == 0) return 0;
        Stack<Integer> operand = new Stack<Integer>();
        Stack<Character> operator = new Stack<Character>();
        int i = 0;
        while (i < exp.length()) {
            if (operatorMap.containsKey(exp.charAt(i))) {
                operator.push(exp.charAt(i++));
                continue;
            } else if (Character.isDigit(exp.charAt(i))) {
                int j = i;
                while (j < exp.length() && Character.isDigit(exp.charAt(j))) j++;
                int y = Integer.parseInt(exp.substring(i, j));
                //calculate * and / int the first iteration
                i = j;
                if (!operator.isEmpty() && (operator.peek() == '*' || operator.peek() == '/')) {
                    int x = operand.pop();
                    int res = operatorMap.get(operator.pop()).eval(x, y);
                    operand.push(res);
                } else operand.push(y);
            } else throw new Exception("The expression contains invalid character");

        }

        //operator stack could contains all +/-, calculate them one by one
        while (!operator.isEmpty()) {
            int x = operand.pop();
            int y = operand.pop();
            char op = operator.pop();
            int temp = operatorMap.get(op).eval(x, y);
            operand.push(temp);
        }
        return operand.pop();
    }
}
