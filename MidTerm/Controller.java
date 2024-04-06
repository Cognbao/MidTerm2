package MidTerm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Controller {
    private Model model;
    private View view;

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    // Method to load text from a file into the model
    public void loadFromFile(File file) throws IOException {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
        }
        model.setText(content.toString());
        view.update(model.getText());
    }

    // Method to save text from the model into a file
    public void saveToFile(File file) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write(model.getText());
        }
    }

    // Method to update the view based on the model's state
    public void updateView() {
        view.display(model.getText());
    }
}
