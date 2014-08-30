package denaro.nick.ascension;

public class Player
{
	public Player(String name)
	{
		this.name=name;
		honor=0;
		this.hand=new Hand();
		this.deck=new Deck();
		this.discardPile=new Deck();
		
		this.runes=0;
		this.power=0;
		this.energy=0;
	}
	
	public void addHonor(int h)
	{
		honor+=h;
	}
	
	public void addRunes(int r)
	{
		runes+=r;
	}
	
	public void addPower(int p)
	{
		power+=p;
	}
	
	public void addEnergy(int e)
	{
		energy+=e;
	}
	
	public Card playCard(int i)
	{
		return(hand.getCard(i));
	}
	
	public void discardHand()
	{
		
	}
	
	private Hand hand;
	private Deck deck;
	private Deck discardPile;
	private String name;
	private int honor;
	
	private int runes;
	private int power;
	private int energy;
}
