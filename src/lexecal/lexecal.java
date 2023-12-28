package lexecal;

import lexecal.Token;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.AbstractMap;

// Enum for token types


public class Lexer {
    // Map enum values to string names
    private static final Map<TokenType, String> tokenTypeNames = new HashMap<>();
    static {
        tokenTypeNames.put(TokenType.ID, "ID");
        tokenTypeNames.put(TokenType.NUM, "NUM");
        tokenTypeNames.put(TokenType.PLUS, "PLUS");
        tokenTypeNames.put(TokenType.MINUS, "MINUS");
        tokenTypeNames.put(TokenType.MULT, "MULT");
        tokenTypeNames.put(TokenType.DIV, "DIV");
        tokenTypeNames.put(TokenType.LEFTPAREN, "LEFTPAREN");
        tokenTypeNames.put(TokenType.RIGHTPAREN, "RIGHTPAREN");
    }

    // Lexical analyzer function
    public static List<Token> lexer(String sourceCode) {
        List<Token> tokens = new ArrayList<>();

     List<Map.Entry<TokenType, String>> patterns = new ArrayList<>();
patterns.add(new AbstractMap.SimpleEntry<>(TokenType.ID, "[a-zA-Z_]\\w*"));
patterns.add(new AbstractMap.SimpleEntry<>(TokenType.NUM, "\\d+"));
patterns.add(new AbstractMap.SimpleEntry<>(TokenType.PLUS, "\\+"));
patterns.add(new AbstractMap.SimpleEntry<>(TokenType.MINUS, "\\-"));
patterns.add(new AbstractMap.SimpleEntry<>(TokenType.MULT, "\\*"));
patterns.add(new AbstractMap.SimpleEntry<>(TokenType.DIV, "\\/"));
patterns.add(new AbstractMap.SimpleEntry<>(TokenType.LEFTPAREN, "\\("));
patterns.add(new AbstractMap.SimpleEntry<>(TokenType.RIGHTPAREN, "\\)"));

        Pattern pattern;
        Matcher matcher;
        String remaining = sourceCode;
        while (!remaining.isEmpty()) {
            boolean matched = false;

            // Try to match each pattern
            for (Map.Entry<TokenType, String> entry : patterns) {
                pattern = Pattern.compile(entry.getValue());
                matcher = pattern.matcher(remaining);
                if (matcher.find()) {
                    tokens.add(new Token(entry.getKey(), matcher.group()));
                    remaining = matcher.replaceFirst("");
                    matched = true;
                    break;
                }
            }

            if (!matched) {
                System.err.println("Error: Invalid character in source code: " + remaining.charAt(0));
                break;
            }
        }

        return tokens;
    }

    // Function to print tokens with type names
    public static void printTokens(List<Token> tokens) {
        for (Token token : tokens) {
            System.out.println("Type: " + tokenTypeNames.get(token.type) + "\tValue: " + token.value);
        }
    }

    public static void main(String[] args) {
        String sourceCode = "32 1 \\ / 3 ; . < ?";
        List<Token> tokens = lexer(sourceCode);

        printTokens(tokens);
    }
}
