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
		chatView = new ChatViewer();
	}

	public void start()
	{
		String response = chatView.collectResponse("What do you want to talk about today????");
		
		while(stupidBot.lengthChecker(response))
		{
			chatView.displayMessage(useChatbotCheckers(response));
			response = chatView.collectResponse("Oh, you are intrested in " + response);
		}
		
	}
	private String useChatbotCheckers(String input)
	{
		String answer = "";
		
		if(stupidBot.contentChecker(input))
		{
			answer += "\nYou know my special secrete!\n";
		}
		if(stupidBot.memeChecker(input))
		{
			answer += "\nI can has memes?\n";
		}
		if(stupidBot.politicalTopicChecker(input))
		{
			answer += "\nPoop politics\n";
		}
		if(answer.length() == 0)
		{
			answer += "Sorry, I don't know about " + input;
		}
		
		
		return answer;
	}
}
