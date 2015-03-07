import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.ArrayList;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class EditorPanel extends JPanel
{
	private Map map;

	public EditorPanel(Dimension size)
	{
		super();
		setSize(size);
		setLayout(null);

		map = new Map(size.width / MapBuild.IMAGE_SIZE , size.height / MapBuild.IMAGE_SIZE);



		MapBuild m = new MapBuild();
		ArrayList<ArrayList<BufferedImage>> images = m.getImages();
		EditorTile[][] map = new EditorTile[size.width / MapBuild.IMAGE_SIZE][size.height / MapBuild.IMAGE_SIZE];
		for(int i = 0; i < map.length; i++)
		{
			for(int j = 0; j < map[0].length; j++)
			{
				map[i][j] = new EditorTile(new Point(i * MapBuild.IMAGE_SIZE, j * MapBuild.IMAGE_SIZE), null);
				add(map[i][j]);
			}
		}
	}

	public void save()
	{
		JFileChooser chooser = new JFileChooser();
		chooser.addChoosableFileFilter(new FileFilter()
		{
			@Override
			public boolean accept(File f)
			{
				return f.isDirectory() || f.getName().contains(".sav");
			}

			@Override
			public String getDescription()
			{
				return null;
			}
		});
		int res = chooser.showSaveDialog(this);

		if(res == JFileChooser.APPROVE_OPTION)
		{
			File f = chooser.getSelectedFile();
			try
			{


				ZipEntry entry = new ZipEntry("map.map");
				ZipOutputStream out = new ZipOutputStream(new FileOutputStream(f));
				out.putNextEntry(entry);

				ObjectOutputStream oout = new ObjectOutputStream(out);
				oout.writeObject(map);

				for(int i = 0; i < map.getX(); i++)
				{
					for(int j = 0; j < map.getY(); j++)
					{

						File file = MapBuild.getFileFromImage(map.getTile(i, j).getImage());
						FileInputStream in = new FileInputStream(file);
						entry = new ZipEntry(file.getName());
						out.putNextEntry(entry);

						byte[] buffer = new byte[1024];
						int len;
						while((len = in.read(buffer)) > 0)
						{
							out.write(buffer, 0, len);
						}
						in.close();

					}
				}
				out.closeEntry();
				out.close();
			}
			catch(FileNotFoundException e)
			{
				e.printStackTrace();
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}
		}
	}
}
