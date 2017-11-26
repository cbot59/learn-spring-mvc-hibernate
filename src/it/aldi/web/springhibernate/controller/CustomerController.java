package it.aldi.web.springhibernate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import it.aldi.web.springhibernate.dao.CustomerDAO;
import it.aldi.web.springhibernate.entity.Customer;

@Controller
@RequestMapping("/customer")
public class CustomerController {

  @Autowired private CustomerDAO customerDao;

  @GetMapping("/list")
  public String listCustomer(Model model) {

    List<Customer> customers = customerDao.getCustomers();

    model.addAttribute("customers", customers);

    return "list-customer";
  }
}
