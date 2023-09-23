class Factor{
    Expr ex;
    String name;
    int con;
    int flag = 0;
    void parse(Scanner s){
        if(s.currentToken() != Core.ID && s.currentToken() != Core.CONST && s.currentToken() != Core.LPAREN){
            System.out.println("Error: Expected ID, CONST, or LPAREN Token. Got: " + s.currentToken());
            System.exit(1);
        }
        if(s.currentToken() == Core.ID){
            flag  = 0;
            name = s.getId();
            s.nextToken();
            if(s.currentToken() == Core.LBRACE){
                flag = 1;
                s.nextToken();
                if(s.currentToken() == Core.ID || s.currentToken() == Core.CONST|| s.currentToken() == Core.LPAREN){
                    ex = new Expr();
                    ex.parse(s);
                }else{
                    System.out.println("Error: Expected ID, CONST, or LPAREN Token. Got: " + s.currentToken());
                    System.exit(1);
                }
                if(s.currentToken() != Core.RBRACE){
                    System.out.println("Error: Expected RBRACE Token");
                    System.exit(1);
                }
                s.nextToken();
            }
        }else if(s.currentToken() == Core.CONST){
            flag = 2;
            con = s.getConst();
            s.nextToken();
        }else if(s.currentToken() == Core.LPAREN){
            flag = 3;
            s.nextToken();
            if(s.currentToken() == Core.ID || s.currentToken() == Core.CONST|| s.currentToken() == Core.LPAREN){
                ex = new Expr();
                ex.parse(s);
            }else{
                System.out.println("Error: Expected ID, CONST, or LPAREN Token. Got: " + s.currentToken());
                System.exit(1);
            }
            if(s.currentToken() != Core.RPAREN){
                System.out.println("Error: Expected RPAREN Token");
                System.exit(1);
            }
            s.nextToken();
        }
    }

    void print(){
        if(flag == 0){
            System.out.print(name);
        }else if(flag == 1){
            System.out.print(name + "[");
            ex.print();
            System.out.print("]");
        }else if(flag == 2){
            System.out.print(con);
        }else if(flag == 3){
            System.out.print("(");
            ex.print();
            System.out.print(")");
        }
    }
}