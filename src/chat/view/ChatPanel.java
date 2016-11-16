package chat.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpringLayout;

import chat.controller.ChatController;

public class ChatPanel extends JPanel
{
	private ChatController baseController;
	private SpringLayout baseLayout;
	private JTextArea chatDisplay;
	private JTextField chatField;
	private JButton chatButton;
	private JLabel imageLabel;

	public ChatPanel(ChatController baseController)
	{
		super();
		this.baseController = baseController;
		this.baseLayout = new SpringLayout();
		chatDisplay = new JTextArea(5, 25);
		chatField = new JTextField(25);
		chatButton = new JButton("Chat with the bot");
		baseLayout.putConstraint(SpringLayout.SOUTH, chatButton, -71, SpringLayout.NORTH, chatField);
		imageLabel = new JLabel(new ImageIcon(getClass().getResource("images/chatbot.png")));
		
		setupChatDisplay();
		setupPanel();
		setupLayout();
		setupListeners();
	}

	private void setupChatDisplay()
	{
		chatDisplay.setEditable(false);
		chatDisplay.setLineWrap(true);
		chatDisplay.setWrapStyleWord(true);
		chatDisplay.setEnabled(false);
	}

	private void setupPanel()
	{
		this.setLayout(baseLayout);
		this.setBackground(Color.GREEN);
		this.add(chatDisplay);
		this.add(chatButton);
		this.add(chatField);
		this.add(imageLabel);
	}

	private void setupLayout()
	{
		baseLayout.putConstraint(SpringLayout.WEST, chatDisplay, 75, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, chatDisplay, 27, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, chatField, 68, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, chatField, -47, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, chatButton, 148, SpringLayout.WEST, this);
	}

	private void setupListeners()
	{
		chatButton.addActionListener(new ActionListener()
		{
			@Override
			public void actionPerformed(ActionEvent e)
			{
				String userWords = chatField.getText();
				String botResponse = baseController.useChatbotCheckers(userWords);
				chatField.setText("");
				chatDisplay.setText("yousaid: " + userWords + "\n" + "Chatbot said " + botResponse);
			}
		});
	}
}
