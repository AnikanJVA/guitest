import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class runLogin extends JFrame{
    private JPanel loginFormPanel, backgroundPanel, topPanel, bottomPanel, loginFormTopPadding, loginFormBottomPadding, loginFormLeftPadding, loginFormRightPadding;
    private JLabel title;
    private JTextField usernameTextField;
    private JPasswordField passwordField;
    private JButton loginButton;

    final Dimension top_bottom_border_size = new Dimension(640, 66);
    final Dimension background_size = new Dimension(640, 349);
    final Dimension login_form_size = new Dimension(326, 242);
    final Dimension text_field = new Dimension(267, 28);

    public runLogin(){
        setTitle("Banking System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(640, 480);
        setResizable(false);
        setLocationRelativeTo(null);

        topPanel = new JPanel();
        topPanel.setPreferredSize(top_bottom_border_size);
        topPanel.setBackground(new Color(0x032F30));
        topPanel.setFocusable(true);

        backgroundPanel = new JPanel();
        backgroundPanel.setPreferredSize(background_size);
        backgroundPanel.setBackground(new Color(0x0C969C));
        backgroundPanel.setLayout(new BorderLayout());

        loginFormPanel = new JPanel();
        loginFormPanel.setPreferredSize(login_form_size);
        loginFormPanel.setBackground(Color.WHITE);
        loginFormPanel.setLayout(null);

        title = new JLabel("Banking System");
        title.setBounds(45, 15, 267, 30);
        title.setFont(new Font("Arial", Font.PLAIN, 30));
        loginFormPanel.add(title);

        usernameTextField = new JTextField("Username");
        usernameTextField.setBounds(20, title.getY() + 55, 267, 28);
        usernameTextField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if(usernameTextField.getText().equals("Username")){
                    usernameTextField.setText("");
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if(usernameTextField.getText().equals("Username") || usernameTextField.getText().isEmpty()){
                    usernameTextField.setText("Username");
                }
            }
        });
        loginFormPanel.add(usernameTextField);

        passwordField = new JPasswordField("Password");
        passwordField.setEchoChar((char) 0);
        passwordField.setBounds(20, usernameTextField.getY() + 40, 267, 28);
        passwordField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                if(passwordField.getText().equals("Password")){
                    passwordField.setText("");
                    passwordField.setEchoChar('*');
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if(passwordField.getText().equals("Password") || passwordField.getText().isEmpty()){
                    passwordField.setText("Password");
                    passwordField.setEchoChar((char) 0);
                }
            }
        });
        loginFormPanel.add(passwordField);

        loginButton = new JButton("Login");
        loginButton.setBackground(new Color(0x0C969C));
        loginButton.setBounds(passwordField.getX(), passwordField.getY() + 41, passwordField.getWidth(), 30);
        loginButton.setFont(new Font("Arial", Font.PLAIN, 10));
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Login login = new Login();
                ArrayList<UserAccount> userAccountList = login.getAllUserAccounts();
                for (UserAccount useraccount : userAccountList) {
                    if(usernameTextField.getText().equalsIgnoreCase(useraccount.getUsername()) && passwordField.getText().equals(useraccount.getPassword())){
                        System.out.println("login success");
                        runPreSelect(useraccount);
                        break;
                    }
                    else{
                        System.out.println("login failed");
                    }
                }          
            }
        });
        loginFormPanel.add(loginButton);

        backgroundPanel.add(loginFormPanel, BorderLayout.CENTER);

        loginFormTopPadding = new JPanel();
        loginFormTopPadding.setPreferredSize(new Dimension(213, 54));
        loginFormTopPadding.setBackground(new Color(0x0C969C));
        backgroundPanel.add(loginFormTopPadding, BorderLayout.NORTH);

        loginFormBottomPadding = new JPanel();
        loginFormBottomPadding.setPreferredSize(new Dimension(213, 54));
        loginFormBottomPadding.setBackground(new Color(0x0C969C));
        backgroundPanel.add(loginFormBottomPadding, BorderLayout.SOUTH);

        loginFormLeftPadding = new JPanel();
        loginFormLeftPadding.setPreferredSize(new Dimension(157, 349));
        loginFormLeftPadding.setBackground(new Color(0x0C969C));
        backgroundPanel.add(loginFormLeftPadding, BorderLayout.WEST);

        loginFormRightPadding = new JPanel();
        loginFormRightPadding.setPreferredSize(new Dimension(157, 349));
        loginFormRightPadding.setBackground(new Color(0x0C969C));
        backgroundPanel.add(loginFormRightPadding, BorderLayout.EAST);

        bottomPanel = new JPanel();
        bottomPanel.setBackground(new Color(0x032F30));
        bottomPanel.setPreferredSize(top_bottom_border_size);

        add(topPanel, BorderLayout.NORTH);
        add(backgroundPanel, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);
        setVisible(true);
    }

    public void runPreSelect(UserAccount useraccount){
        backgroundPanel.removeAll();
        
        JButton button = new JButton("Credit");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Login login = new Login();
                ArrayList<UserAccount> userAccountList = login.getAllUserAccounts();
                for (UserAccount useraccount : userAccountList) {
                    runCredit(useraccount);
                }
            }
        });
        backgroundPanel.add(button);

        repaint();
        setVisible(true);
    }

    public void runCredit(UserAccount useraccount){
        backgroundPanel.removeAll();

        JLabel text = new JLabel("LKASJHDLKASJDHLKSAJD");
        backgroundPanel.add(text);
        
        repaint();
        setVisible(true);
    }
}
