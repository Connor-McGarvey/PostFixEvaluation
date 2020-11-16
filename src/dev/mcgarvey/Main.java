package dev.mcgarvey;

import java.util.Stack;

import static java.lang.Math.pow;

public class Main {

    public static void main(String[] args) {
	String postfix = "5 4 * 3 2 * + 1 -";
	Double answer = evaluate(postfix);
	System.out.println(answer);
    }

    // evaluate method
    public static Double evaluate(String postfix){
        // create stack
        Stack<Double> s = new Stack<Double>();

        // string to character array
        char[] chars = postfix.toCharArray();
        int charsLength = chars.length;

        for(int i = 0; i < charsLength; i++){
            // iterating through char Array
            char currentChar = chars[i];

            if(isOpperation(currentChar)){
                switch(currentChar){
                    case '+' : s.push(s.pop() + s.pop()); break;
                    case '-' : s.push(-s.pop() + s.pop()); break;
                    case '*' : s.push(s.pop() * s.pop()); break;
                    case '/' : s.push(1 / s.pop() * s.pop()); break;
                    case '^' : s.push(pow(s.pop(),s.pop())); break;
                }
            } else if(Character.isDigit(currentChar)){
                //numbers get pushed to the stack
                s.push(0.0);
                while(Character.isDigit(chars[i])){
                    s.push(10.0 * s.pop() + (chars[i++] - '0'));
                }
            }
        }
        if(!s.isEmpty()){
            return s.pop();
        }else{
            return 0.0;
        }
    }
    private static boolean isOpperation(char currentChar){
        // add trig functions
        return currentChar =='*' || currentChar == '/' || currentChar == '+' || currentChar =='-';
    }
}
