package Main;
import java.util.Date;
import DataStructures.List.List.DoublyLinkedList;

/**
 * Contact Card Class to hold all the information 
 * regarding one contact inside the directory.
 * 
 * Inlcudes various getter and setter methods to return and modify the contacts corresponding information.
 * 
 * The Date class was used to store the contacts birthday date.
 * 
 * A DoublyLinkedList was used to store the contact's friends for easier travesal through the list. 
 * Since adding and removing friends from the list is always 0(1), unless done so by index.
 * 
 * @author bermed28 & Cristian J. Matos (Github username: BourneDoomSlayer)
 */
public class ContactCard {
	
	/* ContactCard class private fields which include the person's ID, name, job title,
	 * phone number, Email, birthday date and a list (DoublyLinkedList) of their friends
	 * and their respective contact card information.
	 */
	private int ID;
	private String name;
	private String jobTitle;
	private String phoneNum;
	private String email; 
	private Date bDay;
	private DoublyLinkedList<ContactCard> friends;
	
	/**
	 * Default ContactCard constructor which creates a ContactCard object but only initializng 
	 * the ID number passed as the parameter.
	 * 
	 * @param ID
	 */
	public ContactCard (int ID) {
		this.ID = ID;
	}
	
	/**
	 * Main ContactCard constructor which creates a ContactCard object with all its private field 
	 * values initialized by the parameters passed into it.
	 * 
	 * @param ID
	 * @param name
	 * @param jobTitle
	 * @param phoneNum
	 * @param email
	 * @param bDay
	 * @param friends
	 */
	
	public ContactCard(int ID, String name, String jobTitle, String phoneNum, String email, Date bDay, DoublyLinkedList<ContactCard> friends) {
		this.ID = ID;
		this.name = name;
		this.jobTitle = jobTitle;
		this.phoneNum = phoneNum;
		this.email = email;
		this.bDay = bDay;
		this.friends = friends;
	}
	
	/**
	 * Getter method which returns the Contactcard's special ID number.
	 * 
	 * @return ContactCard's ID number 
	 */
	public int getID() {
		return ID;
	}
	
	/**
	 * Setter method which sets the ContactCard's special ID number with the 
	 * int value passed as a parameter.
	 * 
	 * @param id  New ID number
	 */
	public void setID(int id) {
		this.ID = id;
	}
	
	/**
	 * Getter method which returns the Contactcard's name.
	 * 
	 * @return ContactCard's name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Setter method which sets the ContactCard's name with the 
	 * string value passed as a parameter.
	 * 
	 * @param name New name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Getter method which returns the Contactcard's job title.
	 * 
	 * @return ContactCard's job title 
	 */
	public String getJobTitle() {
		return jobTitle;
	}
	
	/**
	 * Setter method which sets the ContactCard's job title with the 
	 * string value passed as a parameter.
	 * 
	 * @param job New job title
	 */
	public void setJobTitle(String job) {
		this.jobTitle = job;
	}
	
	/**
	 * Getter method which returns the Contactcard's phone number.
	 * 
	 * @return ContactCard's phone number 
	 */
	public String getPhone() {
		return phoneNum;
	}
	
	/**
	 * Setter method which sets the ContactCard's phone number with the 
	 * string value passed as a parameter.
	 * 
	 * @param number New phone number
	 */
	public void setPhone(String number) {
		this.phoneNum = number;
	}
	
	/**
	 * Getter method which returns the Contactcard's email address.
	 * 
	 * @return ContactCard's email address
	 */
	public String getEmail() {
		return email;
	}
	
	/**
	 * Setter method which sets the ContactCard's Email address with the 
	 * string value passed as a parameter.
	 * 
	 * @param email New Email address
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * Getter method which returns the Contactcard's birthday date.
	 * 
	 * @return ContactCard's birthday date
	 */
	public Date getBirthDay() {
		return bDay;
	}
	
	/**
	 * Setter method which sets the ContactCard's birthday date with the 
	 * Date value passed as a parameter.
	 * 
	 * @param bDay New birthday date
	 */
	public void setBirthDay(Date bDay) {
		this.bDay = bDay;
	}
	
	/**
	 * Getter method which returns a list of the Contactcard's friends.
	 * 
	 * @return ContactCard's friends as a DoublyLinkedList
	 */
	public DoublyLinkedList<ContactCard> getFriends() {
		return friends;
	}
	
	/**
	 * Setter method which sets the ContactCard's list of friends with the 
	 * new list of ContactCard's passed as a parameter.
	 * 
	 * @param friends New DoublyLinkedList of friends
	 */
	public void setFriends(DoublyLinkedList<ContactCard> friends) {
		this.friends = friends;
	}
}

