package it.aldi.web.springhibernate.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import it.aldi.web.springhibernate.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

  @Autowired private SessionFactory sessionFactory;

  @Override
  public List<Customer> getCustomers() {

    Session session = sessionFactory.getCurrentSession();

    Query<Customer> query = session.createQuery("from Customer order by lastName", Customer.class);

    List<Customer> customers = query.getResultList();

    return customers;
  }

  @Override
  public void saveCustomer(Customer customer) {

    Session session = sessionFactory.getCurrentSession();

    session.saveOrUpdate(customer);
  }

  @Override
  public Customer getCustomerById(int customerId) {

    Session session = sessionFactory.getCurrentSession();

    Customer customer = session.get(Customer.class, customerId);

    return customer;
  }

  @Override
  public void deleteCustomerById(int customerId) {

    Session session = sessionFactory.getCurrentSession();

    Customer customer = session.get(Customer.class, customerId);

    session.delete(customer);
  }

  @Override
  public List<Customer> findCustomerByName(String customerName) {

    Session session = sessionFactory.getCurrentSession();

    String hql =
        "from Customer where lower(lastName) like :customerName OR lower(firstName) like :customerName";

    Query<Customer> query = session.createQuery(hql, Customer.class);
    query.setParameter("customerName", "%" + customerName.toLowerCase() + "%");

    List<Customer> customers = query.getResultList();
    return customers;
  }
}
