package human;

public class Woman extends Human {
	
	protected Woman(String n, String pnr) {
		//konstruktor
		name = n;
		personnr = pnr;
	}
	
	public String toString() {
		String str = "Jag heter " + name + " och jag är kvinna";
		return str;
	}

}
