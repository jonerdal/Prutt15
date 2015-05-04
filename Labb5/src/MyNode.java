import java.util.ArrayList;


public class MyNode {
	
	private	 String level;
	private String name;
	private String description;
	private ArrayList<MyNode> children = new ArrayList<MyNode>();
	
	public MyNode(String lvl, String n, String descr) {
		level = lvl;
		name = n;
		description = descr;
	}
	
	public String getName() {		
		return name;
	}

	public void addChild(MyNode child) {
		children.add(child);
	}
	
	public ArrayList<MyNode> getChildrenList() {
		return children;
	}
	
	public String getDescription() {
		//det som skrivs ut vid visa detalj
		return level + ": " + name + " " + description;
	}

	public String getLevel() {
		return level;
	}
}
