class Cmpr{
    Expr ex;
    Expr ex2;
    int flag = 0;

    void parse(Scanner s){
        //Checks if token is beginning of an expression, if it is, parses the expression
        if(s.currentToken() != Core.ID && s.currentToken() != Core.CONST && s.currentToken() != Core.LPAREN){
            System.out.println("Error: Expected ID, CONST, or LPAREN Token");
            System.exit(1);
        }
        ex = new Expr();
        ex.parse(s);

        if(s.currentToken() == Core.EQUAL){
            flag = 0;
        }else if(s.currentToken() == Core.LESS){
            flag = 1;
        }else{
            System.out.println("Error: Expected EQUAL or LESS Token");
        }
        s.nextToken();
        
        if(s.currentToken() != Core.ID && s.currentToken() != Core.CONST && s.currentToken() != Core.LPAREN){
            System.out.println("Error: Expected ID, CONST, or LPAREN Token");
            System.exit(1);
        }
        ex2 = new Expr();
        ex2.parse(s);
    }

    void print(){
        ex.print();
        if(flag == 0){
            System.out.print("=");
        }else if(flag == 1){
            System.out.print("<");
        }
        ex2.print();
    }
}