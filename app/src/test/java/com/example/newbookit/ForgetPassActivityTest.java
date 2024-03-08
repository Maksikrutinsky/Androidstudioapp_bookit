package com.example.newbookit;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.verify;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

import org.junit.Test;
import org.mockito.Mock;

public class ForgetPassActivityTest {


    @Mock
    private FirebaseAuth firebaseAuth;

    @Mock
    private Task<Void> task;


    @Test
    public void sendPasswordResetEmail_Success() {
        doAnswer(invocation -> {
            OnCompleteListener<Void> callback = invocation.getArgument(0);
            callback.onComplete(task);
            return null;
        }).when(task).addOnCompleteListener(any());

        verify(firebaseAuth).sendPasswordResetEmail(anyString());

    }
}