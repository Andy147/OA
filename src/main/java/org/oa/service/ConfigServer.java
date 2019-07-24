package org.oa.service;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
@Service
public interface ConfigServer {
    /**
     * 获取全部菜单
     * @return
     */
    public List getMenu();

    /**
     * 根据用户的id查找菜单
     * @param userId
     * @return
     */
    public List getMenuByUserId(int userId);
}
