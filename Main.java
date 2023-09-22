class Main {
	public static void main(String[] args) {


		Scanner s = new Scanner(args[0]);

		if(scan.currentToken()==Core.PROCEDURE){
			p = new Procedure();
			p.parse(s);
		}else{
			System.out.println("Error: Expeceted PROCEDURE Token");
            System.exit(1);
		}
	}
}