import java.util.ArrayList;

public class Scanner{
    ArrayList<Token> process (String input) {
        String[] parts = input.split("");
        ArrayList<String> words = new ArrayList<String>();

        for(String p: parts) {
            if (!p.contains(" "))
                words.add(p);
        }

        ArrayList<Token> tokenList = new ArrayList();
        for (String w : words) {
            if (w.equals("")) {
                //do nothing
            } else {
                Token t = new Token(w);
                tokenList.add(t);
            }
        }

        return tokenList;
    }
}