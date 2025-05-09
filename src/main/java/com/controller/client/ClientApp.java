package com.controller.client;

import com.view.ClientGUI;

import javax.swing.*;

public class ClientApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            ClientGUI clientGUI = new ClientGUI("thinhph");
            clientGUI.setVisible(true);
        });
    }
}
