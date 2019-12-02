import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Date;


public class AppointmentForm extends JFrame implements ActionListener {

    private AppointmentBook appointmentBook;

    private String[] buttonNames = { "Create", "Cancel"};
    private String[] labelNames = { "Customer Name", "Customer Phone", "Stylist Name", "Date" };
    
    private JButton[] buttons;
    private JLabel[] labels;
    private JTextField[] textFields;

    /**
     * Declares the Buttons
     */
    private void setButtons() {
        buttons = new JButton[buttonNames.length];

        for (int i = 0; i < buttonNames.length; i++) {
            buttons[i] = new JButton( buttonNames[i]);
            buttons[i].addActionListener(this);
        }
    }

    /**
     * Declares the Labels
     */
    private void setLabels() {
        labels = new JLabel[labelNames.length];

        for (int i =0; i < labelNames.length; i++) 
		{
            labels[i] = new JLabel(labelNames[i]);
            labels[i].setHorizontalAlignment(SwingConstants.CENTER);
            //labels[i].setEnabled(true);
        }
    }

    /**
     * Declares the TextFields
     */
    private void setTextfields()
	{
        textFields = new JTextField[labelNames.length];

        for (int i=0; i < labelNames.length; i++) 
		{
            textFields[i] = new JTextField(30);
            //tfields[i].setEnabled(false);
        }
    }

    /**
     * Declares the Container
     */
    private void ContainerSetup()
	{
        Container c = getContentPane();

        //South Layout
        JPanel spanel = new JPanel();
        for (int i=0; i < buttonNames.length; i++) spanel.add(buttons[i]);
        c.add(spanel,BorderLayout.SOUTH);

        //Center Layout
        JPanel cpanel = new JPanel();
        cpanel.setBorder(BorderFactory.createLoweredBevelBorder());
        cpanel.setLayout(new GridLayout(labelNames.length,2));
        for (int i=0; i < labelNames.length; i++) 
		{
            cpanel.add(labels[i]);
            cpanel.add(textFields[i]);
        }
        c.add(cpanel,BorderLayout.CENTER);

    }

    public void actionPerformed(ActionEvent e) {

        Object source = e.getSource();
        if (source == buttons[0]) {
            // Create Appointment
            Appointment appointment = new Appointment(textFields[0].getText(), textFields[1].getText(), textFields[2].getText(), new Date());
            appointmentBook.addAppointment(appointment);
            System.out.println("NEW APPOINTMENT");
            setVisible(false);
            dispose();
        } 
        else if (source == buttons[1]) {
            // Close Window
            setVisible(false);
            dispose();
        }
    }

    public AppointmentForm(AppointmentBook appointmentBook)
	{
        super("AppointmentForm");
        this.appointmentBook = appointmentBook;
        setSize(300,300);
        setLocation(400,400);
        setButtons();
        setLabels();
        setTextfields();
        ContainerSetup();
        setVisible(true);
    }
}