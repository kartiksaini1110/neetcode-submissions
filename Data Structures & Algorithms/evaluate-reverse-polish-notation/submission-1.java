class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(String token : tokens){
            switch(token){
                case "+":
                    stack.push(stack.pop() + stack.pop());
                    break;
                case "-":
                {
                    int top = stack.pop();
                    int newTop = stack.pop();
                    stack.push(newTop - top);
                    break;
                }
                case "*":
                    stack.push(stack.pop() * stack.pop());
                    break;
                case "/":
                {
                    int top = stack.pop();
                    int newTop = stack.pop();
                    stack.push(newTop / top);
                    break;
                }
                default:
                    stack.push(Integer.parseInt(token));
            }
        }
        return stack.peek();
    }
}
