import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class MapBuild
{
	public static final int IMAGE_SIZE = 50;
	private static Image correntImage;

	private static ArrayList<ArrayList<BufferedImage>> images;
	private static ArrayList<ArrayList<File>> files;

	public MapBuild()
	{
		this.files = new ArrayList<ArrayList<File>>();
		images = new ArrayList<ArrayList<BufferedImage>>();
		File[] files = new File("pic").listFiles();
		if(files == null)
		{
			//TODO what heppen when pic not exist
		}
		else
		{
			int index = 0;
			for(File f : files)
			{
				if(f.isDirectory())
				{
					index++;
					ArrayList<File> dir = new ArrayList<File>();
					this.files.add(dir);
					ArrayList<BufferedImage> bi = new ArrayList<BufferedImage>();
					images.add(bi);
					File[] pics = f.listFiles();
					for(File file : pics)
					{
						dir.add(file);
						try
						{
							bi.add(ImageIO.read(file));
						}
						catch(IOException e)
						{
							e.printStackTrace();
						}
					}
				}
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

	public ArrayList<ArrayList<BufferedImage>> getImages()
	{
		return images;
	}

	public static File getFileFromImage(Image im)
	{
		for(int i = 0;i<images.size();i++)
		{
			for(int j = 0; j < images.get(i).size(); j++)
			{
				if(images.get(i).get(j) == im)
				{
					return files.get(i).get(j);
				}
			}
		}
		return null;
	}
}
