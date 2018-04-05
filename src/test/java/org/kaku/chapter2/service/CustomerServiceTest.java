package org.kaku.chapter2.service;

import org.apache.commons.collections4.functors.WhileClosure;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.kaku.chapter2.helper.DatabaseHelper;
import org.kaku.chapter2.model.Customer;
import org.kaku.chapter2.service.CustomerService;


import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: kaku
 * @Description: CustomerService 单元测试
 * @Date: Created on 3/30/18.
 */
public class CustomerServiceTest {

    private final CustomerService customerService;

    public CustomerServiceTest(){
        customerService = new CustomerService();
    }

    @Before
    public void init()throws Exception{
        DatabaseHelper.executeSqlFile("sql/customer_init.sql");
    }

    @Test
    public void getCustomerListTest() throws Exception{
        List<Customer> customerList = customerService.getCustomerList();
        Assert.assertEquals(2, customerList.size());
    }

    @Test
    public void getCustomerTest() throws Exception{
        long id = 1;
        Customer customer = customerService.getCustomer(id);
        Assert.assertNotNull(customer);
    }

    @Test
    public void createCustomerTest() throws Exception{
        Map<String, Object> fileMap = new HashMap<String, Object>();
        fileMap.put("name", "customer3");
        fileMap.put("contact", "John");
        fileMap.put("telephone", "13344444444");
        boolean result = customerService.createCustomer(fileMap);
        Assert.assertTrue(result);
    }

    @Test
    public void updateCustomer() throws Exception{
        long id =1;
        Map<String, Object> fileMap = new HashMap<String, Object>();
        fileMap.put("contact", "Eric");
        boolean result = customerService.updateCustomer(id, fileMap);
        Assert.assertTrue(result);
    }

    @Test
    public void deleteCustomer() throws Exception{
        long id = 1;
        boolean result = customerService.deleteCustomer(id);
        Assert.assertTrue(result);
    }
}
