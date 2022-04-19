import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartPanel extends JFrame implements ActionListener {
    ClickerPanel clickerPanel;
    JButton gameButton;
    JButton save;
    JPanel startPanel;

    StartPanel(){
        save = new JButton("Save progress");
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
        if (e.getSource() == save){
            
        }
    }

    public void changeContent() {
        startPanel.remove(gameButton);
        startPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        startPanel.add(save);
        this.add(clickerPanel);
        this.revalidate();

    }
}
