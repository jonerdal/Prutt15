import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.swing.tree.*;
import javax.swing.*;


public class TreeOfLife extends TreeFrame {
	
	static Scanner sc;
	//lista för att hålla koll på taggar
	public static ArrayList<String> arr0= new ArrayList<String>();
	//lista för att hålla koll på namn
	public static ArrayList<String> arr1= new ArrayList<String>();
	//lista för att hålla koll på beskrivningar
	public static ArrayList<String> arr2= new ArrayList<String>();
	public static ArrayList<MyNode> nodes = new ArrayList<MyNode>();
	
	void initTree() {
	
		readFile("TinyLife.txt");		
		root = new DefaultMutableTreeNode(arr1.get(0));
		treeModel = new DefaultTreeModel(root);
		tree = new JTree(treeModel);
		buildTree();
	}

	private void buildTree() {
		// TODO Auto-generated method stub
		
	}


//	@Override
//	void showDetails(TreePath path) {
//		// TODO Auto-generated method stub
//		if ( path == null ) {
//		    return;
//		}
//		super.showDetails(path);
//	}

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
			
			//läser in filen
			while (sc.hasNextLine()) {
				
				String line = sc.nextLine();
				
				if (String.valueOf(line.charAt(1)).equals("/")) {
					//avslutande tagg, kontrollera att den hör till rätt starttagg
					String tempArr[] = line.split("/|>",3);
					String temp = tempArr[1];
					if(temp.equals(arr0.get(arr0.size()-1))) {
						System.out.println("OK tagg, kör på mannen!");
						arr0.remove(arr0.size()-1);
					}
					else {
						System.out.println("Felaktig tagg");
					}
					
				}
				else {
					String tempArr[] = line.split("<| |\"",6);
					arr0.add(tempArr[1]);
					arr1.add(tempArr[3]);
					arr2.add(tempArr[5]);

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
