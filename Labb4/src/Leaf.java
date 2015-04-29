
public class Leaf extends Component {

	int weight;
	String name;
	
	public Leaf(String n, int w) {
		
		weight = w;
		name = n;
				
	}
	
	public int getWeight() {
		return weight;
	}
	public String toString() {
		return name;
	}

	
}
