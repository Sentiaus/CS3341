import java.util;
import java.io;

class Scanner {
    private Queue<Core> tokenQueue;
    private BufferedReader reader;
    private Queue<String> idQueue;
    private Queue<Integer> constQueue;
    // Initialize the scanner
    Scanner(String filename) {
        try{
            reader = new BufferedReader(new FileReader(filename));
            tokenQueue = new LinkedList<>();
            idQueue = new LinkedList<>();
            constQueue = new LinkedList<>();
            tokenize();
        }catch (IOException e){
            System.out.println("Error: File not found");
        }
    }

    private void tokenize(){
        StringBuilder s = new StringBuilder();
        int c;
        int specialEqual;
        try{
            while((c = reader.read()) != -1){
                char ch = (char) c;
                if (Character.isWhitespace(ch)){
                    if(s.length() > 0){
                        addToken(s.toString());
                        s = new StringBuilder();
                    }
                } else if(ch == '+' || ch == '-' || ch == '*' || ch == '/' ||ch == ':'|| ch == '=' || ch == '=' || ch == '<' || ch == ';' || ch == '.' || ch == ',' || ch == '(' || ch == ')' || ch == '[' || ch == ']'){
                    if(s.length() > 0){
                        addToken(s.toString());
                        s = new StringBuilder();
                    }
                    if(ch == ':'){
                        if(reader.ready()){
                            specialEqual = reader.read();
                            if(specialEqual == '='){
                                s.append(ch);
                                s.append(specialEqual);
                                addToken(s.toString());
                                s = new StringBuilder();
                            }else{
                            addToken(Character.toString(ch));
                            addToken(Character.toString(specialEqual));
                            }

                        }else{
                            addToken(Character.toString(ch));
                        }
                    }else{
                    addToken(Character.toString(ch));
                    }
                } else {
                    s.append(ch);
                }
            }
            if(s.length()>0){
                addToken(s.toString());
            }
        }catch (IOException e){
            System.out.println("Error: Tokenizer failed!")
        }
    }
    
    private Core mapStringToCore(String str){
        switch (str) {
            case "procedure": return Core.PROCEDURE;
            case "begin": return Core.BEGIN;
            case "is": return Core.IS;
            case "end": return Core.END;
            case "if": return Core.IF;
            case "else": return Core.ELSE;
            case "in": return Core.IN;
            case "integer": return Core.INTEGER;
            case "return": return Core.RETURN;
            case "do": return Core.DO;
            case "new": return Core.NEW;
            case "not": return Core.NOT;
            case "and": return Core.AND;
            case "or": return Core.OR;
            case "out": return Core.OUT;
            case "array": return Core.ARRAY;
            case "then": return Core.THEN;
            case "while": return Core.WHILE;
            case "+": return Core.ADD;
            case "-": return Core.SUBTRACT;
            case "*": return Core.MULTIPLY;
            case "/": return Core.DIVIDE;
            case ":=": return Core.ASSIGN;
            case "=": return Core.EQUAL;
            case "<": return Core.LESS;
            case ":": return Core.COLON;
            case ";": return Core.SEMICOLON;
            case ".": return Core.PERIOD;
            case ",": return Core.COMMA;
            case "(": return Core.LPAREN;
            case ")": return Core.RPAREN;
            case "[": return Core.LBRACE;
            case "]": return Core.RBRACE;
            default:
                if (str.matches("[0-9]+")){
                    int val = Integer.parseInt(str);
                    if (val >= 0 && val <= 100003){
                        return Core.CONST;
                    }else{
                        System.out.println("Error: CONST " + str + " is not a valid number, or is not in the range of 0 to 100003");
                        return Core.ERROR;
                    }
                } else if(str.matches("[a-zA-Z][a-zA-Z0-9]*")){
                    return Core.ID;
                } else {
                    System.out.println("Error: Token "+ str + " is not valid!");
                    return Core.ERROR;
                }
        }
    }

    private void addToken(String str){
        Core token = mapStringToCore(str);
        tokenQueue.add(token);
        if (token == Core.ID){
            idQueue.add(str);
        }else if(token == Core.CONST){
            constQueue.add(Integer.parseInt(str));
        }
    }

    // Advance to the next token
    public void nextToken() {
        if (!tokenQueue.isEmpty()){
            tokenQueue.poll();
        }
    }

    // Return the current token
    public Core currentToken() {
        if(!tokenQueue.isEmpty()){
            return tokenQueue.peek();
        }else{
            return Core.EOS;
        }
    }

	// Return the identifier string
    public String getId() {
        if(currentToken() == Core.ID){
            return idQueue.poll();
        }
        System.out.println("Error: Requested Token is not an ID");
        return null;
    }

	// Return the constant value
    public int getConst() {
        if(currentToken() == Core.CONST){
            return constQueue.poll();
        }
        System.out.println("Error: Requested Token is not a CONST");
    }

}
