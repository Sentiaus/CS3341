class If{
    Cond cd;
    StmtSeq ss;
    StmtSeq ss2;
    int flag = 0;
    void parse(Scanner s){
        //Checks if current token is an if token, NEXT TOKEN
        if(s.currentToken() != Core.IF){
            System.out.println("Error: Expected IF Token");
            System.exit(1);
        }
        s.nextToken();
        
        //Checks if current token is the beginning of a cond operation
        if(s.currentToken() != Core.ID && s.currentToken() != Core.CONST&& s.currentToken() != Core.LPAREN && s.currentToken() != Core.NOT){
            System.out.println("Error: Expected ID, CONST, LPAREN, or NOT Token");
            System.exit(1);
        }
        cd = new Cond();
        cd.parse(s);
        if(s.currentToken()!=Core.THEN){
            System.out.println("Error: Expected THEN Token. Got:" + s.currentToken());
            System.exit(1);
        }
        s.nextToken();
        if(s.currentToken() != Core.ID && s.currentToken() != Core.IF && s.currentToken() != Core.WHILE && s.currentToken() != Core.OUT && s.currentToken() != Core.IN && s.currentToken() != Core.INTEGER && s.currentToken() != Core.ARRAY ){
            System.out.println("Error: Expected ID, IF, WHILE, OUT, IN, INTEGER, or ARRAY Token");
            System.exit(1);
        }
        ss = new StmtSeq();
        ss.parse(s);

        if(s.currentToken() != Core.END && s.currentToken() != Core.ELSE){
            System.out.println("Error: Expected END or ELSE Token");
            System.exit(1);
        }
        if(s.currentToken() == Core.ELSE){
            flag = 1;
            s.nextToken();
            ss2 = new StmtSeq();
            ss2.parse(s);
        }

        s.nextToken();
    }

    void print(){
        System.out.println("if ");
        cd.print();
        System.out.print(" then \n");
        ss.print();
        if(flag == 1){
            System.out.println("else\n");
            ss2.print();
        }
        System.out.println("end");

    }
}