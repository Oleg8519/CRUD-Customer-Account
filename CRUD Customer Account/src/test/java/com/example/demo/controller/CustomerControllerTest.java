package com.example.demo.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.example.demo.model.Customer;
import com.example.demo.service.CustomerServiceImpl;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

public class CustomerControllerTest {
    private static CustomerController customerController;
    private static CustomerServiceImpl mockedCustomerService;
    private static BindingResult mockedBindingResult;
    private static Model mockedModel;

    //экземпляр контроллера пользователя
    @BeforeClass
    public static void setUpCustomerControllerInstance() {
        mockedCustomerService = mock(CustomerServiceImpl.class);
        mockedBindingResult = mock(BindingResult.class);
        mockedModel = mock(Model.class);
        customerController = new CustomerController(mockedCustomerService);
    }

    //правильная регистрация
    @Test
    public void whenCalledshowSignUpForm_thenCorrect() {
        Customer customer = new Customer("Julie", "Ford", 55, "julie@domain.com", "Canada", "Kiev");

        assertThat(customerController.showSignUpForm(customer)).isEqualTo("add-customer");
    }

    //добавить пользователь И пользователь правильный
    @Test
    public void whenCalledaddCustomerAndValidCustomer_thenCorrect() {
        Customer customer = new Customer("Julie", "Ford", 55, "julie@domain.com", "Canada", "Kiev");

        when(mockedBindingResult.hasErrors()).thenReturn(false);

        assertThat(customerController.addCustomer(customer, mockedBindingResult, mockedModel)).isEqualTo("index");
    }

     @Test
    public void whenCalledaddCustomerAndInValidCustomer_thenCorrect() {
        Customer customer = new Customer("Julie", "Ford", 55, "julie@domain.com", "Canada", "Kiev");

        when(mockedBindingResult.hasErrors()).thenReturn(true);

        assertThat(customerController.addCustomer(customer, mockedBindingResult, mockedModel)).isEqualTo("add-customer");
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenCalledshowUpdateForm_thenIllegalArgumentException() {
        assertThat(customerController.showUpdateForm(0, mockedModel)).isEqualTo("update-customer");
    }

    //обновление пользователя
    @Test
    public void whenCalledupdateCustomerAndValidCustomer_thenCorrect() {
        Customer customer = new Customer("Julie", "Ford", 55, "julie@domain.com", "Canada", "Kiev");

        when(mockedBindingResult.hasErrors()).thenReturn(false);

        assertThat(customerController.updateCustomer(1l, customer, mockedBindingResult, mockedModel)).isEqualTo("index");
    }

    //обновление пользователя
    @Test
    public void whenCalledupdateCustomerAndInValidCustomer_thenCorrect() {
        Customer customer = new Customer("Julie", "Ford", 55, "julie@domain.com", "Canada", "Kiev");

        when(mockedBindingResult.hasErrors()).thenReturn(true);

        assertThat(customerController.updateCustomer(1l, customer, mockedBindingResult, mockedModel)).isEqualTo("update-customer");
    }

    //удалить пользователя
    @Test(expected = IllegalArgumentException.class)
    public void whenCalledDeleteCustomer() {
        assertThat(customerController.deleteCustomer(1l, mockedModel)).isEqualTo("index");
    }
}
