class Solution {
    public int count(int []weights,int capacity){
        int day=1;
        int load=0;
        for(int i=0;i<weights.length;i++){
            if(load+weights[i]>capacity){
                day=day+1;
                load=weights[i];
            }
            else{
                load+=weights[i];
            }
        }
        return day;
    }
    public int shipWithinDays(int[] weights, int days) {
        int low=0;
        int high=0;
        for(int weight:weights){
            low=Math.max(low,weight);
            high+=weight;
        }
        int ans=0;
        while(low<=high){
            int mid=low+(high-low)/2;
            int no_of_days=count(weights,mid);
            if(no_of_days<=days){
                ans=mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return ans;
    }
}