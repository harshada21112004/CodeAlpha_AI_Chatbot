// =========================
// ChatHistory.java
// =========================

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

public class ChatHistory {

    public static void saveChat(
            String message) {

        try {

            FileWriter writer =
                    new FileWriter(
                            "chat_history.txt",
                            true);

            writer.write(
                    "[" +
                    LocalDateTime.now()
                    + "] "
                    + message + "\n");

            writer.close();
        }

        catch(IOException e) {

            System.out.println(
                    "Error saving chat.");
        }
    }
}