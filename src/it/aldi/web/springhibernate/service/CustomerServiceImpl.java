package it.aldi.web.springhibernate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.aldi.web.springhibernate.dao.CustomerDAO;
import it.aldi.web.springhibernate.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

  @Autowired private CustomerDAO customerDao;

  @Override
  @Transactional
  public List<Customer> getCustomers() {
    return customerDao.getCustomers();
  }

  @Override
  @Transactional
  public void saveCustomer(Customer customer) {
    customerDao.saveCustomer(customer);
  }
}
