/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package xmlfile;

/**
 *
 * @author Mohamed Yasser
 */
public class EvaluateInfixExpression {
    
    
    private static boolean isOperator(char token) {
        return token == '+' || token == '-' || token == '*' || token == '/';
    }

    
    private static boolean hasPrecedence(char operator1, char operator2) {
        return (operator1 == '*' || operator1 == '/') && (operator2 == '+' || operator2 == '-');
    }

    
    private static int applyOperator(char operator, int operand2, int operand1) {
        switch (operator) {
            case '+':
                return operand1 + operand2;
            case '-':
                return operand1 - operand2;
            case '*':
                return operand1 * operand2;
            case '/':
                if (operand2 == 0) {
                    throw new ArithmeticException("Division by zero");
                }
                return operand1 / operand2;
            default:
                throw new IllegalArgumentException("Invalid operator: " + operator);
        }
    }

    
    
    public  int evaluateInfixExpression(String infixExpression) {
        char[] tokens = infixExpression.toCharArray();

        stackLinkedList<Integer> values = new stackLinkedList<>();
        stackLinkedList<Character> operators = new stackLinkedList<>();

        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i] == ' ') {
                continue;
            }

            if (Character.isDigit(tokens[i])) {
                StringBuilder sb = new StringBuilder();
                while (i < tokens.length && (Character.isDigit(tokens[i]) || tokens[i] == '.')) {
                    sb.append(tokens[i++]);
                }
                i--;
                values.push(Integer.parseInt(sb.toString()));
            } else if (tokens[i] == '(') {
                operators.push(tokens[i]);
            } else if (tokens[i] == ')') {
                while (operators.getTop() != '(') {
                    int value = applyOperator(operators.pop(), values.pop(), values.pop());
                    values.push(value);
                }
                operators.pop(); // Pop '('
            } else if (isOperator(tokens[i])) {
                while (!operators.isEmpety()&& hasPrecedence(tokens[i], operators.getTop())) {
                    int value = applyOperator(operators.pop(), values.pop(), values.pop());
                    values.push(value);
                }
                operators.push(tokens[i]);
            }
        }

        while (!operators.isEmpety()) {
            int value= applyOperator(operators.pop(), values.pop(), values.pop());
            values.push(value);
        }

        return values.pop();
    }
}
