import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;

public class validParenthesis {

    public boolean isValid(String s) {
        Map<Character, Character> map = Map.of(
                '(', ')',
                '{', '}',
                '[', ']'
        );
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if (ch == ')' || ch == ']' || ch == '}' ){
                if (!stack.isEmpty() && map.get(stack.peek()) == ch){
                    stack.pop();
                } else {
                    return false;
                }
            } else {
                stack.push(ch);
            }
        }
        return stack.isEmpty();
    }
}
