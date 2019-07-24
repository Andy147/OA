package org.oa.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Repository
@Transactional
public interface ConfigDao {
    /**
     * 获取菜单
     * @return
     */
    public List getAllMenu();

    /**
     * 根据用户名查找菜单
     * @param userId
     * @return
     */
    public List getMenuByUserId(int userId);
}
