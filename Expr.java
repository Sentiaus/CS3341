class Expr{
    Term tr;
    Expr ex;
    int flag = 0;
    void parse(Scanner s){
        //Checks if token is beginning of a term, if it is, parses the term
        if(s.currentToken() != Core.ID && s.currentToken() != Core.CONST && s.currentToken() != Core.LPAREN){
            System.out.println("1Error: Expected ID, CONST, or LPAREN Token. Got: " + s.currentToken());
            System.exit(1);
        }
        tr = new Term();
        tr.parse(s);
        if(s.currentToken() == Core.ADD){
            flag = 1;
            s.nextToken();
            if(s.currentToken() != Core.ID && s.currentToken() != Core.CONST && s.currentToken() != Core.LPAREN){
                System.out.println("2Error: Expected ID, CONST, or LPAREN Token. Got: " + s.currentToken());
                System.exit(1);
            }
            ex = new Expr();
            ex.parse(s);
        }else if( s.currentToken() == Core.SUBTRACT){
            flag  = 2;
            s.nextToken();
            if(s.currentToken() != Core.ID && s.currentToken() != Core.CONST && s.currentToken() != Core.LPAREN){
                System.out.println("3Error: Expected ID, CONST, or LPAREN Token. Got: " + s.currentToken());
                System.exit(1);
            }
            ex = new Expr();
            ex.parse(s);
        }
    }
    void print(){
        tr.print();
        if(flag == 1){
            System.out.println("+");
            ex.print();
        }else if(flag == 2){
            System.out.println("-");
            ex.print();
        }
    }
}