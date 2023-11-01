package hostel.guw;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class cashh extends AppCompatActivity {
    Button cashone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cashh);
        cashone=findViewById(R.id.cash1);
        cashone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(cashh.this,CheckoutActivity.class);
                startActivity(i);
            }
        });
    }
}