class Solution {
    public int[] getConcatenation(int[] nums) {
        int n = nums.length;
        int[] result = new int[2 * n];

        for (int i = 0; i < n; i++) {
            result[i] = nums[i];
        }

        for (int j = 0; j < n; j++) {
            result[n + j] = nums[j];
        }

        return result;
    }
}