/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.stack;

import xmlfile.stackLinkedList;

/**
 *
 * @author Mohamed Yasser
 */
public class PrefixToInfix {

    public boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

    public boolean isOperand(char c) {
        return Character.isDigit(c) || Character.isLetter(c);
    }

    public String prefixToInfix(String prefix) {
        stackLinkedList<String> stack = new stackLinkedList<>();

        int length = prefix.length();
        for (int i = length - 1; i >= 0; i--) {
            char c = prefix.charAt(i);

            if (isOperand(c)) {
                stack.push(Character.toString(c));
            } else if (isOperator(c)) {
                String operand1 = stack.pop();
                String operand2 = stack.pop();
                String infix = "(" + operand1 + c + operand2 + ")";
                stack.push(infix);
            }
        }

        return stack.pop();
    }

}
