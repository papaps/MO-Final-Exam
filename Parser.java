import java.util.ArrayList;
import java.util.Stack;

public class Parser {
    public Table table;

    public Parser() {
        this.table = new Table();
    }

    public String parse(ArrayList<Token> tokenList) {
        Stack<String> stack = new Stack<>();
        int pointer = 0;
        boolean over = false;

        ArrayList<String> tokenString = new ArrayList<>();
        for (Token token: tokenList)
            tokenString.add(token.toString());

        stack.push("$");
        stack.push("S");

        if(!tokenString.contains("ERROR")){
            while(stack.peek()!="$" || !over) {
                Token token = null;

                if (pointer < tokenList.size()) {
                    token = tokenList.get(pointer);

                    if (!over && stack.peek().equals(token.getTokenType())) {
                        stack.pop();
                        pointer++;
                    } else if (!over && stack.peek()=="$") {
                        return "- REJECT";
                    } else if (!over && table.containsElement(stack.peek(), token.toString())) {
                        expand(stack, table.getElement(stack.peek(), token.toString()));
                    } else {
                        return " - REJECT";
                    }

                    if (stack.peek().equals("")) {
                        stack.pop();
                    }
                } else {
                    over = true;
                    if (table.containsKey(stack.peek())) {
                        expand(stack, table.getElement(stack.peek(), "$"));
                        if (stack.peek().equals("")) {
                            stack.pop();
                        }
                    } else {
                        return " - REJECT";
                    }
                }
            }
            return " - ACCEPT";
        }
        else {
            return " - REJECT";
        }
    }

    public void expand(Stack stack, String production) {
        if (stack.isEmpty()) {
            return;
        }
        stack.pop();

        String[] symbol = production.split(" ");
        for(int i = symbol.length-1; i >= 0; i--) {
            stack.push(symbol[i]);
        }
    }
}