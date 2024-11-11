import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.*;

public class GamePanel extends JPanel implements ActionListener {
    Image bgImage;// Left tree area width=125px ,right tree area width = 235px
    Image PlayerCar;
    Timer timer;
    Timer timer2;
    int x = 220;
    int y = 540;
    int y1 = -680;
    int y2 = 0;
    JLabel player;
    JButton back;
    GameFrame gf;
    int count = 0;
    // Car1 car[] = new Car1[5];
    ArrayList<Car1> car = new ArrayList<Car1>();   

    int i=0;

    GamePanel(GameFrame gf) {
        this.gf = gf;
        setSize(560, 680);
        setLayout(null);
        loadImages();
        loadPlayer();
        controlPlayer();
        moveBg();
        randomCarGenerator();
        backButton();

        setFocusable(true);

    }

    void moveBg() {
        timer = new Timer(30, (a) -> {
            if (y1 == 680)
                y1 = -680;
            y1 += 20;// setSpeed(count);
            if (y2 == 680)
                y2 = -680;
            y2 += 20;// setSpeed(count);
            repaint();

        });
        timer.start();

    }

    void randomCarGenerator() {

        // int speed = setSpeed(count);
        timer2 = new Timer(2500, (a) -> {

            String cars[] = { "./Images/car0.png", "./Images/car1.png", "./Images/car2.png", "./Images/car3.png",
                    "./Images/car4.png", "./Images/car5.png", "./Images/car6.png" };
            int x = (int) (Math.random() * (325 - 125 + 1) + 125);
            String filename = cars[(int) (Math.random() * (6 - 0 + 1) + 0)];
            car.add(new Car1(x,-50,100,100,filename,20,this));
            add(car.get(i));
            i++;


        });
        timer2.start();

    }

    int setSpeed(int count) {
        if (count <= 7) {
            return 5;

        } else if (count > 7 && count <= 14) {
            return 10;
        } else if (count > 14 && count <= 21) {
            return 15;
        } else if (count > 21 && count <= 40) {
            return 15;
        } else {
            return 30;
        }
    }

    void backButton() {
        back = new JButton("BACK");
        back.setBounds(450, 10, 70, 30);
        back.addActionListener(this);
        back.setBackground(Color.white);
        this.add(back);

    }

    public void actionPerformed(ActionEvent ae) {

        gf.dispose();
    }

    void controlPlayer() {

        addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

                if (e.getKeyCode() == KeyEvent.VK_RIGHT) {

                    if (x <= 325) {
                        x = x + 10;
                        player.setLocation(x, y);
                    }
                }
                if (e.getKeyCode() == KeyEvent.VK_LEFT) {

                    if (x >= 125) {
                        x = x - 10;
                        player.setLocation(x, y);
                    }

                }
                if (e.getKeyCode() == KeyEvent.VK_UP) {

                    if (y >= 0) {
                        y = y - 10;
                        player.setLocation(x, y);

                    }

                }
                if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    if (y <= 540) {
                        y = y + 10;
                        player.setLocation(x, y);
                    }

                }

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }

        });
    }

    void loadPlayer() {
        player = new JLabel();
        player.setIcon(new ImageIcon(PlayerCar));
        player.setBounds(x, y, 100, 100);
        add(player);

    }

    void loadImages() {
        try {
            BufferedImage bufferBgImg = ImageIO.read(HomePanel.class.getResource("./Images/roadImg.jpg"));
            bgImage = bufferBgImg.getScaledInstance(560, 680, Image.SCALE_DEFAULT);

            BufferedImage bufferPlayerCarImg = ImageIO.read(HomePanel.class.getResource("./Images/Player1.png"));
            PlayerCar = bufferPlayerCarImg.getScaledInstance(100, 100, Image.SCALE_DEFAULT);

        } catch (Exception e) {
            System.out.println("Image can't find");
        }
    }

    protected void paintComponent(Graphics g) {

        super.paintComponent(g);
        g.drawImage(bgImage, 0, y1, null);
        g.drawImage(bgImage, 0, y2, null);
        // car.paintImage(g);

    }
}
