import java.util.Random;

public class FifteenModel implements Boardgame {
	
	private String currentMessage = "No message yet";
	private String[][] status; // = new String[4][4]; //spelplan
	private int iemp, jemp; //index to empty field
	
	public FifteenModel(int size) {
		//constructor
		status = new String[size][size];
		int count = 0;
		for (int i=0; i<size; i++) {
			for (int j=0; j<size; j++) {
				if (Integer.toString(count).equals("0")) {
					status[i][j] = " ";
					iemp = i;
					jemp = j;
				}
				else {
					status[i][j] = Integer.toString(count);
				}
				count++;
			}
		}
		for (int i=0; i<200 ;i++) {
			//kör slumpad move, ju fler gånger, desto mer scramblat!
			Random random = new Random();
			int slump1 = random.nextInt(size);
			int slump2 = random.nextInt(size);
			move(slump1,slump2);
			
		}
		
	}

	@Override
	public boolean move(int i, int j) {
		
		//kolla om flytten är OK
		if (i != iemp || j != jemp) {
			//inte valt tom
			if ((i == iemp-1 || i == iemp+1) && j == jemp) {
				//rätt kolumn
				swap(i,j);
			}
			else if((j == jemp-1 || j == jemp+1) && i ==iemp) {
				//rätt rad
				swap(i,j);
			}
			else {
				//inte angränsande ruta, ergo ej OK drag
				currentMessage = "Ej tillåtet drag";
				return false;
			}
			return true;
		}
		currentMessage = "Tomma rutan";
		return false;
	}

	@Override
	public String getStatus(int i, int j) {
		// ge status för i,j.
		return status[i][j];
	}

	@Override
	public String getMessage() {
		// Ger meddelande om draget gick bra eller ej
		return currentMessage;
	}
	
	private void swap(int i, int j) {
		//genomför flytten, dvs flytta nummer frå i,j till iemp, jemp och tillbaka
		//String value = status[i][j];
		status[iemp][jemp] = status[i][j];
		status[i][j] = " ";
		
		//ändra värde på iemp och jemp till den nya tomma rutan
		iemp = i;
		jemp = j;
		
		currentMessage = "OK drag";
		
	}
	
	

}
