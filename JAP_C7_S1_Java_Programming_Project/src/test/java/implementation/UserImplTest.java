package implementation;

import myExceptions.MyException;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class UserImplTest
{
    UserImpl obj = new UserImpl(); Scanner sc = new Scanner(System.in);

    @Test
    void mobileNoVerifier() throws MyException
    {
        String mobile = "9890866705";
        String mobileNo = "9423431543";
        assertEquals(mobile, obj.mobileNoVerifier(mobile));
        assertEquals(mobileNo, obj.mobileNoVerifier(mobileNo));
    }

    @Test
    void emailIdVerifier() throws MyException {
        String emailId = "hsyed2915@gmail.com";
        String email = "hamza@gmail.com";
        assertEquals(emailId, obj.emailIdVerifier(emailId));
        assertEquals(email, obj.emailIdVerifier(email));
    }
}