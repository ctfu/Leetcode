public class Solution {
    private Stack<String> stack = new Stack<>();
    private boolean hasBeginTag = false;
    public boolean isValid(String code) {
        if (code.charAt(0) != '<' || code.charAt(code.length() - 1) != '>') {
            return false;
        }
        int closingIndex = 0;
        for (int i = 0; i < code.length(); i++) {
            boolean isClosingTag = false;
            if (stack.empty() && hasBeginTag) {
                return false;
            }
            if (code.charAt(i) == '<') {
                if (!stack.empty() && code.charAt(i + 1) == '!') {
                    closingIndex = code.indexOf("]]>", i + 1);
                    if (closingIndex < 0 || !validTagContent(code.substring(i + 1, closingIndex))) {
                        return false;
                    }
                } else {
                    if (code.charAt(i + 1) == '/') {
                        i++;
                        isClosingTag = true;
                    }
                    closingIndex = code.indexOf(">", i + 1);
                    if (closingIndex < 0 || !validTagName(code.substring(i + 1, closingIndex), isClosingTag)) {
                        return false;
                    }
                }
                i = closingIndex;
            }
        }
        return stack.empty() && hasBeginTag;
    }
    public boolean validTagName(String name, boolean closingTag) {
        if (name.length() < 1 || name.length() > 9) {
            return false;
        }
        for (int i = 0; i < name.length(); i++) {
            if (!Character.isUpperCase(name.charAt(i))) {
                return false;
            }
        }
        if (closingTag) {
            if (!stack.empty() && stack.peek().equals(name)) {
                stack.pop();
            } else {
                return false;
            }
        } else {
            stack.push(name);
            hasBeginTag = true;
        }
        return true;
    }
    public boolean validTagContent(String content) {
        return content.indexOf("![CDATA[") == 0;
    }
}
