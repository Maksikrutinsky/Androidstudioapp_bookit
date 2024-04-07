package com.technifysoft.bookapp;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.technifysoft.bookapp.activities.ForgotPasswordActivity;

@RunWith(RobolectricTestRunner.class)

public class ForgotPasswordActivityTest {

    @Test
    public void emailValidation_CorrectEmail_ReturnsTrue() {
        ForgotPasswordActivity activity = new ForgotPasswordActivity();
        assertTrue(activity.isEmailValid("test@example.com"));
    }

    @Test
    public void emailValidation_EmptyEmail_ReturnsFalse() {
        ForgotPasswordActivity activity = new ForgotPasswordActivity();
        assertFalse(activity.isEmailValid(""));
    }

    @Test
    public void emailValidation_IncorrectEmail_ReturnsFalse() {
        ForgotPasswordActivity activity = new ForgotPasswordActivity();
        assertFalse(activity.isEmailValid("test"));
    }

}
