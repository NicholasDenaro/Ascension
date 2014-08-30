package denaro.nick.ascension;

import java.util.Stack;

public class Deck
{
	public Deck()
	{
		cards=new Stack<Card>();
	}
	
	public Card draw()
	{
		return(cards.pop());
	}
	
	private void addSet(CardSet set)
	{
		cards.addAll(set.getCards());
	}
	
	public static Deck constructionDeck(CardSet... sets)
	{
		Deck deck=new Deck();
		
		for(CardSet set:sets)
		{
			deck.addSet(set);
		}
		
		return(deck);
	}
	
	public void shuffle()
	{
		Stack<Card> shuffled=new Stack<Card>();
		while(cards.size()>0)
		{
			int i=(int)(Math.random()*cards.size());
			shuffled.push(cards.remove(i));
		}
		
		cards=shuffled;
	}
	
	private Stack<Card> cards;
}
