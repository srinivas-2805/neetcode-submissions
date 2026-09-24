class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> s = new Stack<>();
        for (String operation : operations) {
            if (operation.equals("+")) {
                int num2 = s.pop();
                int num1 = s.peek();
                s.push(num2);
                s.push(num1 + num2);
            }
            else if (operation.equals("D")) {
                int num = s.peek();
                s.push(num * 2);
            }
            else if (operation.equals("C")) {
                s.pop();
            }
            else {
                s.push(Integer.parseInt(operation));
            }
        }
        int sum = 0;
        while (!s.isEmpty()) {
            sum += s.pop();
        }
        return sum;
    }
}