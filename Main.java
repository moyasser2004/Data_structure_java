package com.mycompany.stack;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.EmptyStackException;
import java.util.Scanner;

/**
 *
 * @author Mohamed Yasser
 */
//+ / + 21 42 9 / - 30 * * 3 4 2 2
public class Main {

    public static boolean isDataType(char C) {
        return (C >= '0' && C <= '9') || (C >= 'a' && C <= 'z') || (C >= 'A' && C <= 'Z');
    }

    private static String parseExpression(Element exprElement) {
        StringBuilder formattedEquation = new StringBuilder();

        NodeList children = exprElement.getChildNodes();
        for (int i = 0; i < children.getLength(); i++) {
            Node child = children.item(i);
            if (child.getNodeType() == Node.ELEMENT_NODE) {
                Element childElement = (Element) child;

                switch (childElement.getNodeName()) {
                    case "operator":
                        String operatorValue = childElement.getAttribute("value");
                        switch (operatorValue) {
                            case "+":
                                formattedEquation.append("+ ");
                                break;
                            case "-":
                                formattedEquation.append("- ");
                                break;
                            case "*":
                                formattedEquation.append("* ");
                                break;
                            case "/":
                                formattedEquation.append("/ ");
                                break;
                            default:
                                throw new IllegalArgumentException("Invalid operator value: " + operatorValue);
                        }
                        break;

                    case "expr":
                        formattedEquation.append(parseExpression(childElement));
                        break;

                    case "atom":
                        String atomValue = childElement.getAttribute("value");
                        if (!isDataType(atomValue.charAt(0))) {
                            throw new IllegalArgumentException("Invalid atom value: " + atomValue);
                        }
                        formattedEquation.append(atomValue).append(" ");
                        break;
                }
            }
        }

        return formattedEquation.toString();
    }

    public static void main(String[] args) {

        try {
            File file = new File("C:\\Users\\Mohamed Yasser\\Documents\\NetBeansProjects\\stack\\src\\main\\java\\com\\mycompany\\stack\\file4-1.xml");

            DocumentBuilderFactory xmlBuilder = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = xmlBuilder.newDocumentBuilder();
            Document document = docBuilder.parse(file);
            document.getDocumentElement().normalize();
            NodeList nodeList = document.getElementsByTagName("expr");

            if (nodeList.getLength() == 0) {
                System.out.println("No 'expr' element found in the XML file.");
                return;
            }

            Node node = nodeList.item(0);

            if (node.getNodeType() == Node.ELEMENT_NODE) {
                try {
                    String expression = parseExpression((Element) node);
                    if (expression.isEmpty()) {
                        System.out.println("Invalid XML file. Could not extract a valid prefix expression.");
                    } else {

                        System.out.println(expression);
                        
                        String [] tokens = expression.split(" ");
                        String  expressionWithoutSpace = String.join("", tokens);
                        
                        PrefixToInfix PrefixToInfix = new PrefixToInfix();
                        String prefixToInfixEquation = PrefixToInfix.prefixToInfix(expressionWithoutSpace);
                        System.out.println("Infix Equation: " + prefixToInfixEquation);

                    }
                } catch (IllegalArgumentException e) {
                    System.out.println("Invalid XML file. " + e.getMessage());
                } catch (EmptyStackException e) {
                    System.out.println("Invalid prefix expression");
                } catch (ArithmeticException e) {
                    System.out.println("Arithmetic error during evaluation: " + e.getMessage());
                }
            }
        } catch (Exception e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
        }

//        try {
//            File inputFile = new File("C:\\Users\\Mohamed Yasser\\Documents\\NetBeansProjects\\stack\\src\\main\\java\\com\\mycompany\\stack\\file4-1.xml");
//
//            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
//            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
//            Document doc = dBuilder.parse(inputFile);
//            doc.getDocumentElement().normalize();
//
//            String equation = parseExpression(doc.getDocumentElement());
//            System.out.println("Equation: " + equation);
//
//            Allowed allow = new Allowed();
//
//            if (allow.allowed(equation)) {
//
//                System.out.println("allow");
//
//                String expressionWithoutParentheses = equation.replaceAll("[()]", "");
//
//                System.out.println("Prefix Equation: " + expressionWithoutParentheses);
//   String result = convertPrefixToPostfix("+/+21429/-30**3422");
//    System.out.println("The Equivalent Postfix is : "+ result); 

//        PrefixToInfix PrefixToInfix = new PrefixToInfix();
//                String prefixToInfixEquation = PrefixToInfix.prefixToInfix(expressionWithoutParentheses);
//                System.out.println("Infix Equation: " + prefixToInfixEquation);
//
//                preFixToPostFix prefixToPostfix = new preFixToPostFix();
//                String postfixEquation = prefixToPostfix.prefixToPostfixValue(expressionWithoutParentheses);
//                System.out.println("Postfix Equation: " + postfixEquation);
//                PostfixEvaluation postfixEvaluation = new PostfixEvaluation();
//                postfixEvaluation.postFixCalculation("22432**03-/94+/+");
//            } else {
//                System.out.println("Error in Expression");
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//    public static String parseExpression(Element element) {
//        StringBuilder result = new StringBuilder();
//
//        NodeList childNodes = element.getChildNodes();
//        for (int j = 0; j < childNodes.getLength(); j++) {
//            Node childNode = childNodes.item(j);
//            if (childNode.getNodeType() == Node.ELEMENT_NODE) {
//                Element childElement = (Element) childNode;
//                String nodeName = childElement.getNodeName();
//                if (nodeName.equals("operator")) {
//                    String operatorValue = childElement.getAttribute("value");
//                    result.append("").append(operatorValue).append("");
//                } else if (nodeName.equals("atom")) {
//                    String atomValue = childElement.getAttribute("value");
//                    result.append(atomValue);
//                } else if (nodeName.equals("expr")) {
//                    result.append("(").append(parseExpression(childElement)).append(")");
//                }
//            }
//        }
//        return result.toString();
//    }
//            ReadXmlFile readfile = new ReadXmlFile();
//            File inputFile = new File("C:\\Users\\Mohamed Yasser\\Documents\\NetBeansProjects\\stack\\src\\main\\java\\com\\mycompany\\stack\\file4.xml");
//
//            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
//            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
//            Document doc = dBuilder.parse(inputFile);
//            doc.getDocumentElement().normalize();
//
//            NodeList expressionList = doc.getElementsByTagName("expression");
//            Element expressionElement = (Element) expressionList.item(0);
//
//
//        } catch (Exception e) {
//            System.out.println(e);
//        }
    }
}

//Prefix notation: "+/+21429/-30**34222"

//Postfix notation:  "22432**03-/94+/+"
