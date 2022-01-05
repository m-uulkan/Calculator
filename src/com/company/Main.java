package com.company;

import java.util.IllegalFormatException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static int valueOne, valueTwo;
    static char operation;
    static int result;

    public static void main(String[] args) throws MyException {

        System.out.println("Write 2 integers and 1 operation: ");

        try {
            String userInput = scanner.nextLine();
            char[] chars = new char[15];
            for (int i = 0; i < userInput.length(); i++) {
                chars[i] = userInput.charAt(i);
                if (chars[i] == '+') {
                    operation = '+';
                }
                if (chars[i] == '-') {
                    operation = '-';
                }
                if (chars[i] == '*') {
                    operation = '*';
                }
                if (chars[i] == '/') {
                    operation = '/';
                }
            }

            String forum = String.valueOf(chars);
            String[] index = forum.split("[+-/*]");
            String one = index[0];
            String two = index[1];
            String three = two.trim();

            valueOne = NumberOfRome.romanNumber(one);
            valueTwo = NumberOfRome.romanNumber(three);


            if (one.matches("[A-Z]*") && three.matches("[A-Z]*")) {
                if (valueOne > 0 && valueOne < 11 && valueTwo > 0 && valueTwo < 11) {
                    result = Calculate(operation, valueOne, valueTwo);
                    String s = NumberOfRome.convertNumToRoman(result);
                    System.out.println(s);

                }else{
                    System.out.println("accepts numbers from 1 to 10");
                }
            } else {
                valueOne = Integer.parseInt(one);
                valueTwo = Integer.parseInt(three);
                if (valueOne > 0 && valueOne < 11 && valueTwo > 0 && valueTwo < 11) {
                    result = Calculate(operation, valueOne, valueTwo);
                    System.out.println(result);
                }else{
                    System.out.println("accepts numbers from 1 to 10");
                }
            }

        } catch (MyException e) {
            System.err.println(e.getMessage());

        } catch (NumberFormatException e) {
            System.out.println("Write Arabic number or Roman");
        }
    }
    public static int Calculate(char opera, int valueOne, int valueTwo) throws MyException {

                switch (opera) {
                    case ('+'):
                        result = valueOne + valueTwo;
                        break;
                    case ('-'):
                        result = valueOne - valueTwo;
                        break;
                    case ('*'):
                        result = valueOne * valueTwo;
                        break;
                    case ('/'):
                        result = valueOne / valueTwo;
                        break;
                    default:
                        System.out.println("error");
                }

            return result;
        }



    }
