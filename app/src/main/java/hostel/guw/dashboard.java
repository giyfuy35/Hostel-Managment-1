package hostel.guw;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.google.firebase.messaging.FirebaseMessaging;

public class dashboard extends AppCompatActivity {
    Button map,reges,pzyment,phone,leave,edit,atted,client,staff;
    ImageView bookig,looc,pay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        FirebaseMessaging.getInstance().subscribeToTopic("notifaction");
        map=findViewById(R.id.locc);
        staff=findViewById(R.id.staffregistration);
        client=findViewById(R.id.clientregistration);
        reges=findViewById(R.id.hostelregistration);
        pzyment=findViewById(R.id.qrccode);
        bookig=findViewById(R.id.books);
        leave=findViewById(R.id.leave);
//        edit=findViewById(R.id.editregistration);
        phone=findViewById(R.id.phone);
        looc=findViewById(R.id.hostelnewlocation);
        pay=findViewById(R.id.newsadapay);
        atted=findViewById(R.id.at);
        staff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(dashboard.this, staff.class);
                startActivity(i);

            }
        });
        client.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(dashboard.this, hostelregistry.class);
                startActivity(i);

            }
        });
        atted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(dashboard.this, attendenceoption.class);
                startActivity(i);


            }
        });
//        edit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent i= new Intent(dashboard.this, hostelregistry.class);
//                startActivity(i);
//
//            }
//        });
        bookig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(dashboard.this, hostelregistry.class);
                startActivity(i);


            }
        });

        leave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(dashboard.this, leaveapplication.class);
                startActivity(i);

            }
        });
        looc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(dashboard.this, MapsActivity.class);
                startActivity(i);

            }
        });
        pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(dashboard.this, paymentoptions.class);
                startActivity(i);

            }
        });
        pzyment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(dashboard.this, MainActivitysql.class);
                startActivity(i);

            }
        });
        phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(dashboard.this, phone.class);
                startActivity(i);


            }
        });
        looc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(dashboard.this, MapsActivity.class);
                startActivity(i);

            }
        });
//        qrc.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent i= new Intent(dashboard.this, payment.class);
//                startActivity(i);
//
//            }
//        });
        reges.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(dashboard.this, subcatagory.class);
                startActivity(i);

            }
        });
        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(dashboard.this, MapsActivity.class);
                startActivity(i);
            }
        });
    }
}