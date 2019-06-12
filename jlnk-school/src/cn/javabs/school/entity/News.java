package cn.javabs.school.entity;

public class News {
    private  int id;
    private  String title;
    private  String author;
    private  String description;
    private  String content;
    private  int click;
    private  String createTime;
    // 栏目columns
    private  Column columns;



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getClick() {
        return click;
    }

    public void setClick(int click) {
        this.click = click;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public Column getColumns() {
        return columns;
    }

    public void setColumns(Column columns) {
        this.columns = columns;
    }

    @Override
    public String toString() {
        return "News{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", description='" + description + '\'' +
                ", content='" + content + '\'' +
                ", click=" + click +
                ", createTime='" + createTime + '\'' +
                ", columns=" + columns +
                '}';
    }
}
