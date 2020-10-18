
public class Connection {
	private static Connection instance;
	
	
	// de tranh truong hop van bi goi
	private Connection() {
		
	}
	
	public static Connection getInstance() {
		if(instance == null) {
			instance = new Connection();
		}
		return instance;
	}
}
