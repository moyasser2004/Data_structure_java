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
public class preFixToPostFix {

    public  String prefixToPostfixValue(String prefix) {
        stackLinkedList<String> stack = new stackLinkedList<>();

        int length = prefix.length();
        for (int i = length - 1; i >= 0; i--) {
            char c = prefix.charAt(i);

            if (!isOperator(c)) {
                stack.push(Character.toString(c));
            } else {
                String operand1 = stack.pop();
                String operand2 = stack.pop();
                String postfix = operand1 + operand2 + c;
                stack.push(postfix);
            }
        }

        return stack.pop();
    }

   public  boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }
    
}

