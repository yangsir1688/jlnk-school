package cn.javabs.school.entity;

/**
 * @author Mryang
 * 管理员
 *  type表示用户管理权限类型 管理员和信息发布员
 */
public class Admin {
    private  Integer id;
    private  String  name;// 管理员的姓名
    private  String  usercode;// 用户账号
    private  String  password;// 用户密码
    private  String  birthday;
    // 类型|表示用户管理权限类型 管理员和信息发布员
    private  String  type;
    // 状态 |  0 表示可使用的账号  、1 表示不可以使用  | 逻辑删除
    private  int    status;

    // 生成getters 和setters 方法 及  toString | 快捷键是 alt + insert

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsercode() {
        return usercode;
    }

    public void setUsercode(String usercode) {
        this.usercode = usercode;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", usercode='" + usercode + '\'' +
                ", password='" + password + '\'' +
                ", birthday='" + birthday + '\'' +
                ", type='" + type + '\'' +
                ", status=" + status +
                '}';
    }
}
