class Solution {
    public void find(int index,int[]candidates,List<List<Integer>> ans,int target,List<Integer>ds){
        if(target==0){
            ans.add(new ArrayList<>(ds));
            return;
        }
        for(int i=index;i<candidates.length;i++){
            if(i>index && candidates[i]==candidates[i-1]){
                continue;
            }
            if(candidates[i]>target){
                break;
            }
            ds.add(candidates[i]);
            find(i+1,candidates,ans,target-candidates[i],ds);
            ds.remove(ds.size() - 1);
        }
        
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans=new ArrayList<>();
         Arrays.sort(candidates);
        find(0,candidates,ans,target,new ArrayList<>());
        return ans;
    }
}
