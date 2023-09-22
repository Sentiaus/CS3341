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
        if(s.currentToken() != Core.ID || s.currentToken() != Core.CONST|| s.currentToken() != Core.LPAREN){
            
        }

        
    }

    void print(){

    }
}