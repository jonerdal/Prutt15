
public abstract class Component {
	//abstrakt klass för komponent
	
	public int weight;
	public String name;
	
	abstract public int getWeight();
	
	abstract public String toString();
	
	public void addChild(Component c) {
		
	}

	public void removeChild(Component c) {
		
	}
	
	

}
