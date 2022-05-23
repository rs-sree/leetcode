class Solution {
    public boolean isValid(String s) {
        Stack<Character> charStack = new Stack<Character>();
        if (s.length() == 0) {
            return true;
        }
        if (s.length() == 1) {
            return false;
        }
        for (char ch : s.toCharArray()) {
            if (ch == '}' || ch == ')' || ch == ']') {
                if (!charStack.empty()) {
                    Character top = charStack.peek();
                    if (ch == '}' && top != '{') return false;
                    if (ch == ')' && top != '(') return false;
                    if (ch == ']' && top != '[') return false;
                    charStack.pop();
                } else {
                    return false;
                }
            } else {
                charStack.push((Character) ch);
            }
        }
        return !(charStack.size() > 0);
    }
}