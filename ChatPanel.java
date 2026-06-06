// =========================
// ChatPanel.java
// =========================

import javax.swing.*;
import java.awt.*;

public class ChatPanel extends JPanel {

    ChatPanel() {

        setLayout(new BoxLayout(this,
                BoxLayout.Y_AXIS));

        setBackground(new Color(40,44,52));
    }

    public void addMessage(String text,
                           boolean isUser) {

        MessageBubble bubble =
                new MessageBubble(text,isUser);

        JPanel wrapper =
                new JPanel(new FlowLayout(
                        isUser ?
                                FlowLayout.RIGHT :
                                FlowLayout.LEFT));

        wrapper.setBackground(
                new Color(40,44,52));

        wrapper.add(bubble);

        add(wrapper);

        revalidate();
        repaint();
    }
}