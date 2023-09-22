class In{
    String name;

    void parse(Scanner s){
        //Checks if Current Token is IN Token, NEXT TOKEN
        if(s.currentToken()!=Core.IN){
            System.out.println("ERROR: Expected IN Token");
            System.exit(1);
        }
        s.nextToken();
        //Checks if Current Token is LPARANTHESES, NEXT TOKEN
        if(s.currentToken()!=Core.LPARANTHESES){
            System.out.println("ERROR: Expected LPARANTHESES Token");
            System.exit(1);
        }
        s.nextToken();
        //Checks if token is and ID, NEXT TOKEN
        if(s.currentToken() != Core.ID){
            System.out.println("Error: Expected ID Token");
            System.exit(1);
        }
        name = s.getId();
        s.nextToken();

        //Checks if token is RPARANTHESES, NEXT TOKEN
        if(s.currentToken()!=Core.RPARANTHESES){
            System.out.println("ERROR: Expected RPARANTHESES Token");
            System.exit(1);
        }
        s.nextToken();

        //Checks if Token is Semicolon, NEXT TOKEN
        if(s.currentToken()!= Core.SEMICOLON){
            System.out.println("Error: Expeceted SEMICOLON Token");
            System.exit(1);
        }
        s.nextToken();
    }

    void print(){
        System.out.println("in( "+ name + " );");
    }

}