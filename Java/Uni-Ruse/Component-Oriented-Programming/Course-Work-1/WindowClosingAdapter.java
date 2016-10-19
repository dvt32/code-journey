import java.awt.event.*;

public class WindowClosingAdapter extends WindowAdapter {
	private boolean exitSystem;
	
	// Constructors
	public WindowClosingAdapter(boolean exitSystem) {
		this.exitSystem = exitSystem;
	}
	public WindowClosingAdapter() {
		this(false);
	}
	
	// Close window method
	public void windowClosing(WindowEvent event) {
		event.getWindow().setVisible(false);
		event.getWindow().dispose();
		if (exitSystem == true) {
			System.exit(0);
		}
	}
}
