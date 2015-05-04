import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.swing.tree.*;
import javax.swing.*;


public class TreeOfLife extends TreeFrame {
	
	static Scanner sc;
	//lista/stack för att hålla koll på starttaggar
	private static ArrayList<String> arr0= new ArrayList<String>();
	//lista med noder
	private static ArrayList<MyNode> myNodes = new ArrayList<MyNode>();
	private static ArrayList<MyNode> allNodes = new ArrayList<MyNode>();
	public static ArrayList<String> lvl = new ArrayList<String>();
	private static MyNode roten;
	
	void initTree() {
	
		readFile("Life.txt");
		checkNodes();
		//populateLevel();
		root = new DefaultMutableTreeNode(roten.toString());
		treeModel = new DefaultTreeModel(root);
		tree = new JTree(treeModel);
		buildTree();
	}

	private void populateLevel() {
		//stoppar in alla olika nivåer i en lista, utan dubletter
		lvl.add(myNodes.get(0).getLevel());
		for (int i=1;i<myNodes.size();i++) {
			if(!lvl.contains(myNodes.get(i).getLevel())) {
				lvl.add(myNodes.get(i).getLevel());
			}			
		}
		//för att skriva ut så jag ser hur listan ser ut.
		for (int j=0;j<lvl.size();j++) {
			System.out.println(lvl.get(j));
		}
	}

	private void checkNodes() {
		// bara för att kontrollera saker hela tiden, helt onödig, trololo
		for(int i = 0; i<myNodes.size();i++) {
			System.out.println(myNodes.get(i));
			System.out.println(roten.getAllChildren());			
		}		
	}

	private void buildTree() {
		
		for (MyNode x : roten.getChildrenList()) {
			//går igenom listan med rotens alla barn
			buildTree(x, root);
		}
	}

private void buildTree(MyNode x, DefaultMutableTreeNode parent) {
		// TODO Auto-generated method stub
	DefaultMutableTreeNode child = new DefaultMutableTreeNode(x.toString());
	parent.add(child);
	for(MyNode y : x.getChildrenList()) {
		buildTree(y,child);
	}
		
	}

@Override
void showDetails(TreePath path) {
	// TODO Auto-generated method stub
	if ( path == null ) {
		return;
	}
	//super.showDetails(path);	
	for (MyNode x : allNodes) {
		if (x.toString().equals(path.getLastPathComponent().toString())) {
			JOptionPane.showMessageDialog( this, x.getDescription());
		}
	}
}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new TreeOfLife();

	}
	
	private void readFile(String file) {
		// läser in fil och populerar de tre listorna arr0-arr2
		try {
			sc = new Scanner(new File(file));

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		//count för att kolla avsluttaggarna

		//läser in filen
		while (sc.hasNextLine()) {

			String line = sc.nextLine();

			if (String.valueOf(line.charAt(1)).equals("/")) {
				//avslutande tagg, kontrollera att den hör till rätt starttagg
				String tempArr[] = line.split("/|>",3);
				String temp = tempArr[1];
				if(temp.equals(arr0.get(arr0.size()-1))) {
					//System.out.println("OK tagg, kör på mannen!");
					arr0.remove(arr0.size()-1);
					if (myNodes.size()>1) {
						myNodes.get(myNodes.size()-2).addChild(myNodes.get(myNodes.size()-1));
						myNodes.remove(myNodes.size()-1);
					}
					
					
				}
				else {
					System.out.println("Felaktig tagg");
					System.exit(getDefaultCloseOperation());
				}

			}
			else if (String.valueOf(line.charAt(1)).equals("?")) {
				//inforad om xml, hoppa över denna!
			}
			else {
				String tempArr[] = line.split("<| |\"",6);
				//för att hålla koll på sluttaggar
				MyNode node = new MyNode(tempArr[1],tempArr[3],tempArr[5]);
				allNodes.add(node);
				arr0.add(tempArr[1]);
				//populerar listan myNodes
				myNodes.add(node);
				if(node.getLevel().equals("Biosfar")) {
					roten = node;
				}
								
			}		
		}

	}
}


/*
 * Gammal kod
 */






//if (String.valueOf(line.charAt(1)).equals("B")) {
////raden startar med <B
//
//
//String arr[] = line.split("\"", 2);
//String del2 = arr[1];
//String arr2[] = del2.split("\"", 2);
//
//
//root = new DefaultMutableTreeNode(arr2[0]);
//System.out.println(arr2[0]);
//System.out.println(arr2[1]);
//
//treeModel = new DefaultTreeModel(root);		
//
//tree = new JTree(treeModel);
//
//String arr3[] = arr2[1].split(" ",2);
//System.out.println(arr3[1]);
//
//}
