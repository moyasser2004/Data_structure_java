/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package xmlfile;

/**
 *
 * @author Mohamed Yasser
 */
public class ConvertPrefixToInfix {

    private static boolean isOperator(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
    }

    public String convertPrefixToInfix(String prefixExpression) {

        stackLinkedList<String> stack = new stackLinkedList<>();
        String[] tokens = prefixExpression.split("\\s");
        
        for (int i = tokens.length - 1; i >= 0; i--) {
            String token = tokens[i];
            if (isOperator(token)) {
                String operand1 = stack.pop();
                String operand2 = stack.pop();
                String infixExpression = "(" + operand1 + token + operand2 + ")";
                stack.push(infixExpression);
            } else {
                stack.push(token);
            }
        }
        return stack.pop();
    }

}
