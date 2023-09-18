class Procedure{
    String name;
    DeclSeq ds;
    StmtSeq ss;

    void parse(Scanner s){
        if (s.currentToken() != Core.Procedure){
            System.out.println("Error: Expected Procedure Token");
            System.exit(1);
        }
        s.nextToken();
    }
}