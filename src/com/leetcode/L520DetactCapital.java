package com.leetcode;

/**
 * @author liyikun 2017/06/01
 * @see
 *      <a href=
 *      "https://leetcode.com/problems/detect-capital/#/description"
 *      >520. Detect Capital</a>
 * @description
 *              Given a word, you need to judge whether the usage of capitals in
 *              it is right or not. We define the usage of capitals in a word to
 *              be right when one of the following cases holds:
 *              All letters in this word are capitals, like "USA".
 *              All letters in this word are not capitals, like "leetcode".
 *              Only the first letter in this word is capital if it has more
 *              than one letter, like "Google".
 *              Otherwise, we define that this word doesn't use capitals in a
 *              right way.
 *              Example 1:
 *              Input: "USA"
 *              Output: True
 *              Example 2:
 *              Input: "FlaG"
 *              Output: False
 *              Note: The input will be a non-empty word consisting of uppercase
 *              and lowercase latin letters.
 */
public class L520DetactCapital {

    public static void main(String[] args) {
        Solution solution = new Traverse();
        System.out.println(solution.detectCapitalUse("USA"));
        System.out.println(solution.detectCapitalUse("FlaG"));
        System.out.println(solution.detectCapitalUse("F"));
    }

    public static interface Solution {

        public boolean detectCapitalUse(String word);
    }

    public static class Traverse implements Solution {

        private static final int RIGHT_ALL_CAPITALS = 0;
        private static final int RIGHT_ALL_NOT_CAPITALS = 0;
        private static final int RIGHT_FIRST_CAPITAL = 0;

        @Override
        public boolean detectCapitalUse(String word) {
            if (word.length() == 1) {
                return true;
            }
            int mode;
            if (word.charAt(0) >= 'A' && word.charAt(0) <= 'Z'
                    && word.charAt(1) >= 'A' && word.charAt(1) <= 'Z') {
                mode = RIGHT_ALL_CAPITALS;
            } else if (word.charAt(0) >= 'A' && word.charAt(0) <= 'Z'
                    && word.charAt(1) >= 'a' && word.charAt(1) <= 'z') {
                mode = RIGHT_FIRST_CAPITAL;
            } else if (word.charAt(0) >= 'a' && word.charAt(0) <= 'z'
                    && word.charAt(1) >= 'a' && word.charAt(1) <= 'z') {
                mode = RIGHT_ALL_NOT_CAPITALS;
            } else {
                return false;
            }
            for (int i = 2; i < word.length(); i++) {
                if (mode == RIGHT_ALL_CAPITALS) {
                    if (word.charAt(i) >= 'a' && word.charAt(i) <= 'z') {
                        return false;
                    }
                } else {
                    if (word.charAt(i) >= 'A' && word.charAt(i) <= 'Z') {
                        return false;
                    }
                }
            }
            return true;
        }

    }
}
