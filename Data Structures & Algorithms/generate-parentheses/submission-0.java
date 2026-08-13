class Solution {
    public void find(int n,int open,int close,List<String>ans,StringBuilder temp){
        if(temp.length()==2*n){
            ans.add(temp.toString());
            return;
        }
        if(open<n){
            temp.append('(');
            find(n,open+1,close,ans,temp);
            temp.deleteCharAt(temp.length()-1);
        }
        if(close<open){
            temp.append(')');
            find(n,open,close+1,ans,temp);
            temp.deleteCharAt(temp.length()-1);
        }
    }
    public List<String> generateParenthesis(int n) {
        List<String>ans=new ArrayList<>();
        find(n,0,0,ans,new StringBuilder());
        return ans;
    }
}
