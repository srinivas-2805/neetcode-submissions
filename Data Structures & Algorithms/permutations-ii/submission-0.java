class Solution {

    public void find(int[] nums,
                     List<List<Integer>> ans,
                     List<Integer> temp,
                     boolean[] used) {

        // A complete permutation
        if (temp.size() == nums.length) {
            ans.add(new ArrayList<>(temp));
            return;
        }

        for (int i = 0; i < nums.length; i++) {

            // Already used
            if (used[i]) {
                continue;
            }

            
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }

           
            used[i] = true;
            temp.add(nums[i]);

            
            find(nums, ans, temp, used);
            temp.remove(temp.size() - 1);
            used[i] = false;
        }
    }

    public List<List<Integer>> permuteUnique(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();

        Arrays.sort(nums);

        boolean[] used = new boolean[nums.length];

        find(nums, ans, new ArrayList<>(), used);

        return ans;
    }
}