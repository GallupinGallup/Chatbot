package chat.controller;

import chat.model.Chatbot;
import chat.view.ChatFrame;

public class ChatController
{
	private Chatbot stupidBot;
	//private ChatViewer chatView;
	private ChatFrame baseFrame;

 	public ChatController()
	{
		stupidBot = new Chatbot("GallupinGallup");
		//chatView = new ChatViewer();
		baseFrame = new ChatFrame(this);
	}

	public void start()
	{
		/*
		 * String response = chatView.collectResponse("What do you want to talk about today????");
		
		while(stupidBot.lengthChecker(response))
		{
			chatView.displayMessage(useChatbotCheckers(response));
			response = chatView.collectResponse("Oh, you are intrested in " + response);
		}
		 */
		
	}
	
	public String useChatbotCheckers(String input)
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
		if(stupidBot.lengthChecker(answer))
		{
			answer += "Sorry, I don't know about " + input;
		}
		
		
		return answer;
	}

	public Object getBaseFrame()
	{
		// TODO Auto-generated method stub
		return baseFrame;
	}

	public Chatbot getChatbot()
	{
		// TODO Auto-generated method stub
		return stupidBot;
	}
	
}
