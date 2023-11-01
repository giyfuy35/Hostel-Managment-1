package hostel.guw;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class loginportal extends AppCompatActivity {
    Button staff,admin,client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginportal);
        staff=findViewById(R.id.staafs);
        admin=findViewById(R.id.admins);
        client=findViewById(R.id.cl);
        staff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(loginportal.this,login.class);
                startActivity(i);
            }
        });
        client.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(loginportal.this,login.class);
                startActivity(i);
            }


        });
        admin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(loginportal.this,login.class);
                startActivity(i);

            }
        });
    }
}