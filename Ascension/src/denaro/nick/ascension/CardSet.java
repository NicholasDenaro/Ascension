package denaro.nick.ascension;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Consumer;

public class CardSet
{
	public CardSet()
	{
		cards=new HashSet<Card>();
	}
	
	public void addCards(ArrayList<Card> cards)
	{
		this.cards.addAll(cards);
	}
	
	public ArrayList<Card> getCards()
	{
		ArrayList<Card> list=new ArrayList<Card>();
		cards.forEach(new Consumer<Card>(){
			public void accept(Card c)
			{
				list.add(c);
			}
		});
		
		return(list);
	}
	
	private Set<Card> cards;
}
