package com.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ClientGUI extends JFrame {
//    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        MyStompClient myStompClient = new MyStompClient("thinhph");
//        myStompClient.sendMessage(new Message("thinhph", "Hello from client"));
//        myStompClient.disconnectUser("thinhph");
//    }
    JPanel connectedUsersPanel, messagePanel;

    public ClientGUI(String username) {
        super("User: " + username);
        setSize(1218, 685);
        setLocationRelativeTo(null); // Load GUI in the center of the screen.
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int option = JOptionPane.showConfirmDialog(
                        ClientGUI.this,
                        "Are you sure you want to exit?",
                        "Exit",
                        JOptionPane.YES_NO_OPTION);
                if (option == JOptionPane.YES_OPTION) {
                    ClientGUI.this.dispose();
                }
            }
        });

        getContentPane().setBackground(Utilities.PRIMARY_COLOR);
        addGuiComponents();
    }

    void addGuiComponents() {
        addConnectedUsersComponents();
        addChatComponents();
    }

    void addConnectedUsersComponents() {
        connectedUsersPanel = new JPanel();
        connectedUsersPanel.setBorder(Utilities.addPadding(10, 10, 10, 10));
        connectedUsersPanel.setLayout(new BoxLayout(connectedUsersPanel, BoxLayout.Y_AXIS));
        connectedUsersPanel.setBackground(Utilities.SECONDARY_COLOR);
        connectedUsersPanel.setPreferredSize(new Dimension(200, getHeight()));

        JLabel connectedUsersLabel = new JLabel("Connected users: ");
        connectedUsersLabel.setFont(new Font("Inter", Font.BOLD, 18));
        connectedUsersLabel.setForeground(Utilities.TEXT_COLOR);
        connectedUsersPanel.add(connectedUsersLabel);

        add(connectedUsersPanel, BorderLayout.WEST);
    }

    void addChatComponents() {
        JPanel chatPanel = new JPanel();
        chatPanel.setLayout(new BorderLayout());
        chatPanel.setBackground(Utilities.TRANSPARENT_COLOR);
        // chatPanel.setPreferredSize(new Dimension(getWidth() - 200, getHeight()));
        messagePanel = new JPanel();
        messagePanel.setLayout(new BoxLayout(messagePanel, BoxLayout.Y_AXIS));
        messagePanel.setBackground(Utilities.TRANSPARENT_COLOR);
        chatPanel.add(messagePanel, BorderLayout.CENTER);

        JLabel message = new JLabel("Random Message");
        message.setFont(new Font("Inter", Font.BOLD, 18));
        message.setForeground(Utilities.TEXT_COLOR);

        messagePanel.add(message);

        // Add input panel
        JPanel inputPanel = new JPanel();
        inputPanel.setBorder(Utilities.addPadding(10, 10, 10, 10));
        inputPanel.setLayout(new BorderLayout());
        inputPanel.setBackground(Utilities.TRANSPARENT_COLOR);

        JTextField inputField = new JTextField();
        inputField.setBackground(Utilities.SECONDARY_COLOR);
        inputField.setBackground(Utilities.TEXT_COLOR);
        inputField.setFont(new Font("Inter", Font.PLAIN, 18));
        inputField.setPreferredSize(new Dimension(inputPanel.getWidth(), 50));

        inputPanel.add(inputField, BorderLayout.CENTER);
        chatPanel.add(inputPanel, BorderLayout.SOUTH);


        add(chatPanel, BorderLayout.CENTER);
    }
}