import java.util.ArrayList;


public class MyNode {
	
	private	 String level;
	private String name;
	private String description;
	private ArrayList<MyNode> children = new ArrayList<MyNode>();

	
	MyNode(String lvl, String n, String descr) {
		level = lvl;
		name = n;
		description = descr;
	}
	
	public String toString() {		
		return name;
	}
	public String getLevel() {
		return level;
	}
	public void addChild(MyNode child) {
		children.add(child);
	}
	
	public String getAllChildren() {
		String str = "";
		for ( MyNode x : children) {
			str += x.toString();
		}
		return str;
		
	}
	
	public ArrayList<MyNode> getChildrenList() {
		return children;
	}
	
	public String getDescription() {
		//det som skrivs ut vid visa detalj
		return level + ": " + name + " " + description;
	}


}
