package com.leetcode;

/**
 * @author liyikun 2017/06/05
 * @see
 *      <a
 *      href="https://leetcode.com/problems/reverse-string-ii/#/description">
 *      541. Reverse String II</a>
 * @description
 *              Given a string and an integer k, you need to reverse the first k
 *              characters for every 2k characters counting from the start of
 *              the string. If there are less than k characters left, reverse
 *              all of them. If there are less than 2k but greater than or equal
 *              to k characters, then reverse the first k characters and left
 *              the other as original.
 *              Example:
 *              Input: s = "abcdefg", k = 2
 *              Output: "bacdfeg"
 *              Restrictions:
 *              The string consists of lower English letters only.
 *              Length of the given string and k will in the range [1, 10000]
 */
public class L541ReverseStringII {

    public static void main(String[] args) {
        Solution solution = new SolutionImpl();
        System.out.println(solution.reverseStr("abcdefg", 2));
    }

    public static interface Solution {

        public String reverseStr(String s, int k);
    }

    public static class SolutionImpl implements Solution {

        @Override
        public String reverseStr(String s, int k) {
            if (k == 1 || s == null || s.length() <= 1) {
                return s;
            }
            StringBuilder builder = new StringBuilder();
            StringBuilder temp = new StringBuilder();
            int endPosition = 2 * k;
            for (int i = 0; i < s.length(); i++) {
                if (i == endPosition) {
                    builder.append(temp);
                    temp = new StringBuilder();
                    endPosition += 2 * k;
                }
                if (i < endPosition - k) {
                    temp.insert(0, s.charAt(i));
                } else {
                    temp.append(s.charAt(i));
                }
            }
            builder.append(temp);
            return builder.toString();
        }

    }
}
