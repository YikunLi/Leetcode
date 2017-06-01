package com.leetcode;

/**
 * @author liyikun 2017/06/01
 * @see
 *      <a
 *      href="https://leetcode.com/problems/find-the-difference/#/description">
 *      389. Find the Difference</a>
 * @description:
 *               Given two strings s and t which consist of only lowercase
 *               letters.String t is generated by random shuffling string s and
 *               then add one more letter at a random position. Find the letter
 *               that was added in t.
 *               Example:
 *               Input:
 *               s = "abcd"
 *               t = "abcde"
 *               Output:
 *               e
 *               Explanation:
 *               'e' is the letter that was added.
 */
public class L389FindTheDifference {

    public static void main(String[] args) {
        String s = "ymbgaraibkfmvocpizdydugvalagaivdbfsfbepeyccqfepzvtpyxtbadkhmwmoswrcxnargtlswqemafandgkmydtimuzvjwxvlfwlhvkrgcsithaqlcvrihrwqkpjdhgfgreqoxzfvhjzojhghfwbvpfzectwwhexthbsndovxejsntmjihchaotbgcysfdaojkjldprwyrnischrgmtvjcorypvopfmegizfkvudubnejzfqffvgdoxohuinkyygbdzmshvyqyhsozwvlhevfepdvafgkqpkmcsikfyxczcovrmwqxxbnhfzcjjcpgzjjfateajnnvlbwhyppdleahgaypxidkpwmfqwqyofwdqgxhjaxvyrzupfwesmxbjszolgwqvfiozofncbohduqgiswuiyddmwlwubetyaummenkdfptjczxemryuotrrymrfdxtrebpbjtpnuhsbnovhectpjhfhahbqrfbyxggobsweefcwxpqsspyssrmdhuelkkvyjxswjwofngpwfxvknkjviiavorwyfzlnktmfwxkvwkrwdcxjfzikdyswsuxegmhtnxjraqrdchaauazfhtklxsksbhwgjphgbasfnlwqwukprgvihntsyymdrfovaszjywuqygpvjtvlsvvqbvzsmgweiayhlubnbsitvfxawhfmfiatxvqrcwjshvovxknnxnyyfexqycrlyksderlqarqhkxyaqwlwoqcribumrqjtelhwdvaiysgjlvksrfvjlcaiwrirtkkxbwgicyhvakxgdjwnwmubkiazdjkfmotglclqndqjxethoutvjchjbkoasnnfbgrnycucfpeovruguzumgmgddqwjgdvaujhyqsqtoexmnfuluaqbxoofvotvfoiexbnprrxptchmlctzgqtkivsilwgwgvpidpvasurraqfkcmxhdapjrlrnkbklwkrvoaziznlpor";
        String t = "qhxepbshlrhoecdaodgpousbzfcqjxulatciapuftffahhlmxbufgjuxstfjvljybfxnenlacmjqoymvamphpxnolwijwcecgwbcjhgdybfffwoygikvoecdggplfohemfypxfsvdrseyhmvkoovxhdvoavsqqbrsqrkqhbtmgwaurgisloqjixfwfvwtszcxwktkwesaxsmhsvlitegrlzkvfqoiiwxbzskzoewbkxtphapavbyvhzvgrrfriddnsrftfowhdanvhjvurhljmpxvpddxmzfgwwpkjrfgqptrmumoemhfpojnxzwlrxkcafvbhlwrapubhveattfifsmiounhqusvhywnxhwrgamgnesxmzliyzisqrwvkiyderyotxhwspqrrkeczjysfujvovsfcfouykcqyjoobfdgnlswfzjmyucaxuaslzwfnetekymrwbvponiaojdqnbmboldvvitamntwnyaeppjaohwkrisrlrgwcjqqgxeqerjrbapfzurcwxhcwzugcgnirkkrxdthtbmdqgvqxilllrsbwjhwqszrjtzyetwubdrlyakzxcveufvhqugyawvkivwonvmrgnchkzdysngqdibhkyboyftxcvvjoggecjsajbuqkjjxfvynrjsnvtfvgpgveycxidhhfauvjovmnbqgoxsafknluyimkczykwdgvqwlvvgdmufxdypwnajkncoynqticfetcdafvtqszuwfmrdggifokwmkgzuxnhncmnsstffqpqbplypapctctfhqpihavligbrutxmmygiyaklqtakdidvnvrjfteazeqmbgklrgrorudayokxptswwkcircwuhcavhdparjfkjypkyxhbgwxbkvpvrtzjaetahmxevmkhdfyidhrdeejapfbafwmdqjqszwnwzgclitdhlnkaiyldwkwwzvhyorgbysyjbxsspnjdewjxbhpsvj";
        Solution solution = new Hash();
        System.out.println(solution.findTheDifference(s, t));
    }

    public static interface Solution {

        public char findTheDifference(String s, String t);
    }

    /**
     * Wrong answer
     */
    public static class Traverse implements Solution {

        @Override
        public char findTheDifference(String s, String t) {
            if (s == null || t == null || t.length() == 0) {
                return 0;
            }
            for (int i = 0; i < t.length(); i++) {
                if (s.length() == i) {
                    return t.charAt(i);
                }
                if (s.charAt(i) != t.charAt(i)) {
                    return t.charAt(i);
                }
            }
            return 0;
        }
    }

    public static class Hash implements Solution {

        @Override
        public char findTheDifference(String s, String t) {
            if (s == null || t == null || t.length() == 0) {
                return 0;
            }
            if (s.length() == 0 && t.length() > 0) {
                return t.charAt(0);
            }
            int[] letters = new int['z' - 'a' + 1];
            for (int i = 0; i < s.length(); i++) {
                letters[s.charAt(i) - 'a']++;
            }
            for (int i = 0; i < t.length(); i++) {
                char letter = t.charAt(i);
                if (letters[letter - 'a']-- == 0) {
                    return letter;
                }
            }
            return 0;
        }

    }
}