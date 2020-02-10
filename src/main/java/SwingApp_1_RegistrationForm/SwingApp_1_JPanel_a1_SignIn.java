package SwingApp_1_RegistrationForm;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwingApp_1_JPanel_a1_SignIn extends JPanel {
    JTextField jTextField1_login;
    JPasswordField jPasswordField1_password;
    JLabel jLabel3_result;

    public SwingApp_1_JPanel_a1_SignIn() {
        setLayout(null); // wylacza domyslny zarzadca rozkladu

        //JTabbedPane  - zakladki SignIn SignUp
        // panel title
        JLabel jLabel0 = new JLabel("SingIn");
        jLabel0.setBounds(400, 5, 250, 50);
        jLabel0.setFont(new Font("TimesRoman", Font.PLAIN, 24));
        add(jLabel0);
        jLabel0.setForeground(Color.red);

        //login
        JLabel jLabel1 = new JLabel("login:");
        jLabel1.setBounds(100, 100, 100, 30);
        add(jLabel1);

        jTextField1_login = new JTextField("type your login");
        jTextField1_login.setBounds(300, 100, 150, 30);
        add(jTextField1_login);
        // password
        JLabel jLabel2 = new JLabel("password:");
        jLabel2.setBounds(100, 140, 100, 30);
        add(jLabel2);

        jPasswordField1_password = new JPasswordField("type your password");
        jPasswordField1_password.setBounds(300, 140, 150, 30);
        add(jPasswordField1_password);

        //JSplitPane - spit pane
        // create a splitpane
        //JSplitPane jSplitPane = new JSplitPane(SwingConstants.HORIZONTAL, );
        // add panel

        JSeparator jSeparator = new JSeparator();
        jSeparator.setBounds(10, 230, 560, 20);
        jSeparator.setBackground(Color.black);
        add(jSeparator);

        //RESULT

        jLabel3_result = new JLabel();
        jLabel3_result.setBounds(200, 270, 200, 30);
        add(jLabel3_result);

        // buttons
        //clean
        JButton jButton1 = new JButton("wipe");
        jButton1.setBounds(150, 440, 150, 50);
        jButton1.addActionListener(new ActionButtonWipe());
        // jButton1.addActionListener(new SwingApp_1_JPanel_b1_SignUp.ActionButtonWipeForm()); clean form
        add(jButton1);
        //register
        JButton jButton2 = new JButton("login");
        jButton2.setBounds(350, 440, 150, 50);
        jButton2.addActionListener(new ActionButtonSignIn());
        add(jButton2);

    }
    class ActionButtonWipe implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            jTextField1_login.setText("");
            jPasswordField1_password.setText("");
        }

    }
    class ActionButtonSignIn implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String login = jTextField1_login.getText();
            String password = String.valueOf(jPasswordField1_password.getPassword());
            System.out.println("login: " + login + " " + "password: " + password);
            if (!login.isEmpty() | !password.isEmpty()) {
                for (Users user : Users.listUsers) {
                    if (user.getLogin().equals(login) & user.getPassword().equals(password)) {
                        jLabel3_result.setText(String.valueOf(Alerts.SUCCESSFULLY_LOGGED_IN));
                        jLabel3_result.setForeground(Color.GREEN);
                        JOptionPane.showMessageDialog(null, "You have successfully logged in.");
                    }

                }
            } else {
                JOptionPane.showMessageDialog(null, "Empty Login Or Password");
            }
        }


    }


}






