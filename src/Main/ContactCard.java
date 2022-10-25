package Main;
import java.util.Date;
import DataStructures.List.List.DoublyLinkedList;

/**
 * Contact Card Class to hold all the information 
 * regarding one contact inside the directory
 * 
 * @author bermed28 & Cristian J. Matos (Github username: BourneDoomSlayer)
 */
public class ContactCard {
	
	private int ID;
	private String name;
	private String jobTitle;
	private String phoneNum;
	private String email; 
	private Date bDay;
	private DoublyLinkedList<ContactCard> friends;
	/**
	 * 
	 * @param ID
	 * @param name
	 * @param jobTitle
	 * @param phoneNum
	 * @param email
	 * @param bDay
	 * @param friends
	 */
	
	public ContactCard () {
		
	}
	
	public ContactCard(int ID, String name, String jobTitle, String phoneNum, String email, Date bDay, DoublyLinkedList<ContactCard> friends) {
		this.ID = ID;
		this.name = name;
		this.jobTitle = jobTitle;
		this.phoneNum = phoneNum;
		this.email = email;
		this.bDay = bDay;
		this.friends = friends;
	}
	
	
	public int getID() {
		return ID;
	}
	
	public void setID(int id) {
		this.ID = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getJobTitle() {
		return jobTitle;
	}
	
	public void setJobTitle(String job) {
		this.jobTitle = job;
	}
	
	public String getPhone() {
		return phoneNum;
	}
	
	public void setPhone(String number) {
		this.phoneNum = number;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public Date getBirthDay() {
		return bDay;
	}
	
	public void setBirthDay(Date bDay) {
		this.bDay = bDay;
	}
	
	public DoublyLinkedList<ContactCard> getFriends() {
		return friends;
	}
	
	public void setFriends(DoublyLinkedList<ContactCard> friends) {
		this.friends = friends;
	}
}

