class Solution {
    public String decodeString(String s) {

        Stack<Integer> numStack = new Stack<>();
        Stack<String> strStack = new Stack<>();

        String currStr = "";
        int currNum = 0;

        for (char ch : s.toCharArray()) {

            // If digit
            if (Character.isDigit(ch)) {
                currNum = currNum * 10 + (ch - '0');
            }

            // Opening bracket
            else if (ch == '[') {
                numStack.push(currNum);
                strStack.push(currStr);

                currNum = 0;
                currStr = "";
            }

            // Closing bracket
            else if (ch == ']') {

                int repeat = numStack.pop();
                String prevStr = strStack.pop();

                StringBuilder temp = new StringBuilder(prevStr);

                for (int i = 0; i < repeat; i++) {
                    temp.append(currStr);
                }

                currStr = temp.toString();
            }

            // Normal character
            else {
                currStr += ch;
            }
        }

        return currStr;
    }
}