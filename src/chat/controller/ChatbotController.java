package chat.controller;

import chat.view.ChatViewer;
import chat.model.Chatbot;

public class ChatbotController
{
	private Chatbot stupidBot;
	private ChatViewer chatView;

	public ChatbotController()
	{
		stupidBot = new Chatbot("GallupinGallup");
	}

	public void start()
	{
		String response = "talking to you";
		
		while(stupidBot.lengthChecker(response))
		{
			response = chatView.collectResponse("What to talk about today?");
		}
	}
}
