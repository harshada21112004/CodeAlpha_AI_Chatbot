// =========================
// ChatbotUI.java
// =========================

import javax.swing.*;
import java.awt.*;

public class ChatbotUI extends JFrame {

    ChatPanel chatPanel;
    JTextField inputField;
    JButton sendButton;

    ChatbotLogic bot = new ChatbotLogic();

    ChatbotUI() {

        setTitle("AI Assistant Chatbot");
        setSize(500, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Header
        JPanel topPanel = new JPanel();
        topPanel.setBackground(new Color(0,120,215));
        topPanel.setPreferredSize(new Dimension(500,70));

        JLabel title = new JLabel("AI Assistant");
        title.setForeground(Color.WHITE);
        title.setFont(new Font("Segoe UI", Font.BOLD, 24));

        topPanel.add(title);

        // Chat Panel
        chatPanel = new ChatPanel();

        JScrollPane scrollPane =
                new JScrollPane(chatPanel);

        scrollPane.setBorder(null);

        // Bottom Panel
        JPanel bottomPanel =
                new JPanel(new BorderLayout());

        bottomPanel.setBackground(
                new Color(30,30,30));

        inputField = new JTextField();
        inputField.setFont(
                new Font("Segoe UI",
                        Font.PLAIN,16));

        sendButton = new JButton("Send");

        sendButton.setBackground(
                new Color(0,120,215));

        sendButton.setForeground(Color.WHITE);

        sendButton.setFocusPainted(false);

        bottomPanel.add(inputField,
                BorderLayout.CENTER);

        bottomPanel.add(sendButton,
                BorderLayout.EAST);

        // Add Components
        add(topPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);

        // Welcome Message
        chatPanel.addMessage(
                "Hello 👋 Welcome!",
                false);

        chatPanel.addMessage(
                "How can I help you today?",
                false);

        // Button Action
        sendButton.addActionListener(e -> sendMessage());

        inputField.addActionListener(e -> sendMessage());

        setVisible(true);
    }

    // Send Message
    private void sendMessage() {

        String text =
                inputField.getText().trim();

        if(text.isEmpty()) {
            return;
        }

        // User Message
        chatPanel.addMessage(text,true);

        // Bot Reply
        String reply =
                bot.getResponse(text);

        chatPanel.addMessage(reply,false);

        // Save Chat
        ChatHistory.saveChat(
                "You: " + text);

        ChatHistory.saveChat(
                "Bot: " + reply);

        inputField.setText("");

        revalidate();
    }
}