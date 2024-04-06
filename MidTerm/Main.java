package MidTerm;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;

// Main class with GUI
public class Main {
    public static void main(String[] args) {
        // Create the Model, View, and Controller
        Model model = new Model();
        View view = new View();
        Controller controller = new Controller(model, view);

        // Create the GUI components
        JFrame frame = new JFrame("Simple Notepad");
        JTextArea textArea = new JTextArea(20, 40);
        JScrollPane scrollPane = new JScrollPane(textArea);
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("File");
        JMenuItem openItem = new JMenuItem("Open");
        JMenuItem saveItem = new JMenuItem("Save");

        // Add action listeners for menu items
        openItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                    File file = fileChooser.getSelectedFile();
                    try {
                        controller.loadFromFile(file);
                        textArea.setText(model.getText());
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });

        saveItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                if (fileChooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
                    File file = fileChooser.getSelectedFile();
                    try {
                        controller.saveToFile(file);
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });

        // Add components to the frame
        fileMenu.add(openItem);
        fileMenu.add(saveItem);
        menuBar.add(fileMenu);
        frame.setJMenuBar(menuBar);
        frame.add(scrollPane);
        frame.setSize(500, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
