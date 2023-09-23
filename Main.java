class Main {
	public static void main(String[] args) {
	Scanner s = new Scanner(args[0]);
	Procedure p;

		if(s.currentToken()==Core.PROCEDURE){
			p = new Procedure();
			p.parse(s);
			p.print();
		}else{
			System.out.println("Error: Expeceted PROCEDURE Token");
            System.exit(1);
		}
	}
}