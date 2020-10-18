package model;

public class Reader {
	private static int id = 10000000;
	private int readerID;
	private String fullName;
	private String address;
	private String phoneNumberString;
	public Reader() {
		super();
	}
	public Reader(int readerID) {
		super();
		this.readerID = readerID;
	}
	public Reader(int readerID, String fullName, String address, String phoneNumberString) {
		super();
		this.readerID = readerID;
		this.fullName = fullName;
		this.address = address;
		this.phoneNumberString = phoneNumberString;
	}
	public static int getId() {
		return id;
	}
	public static void setId(int id) {
		Reader.id = id;
	}
	public int getReaderID() {
		return readerID;
	}
	public void setReaderID(int readerID) {
		this.readerID = readerID;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhoneNumberString() {
		return phoneNumberString;
	}
	public void setPhoneNumberString(String phoneNumberString) {
		this.phoneNumberString = phoneNumberString;
	}
		
	
	
}
