import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ReceiptGUI {

    private JTextArea text = new JTextArea();
    private JFrame receipt = new JFrame("Receipt");

    public ReceiptGUI(String info) {
        Container p = receipt.getContentPane();
        receipt.setSize(235,600);
        p.add(new JScrollPane(text),BorderLayout.CENTER);
        text.setText(info);
        text.setEditable(false);
        //text.setFont(new Font("Monospaced",Font.PLAIN,12));
        receipt.show();
        
    }
}
