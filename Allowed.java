package com.mycompany.stack;

import xmlfile.stackLinkedList;

/**
 *
 * @author Mohamed Yasser
 */
public class Allowed {

    public boolean allowed(String exc) {
        
        stackLinkedList<Character> stack = new stackLinkedList<>();

        for (int i = 0; i < exc.length(); i++) {
            char c = exc.charAt(i);

            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else if (c == ')' || c == '}' || c == ']') {
                
                if (stack.isEmpety() || !isPare(stack.getTop(), c)) {
                    return false;
                } else {
                    stack.pop();
                }

            }
        }
        return stack.isEmpety();
    }

    
    public boolean isPare(char open, char close) {
        if (open == '(' && close == ')') {
            return true;
        } else if (open == '{' && close == '}') {
            return true;
        } else {
            return (open == '[' && close == ']');
        }
    }

}
