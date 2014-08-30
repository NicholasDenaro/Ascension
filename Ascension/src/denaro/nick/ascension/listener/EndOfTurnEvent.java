package denaro.nick.ascension.listener;

import denaro.nick.ascension.Player;

public class EndOfTurnEvent
{
	public EndOfTurnEvent(Player player, int turn)
	{
		this.player=player;
		this.turn=turn;
	}
	
	private Player player;
	private int turn;
}
