/*
*   A calculator to solve simple arithmetic expressions.
*   Currently, it only works with simple digit numbers.
*   We will expand its features and capabilities later.
*   added % and correct whitespace issue
*   
*/

import java.io.CharArrayReader;
import java.util.Scanner;
import java.util.Stack;

import javax.lang.model.util.ElementScanner14;

//import jdk.javadoc.internal.doclets.formats.html.SourceToHTMLConverter;

public class Calculator{
    public static void main(String[] args) throws Exception{
        Scanner scanner = new Scanner(System.in);
        boolean exit= true;
        int choice;

        while (exit){
            System.out.println("1. Expression to solve:");
            System.out.println("2. Exit: ");
            System.out.print("Your choice: ");
            choice= scanner.nextInt();
            scanner.nextLine();  // flushing scanner
            if(choice==1){
                System.out.println("1. Expression to solve:");
                String input = scanner.nextLine();
                String temp = input.replaceAll(" ", ""); //removing spaces

                if(input.length()==0) break;
                System.out.println("ANS: "+evaluate(temp)+"\n");
                }
            else if(choice==2){
                System.out.println("Thanks and keep contributing");
                exit = false;
                break;
            }
            else
            System.out.println("Enter correct choice");
        }
    }

    public static int evaluate(String exp) throws Exception{
        Stack<Character> operators = new Stack<>();
        Stack<Integer> operands = new Stack<>();

        for(int i=0;i<exp.length();i++){
            char c = exp.charAt(i);

            if(isOperand(c)){
                StringBuilder opr = new StringBuilder();
                while(i<exp.length() && isOperand(exp.charAt(i))){
                    opr.append(exp.charAt(i++)); //keeps pointing to next 
                }
                operands.push(Integer.parseInt(opr.toString()));
                i--;
                
            }
            
            else if(c=='('){
                operators.push(c);

            }
            else if(c==')'){
                while(operators.peek()!='('){
                    int b = operands.pop();
                    int a = operands.pop();
                    char op = operators.pop();
                    operands.push(operate(b,a,op)); 
                }
                operators.pop(); //popped ')'
            }
            else if(isOperator(c)){
                while(!operators.empty() && opPrec(operators.peek())>=opPrec(c)){
                    int b = operands.pop();
                    int a = operands.pop();
                    char op = operators.pop();
                    operands.push(operate(b, a, op)); // corrected the order
                }
                operators.push(c); // push next character
            }
            
        }
        while(!operators.empty()){
            int b = operands.pop();
            int a = operands.pop();
            char op = operators.pop();
            operands.push(operate(b,a,op));
        }
        return operands.pop();
    }

    public static int opPrec(char op){
            if (op == '+' || op == '-') {
                return 1;
            }
            if (op == '*' || op == '/' || op == '%') {
                return 2;
            }
            if (op == '^' || op == '$') {
                return 3;
            }
            return 0;
        }

    public static boolean isOperator(char op){
        switch (op){
            case '+':
            case '-':
            case '*':
            case '/':
            case '(':
            case ')':
            case '%':
                return true;
        }
        return false;
    }

    public static boolean isOperand(char op){
        return (op>='0'&& op<='9');
    }

    public static int operate(int b, int a, char op) throws Exception{
        switch (op){
            case '+':
                return a+b;
                
            case '-':
                return a-b;

            case '*':
                return a*b;

            case '/':
                if(b==0){
                    throw new Exception("Cannot divide by 0");
                }
                    return a/b;  
            case '%':
                return a%b;
        }
        return 0;
    }
}