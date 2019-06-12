package cn.javabs.bookstore.entity;
/**
 * 图书的实体类设计
 * @author Mryang
 *
 */
public class Book {
	
	
	

	private String id; //  图书编号
	private String name;// 图书名称
	private String author;// 作者
	private String description;// 图书描述
	private String publish;// 图书的出版社
	private float  price;// 图书的单价
	// 图片 的显示 = 图片的路径                         + 图片的名称
	// 示例：E:\20181119-201811-28\资料\图解\2018-11-21.png
	// 图片的路径
	private String path;
	// 图片的名称
	private String photoName;
	// 分类的id
	private String categoryId;
	
//	private Category categoryIds;//这是面向对象的写法，日后这么写
	
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
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPublish() {
		return publish;
	}
	public void setPublish(String publish) {
		this.publish = publish;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public String getPhotoName() {
		return photoName;
	}
	public void setPhotoName(String photoName) {
		this.photoName = photoName;
	}
	public String getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}
	@Override
	public String toString() {
		return "图书详细："+"<br/><br/>"+"图书名称=" + name +"<br/><br/>"+ ", 图书作者=" + author
				+ "<br/><br/>"+", 图书描述=" + description +"<br/><br/>"+ ", 图书出版社=" + publish
				+ "<br/><br/>"+", 图书售价=" + price ;
	}
	
}
