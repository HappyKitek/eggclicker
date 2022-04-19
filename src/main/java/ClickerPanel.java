import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class ClickerPanel extends JPanel implements MouseListener {
    int score = 0;
    JLabel jajo;

    public ClickerPanel() {
        jajo = new JLabel();
        jajo.setLocation(250,250);
        jajo.setFont(new Font("MV Boli",Font.PLAIN,20));
        jajo.setHorizontalTextPosition(JLabel.CENTER);
        jajo.setVerticalTextPosition(JLabel.TOP);
        jajo.setText("Score: " + score);
        ImageIcon jajoImage = new ImageIcon("C:\\Users\\Kosma\\Desktop\\java programowanie\\eggclicker\\src\\main\\java\\jajo.jpg");
        jajo.setBounds(400,600,200,300);
        jajo.setIcon(jajoImage);

        this.setLayout(new GridLayout(1,1));
        this.addMouseListener(this);
        this.add(jajo);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (jajo.contains(e.getPoint())) {
            score ++;
            jajo.setText("Score: "+ score);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
