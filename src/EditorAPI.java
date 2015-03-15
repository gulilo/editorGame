import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class EditorAPI
{
	private EditorPanel editor;

	public EditorAPI(EditorPanel editor)
	{
		this.editor = editor;
	}

	public void save()
	{
		JFileChooser chooser = new JFileChooser();
		chooser.setCurrentDirectory(new File("D:\\Projects\\EditorGame\\saves"));
		FileNameExtensionFilter filter = new FileNameExtensionFilter("save file", "sav");
		chooser.addChoosableFileFilter(filter);
		chooser.setFileFilter(filter);
		int res = chooser.showSaveDialog(editor);

		if(res == JFileChooser.APPROVE_OPTION)
		{
			File f = chooser.getSelectedFile();
			try
			{
				f = new File(f.toString() +".sav");
				Map map = editor.getMap();
				ZipEntry entry = new ZipEntry("map.map");
				ZipOutputStream out = new ZipOutputStream(new FileOutputStream(f));
				out.putNextEntry(entry);

				ObjectOutputStream oout = new ObjectOutputStream(out);
				oout.writeObject(map);

				for(int i = 0; i < map.getX(); i++)
				{
					for(int j = 0; j < map.getY(); j++)
					{
						if(map.getTile(i,j).getImage() != null)
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
