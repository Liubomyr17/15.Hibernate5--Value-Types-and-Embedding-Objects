package com.infotech.client;

import com.infotech.entities.Employee;
import com.infotech.model.Address;
import com.infotech.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;

import java.util.Date;

public class ClientTest {

    public static void main(String[] args) {
        try( Session session = HibernateUtil.getSessionFactory().openSession()) {

            createEmployee(session);
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    }

    private static void createEmployee(Session session) {
        session.beginTransaction();
        Integer id =(Integer)session.save(getEmployee());
        System.out.println("Employee is created  with Id::"+id);
        session.getTransaction().commit();

    }

    private static Employee getEmployee(){
        Employee employee= new Employee();
        employee.setEmployeeName("Barry Bingel");
        employee.setEmail("barry.cs2017@gmail.com");
        employee.setSalary(50000.00);
        employee.setDoj(new Date());

        Address address = new Address ();
        address.setCity ("Chennai");
        address.setPincode (90123L);
        address.setState ("IL");
        address.setStreet ("Park St.");
        employee.setAddress (address);

        return employee;
    }
}