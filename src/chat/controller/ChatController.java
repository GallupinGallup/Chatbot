package chat.controller;

import chat.model.Chatbot;
import chat.view.ChatFrame;
import chat.view.ChatViewer;

public class ChatController
{
	private Chatbot stupidBot;
	private ChatViewer chatView;
	private ChatFrame baseFrame;

	public ChatController()
	{
		stupidBot = new Chatbot("GallupinGallup");
		chatView = new ChatViewer();
		baseFrame = new ChatFrame(this);
	}

	public void start()
	{
		/*
		 * String response =
		 * chatView.collectResponse("What do you want to talk about today????");
		 * 
		 * while(stupidBot.lengthChecker(response)) {
		 * chatView.displayMessage(useChatbotCheckers(response)); response =
		 * chatView.collectResponse("Oh, you are intrested in " + response); }
		 */

	}

	public String useChatbotCheckers(String input)
	{
		String answer = "";
		if (!stupidBot.quitChecker(input))
		{
			

			if (stupidBot.contentChecker(input))
			{
				answer += "\nYou know my special secrete!\n";
			}
			if (stupidBot.memeChecker(input))
			{
				answer += "\nI can has memes?\n";
			}
			if (stupidBot.politicalTopicChecker(input))
			{
				answer += "\nPoop politics\n";
			}
			if (stupidBot.lengthChecker(answer))
			{
				answer += "Sorry, I don't know about " + input;
			}
			int canBeRandom = (int) (Math.random() * 7);
			if (canBeRandom % 7 == 0)
			{
				answer += randomTopicGenerator();
			}
		} else
		{
			chatView.displayMessage("Thank you for chatting with me :D");
			System.exit(0);
		}
		return answer;
	}
	
	private String randomTopicGenerator()
	{
		String randomTopic = "";
		int random = (int)(Math.random() *7);
		
		switch (random)
		{
		case 0:
			randomTopic = "Have you herd about that awesome kid named Tyler Gallup";
			break;
		case 1:
			randomTopic = "Can you bring me some horchata";
			break;
		case 2:
			randomTopic = "Megusta comida";
			break;
		case 3:
			randomTopic = "Como estas?";
			break;
		case 4:
			randomTopic = "Tu mentiri anguis";
			break;
		case 5:
			randomTopic = "obtrucabotu";
			break;
		case 6:
			randomTopic = "tu eres una burro";
			break;
		default:
			randomTopic = "tu eres gorto";
			break;
		
		}
		return randomTopic;
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
