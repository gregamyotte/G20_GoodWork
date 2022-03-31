/**
 * 
 */
package contactList;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author Greg Amyotte
 *
 */
public class Business extends Contact {
	private String workPhone;
	private String companyName;
	private String departmentName;
	private String jobTitle;
	private static FileWriter write;

	public Business() {
		super();
		setContactIdentifier();
		workPhone = "n/a";
		companyName = "Unknown";
		departmentName = "n/a";
		jobTitle = "n/a";
		openBusiness();
	} // Business()

	public Business(String l, String f, String e, String cn) {
		super(l, f, e);
		setContactIdentifier();
		setCompanyName(cn);
		workPhone = "n/a";
		departmentName = "n/a";
		jobTitle = "n/a";
		openBusiness();
	} // Business (String, String, String, String)

	public static void openBusiness() {
		File businessFile = new File("businessContacts.txt");
		try {
			write = new FileWriter(businessFile, true);
		} // try
		catch (IOException e) {
			System.out
					.println("ERROR: File businessContacts.txt could not be opened: "
							+ e.getMessage());
		} // catch
	} // openPersonal()

	public static void closeBusiness() {
		try {
			write.close();
		} // try
		catch (IOException e) {
			System.out
					.println("ERROR: File businessContacts.txt could not be closed: "
							+ e.getMessage());
		} // catch
	} // closePersonal()

	public void setWorkPhone(String wpa, String wpf, String wpl) {
		workPhone = wpa + "-" + wpf + "-" + wpl;
	} // setWorkPhone(String, String, String)

	public String getWorkPhone() {
		return workPhone;
	} // getWorkPhone()

	public void setCompanyName(String cn) {
		companyName = cn;
	} // setCompanyName(String)

	public String getCompanyName() {
		return companyName;
	} // getCompanyName()

	public void setDepartmentName(String d) {
		departmentName = d;
	} // setDepartmentName(String)

	public String getDepartmentName() {
		return departmentName;
	} // getDepartmentName()

	public void setJobTitle(String j) {
		jobTitle = j;
	} // setJobTitle(String)

	public String getJobTitle() {
		return jobTitle;
	} // getJobTitle()

	@Override
	public void setContactIdentifier() {
		contactIdentifier = "B" + contactNumber;
	} // setContactIdentifier()

	public boolean newBusiness() {
		try {
			write.write(contactIdentifier + "~" + lastName + "~" + firstName + "~"
					+ DOBDay + "~" + DOBMonth + "~" + DOBYear + "~" + address + "~" + city
					+ "~" + province + "~" + postalCode + "~" + email + "~" + cellphone
					+ "~" + workPhone + "~" + companyName + "~" + departmentName + "~"
					+ jobTitle + "\n");
			write.flush();
		} // try
		catch (IOException e) {
			System.out.println("ERROR: Contact " + getContactIdentifier()
					+ "could not be written to file businessContacts.txt: "
					+ e.getMessage());
		} // catch
		return true;
	} // newBusiness()
} // Business class
