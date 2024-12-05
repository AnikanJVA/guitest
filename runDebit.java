import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class runDebit{
    public runDebit(JFrame window, UserAccount userAccount){
        window.getContentPane().removeAll();
        
        JLabel debitText = new JLabel("Debit Account");
        debitText.setBounds(24, 24, 500, 30);
        debitText.setFont(new Font("Arial", Font.PLAIN, 30));
        window.add(debitText);

        JLabel acountNumText = new JLabel("account number: " + userAccount.getDebitAccountNum());
        acountNumText.setBounds(debitText.getX(), 53, debitText.getWidth(), debitText.getHeight());
        acountNumText.setFont(new Font("Arial", Font.PLAIN, 25));
        window.add(acountNumText);

        JButton withdrawButton = new JButton("Withdraw");
        withdrawButton.setBounds(debitText.getX(), 125, debitText.getWidth(), 38);
        withdrawButton.setFont(new Font("Arial", Font.PLAIN, 20));
        withdrawButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                runWithdraw(window, userAccount);
            }
        });
        window.add(withdrawButton);

        window.repaint();
        window.setVisible(true);
    }

    public void runWithdraw(JFrame window, UserAccount userAccount){
        window.getContentPane().removeAll();

        Balance balanceManager = new Balance();
        Withdraw withdraw = new Withdraw(userAccount.getDebitAccountNum());
        double currentBalance = balanceManager.getCurrentBalance(userAccount.getDebitAccountNum());
        
        JLabel withdrawText = new JLabel("Withdraw");
        withdrawText.setBounds(24, 24, 250, 30);
        withdrawText.setFont(new Font("Arial", Font.PLAIN, 30));
        window.add(withdrawText);

        JLabel currentBalanceLabel = new JLabel("Current Balance: " + currentBalance);
        currentBalanceLabel.setBounds(withdrawText.getX(), 100, 500, 25);
        currentBalanceLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        window.add(currentBalanceLabel);

        JLabel enterAmountLabel = new JLabel("Enter Amount to Withdraw: ");
        enterAmountLabel.setBounds(withdrawText.getX(), 142, 500, 25);
        enterAmountLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        window.add(enterAmountLabel);

        JTextField amounTextField = new JTextField();
        amounTextField.setBounds(withdrawText.getX(), 170, 500, 38);
        window.add(amounTextField);

        JLabel statusLabel = new JLabel("");
        statusLabel.setBounds(withdrawText.getX(), 289, 500, 25);
        statusLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        window.add(statusLabel);

        JButton toWithdrawButton = new JButton("Withdraw");
        toWithdrawButton.setBounds(withdrawText.getX(), 227, amounTextField.getWidth(), 38);
        toWithdrawButton.setFont(new Font("Arial", Font.PLAIN, 20));
        toWithdrawButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    double amount = Double.parseDouble(amounTextField.getText());
                    if(amount <= 0){
                        statusLabel.setText("Withdraw failed. Amount must be greater than 0");
                    }

                    else if(amount > balanceManager.getCurrentBalance(userAccount.getDebitAccountNum())){
                        statusLabel.setText("Withdraw failed. Balance exeeded");
                    }
                    else{
                        withdraw.amountWithdraw(amount);
                        statusLabel.setText("Withdraw successful.");
                        amounTextField.setText("");
                        currentBalanceLabel.setText("Current Balance: " + balanceManager.getCurrentBalance(userAccount.getDebitAccountNum()));
                    }
                }
                catch(Exception err){
                    statusLabel.setText("Withdraw failed. Amount must be a number");
                }
            }
        });
        window.add(toWithdrawButton);

        window.repaint();
        window.setVisible(true);
    }
}