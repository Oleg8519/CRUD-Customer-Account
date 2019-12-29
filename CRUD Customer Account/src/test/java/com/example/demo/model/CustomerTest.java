package com.example.demo.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;


public class CustomerTest {

    @Test
    public void whenCalledGetFirstName_thenCorrect() {
        Customer customer = new Customer("Julie", "Ford", 55, "julie@domain.com", "Canada", "Kiev");

        assertThat(customer.getFirstName()).isEqualTo("Julie");
    }
    @Test
    public void whenCalledGetLastName_thenCorrect() {
        Customer customer = new Customer("Julie", "Ford", 55, "julie@domain.com", "Canada", "Kiev");

        assertThat(customer.getLastName()).isEqualTo("Ford");
    }
    @Test
    public void whenCalledGetAge_thenCorrect() {
        Customer customer = new Customer("Julie", "Ford", 55, "julie@domain.com", "Canada", "Kiev");

        assertThat(customer.getAge()).isEqualTo(55);
    }

    @Test
    public void whenCalledGetEmail_thenCorrect() {
        Customer customer = new Customer("Julie", "Ford", 55, "julie@domain.com", "Canada", "Kiev");

        assertThat(customer.getEmail()).isEqualTo("julie@domain.com");
    }
    @Test
    public void whenCalledGetCountry_thenCorrect() {
        Customer customer = new Customer("Julie", "Ford", 55, "julie@domain.com", "Canada", "Kiev");

        assertThat(customer.getCountry()).isEqualTo("Canada");
    }

    @Test
    public void whenCalledCity_thenCorrect() {
        Customer customer = new Customer("Julie", "Ford", 55, "julie@domain.com", "Canada", "Kiev");

        assertThat(customer.getCity()).isEqualTo("Kiev");
    }

    @Test
    public void whenCalledSetFirstName_thenCorrect() {
        Customer customer = new Customer("Julie", "Ford", 55, "julie@domain.com", "Canada", "Kiev");

        customer.setFirstName("Julie");

        assertThat(customer.getFirstName()).isEqualTo("Julie");
    }

    @Test
    public void whenCalledSetAge_thenCorrect() {
        Customer customer = new Customer("Julie", "Ford", 55, "julie@domain.com", "Canada", "Kiev");

        customer.setAge(55);

        assertThat(customer.getAge()).isEqualTo(55);
    }

    @Test
    public void whenCalledSetEmail_thenCorrect() {
        Customer customer = new Customer("Julie", "Ford", 55, "julie@domain.com", "Canada", "Kiev");

        customer.setEmail("julie@domain.com");

        assertThat(customer.getEmail()).isEqualTo("julie@domain.com");
    }

    @Test
    public void whenCalledSetCountry_thenCorrect() {
        Customer customer = new Customer("Julie", "Ford", 55, "julie@domain.com", "Canada", "Kiev");

        customer.setCountry("Canada");

        assertThat(customer.getCountry()).isEqualTo("Canada");
    }

    @Test
    public void whenCalledSetCity_thenCorrect() {
        Customer customer = new Customer("Julie", "Ford", 55, "julie@domain.com", "Canada", "Kiev");

        customer.setCity("Kiev");

        assertThat(customer.getCity()).isEqualTo("Kiev");
    }

    @Test
    public void whenCalledtoString_thenCorrect() {
        Customer customer = new Customer("Julie", "Ford", 55, "julie@domain.com", "Canada", "Kiev");
        assertThat(customer.toString()).isEqualTo("Customer{id=0, firstName=Julie, lastName=Ford, age=55, email=julie@domain.com, country=Canada, city=Kiev}");
    }
}
