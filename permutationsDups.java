import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class permutationsDups {
    public static void main(String[] args) {
        List<List<Integer>> list = permuteDups(new int[] {1, 1, 2});
        System.out.println(list.toString());
    }

    public static List<List<Integer>> permuteDups(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        Arrays.sort(nums);
        recurse(nums, new boolean[nums.length], 0, res, temp);
        return res;
    }

    private static void recurse(int[] nums, boolean[] isUsed, int index, List<List<Integer>> res, List<Integer> temp){
        if(index == nums.length){
            res.add(new ArrayList<>(temp));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if(!isUsed[i]){
                if(i != 0 && nums[i] == nums[i-1] && !isUsed[i-1]) continue;
                temp.add(nums[i]);
                isUsed[i] = true;
                recurse(nums, isUsed, index+1, res, temp);
                isUsed[i] = false;
                temp.remove(temp.size()-1);
            }
        }
    }
}
