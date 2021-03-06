package it.aldi.web.springhibernate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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

  @GetMapping("/showFormForAddCustomer")
  public String showFormForAddCustomer(Model model) {

    Customer customer = new Customer();

    model.addAttribute("customer", customer);

    return "customer-form";
  }

  @PostMapping("/saveCustomer")
  public String saveCustomer(@ModelAttribute("customer") Customer customer) {

    customerService.saveCustomer(customer);

    return "redirect:/customer/list";
  }

  @GetMapping("/showFormForUpdateCustomer")
  public String showFormForUpdateCustomer(@RequestParam("customerId") int customerId, Model model) {

    Customer customer = customerService.getCustomerById(customerId);

    model.addAttribute("customer", customer);

    return "customer-form";
  }

  @GetMapping("/deleteCustomer")
  public String deleteCustomer(@RequestParam("customerId") int customerId) {

    customerService.deleteCustomerById(customerId);

    return "redirect:/customer/list";
  }

  @PostMapping("/findCustomer")
  public String searchCustomer(
      @RequestParam("searchCustomerName") String customerName, Model model) {

    customerName = customerName.trim();

    List<Customer> customers = customerService.findCustomerByName(customerName);

    model.addAttribute("customers", customers);

    return "list-customer";
  }
}
