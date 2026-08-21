class Solution {
    public boolean canJump(int[] nums) {
        int lastposition=nums.length-1;
        for(int i=nums.length-2;i>=0;i--){
            if(i+nums[i]>=lastposition){
                lastposition=i;
            }
        }
        return lastposition==0;
    }
}
