class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> helper = new Stack<>();
        int n = temperatures.length;
        int[] result = new int[n];

        for (int idx = n - 1; idx >= 0; idx--) {

            while (!helper.isEmpty() &&
                   temperatures[idx] >= temperatures[helper.peek()]) {
                helper.pop();
            }

            if (helper.isEmpty()) {
                result[idx] = 0;
            } else {
                result[idx] = helper.peek() - idx;
            }

            helper.push(idx);
        }

        return result;
    }
}