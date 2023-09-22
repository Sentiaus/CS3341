class DeclSeq{
    Decl d;
    DeclSeq ds;

    void parse(Scanner s){
        d = new Decl();
        d.parse(s);

        if(s.currentToken() == Core.INTEGER || s.currentToken() == Core.ARRAY){
            ds = new DeclSeq();
            ds.parse(s);
        }

    }

    void print(){
        d.print();
        if(ds != null){
            ds.print();
        }
    }

}