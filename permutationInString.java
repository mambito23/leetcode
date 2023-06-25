//https://leetcode.com/problems/permutation-in-string/description/
public class permutationInString {

    public static void main(String[] args) {
        System.out.println(checkInclusion("ab", "eidbaooo"));
    }

    static boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }

        int[] s1Count = new int[26];
        int[] s2Count = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            s1Count[s1.charAt(i) - 'a'] += 1;
            s2Count[s2.charAt(i) - 'a'] += 1;
        }

        int matches = 0;
        for (int i = 0; i < 26; i++) {
            matches += (s1Count[i] == s2Count[i]) ? 1 : 0;
        }

        int start = 0;
        for (int end = s1.length(); end < s2.length(); end++) {
            if (matches == 26) {
                return true;
            }
            int index = s2.charAt(end) - 'a';
            s2Count[s2.charAt(end) - 'a'] ++;
            if (s1Count[index] == s2Count[index]) {
                matches ++;
            } else if (s1Count[index] + 1 == s2Count[index]) {
                matches --;
            }
            index = s2.charAt(start) - 'a';
            s2Count[index] --;
            if (s1Count[index] == s2Count[index]) {
                matches ++;
            } else if (s1Count[index] - 1 == s2Count[index]) {
                matches --;
            }
            start ++;
        }
        return matches == 26;
    }
}
