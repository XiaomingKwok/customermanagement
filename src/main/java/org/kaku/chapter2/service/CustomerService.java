package org.kaku.chapter2.service;


import org.kaku.chapter2.helper.DatabaseHelper;
import org.kaku.chapter2.model.Customer;
import org.kaku.chapter2.util.PropsUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;


/**
 * @Author: kaku
 * @Description:
 * @Date: Created on 3/31/18.
 */
public class CustomerService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerService.class);

    /*
     *@Author: apple
     *@Description:获取客户列表,暂不考虑分页
     *@Date: 1:37 AM 3/28/18
     *@Param:  * @param keyword
     */
    public List<Customer> getCustomerList(){
        String sql = "SELECT * FROM customer";
        return DatabaseHelper.queryEntityList(Customer.class, sql);
    }

    /*
     *@Author: apple
     *@Description:
     *@Date: 1:38 AM 3/28/18
     *@Param:  * @param null
     */
    public Customer getCustomer(long id){
        String sql = "SELECT * FROM customer WHERE id = " + id;
        Customer customer = DatabaseHelper.queryEntity(Customer.class, sql);
        return customer;
    }

    public boolean createCustomer(Map<String, Object> fieldMap){
        return DatabaseHelper.insertEntity(Customer.class, fieldMap);
    }

    public boolean updateCustomer(long id, Map<String, Object> fieldMap){
        return DatabaseHelper.updateEntity(Customer.class, id, fieldMap);
    }

    public boolean deleteCustomer(long id){
        return DatabaseHelper.deleteEntity(Customer.class, id);
    }
}
