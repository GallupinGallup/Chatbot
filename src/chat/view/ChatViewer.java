package chat.view;

import javax.swing.JOptionPane;
import javax.swing.ImageIcon;

/**
 * Popup display class for GUI interaction in the Chatbot project.
 * @author tgal3078
 * @version 1.1 added constructior
 */

public class ChatViewer
{
	private String windowMessage;
	private ImageIcon chatIcon;
	public ChatViewer()
	{
		windowMessage = "This message brought to you be the chatbot! :D";
		chatIcon = new ImageIcon(getClass().getResource("images/chatbot.png"));
	}

	/**
	 * displays a GUI popup for collection user text with the supplied String.
	 * Usually in the form of a questions to collect for further use in the program.
	 * @param displayText The text to show in the popup window. Should be a question
	 * @return The text supplied by the user.
	 */
	public String collectResponse(String question)
	{
		String response = "";

		response = JOptionPane.showInputDialog(null, question, windowMessage,
												JOptionPane.INFORMATION_MESSAGE, chatIcon, null,
												"Type here please").toString();

		return response;
	}

	/**
	 * Displays a String to the user with a standard popup.
	 * @param displayText The supplied text to be displayed.
	 */

	public int collectUserOption(String question)
	{
		int response = 0;

		response = JOptionPane.showConfirmDialog(null, question);

		return response;
	}

	public void displayMessage(String Message)
	{
		JOptionPane.showMessageDialog(null, Message);
	}
}
