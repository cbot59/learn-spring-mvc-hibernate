package it.aldi.web.springhibernate.service;

import java.util.List;

import it.aldi.web.springhibernate.entity.Customer;

public interface CustomerService {

  public List<Customer> getCustomers();

  public void saveCustomer(Customer customer);
}
