class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        while(i < tokens.length){
            if(tokens[i].equals("+")){
                int top = stack.pop();
                int prevTop = stack.pop();
                stack.push(top + prevTop);
            }else if(tokens[i].equals("-")){
                int top = stack.pop();
                int prevTop = stack.pop();
                stack.push(prevTop - top);
            }else if(tokens[i].equals("*")){
                int top = stack.pop();
                int prevTop = stack.pop();
                stack.push(top * prevTop);
            }else if(tokens[i].equals("/")){
                int top = stack.pop();
                int prevTop = stack.pop();
                stack.push(prevTop / top);
            }else{
                stack.push(Integer.parseInt(tokens[i]));
            }
            i++;
        }
        return stack.peek();
    }
}
