import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * AppointmentBookGUI
 */
public class AppointmentBookGUI extends JFrame implements ActionListener {

    private AppointmentBook appointmentBook = new AppointmentBook();

    private String[] buttonNames = { "New Appointment", "Remove Appointment", "Print Receipt", "Refresh", "Close"};

    private JTable appointmentsTable;
    private AppointmentTableModel appointmentsTableModel;
    private JScrollPane appointmentsTablePane;
    private JButton[] buttons;

    public AppointmentBookGUI(AppointmentBook appointmentBook)
	{
        super("Hair So Long Appointment System");
        appointmentBook = this.appointmentBook;
        appointmentBook.loadAppointmentsFromFile();
        appointmentBook.loadSalonServices();
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(700,300);
        setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        setTable();
        setButtons();
        ContainerSetup();
        setVisible(true);
    }

    private void setTable(){
        appointmentsTable = new JTable();
        appointmentsTablePane = new JScrollPane(appointmentsTable);
        appointmentsTableModel = new AppointmentTableModel(appointmentBook.getAppointments());
        appointmentsTable.setModel(appointmentsTableModel);
    }

    private void setButtons() {
        buttons = new JButton[buttonNames.length];

        for (int i = 0; i < buttonNames.length; i++) {
            buttons[i] = new JButton( buttonNames[i]);
            buttons[i].addActionListener(this);
        }
    }

    private void resetTable() {
        appointmentsTableModel = new AppointmentTableModel(appointmentBook.getAppointments());
        appointmentsTable.setModel(appointmentsTableModel);
        appointmentsTable.invalidate();
    }

    private void ContainerSetup()
	{
        Container c = getContentPane();
        // Center Layout
        c.add(appointmentsTablePane, BorderLayout.CENTER);

        //South Layout
        JPanel spanel = new JPanel();
        for (int i=0; i < buttonNames.length; i++) spanel.add(buttons[i]);
        c.add(spanel,BorderLayout.SOUTH);
    }

    public void actionPerformed(ActionEvent e) {

        Object source = e.getSource();

        if (source == buttons[0]) {
            // New Appointment
            AppointmentGUI form = new AppointmentGUI(appointmentBook);
        }
        else if (source == buttons[1]) {
            // Remove Appointment
            int index = appointmentsTable.getSelectedRow();
            appointmentBook.removeAppointment(index);
            resetTable();
        } 
        else if (source == buttons[2]) {
            // Print Receipt
            int index = appointmentsTable.getSelectedRow();
            ReceiptGUI r = new ReceiptGUI(appointmentBook.writeAppointmentReceiptToFile(index));
        }
        else if (source == buttons[3]) {
            // Refresh Table
            resetTable();
        }
        else if (source == buttons[4]) {
            // Exit
            appointmentBook.writeAppointmentsToFile();
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