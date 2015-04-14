import java.applet.*;
import java.awt.*;

public class Labb1_5 extends Applet {
	
	public void init() {
		add (new Label("En liten applet för prutten"));
		add (new MyButton(Color.blue,Color.pink,"Hej","Då"));
		add (new MyButton(Color.blue,Color.pink,"Hej","Då"));
	}

}
