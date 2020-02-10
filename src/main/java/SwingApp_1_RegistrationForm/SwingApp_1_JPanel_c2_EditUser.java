package SwingApp_1_RegistrationForm;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class SwingApp_1_JPanel_c2_EditUser extends JPanel {

    public SwingApp_1_JPanel_c2_EditUser() {
        setLayout(null);

        //textfield
        JTextField jTextField1 = new JTextField("JField record");
        jTextField1.setBounds(30, 100, 400, 50);
        add(jTextField1);

        // button submit
        JButton jButtonSubmit = new JButton("submit data");
        jButtonSubmit.setBounds(460, 100, 100, 50);
        jButtonSubmit.addActionListener(new ActionButtonSaveChanges());
        add(jButtonSubmit);


    }
    class ActionButtonSaveChanges implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                Users.exportUsers_toTXT();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

}




