package denaro.nick.ascension;

public class GameStartedException extends Exception
{
	public GameStartedException(String extra)
	{
		super("Game has already be started. "+extra);
	}
}
