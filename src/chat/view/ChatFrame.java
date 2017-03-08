package chat.view;
import chat.controller.ChatController;
import javax.swing.*;
import java.awt.Dimension;
public class ChatFrame extends JFrame
{
		private ChatController baseController;
		private ChatPanel basePanel;
		
		public ChatFrame (ChatController baseController)
		{
			super();
			this.baseController = baseController;
			basePanel = new ChatPanel(baseController);
			
			setupFrame();
		}
		
		private void setupFrame()
		{
			this.setContentPane(basePanel);
			this.setTitle("This is a htaiosgjap;dshiuyopgjlnadfgs");
			this.setSize(new Dimension(900, 900));
			this.setResizable(true);
			this.setVisible(true);
			
		}
	
}