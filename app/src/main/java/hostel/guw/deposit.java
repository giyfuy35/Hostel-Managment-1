package hostel.guw;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class deposit extends AppCompatActivity {
    Button cashtwo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deposit);
        cashtwo=findViewById(R.id.cash2);
        cashtwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(deposit.this,CheckoutActivity.class);
                startActivity(i);
            }
        });
    }
}