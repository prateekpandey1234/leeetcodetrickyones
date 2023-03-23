package RecursionAndBacktracking.Hard;

import java.util.ArrayList;
import java.util.List;

public class ExpressionAddOperator {
    class Solution {
        public List<String> addOperators(String num, int target) {
            List<String> res = new ArrayList<>();
            backtrack(res, num, target, "", 0, 0, 0);
            return res;
        }

        private void backtrack(List<String> res, String num, int target, String expr, int index, long eval, long prev) {
            if (index == num.length()) {
                if (eval == target) {
                    res.add(expr);
                }
                return;
            }
            for (int i = index; i < num.length(); i++) {
                if (i != index && num.charAt(index) == '0') {
                    break;
                }
                long curr = Long.parseLong(num.substring(index, i + 1));
                if (index == 0) {
                    backtrack(res, num, target, expr + curr, i + 1, curr, curr);//starting  with our very first digit
                } else {
                    //that eval-prev thing will give us the number before the multiplying in expression
                    //ex:- 1+2*3
                    // at i->3 , eval-prev = 1 , prev =2,curr=3;
                    backtrack(res, num, target, expr + "+" + curr, i + 1, eval + curr, curr);
                    backtrack(res, num, target, expr + "-" + curr, i + 1, eval - curr, -curr);
                    backtrack(res, num, target, expr + "*" + curr, i + 1, eval - prev + prev * curr, prev * curr);
                }
                // eval = eval - prev + prev * curr;the prev here is used to keep track of previous number we used so that if we face '*' we can avoid getting wrong eval
                // prev = prev * curr;//updating our prev ... here we can also see that prev is keeping track of our previous numbers multiply also for continious multipications
            }
        }
    }

}
