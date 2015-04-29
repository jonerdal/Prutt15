import javax.swing.tree.*;
import javax.swing.*;


public class LivetsTrad extends TreeFrame {

	void initTree() {
		//rot - Liv
		root = new DefaultMutableTreeNode("Liv");
		
		//skapa trädmodell
		treeModel = new DefaultTreeModel(root);		
		
		//nod child - växter
		DefaultMutableTreeNode child = new DefaultMutableTreeNode("Växter");
		
		//lägg till växter till liv
		root.add(child);
		
		//samma för svampar och djur
		DefaultMutableTreeNode child2 = new DefaultMutableTreeNode("Djur");
		DefaultMutableTreeNode child3 = new DefaultMutableTreeNode("Svampar");

		root.add(child2);
		root.add(child3);

		//skapa träd
		tree = new JTree(treeModel);
		
	}
	
	public static void main (String[] args) {
		new LivetsTrad();
		
	}
	
}
