package hostel.guw;

import androidx.appcompat.app.AppCompatActivity;

//import android.support.design.widget.TextInputEditText;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class forgotpassword extends AppCompatActivity {
    private EditText tasbeehcountss,cnic,name,contacts,email,dateofregistration,address,gurdian,contactgurdian;
    private Button ok,cancel,phoneaddress;
    private FirebaseDatabase db= FirebaseDatabase.getInstance();
    private DatabaseReference root= db.getReference().child("ResetPassword");



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgotpassword);
//        cnic=findViewById(R.id.tcnic);
        name=findViewById(R.id.tname);
//        tasbeehcountss=findViewById(R.id.tfather);
//        contacts=findViewById(R.id.tcontact);
//        email=findViewById(R.id.temail);
//        dateofregistration=findViewById(R.id.tdateofregistration);
//        address=findViewById(R.id.taddress);
//        gurdian=findViewById(R.id.tgurdian);
//        contactgurdian=findViewById(R.id.tcontactgurdian);
//        phoneaddress=findViewById(R.id.ok);
//        phoneaddress.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent i= new Intent(forgotpassword.this, hostel.hosyel.phoneaddress.class);
//                startActivity(i);
//
//            }
//        });



        ok=findViewById(R.id.k);

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                String tfather = tasbeehcountss.getText().toString();
//                String tcnic=cnic.getText().toString();
                String tname=name.getText().toString();
//                String tcontact=contacts.getText().toString();
//                String temail=email.getText().toString();
//                String tdateofregistration=dateofregistration.getText().toString();
//                String taddress=address.getText().toString();
//                String tgurdian=gurdian.getText().toString();
//                String tcontactgurdian=contactgurdian.getText().toString();

                HashMap<String, String> userMap= new HashMap<>();
//                userMap.put("tfather", tfather);
                userMap.put("tname", tname);
//                userMap.put("tcnic", tcnic);
//                userMap.put("tcontact", tcontact);
//                userMap.put("temail", temail);
//                userMap.put("tdateofregistration", tdateofregistration);
//                userMap.put("taddress", taddress);
//                userMap.put("tgurdian",tgurdian);
//                userMap.put("tcontactgurdian",tcontactgurdian);
                root.push().setValue(userMap);



                Toast.makeText(forgotpassword.this, "Suceesfully added", Toast.LENGTH_SHORT).show();




            }
        });


        String textview = getIntent().getStringExtra("keyname");
        name.setText(textview);
    }
}