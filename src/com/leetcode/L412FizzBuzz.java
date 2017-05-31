package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liyikun 2017/05/31
 * @see <a href="https://leetcode.com/problems/fizz-buzz/#/description">412.
 *      Fizz Buzz</a>
 * @description
 *              Write a program that outputs the string representation of
 *              numbers from 1 to n. But for multiples of three it should output
 *              “Fizz” instead of the number and for the multiples of five
 *              output “Buzz”. For numbers which are multiples of both three and
 *              five output “FizzBuzz”.
 *              Example:
 *              n = 15,
 *              Return:
 *              [
 *              "1",
 *              "2",
 *              "Fizz",
 *              "4",
 *              "Buzz",
 *              "Fizz",
 *              "7",
 *              "8",
 *              "Fizz",
 *              "Buzz",
 *              "11",
 *              "Fizz",
 *              "13",
 *              "14",
 *              "FizzBuzz"
 *              ]
 */
public class L412FizzBuzz {

    public static void main(String[] args) {
        Solution solution = new Traverse();
        System.out.println(solution.fizzBuzz(0));
    }

    public static interface Solution {

        public List<String> fizzBuzz(int n);
    }

    public static class Traverse implements Solution {

        @Override
        public List<String> fizzBuzz(int n) {
            List<String> list = new ArrayList<String>();
            if (n == 0) {
                return list;
            }
            final String MULTIPLES_OF_THREE = "Fizz";
            final String MULTIPLES_OF_FIVE = "Buzz";
            final String MULTIPLES_OF_THREE_AND_FIVE = MULTIPLES_OF_THREE
                    + MULTIPLES_OF_FIVE;
            for (int i = 1; i <= n; i++) {
                if (i % 3 == 0 && i % 5 == 0) {
                    list.add(MULTIPLES_OF_THREE_AND_FIVE);
                } else if (i % 3 == 0) {
                    list.add(MULTIPLES_OF_THREE);
                } else if (i % 5 == 0) {
                    list.add(MULTIPLES_OF_FIVE);
                } else {
                    list.add(String.valueOf(i));
                }
            }
            return list;
        }

    }
}
