package container.user;

import org.springframework.stereotype.Component;

@Component
public class User {

	private int no = 0;
	private String name = "김송현";

	public User() {
		
	}
	
	public User(String name) {
		this.name = name;
	}
	
	
	@Override
	public String toString() {
		return "User [no=" + no + ", name=" + name + "]";
	}

	
}
