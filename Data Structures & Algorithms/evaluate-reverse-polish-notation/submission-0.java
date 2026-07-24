class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> s = new Stack<>();

        for (String token : tokens) {
            if (isOperator(token)) {
                int num2 = Integer.parseInt(s.pop());
                int num1 = Integer.parseInt(s.pop());

                int result = 0;

                if (token.equals("+")) {
                    result = num1 + num2;
                } else if (token.equals("-")) {
                    result = num1 - num2;
                } else if (token.equals("*")) {
                    result = num1 * num2;
                } else {
                    result = num1 / num2;
                }

                s.push(String.valueOf(result));
            } else {
                s.push(token);
            }
        }

        return Integer.parseInt(s.pop());
    }

    public boolean isOperator(String token) {
        return token.equals("+") ||
               token.equals("-") ||
               token.equals("*") ||
               token.equals("/");
    }
}