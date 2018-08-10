package com.example.rohit.assistent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class student_login extends AppCompatActivity {

    EditText et1,et2;
    DatabaseHelper db;
    Button b1,b2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_login);
        db = new DatabaseHelper(this);
        et1 = findViewById(R.id.email);
        et2 = findViewById(R.id.pass);
        b1 = findViewById(R.id.login);
        b2 = findViewById(R.id.login_to_registation);

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(student_login.this, teacher_ragistration.class ));
            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = et1.getText().toString();
                String pass = et2.getText().toString();
                Boolean chkmailpass = db.emailpassstudent(email,pass);

                if(chkmailpass == true){
                    Toast.makeText(getApplicationContext(),"Login Successfully",Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(student_login.this,  Student_activity.class ));

                }
                else {
                    Toast.makeText(getApplicationContext(),"Wrong EmailId and Password",Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(student_login.this, student_signup.class ));
                }
            }
        });
    }
}
