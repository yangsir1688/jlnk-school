package cn.javabs.school.service;

import cn.javabs.school.entity.Admin;

public interface AdminService {
    Admin login(String usercode, String password);
}
