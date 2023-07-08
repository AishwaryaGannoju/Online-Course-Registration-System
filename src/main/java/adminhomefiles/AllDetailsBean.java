package adminhomefiles;

public class AllDetailsBean {
public AllDetailsBean(String name, String email, String password, int cid, String cname) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
		this.cid = cid;
		this.cname = cname;
	}
private String name;
private String email;
private String password;
private int cid;
private String cname;

public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
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
public int getCid() {
	return cid;
}
public void setCid(int cid) {
	this.cid = cid;
}
public String getCname() {
	return cname;
}
public void setCname(String cname) {
	this.cname = cname;
}

}
