package yourpack;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;

public class TestJList {

public static void main(String[] args) {
    String[] items = new String[]
        {
                "One", "Two", "Three", "Four"
        };
    final JList list = new JList(items);
    final JFrame frame = new JFrame();
    frame.setLayout(new BorderLayout());
    frame.add(list, BorderLayout.CENTER);

    JButton btn = new JButton("Get selected");
    btn.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showConfirmDialog(frame, "You Selected : " + list.getSelectedValue(), "Display",
                    JOptionPane.PLAIN_MESSAGE);

        }
    });

    frame.add(btn, BorderLayout.SOUTH);
    frame.pack();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
}
}