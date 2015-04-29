package human;

public class Man extends Human {
	
	protected Man(String n, String pnr) {
		//konstruktor
		name = n;
		personnr = pnr;
		
	}
	
	public String toString() {
		String str = "Jag heter " + name + " och jag är man";
		return str;
	}

}
