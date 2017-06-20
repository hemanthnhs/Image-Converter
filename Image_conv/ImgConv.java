import java.util.Scanner;
import java.io.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

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
	}
}