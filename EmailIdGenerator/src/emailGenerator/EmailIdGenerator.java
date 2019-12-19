package emailGenerator;

import java.util.*;

public class EmailIdGenerator 
{
	 public static void main(String args[])
	 {
		 String C = "Example";
		  C = "@"+ C.toLowerCase().concat(".com");		 
		  String S = "John Doe; Peter Benjamin Parker; Mary Jane Watson-Parker; John Elvis Doe; John Evan Doe; Jane Doe; Peter Brian Parker";
		  String[] fullNames = S.split("; ");
		  ArrayList<String> emailIDs = new ArrayList<String>();
		  ArrayList<String> uniEmailIDs = new ArrayList<String>();	
		  LinkedHashMap<String, String> lhmEmail = new LinkedHashMap<String, String>();
		  int[] counter = {1};
		  
		  /* Truncating last name, 
		  eliminating '-' from the last name,
		  generating email ID in the given format, firstname.lastname@example.com, for every given names
		   */
		  
		  for(int i=0;i<fullNames.length;i++)
		  {
			  fullNames[i]=fullNames[i];
			  String[] tempNames = fullNames[i].split(" ");
			  int lastnameIndex = tempNames.length -1;
			  
					  
			  String tempLastname = tempNames[lastnameIndex].replace("-", "").toLowerCase();
			  if (tempLastname.length()>8)
			  	{
				  tempLastname = tempLastname.substring(0, 7);					  
			  	}			  
					  
			  emailIDs.add(tempNames[0].toLowerCase()+"."+tempLastname+C);
			  lhmEmail.put(fullNames[i], emailIDs.get(i));		  
			  
		  }
				  
		  /* Iterating through the email id data structure to make every email id unique
		   * If the firstname+lastname combination becomes duplicate, append an integer to the lastname
		   * so that the integer increments sequentially for every duplicate set of names
		   * 
		   */
		  Set<String> hstUnique = new HashSet<String>(emailIDs);		  
		  for(String email : hstUnique)
		  {
			  String[] tempEmail=email.split("@");
			  counter[0] = 1;
				if (Collections.frequency(emailIDs, email)>1)
				{					
					for(int i=0;i<Collections.frequency(emailIDs, email);i++)
					{	
						lhmEmail.forEach((fName,eID)-> 
						{							
							if(eID.equals(email))
							{											
								String temp = tempEmail[0]+ counter[0]+"@example.com";								    					  
								lhmEmail.put(fName, temp);									
								counter[0] = counter[0]+1;									
							}										
						 });					
							
					 }
						
				 }
			}		
	      Set set = lhmEmail.entrySet(); // Get a set of the entries
	      Iterator itr = set.iterator(); // Get an iterator
		  while (itr.hasNext())
		  {
			  Map.Entry me = (Map.Entry)itr.next();
			  System.out.print("Employee Name & Email ID: " + me.getKey() + " -> " );
			  System.out.println(me.getValue());
		  }
		  System.out.println();
		  	
	 }		  	  
		 
		  
}


