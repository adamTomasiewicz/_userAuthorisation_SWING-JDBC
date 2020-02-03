package g_gui.SwingApp_1_RegistrationForm;

import javax.swing.*;
import java.awt.*;

public class AuthorizationFormMain {
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                SwingApp_1_JFrame1 swingApp_1_JFrame1 = new SwingApp_1_JFrame1();
                swingApp_1_JFrame1.setVisible(true);
                swingApp_1_JFrame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            }
        });
    }
}

