package com.example.newbookit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;

import org.junit.Test;

public class LoginActivityTest {

    @Test
    public void testCheckUser_User() {
        // דמה את ה-DataSnapshot עם סוג משתמש 'user'
        DataSnapshot snapshot = mock(DataSnapshot.class);
        when(snapshot.child("userType").getValue(String.class)).thenReturn("user");

        // בצע את הבדיקה
        String userType = checkUserType(snapshot); // הנח שיש לך פונקציה שמחזירה את סוג המשתמש

        assertEquals("user", userType);
    }

    public String checkUserType(DataSnapshot snapshot) {

        // נחפש ב-snapshot את הערך של "userType"
        String userType = snapshot.child("userType").getValue(String.class);

        // מחזירים את סוג המשתמש, או מחרוזת ריקה אם הערך לא קיים
        return userType != null ? userType : "";
    }

    @Test
    public void validateData_InvalidEmail_ShowToast() {
        LoginActivity activity = new LoginActivity();
        activity.passLogin.setText("");
        activity.userLogin.setText("Noam");

        assertFalse(activity.validateData());

    }
}