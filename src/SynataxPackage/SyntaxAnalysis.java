/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SynataxPackage;

/**
 *
 * @author dell
 */
import java.util.ArrayList;
import java.util.List;
import SynataxPackage.Token;



public class SyntaxAnalysis {

    static ArrayList<Token> syntaxAnalysis(ArrayList<Token> tokens) {
        if (tokens.size() >= 8 &&
                tokens.get(0).type.equals("keyword") && tokens.get(0).value.equals("int") &&
                tokens.get(1).type.equals("identifier") &&
                tokens.get(2).type.equals("symbol") && tokens.get(2).value.equals("(") &&
                tokens.get(3).type.equals("symbol") && tokens.get(3).value.equals(")") &&
                tokens.get(4).type.equals("symbol") && tokens.get(4).value.equals("{") &&
                tokens.get(5).type.equals("keyword") && tokens.get(5).value.equals("return") &&
                tokens.get(6).type.equals("number") &&
                tokens.get(7).type.equals("symbol") && tokens.get(7).value.equals(";")) {

            ArrayList<Token> parseTree = new ArrayList<>();
            parseTree.add(new Token("FunctionDeclaration", ""));
            parseTree.add(new Token("ReturnType", "int"));
            parseTree.add(new Token("FunctionName", tokens.get(1).value));
            parseTree.add(new Token("ReturnValue", tokens.get(6).value));

            return parseTree;
        } else {
            return new ArrayList<>();
        }
    }

    public static void main(String[] args) {
        String input = "int main() { return 0; }";

        ArrayList<Token> tokens = new ArrayList<>();
        tokens.add(new Token("keyword", "int"));
        tokens.add(new Token("identifier", "main"));
        tokens.add(new Token("symbol", "("));
        tokens.add(new Token("symbol", ")"));
        tokens.add(new Token("symbol", "{"));
        tokens.add(new Token("keyword", "return"));
        tokens.add(new Token("number", "0"));
        tokens.add(new Token("symbol", ";"));
        tokens.add(new Token("symbol", "}"));

        ArrayList<Token> parseTree = syntaxAnalysis(tokens);

        if (!parseTree.isEmpty()) {
            for (Token token : parseTree) {
                System.out.println(token.type + ": " + token.value);
            }
        } else {
            System.out.println("Syntax error: Invalid program structure.");
        }
    }
}
