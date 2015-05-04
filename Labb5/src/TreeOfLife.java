import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.swing.tree.*;
import javax.swing.*;


public class TreeOfLife extends TreeFrame {

	static Scanner sc;
	
	//stack med noder
	private static ArrayList<MyNode> myNodes = new ArrayList<MyNode>();
	//lista med noder
	private static ArrayList<MyNode> allNodes = new ArrayList<MyNode>();

	void initTree() {

		readFile("Life.txt");
		root = new DefaultMutableTreeNode(allNodes.get(0).getName());
		treeModel = new DefaultTreeModel(root);
		tree = new JTree(treeModel);
		buildTree();
	}
	
	public static void main(String[] args) {
		
		new TreeOfLife();
	}


	private void buildTree() {

		for (MyNode x : allNodes.get(0).getChildrenList()) {
			//går igenom listan med rotens alla barn
			buildTree(x, root);
		}
	}

	private void buildTree(MyNode x, DefaultMutableTreeNode parent) {
		//skapar nytt barn och berättar vem föräldern är
		DefaultMutableTreeNode child = new DefaultMutableTreeNode(x.getName());
		parent.add(child);
		
		//går igenom listan med barnets barn och bygger träd för dessa
		for(MyNode y : x.getChildrenList()) {
			buildTree(y,child);
		}
	}

	@Override
	void showDetails(TreePath path) {
		// metod för att visa detaljinformation
		if ( path == null ) {
			return;
		}
		
		//hittar rätt node och hämtar description för denna
		for (MyNode x : allNodes) {
			if (x.getName().equals(path.getLastPathComponent().toString())) {
				
				JOptionPane.showMessageDialog( this, x.getDescription());
			}
		}
	}



	private void readFile(String file) {
		
		// Kontrollerar så det inte blir exception när vi läser in filen
		try {
			sc = new Scanner(new File(file));

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//läser in filen
		while (sc.hasNextLine()) {
			
			String line = sc.nextLine();
			
			if (String.valueOf(line.charAt(1)).equals("/")) {
				//avslutande tagg, kontrollera att den hör till rätt starttagg
				String tempArr[] = line.split("/|>",3);
				String temp = tempArr[1];
				//kollar om det är samma
				if(temp.equals(myNodes.get(myNodes.size()-1).getLevel())) { 
					
					//kontrollerar så att vi inte försöker ta bort sista objektet, roten
					if (myNodes.size()>1) {
						//berättar för nodens farsa om dess barn
						myNodes.get(myNodes.size()-2).addChild(myNodes.get(myNodes.size()-1));
						//tar bort barnet, det har ju inga barn eftersom vi hittat en sluttagg
						myNodes.remove(myNodes.size()-1);
					}
				}
				
				else {
					//felaktig tagg, stänger av programmet
					System.out.println("Felaktig tagg, avslutar process");
					System.exit(getDefaultCloseOperation());
				}
			
			}
			else if (String.valueOf(line.charAt(1)).equals("?")) {
				//inforad om xml, hoppar över denna!
			}
			
			else {
				String tempArr[] = line.split("<| |\"",6);
				//skapar ny node
				MyNode node = new MyNode(tempArr[1],tempArr[3],tempArr[5]);
				//lägger till node i nodelista
				allNodes.add(node);
				//lägger till node i nodestack
				myNodes.add(node);
			}		
		}
	}
}