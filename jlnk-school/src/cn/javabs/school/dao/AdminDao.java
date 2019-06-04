package cn.javabs.school.dao;

import cn.javabs.school.entity.Admin;

/**
 * 管理员的数据访问层的接口
 */
public interface AdminDao {
    Admin loginAdmin(String usercode, String password);
}
