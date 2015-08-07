package lexer;

import java.util.Scanner;
import java.util.Hashtable;
import java.util.StringTokenizer;

/**
 *
 * @author Jackson Isaac
 */

public class LexicalAnalyser {

    static Hashtable<String, String> tokenType;

    public static void main(String[] args) {
        
        // Setting up the HashTable <key, value> pairs.
        tokenType = new Hashtable<String, String>();
        tokenType.put("=", "ASSIGN");
        tokenType.put("+", "PLUS");
        tokenType.put("-", "MINUS");
        tokenType.put("*", "TIMES");
        tokenType.put("/", "DIV");
        tokenType.put("if", "IF");
        tokenType.put("else", "ELSE");
        tokenType.put("for", "FOR");
        tokenType.put("while", "WHILE");
        tokenType.put("int", "INT");
        tokenType.put("float", "FLOAT");
        tokenType.put("switch", "SWITCH");
        tokenType.put("case", "CASE");
        tokenType.put("do", "DO");
        tokenType.put("(", "LPAREN");
        tokenType.put(")", "RPAREN");
        tokenType.put(";", "SEMICLN");
        tokenType.put("==", "EQ");
        tokenType.put("!=", "NEQ");
        tokenType.put("<", "LT");
        tokenType.put("<=", "LEQ");
        tokenType.put(">", "GT");
        tokenType.put(">=", "GEQ");
        
        Scanner in = new Scanner(System.in);
        String inp = in.nextLine();
        // Split string ignoring the whitespaces.
        String[] tokens = inp.split("[ ]+");
//        for (int i = 0; i < tokens.length; i++) {
//            checkLexical(tokens[i]);
//        }
        if( checkLexical(tokens) ) {
            System.out.println("Valid input found");
        } else {
            System.out.println("Invalid input");
        }
    }
    
    static boolean checkLexical (String[] inp) {
        for (int i = 0; i < inp.length; i++) {
            if(tokenType.get(inp[i]) != null) {
                System.out.println("< " + tokenType.get(inp[i]) + ", " + inp[i] + ">");
            } else {
                if(inp[i].matches("[a-zA-Z][a-zA-Z0-9]*")) {
                    System.out.println("< ID, " + inp[i] + ">");
                } else if(inp[i].matches("[0-9]+")) {
                    System.out.println("< NUM, " + inp[i] + ">");
                } else if(inp[i].matches("[0-9]+\\.?[0-9]+")) {
                    System.out.println("< REAL, " + inp[i] + ">");
                }  else if(inp[i].matches("\"[[a-zA-Z0-9]|[ ]]*\"")) {
                    System.out.println("< STRING, " + inp[i] + ">");
                } else {
                    System.out.println("< ERROR, " + inp[i] + ">");
                }
            }
        }
        return true;
    }
}
