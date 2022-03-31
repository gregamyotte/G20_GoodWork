/**
 * 
 */
package contactList;

import java.io.*;

/**
 * @author Greg Amyotte
 *
 */
public class Personal extends Contact {
	private String homePhone;
	private String twitterHandle;
	private String instagramUsername;
	private String relationship;
	private int relationshipCode;
	private static FileWriter write;

	public Personal() {
		super();
		setContactIdentifier();
		homePhone = "n/a";
		twitterHandle = "n/a";
		instagramUsername = "n/a";
		relationship = "Unknown";
		relationshipCode = 0;
		openPersonal();
	} // Personal()

	public Personal(String l, String f, String e, String r) {
		super(l, f, e);
		setContactIdentifier();
		homePhone = "n/a";
		twitterHandle = "n/a";
		instagramUsername = "n/a";
		setRelationship(r);
		setRelationshipCode();
		openPersonal();
	} // Personal(String, String, String, String)

	public static void openPersonal() {
		File personalFile = new File("personalContacts.txt");
		try {
			write = new FileWriter(personalFile, true);
		} // try
		catch (IOException e) {
			System.out
					.println("ERROR: File personalContacts.txt could not be opened: "
							+ e.getMessage());
		} // catch
	} // openPersonal()

	public static void closePersonal() {
		try {
			write.close();
		} // try
		catch (IOException e) {
			System.out
					.println("ERROR: File personalContacts.txt could not be closed: "
							+ e.getMessage());
		} // catch
	} // closePersonal()

	public void setHomePhone(String hpa, String hpf, String hpl) {
		homePhone = hpa + "-" + hpf + "-" + hpl;
	} // setHomePhone(String, String, String)

	public String getHomePhone() {
		return homePhone;
	} // getHomePhone()

	public void setTwitterHandle(String t) {
		twitterHandle = t;
	} // setTwitterHandle()

	public String getTwitterHandle() {
		return twitterHandle;
	} // getTwitterHandle()

	public void setInstagramUsername(String i) {
		instagramUsername = i;
	} // setInstagramUsername(String)

	public String getInstagramUsername() {
		return instagramUsername;
	} // getInstagramUsername()

	public void setRelationship(String r) {
		relationship = r;
	} // setRelationship(String)

	public String getRelationship() {
		return relationship;
	} // getRelationship()

	public void setRelationshipCode() {
		if (relationship.equals("Spouse/Partner"))
			relationshipCode = 1;
		else
			if (relationship.equals("Family"))
				relationshipCode = 2;
			else
				if (relationship.equals("Friend"))
					relationshipCode = 3;
				else
					if (relationship.equals("Acquaintance"))
						relationshipCode = 4;
					else
						if (relationship.equals("Neighbour"))
							relationshipCode = 5;
						else
							if (relationship.equals("Other"))
								relationshipCode = 99;
							else
								relationshipCode = 0;
	} // setRelationshipCode(String)

	public int getRelationshipCode() {
		return relationshipCode;
	} // getRelationshipCode()

	@Override
	public void setContactIdentifier() {
		contactIdentifier = "P" + contactNumber;
	} // setContactIdentifier()

	public boolean newPersonal() {
		try {
			write.write(contactIdentifier + "~" + lastName + "~" + firstName + "~"
					+ DOBDay + "~" + DOBMonth + "~" + DOBYear + "~" + address + "~" + city
					+ "~" + province + "~" + postalCode + "~" + email + "~" + cellphone
					+ "~" + homePhone + "~" + twitterHandle + "~" + instagramUsername
					+ "~" + relationshipCode + "\n");
			write.close();
		} // try
		catch (IOException e) {
			System.out.println("ERROR: Contact " + getContactIdentifier()
					+ "could not be written to file personalContacts.txt: "
					+ e.getMessage());
		} // catch
		return true;
	} // newPersonal()
} // Personal class
