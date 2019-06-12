package cn.javabs.bookstore.entity;
/**
 * 用户实体类的设计
 * @author Mryang
 *
 */
public class User {

	private  String id;
	
	private  String username;
	
	private  String password ;

	// 用户角色问题： 0是普通用户、 1是管理员
	private String type;
	

	private  String sex;

//	 alt+shift+s  -- r  生成了getter 和setter 方法
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", password="
				+ password + ", type=" + type + ", sex=" + sex + "]";
	}
	
}
