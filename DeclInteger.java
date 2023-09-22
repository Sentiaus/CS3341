class DeclInteger{
    String name;
    void parse(Scanner s){
        s.nextToken();
        if(s.currentToken() != Core.ID){
            System.out.println("Error: Expeceted ID Token");
            System.exit(1);
        }
        name = s.getId();
        s.nextToken();
        if(s.currentToken()!= Core.SEMICOLON){
            System.out.println("Error: Expeceted SEMICOLON Token");
            System.exit(1);
        }
        s.nextToken();
    }

    void print(){
        System.out.println("integer " + name + " ;");
    }
}