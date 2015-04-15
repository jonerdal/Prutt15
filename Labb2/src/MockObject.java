import java.util.Random;
public class MockObject implements Boardgame {
	
	private int size;
	private String currentMessage = "No message yet";
	private String[][] status; // = new String[4][4]; //spelplan
	private String[] ord = new String[2];
	
	public MockObject(int n) {
		size = n;
		ord[0] = "Hej";
		ord[1] = "Tjockis"; 
		status = new String[size][size];
		
		for(int i=0; i<size; i++) {
			for (int j=0; j<size; j++) {
				status[i][j] = "";
			}
		}
		
	}

	@Override
	public boolean move(int i, int j) {
		currentMessage = "Pelle";
		Random rnd = new Random();
		int tal = rnd.nextInt(2);
		status[i][j] = ord[tal];
		return true;
	}

	@Override
	public String getStatus(int i, int j) {
		// TODO Auto-generated method stub
		return status[i][j];
	}

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return currentMessage;
	}

}
