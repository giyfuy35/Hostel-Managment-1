package hostel.guw;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

import androidx.appcompat.app.AppCompatActivity;
import hostel.guw.R;

public class leaveapplication extends AppCompatActivity {
    EditText Leavingdate,joining,Reason,Name,Cnic,City,contacts;
    Button ok;
    private FirebaseDatabase db= FirebaseDatabase.getInstance();
    private DatabaseReference root= db.getReference().child("leave application");
    private String sUsername;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leaveapplication);
        Leavingdate=findViewById(R.id.tleaving);
        joining=findViewById(R.id.tjoiningdate);
        Reason=findViewById(R.id.treasonofleave);
        Name=findViewById(R.id.tname);
        Cnic=findViewById(R.id.tCNIC);
        City=findViewById(R.id.tcityy);
        contacts=findViewById(R.id.tcontacts);
        ok=findViewById(R.id.ok);
        //

//        sUsername = Cnic.getText().toString();
//        if (sUsername.matches("")) {
//            Toast.makeText(this, "You did not enter a date ", Toast.LENGTH_SHORT).show();
//            return;
//        }





        //
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(leaveapplication.this,dashboard.class);
                startActivity(i);
                String tleaving = Leavingdate.getText().toString();
                String tjoiningdate=joining.getText().toString();
                String treasonofleave=Reason.getText().toString();
                String tname=Name.getText().toString();
                String tCNIC=Cnic.getText().toString();
                String tcityy=  City.getText().toString();
                String tcontacts=  contacts.getText().toString();
                HashMap<String, String> userMap= new HashMap<>();
                userMap.put("tleaving", tleaving);
                userMap.put("tjoiningdate", tjoiningdate);
                userMap.put("treasonofleave", treasonofleave);
                userMap.put("tname", tname);
                userMap.put("tCNIC", tCNIC);
                userMap.put("tcity", tcityy);
                userMap.put("tcontacts", tcontacts);
                root.push().setValue(userMap);
                Toast.makeText(leaveapplication.this, "Suceesfully added", Toast.LENGTH_SHORT).show();

            }
        });
        String textview = getIntent().getStringExtra("keyname");
        Leavingdate.setText(textview);
    }
}