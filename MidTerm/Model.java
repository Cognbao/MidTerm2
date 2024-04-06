package MidTerm;
import java.io.*;
import java.util.*;

// Model
public class Model {
    private String text;

    // Constructor
    public Model() {
        text = ""; // Initialize with empty text
    }

    // Getter method to retrieve the text data
    public String getText() {
        return text;
    }

    // Setter method to update the text data
    public void setText(String newText) {
        text = newText;
    }
    private List<String> lines = new ArrayList<>();

    public void addLine(String line) {
        lines.add(line);
    }

    public List<String> getLines() {
        return lines;
    }

    public void loadFromFile(File file) throws IOException {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        }
    }

    public void saveToFile(File file) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            for (String line : lines) {
                writer.write(line);
                writer.newLine();
            }
        }
    }
}