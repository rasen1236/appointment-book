
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import java.awt.*;
import java.awt.event.*;
import com.apple.eawt.ApplicationListener;


public class AppointmentForm extends JFrame implements ActionListener {

    private String[] buttonNames = { "Create", "Cancel"};

    private JButton[] buttons;

    public AppointmentForm()
	{
        super("AppointmentForm");
        setSize(300,300);
        setLocation(400,400);
        setButtons();
        ContainerSetup();
        setVisible(true);
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

    }
}