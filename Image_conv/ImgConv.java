import java.util.Scanner;
import java.io.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class ImgConv{
	public static void main(String args[]) throws Exception{
		System.out.println("Enter File name :");
		Scanner s= new Scanner(System.in);
		String img_name=s.next();
		System.out.println("File name is :"+img_name);
		BufferedImage img = null;
		try {
		    img = ImageIO.read(new File(img_name));
		    System.out.println("done");
		} catch (IOException ioe) {
			System.out.println("File not found!!");
			ioe.printStackTrace();
		}
		int width = img.getWidth();
        int height = img.getHeight();
        for(int i=0; i<height; i++){
            for(int j=0; j<width; j++){
               Color c = new Color(img.getRGB(j, i));
               int red = (int)(c.getRed() * 0.299);
               int green = (int)(c.getGreen() * 0.587);
               int blue = (int)(c.getBlue() *0.114);
               Color newColor = new Color(red+green+blue,red+green+blue,red+green+blue);
               img.setRGB(j,i,newColor.getRGB());
            }
         }

		ImageIcon icon=new ImageIcon(img);
		JFrame frame=new JFrame();
        frame.setLayout(new FlowLayout());
        frame.setSize(height,width);
        JLabel lbl=new JLabel();
        lbl.setIcon(icon);
        frame.add(lbl);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}