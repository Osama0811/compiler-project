package lexecal;
enum TokenType {
    ID,
    NUM,
    PLUS,
    MINUS,
    MULT,
    DIV,
    LEFTPAREN,
    RIGHTPAREN
}
public class Token {
    public TokenType type;
    public String value;

    public Token(TokenType type, String value) {
        this.type = type;
        this.value = value;
    }
}
