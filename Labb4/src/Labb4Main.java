

public class Labb4Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Composite suitcase = new Composite("Suitcase",2000);
		Composite bag = new Composite("Bag",500);
		suitcase.addChild(bag);
		Leaf toothbrush = new Leaf("Toothbrush",200);
		Leaf toothpaste = new Leaf("Toothpaste",300);
		bag.addChild(toothbrush);
		bag.addChild(toothpaste);
		
		Composite smallBag = new Composite("Small bag",10);
		bag.addChild(smallBag);
		
		Leaf button = new Leaf("Spare buttons",20);
		smallBag.addChild(button);
		
		Leaf jeans = new Leaf("Jeans",800);
		suitcase.addChild(jeans);
		
		Composite folder = new Composite("Folder",10);		
		Leaf p1 = new Leaf("Important paper nr 1", 5);
		Leaf p2 = new Leaf("Important paper nr 2", 5);
		Leaf p3 = new Leaf("Not so important paper", 5);
		folder.addChild(p1);
		folder.addChild(p2);
		folder.addChild(p3);
		suitcase.addChild(folder);
		
		System.out.println(suitcase.toString());
		System.out.println("Vikt: " + suitcase.getWeight());
		

	

	}


}
