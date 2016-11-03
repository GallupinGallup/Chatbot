package chat.model;

import java.util.ArrayList;

/**
 * Base version of the 2015 Chatbot class. Only stub methods are provided.
 * Students will complete methods as part * of the project. * @author Tyler
 * Tyler Gallup * @version 1.0 10/14/16
 */
public class Chatbot
{ 
	private ArrayList<String> memesList;
	private ArrayList<String> politicalTopicList;
	private String userName;
	private String content;

	/**
	 * * Creates an instance of the Chatbot with the supplied username. * @param
	 * userName The username for the chatbot.
	 */
	public Chatbot(String userName)
	{
		this.memesList = new ArrayList<String>();
		this.userName = new String(userName);
		this.content = new String("Thai food");
		this.politicalTopicList = new ArrayList<String>();
		buildPoliticalTopicsList();
		buildMemesList();
	}

	private void buildMemesList()
	{
		memesList.add("doge");
		memesList.add("cat");
		memesList.add("dat boi");
		memesList.add("willy wonka");
		memesList.add("harambe");
		memesList.add("john cena");
		memesList.add("cute animals");
		memesList.add("grumpy cat");
		memesList.add("dog");
		memesList.add("meme");
		memesList.add("memes");
		memesList.add("food");
		memesList.add("juan");
		memesList.add("sponge bob");
		memesList.add("panda");
		memesList.add("Twenty one");
		memesList.add("gorilla");
		memesList.add("soviet russia");
	}

	private void buildPoliticalTopicsList()
	{
		politicalTopicList.add("Trump");
		politicalTopicList.add("Hillary");
		politicalTopicList.add("Donald");
		politicalTopicList.add("Clinton");
		politicalTopicList.add("Political");
		politicalTopicList.add("President");
		politicalTopicList.add("presidental");
		politicalTopicList.add("Debate");
		politicalTopicList.add("Demicrats");
		politicalTopicList.add("Republicans");
		politicalTopicList.add("liberal");
		politicalTopicList.add("libertarian");
		politicalTopicList.add("Government");
		politicalTopicList.add("China");
		politicalTopicList.add("Putin");
		politicalTopicList.add("Mexico");
		politicalTopicList.add("wall");
		politicalTopicList.add("Deleted emails");
	}

	/**
	 * * Checks the length of the supplied string. Returns false if the supplied
	 * String is empty or null, otherwise returns true. * @param currentInput * @return
	 * A true or false based on the length of the supplied String.
	 */
	public boolean lengthChecker(String currentInput)
	{
		boolean hasLength = false;

		if (currentInput != null && currentInput.length() > 0)
		{
			hasLength = true;
		}
		return hasLength;
	}

	/**
	 * * Checks if the supplied String matches the content area for this Chatbot
	 * instance.
	 * 
	 * @param currentInput
	 *            The supplied String to be checked. * @return Whether it
	 *            matches the content area.
	 */
	public boolean contentChecker(String currentInput)
	{
		boolean contentChecker = false;
		if (currentInput != null && currentInput.contains(content))
		{
			contentChecker = true;
		}
		return contentChecker;
	}

	/**
	 * * Checks if supplied String matches ANY of the topics in the
	 * politicalTopicsList. Returns true if it does find a match and false if it
	 * does not match.
	 * 
	 * @param currentInput
	 *            The supplied String to be checked. * @return Whether the
	 *            String is contained in the ArrayList.
	 */
	public boolean politicalTopicChecker(String currentInput)
	{
		boolean politicalTopicChecker = false;
		for(int posistion = 0; posistion < politicalTopicList.size(); posistion ++)
		{
		if (currentInput != null && currentInput.equalsIgnoreCase(politicalTopicList.get(posistion)))
		{
			politicalTopicChecker = true;
		}
		}
		return politicalTopicChecker;
	}

	/**
	 * * Checks to see that the supplied String value is in the current
	 * memesList variable.
	 * 
	 * @param currentInput
	 *            The supplied String to be checked. * @return Whether the
	 *            supplied String is a recognized meme.
	 */
	public boolean memeChecker(String currentInput)
	{
		boolean memeChecker = false;
		for(int posistion = 0; posistion < memesList.size(); posistion ++)
		{
		if (currentInput != null && currentInput.equalsIgnoreCase(memesList.get(posistion)))
		{
			memeChecker = true;
		}
		}
		return memeChecker;
	}

	/**
	 * * Returns the username of this Chatbot instance. * @return The username
	 * of the Chatbot.
	 */
	public String getUserName()
	{
		return userName;
	}

	/**
	 * * Returns the content area for this Chatbot instance. * @return The
	 * content area for this Chatbot instance.
	 */
	public String getContent()
	{
		return content;
	}

	/**
	 * * Getter method for the memesList object. * @return The reference to the
	 * meme list.
	 */
	public ArrayList<String> getMemesList()
	{
		return memesList;
	}

	/**
	 * * Getter method for the politicalTopicList object. * @return The
	 * reference to the political topic list.
	 */
	public ArrayList<String> getPoliticalTopicList()
	{
		return politicalTopicList;
	}

	/**
	 * * Updates the content area for this Chatbot instance. * @param content
	 * The updated value for the content area.
	 */
	public void setContent(String content)
	{
		this.content = content;
	}

}
