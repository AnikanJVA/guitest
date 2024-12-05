import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
public class testing{
    public static JFrame window;
    public static JLabel usernameText, passwordText, successLabel;
    public static JPasswordField passwordTextField;
    public static JTextField usernameTextField;
    public static JButton loginButton, creditButton, debitButton;
    public static void main(String[] args) {
        window = new JFrame("Banking System");
        window.setSize(560, 400);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setLocationRelativeTo(null);
        window.setLayout(null);

        usernameText = new JLabel("Username");
        usernameText.setBounds(24, 58, 500, 24);
        usernameText.setFont(new Font("Arial", Font.PLAIN, 20));
        window.add(usernameText);

        successLabel = new JLabel();
        successLabel.setBounds(usernameText.getX(), usernameText.getY() - 28, usernameText.getWidth(), usernameText.getHeight());
        window.add(successLabel);
        
        usernameTextField = new JTextField();
        usernameTextField.setBounds(24, 89, 500, 46);
        window.add(usernameTextField);

        passwordText = new JLabel("Password");
        passwordText.setBounds(usernameTextField.getX(), 173, usernameText.getWidth(), usernameText.getHeight());
        passwordText.setFont(new Font("Arial", Font.PLAIN, 20));
        window.add(passwordText);

        passwordTextField = new JPasswordField();
        passwordTextField.setBounds(passwordText.getX(), 204, usernameTextField.getWidth(), usernameTextField.getHeight());
        window.add(passwordTextField);

        loginButton = new JButton("Login");
        loginButton.setBounds(passwordTextField.getX(), 288, 500, 56);
        loginButton.setFont(new Font("Arial", Font.PLAIN, 25));
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Login login = new Login();
                ArrayList<UserAccount> userAccountList = login.getAllUserAccounts();
                for (UserAccount useraccount : userAccountList) {
                    if(usernameTextField.getText().equalsIgnoreCase(useraccount.getUsername()) && passwordTextField.getText().equals(useraccount.getPassword())){
                        selectAccount(useraccount);
                        break;
                    }
                    else{
                        successLabel.setText("login failed");
                    }
                }
            }
        });
        window.add(loginButton);

        window.setVisible(true);
    }

    public static void selectAccount(UserAccount useraccount){
        window.getContentPane().removeAll();

        JLabel welcomeText = new JLabel("Welecome " + useraccount.getUsername() + "!");
        welcomeText.setBounds(24, 39, successLabel.getWidth(), successLabel.getHeight());
        welcomeText.setFont(new Font("Arial", Font.PLAIN, 30));
        window.add(welcomeText);

        JLabel selectText = new JLabel("Select account:");
        selectText.setBounds(welcomeText.getX(), 127, successLabel.getWidth(), successLabel.getHeight());
        selectText.setFont(new Font("Arial", Font.PLAIN, 27));
        window.add(selectText);
        
        creditButton = new JButton("Credit");
        creditButton.setBounds(loginButton.getX(), 170, loginButton.getWidth(), loginButton.getHeight());
        creditButton.setFont(new Font("Arial", Font.PLAIN, 20));
        creditButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Credit button pressed");
            }
        });
        window.add(creditButton);

        debitButton = new JButton("Debit");
        debitButton.setBounds(loginButton.getX(), 234, loginButton.getWidth(), loginButton.getHeight());
        debitButton.setFont(new Font("Arial", Font.PLAIN, 20));
        debitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new runDebit(window, useraccount);
            }
        });
        window.add(debitButton);

        window.repaint();
        window.setVisible(true);
    }

}