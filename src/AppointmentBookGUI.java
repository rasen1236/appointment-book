import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * AppointmentBookGUI
 */
public class AppointmentBookGUI extends JFrame implements ActionListener {

    private AppointmentBook appointmentBook = new AppointmentBook();

    private String[] buttonNames = { "New Appointment", "Remove Appointment", "Refresh", "Close"};

    private JTable appointmentsTable;
    private AppointmentTableModel appointmentsTableModel;
    private JScrollPane appointmentsTablePane;
    private JButton[] buttons;

    public AppointmentBookGUI(AppointmentBook appointmentBook)
	{
        super("Hair So Long Appointment System");
        appointmentBook = this.appointmentBook;
        appointmentBook.loadAppointmentsFromFile("appointments.txt");
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(600,300);
        setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        setTable();
        setButtons();
        ContainerSetup();
        setVisible(true);
    }

    private void setTable(){
        appointmentsTablePane = new JScrollPane();
        appointmentsTable = new JTable();
        appointmentsTableModel = new AppointmentTableModel(appointmentBook.getAppointments());
        appointmentsTable.setModel(appointmentsTableModel);
        appointmentsTablePane.setViewportView(appointmentsTable);
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

        c.add(appointmentsTablePane, BorderLayout.NORTH);
    }

    public void actionPerformed(ActionEvent e) {

        Object source = e.getSource();

        if (source == buttons[0]) {
            // New Appointment
            AppointmentForm form = new AppointmentForm(appointmentBook);
        }
        else if (source == buttons[2]) {
            // Refresh Table
            appointmentsTableModel = new AppointmentTableModel(appointmentBook.getAppointments());
            appointmentsTable.setModel(appointmentsTableModel);
            appointmentsTable.invalidate();
        }
        else if (source == buttons[3]){
            // Exit
            appointmentBook.writeAppointmentsToFile("appointments.txt");
            System.exit(1);
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