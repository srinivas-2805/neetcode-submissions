class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int low=1;
        int high=0;
        for(int i=0;i<piles.length;i++){
            if(piles[i]>high){
               high=piles[i];
            }
        }
        while(low<=high){
            int mid=low+(high-low)/2;
            long reqtime=Calculate(piles,mid);
            if(reqtime<=h){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return low;
    }
    public long Calculate(int []piles,int hours){
        long time=0;
        for(int i=0;i<piles.length;i++){
            time+=Math.ceil((double)piles[i]/hours);
        }
        return time;
    }
}
