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
		this.userName = userName;
		this.content = new String("Thai food");
		this.politicalTopicList = new ArrayList<String>();
		buildPoliticalTopicsList();
		buildMemesList();
	}

	/**
	 * Adds a list of memes so that the chatbot will know when people are
	 * talking about memes.
	 */

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
		memesList.add("meme");
		memesList.add("memes");
		memesList.add("food");
		memesList.add("juan");
		memesList.add("sponge bob");
		memesList.add("panda");
		memesList.add("Twenty one");
		memesList.add("gorilla");
		memesList.add("soviet russia");
		memesList.add("chuck noris");
	}

	/**
	 * Adds a list of Political words so that the chatbot will know when people
	 * are talking about Political stuff.
	 */
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
		politicalTopicList.add("Democrat");
		politicalTopicList.add("Republican");
		politicalTopicList.add("liberal");
		politicalTopicList.add("libertarian");
		politicalTopicList.add("Government");
		politicalTopicList.add("China");
		politicalTopicList.add("Putin");
		politicalTopicList.add("Mexico");
		politicalTopicList.add("wall");
		politicalTopicList.add("Deleted emails");
		politicalTopicList.add("11/8/16");
		politicalTopicList.add("conservative");
		politicalTopicList.add("Kaine");
		politicalTopicList.add("Pence");
		politicalTopicList.add("Stein");
		politicalTopicList.add("Johnson");
		politicalTopicList.add("election");
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
		for (int posistion = 0; posistion < politicalTopicList.size(); posistion++)
		{
			if (currentInput != null && currentInput.equals(politicalTopicList.get(posistion)))
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
		for (int posistion = 0; posistion < memesList.size(); posistion++)
		{
			if (currentInput != null && currentInput.equalsIgnoreCase(memesList.get(posistion)))
			{
				memeChecker = true;
			}
		}
		return memeChecker;
	}

	/**
	 * Checks to see if someone put in an HTML.
	 */
	public boolean inputHTMLChecker(String input)
	{
		boolean htmlBool = false;
		String part1;
		int a = input.indexOf(">");
		int c = input.indexOf("<");
		String tag = input.substring(c, a);
		if (a >= 0)
		{
			String trimmed = input.replaceAll(" ", "");
			part1 = input.substring(0, a++);
			a = input.indexOf(">");
			String part2 = input.substring(a++);

			if ((input.equalsIgnoreCase("<p>") || part2.contains("<") && part2.contains(">"))
					&& (trimmed.length() > 2 && !input.endsWith("  ") && part1.length() >2
							&& !input.endsWith("F> </a>") && part1.contains("<") && part2.contains(tag)))
			{
				htmlBool = true;
			}
		}

		return htmlBool;
	}

	/**
	 * Checks to see if someone put in a hastag from twitter.
	 */
	public boolean twitterChecker(String input)
	{
		boolean twitterBool = false;
		String trimmed = input.replaceAll(" ", "");
		if (trimmed.length() > 1 && !input.startsWith(" "))
		{
			twitterBool = true;
		}

		return twitterBool;
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

	public boolean quitChecker(String input)
	{
		boolean quitBool = false;
		if (input.equalsIgnoreCase("quit"))
		{
			quitBool = true;
		}
		return quitBool;
	}

	public boolean keyboardMashChecker(String input)
	{
		boolean keyboardMashBool = false;
		if ((input.contains("sdf") || input.contains("dfg") || input.contains("cvb") || input.contains(",./")))
		{
			keyboardMashBool = true;
		}
		return keyboardMashBool;
	}

}
