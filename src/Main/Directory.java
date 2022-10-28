package Main;
import DataStructures.List.List;  

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * Directory class to create and store all contact cards 
 * and their respective information provided by a directory.csv file.
 * 
 * A DoublyLinkedList was used to store the contacts inside the directory for easier travesal through the list. 
 * Since adding and removing contacts from the list is always 0(1), unless done so by index.
 * 
 * Uses a buffer reader object and the split() function to scan each line of the file and parse the contact information by commas.
 * 
 * @author Cristian J. Matos (BourneDoomSlayer)
 *
 */
public class Directory implements BaseDirectory{
	
	//Directory class private field which only includes the DoublyLinkedList used to store the contact cards
	private List.DoublyLinkedList<ContactCard> directory = new List.DoublyLinkedList<>();
	
	//Directory default constructor
	public Directory() {

	}

	/**
	 * Method that takes in a string representing 
	 * the path of contactDirectoy.csv and parses said csv. 
	 * Once parsed, the Directory class will have filled up the private directory 
	 * DoublyLinkedList<ContactCard> field
	 * 
	 * @param path - Path to contactDirectory.csv
	 */
	@Override
	public void createDirectory(String path) {
		try {
			//Creates buffer reader
			File file = new File(path);
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			
			//Parameters used to create each contact card
			String line = "";
			String [] info;
			Date oldDate;
			String stringDate;
			Date newDate;
			while((line = br.readLine()) != null) //loop which will read each line of the csv file until there are no more lines to read (line == null)
			{
				List.DoublyLinkedList<ContactCard> friends = new List.DoublyLinkedList<>();
				
				info = line.split(","); //array used to store the contact information by index
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); //Date formater to fix the given birthday date to a "MM-dd-yyyy" format
				oldDate = sdf.parse(info[5]); //stores contact birthday date as it appears in the csv file. Corresponds to fifth index of the info array
				sdf.applyPattern("MM-dd-yyyy"); //sets desired date pattern
				stringDate = sdf.format(oldDate); //formats new date pattern into a string
				newDate = sdf.parse(stringDate); //parses the new string date format into a new date variable 
			
				//Loop to create the default friends list (with their respective ID number only) for each contact
				for (int i = 6; i < info.length; i++) //runs from 6 to below info.length since the contact's friends ID's will always be after info index 5 
				{
					ContactCard fave = new ContactCard(Integer.parseInt(info[i])); //calls contact card default constructor
					friends.add(fave);
				}
				
				//Creates and adds the directory contact card with the information from the correspoding info array index, excluding the list of friends
				ContactCard card = new ContactCard(Integer.parseInt(info[0]), info[1], info[2], info[3], info[4], newDate, friends);
				directory.add(card);
			}
			
			for (ContactCard card : directory) // for each contact card in the directory create a new list which will be used to update the contact's friends list with their respective information
			{
				List.DoublyLinkedList<ContactCard> updateFriends = new List.DoublyLinkedList<>();
				
				for (ContactCard friend : card.getFriends()) //loop to check the friends of each contact card
				{
					for (ContactCard dir : directory) //loop to compare the ID of the contacts friend with its directory counterpart which holds all its corresponding information
					{
						if (dir.getID() == friend.getID()) //if the IDs match the directory contact card is added to the list
						{
							updateFriends.add(dir);
						}
					}
				}
				card.setFriends(updateFriends); //once each friend of the contact is added to the list, each respective friend list is set and updated with their corresponding information
			}
			
			br.close();
		}
		catch (Exception ioe) { //catches exceptions such as parsing errors or invalid directory file paths 
			ioe.printStackTrace();
		}
	}

	/**
	 * Method that returns a list of ContactCards that represent all of the cards the contact 
	 * passed as parameter does not have marked as favorite, but his favorites do have marked 
	 * as favorite.
	 *
	 * Contact passed must have a valid ID number.
	 * 
	 * If contact does not have any friends, the method returns an empty list.
	 *  
	 * @param contact - The target contact to find the recommendedFriends of.
	 * @return - A list of contact cards that represent all of the cards the contact 
	 * passed as parameter does not have marked as favorite, but his favorites do have marked 
	 * as favorite.
	 * 
	 */
	@Override
	public List<ContactCard> recommendedFriends(ContactCard contact) {
		List.DoublyLinkedList<ContactCard> recommendedList = new List.DoublyLinkedList<>();
		
		if (validID(contact.getID())) //verifies if contact has a valid ID number
		{
			for (ContactCard contactFriends : contact.getFriends()) //loop to check passed contact's friends
			{
				for (ContactCard friendFriends : contactFriends.getFriends()) //loop to check the friends of the passed contact's friends
				{
					if (friendFriends.getID() != contact.getID()) //check to see if friend of friends ID isnt the same as the passed contact's ID
					{
						if (!contact.getFriends().contains(friendFriends) && !recommendedList.contains(friendFriends)) //check to see if the friend of the contact's friends isn't already a friend of contact and if it wasnt already added to the recommended friends list 
						{
							recommendedList.add(friendFriends);
						}
					}
					
				}
			}
		}
		else
			throw new IllegalArgumentException("The ID entered is invalid.");
		
		return recommendedList;
	}

	/**
	 * Method that returns a list of common friends between 2 contact cards.
	 * 
	 * Contacts passed must have a valid ID numbers.
	 * 
	 * If c1 or c2 do not have any friends, or dont share any common friends the method returns an empty list.
	 * 
	 * @param c1 - Contact 1
	 * @param c2 - Contact 2
	 * @return A list of common friends between c1 and c2
	 */
	@Override
	public List<ContactCard> commonFriends(ContactCard c1, ContactCard c2) {
		List.DoublyLinkedList<ContactCard> commonList = new List.DoublyLinkedList<>();
		
		if (validID(c1.getID()) && validID(c2.getID())) //verifies if both c1 and c2 have valid IDs
		{
			for (ContactCard card1 : c1.getFriends()) //loop to check each friend of c1
			{
				for (ContactCard card2 : c2.getFriends()) //loop to check each friend of c2
				{
					if (card1.getID() == card2.getID()) //if both friends share the same ID then both c1 & c2 share that friend and they are added to the common friends list 
					{
						commonList.add(card2);
					}
				}
			}
		}
		else
			throw new IllegalArgumentException("The ID entered is invalid.");

		return commonList;
	}
	
	
	/**
	 * Method that returns a list of contacts who share the same birthday as the contact passed as parameter.
	 * A shared birthday are the dates that share the same month and the same day.
	 * 
	 * Contact passed must have a valid ID number.
	 * 
	 * If no contact shares the same birthday then an empty list is returned.
	 * 
	 * @param contact - Target contact that contains the birthday to look for in common with other contacts
	 * @return a list of contacts who share the same birthday as the parameter contact.
	 */
	@SuppressWarnings("deprecation")
	@Override
	public List<ContactCard> shareBirthdays(ContactCard contact) {
		List.DoublyLinkedList<ContactCard> sameBDayList = new List.DoublyLinkedList<ContactCard>();
		
		if (validID(contact.getID())) // verify if contact ID is valid 
		{
			for (ContactCard card : directory) // for loop to compare given contact birthday with each birthday in the directory
			{
				if (!card.equals(contact)) // verifies if the current directory contact is the same contact as the parameter 
				{
					//if the directory contact and the parameter contact share the same month and day on their birthday, the directory card is added to same birthday list
					if (card.getBirthDay().getMonth() == contact.getBirthDay().getMonth() && card.getBirthDay().getDate() == contact.getBirthDay().getDate())
					{
						sameBDayList.add(card);
					}
				}
			}
		}
		else
			throw new IllegalArgumentException("The ID entered is invalid.");
		
		return sameBDayList;
	}
	
	/**
	 * Boolean type auxiliary mehtod that helps verify if the ID of the contact passed 
	 * as a parameter in the other BaseDirectory implemented methods is valid 
	 * by comparing it with the existing contact ID's in the directory.
	 * 
	 * @param ID ID number to verify
	 * @return True if the ID is valid, false otherwise
	 */
	public boolean validID(int ID) {
		for (ContactCard dir : directory)
		{
			if (dir.getID() == ID) return true;
				
		}
		return false;
	}
	
	
	/**
	 * Getter method which returns the directory itself. In other words, 
	 * it returns the DoublyLinkedList of ContactCards created. 
	 * 
	 * @return Directory: DoublyLinkedList with ContactCards and their respetive information
	 */
	public List<ContactCard> getContacts() {
		return directory;
	}

}
