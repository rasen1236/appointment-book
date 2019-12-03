import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Date;

public class AppointmentGUI extends JFrame implements ActionListener {

    private AppointmentBook appointmentBook;

    private String[] buttonNames = { "Create", "Cancel"};
    private String[] labelNames = { "Customer Name", "Customer Phone", "Stylist Name", "Date dd/MM/yyyy HH:mm:ss" };

    private static final String[] listItems = { "BLUE", "BLACK", "CYAN",
            "GREEN", "GRAY", "RED", "WHITE" };
    
    private JButton[] buttons;
    private JLabel[] labels;
    private JTextField[] textFields;

    private JList list;
    private JButton serviceButton;
    private JList serviceList;
    private DefaultListModel serviceListModel;

    /**
     * Declares the Buttons
     */
    private void setButtons() {
        buttons = new JButton[buttonNames.length];

        for (int i = 0; i < buttonNames.length; i++) {
            buttons[i] = new JButton( buttonNames[i]);
            buttons[i].addActionListener(this);
        }

        serviceButton = new JButton(">>>");
        serviceButton.addActionListener(this);
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
     * Declares the TextFields
     */
    private void setLists()
	{
        list = new JList(appointmentBook.getSalonServices());
        list.setFixedCellHeight(15);
        list.setFixedCellWidth(100);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.setVisibleRowCount(4);

        serviceList = new JList();
        serviceListModel = new DefaultListModel();
        serviceList.setModel(serviceListModel);
        serviceList.setFixedCellHeight(15);
        serviceList.setFixedCellWidth(100);
        serviceList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        serviceList.setVisibleRowCount(4);
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
        c.add(cpanel,BorderLayout.NORTH);

        JPanel mpanel = new JPanel();
        //mpanel.setBorder(BorderFactory.createLoweredBevelBorder());
        mpanel.setLayout(new GridLayout(1,3));
        mpanel.add(list);
        mpanel.add(serviceButton);
        mpanel.add(serviceList);

        c.add(mpanel, BorderLayout.CENTER);
    }

    public void actionPerformed(ActionEvent e) {

        Object source = e.getSource();
        if (source == buttons[0]) {
            // Create Appointment
            Appointment appointment = new Appointment(textFields[0].getText(), textFields[1].getText(), textFields[2].getText(), HairSalon.string2Date(textFields[3].getText()));
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
        else if (source == serviceButton) {
            serviceListModel.addElement(list.getSelectedValue());
        }
    }

    public AppointmentGUI(AppointmentBook appointmentBook)
	{
        super("New Appointment");
        this.appointmentBook = appointmentBook;
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(300,300);
        setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        setButtons();
        setLabels();
        setTextfields();
        setLists();
        ContainerSetup();
        setVisible(true);
    }
}