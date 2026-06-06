// =========================
// Imp.java
// =========================

import java.util.HashMap;

public class Imp {

    public static HashMap<String, String> getFAQData() {

        HashMap<String, String> faq = new HashMap<>();

        faq.put("what is ai",
                "AI means Artificial Intelligence.");

        faq.put("what is sql",
                "SQL is used for databases.");

        faq.put("what is java",
                "Java is a programming language.");

        return faq;
    }
}