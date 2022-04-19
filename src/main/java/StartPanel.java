import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class StartPanel extends JFrame implements ActionListener {
    ClickerPanel clickerPanel;
    JButton restoreButton;
    JButton gameButton;
    JButton saveButton;
    JPanel startPanel;

    StartPanel(){
        restoreButton = new JButton("Restore progress");
        restoreButton.addActionListener(this);
        saveButton = new JButton("Save progress");
        saveButton.addActionListener(this);
        gameButton = new JButton("START");
        clickerPanel = new ClickerPanel();
        startPanel = new JPanel();

        gameButton.setSize(200,100);
        gameButton.addActionListener(this);
        gameButton.setFocusable(false);
        startPanel.add(gameButton);

        this.setTitle("CLICKER");
        this.setSize(700,700);
        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(new FlowLayout(FlowLayout.CENTER,0,200));
        this.add(startPanel);
        this.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == gameButton){
                changeContent();
        }
        if (e.getSource() == saveButton) {
            try {
                saveProgress();
            } catch (IOException ex) {
                System.out.println("Path not exist");
            }
        }
        if (e.getSource() == restoreButton){
            try {
                readProgress();
            } catch (IOException ex) {
                System.out.println("File not exist");
            }
        }

    }

    public void changeContent() {
        startPanel.remove(gameButton);
        startPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        startPanel.add(saveButton);
        startPanel.add(restoreButton);
        this.add(clickerPanel);
        this.revalidate();
    }

    private void saveProgress() throws IOException {
        File file = new File("src\\main\\java\\save_logs\\save");
        FileWriter writer = new FileWriter(file);
        writer.write("" + clickerPanel.score);
        writer.close();
        this.revalidate();
    }

    private void readProgress() throws IOException {
        File file = new File("src\\main\\java\\save_logs\\save");
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String data = reader.readLine();
        reader.close();
        clickerPanel.score = Integer.parseInt(data);
    }
}
