package utilities;


import com.github.javafaker.Faker;
import objects.Employee;

public class Test_data_employee {

public static Employee employee_test_data(){
    Faker faker = new Faker();
    Employee employee = new Employee();
    employee.setEmployee_name(faker.name().fullName());
    employee.setEmployee_salary(faker.number().numberBetween(40000, 100000));
    employee.setEmployee_age(faker.number().numberBetween(20, 100));
    employee.setProfile_image(faker.avatar().image());
    return employee;
}
    public static Employee partially_update_employee_test_data(){
        Faker faker = new Faker();
        Employee employee = new Employee();
        employee.setEmployee_name(faker.name().fullName());
        employee.setProfile_image(faker.avatar().image());
        return employee;
    }
}
