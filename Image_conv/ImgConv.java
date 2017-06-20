import java.util.Scanner;
import java.io.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;    
import javax.swing.JTextField;    
import java.awt.event.*;  

public class ImgConv{
	static BufferedImage img = null;
	public BufferedImage grayscale_fn(BufferedImage img,int width,int height){
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
         return img;
	}
	public static void main(String args[]) throws Exception{
		System.out.println("Enter File name :");
		Scanner s= new Scanner(System.in);
		String img_name=s.next();
		System.out.println("File name is :"+img_name);
		
		try {
		    img = ImageIO.read(new File(img_name));
		    System.out.println("done");
		} catch (IOException ioe) {
			System.out.println("File not found!!");
			ioe.printStackTrace();
		}
		int width= img.getWidth();
        int height = img.getHeight();
        
		
		JFrame frame=new JFrame();
        frame.setLayout(new FlowLayout());
        frame.setSize(height,width);
        JButton b=new JButton("Grayscale");
        JButton c=new JButton("Black and White");
        b.setBounds(50,100,95,30);
        ImageIcon icon=new ImageIcon(img);
        frame.add(b);  
        frame.add(c);
        JLabel lbl=new JLabel();
        lbl.setIcon(icon);
        frame.add(lbl);
        frame.setVisible(true);
        b.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){  
						frame.getContentPane().removeAll();
          				System.out.println("yoo");
          				img= new ImgConv().grayscale_fn(img,width,height);
          				System.out.println("yoo2");
          				frame.remove(lbl);
          				frame.add(b);  
        				frame.add(c);
				        JLabel lbl=new JLabel();
				        lbl.setIcon(icon);
				        frame.add(lbl);
				        frame.setVisible(true);
        				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			        }
			    });
        
        
        
	}
}