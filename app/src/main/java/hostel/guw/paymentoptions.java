package hostel.guw;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class paymentoptions extends AppCompatActivity {
    Button credit,payment,deposit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paymentoptions);
        credit=findViewById(R.id.credit);
        payment=findViewById(R.id.cash);
        deposit=findViewById(R.id.dep);
        credit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(paymentoptions.this, CheckoutActivity.class);
                startActivity(i);
            }
        });
        payment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(paymentoptions.this, cashh.class);
                startActivity(i);

            }
        });
        deposit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(paymentoptions.this, deposit.class);
                startActivity(i);

            }
        });
    }
}