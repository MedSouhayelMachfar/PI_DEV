package entity;

public class User {
	// Properties
	private int userId;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private boolean etatCompte;
	
	// Constructors
	public User() {
		super();
	}
	
	public User(int userId, String firstName, String lastName, String email, String password, boolean etatCompte) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.etatCompte = etatCompte;
	}

	public User(int userId, String firstName, String lastName, String email, boolean etatCompte) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.etatCompte = etatCompte;
	}
	public User(String firstName, String lastName, String email, String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
	}
	public User(String firstName, String lastName, String email) {
		super();
		this.userId = 0;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.etatCompte = false;
	}
	public User(int userId, String firstName, String lastName, String email) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.etatCompte = false;
	}
	// Getters and setters
	public int getUserId() {
		return userId;
	}

	
	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEtatCompte() {
		return etatCompte;
	}

	public void setEtatCompte(boolean etatCompte) {
		this.etatCompte = etatCompte;
	}

	// Methods
	@Override
	public String toString() {
		return "User [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", etatCompte=" + etatCompte + "]";
	}
}