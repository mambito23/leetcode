import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationsNonDups {
    public static void main(String[] args) {
//        permutations("", "abc");

        //ArrayList<String> ans = permutationsList(new StringBuilder(), "abc");
        //System.out.println(ans);

        List<List<Integer>> ans = permuteArrayNonDups(new int[] {1,2,3});
        for (List<Integer> list : ans){
            System.out.print("list: [");
            for (Integer n : list){
                System.out.print(n);
            }
            System.out.print("]");
            System.out.println();
        }
        //System.out.println(permutationsCount("", "abcd"));

        /*
        List<String> ans = permutationsListNonDups(new StringBuilder(), "123");
        for (String str : ans) System.out.println(str);

         */
    }

    //Finds ways of arranging each character.
    //Every single character must be used.
    //Non Dups
    static ArrayList<String> permutateStringNonDups(StringBuilder p, String up) {
        if (up.isEmpty()) {
            ArrayList<String> list = new ArrayList<>();
            list.add(p.toString());
            return list;
        }
        char ch = up.charAt(0);

        // local to this call
        ArrayList<String> ans = new ArrayList<>();

        for (int i = 0; i <= p.length(); i++) {
            StringBuilder f = new StringBuilder(p.substring(0, i));
            StringBuilder s = new StringBuilder(p.substring(i, p.length()));
            ans.addAll(permutateStringNonDups(f.append(ch).append(s), up.substring(1)));
        }
        return ans;
    }

    //Finds # of ways of arranging each character.
    //Every single character must be used.
    //Non Dups
    static int permutationsCountNonDups(String p, String up) {
        if (up.isEmpty()) {
            return 1;
        }
        int count = 0;
        char ch = up.charAt(0);
        for (int i = 0; i <= p.length(); i++) {
            String f = p.substring(0, i);
            String s = p.substring(i, p.length());
            count = count + permutationsCountNonDups(f + ch + s, up.substring(1));
        }
        return count;
    }

    //Finds ways of arranging the array.
    //Every single character must be used.
    //Non Dups
    public static List<List<Integer>> permuteArrayNonDups(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        helperGeneratePermutations(new ArrayList<>(), ans, nums);
        return ans;
    }

    private static void helperGeneratePermutations(List<Integer> curr, List<List<Integer>> ans, int[] nums) {
        if (curr.size() == nums.length) {
            ans.add(new ArrayList<>(curr));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!curr.contains(nums[i])) {
                curr.add(nums[i]);
                helperGeneratePermutations(curr, ans, nums);
                curr.remove(curr.size() - 1);
            }
        }
    }



}
