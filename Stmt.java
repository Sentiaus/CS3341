class Stmt{
    Assign ass;
    If iff;
    Loop loo;
    Out ou;
    In inn;
    Decl d;
    
    void parse(Scanner s){
        if(s.currentToken() == Core.ID){
            ass = new Assign();
            ass.parse(s);
        }else if(s.currentToken()==Core.IF){
            iff = new If();
            iff.parse(s);
        }else if(s.currentToken()==Core.WHILE){
            loo = new Loop();
            loo.parse(s);
        }else if(s.currentToken()==Core.OUT){
            ou = new Out();
            ou.parse(s);
        }else if(s.currentToken()==Core.IN){
            inn = new In();
            inn.parse(s);
        }else if(s.currentToken() == Core.INTEGER || s.currentToken() == Core.ARRAY){
            d = new Decl();
            d.parse(s);
        }else{
            System.out.println("Error: Expected \"In\", \"Out\", \"ID\", \"IF\", \"While\", \"Integer\", or \"Array\", Token. Received: " + s.currentToken() + " token.");
            System.exit(1);
        }
    }
    
    void print(){
        if(ass != null){
            ass.print();
        }else if(iff != null){
            iff.print();
        }else if(loo != null){
            loo.print();
        }else if(ou != null){
            ou.print();
        }else if(inn != null){
            inn.print();
        }else if(d != null){
            d.print();
        }
    }
}