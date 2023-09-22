class Out{
    Expr ex;

    void parse(Scanner s){
        //Checks if Current Token is OUT Token, NEXT TOKEN
        if(s.currentToken()!=Core.OUT){
            System.out.println("ERROR: Expected OUT Token");
            System.exit(1);
        }
        s.nextToken();
        //Checks if Current Token is LPARANTHESES, NEXT TOKEN
        if(s.currentToken()!=Core.LPARANTHESES){
            System.out.println("ERROR: Expected LPARANTHESES Token");
            System.exit(1);
        }
        s.nextToken();
        //Checks if token is beginning of an expression, if it is, parses the expression
        if(s.currentToken() != Core.ID || s.currentToken() != Core.CONST || s.currentToken() != Core.LPARANTHESES){
            System.out.println("Error: Expected ID, CONST, or LPARANTHESES Token");
            System.exit(1);
        }
        ex = new Expr();
        ex.parse(s);

        //Checks if token is RPARANTHESES, NEXT TOKEN
        if(s.currentToken()!=Core.RPARANTHESES){
            System.out.println("ERROR: Expected RPARANTHESES Token");
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