package org.oa.service.impl;

import org.oa.dao.ConfigDao;
import org.oa.model.Menu;
import org.oa.service.ConfigServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
@Service
public class ConfigServerImpl implements ConfigServer {
    @Autowired
    ConfigDao configDao;
    @Override
    public List getMenu() {
        System.out.println("查询所有菜单");
        List list = configDao.getAllMenu();
        return returnMenuList( list);
    }

    @Override
    public List getMenuByUserId(int userId) {
        List list = configDao.getMenuByUserId(userId);
        return returnMenuList( list);
    }

    /**
     * 处理返回来的菜单
     * @param list
     * @return
     */
    private List returnMenuList(List list)
    {
        List<Menu> result = new ArrayList<Menu>();
        for (int i=0 ; i < list.size() ;i++)
        {
            Map map = (Map) list.get(i);
            //先找到父节点
            String parent_id = (String) map.get("parent_id");
            if (null == parent_id)
            {
                Menu menu = new Menu();
                List<Map> ms = new ArrayList<>();
                String idPar = (String) map.get("menu_id");
                menu.setParent(map);
                //根据父节点的ID去查找子节点
                for(int j=0 ; j < list.size() ; j++)
                {
                    Map m = (Map) list.get(j);
                    if (m.get("parent_id") !=null && idPar.equals(m.get("parent_id")) )
                    {
                        ms.add(m);
                    }
                }
                menu.setChildren(ms);
                result.add(menu);
            }
        }
        return result;
    }
}
