import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

public class ImageMover extends JPanel implements ActionListener {
    private Image image;
    private int x = 0, y = 0;
    private Timer timer;

    public ImageMover() {
        try {
            URL url = new URL("https://e7.pngegg.com/pngimages/624/18/png-clipart-cute-little-star-little-stars-star-thumbnail.png");
            image = new ImageIcon(url).getImage();
        } catch (Exception e) {
            e.printStackTrace();
        }
        timer = new Timer(10, this); // Таймер с интервалом 10 миллисекунд
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, x, y, this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        x += 1;
        y += 1;
        if (x > getWidth() || y > getHeight()) {
            x = 0;
            y = 0;
        }
        repaint();
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Image Mover");
        ImageMover imageMover = new ImageMover();
        frame.add(imageMover);
        frame.setSize(600, 600); // Размер панели
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}

