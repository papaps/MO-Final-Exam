import java.util.HashMap;

public class Table {
    public HashMap<String, HashMap> table;

    public Table () {
        this.table = new HashMap<>();
        init();
    }

    public void init(){
        HashMap<String, String> S = new HashMap<>();
        S.put("EMPTY", "A B");
        S.put("LPAREN", "A B");
        S.put("ALPHANUM", "A B");

        HashMap<String, String> A = new HashMap<>();
        A.put("EMPTY", "EMPTY");
        A.put("LPAREN", "C");
        A.put("ALPHANUM", "C");

        HashMap<String, String> B = new HashMap<>();
        B.put("UNION", "UNION A B");
        B.put("LPAREN", "C B");
        B.put("RPAREN", "");
        B.put("ALPHANUM", "C B");
        B.put("$", "");

        HashMap<String, String> C = new HashMap<>();
        C.put("LPAREN", "D F");
        C.put("ALPHANUM", "D F");

        HashMap<String, String> D = new HashMap<>();
        D.put("LPAREN", "LPAREN S RPAREN");
        D.put("ALPHANUM", "ALPHANUM");

        HashMap<String, String> F = new HashMap<>();
        F.put("UNION", "");
        F.put("LPAREN", "");
        F.put("RPAREN", "");
        F.put("ALPHANUM", "");
        F.put("STAR", "STAR");
        F.put("PLUS", "PLUS");
        F.put("OPTIONAL", "OPTIONAL");
        F.put("$", "");

        table.put("S", S);
        table.put("A", A);
        table.put("B", B);
        table.put("C", C);
        table.put("D", D);
        table.put("F", F);
    }

    public String getElement(String nt, String t){
        HashMap element = table.get(nt);
        String derivation = (String) element.get(t);
        return derivation;
    }

    public Boolean containsElement(String nt, String t){
        HashMap element = table.get(nt);
        return element.containsKey(t);
    }

    public Boolean containsKey(String nt){
        return table.containsKey(nt);
    }
}
