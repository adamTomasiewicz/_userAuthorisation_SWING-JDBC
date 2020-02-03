package g_gui.SwingApp_1_RegistrationForm;

import javax.swing.*;

public class SwingApp_1_JFrame1 extends JFrame {
    JTabbedPane jTabbedPanes;
    SwingApp_1_JPanel_a1_SignIn jPanel_a1_SignIn;
    SwingApp_1_JPanel_b1_SignUp jPanel_b1_SignUp;
    SwingApp_1_JPanel_c1_Users jPanel_c1_Users;

    public SwingApp_1_JFrame1() {
        setSize(600, 600);
        setLocation(50, 50);
        setTitle("authorization form");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        jTabbedPanes = new JTabbedPane(JTabbedPane.TOP);
        jPanel_a1_SignIn=new SwingApp_1_JPanel_a1_SignIn();
        jPanel_b1_SignUp=new SwingApp_1_JPanel_b1_SignUp();
        jPanel_c1_Users=new SwingApp_1_JPanel_c1_Users();


        jTabbedPanes = new JTabbedPane();
        jTabbedPanes.addTab("SignIn", jPanel_a1_SignIn );
        jTabbedPanes.addTab("SignUp", jPanel_b1_SignUp);
        jTabbedPanes.addTab("Users", jPanel_c1_Users);

        getContentPane().add(jTabbedPanes);

    }
}

