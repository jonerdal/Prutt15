package human;

public abstract class Human {
	
	//protected för att alla i paketet ska kunna komma åt
	protected String name;
	protected String personnr;
	
	public abstract String toString();
	
	public static Human create(String name, String pnr) {
		Human h;
		
		//kolla om man eller kvinna och skapar instans av rätt typ
		if (Integer.valueOf(pnr.charAt(9)) % 2 == 1) {
			h = new Man(name, pnr);
		}
		else {
			h = new Woman(name,pnr);
		}		
		return h;
	}

}
