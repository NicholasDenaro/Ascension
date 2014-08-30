package denaro.nick.ascension;

import java.util.ArrayList;
import java.util.HashSet;

import denaro.nick.ascension.listener.EndOfRoundEvent;
import denaro.nick.ascension.listener.EndOfRoundListener;
import denaro.nick.ascension.listener.EndOfTurnEvent;
import denaro.nick.ascension.listener.EndOfTurnListener;

public class Game
{
	public Game()
	{
		started=false;
		players=new ArrayList<Player>();
	}
	
	public void addPlayer(Player p) throws GameStartedException
	{
		if(started)
			throw new GameStartedException("Can't add new player.");
		players.add(p);
	}
	
	public void setCenterDeck(Deck deck) throws GameStartedException
	{
		if(started)
			throw new GameStartedException("Can't set deck.");
		centerDeck=deck;
	}
	
	public void start()
	{
		started=true;
		
		currentPlayer=chooseStartingPlayer();
	}
	
	public void endTurn()
	{
		Player player=players.get(currentPlayer);
		
		player.discardHand();
		
		for(EndOfTurnListener eotl:endOfTurnListeners)
			eotl.turnEnd(new EndOfTurnEvent(player,currentPlayer));
		
		currentPlayer=(currentPlayer+1)%players.size();
		
		if(currentPlayer==0)
			for(EndOfRoundListener eotl:endOfRoundListeners)
				eotl.roundEnd(new EndOfRoundEvent());
	}
	
	public int chooseStartingPlayer()
	{
		//TODO logic for choosing the player to go first.
		return ((int)(Math.random()*players.size()));
	}
	
	public boolean isGameOver()
	{
		return(honor<=0);
	}
	
	private boolean started;
	private ArrayList<Player> players;
	private Deck centerDeck;
	private int currentPlayer;
	
	private int honor;
	
	private HashSet<EndOfTurnListener> endOfTurnListeners=new HashSet<EndOfTurnListener>();
	private HashSet<EndOfRoundListener> endOfRoundListeners=new HashSet<EndOfRoundListener>();
}
