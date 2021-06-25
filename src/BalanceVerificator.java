import java.util.*;

/**
 * @author Solodovnykov M.S.
 * @version 1.0
 */

public class BalanceVerificator {

    public static void balValid(String str) {
        // Check for validity
        if (!str.matches("[^a-zA-Z0-9]+")) {
            System.out.println("The string contains character that doesn’t belong to bracket types ([{ or }])");
        } else {
            // Create base
            Stack<Character> s = new Stack<Character>();
            int cout = 0; // counter
            for (char c : str.toCharArray()) {
                if (c == '(' || c == '{' || c == '[') {
                    s.push(c);
                    cout++;
                } else {
                    // Check if a parenthesis is open or closed
                    if (s.empty()) {
                        System.out.println(str);
                        System.out.println("The string is not balanced, because the brackets enclosed by the matched pair "
                                + cout + " not balanced");
                        return;
                    } else {
                        char top = (Character) s.peek();
                        if (c == ')' && top == '(' || c == '}' && top == '{' || c == ']' && top == '[') {
                            s.pop();
                        } else {
                            System.out.println(str);
                            System.out.println("The string is not balanced, because the brackets enclosed by the matched pair "
                                    + cout + " not balanced " + top);
                            return;
                        }
                    }
                }
            }
            // Determine the status
            if (s.empty()) {
                System.out.println(str);
                System.out.println("The string " + str + " meets both criteria for being a balanced string.");
            } else {
                System.out.println(str);
                System.out.println("The string is not balanced, because the brackets enclosed by the matched pair "
                        + cout + " not balanced");
            }
        }
    }

    public static void main(String args[]) {
        String str1 = "{[()]}";
        String str2 = "{[(]}";
        String str3 = "{{[[(())]]}}";
        String str4 = "s[]";
        String str5 = "9{}";

        balValid(str1);
        balValid(str2);
        balValid(str3);
        balValid(str4);
        balValid(str5);
    }

}