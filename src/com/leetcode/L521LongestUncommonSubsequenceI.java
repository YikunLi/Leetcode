package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liyikun 2017/06/01
 * @see
 *      <a href=
 *      "https://leetcode.com/problems/longest-uncommon-subsequence-i/#/description"
 *      >521. Longest Uncommon Subsequence I</a>
 * @description
 *              Given a group of two strings, you need to find the longest
 *              uncommon subsequence of this group of two strings. The longest
 *              uncommon subsequence is defined as the longest subsequence of
 *              one of these strings and this subsequence should not be any
 *              subsequence of the other strings. A subsequence is a sequence
 *              that can be derived from one sequence by deleting some
 *              characters without changing the order of the remaining elements.
 *              Trivially, any string is a subsequence of itself and an empty
 *              string is a subsequence of any string. The input will be two
 *              strings, and the output needs to be the length of the longest
 *              uncommon subsequence. If the longest uncommon subsequence
 *              doesn't exist, return -1.
 *              Example 1:
 *              Input: "aba", "cdc"
 *              Output: 3
 *              Explanation: The longest uncommon subsequence is "aba" (or
 *              "cdc"), because "aba" is a subsequence of "aba", but not a
 *              subsequence of any other strings in the group of two strings.
 *              Note:
 *              Both strings' lengths will not exceed 100.
 *              Only letters from a ~ z will appear in input strings.
 */
public class L521LongestUncommonSubsequenceI {

    public static void main(String[] args) {
        Solution solution = new SolutionImpl();
        System.out.println(solution.findLUSlength("aba", "cdc"));
        System.out.println(solution.findLUSlength("aaa", "aaa"));
    }

    public static interface Solution {

        public int findLUSlength(String a, String b);
    }

    public static class SolutionImpl implements Solution {

        @Override
        public int findLUSlength(String a, String b) {
            if ((a == null || a.length() == 0)
                    && (b == null || b.length() == 0)) {
                return -1;
            } else if ((a != null && a.length() != 0)
                    && (b == null || b.length() == 0)) {
                return a.length();
            } else if ((a == null || a.length() == 0)
                    && (b != null && b.length() != 0)) {
                return b.length();
            } else if (a.equals(b)) {
                return -1;
            }
            // 找到两个字符串的所有子串，并且一个字符串的子串不能是第一个字符串的子串
            List<String> list = new ArrayList<String>();
            for (int i = 0; i < a.length() - 1; i++) {
                for (int j = i + 1; j <= a.length(); j++) {
                    String subString = a.substring(i, j);
                    if (list.contains(subString)) {
                        continue;
                    } else if (!b.contains(subString)) {
                        list.add(subString);
                    }
                }
            }
            for (int i = 0; i < b.length() - 1; i++) {
                for (int j = i + 1; j <= b.length(); j++) {
                    String subString = b.substring(i, j);
                    if (list.contains(subString)) {
                        continue;
                    } else if (!a.contains(subString)) {
                        list.add(subString);
                    }
                }
            }
            int maxLength = -1;
            for (String next : list) {
                if (next.length() > maxLength) {
                    maxLength = next.length();
                }
            }
            return maxLength;
        }

    }

}
