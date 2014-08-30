package denaro.nick.ascension;

public class CardParser
{
	private CardParser()
	{
		
	}
	
	public CardParser instance()
	{
		if(parser==null)
			parser=new CardParser();
		return(parser);
	}
	
	public void parse(String text)
	{
		
	}
	
	public static CardParser parser;
}
