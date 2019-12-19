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
				  
		  ArrayList<String> tempfullIdNames = new ArrayList<String>();
		  int[] counter = {1};
		  
		  
		  /* Truncating last name, 
		  eliminating '-' from the last name,
		  generating email ID in the given format, firstname.lastname@example.com, for every given names
		   */
		  
		  for(int i=0;i<fullNames.length;i++)
		  {
			  fullNames[i]=fullNames[i].toLowerCase();
			  String[] tempNames = fullNames[i].split(" ");
			  int lastnameIndex = tempNames.length -1;
			  
					  
			  String tempLastname = tempNames[lastnameIndex].replace("-", "");
			  if (tempLastname.length()>8)
			  	{
				  tempLastname = tempLastname.substring(0, 7);					  
			  	}
			  
			  tempfullIdNames.add(tempNames[0]+"."+tempLastname);			  
			  emailIDs.add(tempNames[0]+"."+tempLastname+C);
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
			  counter[0] = 1;
				if (Collections.frequency(emailIDs, email)>1)
				{
					for(int i=0;i<Collections.frequency(emailIDs, email);i++)
					{						
						String[] tempEmail=email.split("@");												
						lhmEmail.forEach((fName,eID)-> 
						{							
							if(eID.equals(email))
							{								
								String temp = tempEmail[0]+ counter[0]+"@example.com";								    					  
								lhmEmail.put(fName, temp.toLowerCase());									
								counter[0] = counter[0]+1;									
							}											
						 });					
							
					 }
						
				 }
			}
		    System.out.println("Employee Names: "+ lhmEmail.keySet());
		  	System.out.println("Employee Email IDs: "+ lhmEmail.values());
		  	
	 }		  	  
		 
		  
}


