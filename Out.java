class Out{
    Expr ex;

    void parse(Scanner s){
        //Checks if Current Token is OUT Token, NEXT TOKEN
        if(s.currentToken()!=Core.OUT){
            System.out.println("ERROR: Expected OUT Token");
            System.exit(1);
        }
        s.nextToken();
        //Checks if Current Token is LPAREN, NEXT TOKEN
        if(s.currentToken()!=Core.LPAREN){
            System.out.println("ERROR: Expected LPAREN Token");
            System.exit(1);
        }
        s.nextToken();
        //Checks if token is beginning of an expression, if it is, parses the expression
        if(s.currentToken() != Core.ID || s.currentToken() != Core.CONST || s.currentToken() != Core.LPAREN){
            System.out.println("Error: Expected ID, CONST, or LPAREN Token");
            System.exit(1);
        }
        ex = new Expr();
        ex.parse(s);

        //Checks if token is RPAREN, NEXT TOKEN
        if(s.currentToken()!=Core.RPAREN){
            System.out.println("ERROR: Expected RPAREN Token");
            System.exit(1);
        }
        s.nextToken();

        //Checks if Token is Semicolon, NEXT TOKEN
        if(s.currentToken()!= Core.SEMICOLON){
            System.out.println("Error: Expeceted SEMICOLON Token");
            System.exit(1);
        }
        s.nextToken();
    }

    void print(){
        System.out.println("out(");
        ex.print();
        System.out.print(");");
    }
}