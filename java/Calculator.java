/*
*   A calculator to solve simple arithmetic expressions.
*   Currently, it only works with simple digit numbers.
*   We will expand its features and capabilities later.
*/

import java.util.Scanner;
import java.util.Stack;

public class Calculator{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        while (true){
            System.out.println("Enter an expression to solve:");
            String input = scanner.nextLine();
            if(input.length()==0) break;
            System.out.println("ANS: "+evaluate(input)+"\n");
        }
    }

    public static int evaluate(String exp){
        Stack<Character> operators = new Stack<>();
        Stack<Integer> operands = new Stack<>();
        int i = 0;
        String num="";
        while (i<exp.length()){   
            char c = exp.charAt(i);
            if(isOperand(c)){
                while (isOperand(c) && i<exp.length()-1) {
                    num+=Character.toString(c);
                    i++;
                    c=exp.charAt(i);
                }
                operands.push(Integer.parseInt(num));
                num="";
            }else if(c=='('){
                operators.push(c);
            }else if(c==')'){
                while(operators.peek()!='('){
                    int b = operands.pop();
                    int a = operands.pop();
                    char op = operators.pop();
                    operands.push(operate(a,b,op));
                }
                operators.pop();
            }else if(isOperator(c)){
                while(!operators.empty() && opPrec(operators.peek())>=opPrec(c)){
                    int b = operands.pop();
                    int a = operands.pop();
                    char op = operators.pop();
                    operands.push(operate(a,b,op));
                }
                operators.push(c);
            }
            i++;
        }
        while(!operators.empty()){
            int b = operands.pop();
            int a = operands.pop();
            char op = operators.pop();
            operands.push(operate(a,b,op));
        }
        return operands.peek();
    }

    public static int opPrec(char op){
        switch (op){
            case '+':
            case '-':
                return 1;
            case '*':
                return 2;
            case '/':
                return 2;
            case '(':
            case ')':
                return -2;
        }
        return -1;
    }

    public static boolean isOperator(char op){
        switch (op){
            case '+':
            case '-':
            case '*':
            case '/':
            case '(':
            case ')':
                return true;
        }
        return false;
    }

    public static boolean isOperand(char op){
        return Character.isDigit(op);
    }

    public static int operate(int a, int b, char op){
        int result = 0;
        switch (op){
            case '+':
                result = a+b;
                break;
            case '-':
                result = a-b;
                break;
            case '*':
                result = a*b;
                break;
            case '/':
                result = a/b;
                break;
        }
        return result;
    }
}