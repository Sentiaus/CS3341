class Cond{
    Cmpr cr;
    Cond cd;
    int flag = 0;

    void parse(Scanner s){
        if(s.currentToken() != Core.ID && s.currentToken() != Core.CONST && s.currentToken() != Core.LPAREN && s.currentToken()!= Core.NOT){
            System.out.println("Error: Expected ID, CONST, NOT, or LPAREN Token. Got: " + s.currentToken());
            System.exit(1);
        }
        if(s.currentToken() == Core.ID || s.currentToken() == Core.CONST || s.currentToken() == Core.LPAREN){
            flag = 0;
            cr = new Cmpr();
            cr.parse(s);
            if(s.currentToken() == Core.OR){
                flag = 2;
                s.nextToken();
                cd = new Cond();
                cd.parse(s);
            }else if(s.currentToken() == Core.AND){
                flag = 3;
                s.nextToken();
                cd = new Cond();
                cd.parse(s);
            }
        }else if(s.currentToken() == Core.NOT){
            flag = 1;
            s.nextToken();
            cd = new Cond();
            cd.parse(s);
        }
    }

    void print(){
        if(flag == 0){
            cr.print();
        }else if(flag == 1){    
            System.out.print("not ");
            cd.print();
        }else if(flag == 2){
            cr.print();
            System.out.print(" or ");
            cd.print();
        }else if(flag == 3){
            cr.print();
            System.out.print(" and ");
            cd.print();
        }
    }  
}