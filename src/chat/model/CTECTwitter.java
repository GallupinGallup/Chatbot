package chat.model;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import chat.controller.ChatController;
import twitter4j.Paging;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;


public class CTECTwitter 
{
	private ChatController baseController;
	private Twitter twitterBot;
	private List<String> tweetedWords;
	private List<Status> allTheTweets;

	
	public CTECTwitter(ChatController baseController)
	{
		this.baseController = baseController;
		tweetedWords = new ArrayList<String>();
		allTheTweets = new ArrayList<Status>();
		twitterBot = TwitterFactory.getSingleton();
	}
	
	public void sendTweet(String textToTweet)
	{
		try
		{
			twitterBot.updateStatus(textToTweet + "@ChatbotCTEC");
		}
		catch(TwitterException tweetError)
		{
			baseController.handleErrors(tweetError);
		}
		catch(Exception otherError)
		{
			baseController.handleErrors(otherError);
		}
	}
	
	private String [] createIgnoredWordsArray()
	{
		String[] boringWords;
		int wordCount = 0;
		
		Scanner boringWordScanner = new Scanner(this.getClass().getResourceAsStream("commonWords.txt"));
		while(boringWordScanner.hasNextLine())
		{
			wordCount++;
		}
		boringWordScanner.close();
		
		boringWords = new String[wordCount];
		
		boringWordScanner = new Scanner(this.getClass().getResourceAsStream("commonWords.txt"));
		
		for(int index = 0; index < boringWords.length; index++)
		{
			boringWords[index] = boringWordScanner.next();
		}
		boringWordScanner.close();
		
		return null;
	}
	
	private void collectTweets(String userName)
	{
		
	}
	
	public String getMostPopularWord(String userName)
	{
		this.gatherTheTweets(userName);
		this.turnTweetsToWords();
		this.turnTweetsToWords();
		this.removeBoringWords();
		this.removeBlankWords();
		
		String information = "The tweetcount is " + allTheTweets.size() + "and the word count after removal is " + tweetedWords.size();
		
		return information;
	}
	
	private void removeBoringWords()
	{
		String [] boringWords = createIgnoredWordsArray();
		
		for(int index = 0; index <tweetedWords.size(); index++)
		{
			for(int boringIndex = 0; boringIndex < boringWords.length; boringIndex++)
			{
				tweetedWords.remove(index);
				index--;
				boringIndex = boringWords.length;
			}
		}
	}
	
	private void turnTweetsToWords()
	{
		for(Status currentTweet : allTheTweets)
		{
			String text = currentTweet.getText();
			String [] tweetWords = text.split(" ");
			for(String word : tweetWords)
			{
				tweetedWords.add(word);
			}
		}
	}
	
	private void removeBlankWords()
	{
		for(int index = 0; index < tweetedWords.size(); index++)
		{
			if(tweetedWords.get(index).trim().equals(""))
			{
				tweetedWords.remove(index);
				index--;
			}
		}
	}
	
	private void gatherTheTweets(String user)
	{
		tweetedWords.clear();
		allTheTweets.clear();
		int pageCount = 1;
		
		Paging statusPage = new Paging(1, 200);
		
		while(pageCount <= 10)
		{
			try {
				allTheTweets.addAll(twitterBot.getUserTimeline(user, statusPage));
			} catch (TwitterException twitterError) {
				baseController.handleErrors(twitterError);
			}
			pageCount++;
		}
	}
	
	private String calucalteTopWord()
	{
		String results = "" ;
		String topWord = ";";
		int mostPopularIndex = 0;
		int popularCount = 0;
		
		
		for (int index = 0; index< tweetedWords.size(); index++)
		{
			int currentPopularity = 0;
			for (int searched = index + 1; searched < tweetedWords.size(); searched++)
			{
				if(tweetedWords.get(index).equalsIgnoreCase(tweetedWords.get(searched)))
				{
					currentPopularity++;
				}
				
			}
			if(currentPopularity > popularCount)
			{
				popularCount = currentPopularity;
				mostPopularIndex = index;
				topWord = tweetedWords.get(mostPopularIndex);
			}
		}
		results += " the mo0st popular wors was " + topWord + ", and it occurend " + popularCount + " times.";
		results += "\nThat means it has a percentage of " + ((double)popularCount)/tweetedWords.size() + "%";
		return results;
	}
}