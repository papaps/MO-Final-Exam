public class Token{
    public enum TokenType{
        ALPHANUM,
        PLUS,
        STAR,
        OPTIONAL,
        LPAREN,
        RPAREN,
        EMPTY,
        UNION,
        ERROR
    }

    public TokenType tokenType;
    public String lexeme;

    private static final int q0 = 0;
    private static final int q1 = 1;
    private static final int q2 = 2;
    private static final int q3 = 3;
    private static final int q4 = 4;
    private static final int q5 = 5;
    private static final int q6 = 6;
    private static final int q7 = 7;
    private static final int q8 = 8;
    private static final int qdead = -1;

    private int state;

    public Token (String word) {
        this.lexeme = word;
        this.tokenType = identifyToken(word);
    }

    static private int transitions (int s, char c) {
        switch (s) {
            case q0: switch (c) {
                case '0': case '1': case '2': case '3': case '4': case '5': case '6': case '7': case '8': case '9':
                case 'a': case 'b': case 'c': case 'd': case 'e': case 'f': case 'g': case 'h': case 'i': case 'j':
                case 'k': case 'l': case 'm': case 'n': case 'o': case 'p': case 'q': case 'r': case 's': case 't':
                case 'u': case 'v': case 'w': case 'x': case 'y': case 'z': return q1;
                case '*': return q2;
                case '+': return q3;
                case '?': return q4;
                case '(': return q5;
                case ')': return q6;
                case 'U': return q7;
                case 'E': return q8;
                default: return qdead;
            }
            case q1: switch (c) {
                default: return qdead;
            }
            case q2: switch (c) {
                default: return qdead;
            }
            case q3: switch (c) {
                default: return qdead;
            }
            case q4: switch (c) {
                default: return qdead;
            }
            case q5: switch (c) {
                default: return qdead;
            }
            case q6: switch (c) {
                default: return qdead;
            }
            case q7: switch (c) {
                default: return qdead;
            }
            case q8: switch (c) {
                default: return qdead;
            }
            default: return qdead;
        }
    }

    public TokenType identifyToken(String word){
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            state = transitions(state, c);
        }
        if (state == q1)
            return TokenType.ALPHANUM;
        else if (state == q2)
            return TokenType.STAR;
        else if (state == q3)
            return TokenType.PLUS;
        else if (state == q4)
            return TokenType.OPTIONAL;
        else if (state == q5)
            return TokenType.LPAREN;
        else if (state == q6)
            return TokenType.RPAREN;
        else if (state == q7)
            return TokenType.UNION;
        else if (state == q8)
            return TokenType.EMPTY;
        else
            return TokenType.ERROR;
    }

    public String getTokenType() {return tokenType.toString();}
    public String getLexeme() {return lexeme;}

    @Override
    public String toString(){
        return this.tokenType.toString();
    }
}