package denaro.nick.ascension;

import java.util.HashMap;

public class Main
{
	public static void main(String[] args)
	{
		keywords=new HashMap<String,GameAction>();
		
		keywords.put("Gain (# Honor)",new GameAction(){
			public boolean run(Object[] obj)
			{
				Player p=(Player)obj[0];
				int honor=(int)obj[1];
				p.addHonor(honor);
				return true;
			}
		});
		
		Game game=new Game();
		Player p1=new Player("Nick");
		try
		{
			game.addPlayer(p1);
		}
		catch(GameStartedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private static HashMap<String,GameAction> keywords;
}
