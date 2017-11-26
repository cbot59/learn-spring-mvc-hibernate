package it.aldi.web.springhibernate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import it.aldi.web.springhibernate.entity.Customer;
import it.aldi.web.springhibernate.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

  @Autowired private CustomerService customerService;

  @GetMapping("/list")
  public String listCustomer(Model model) {

    List<Customer> customers = customerService.getCustomers();

    model.addAttribute("customers", customers);

    return "list-customer";
  }

  @GetMapping("/showAddCustomerForm")
  public String showAddCustomerForm(Model model) {

    Customer customer = new Customer();

    model.addAttribute("customer", customer);

    return "customer-form";
  }

  @PostMapping("/saveCustomer")
  public String saveCustomer(@ModelAttribute("customer") Customer customer) {

    customerService.saveCustomer(customer);
    return "redirect:/customer/list";
  }
}
