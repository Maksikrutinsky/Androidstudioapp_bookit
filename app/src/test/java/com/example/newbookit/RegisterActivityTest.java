package com.example.newbookit;

import static org.junit.Assert.*;

import org.junit.Test;

public class RegisterActivityTest {

    @Test
    public void testValidateData_invalidEmail() {
        RegisterActivity activity = new RegisterActivity();
        activity.nameReg.setText("Maksi");
        activity.passReg.setText("pass123");
        activity.userReg.setText("blabla");
        activity.cpassReg.setText("pass123");

        assertFalse(activity.validateData());
    }

    @Test
    public void testValidateData_emptyPassword() {
        RegisterActivity activity = new RegisterActivity();
        activity.nameReg.setText("Maksi");
        activity.passReg.setText("");
        activity.userReg.setText("Maksi@gmail.com");
        activity.cpassReg.setText("pass123");

        assertFalse(activity.validateData());
    }


    @Test
    public void testValidateData_passwordMismatch() {
        RegisterActivity activity = new RegisterActivity();
        activity.nameReg.setText("Maksi");
        activity.passReg.setText("Maksi123");
        activity.userReg.setText("example@example.com");
        activity.cpassReg.setText("Maksi456");

        assertFalse(activity.validateData());
    }

    @Test
    public void testValidateData_validData() {
        RegisterActivity activity = new RegisterActivity();
        activity.nameReg.setText("Maksi");
        activity.passReg.setText("Maksi123");
        activity.userReg.setText("Maksi@gmail.com");
        activity.cpassReg.setText("Maksi123");

        assertTrue(activity.validateData());
    }

}