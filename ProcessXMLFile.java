/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package xmlfile;

import java.io.File;
import java.io.IOException;
import java.util.EmptyStackException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author Mohamed Yasser
 */
public class ProcessXMLFile {

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

    
    public void processXMLFile(File file) {
        try {
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

                        System.out.println("Prefix expression: " + expression);

                        
                        ConvertPrefixToInfix convertPrefixToInfix = new ConvertPrefixToInfix();
                        String infixExpression = convertPrefixToInfix.convertPrefixToInfix(expression);
                        System.out.println("Infix expression: " + infixExpression);

                        
                        ConvertPrefixToPostfix convertPrefixToInfx = new ConvertPrefixToPostfix();
                        String postfixExpression = convertPrefixToInfx.prefixToPostfixValue(expression);
                        System.out.println("Postfix expression: " + postfixExpression);

                        
                        EvaluateInfixExpression evaluateInfixExpression = new EvaluateInfixExpression();
                        int evaluationResult = evaluateInfixExpression.evaluateInfixExpression(infixExpression);
                        System.out.println("Evaluation result: " + evaluationResult);

                    }
                } catch (IllegalArgumentException e) {
                    System.out.println("Invalid XML file. " + e.getMessage());
                } catch (EmptyStackException e) {
                    System.out.println("Invalid prefix expression");
                } catch (ArithmeticException e) {
                    System.out.println("Arithmetic error during evaluation: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading the XML file: " + e.getMessage());
        } catch (ParserConfigurationException | SAXException e) {
            System.out.println("An unexpected error occurred: " + e.getMessage());
        }
    }
}
