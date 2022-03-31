package contactList;

import javax.swing.*;

import java.awt.event.*;

import java.awt.*;

public class ContactListFrame extends JFrame implements WindowListener {
	private JTextField fldFirstName;
	private JTextField fldLastName;
	private JTextField fldCellphoneArea;
	private JTextField fldCellphoneFirst;
	private JTextField fldCellphoneLast;
	private JTextField fldAddress;
	private JTextField fldCity;
	private JTextField fldPostalCode;
	private JTextField fldEmail;
	private JTextField fldHomePhoneArea;
	private JTextField fldHomePhoneFirst;
	private JTextField fldHomePhoneLast;
	private JTextField fldTwitter;
	private JTextField fldInstagram;
	private JTextField fldWorkPhoneArea;
	private JTextField fldWorkPhoneFirst;
	private JTextField fldWorkPhoneLast;
	private JTextField fldCompany;
	private JTextField fldDepartment;
	private JTextField fldJobTitle;
	private JLabel lblFirstName;
	private JLabel lblLastName;
	private JLabel lblDOB;
	private JLabel lblCellphone;
	private JLabel lblAddress;
	private JLabel lblCity;
	private JLabel lblProvince;
	private JLabel lblPostalCode;
	private JLabel lblEmail;
	private JLabel lblAdd;
	private JLabel lblHomePhone;
	private JLabel lblTwitter;
	private JLabel lblInstagram;
	private JLabel lblRelationship;
	private JLabel lblWorkPhone;
	private JLabel lblCompany;
	private JLabel lblDepartment;
	private JLabel lblJobTitle;
	private JButton btnAddPersonal;
	private JButton btnAddBusiness;
	private JButton btnAdd;
	private JButton btnClear;
	private JComboBox cmbxDOBYear;
	private JComboBox cmbxDOBMonth;
	private JComboBox cmbxDOBDay;
	private JComboBox cmbxProvince;
	private JComboBox cmbxRelationship;

	private Contact contact;
	private char contactType;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ContactListFrame frame = new ContactListFrame();
					frame.setVisible(true);
				}
				catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	} // main()

	/**
	 * Create the frame.
	 */
	public ContactListFrame() {
		Contact.open();
		setTitle("Contact List");
		setBounds(100, 100, 591, 459);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		lblFirstName = new JLabel("First Name:");
		lblFirstName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFirstName.setBounds(10, 11, 70, 14);
		getContentPane().add(lblFirstName);

		fldFirstName = new JTextField();
		fldFirstName.setBounds(90, 8, 175, 20);
		getContentPane().add(fldFirstName);
		fldFirstName.setColumns(10);

		lblLastName = new JLabel("Last Name:");
		lblLastName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLastName.setBounds(294, 11, 70, 14);
		getContentPane().add(lblLastName);

		fldLastName = new JTextField();
		fldLastName.setBounds(374, 8, 175, 20);
		getContentPane().add(fldLastName);
		fldLastName.setColumns(10);

		lblDOB = new JLabel("DOB:");
		lblDOB.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDOB.setBounds(10, 48, 70, 14);
		getContentPane().add(lblDOB);

		cmbxDOBYear = new JComboBox();
		cmbxDOBYear.setModel(new DefaultComboBoxModel(new String[] { "YYYY", "2021",
				"2020", "2019", "2018", "2017", "2016", "2015", "2014", "2013", "2012",
				"2011", "2010", "2009", "2008", "2007", "2006", "2005", "2004", "2003",
				"2002", "2001", "2000", "1999", "1998", "1997", "1996", "1995", "1994",
				"1993", "1992", "1991", "1990", "1989", "1988", "1987", "1986", "1985",
				"1984", "1983", "1982", "1981", "1980", "1979", "1978", "1977", "1976",
				"1975", "1974", "1973", "1972", "1971", "1970", "1969", "1968", "1967",
				"1966", "1965", "1964", "1963", "1962", "1961", "1960", "1959", "1958",
				"1957", "1956", "1955", "1954", "1953", "1952", "1951", "1950", "1949",
				"1948", "1947", "1946", "1945", "1944", "1943", "1942", "1941", "1940",
				"1939", "1938", "1937", "1936", "1935", "1934", "1933", "1932", "1931",
				"1930", "1929", "1928", "1927", "1926", "1925", "1924", "1923", "1922",
				"1921" }));
		cmbxDOBYear.setBounds(88, 44, 55, 22);
		getContentPane().add(cmbxDOBYear);

		cmbxDOBMonth = new JComboBox();
		cmbxDOBMonth.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dateSelector();
			}
		});
		cmbxDOBMonth.setModel(new DefaultComboBoxModel(new String[] { "MM", "1",
				"2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));
		cmbxDOBMonth.setBounds(145, 44, 55, 22);
		getContentPane().add(cmbxDOBMonth);

		cmbxDOBDay = new JComboBox();
		cmbxDOBDay.setModel(new DefaultComboBoxModel(new String[] { "DD" }));

		cmbxDOBDay.setBounds(210, 44, 55, 22);
		getContentPane().add(cmbxDOBDay);

		lblCellphone = new JLabel("Cellphone:");
		lblCellphone.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCellphone.setBounds(10, 137, 70, 14);
		getContentPane().add(lblCellphone);

		fldCellphoneArea = new JTextField();
		fldCellphoneArea.setBounds(90, 134, 38, 20);
		getContentPane().add(fldCellphoneArea);
		fldCellphoneArea.setColumns(10);

		fldCellphoneFirst = new JTextField();
		fldCellphoneFirst.setBounds(138, 134, 38, 20);
		getContentPane().add(fldCellphoneFirst);
		fldCellphoneFirst.setColumns(10);

		fldCellphoneLast = new JTextField();
		fldCellphoneLast.setBounds(186, 134, 55, 20);
		getContentPane().add(fldCellphoneLast);
		fldCellphoneLast.setColumns(10);

		lblAddress = new JLabel("Address:");
		lblAddress.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAddress.setBounds(10, 86, 70, 14);
		getContentPane().add(lblAddress);

		fldAddress = new JTextField();
		fldAddress.setBounds(88, 83, 175, 20);
		getContentPane().add(fldAddress);
		fldAddress.setColumns(10);

		lblCity = new JLabel("City:");
		lblCity.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCity.setBounds(294, 86, 70, 14);
		getContentPane().add(lblCity);

		fldCity = new JTextField();
		fldCity.setBounds(374, 83, 175, 20);
		getContentPane().add(fldCity);
		fldCity.setColumns(10);

		lblProvince = new JLabel("Province:");
		lblProvince.setHorizontalAlignment(SwingConstants.RIGHT);
		lblProvince.setBounds(10, 112, 70, 14);
		getContentPane().add(lblProvince);

		cmbxProvince = new JComboBox();
		cmbxProvince.setModel(new DefaultComboBoxModel(
				new String[] { "", "Alberta", "British Columbia", "Manitoba",
						"New Brunswick", "Newfoundland & Labrador", "Northwest Territories",
						"Nova Scotia", "Nunavut", "Ontario", "Prince Edward Island",
						"Quebec", "Saskatchewan", "Yukon" }));
		cmbxProvince.setBounds(88, 108, 175, 22);
		getContentPane().add(cmbxProvince);

		lblPostalCode = new JLabel("Postal Code:");
		lblPostalCode.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPostalCode.setBounds(285, 112, 79, 14);
		getContentPane().add(lblPostalCode);

		fldPostalCode = new JTextField();
		fldPostalCode.setBounds(374, 109, 175, 20);
		getContentPane().add(fldPostalCode);
		fldPostalCode.setColumns(10);

		lblEmail = new JLabel("Email:");
		lblEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmail.setBounds(294, 134, 70, 14);
		getContentPane().add(lblEmail);

		fldEmail = new JTextField();
		fldEmail.setBounds(374, 134, 175, 20);
		getContentPane().add(fldEmail);
		fldEmail.setColumns(10);

		lblAdd = new JLabel("Add");
		lblAdd.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdd.setBounds(257, 171, 46, 14);
		getContentPane().add(lblAdd);

		btnAddPersonal = new JButton("Personal");
		btnAddPersonal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnAddPersonal_actionPerformed();
			}
		});
		btnAddPersonal.setBounds(176, 191, 89, 23);
		getContentPane().add(btnAddPersonal);

		btnAddBusiness = new JButton("Business");
		btnAddBusiness.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnAddBusiness_actionPerformed();
			}
		});
		btnAddBusiness.setBounds(294, 191, 89, 23);
		getContentPane().add(btnAddBusiness);

		lblHomePhone = new JLabel("Home Phone:");
		lblHomePhone.setEnabled(false);
		lblHomePhone.setHorizontalAlignment(SwingConstants.RIGHT);
		lblHomePhone.setBounds(0, 232, 80, 14);
		getContentPane().add(lblHomePhone);

		fldHomePhoneArea = new JTextField();
		fldHomePhoneArea.setEnabled(false);
		fldHomePhoneArea.setColumns(10);
		fldHomePhoneArea.setBounds(90, 229, 38, 20);
		getContentPane().add(fldHomePhoneArea);

		fldHomePhoneFirst = new JTextField();
		fldHomePhoneFirst.setEnabled(false);
		fldHomePhoneFirst.setColumns(10);
		fldHomePhoneFirst.setBounds(138, 229, 38, 20);
		getContentPane().add(fldHomePhoneFirst);

		fldHomePhoneLast = new JTextField();
		fldHomePhoneLast.setEnabled(false);
		fldHomePhoneLast.setColumns(10);
		fldHomePhoneLast.setBounds(186, 229, 55, 20);
		getContentPane().add(fldHomePhoneLast);

		lblTwitter = new JLabel("Twitter:");
		lblTwitter.setEnabled(false);
		lblTwitter.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTwitter.setBounds(10, 257, 70, 14);
		getContentPane().add(lblTwitter);

		fldTwitter = new JTextField();
		fldTwitter.setEnabled(false);
		fldTwitter.setBounds(90, 254, 175, 20);
		getContentPane().add(fldTwitter);
		fldTwitter.setColumns(10);

		lblInstagram = new JLabel("Instagram:");
		lblInstagram.setEnabled(false);
		lblInstagram.setHorizontalAlignment(SwingConstants.RIGHT);
		lblInstagram.setBounds(10, 282, 70, 14);
		getContentPane().add(lblInstagram);

		fldInstagram = new JTextField();
		fldInstagram.setEnabled(false);
		fldInstagram.setText("");
		fldInstagram.setBounds(90, 279, 175, 20);
		getContentPane().add(fldInstagram);
		fldInstagram.setColumns(10);

		lblRelationship = new JLabel("Relationship:");
		lblRelationship.setEnabled(false);
		lblRelationship.setHorizontalAlignment(SwingConstants.RIGHT);
		lblRelationship.setBounds(0, 307, 80, 14);
		getContentPane().add(lblRelationship);

		cmbxRelationship = new JComboBox();
		cmbxRelationship.setEnabled(false);
		cmbxRelationship.setModel(
				new DefaultComboBoxModel(new String[] { "Unknown", "Spouse/Partner",
						"Family", "Friend", "Acquaintance", "Neighbour", "Other" }));
		cmbxRelationship.setBounds(90, 303, 175, 22);
		getContentPane().add(cmbxRelationship);

		lblWorkPhone = new JLabel("Work Phone:");
		lblWorkPhone.setEnabled(false);
		lblWorkPhone.setHorizontalAlignment(SwingConstants.RIGHT);
		lblWorkPhone.setBounds(294, 232, 70, 14);
		getContentPane().add(lblWorkPhone);

		fldWorkPhoneArea = new JTextField();
		fldWorkPhoneArea.setEnabled(false);
		fldWorkPhoneArea.setColumns(10);
		fldWorkPhoneArea.setBounds(374, 229, 38, 20);
		getContentPane().add(fldWorkPhoneArea);

		fldWorkPhoneFirst = new JTextField();
		fldWorkPhoneFirst.setEnabled(false);
		fldWorkPhoneFirst.setColumns(10);
		fldWorkPhoneFirst.setBounds(422, 229, 38, 20);
		getContentPane().add(fldWorkPhoneFirst);

		fldWorkPhoneLast = new JTextField();
		fldWorkPhoneLast.setEnabled(false);
		fldWorkPhoneLast.setColumns(10);
		fldWorkPhoneLast.setBounds(470, 229, 55, 20);
		getContentPane().add(fldWorkPhoneLast);

		lblCompany = new JLabel("Company:");
		lblCompany.setEnabled(false);
		lblCompany.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCompany.setBounds(294, 257, 70, 14);
		getContentPane().add(lblCompany);

		fldCompany = new JTextField();
		fldCompany.setEnabled(false);
		fldCompany.setBounds(374, 254, 175, 20);
		getContentPane().add(fldCompany);
		fldCompany.setColumns(10);

		lblDepartment = new JLabel("Department:");
		lblDepartment.setEnabled(false);
		lblDepartment.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDepartment.setBounds(294, 282, 70, 14);
		getContentPane().add(lblDepartment);

		fldDepartment = new JTextField();
		fldDepartment.setEnabled(false);
		fldDepartment.setBounds(374, 279, 175, 20);
		getContentPane().add(fldDepartment);
		fldDepartment.setColumns(10);

		lblJobTitle = new JLabel("Job Title:");
		lblJobTitle.setEnabled(false);
		lblJobTitle.setHorizontalAlignment(SwingConstants.RIGHT);
		lblJobTitle.setBounds(294, 307, 70, 14);
		getContentPane().add(lblJobTitle);

		fldJobTitle = new JTextField();
		fldJobTitle.setEnabled(false);
		fldJobTitle.setBounds(374, 304, 175, 20);
		getContentPane().add(fldJobTitle);
		fldJobTitle.setColumns(10);

		btnAdd = new JButton("Add");
		btnAdd.setEnabled(false);
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnAdd_actionPerformed();
			}
		});
		btnAdd.setBounds(176, 369, 89, 23);
		getContentPane().add(btnAdd);

		btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearAllFields();
			}
		});
		btnClear.setBounds(294, 369, 89, 23);
		getContentPane().add(btnClear);

		this.addWindowListener(this);
	} // ContactListFrame()

	public void dateSelector() {
		if (cmbxDOBMonth.getSelectedIndex() == 2) {
			cmbxDOBDay.setModel(new DefaultComboBoxModel(
					new String[] { "DD", "1", "2", "3", "4", "5", "6", "7", "8", "9",
							"10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20",
							"21", "22", "23", "24", "25", "26", "27", "28" }));
		}
		else
			if (cmbxDOBMonth.getSelectedIndex() == 4
					|| cmbxDOBMonth.getSelectedIndex() == 6
					|| cmbxDOBMonth.getSelectedIndex() == 9
					|| cmbxDOBMonth.getSelectedIndex() == 11) {
				cmbxDOBDay.setModel(new DefaultComboBoxModel(new String[] { "DD", "1",
						"2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13",
						"14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24",
						"25", "26", "27", "28", "29", "30" }));
			}
			else {
				cmbxDOBDay.setModel(new DefaultComboBoxModel(new String[] { "DD", "1",
						"2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13",
						"14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24",
						"25", "26", "27", "28", "29", "30", "31" }));
			}
	} // dateSelector()

	private boolean verifyFields() {
		boolean valid = false;
		if (verifyNameFields() && verifyEmail() && verifyPostalCode()
				&& verifyCellphoneFields())
			valid = true;
		else
			JOptionPane.showMessageDialog(this, "An error has occured", "Error",
					JOptionPane.ERROR_MESSAGE);
		return valid;
	} // verifyFields

	private boolean verifyNameFields() {
		boolean valid = false;
		if (fldLastName.getText().length() == 0
				|| fldFirstName.getText().length() == 0)
			JOptionPane.showMessageDialog(this,
					"The contact's full name must be entered.", "Name Incomplete",
					JOptionPane.ERROR_MESSAGE);
		else
			valid = true;
		return valid;
	} // verifyNameFields()

	private boolean verifyEmail() {
		boolean valid = false;
		if (fldEmail.getText().length() == 0)
			JOptionPane.showMessageDialog(this,
					"The contact's email must be entered.", "Email Missing",
					JOptionPane.ERROR_MESSAGE);
		else
			if (!fldEmail.getText().contains("@")
					|| !fldEmail.getText().contains(".")) {
				JOptionPane.showMessageDialog(this,
						"The contact's email does not follow the proper email format (example@example.com).",
						"Email Invalid", JOptionPane.ERROR_MESSAGE);
				fldEmail.setText("");
			} // if (!fldEmail.getText().contains("@") && !fldEmail.getText().contains("."))
			else
				valid = true;
		return valid;
	} // verifyEmail()

	private boolean verifyPostalCode() {
		boolean valid = false;
		if (fldPostalCode.getText().length() != 0) {
			String postalCode = fldPostalCode.getText().replaceAll(" ", "");
			boolean isPostalCode = false;
			if (!Character.isDigit(postalCode.charAt(0))) {
				if (Character.isDigit(postalCode.charAt(1))) {
					if (!Character.isDigit(postalCode.charAt(2))) {
						if (Character.isDigit(postalCode.charAt(3))) {
							if (!Character.isDigit(postalCode.charAt(4))) {
								if (Character.isDigit(postalCode.charAt(5))) {
									isPostalCode = true;
								} // if (Character.isDigit(postalCode.charAt(5)))
							} // if (!Character.isDigit(postalCode.charAt(4)))
						} // if (Character.isDigit(postalCode.charAt(3)))
					} // if (!Character.isDigit(postalCode.charAt(2)))
				} // if (Character.isDigit(postalCode.charAt(1)))
			} // if (!Character.isDigit(postalCode.charAt(0)))
			if (isPostalCode == false)
				JOptionPane.showMessageDialog(this,
						"The contact's postal code does not follow the proper postal code format (X0X0X0).",
						"Postal Code Invalid", JOptionPane.ERROR_MESSAGE);
			else
				valid = true;
		} // if (fldPostalCode.getText().length() != 0)
		else
			valid = true;
		return valid;
	} // verifyPostalCode()

	private boolean verifyCellphoneFields() {
		boolean valid = false;
		if (fldCellphoneArea.getText().length() == 0
				&& fldCellphoneFirst.getText().length() == 0
				&& fldCellphoneLast.getText().length() == 0) {
			int proceed = JOptionPane.showConfirmDialog(this,
					"Do you want to continue without entering the contact's cellphone number?",
					"No Cellphone Number", JOptionPane.YES_NO_OPTION);
			if (proceed == 0)
				valid = true;
		} // if (fldCellphoneArea.getText().length() == 0	&& fldCellphoneFirst.getText().length() == 0 && fldCellphoneLast.getText().length() == 0)
		else
			if (verifyPhoneFields(fldCellphoneArea.getText(),
					fldCellphoneFirst.getText(), fldCellphoneLast.getText(), 'c'))
				valid = true;
		return valid;
	} // verifyCellphoneFields

	private boolean verifyPhoneFields(String pa, String pf, String pl, char t) {
		boolean valid = false;
		String phoneArea = pa;
		String phoneFirst = pf;
		String phoneLast = pl;
		char typeOfPhone = t;

		if (phoneArea.length() != 0 || phoneFirst.length() != 0
				|| phoneLast.length() != 0) {
			if (phoneArea.length() == 0 || phoneFirst.length() == 0
					|| phoneLast.length() == 0) {
				if (typeOfPhone == 'c')
					JOptionPane.showMessageDialog(this,
							"The contact's cellphone number is incomplete",
							"Cellphone Number Incomplete", JOptionPane.ERROR_MESSAGE);
				else
					if (typeOfPhone == 'w')
						JOptionPane.showMessageDialog(this,
								"The contact's work phone number is incomplete",
								"Work Phone Number Incomplete", JOptionPane.ERROR_MESSAGE);
					else
						if (typeOfPhone == 'p')
							JOptionPane.showMessageDialog(this,
									"The contact's Home Phone number is incomplete",
									"Home Phone Number Incomplete", JOptionPane.ERROR_MESSAGE);
			} // if (phoneArea.length() == 0 || phoneFirst.length() == 0 || phoneLast.length() == 0)
			else
				if (phoneArea.length() != 0 && phoneFirst.length() != 0
						&& phoneLast.length() != 0) {
					if (phoneArea.length() != 3 || phoneFirst.length() != 3
							|| phoneLast.length() != 4) {
						if (typeOfPhone == 'c')
							JOptionPane.showMessageDialog(this,
									"The cellphone number does not follow the phone number format (xxx-xxx-xxxx",
									"Invalid Phone Number", JOptionPane.ERROR_MESSAGE);
						else
							if (typeOfPhone == 'w')
								JOptionPane.showMessageDialog(this,
										"The work phone number does not follow the phone number format (xxx-xxx-xxxx",
										"Invalid Phone Number", JOptionPane.ERROR_MESSAGE);
							else
								if (typeOfPhone == 'p')
									JOptionPane.showMessageDialog(this,
											"The Home Phone number does not follow the phone number format (xxx-xxx-xxxx",
											"Invalid Phone Number", JOptionPane.ERROR_MESSAGE);
					} // if (phoneArea.length() != 3 || phoneFirst.length() != 3|| phoneLast.length() != 4)
					else
						valid = true;
				} // if (phoneArea.length() != 0 && phoneFirst.length() != 0 && phoneLast.length() != 0)
				else
					valid = true;
		} //	if (phoneArea.length() != 0 || phoneFirst.length() != 0 || phoneLast.length() != 0)
		return valid;
	} // verifyWorkPhoneFields()

	private void enablePersonalFields(boolean enabled) {
		fldHomePhoneArea.setEnabled(enabled);
		fldHomePhoneFirst.setEnabled(enabled);
		fldHomePhoneLast.setEnabled(enabled);
		lblHomePhone.setEnabled(enabled);
		fldTwitter.setEnabled(enabled);
		lblTwitter.setEnabled(enabled);
		fldInstagram.setEnabled(enabled);
		lblInstagram.setEnabled(enabled);
		cmbxRelationship.setEnabled(enabled);
		lblRelationship.setEnabled(enabled);
	} // enabledPersonalFields(boolean enabled()

	private void enableBusinessFields(boolean enabled) {
		fldWorkPhoneArea.setEnabled(enabled);
		fldWorkPhoneFirst.setEnabled(enabled);
		fldWorkPhoneLast.setEnabled(enabled);
		lblWorkPhone.setEnabled(enabled);
		fldCompany.setEnabled(enabled);
		lblCompany.setEnabled(enabled);
		fldDepartment.setEnabled(enabled);
		lblDepartment.setEnabled(enabled);
		fldJobTitle.setEnabled(enabled);
		lblJobTitle.setEnabled(enabled);
	} // enabledBusinessFields(boolean enabled()

	private void btnAddPersonal_actionPerformed() {
		if (verifyFields()) {
			enablePersonalFields(true);
			enableBusinessFields(false);
			btnAdd.setEnabled(true);
			contactType = 'P';
		}
	} // btnAddPersonal_actionPerformed()

	private void btnAddBusiness_actionPerformed() {
		if (verifyFields()) {
			enableBusinessFields(true);
			enablePersonalFields(false);
			btnAdd.setEnabled(true);
			contactType = 'B';
		}
	} // btnAddBusiness_actionPerformed()

	private void clearAllFields() {
		fldHomePhoneArea.setText("");
		fldHomePhoneFirst.setText("");
		fldHomePhoneLast.setText("");
		fldTwitter.setText("");
		fldInstagram.setText("");
		cmbxRelationship.setSelectedIndex(0);
		fldWorkPhoneArea.setText("");
		fldWorkPhoneFirst.setText("");
		fldWorkPhoneLast.setText("");
		fldCompany.setText("");
		fldDepartment.setText("");
		fldJobTitle.setText("");
		fldLastName.setText("");
		fldFirstName.setText("");
		cmbxDOBDay.setSelectedIndex(0);
		cmbxDOBMonth.setSelectedIndex(0);
		cmbxDOBYear.setSelectedIndex(0);
		fldEmail.setText("");
		fldAddress.setText("");
		fldCity.setText("");
		cmbxProvince.setSelectedIndex(0);
		fldPostalCode.setText("");
		fldCellphoneArea.setText("");
		fldCellphoneFirst.setText("");
		fldCellphoneLast.setText("");
		btnAdd.setEnabled(false);
		enableBusinessFields(false);
		enablePersonalFields(false);
	} // clearAllFields()

	private void checkDOBFields() {
		if (cmbxDOBYear.getSelectedIndex() == 0)
			contact.setDOBYear(0);
		else
			contact.setDOBYear(
					Integer.parseInt(cmbxDOBYear.getSelectedItem().toString()));
		if (cmbxDOBMonth.getSelectedIndex() == 0)
			contact.setDOBMonth(0);
		else
			contact.setDOBMonth(
					Integer.parseInt(cmbxDOBMonth.getSelectedItem().toString()));
		if (cmbxDOBDay.getSelectedIndex() == 0)
			contact.setDOBDay(0);
		else
			contact
					.setDOBDay(Integer.parseInt(cmbxDOBDay.getSelectedItem().toString()));
	} // checkDOBFields()

	private void checkAddressFields() {
		if (!fldAddress.getText().isBlank())
			contact.setAddress(fldAddress.getText());
		if (!fldCity.getText().isBlank())
			contact.setCity(fldCity.getText());
		if (cmbxProvince.getSelectedIndex() != 0)
			contact.setProvince(cmbxProvince.getSelectedItem().toString());
		if (!fldPostalCode.getText().isBlank())
			contact.setPostalCode(fldPostalCode.getText());
	} // checkAddressFields()

	private void checkCellphoneFields() {
		if (verifyPhoneFields(fldCellphoneArea.getText(),
				fldCellphoneFirst.getText(), fldCellphoneLast.getText(), 'c'))
			contact.setCellphone(fldCellphoneArea.getText(),
					fldCellphoneFirst.getText(), fldCellphoneLast.getText());
	} // checkCellphoneFields()

	private boolean checkPersonalFields() {
		checkTwitterField();
		checkInstagramField();
		if (checkHomePhoneFields())
			return true;
		else
			return false;
	} // checkPersonalFields()

	private boolean checkHomePhoneFields() {
		if (verifyPhoneFields(fldHomePhoneArea.getText(),
				fldHomePhoneFirst.getText(), fldHomePhoneLast.getText(), 'p')) {
			((Personal) contact).setHomePhone(fldHomePhoneArea.getText(),
					fldHomePhoneFirst.getText(), fldHomePhoneLast.getText());
			return true;
		}
		else
			return false;
	} // checkHomePhoneFields()

	private void checkTwitterField() {
		if (fldTwitter.getText().length() != 0)
			((Personal) contact).setTwitterHandle(fldTwitter.getText());

	} // checkTwitterField()

	private void checkInstagramField() {
		if (fldInstagram.getText().length() != 0)
			((Personal) contact).setInstagramUsername(fldInstagram.getText());
	} // checkInstagramField()

	private boolean checkBusinessFields() {
		checkDepartmentField();
		checkJobTitleField();
		if (checkCompanyField() && checkWorkPhoneFields())
			return true;
		else
			return false;
	} // checkBusinessFields()

	private boolean checkWorkPhoneFields() {
		if (verifyPhoneFields(fldWorkPhoneArea.getText(),
				fldWorkPhoneFirst.getText(), fldWorkPhoneLast.getText(), 'w')) {
			((Business) contact).setWorkPhone(fldWorkPhoneArea.getText(),
					fldWorkPhoneFirst.getText(), fldWorkPhoneLast.getText());
			return true;
		}
		else
			return false;
	} // checkWorkPhoneFields()

	private boolean checkCompanyField() {
		if (checkCompanyName().length() != 0)
			return true;
		else
			return false;
	} // checkCompanyField()

	private String checkCompanyName() {
		String companyName = "";
		if (fldCompany.getText().length() == 0)
			JOptionPane.showMessageDialog(this, "The company name must be entered.",
					"No company name", JOptionPane.ERROR_MESSAGE);
		else
			companyName = fldCompany.getText();
		return companyName;
	} // checkCompanyField()

	private void checkDepartmentField() {
		if (fldDepartment.getText().length() != 0)
			((Business) contact).setDepartmentName(fldDepartment.getText());
	} // checkDepartmentField()

	private void checkJobTitleField() {
		if (fldJobTitle.getText().length() != 0)
			((Business) contact).setJobTitle(fldJobTitle.getText());
	} // checkJobTitleField()

	private void btnAdd_actionPerformed() {
		if (contactType == 'P') {
			contact = new Personal(fldLastName.getText(), fldFirstName.getText(),
					fldEmail.getText(), cmbxRelationship.getSelectedItem().toString());
			checkDOBFields();
			checkAddressFields();
			checkCellphoneFields();
			if (checkPersonalFields())
				if (((Personal) contact).newPersonal()) {
					JOptionPane.showMessageDialog(this,
							"The personal contact was added successfully with the ID "
									+ contact.getContactIdentifier());
					clearAllFields();
				}
		} // if (contactType == 'P')
		else
			if (contactType == 'B') {
				contact = new Business(fldLastName.getText(), fldFirstName.getText(),
						fldEmail.getText(), checkCompanyName());
				checkDOBFields();
				checkAddressFields();
				checkCellphoneFields();
				if (checkBusinessFields())
					if (((Business) contact).newBusiness()) {
						JOptionPane.showMessageDialog(this,
								"The business contact was added successfully with the ID "
										+ contact.getContactIdentifier());
						clearAllFields();
					}
			} // if (contactType == 'B')
	} // btnAdd_actionPerformed()

	@Override
	public void windowOpened(WindowEvent e) {

	}

	@Override
	public void windowClosing(WindowEvent e) {
		Contact.close();
		if (contactType == 'P')
			Personal.closePersonal();
		else
			if (contactType == 'B')
				Business.closeBusiness();
	}

	@Override
	public void windowClosed(WindowEvent e) {

	}

	@Override
	public void windowIconified(WindowEvent e) {

	}

	@Override
	public void windowDeiconified(WindowEvent e) {

	}

	@Override
	public void windowActivated(WindowEvent e) {

	}

	@Override
	public void windowDeactivated(WindowEvent e) {

	}
} // ContactListFrame class
