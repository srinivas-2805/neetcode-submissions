class Solution {

    public boolean canSplit(int[] nums, int maxSum, int k) {

        int subarrays = 1;
        int currentSum = 0;

        for (int i = 0; i < nums.length; i++) {

            if (currentSum + nums[i] <= maxSum) {
                currentSum += nums[i];
            } 
            else {
                subarrays++;
                currentSum = nums[i];
            }
        }

        return subarrays <= k;
    }

    public int splitArray(int[] nums, int k) {

        if (k > nums.length) {
            return -1;
        }

        int low = 0;
        int high = 0;

        for (int num : nums) {
            low = Math.max(low, num);
            high += num;
        }

        int answer = high;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (canSplit(nums, mid, k)) {
                answer = mid;
                high = mid - 1;
            } 
            else {
                low = mid + 1;
            }
        }

        return answer;
    }
}