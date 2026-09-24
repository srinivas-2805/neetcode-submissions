class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int count1=0;
        int count2=0;
        int ele1=0;
        int ele2=0;
        for(int i=0;i<nums.length;i++){
            if(count1==0 && nums[i]!=ele2){
                count1++;
                ele1=nums[i];
            }
            if(count2==0 && nums[i]!=ele1){
                count2++;
                ele2=nums[i];
            }
            else if(nums[i]==ele1){
                count1++;
            }
            else if(nums[i]==ele2){
                count2++;
            }
            else{
                count1--;
                count2--;
            }

        }
        count1=0;
        count2=0;
        List<Integer> ans=new ArrayList<>();
        for(int num:nums){
           if(num==ele1){
            count1++;
           }
           if(num==ele2){
            count2++;
           }
        }
        int mini=(int)(nums.length/3)+1;
        if(count1>=mini) ans.add(ele1);
        if(count2>=mini) ans.add(ele2);
        return ans;
    }
}