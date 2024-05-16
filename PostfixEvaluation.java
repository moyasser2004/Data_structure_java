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
public class PostfixEvaluation {

    public  boolean isOperator(char c) {
        return (c == '+' || c == '-' || c == '*' || c == '/');
    }

    public int calculation(int num1, int num2, char operation) {
        int answer = 0;
        switch (operation) {
            case '+' ->
                answer = num2 + num1;
            case '-' ->
                answer = num2 - num1;
            case '*' ->
                answer = num2 * num1;
            case '/' ->
                answer = num2 / num1;
        }
        return answer;
    }

    public void postFixCalculation(String input) {

        String[] tokens = input.split(" ");
        String exc = String.join("", tokens);
        
        stackLinkedList<Integer> stack = new stackLinkedList<>();

        for (int i = 0; i < tokens.length; i++) {
           
            char c= exc.charAt(i);  
            
            if (!isOperator(c)) {
                String x = String.valueOf(c); 
                int num = Integer.parseInt(x);
                stack.push(num);
            } else {
                int num1 = stack.pop();
                int num2 = stack.pop();
                int result = calculation(num1, num2, c);
                stack.push(result);
            }
        }

        System.out.println("Answer= " + stack.pop());
    }

}


