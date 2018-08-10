package com.example.rohit.assistent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class principal_registration extends AppCompatActivity {

    DatabaseHelper db;
    EditText et1, et2, et3;
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal_registration);

        db = new DatabaseHelper(this);
        et1 = (EditText) findViewById(R.id.email);
        et2 = (EditText) findViewById(R.id.pass);
        et3 = (EditText) findViewById(R.id.cpass);
        b1 = (Button) findViewById(R.id.register_button);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1 = et1.getText().toString();
                String s2 = et2.getText().toString();
                String s3 = et3.getText().toString();
                if (s1.equals("") || s2.equals("") || s3.equals("")) {
                    Toast.makeText(getApplicationContext(), "Feilds are Empty", Toast.LENGTH_SHORT).show();
                } else {
                    if (s2.equals(s3)) {
                        Boolean chkmail = db.chkemailprincilap(s1);
                        if (chkmail == true) {
                            Boolean insert = db.insertprincipal(s1, s2);
                            if (insert == true) {
                                Toast.makeText(getApplicationContext(), "Register successfully", Toast.LENGTH_LONG).show();
                                startActivity(new Intent(principal_registration.this, principal_login.class));
                            }
                        } else {
                            Toast.makeText(getApplicationContext(), "Email Alredy Exist", Toast.LENGTH_LONG).show();
                        }
                    }
                    Toast.makeText(getApplicationContext(), "Password Do no Match", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
