import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.*;

import com.apple.eawt.ApplicationListener;

/**
 * AppointmentBookGUI
 */
public class AppointmentBookGUI extends JFrame implements ApplicationListener {

    private AppointmentBook appointmentBook = new AppointmentBook();
    private final static int INFO_SIZE = 30;

    public AppointmentBookGUI(AppointmentBook appointmentBook)
	{
        super("AppointmentBookGUI");
        appointmentBook = this.appointmentBook;
        setSize(600,300);
        setLocation(200,200);
        setlabels();
        setbuttons();
        settextfield();
        setbutton2();
        setmenubar();
        ContainerSetup();
        show();
    }

    public static void main(String[] args) {
        
        AppointmentBookGUI app = new AppointmentBookGUI(new AppointmentBook());

        app.addWindowListener( new WindowAdapter()
		{
			public void windowClosing(WindowEvent e) { System.exit(0); } 
		});
    }
}