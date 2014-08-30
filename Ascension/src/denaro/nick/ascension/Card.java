package denaro.nick.ascension;

public class Card
{
	private Card(String name, String faction, String type, int cost, int honor, int rarity, String set, String description)
	{
		this.name=name;
		this.faction=faction;
		this.type=type;
		this.cost=cost;
		this.honor=honor;
		this.rarity=rarity;
		this.set=set;
		this.description=description;
	}
	
	private Card(String[] attributes)
	{
		this.name=attributes[1];
		this.faction=attributes[2];
		this.type=attributes[3];
		try
		{
			this.cost=new Integer(attributes[4]);
		}
		catch(NumberFormatException ex)
		{
			this.cost=-1;
		}
		try
		{
			this.honor=new Integer(attributes[5]);
		}
		catch(NumberFormatException ex)
		{
			this.honor=-1;
		}
		try
		{
			this.rarity=new Integer(attributes[6]);
		}
		catch(NumberFormatException ex)
		{
			this.rarity=-1;
		}
		this.set=attributes[7];
		this.description=attributes[8];
	}
	
	public static Card createCard(String name, String faction, String type, int cost, int honor, int rarity, String set, String description)
	{
		return(new Card(name, faction, type, cost, honor, rarity, set, description));
	}
	
	public static Card createCard(String[] attributes)
	{
		return(new Card(attributes));
	}
	
	public Card copyCard(Card c, Player owner)
	{
		Card copy=new Card(name, faction, type, cost, honor, rarity, set, description);
		
		copy.owner=owner;
		
		return(copy);
	}
	
	public String getName()
	{
		return(name);
	}
	
	public String getFaction()
	{
		return(faction);
	}
	
	public String getType()
	{
		return(type);
	}
	
	public int getCost()
	{
		return(cost);
	}
	
	public int getHonor()
	{
		return(honor);
	}
	
	public int getRarity()
	{
		return(rarity);
	}
	
	public String getSet()
	{
		return(set);
	}
	
	public String getDescription()
	{
		return(description);
	}
	
	public String toString()
	{
		return("Card: "+name+"\n\tfaction: "+faction+"\n\ttype: "+type+"\n\tcost: "+cost+"\n\thonor: "+honor+"\n\trarity: "+rarity+"\n\tset: "+set+"\n\tdescription: "+description);
	}
	
	private String name;
	private String faction;
	private String type;
	private int cost;
	private int honor;
	private int rarity;
	private String set;
	private String description;
	
	private Player owner;
}
