package test_scripts;

import base.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;
import static utilities.Requests.createEmployeeReturnId;

public class CreateEmployee extends TestBase {

    @Test
    void create_employee(){
        logger.info("********* staring test to create a new employee  ********** ");
        String employeeId =  createEmployeeReturnId();
        Assert.assertNotEquals(employeeId, null);
    }
}
