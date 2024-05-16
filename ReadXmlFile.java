package com.mycompany.stack;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author Mohamed Yasser
 */
public class ReadXmlFile {

    public static String formatEquation(String equation) {

        StringBuilder formattedEquation = new StringBuilder();
        String[] tokens = equation.split("\\s+");

        for (String token : tokens) {
            switch (token) {
                case "addition" ->
                    formattedEquation.append("+ ");
                case "subtraction" ->
                    formattedEquation.append("- ");
                case "multiplication" ->
                    formattedEquation.append("* ");
                case "division" ->
                    formattedEquation.append("/ ");
                default -> {
                    if (!token.isEmpty()) {
                        formattedEquation.append(token).append(" ");
                    }
                }
            }
        }
        return formattedEquation.toString().trim();
    }
}
