import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class MapBuild
{
	public static final int IMAGE_SIZE = 50;
	private static final int GAP = 5;
	private static Image correntImage;

	private ArrayList<BufferedImage[]> images;

	public MapBuild()
	{
		images = new ArrayList<BufferedImage[]>();
		File[] files = new File("pic").listFiles();
		for(File f : files)
		{
			try
			{
				BufferedImage im = ImageIO.read(f);
				int n = im.getWidth() / IMAGE_SIZE;
				int m = im.getHeight() / IMAGE_SIZE;
				BufferedImage[] bi = new BufferedImage[n * m];
				for(int i = 0; i < m; i++)
				{
					for(int j = 0; j < n; j++)
					{
						int x = j * IMAGE_SIZE + GAP * j;
						int y = i * IMAGE_SIZE + GAP * i;
						bi[j * m + i] = im.getSubimage(x, y, IMAGE_SIZE, IMAGE_SIZE);
					}
				}
				images.add(bi);
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}
		}
	}

	public static Image getCorrentImage()
	{

		return correntImage;
	}

	public static void setCorrentImage(Image correntImage)
	{
		MapBuild.correntImage = correntImage;
	}

	public ArrayList<BufferedImage[]> getImages()
	{
		return images;
	}


	public static File getFileFromName(Image image)
	{
		return null;
	}
}
