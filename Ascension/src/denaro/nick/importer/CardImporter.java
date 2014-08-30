package denaro.nick.importer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

import denaro.nick.ascension.Card;
import denaro.nick.ascension.CardSet;


public class CardImporter
{
	public static void main(String[] args)
	{
		sortSets();
	}
	
	public CardSet importSet(String setName)
	{
		CardSet set=new CardSet();
		
		set.addCards(readCardsFromFile(setName+".txt"));
		
		return(set);
	}
	
	public static ArrayList<Card> readCardsFromFile(String filename)
	{
		ArrayList<Card> cards=new ArrayList<Card>();
		
		File file=new File(filename);
		try
		{
			BufferedReader in=new BufferedReader(new FileReader(file));
			String line;
			while((line=in.readLine())!=null)
			{
				String[] attributes=line.split("\t");
				Card card=Card.createCard(attributes);
				cards.add(card);
			}
			in.close();
			return(cards);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		
		return(null);
	}
	
	public static void sortSets()
	{
		File file=new File("ListOfCards.txt");
		try
		{
			BufferedReader in=new BufferedReader(new FileReader(file));
			String line;
			while((line=in.readLine())!=null)
			{
				String[] attributes=line.split("\t");
				Card card=Card.createCard(attributes);
				if(!sets.containsKey(card.getSet()))
					sets.put(card.getSet(),new HashSet<Card>());
				sets.get(card.getSet()).add(card);
				//System.out.println(card);
			}
			in.close();
			
			Iterator<String> it=sets.keySet().iterator();
			
			while(it.hasNext())
			{
				String set=it.next();
				File output=new File(set+".txt");
				BufferedWriter out=new BufferedWriter(new FileWriter(output));
				
				Iterator<Card> cards=sets.get(set).iterator();
				
				while(cards.hasNext())
				{
					Card card=cards.next();
					out.write(card.getName()+"\t"+card.getFaction()+"\t"+card.getType()+"\t"+card.getCost()+"\t"+card.getHonor()+"\t"+card.getRarity()+"\t"+card.getSet()+"\t"+card.getDescription()+"\n");
				}
				
				out.close();
			}
			
			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	
	public static void printArray(Object[] array)
	{
		int i=0;
		System.out.print("[");
		for(i=0;i<array.length-1;i++)
		{
			System.out.print(array[i]);
			if(i<array.length-1)
				System.out.print(",");
		}
		if(i<array.length)
			System.out.println(array[i]+"]");
	}
	
	public static HashMap<String,HashSet<Card>> sets=new HashMap<String,HashSet<Card>>();
}
