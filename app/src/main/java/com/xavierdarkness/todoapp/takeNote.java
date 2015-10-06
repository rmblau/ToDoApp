package com.xavierdarkness.todoapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;

public class takeNote extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_take_note);
        final Button testBtn = (Button) findViewById(R.id.testBtn);
        final EditText todoText =(EditText) findViewById(R.id.todoText);
        Intent intent = getIntent();
        testBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Firebase("https://xaviertest.firebaseio.com/todoItem")
                        .push()
                       .child("text")
                          .setValue(todoText.getText().toString());
                todoText.setText("");
            }
        });
    }
}
