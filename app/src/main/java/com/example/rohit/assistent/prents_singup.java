package com.example.rohit.assistent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class prents_singup extends AppCompatActivity {

    DatabaseHelper db;
    EditText et1,et2,et3;
    Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prents_singup);

        db = new DatabaseHelper(this);
        et1 = findViewById(R.id.email);
        et2 = findViewById(R.id.pass);
        et3 = findViewById(R.id.cpass);
        b1 = findViewById(R.id.register_button);

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
                        Boolean chkmail = db.chkemailparents(s1);
                        if (chkmail == true) {
                            Boolean insert = db.insertparents(s1, s2);
                            if (insert == true) {
                                Toast.makeText(getApplicationContext(), "Register successfully", Toast.LENGTH_LONG).show();
                                startActivity(new Intent(prents_singup.this, parents_login.class));
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
