package chat.model;

import chat.controller.ChatController;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;

public class CTECTwitter {
	
	private ChatController baseController;
	private Twitter twitterBot;
	
	public CTECTwitter(ChatController baseController){
		this.baseController = baseController;
		this.twitterBot = TwitterFactory.getSingleton();
	}
	
	public void sendTweet(String textToTweet){
		try{
			twitterBot.updateStatus("I Jacob Peterson just tweeted from my Java Chatbot program 2017! "
					+ "#APCSRocks @CTECNow Thanks @cscheerleader & @codyhenrichsen! @ChatbotCTEC");
		}catch(TwitterException tweetError){
			baseController.handleErrors(tweetError);
		}catch(Exception e){
			baseController.handleErrors(e);
		}
	}
}