// =========================
// ChatbotLogic.java
// =========================

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Random;

public class ChatbotLogic {

    Random random = new Random();

    HashMap<String, String> faq =
            Imp.getFAQData();

    public String getResponse(String message) {

        message = message.toLowerCase();

        if(message.contains("hello")
                || message.contains("hi")) {

            String[] replies = {
                    "Hello 👋",
                    "Hi there!",
                    "Welcome!",
                    "Nice to meet you!"
            };

            return replies[
                    random.nextInt(
                            replies.length)];
        }

        else if(message.contains("time")) {

            DateTimeFormatter format =
                    DateTimeFormatter
                            .ofPattern("hh:mm a");

            return "Current time is "
                    + LocalTime.now()
                    .format(format);
        }

        else if(message.contains("bye")) {

            return "Goodbye 👋";
        }

        // FAQ System
        else if(faq.containsKey(message)) {

            return faq.get(message);
        }

        else {

            return "Sorry, I don't understand.";
        }
    }
}