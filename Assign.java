class Assign{
    String name;
    String name2;
    Expr ex;
    Expr ex2;
    int flag = 0;
    void parse(Scanner s){
        //Checks if current Token is an ID
        if(s.currentToken() != Core.ID){
            System.out.println("Error: Expeceted ID Token");
            System.exit(1);
        }
        name = s.getId();
        //Next Token, Checks if Token is an Assign, or LBRACE
        s.nextToken();
        if(s.currentToken() != Core.ASSIGN || s.currentToken() != Core.LBRACE){
            System.out.println("Error: Expeceted ASSIGN or LBRACE Token");
            System.exit(1);
        }
        if(s.currentToken() == Core.ASSIGN){
            //IF ASSIGN,Next token, Checks if token is the beginning of an expression, a NEW Token, or an ARRAY Token
            s.nextToken();
            if(s.currentToken() != Core.ID || s.currentToken() != Core.CONST || s.currentToken() != Core.LPAREN || s.currentToken() != Core.NEW || s.currentToken() != Core.ARRAY){
                System.out.println("Error: Expected ID, CONST, LPAREN, NEW, or ARRAY Token");
                System.exit(1);
            }
            if(s.currentToken() == Core.ID || s.currentToken() == Core.CONST|| s.currentToken() == Core.LPAREN){
               flag = 0;
               ex = new Expr();
               ex.parse(s);
            }else if(s.currentToken() == Core.NEW){
                //if Token equals NEW, next Token, sets flag to 2, If token is integer, NEXT TOKEN
                flag = 2;
                s.nextToken();
                if(s.currentToken() != Core.INTEGER){
                    System.out.println("Error: Expected INTEGER Token");
                    System.exit(1);
                }
                s.nextToken();

                //Checks if token is an LBRACE, if it is, NEXT TOKEN
                if(s.currentToken() != Core.LBRACE){
                    System.out.println("Error: Expeceted LBRACE Token");
                    System.exit(1);
                }
                s.nextToken();

                //Checks if token is beginning of an expression, if it is, parses the expression
                if(s.currentToken() != Core.ID || s.currentToken() != Core.CONST || s.currentToken() != Core.LPAREN){
                    System.out.println("Error: Expected ID, CONST, or LPAREN Token");
                    System.exit(1);
                }
                ex = new Expr();
                ex.parse(s);

                //Checks if the token after the expression is an RBRACE
                if(s.currentToken() != Core.RBRACE){
                    System.out.println("Error: Expeceted RBRACE Token");
                    System.exit(1);
                }
            }else if(s.currentToken() == Core.ARRAY){
                //If token equals Array, Next Token, sets flag to 3
                flag = 3;
                s.nextToken();
                //If Token is ID, NEXT TOKEN
                if(s.currentToken() != Core.ID){
                    System.out.println("Error: Expeceted ID Token");
                    System.exit(1);
                }
                name2 = s.getId();
                s.nextToken();
            }
        }else if(s.currentToken() == Core.LBRACE){
            //IF LBRACE,Next token, Checks if token is the beginning of an expression, sets flag to 1
            flag = 1
            s.nextToken();
            if(s.currentToken() == Core.ID || s.currentToken() == Core.CONST|| s.currentToken() == Core.LPAREN){
               ex = new Expr();
               ex.parse(s);
            }else{
                System.out.println("Error: Expected ID, CONST, or LPAREN Token");
                System.exit(1);
            }
            //Checks if the token after the expression is an RBRACE
            if(s.currentToken() != Core.RBRACE){
                System.out.println("Error: Expeceted RBRACE Token");
                System.exit(1);
            }
            //Next Token, Checks if the token is an assign token
            s.nextToken();
            if(s.currentToken() != Core.ASSIGN){
                System.out.println("Error: Expeceted Assign Token");
                System.exit(1);
            }
            //Next Token, Checks if the token is the beginning of another expression
            s.nextToken();
            if(s.currentToken() == Core.ID || s.currentToken() == Core.CONST|| s.currentToken() == Core.LPAREN){
                ex2 = new Expr();
                ex2.parse(s); 
            }else{
                System.out.println("Error: Expected ID, CONST, or LPAREN Token");
                System.exit(1);
            }
        }
        //ALL ASSIGN OPERATIONS END IN SEMICOLON
        //Next Token, Checks if the token is a semicolon token
        s.nextToken();
        if(s.currentToken()!= Core.SEMICOLON){
            System.out.println("Error: Expeceted SEMICOLON Token");
            System.exit(1);
        }
        //Next Token
        s.nextToken();
    }

    void print(){
        System.out.println(name);
        if(flag == 0 || flag == 2 || flag == 3){
            System.out.print(" :=");
            if(flag == 0){
                ex.print();
            }else if(flag == 2){
                System.out.print(" new integer [");
                ex.print();
                System.out.print("]");
            }else if(flag == 3){
                System.out.print(" array " + name2);
            }
            
        }else if(flag == 1){
            System.out.print("[");
            ex.print();
            System.out.print("] := ");
            ex2.print();
        }
        System.out.println(";");
    }
}