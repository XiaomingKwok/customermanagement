package org.kaku.chapter2.controller;

import org.kaku.chapter2.model.Customer;
import org.kaku.chapter2.service.CustomerService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @Author: kaku
 * @Description:进入 客户列表 界面
 * @Date: Created on 4/4/18.
 */
@WebServlet("/customer")
public class CustomerServlet extends HttpServlet {

    private CustomerService customerService;

    /*
     *@Author: apple
     *@Description:避免创建多个CustomerService实例,整个应用只需要一个.后续用单例模式优化
     *@Date: 10:56 AM 4/5/18
     *@Param:  * @param null
     */
    @Override
    public void init() throws ServletException {
        customerService = new CustomerService();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Customer> customerList = customerService.getCustomerList();
        req.setAttribute("customerList", customerList);
        req.getRequestDispatcher("/WEB-INF/view/customer.jsp").forward(req, resp);
    }
}
