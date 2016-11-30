package chat.view;

import chat.controller.ChatController;
import javax.swing.JFrame;
import java.awt.Dimension;

public class ChatFrame extends JFrame
{
	private ChatController baseController;
	private ChatPanel appPanel;
	
	public ChatFrame(ChatController baseController)
	{
		super();
		this.baseController = baseController;
		this.appPanel = new ChatPanel(baseController);
		
		setupFrame();
	}
	
	public void setupFrame()
	{
		this.setContentPane(appPanel);
		this.setSize(new Dimension(600, 400));
		this.setTitle("such memes");
		this.setVisible(true);
	}
	public ChatPanel getAppPanel()
	{
		return appPanel;
	}
}
