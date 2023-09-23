class Loop{
    Cond cd;
    StmtSeq ss;

    void parse(Scanner s){
        if(s.currentToken()!= Core.WHILE){
            System.out.println("ERROR: Expected WHILE Token. Got: "+ s.currentToken());
            System.exit(1);
        }
        s.nextToken();
        if(s.currentToken() != Core.ID && s.currentToken() != Core.CONST && s.currentToken() != Core.LPAREN && s.currentToken()!= Core.NOT){
            System.out.println("Error: Expected ID, CONST, NOT, or LPAREN Token. Got: " + s.currentToken());
            System.exit(1);
        }
        cd = new Cond();
        cd.parse(s);
        if(s.currentToken() != Core.DO){
            System.out.println("ERROR: Expected DO Token. Got: "+ s.currentToken());
            System.exit(1);
        }
        s.nextToken();

        if(s.currentToken() != Core.ID && s.currentToken() != Core.IF && s.currentToken() != Core.WHILE && s.currentToken() != Core.OUT && s.currentToken() != Core.IN && s.currentToken() != Core.INTEGER && s.currentToken() != Core.ARRAY ){
            System.out.println("Error: Expected ID, IF, WHILE, OUT, IN, INTEGER, or ARRAY Token");
            System.exit(1);
        }
        ss = new StmtSeq();
        ss.parse(s);

        if(s.currentToken() != Core.END){
            System.out.println("ERROR: Expected END Token. Got: "+ s.currentToken());
            System.exit(1);
        }
        s.nextToken();
    }

    void print(){
        System.out.println("while ");
        cd.print();
        System.out.print(" do ");
        ss.print();
        System.out.print(" end");
    }
}