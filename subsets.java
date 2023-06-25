import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class subsets {
    public List<List<Integer>> subsetsNonDups(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        backtrack(nums, 0, subset, res);
        return res;
    }

    private void backtrack(int[] nums, int index, List<Integer> subset, List<List<Integer>> res) {
        if (index >= nums.length) {
            res.add(new ArrayList<>(subset));
            return;
        }

        // Decision to include nums[index]
        subset.add(nums[index]);
        backtrack(nums, index + 1, subset, res);
        subset.remove(subset.size() - 1);

        // Decision NOT to include nums[index]
        backtrack(nums, index + 1, subset, res);
    }

    public List<List<Integer>> subsetsWithDups(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        subSet(nums, 0, ans, list);
        return ans;
    }

    public void subSet(int[] nums, int idx, List<List<Integer>> ans, List<Integer> list) {
        ans.add(new ArrayList<>(list));

        for (int i = idx; i < nums.length; i++) {
            //skip the duplicate elements
            if (i > idx && nums[i] == nums[i - 1]) continue;
            list.add(nums[i]);
            subSet(nums, i + 1, ans, list);
            list.remove(list.size() - 1);
        }
    }

}
