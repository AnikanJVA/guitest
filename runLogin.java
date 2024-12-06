import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class runLogin extends JFrame{
    private JPanel loginFormPanel, backgroundPanel, topPanel, bottomPanel;
    private JLabel title;
    private JTextField usernamTextField;
    private JPasswordField passwordField;
    private JButton loginButton;

    final Dimension top_bottom_border_size = new Dimension(640, 66);
    final Dimension background_size = new Dimension(640, 349);
    final Dimension login_form_size = new Dimension(326, 242);

    public runLogin(){
        setTitle("Banking System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(640, 480);
        setResizable(false);
        setLocationRelativeTo(null);

        topPanel = new JPanel();
        topPanel.setPreferredSize(top_bottom_border_size);
        topPanel.setBackground(new Color(0x032F30));

        backgroundPanel = new JPanel();
        backgroundPanel.setSize(background_size);
        backgroundPanel.setBackground(new Color(0x0C969C));
        backgroundPanel.setLayout(new BorderLayout(0, 0));

        loginFormPanel = new JPanel();
        // loginFormPanel.setBounds(157, 0, 326, 424);
        loginFormPanel.setPreferredSize(login_form_size);
        loginFormPanel.setBackground(Color.WHITE);
        backgroundPanel.add(loginFormPanel, BorderLayout.CENTER);
        // backgroundPanel.add(loginFormPanel);

        bottomPanel = new JPanel();
        bottomPanel.setPreferredSize(top_bottom_border_size);
        bottomPanel.setBackground(new Color(0x032F30));

        add(topPanel, BorderLayout.NORTH);
        add(backgroundPanel, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);
        setVisible(true);
    }

    public static void main(String[] args) {
        new runLogin();
    }
}
