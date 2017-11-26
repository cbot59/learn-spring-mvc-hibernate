package it.aldi.web.springhibernate.dao;

import java.util.List;

import it.aldi.web.springhibernate.entity.Customer;

public interface CustomerDAO {

  public List<Customer> getCustomers();

  public void saveCustomer(Customer customer);
}
