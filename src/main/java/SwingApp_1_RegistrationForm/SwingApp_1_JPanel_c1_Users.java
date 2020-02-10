package SwingApp_1_RegistrationForm;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Arrays;


public class SwingApp_1_JPanel_c1_Users extends JPanel {

    private JTextField jTextField1;
    private JTextField jTextField2;
    private JTextField jTextField3;
    private static JList<String> jList1;
   private static DefaultListModel<String> defaultListModel;

    public static JList<String> getTempUsers() {




        return jList1;
    }

    public static DefaultListModel<String> getDefaultListModel() {
        return defaultListModel;
    }

    public SwingApp_1_JPanel_c1_Users() {
        setLayout(null);

        // JList
        //System.out.println(Users.listUsers.size());
        defaultListModel = new DefaultListModel<>();
        jList1 = new JList<>(defaultListModel);
        jList1.setBounds(50,50,500,300);
        add(fillDefaultListModel());

        //JLabel
        JLabel jLabel0 = new JLabel("Users");
        jLabel0.setBounds(400, 5, 250, 50);
        jLabel0.setFont(new Font("TimesRoman", Font.PLAIN, 24));
        add(jLabel0);
        jLabel0.setForeground(Color.red);

        //textfield
       jTextField1 = new JTextField("login");
        jTextField1.setBounds(50, 400, 300, 20);
        add(jTextField1);
      jTextField2 = new JTextField("password");
        jTextField2.setBounds(50, 430, 300, 20);
        add(jTextField2);
        jTextField3 = new JTextField("SEX");
        jTextField3.setBounds(50, 460, 300, 20);
        add(jTextField3);

        // add button - icon: +
        JButton jButtonAdd = new JButton("add");
        jButtonAdd.setBounds(400, 400, 80, 40);
        jButtonAdd.addActionListener(new ActionButtonAdd());
        add(jButtonAdd);
        // remove button - icon: -
        JButton jButtonRemove = new JButton("remove");
        jButtonRemove.setBounds(400, 450, 80, 40);
        jButtonRemove.addActionListener(new ActionButtonRemove());
        add(jButtonRemove);
        // edit button - icon: pencil
        JButton jButtonEdit = new JButton("edit");
        jButtonEdit.setBounds(480, 420, 50, 50);
        jButtonEdit.addActionListener(new ActionButtonEdit());
        add(jButtonEdit);

        //save button
        JButton jButtonSave = new JButton("save");
        jButtonSave.setBounds(480, 480, 50, 50);
        jButtonSave.addActionListener(new ActionButtonSave());
        add(jButtonSave);

    }
    static JList<String> fillDefaultListModel () {

        defaultListModel.clear();
        int counter=1;
        for (Users user : Users.listUsers) {
            defaultListModel.addElement(""+counter++ +user.toString());
        }
        jList1.setModel(defaultListModel);
        return jList1;
    }


    class ActionButtonAdd implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Users userToAdd = new Users(jTextField1.getText(),jTextField2.getText(), jTextField3.getText().equals("SEX")?"OTHER":jTextField3.getText(), Arrays.asList(""));
            System.out.println("created user: "+userToAdd);
            SwingApp_1_repository.addUserToDB(userToAdd);
            add(fillDefaultListModel());

        }
    }
    class ActionButtonRemove implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println(jList1.getSelectedIndex());
            Users.listUsers.remove(jList1.getSelectedIndex());
            System.out.println("removed user: ");
            add(fillDefaultListModel());
        }
    }

    class ActionButtonEdit implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
           Users user = Users.listUsers.get(jList1.getSelectedIndex());
           user.setLogin(jTextField1.getText());
           user.setPassword(jTextField2.getText());
           user.setSex((jTextField3.getText().equals("SEX")?"OTHER":jTextField3.getText()));
            add(fillDefaultListModel());
            EventQueue.invokeLater(new Runnable() {
                @Override
                public void run() {
                    SwingApp_1_JFrame2 swingApp_1_JFrame2 = new SwingApp_1_JFrame2();
                    swingApp_1_JFrame2.setVisible(true);
                  //  swingApp_1_JFrame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


                }
            });
        }
    }
    class ActionButtonSave implements ActionListener {
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




