package cn.javabs.service;

import cn.javabs.entity.User;

/**
 * 在1.8版本之前、接口中的方法全部都得是抽象方法、但是因为接口会默认帮我们加入 public abstract | 因此可以不用写 public abstract
 * abstract抽象 不具体的东西！|   只需要写功能  具体代码没有！
 */
public interface UserService {

    public abstract int addUser(User u);

}
