/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package xmlfile;

/**
 *
 * @author Mohamed Yasser
 */
public class ConvertPrefixToPostfix {

    public String prefixToPostfixValue(String prefix) {
        
        stackLinkedList<String> stack = new stackLinkedList<>();
                String[] tokens = prefix.split("\\s+"); 


        int length = tokens.length;
        for (int i = length - 1; i >= 0; i--) {
            char c = tokens[i].charAt(0);

            if (!isOperator(c)) {
                stack.push(Character.toString(c));
            } else {
                String operand2 = stack.pop();
                String operand1 = stack.pop();
                String postfix = operand2 + " " + operand1 + " " + tokens[i]; 
                stack.push(postfix);
            }
        }

        return stack.pop();
    }

    public boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }
}
