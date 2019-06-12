package cn.javabs.school.service;

import cn.javabs.school.entity.User;

import java.util.List;

public interface UserService {

    User UserLogin(String username , String  password);


    ///*********************************************

    int addUser(User user);
    int delUser(int id);
    int updateUser(User user);

    List<User> findAllUser();
    User findUserById(int id);

    User findUserByName(String username);

}
