package Main;
import DataStructures.List.List;

import java.io.*;
import java.lang.reflect.Array;
import java.util.Date;

public class Directory implements BaseDirectory{
	
	private List.DoublyLinkedList<ContactCard> directory = new List.DoublyLinkedList<>();
	private List.DoublyLinkedList<ContactCard> friends = new List.DoublyLinkedList<>();
	
	public Directory() {
			
	}

	@Override
	public void createDirectory(String path) {
		try {
			File file = new File(path);
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			
			String line = "";
			String [] info;
			while((line = br.readLine()) != null)
			{
				info = line.split(",");
				ContactCard card = new ContactCard(Integer.parseInt(info[0]), info[1], info[2], Integer.parseInt(info[3]), info[4], Date.info[5]), friends);

			}
			br.close();
		}
		catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

	@Override
	public List<ContactCard> recommendedFriends(ContactCard contact) {
		List.DoublyLinkedList<ContactCard> list = new List.DoublyLinkedList<>();
		return null;
	}

	@Override
	public List<ContactCard> commonFriends(ContactCard c1, ContactCard c2) {
		List.DoublyLinkedList<ContactCard> list = new List.DoublyLinkedList<>();
		return null;
	}

	@Override
	public List<ContactCard> shareBirthdays(ContactCard contact) {
		List.DoublyLinkedList<ContactCard> list = new List.DoublyLinkedList<>();
		return null;
	}

}
