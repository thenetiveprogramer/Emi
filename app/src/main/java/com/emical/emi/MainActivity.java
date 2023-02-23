package com.emical.emi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText amt,Intrest,mnt;

    Button cal;

    TextView txtEmi,txtTotalamt,txtIntrestamt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        amt = findViewById(R.id.amt);
        Intrest = findViewById(R.id.Intrest);
        mnt = findViewById(R.id.mnt);
        cal = findViewById(R.id.cal);
        txtEmi = findViewById(R.id.Emi);
        txtTotalamt = findViewById(R.id.Totalamt);
        txtIntrestamt = findViewById(R.id.Intrestamt);

        cal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int amount = Integer.parseInt(amt.getText().toString());
                double rest = Double.parseDouble(Intrest.getText().toString());
                int month = Integer.parseInt(mnt.getText().toString());

                double r = rest/(12*100);
                double cal = 1;
                for (int i = 0; i < month; i++) {
                    cal *= (1+r);

                }

                double ans = amount*r*(cal/(cal-1));

                txtEmi.setText("Emi = "+ans);
                double total = ans*month;
                txtTotalamt.setText("Total amt ="+total);
                double Intrestamt = total-amount;
                txtIntrestamt.setText("Intrest amt ="+Intrestamt);
            }
        });
    }
}