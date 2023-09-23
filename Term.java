class Term{
    Factor ft;
    Term tr;
    int flag = 0;
    void parse(Scanner s){
        if(s.currentToken() != Core.ID && s.currentToken() != Core.CONST && s.currentToken() != Core.LPAREN){
            System.out.println("Error: Expected ID, CONST, or LPAREN Token. Got: " + s.currentToken());
            System.exit(1);
        }
        ft = new Factor();
        ft.parse(s);

        if(s.currentToken() == Core.MULTIPLY){
            flag = 1;
            s.nextToken();
            if(s.currentToken() != Core.ID && s.currentToken() != Core.CONST && s.currentToken() != Core.LPAREN){
                System.out.println("Error: Expected ID, CONST, or LPAREN Token. Got: " + s.currentToken());
                System.exit(1);
            }
            tr = new Term();
            tr.parse(s);
        }else if( s.currentToken() == Core.DIVIDE){
            flag  = 2;
            s.nextToken();
            if(s.currentToken() != Core.ID && s.currentToken() != Core.CONST && s.currentToken() != Core.LPAREN){
                System.out.println("Error: Expected ID, CONST, or LPAREN Token. Got: " + s.currentToken());
                System.exit(1);
            }
            tr = new Term();
            tr.parse(s);
        }

    }

    void print(){
        ft.print();
        if(flag == 1){
            System.out.println("*");
            tr.print();
        }else if(flag == 2){
            System.out.println("/");
            tr.print();
        }
    }
    
}