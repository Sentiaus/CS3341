class StmtSeq{
    Stmt st;
    StmtSeq ss;

    void parse(Scanner s){
        st = new Stmt();
        st.parse(s);
        
        if(s.currentToken() == Core.ASSIGN || s.currentToken() == Core.IF || s.currentToken() == Core.WHILE || s.currentToken() == Core.OUT || s.currentToken() == Core.IN || s.currentToken() == Core.INTEGER || s.currentToken() == Core.ARRAY ){
            ss = new StmtSeq();
            ss.parse(s);
        }
    }

    
}