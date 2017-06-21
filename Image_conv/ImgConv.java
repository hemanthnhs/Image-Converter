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
	public BufferedImage bwscale_fn(BufferedImage img,int width,int height){
		for(int i=0; i<height; i++){
            for(int j=0; j<width; j++){
               Color c = new Color(img.getRGB(j, i));
               int val= ((int)c.getRed() +(int)c.getRed() +(int)c.getRed())/3; 
               //System.out.println("Colors are"+val);
               int red = val;
               int green = val;
               int blue = val;
               Color newColor = new Color(val,val,val);
               img.setRGB(j,i,newColor.getRGB());
            }
         }
         return img;
	}
	public BufferedImage sepiaScale_fn(BufferedImage img,int width,int height){
		for(int i=0; i<height; i++){
            for(int j=0; j<width; j++){
            	int sepiaDepth = 20;
              int rgb = img.getRGB(j, i);
	            Color color = new Color(rgb, true);
	            int r = color.getRed();
	            int g = color.getGreen();
	            int b = color.getBlue();
	            int gry = (r + g + b) / 3;

	            r = g = b = gry;
	            r = r + (sepiaDepth * 2);
	            g = g + sepiaDepth;

	            if (r > 255) {
	                r = 255;
	            }
	            if (g > 255) {
	                g = 255;
	            }
	            if (b > 255) {
	                b = 255;
	            }

	            // Darken blue color to increase sepia effect
	            //b -= sepiaIntensity;

	            // normalize if out of bounds
	            if (b < 0) {
	                b = 0;
	            }
	            if (b > 255) {
	                b = 255;
	            }

	            color = new Color(r, g, b, color.getAlpha());
	            img.setRGB(j, i, color.getRGB());
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
        JButton d=new JButton("Sepia Tone");
        JButton e=new JButton("Blur");
        b.setBounds(50,100,95,30);
        ImageIcon icon=new ImageIcon(img);
        frame.add(b);  
        frame.add(c);
        frame.add(d);
        
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
        				frame.add(d);
        				
				        JLabel lbl=new JLabel();
				        lbl.setIcon(icon);
				        frame.add(lbl);
				        frame.setVisible(true);
        				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			        }
			    });
        
        c.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){  
						frame.getContentPane().removeAll();
          				System.out.println("yoo");
          				img= new ImgConv().bwscale_fn(img,width,height);
          				System.out.println("yoo2");
          				frame.remove(lbl);
          				frame.add(b);  
        				frame.add(c);
        				frame.add(d);
        				
				        JLabel lbl=new JLabel();
				        lbl.setIcon(icon);
				        frame.add(lbl);
				        frame.setVisible(true);
        				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			        }
			    });
         d.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){  
						frame.getContentPane().removeAll();
          				System.out.println("yoo");
          				img= new ImgConv().sepiaScale_fn(img,width,height);
          				System.out.println("yoo2");
          				frame.remove(lbl);
          				frame.add(b);  
        				frame.add(c);
        				frame.add(d);
        				
				        JLabel lbl=new JLabel();
				        lbl.setIcon(icon);
				        frame.add(lbl);
				        frame.setVisible(true);
        				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			        }
			    });
        
        
        
	}
}