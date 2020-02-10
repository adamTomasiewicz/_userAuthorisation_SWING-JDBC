package SwingApp_1_RegistrationForm;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

//https://stackoverflow.com/questions/26241488/java-swing-group-of-checkbox-multiple-selection-handler

public class SwingApp_1_JPanel_b1_SignUp extends JPanel {

    JTextField jTextField1;
    JTextField jTextField2;
    JTextField jTextField3;
    JRadioButton jRadioButton1;
    JRadioButton jRadioButton2;
    JRadioButton jRadioButton3;
    JCheckBox jCheckBox1;
    JCheckBox jCheckBox2;
    JCheckBox jCheckBox3;
    JCheckBox jCheckBox4;
    JLabel jLabel4;
    JLabel jLabel5;
    JLabel jLabel6;


    public SwingApp_1_JPanel_b1_SignUp() {
        setLayout(null); // wylacza domyslny zarzadca rozkladu

        // panel title
        JLabel jLabel0 = new JLabel("SingUp");
        jLabel0.setBounds(400, 5, 250, 50);
        jLabel0.setFont(new Font("TimesRoman", Font.PLAIN, 24));
        add(jLabel0);
        jLabel0.setForeground(Color.red);

        //login
        JLabel jLabel1 = new JLabel("login:");
        jLabel1.setBounds(100, 100, 100, 30);
        add(jLabel1);

        jTextField1 = new JTextField("type your login");
        jTextField1.setBounds(300, 100, 100, 30);
        add(jTextField1);

        jLabel4 = new JLabel();
        jLabel4.setVisible(false);
        jLabel4.setBounds(410, 100, 200, 30);
        add(jLabel4);

        // password
        JLabel jLabel2 = new JLabel("password:");
        jLabel2.setBounds(100, 140, 100, 30);
        add(jLabel2);

        jTextField2 = new JTextField("type your password");
        jTextField2.setBounds(300, 140, 100, 30);
        add(jTextField2);

        jLabel5 = new JLabel();
        jLabel5.setVisible(false);
        jLabel5.setBounds(410, 140, 200, 30);
        add(jLabel5);

        //password 2
        JLabel jLabel3 = new JLabel("re-enter password:");
        jLabel3.setBounds(80, 180, 200, 30);
        add(jLabel3);

        jTextField3 = new JTextField("re-enter your password");
        jTextField3.setBounds(300, 180, 100, 30);
        add(jTextField3);

        jLabel6 = new JLabel();
        jLabel6.setVisible(false);
        jLabel6.setBounds(410, 180, 200, 30);
        add(jLabel6);

        //JSplitPane - spit pane
        // create a splitpane
        //JSplitPane jSplitPane = new JSplitPane(SwingConstants.HORIZONTAL, );
        // add panel

        JSeparator jSeparator = new JSeparator();
        jSeparator.setBounds(10, 260, 560, 20);
        jSeparator.setBackground(Color.black);
        add(jSeparator);

        //sex
        JLabel jLabel5 = new JLabel("sex:");
        jLabel5.setBounds(100, 260, 100, 30);
        add(jLabel5);

        List<JRadioButton> listJRadioButtons = new LinkedList<>();
        ButtonGroup buttonGroup1= new ButtonGroup();
        jRadioButton1 = new JRadioButton("Man");
        jRadioButton1.setText("Man");
        jRadioButton1.setBounds(90,300 , 120,20);
        buttonGroup1.add(jRadioButton1);
        add(jRadioButton1);

        jRadioButton2 = new JRadioButton("Woman");
        jRadioButton2.setText("Woman");
        jRadioButton2.setBounds(290,300 , 120,20);
        buttonGroup1.add(jRadioButton2);
        add(jRadioButton2);

        jRadioButton3 = new JRadioButton("Other");
        jRadioButton3.setText("Other");
        jRadioButton3.setBounds(490,300 , 120,20);
        buttonGroup1.add(jRadioButton3);
        add(jRadioButton3);

        listJRadioButtons.add(jRadioButton1);
        listJRadioButtons.add(jRadioButton2);
        listJRadioButtons.add(jRadioButton3);

        //interests

        JLabel jLabel6 = new JLabel("interests:");
        jLabel6.setBounds(100, 350, 100, 30);
        add(jLabel6);

        List<JCheckBox> listJCheckBoxes = new LinkedList<>();
        CheckboxGroup checkboxGroup1= new CheckboxGroup();

        jCheckBox1 = new JCheckBox("trips");
        jCheckBox1.setBounds(90, 400, 100, 30);
        add(jCheckBox1);

        jCheckBox2 = new JCheckBox("movies");
        jCheckBox2.setBounds(190, 400, 100, 30);
        //checkboxGroup1.add(jCheckBox2);
        add(jCheckBox2);

        jCheckBox3 = new JCheckBox("fishing");
        jCheckBox3.setBounds(290, 400, 100, 30);
        //checkboxGroup1.add(jCheckBox3);
        add(jCheckBox3);

        jCheckBox4 = new JCheckBox("drinking");
        jCheckBox4.setBounds(390, 400, 100, 30);
       // checkboxGroup1.add(jCheckBox4);
        add(jCheckBox4);

        listJCheckBoxes.add(jCheckBox1);
        listJCheckBoxes.add(jCheckBox2);
        listJCheckBoxes.add(jCheckBox3);
        listJCheckBoxes.add(jCheckBox4);

        // buttons
        //test data
        JButton jButton1 = new JButton("test person");
        jButton1.setBounds(50, 470, 120, 50);
        jButton1.addActionListener(new ActionButtonTestData());
        add(jButton1);
        //clean
        JButton jButton2 = new JButton("wipe form");
        jButton2.setBounds(200, 470, 120, 50);
        jButton2.addActionListener(new ActionButtonCleanForm());
        add(jButton2);
        //register
        JButton jButton3 = new JButton("register person");
        jButton3.setBounds(350, 470, 120, 50);
        jButton3.addActionListener(new ActionButtonRegisterPerson());
        add(jButton3);

    }
    //todo action listeners:

    class ActionButtonTestData implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            jTextField1.setText("TestPerson"); jTextField2.setText("test1234"); jTextField3.setText("test1234");
            jRadioButton1.setSelected(true);jCheckBox1.setSelected(true);jCheckBox2.setSelected(true);
        }
    }
    class ActionButtonCleanForm implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            jTextField1.setText("");jTextField2.setText(""); jRadioButton1.setSelected(false);jRadioButton2.setSelected(false);jRadioButton3.setSelected(false);
            jCheckBox1.setSelected(false);jCheckBox2.setSelected(false); jCheckBox3.setSelected(false);jCheckBox4.setSelected(false);
        }
    }
    class ActionButtonRegisterPerson implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
           if (isCorrectPassword()){
               String sex;
               if(jRadioButton1.isSelected()) sex = "Man";
               else if(jRadioButton2.isSelected()) sex = "Woman";
               else sex = "Other";
               Users user = new Users(jTextField1.getText(), jTextField2.getText(), sex, Arrays.asList(jCheckBox1.getText(),jCheckBox2.getText()));
               JOptionPane.showMessageDialog(null, "UserCreated");
               SwingApp_1_repository.addUserToDB(user);
               SwingApp_1_JPanel_c1_Users.fillDefaultListModel();
           }
      }
    }
    class CheckDataCompletion implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            //System.out.println("login: "+jTextField1.getText()+"password: "+ jTextField2.getText()+"sex: " +Person.Sex.MAN + Arrays.asList(jCheckBox1.getText(),jCheckBox2.getText()));
            //  new Person(jTextField1.getText(), jTextField2.getText(), Person.Sex.MAN, Arrays.asList(jCheckBox1.getText(),jCheckBox2.getText()));

        }
    }
   public boolean isCorrectPassword () {
       String pass1 = jTextField2.getText();
       String pass2 = jTextField3.getText();
       int pass1Length=pass1.length();
       int pass2Length=pass2.length();
       char[] pass1charArray = pass1.toCharArray();
       char[] pass2charArray = pass2.toCharArray();
       if(pass1.isEmpty() ){
           jLabel5.setVisible(true); jLabel5.setText(Alerts.PROVIDED_PASSWORDS_ARE_DIFFERENT.alertEN); }
       else if(pass2.isEmpty()){
           jLabel6.setVisible(true);jLabel6.setText(Alerts.PROVIDED_PASSWORDS_ARE_DIFFERENT.alertEN); }
       else if(!pass1.equals(pass2)) {
           jLabel5.setVisible(true);jLabel5.setText(Alerts.PROVIDED_PASSWORDS_ARE_DIFFERENT.alertEN);
           jLabel6.setVisible(true);jLabel6.setText(Alerts.PROVIDED_PASSWORDS_ARE_DIFFERENT.alertEN); }

       //8+znakow
       boolean isPass1LongerThan8=false;
       boolean isPass2LongerThan8=false;
       if (pass1Length>7) isPass1LongerThan8 = true;
       if (pass2Length>7) isPass2LongerThan8 = true;
       // cyfra
       boolean ifPass1ContainsDigit=false;
       boolean ifPass2ContainsDigit=false;
       for (int i = 0; i <pass1Length ; i++) {
           if(Character.isDigit(pass1charArray[i])) ifPass1ContainsDigit=true; }
       for (int i = 0; i <pass2Length ; i++) {
           if(Character.isDigit(pass2charArray[i])) ifPass2ContainsDigit=true; }
       //mala litera
       boolean ifPass1ContainsLowLetter=false;
       boolean ifPass2ContainsLowLetter=false;
       for (int i = 0; i <pass1Length ; i++) {
           if(Character.isLowerCase(pass1charArray[i])) ifPass1ContainsLowLetter=true;}
       for (int i = 0; i <pass2Length ; i++) {
           if(Character.isLowerCase(pass2charArray[i])) ifPass2ContainsLowLetter=true;}
       //duza litera
       boolean ifPass1ContainsUppLetter=false;
       boolean ifPass2ContainsUppLetter=false;
       for (int i = 0; i <pass1Length ; i++) {
           if(Character.isUpperCase(pass1charArray[i])) ifPass1ContainsUppLetter=true;}
       for (int i = 0; i <pass2Length ; i++) {
           if(Character.isUpperCase(pass2charArray[i])) ifPass2ContainsUppLetter=true;}
       //znak specjalny
       boolean ifPass1ContainsSpecial=false;
       boolean ifPass2ContainsSpecial=false;
       for (int i = 0; i <pass1Length ; i++) {
           if(!Character.isDigit(pass1charArray[i])&!Character.isDigit(pass1charArray[i])) {
               ifPass1ContainsSpecial=true;}  }
       for (int i = 0; i <pass2Length ; i++) {
           if(!Character.isDigit(pass2charArray[i])&!Character.isDigit(pass2charArray[i])) {
               ifPass2ContainsSpecial=true;} }

       //todo: CHECK
       //longer than 8
       if(!isPass1LongerThan8) {
           jLabel5.setVisible(true);jLabel5.setText(Alerts.PASSWORD_DOES_NOT_MEET_THE_REQUIREMENTS.alertEN);
           return false;}
       else if(!isPass2LongerThan8) {
           jLabel6.setVisible(true);jLabel6.setText(Alerts.PASSWORD_DOES_NOT_MEET_THE_REQUIREMENTS.alertEN);
           return false;}
       //cyfra
       else if(!ifPass1ContainsDigit) {
           jLabel5.setVisible(true);jLabel6.setText(Alerts.PASSWORD_DOES_NOT_MEET_THE_REQUIREMENTS.alertEN);
           return false;}
       else if(!ifPass2ContainsDigit) {
           jLabel6.setVisible(true);jLabel6.setText(Alerts.PASSWORD_DOES_NOT_MEET_THE_REQUIREMENTS.alertEN);
           return false;}
       //malalitera
       else if(!ifPass1ContainsLowLetter) {
           jLabel5.setVisible(true);jLabel6.setText(Alerts.PASSWORD_DOES_NOT_MEET_THE_REQUIREMENTS.alertEN);
           return false;}
       else if(!ifPass2ContainsLowLetter) {
           jLabel6.setVisible(true);jLabel6.setText(Alerts.PASSWORD_DOES_NOT_MEET_THE_REQUIREMENTS.alertEN);
           return false;}
       //duzalitera
       else if(!ifPass1ContainsUppLetter) {
           jLabel5.setVisible(true);jLabel6.setText(Alerts.PASSWORD_DOES_NOT_MEET_THE_REQUIREMENTS.alertEN);
           return false;}
       else if(!ifPass2ContainsUppLetter) {
           jLabel6.setVisible(true);jLabel6.setText(Alerts.PASSWORD_DOES_NOT_MEET_THE_REQUIREMENTS.alertEN);
           return false;}
       //znak
       else if(!ifPass1ContainsSpecial) {
           jLabel5.setVisible(true);jLabel6.setText(Alerts.PASSWORD_DOES_NOT_MEET_THE_REQUIREMENTS.alertEN);
           return false;}
       else if(!ifPass2ContainsSpecial) {
           jLabel6.setVisible(true);jLabel6.setText(Alerts.PASSWORD_DOES_NOT_MEET_THE_REQUIREMENTS.alertEN);
           return false;}

       return true;
    }

}




