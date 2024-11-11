
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.swing.*;
import javax.imageio.ImageIO;

public class Car  {
    int x;
    int y;
    int h;
    int w;
    int speed;
    Image image;
    String fileName;
    Timer timer;
    GamePanel gp;


    Car(int x, int y, int h, int w, String fileName, int speed,GamePanel gp) {
        this.gp = gp;
        this.x = x;
        this.y = y;
        this.h = h;
        this.w = w;
        this.fileName = fileName;
        this.speed = speed;
        loadBgImage();
        move();
    }

    void loadBgImage() {
        try {
            BufferedImage bufferImg = ImageIO.read(GamePanel.class.getResource(fileName));
            image = bufferImg.getScaledInstance(w, h, Image.SCALE_DEFAULT);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    void paintImage(Graphics pen) {
        pen.drawImage(image, x, y, w, h, null);
    }

    void move() {
       timer = new Timer(50, (a)->{
        y =y+speed;
        gp.repaint();

       });
       timer.start();
    }
}