import java.util.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] htmlSentences = (br.readLine()).split("<");
        for (int i=0; i<htmlSentences.length; i++) {
            String sentence = htmlSentences[i];
            // System.out.println("<" + sentence);
            if (sentence.length() == 0) continue;
            else if (sentence.contains("main>")) continue;
            else if (sentence.startsWith("div")) {
                String[] titleSentence = sentence.split("title=");
                if (titleSentence.length > 1) System.out.println("title : " + titleSentence[1].split("\"")[1]);
                if (i+1 == htmlSentences.length) break;
                sentence = htmlSentences[++i];
                String printSentense = "";
                while (!sentence.equals("/div>")) {
                    if (sentence.startsWith("/")) {
                        if (sentence.equals("/p>")) {
                            printSentense = printSentense.trim();
                            while (printSentense.contains("  ")) printSentense = printSentense.replace("  ", " ");
                            System.out.println(printSentense);
                            printSentense = "";
                        } else {
                            if (sentence.split(">").length > 1) printSentense = printSentense + sentence.split(">")[1];
                        }
                    } else if (sentence.contains(">")) {
                        if (sentence.split(">").length > 1) printSentense = printSentense + sentence.split(">")[1];
                    }
                    
                    sentence = htmlSentences[++i];
                }
            }
        }
    }
}