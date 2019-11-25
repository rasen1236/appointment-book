import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.AbstractButton;

import java.awt.*;
import java.awt.event.*;
import com.apple.eawt.ApplicationListener;

/**
 * AppointmentBookGUI
 */
public class AppointmentBookGUI extends JFrame implements ActionListener {

    private AppointmentBook appointmentBook = new AppointmentBook();

    private String[] buttonNames = { "New Appointment", "Update Appointment", "Remove", "Close"};
    private String[] columnNames = { "Name", "Contact", "Stylist"}; 
    private String[][] data = { 
        { "Kundan Kumar Jha", "4031", "CSE" }, 
        { "Anand Jha", "6014", "IT" } 
    }; 

    private JTable appointmentsTable;
    private JButton[] buttons;

    public AppointmentBookGUI(AppointmentBook appointmentBook)
	{
        super("AppointmentBook");
        appointmentBook = this.appointmentBook;
        setSize(600,300);
        setLocation(200,200);
        setTable();
        setButtons();
        ContainerSetup();
        setVisible(true);
    }

    private void setTable(){
        appointmentsTable = new JTable(data, columnNames);
    }

    private void setButtons() {
        buttons = new JButton[buttonNames.length];

        for (int i = 0; i < buttonNames.length; i++) {
            buttons[i] = new JButton( buttonNames[i]);
            buttons[i].addActionListener(this);
        }
    }

    private void ContainerSetup()
	{
        Container c = getContentPane();

        //South Layout
        JPanel spanel = new JPanel();
        for (int i=0; i < buttonNames.length; i++) spanel.add(buttons[i]);
        c.add(spanel,BorderLayout.SOUTH);

        c.add(appointmentsTable, BorderLayout.NORTH);
    }

    public void actionPerformed(ActionEvent e) {

        Object source = e.getSource();

        if (source == buttons[0]) {
            AppointmentForm form = new AppointmentForm();
        }
        
    }

    public static void main(String[] args) {
        
        AppointmentBookGUI app = new AppointmentBookGUI(new AppointmentBook());

        app.addWindowListener( new WindowAdapter()
		{
			public void windowClosing(WindowEvent e) { System.exit(0); } 
		});
    }
}