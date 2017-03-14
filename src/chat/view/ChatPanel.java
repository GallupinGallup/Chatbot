package chat.view;
import chat.controller.ChatController;
import chat.controller.FileController;

import javax.swing.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ChatPanel extends JPanel
{
	private ChatController baseController;
	private SpringLayout baseLayout;
	private JScrollPane chatPane;
	private JTextArea chatDisplay;
	private JTextField chatField;
	private JButton chatButton;
	private JButton loadButton;
	private JButton tButton;
	private JButton hButton;
	private JButton saveButton;
	private JLabel chatLabel;
	private JButton searchTwitterButton;
	private JButton GEOSearchButton;
	private JButton clear;
	
	public ChatPanel(ChatController baseController)
	{
		super();
		baseLayout = new SpringLayout();
		this.baseController = baseController;
		
		chatField = new JTextField(25);
		
		chatButton = new JButton("Chat!");
		
		searchTwitterButton = new JButton("Search twitter!");
		
		clear = new JButton("Clear!");
		
		
		loadButton = new JButton("Random Topic");
		
		tButton = new JButton("Post to twitter!");
		
		chatDisplay = new JTextArea(5, 25);
		chatPane = new JScrollPane(chatDisplay);
		
		hButton = new JButton("HTML");
		
		saveButton = new JButton("Save");
		
		
		chatLabel = new JLabel("Type words here!");
		
		GEOSearchButton = new JButton("Search for tweets near DC!!!");
		
	
		setupChatDisplay();
		setupPanel();
		setupLayout();
		setupListeners();
	}
	private void setupChatDisplay()
	{
		chatDisplay.setEditable(false);
		chatDisplay.setEnabled(false);
		chatDisplay.setLineWrap(true);
		chatDisplay.setWrapStyleWord(true);
	}
	
	private void setupPanel()
	{
		this.setLayout(baseLayout);
		this.setPreferredSize(new Dimension(900, 800));
		this.setBackground(Color.YELLOW);
		this.add(chatButton);
		this.add(chatField);
		this.add(chatLabel);
		this.add(hButton);
		this.add(loadButton);
		this.add(saveButton);
		this.add(tButton);
		this.add(chatPane);
		this.add(searchTwitterButton);
		this.add(GEOSearchButton);
		this.add(clear);
		
	}
	
	private void setupLayout()
	{
		baseLayout.putConstraint(SpringLayout.SOUTH, clear, -89, SpringLayout.NORTH, chatPane);
		baseLayout.putConstraint(SpringLayout.EAST, clear, 0, SpringLayout.EAST, chatButton);
		baseLayout.putConstraint(SpringLayout.NORTH, GEOSearchButton, 10, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.WEST, GEOSearchButton, 10, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.EAST, chatField, -495, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, chatButton, 80, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, chatButton, -323, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.WEST, searchTwitterButton, 204, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, searchTwitterButton, -69, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.EAST, searchTwitterButton, -545, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, chatPane, 332, SpringLayout.NORTH, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, chatPane, -168, SpringLayout.SOUTH, this);
		baseLayout.putConstraint(SpringLayout.SOUTH, chatField, -20, SpringLayout.NORTH, chatPane);
		baseLayout.putConstraint(SpringLayout.WEST, chatPane, 390, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.EAST, chatPane, -10, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, loadButton, 183, SpringLayout.SOUTH, chatField);
		baseLayout.putConstraint(SpringLayout.WEST, loadButton, 112, SpringLayout.WEST, this);
		baseLayout.putConstraint(SpringLayout.EAST, loadButton, -637, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, tButton, 0, SpringLayout.NORTH, searchTwitterButton);
		baseLayout.putConstraint(SpringLayout.WEST, tButton, 164, SpringLayout.EAST, searchTwitterButton);
		baseLayout.putConstraint(SpringLayout.WEST, hButton, 0, SpringLayout.WEST, searchTwitterButton);
		baseLayout.putConstraint(SpringLayout.SOUTH, hButton, -116, SpringLayout.NORTH, chatField);
		baseLayout.putConstraint(SpringLayout.SOUTH, saveButton, -47, SpringLayout.NORTH, chatPane);
		baseLayout.putConstraint(SpringLayout.EAST, saveButton, -36, SpringLayout.EAST, this);
		baseLayout.putConstraint(SpringLayout.NORTH, chatLabel, 36, SpringLayout.SOUTH, chatField);
		baseLayout.putConstraint(SpringLayout.EAST, chatLabel, -104, SpringLayout.WEST, chatPane);
		baseLayout.putConstraint(SpringLayout.NORTH, chatDisplay, 6, SpringLayout.SOUTH, tButton);
		baseLayout.putConstraint(SpringLayout.WEST, chatDisplay, 0, SpringLayout.WEST, chatField);
		
	}
	
	private void setupListeners()
	{
		chatButton.addActionListener(new ActionListener()
		{
			public void actionPerformed (ActionEvent click)
			{
				String userWords = chatField.getText();
				String botResponse = baseController.useChatbotCheckers(userWords);
				String currentText = chatDisplay.getText();
				
				chatDisplay.setText("You said: " + userWords + "\n" + "Chatbot says: " + botResponse + "\n" + currentText);
				chatDisplay.setCaretPosition(chatDisplay.getCaretPosition());
				chatField.setText("");
			}
		});
		
		hButton.addActionListener(new ActionListener()
		{
			public void actionPerformed (ActionEvent click)
			{
				
			}
		});
		
		tButton.addActionListener(new ActionListener()
		{
			public void actionPerformed (ActionEvent click)
			{
				baseController.useTwitter(chatField.getText());
			}
		});
		
		saveButton.addActionListener(new ActionListener()
		{
			public void actionPerformed (ActionEvent click)
			{
				String fileName = chatField.getText();
				
				FileController.saveFile(baseController, fileName.trim(), chatDisplay.getText());
			}
		});
		
		loadButton.addActionListener(new ActionListener()
		{
			public void actionPerformed (ActionEvent click)
			{
				String fileName = chatField.getText() + ".txt";
				String saved = FileController.readFile(baseController, fileName);
				chatDisplay.setText(saved);
			}
		});
		
		searchTwitterButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent click)
			{
				String userName = chatField.getText();
				chatDisplay.append(baseController.searchTwitter(userName));
			}
		});
		GEOSearchButton.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent click)
				{
					String input = chatField.getText();
					chatDisplay.append(baseController.WDCSearch(input));
				}
			});
		clear.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent click)
				{
					chatDisplay.setText("");
				}
			});
	}
}