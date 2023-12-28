package SynataxPackage;

enum TokenType {
    KEYWORD,
    IDENTIFIER,
    SYMBOL,
    NUMBER
}
class Token {
    String type;
    String value;

    public Token(String type, String value) {
        this.type = type;
        this.value = value;
    }
}