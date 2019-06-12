package cn.javabs.bookstore.entity;

import java.io.Serializable;

/**
 * 分类的实体设计
 * @author Mryang
 * Serializable 序列化： 为了网络的传输
 */
@SuppressWarnings("serial")
public class Category implements Serializable {
	
	// 字符串类型的分类编号
	private String id;
	
	//字符串类型的分类名称
	private String name;
	
	//字符串类型的分类描述
	private String description;

	
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", description="
				+ description + "]";
	}

}
