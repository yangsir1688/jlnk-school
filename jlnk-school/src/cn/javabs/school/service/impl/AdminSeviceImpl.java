package cn.javabs.school.service.impl;

import cn.javabs.school.dao.AdminDao;
import cn.javabs.school.dao.impl.AdminDaoImpl;
import cn.javabs.school.entity.Admin;
import cn.javabs.school.service.AdminService;

/**
 *  管理员的逻辑层的实现类
 */
public class AdminSeviceImpl implements AdminService {
    AdminDao adminDao  = new AdminDaoImpl();
    @Override
    public Admin login(String usercode , String password) {
        Admin  admin  = adminDao.loginAdmin(usercode ,  password);
        return admin;
    }
}
