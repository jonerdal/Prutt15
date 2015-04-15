
public interface Boardgame {
	public boolean move(int i, int j); //returns true if OK move, otherwise false
	public String getStatus(int i, int j);
	public String getMessage();
}