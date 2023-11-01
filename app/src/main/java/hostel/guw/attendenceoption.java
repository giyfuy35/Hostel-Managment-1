package hostel.guw;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import hostel.guw.databinding.ActivityMainBinding;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;

public class attendenceoption extends AppCompatActivity {
    private EditText tasbeehcountss,cnic,namee,contacts,email,dateofregistration,address,gurdian,contactgurdian,nameguardian;
    private Button ok,cancel,phoneaddress,edit;
    private FirebaseDatabase db= FirebaseDatabase.getInstance();
    private DatabaseReference root= db.getReference().child("Attendence");
    //
    DatePicker picker;
    Button displayDate;


    //image

    Button upload,select;
    ActivityMainBinding binding;
    Uri imageUri;
    StorageReference storageReference;
    ProgressDialog progressDialog;
    ImageView img;
    private String sUusername;


    //

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_attendenceoption);
        upload=findViewById(R.id.uploads);
        select=findViewById(R.id.selects);
        edit=findViewById(R.id.edit);
        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(attendenceoption.this,editregistation.class);
                startActivity(i);
            }
        });

        select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                selectImage();

            }
        });
        upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                uploadImage();
            }
        });


        //
        cnic=findViewById(R.id.in);
        namee=findViewById(R.id.name);
        tasbeehcountss=findViewById(R.id.out);
        contacts=findViewById(R.id.room);
//        email=findViewById(R.id.temail);
//
//        address=findViewById(R.id.taddress);
//        gurdian=findViewById(R.id.tgurdian);
//        contactgurdian=findViewById(R.id.tcontactgurdian);
//        phoneaddress=findViewById(R.id.ok);
//        //
        dateofregistration=findViewById(R.id.tdateofregistration);

        picker=(DatePicker)findViewById(R.id.datePicker);
        displayDate=(Button)findViewById(R.id.button1);
//        nameguardian=findViewById(R.id.ngurdian);
        dateofregistration.setText("Current Date: "+getCurrentDate());
        displayDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dateofregistration.setText("Current Date: "+getCurrentDate());

            }
        });










        //
//        phoneaddress.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent i= new Intent(attendenceoption.this, hostel.guw.phoneaddress.class);
//                startActivity(i);
//
//            }
//        });
        sUusername = dateofregistration.getText().toString();
        if (sUusername.matches("")) {
            Toast.makeText(this, "You did not enter a date ", Toast.LENGTH_SHORT).show();
            return;
        }



        ok=findViewById(R.id.k);

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //
                Intent i= new Intent(attendenceoption.this,dashboard.class);
                startActivity(i);



                //
                String in = tasbeehcountss.getText().toString();
                String name=cnic.getText().toString();
                String out=namee.getText().toString();
                String room=contacts.getText().toString();
//                String temail=email.getText().toString();
                String tdateofregistration=dateofregistration.getText().toString();
//                String taddress=address.getText().toString();
//                String tgurdian=gurdian.getText().toString();
//                String ngurdian=nameguardian.getText().toString();
//                String tcontactgurdian=contactgurdian.getText().toString();

                HashMap<String, String> userMap= new HashMap<>();
                userMap.put("in", in);
                userMap.put("name", name);
                userMap.put("out", out);
                userMap.put("room", room);
//                userMap.put("temail", temail);
                userMap.put("tdateofregistration", tdateofregistration);
//                userMap.put("taddress", taddress);
//                userMap.put("tgurdian",tgurdian);
//                userMap.put("tcontactgurdian",tcontactgurdian);
//                userMap.put("ngurdian",ngurdian);
                root.push().setValue(userMap);



                Toast.makeText(attendenceoption.this, "Suceesfully added", Toast.LENGTH_SHORT).show();




            }
        });


        String textview = getIntent().getStringExtra("keyname");
        tasbeehcountss.setText(textview);
    }
    private void selectImage() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent,100);

    }


    private void uploadImage() {
        progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Uploading File....");
        progressDialog.show();


        SimpleDateFormat formatter = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss", Locale.CANADA);
        Date now = new Date();
        String fileName = formatter.format(now);
        storageReference = FirebaseStorage.getInstance().getReference("images/"+fileName);


        storageReference.putFile(imageUri)
                .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                    @Override
                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {


                        Toast.makeText(attendenceoption.this,"Successfully Uploaded",Toast.LENGTH_SHORT).show();
                        if (progressDialog.isShowing())
                            progressDialog.dismiss();

                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {


                        if (progressDialog.isShowing())
                            progressDialog.dismiss();
                        Toast.makeText(attendenceoption.this,"Failed to Upload",Toast.LENGTH_SHORT).show();


                    }
                });
    }
    //



    //

    private String getCurrentDate() {
        StringBuilder builder=new StringBuilder();;
        builder.append((picker.getMonth() + 1)+"/");//month is 0 based
        builder.append(picker.getDayOfMonth()+"/");
        builder.append(picker.getYear());
        return builder.toString();
    }
    //
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 100 && data != null && data.getData() != null){

            imageUri = data.getData();



        }
    }


    //
}