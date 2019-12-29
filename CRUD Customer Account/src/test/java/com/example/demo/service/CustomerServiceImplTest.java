package com.example.demo.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import com.example.demo.model.Customer;
import com.example.demo.repository.CustomerRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
public class CustomerServiceImplTest {

    @Mock
    private CustomerRepository customerRepository;

    @InjectMocks
    private CustomerServiceImpl customerService;

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void saveCustomer(){
        Customer customer = new Customer(5,"Julie", "Ford", 55, "julie@domain.com", "Canada", "Kiev");
        when(customerRepository.save(customer)).thenReturn(customer);
        Customer result = customerService.saveCustomer(customer);
        assertEquals(5, result.getId());
        assertEquals("Julie", result.getFirstName());
        assertEquals("Ford", result.getLastName());
        assertEquals(55, result.getAge());
        assertEquals("julie@domain.com", result.getEmail());
        assertEquals("Canada", result.getCountry());
        assertEquals("Kiev", result.getCity());
    }

    @Test
    public void deleteCustomer(){
        Customer customer = new Customer(5,"Julie", "Ford", 55, "julie@domain.com", "Canada", "Kiev");
        customerService.deleteCustomer(customer);
        verify(customerRepository, times(1)).delete(customer);
    }
    @Test
    public void findAllCustomer(){
        List<Customer> customerList = new ArrayList<Customer>();
        customerList.add(new Customer(1,"Julie", "Ford", 55, "julie@domain.com", "Canada", "Kiev"));
        customerList.add(new Customer(2,"Julie", "Ford", 56, "julie@domain.com", "Canada", "Kiev"));
        customerList.add(new Customer(3,"Julie", "Ford", 65, "julie@domain.com", "Canada", "Kiev"));
        when(customerRepository.findAll()).thenReturn(customerList);

        List<Customer> result = customerService.findAll();
        assertEquals(3, result.size());
    }
    // @Test
    // public void getCustomerById(){
    //     Customer user = new Customer(1,"Sample 1","qwqwqwqwqw");
    //     when(userRepository.findOne(1L)).thenReturn(user);
    //     User result = userService.getUserById(1);
    //     assertEquals(1, result.getId());
    //     assertEquals("Sample 1", result.getName());
    //     assertEquals("qwqwqwqwqw", result.getEmail());
    // }
}
