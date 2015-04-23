import java.util.ArrayList;
import java.util.List;




public class Composite extends Component {
	
	int weight;
	String name;
	List<Component> children = new ArrayList<Component>();
	
	public Composite(String n, int w) {
		//konstruktor
		weight = w;
		name = n;		
		
	}
	
	public int getWeight() {
		int totalWeight = weight;
		for (int i=0; i < children.size(); i++) {
			totalWeight += children.get(i).getWeight();
		}
		
		return totalWeight;
	}
	
	public String toString() {
		String all = name + "(";

		for (Component comp : children) {
			all += " " + comp.toString();
		}
		all += ")";
		
		return all;
	} 

	public void addChild(Component c) {
		//add för att ha koll på barn
		children.add(c);
	}
	public void removeChild(Component c) {
		if (children.contains(c)) {
			//barn finns i composite och kan därför tas bort
			System.out.println("Tar bort " + c.toString());
			children.remove(c);
		}
		else {
			System.out.println("Kunde inte ta bort " + c.toString()
					+ " från " + name);
		}
	}
	
}
