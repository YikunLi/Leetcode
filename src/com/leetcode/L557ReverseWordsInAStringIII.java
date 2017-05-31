package com.leetcode;

/**
 * @author liyikun 2017/05/31
 * @see
 *      <a href=
 *      "https://leetcode.com/problems/reverse-words-in-a-string-iii/#/description"
 *      >557. Reverse Words in a String III</a>
 * @description
 *              Given a string, you need to reverse the order of characters in
 *              each word within a sentence while still preserving whitespace
 *              and initial word order.
 *              Example 1:
 *              Input: "Let's take LeetCode contest"
 *              Output: "s'teL ekat edoCteeL tsetnoc"
 *              Note: In the string, each word is separated by single space and
 *              there will not be any extra space in the string.F
 */
public class L557ReverseWordsInAStringIII {

    public static void main(String[] args) {
        String input = "Let's take LeetCode contest";
        Solution solution = new SolutionImpl();
        System.out.println(solution.reverseWords(input));
        System.out.println(solution.reverseWords("ad      ads   "));
    }

    public static interface Solution {

        public String reverseWords(String s);
    }

    public static class SolutionImpl implements Solution {

        @Override
        public String reverseWords(String s) {
            if (s == null || s.length() == 0) {
                return s;
            }
            final char SPACE = ' ';
            final String NULL_STRING = "";
            String reverseString = "";
            String temp = "";
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == SPACE) {
                    if (!temp.equals(NULL_STRING)) {
                        reverseString += temp;
                        temp = "";
                    }
                    reverseString += SPACE;
                    continue;
                }
                temp = s.charAt(i) + temp;
            }
            if (!temp.equals(NULL_STRING)) {
                reverseString += temp;
            }
            return reverseString;
        }

    }
}
