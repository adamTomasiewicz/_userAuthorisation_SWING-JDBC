package g_gui.SwingApp_1_RegistrationForm;

import javax.swing.*;

public class SwingApp_1_JFrame2 extends JFrame {


    public SwingApp_1_JFrame2() {
        setSize(600, 300);
        setLocation(350, 350);
        setTitle("edit user");
        //setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        SwingApp_1_JPanel_c2_EditUser swingApp_1_JPanel_c2_EditUser = new SwingApp_1_JPanel_c2_EditUser();
        add(swingApp_1_JPanel_c2_EditUser);

    }
}

