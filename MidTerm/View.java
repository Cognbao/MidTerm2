package MidTerm;
import javax.swing.*;

public class View {
    private JTextArea textArea;

    public View() {
        // Initialize the JTextArea
        textArea = new JTextArea(20, 40);
    }
    public void update(String text) {
        textArea.setText(text);
    }
    // Method to update the text area with text from the model
    public void display(String text) {
        textArea.setText(text);
    }

    // Method to get the current text from the text area
    public String getText() {
        return textArea.getText();
    }

    // Method to get the JTextArea component
    public JTextArea getTextArea() {
        return textArea;
    }
}
