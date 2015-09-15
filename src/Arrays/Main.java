package Arrays;

import Strings.ExpressionEvaluation;

public class Main {

    public static void main(String[] args)
    {
        // write your code here
        //testing the expression evaluation
        ExpressionEvaluation evaluator = new ExpressionEvaluation();
        try {
            int res = evaluator.evalExp("2+2*2+1");
            System.out.println(res);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //testing the interval covered length;
        Intervals intervals = new Intervals();
        intervals.addInterval(1, 5);
        intervals.addInterval(3, 6);
        intervals.addInterval(8, 9);
        intervals.addInterval(8, 10);
        System.out.println(intervals.list.size());
        System.out.println(intervals.getTotalCoveredLength());
    }
}
