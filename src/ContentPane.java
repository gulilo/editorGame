import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ContentPane extends BasicPanel
{
	private static Point EDITOR_LOCATION = new Point(0, 0);

	public ContentPane(Point loc, Dimension size)
	{
		super(loc, size);

		setBackground(new Color(152,125,0));

		EditorPanel editor = new EditorPanel(EDITOR_LOCATION, new Dimension(size.width - (size.width * 20 / 100), size.height - (size.height * 20 / 100)));
		add(editor);

		Point selectLocation = new Point(editor.getSize().width + 20, 0);
		SelectPanel select = new SelectPanel(selectLocation,new Dimension(size.width - selectLocation.x,editor.getSize().height));
		add(select);

		JButton save = new JButton("Save");
		save.setSize(100,50);
		save.setLocation(0,size.height - save.getSize().height-40);
		save.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e)
			{
				EditorPanel.API.save();
			}
		});
		add(save);

	}
}
