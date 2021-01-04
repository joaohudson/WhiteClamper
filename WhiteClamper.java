import java.awt.image.*;
import java.io.*;
import javax.imageio.ImageIO;

public class WhiteClamper{
	public static void main(String[] args) throws Exception{
		
		if(args.length == 0){
			System.err.println("Digite o nome da imagem!");
			return;
		}
		
		BufferedImage img = ImageIO.read(new File(args[0]));
		
		WritableRaster wr = img.getRaster();
		double[] color = new double[4];
		
		for(int x = 0; x < img.getWidth(); x++){
			for(int y = 0; y < img.getHeight(); y++){
				
				wr.getPixel(x, y, color);
				if(color[0] == color[1] && color[1] == color[2] && color[2] == 255f){
					color[3] = 0f;
				}
				wr.setPixel(x, y, color);
			}
		}
		
		ImageIO.write(img, "png", new File(args.length == 1 ? "out" : args[1]));
	}
}