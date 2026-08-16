class Solution {
    public void find(int index,List<List<Integer>> ans,int n,int k,List<Integer> temp){
        if (temp.size() == k) {
            ans.add(new ArrayList<>(temp));
            return;
        }

        for (int i = index; i <= n; i++) {
            temp.add(i);

            find(i + 1, ans, n, k, temp);

            temp.remove(temp.size() - 1);
        }
    }
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans=new ArrayList<>();
        find(1,ans,n,k,new ArrayList<>());
        return ans;
    }
}