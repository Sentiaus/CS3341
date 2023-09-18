class Procedure{
    String name;
    DeclSeq ds;
    StmtSeq ss;

    void parse(Scanner s){
        if(s.currentToken() != Core.Procedure){
            System.out.println("Error: Expected Procedure Token");
            System.exit(1);
        }
        s.nextToken();

        if(s.currentToken() != Core.ID){
            System.out.println("Error: Expecrted ID Token");
            System.exit(1);
        }
        name = s.getId();
        s.nextToken();

        if(s.currentToken() != Core.IS){
            System.out.println("Error: Expected IS Token");
            System.exit(1);
        }
        s.nextToken();

        if(s.currentToken() != Core.BEGIN){
            ds = new DeclSeq();
            ds.parse(s);
        }

        if(s.currentToken() != Core.BEGIN){
            System.out.println("Error: Expected BEGIN Token");
            System.exit(1);
        }
        s.nextToken();

        ss = new StmtSeq();
        ss.parse(s);
        if(s.currentToken() != Core.END){
            System.out.println("Error: Expected END Token");
            System.exit(1);
        }
        s.nextToken();

        if(s.currentToken() != Core.EOS){
            System.out.println("Error: Expected EOS Token");
            System.exit(1);
        }
        s.nextToken();
    }

    void print(){
        System.out.println("procedure " + name + " is ");
        if(ds != null){
            ds.print();
        }
        System.out.println("begin");
        ss.print();
        System.out.println("end");
    }
}