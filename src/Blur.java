//Name: Dillon Sheppard
//Testing: there are two pictures in the res folder, but the program is not limited to those pictures
//you can browse any folder on your computer!
//Date: 10/25/20

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;
import java.io.File;


public class Blur {
    public static JFrame frame;
    public static File file;
    public static JPanel mid;
    public static final int w = 5;
    public static final int h = 5;
    // sigma aka k is the value that the user chooses and the value that differentiates
    public static float k;
    public static JLabel imgHold;
    public static BufferedImage read;


    public static void main(String[] args)
    {
        frame = new JFrame("Blur");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
        ImgBlur();
    }

    public static void ImgBlur()
    {
        //the program prompts the user for a file, first.
        int response;
        JFileChooser chooser = new JFileChooser(".");

        chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        response = chooser.showOpenDialog(null);

        if(response == JFileChooser.APPROVE_OPTION)
        {
            try{
                file = chooser.getSelectedFile();
                read = ImageIO.read(file);
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }

        //JPanels for the reset button, sigma values, quit and file reader
        JPanel top = new JPanel();
        mid = new JPanel();
        imgHold = new JLabel();
        JPanel bot = new JPanel();
        JButton quit = new JButton("Quit");
        JButton reset = new JButton("Reset");
        JButton newImg = new JButton("Browse");
        JButton one = new JButton("1.0");
        JButton oneHalf = new JButton("1.5");
        JButton two = new JButton("2.0");
        JButton twoHalf = new JButton("2.5");
        JButton three = new JButton("3.0");

        //add top buttons
        top.add(one);
        top.add(oneHalf);
        top.add(two);
        top.add(twoHalf);
        top.add(three);
        frame.add(top, BorderLayout.NORTH);
        frame.repaint();

        //add bottom buttons
        bot.add(quit);
        bot.add(reset);
        bot.add(newImg);
        frame.add(bot, BorderLayout.SOUTH);
        frame.repaint();

        //display image
        imgHold.setIcon(new ImageIcon(read));
        mid.add(imgHold);
        frame.add(mid, BorderLayout.CENTER);
        frame.revalidate();
        frame.repaint();

        //quit button Listener
        quit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        //reset button listener
        reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mid.removeAll();
                imgHold.setIcon(new ImageIcon(read));
                mid.add(imgHold);
                mid.revalidate();
                mid.repaint();
            }
        });

        //one button listener
        one.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                k = 1f;
                float f[] = new float[w * h];
                for(int i = 0; i < f.length; i++)
                {
                    f[i] = k / (w*h);
                }

                Kernel kern = new Kernel(h, w, f);
                ConvolveOp convolveOp = new ConvolveOp(kern);
                BufferedImage filter = convolveOp.filter(read, null);

                //display image
                mid.removeAll();
                mid.repaint();
                imgHold.setIcon(new ImageIcon(filter));
                mid.add(imgHold);
                mid.revalidate();
            }
        });

        // 1.5 button listener
        oneHalf.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                k = 1.5f;
                float f[] = new float[w * h];
                for(int i = 0; i < f.length; i++)
                {
                    f[i] = k / (w*h);
                }

                Kernel kern = new Kernel(h, w, f);
                ConvolveOp convolveOp = new ConvolveOp(kern);
                BufferedImage filter = convolveOp.filter(read, null);

                //display image
                mid.removeAll();
                mid.repaint();
                imgHold.setIcon(new ImageIcon(filter));
                mid.add(imgHold);
                mid.revalidate();
            }
        });

        //two button listener
        two.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                k = 2f;
                float f[] = new float[w * h];
                for(int i = 0; i < f.length; i++)
                {
                    f[i] = k / (w*h);
                }

                Kernel kern = new Kernel(h, w, f);
                ConvolveOp convolveOp = new ConvolveOp(kern);
                BufferedImage filter = convolveOp.filter(read, null);

                //display image
                mid.removeAll();
                mid.repaint();
                imgHold.setIcon(new ImageIcon(filter));
                mid.add(imgHold);
                mid.revalidate();
            }
        });

        //2.5 button listener
        twoHalf.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                k = 2.5f;
                float f[] = new float[w * h];
                for(int i = 0; i < f.length; i++)
                {
                    f[i] = k / (w*h);
                }

                Kernel kern = new Kernel(h, w, f);
                ConvolveOp convolveOp = new ConvolveOp(kern);
                BufferedImage filter = convolveOp.filter(read, null);

                //display image
                mid.removeAll();
                mid.repaint();
                imgHold.setIcon(new ImageIcon(filter));
                mid.add(imgHold);
                mid.revalidate();
            }
        });

        //3 button listener
        three.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                k = 3f;
                float f[] = new float[w * h];
                for(int i = 0; i < f.length; i++)
                {
                    f[i] = k / (w*h);
                }

                Kernel kern = new Kernel(h, w, f);
                ConvolveOp convolveOp = new ConvolveOp(kern);
                BufferedImage filter = convolveOp.filter(read, null);

                //display image
                mid.removeAll();
                mid.repaint();
                imgHold.setIcon(new ImageIcon(filter));
                mid.add(imgHold);
                mid.revalidate();
            }
        });

        //browse for a new image
        newImg.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //the program prompts the user for a file, first.
                int response;
                JFileChooser chooser = new JFileChooser(".");

                chooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
                response = chooser.showOpenDialog(null);

                if(response == JFileChooser.APPROVE_OPTION)
                {
                    try{
                        file = chooser.getSelectedFile();
                        read = ImageIO.read(file);
                    }
                    catch (Exception a)
                    {
                        a.printStackTrace();
                    }
                }

                //place new image on mid JPanel
                mid.removeAll();
                mid.repaint();
                imgHold.setIcon(new ImageIcon(read));
                mid.add(imgHold);
                mid.revalidate();

            }
        });

    }


}
