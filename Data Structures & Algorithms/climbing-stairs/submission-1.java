class Solution {
    public int climbStairs(int n) {
        if(n<=2){
            return n;
        }
        int prior2=1;
        int prior1=2;
        for(int i=3;i<=n;i++){
            int cur =prior1+prior2;
            prior2=prior1;
            prior1=cur;
        }
        return prior1;
    }
}
