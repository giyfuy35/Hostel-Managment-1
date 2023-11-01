package hostel.guw;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class phoneaddress extends AppCompatActivity {
    Button phone,address;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phoneaddress);
        phone=findViewById(R.id.newohone);
        address=findViewById(R.id.newaddress);
       phone.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent i=new Intent(phoneaddress.this,phone.class);
               startActivity(i);
           }
       });
       address.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent i=new Intent(phoneaddress.this,MapsActivity.class);
               startActivity(i);

           }
       });
    }
}