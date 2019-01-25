package br.com.lefi.markethere.jdbc.tests;

import br.com.lefi.markethere.jdbc.dao.GroupDao;
import br.com.lefi.markethere.jdbc.dao.javaBean.GroupBean;
import br.com.lefi.markethere.jdbc.dao.javaBean.UserBean;
import java.util.Calendar;

/**
 *
 * @author assert
 */
public class GroupDaoTest {
    public static void main(String[] args) {
        GroupBean groupBean = new GroupBean(Calendar.getInstance(), "grupo do sabado", 25);
        for(UserBean groupItem: new GroupDao().getUsersInGroup(1)){
            System.err.println(groupItem);
        }
    }
}
