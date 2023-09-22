class Decl{
    DeclInteger di;
    DeclArray da;
    void parse(Scanner s){
        if(s.currentToken()==Core.INTEGER){
            di = new DeclInteger();
            di.parse(s);
        }else if(s.currentToken()==Core.ARRAY){
            da = new DeclArray();
            da.parse(s);
        }else{
            System.out.println("Error: Expeceted INTEGER or ARRAY Token");
        }
    }

    void print(){
        if(di != null){
            di.print();
        }else if(da != null){
            da.print();
        }
    }
}