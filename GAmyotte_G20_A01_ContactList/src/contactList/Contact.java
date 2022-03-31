/**
 * 
 */
package contactList;

import java.util.*;

import java.io.*;

/**
 * @author Greg Amyotte
 *
 */
public abstract class Contact {

	private static int nextNumber;
	private static String numberFileName;
	protected String contactNumber;
	protected String lastName;
	protected String firstName;
	protected int DOBYear;
	protected int DOBMonth;
	protected int DOBDay;
	protected String address;
	protected String city;
	protected String province;
	protected String postalCode;
	protected String cellphone;
	protected String email;
	protected String contactIdentifier;

	public Contact() {
		setContactNumber();
		lastName = "Unknown";
		firstName = "Unknown";
		email = "Unknown";
		DOBYear = 0;
		DOBMonth = 0;
		DOBDay = 0;
		address = "n/a";
		city = "n/a";
		province = "n/a";
		postalCode = "n/a";
		cellphone = "n/a";
	} // Contact()

	public Contact(String l, String f, String e) {
		setContactNumber();
		setFirstName(f);
		setLastName(l);
		setEmail(e);
		DOBYear = 0;
		DOBMonth = 0;
		DOBDay = 0;
		address = "n/a";
		city = "n/a";
		province = "n/a";
		postalCode = "n/a";
		cellphone = "n/a";
	} // Contact(String, String, String)

	public void setLastName(String l) {
		lastName = l;
	} // setLastName(String)

	public String getLastName() {
		return lastName;
	} // getLastName()

	public void setFirstName(String f) {
		firstName = f;
	} // setFirstName(String)

	public String getFirstName() {
		return firstName;
	} // getFirstName()

	public void setEmail(String e) {
		email = e;
	} // setEmail(String)

	public String getEmail() {
		return email;
	} // getEmail()

	public void setDOBYear(int y) {
		DOBYear = y;
	} // setDOBYear(int)

	public int getDOBYear() {
		return DOBYear;
	} // getDOBYear()

	public void setDOBMonth(int m) {
		DOBMonth = m;
	} // setDOBMonth(int)

	public int getDOBMonth() {
		return DOBMonth;
	} // getDOBMonth

	public void setDOBDay(int d) {
		DOBDay = d;
	} // setDOBDay(int)

	public int getDOBDay() {
		return DOBDay;
	} // getDOBDay()

	public void setAddress(String a) {
		address = a;
	} // setAddress(String)

	public String getAddress() {
		return address;
	} // getAddress()

	public void setCity(String c) {
		city = c;
	} // setCity(String)

	public String getCity() {
		return city;
	} // getCity()

	public void setProvince(String p) {
		province = p;
	} // setProvince(String)

	public String getProvince() {
		return province;
	} // getProvince()

	public void setPostalCode(String pc) {
		postalCode = pc;
	} // setPostalCode(String)

	public String getPostalCode() {
		return postalCode;
	} // getPostalCode()

	public void setCellphone(String cpa, String cpf, String cpl) {
		cellphone = cpa + "-" + cpf + "-" + cpl;
	} // setCellphone(String, String, String)

	public String getCellphone() {
		return cellphone;
	} // getCellphone()

	public abstract void setContactIdentifier();

	public String getContactIdentifier() {
		return contactIdentifier;
	} // getContactIdentifier()

	private void setContactNumber() {
		contactNumber = String.valueOf(nextNumber);
		++nextNumber;
	} // setProductNumber()

	public static void open() {
		numberFileName = "contactNumber.txt";
		initializeNextNumber();
	} // open()

	private static void initializeNextNumber() {
		File numberFile = new File(numberFileName);
		Scanner in = null;
		try {
			in = new Scanner(numberFile);
		} // try
		catch (FileNotFoundException e) {
			System.out.println("ERROR: " + numberFileName
					+ " was not found. The next contact number cannot be initialized.");
			System.exit(-1);
		} // catch (FileNotFoundException e)
		catch (IOException e) {
			System.out
					.println("ERROR opening " + numberFileName + ": " + e.getMessage());
			System.exit(-2);
		} // catch (IOException e)
		nextNumber = in.nextInt();
	} // initializeNextNumber()

	public static void close() {
		File numberFile = new File(numberFileName);
		try {
			FileWriter numberOut = new FileWriter(numberFile);
			numberOut.write(String.valueOf(nextNumber));
			numberOut.close();
		} // try
		catch (IOException e) {
			System.out.println(
					"ERROR: Could not rewrite " + numberFile + " " + e.getMessage());
		} // catch (IOException e)
	} // close()

} // Contact class
