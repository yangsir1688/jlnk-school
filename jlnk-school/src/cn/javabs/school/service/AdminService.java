package cn.javabs.school.service;

import cn.javabs.school.entity.Admin;

/**
 * 管理员的逻辑层接口
 */
public interface AdminService {
    Admin login(String usercode, String password);
}
