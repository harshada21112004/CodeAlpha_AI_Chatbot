// =========================
// MessageBubble.java
// =========================

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class MessageBubble extends JPanel {

    MessageBubble(String message,
                  boolean isUser) {

        setLayout(new BorderLayout());

        JLabel label =
                new JLabel("<html><p style='width:200px'>"
                        + message +
                        "</p></html>");

        label.setFont(
                new Font("Segoe UI",
                        Font.PLAIN,16));

        label.setForeground(Color.WHITE);

        setBorder(new EmptyBorder(
                10,15,10,15));

        add(label);

        if(isUser) {

            setBackground(
                    new Color(0,120,215));
        }

        else {

            setBackground(
                    new Color(60,63,65));
        }
    }
}