package cn.javabs.entity;


import org.junit.Test;

public class User {
    // 基础数据类型：char    包装类Character【复合数据类型】
    private  Integer id;
    private  String username;
    private  String password;
    private  String sex;

    // alt+insert  -->  getter and setter --> ok

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
}
