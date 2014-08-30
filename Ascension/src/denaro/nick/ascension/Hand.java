package denaro.nick.ascension;

import java.util.ArrayList;

public class Hand
{
	public Hand()
	{
		cards=new ArrayList<Card>();
	}
	
	public void addCard(Card card)
	{
		cards.add(card);
	}
	
	public Card getCard(int i)
	{
		return(cards.get(i));
	}
	
	public int getSize()
	{
		return(cards.size());
	}
	
	public Card playCard(int i)
	{
		return(cards.remove(i));
	}
	
	private ArrayList<Card> cards;
}
