class Solution {
    public void find(int index,int[]nums,List<List<Integer>> ans,int target,List<Integer> ds){
        if(index==nums.length){
            if(target==0){
                ans.add(new ArrayList<>(ds));
            }
            return;
        }
        if(nums[index]<=target){
           ds.add(nums[index]);
           find(index,nums,ans,target-nums[index],ds);
           ds.remove(ds.size()-1);
        }
        find(index+1,nums,ans,target,ds);
    }
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> ans=new ArrayList<>();
        find(0,nums,ans,target,new ArrayList<>());
        return ans;
    }
}
