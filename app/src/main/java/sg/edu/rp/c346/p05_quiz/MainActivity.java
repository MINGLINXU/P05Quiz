package sg.edu.rp.c346.p05_quiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    CheckBox onewaycheck;
    CheckBox roundcheck;
    Button btnPlus;
    Button btnMinus;
    Button btnSubmit;
    TextView paxdisplay;
    TextView inputDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        onewaycheck = findViewById(R.id.OneWay);
        roundcheck = findViewById(R.id.RoundTrip);
        btnPlus = findViewById(R.id.plus);
        btnMinus = findViewById(R.id.minus);
        btnSubmit = findViewById(R.id.submit);
        paxdisplay = findViewById(R.id.paxdisplay);
        inputDisplay = findViewById(R.id.inputDisplay);


        onewaycheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(onewaycheck.isChecked()){
                    roundcheck.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if(roundcheck.isChecked()&& onewaycheck.isChecked()){
                                Toast.makeText(MainActivity.this,"Invalid Input", Toast.LENGTH_SHORT).show();

                            }
                            else{
                                Intent intent = new Intent(getBaseContext(),FlightDetails.class){
                                };
                                intent.putExtra("trip","One Way Trip");
                                startActivity(intent);
                            }
                        }
                    });
                }

            }
        });

        roundcheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(roundcheck.isChecked()){
                    onewaycheck.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            if(onewaycheck.isChecked()&& roundcheck.isChecked()){
                                Toast.makeText(MainActivity.this,"Invalid Input", Toast.LENGTH_SHORT).show();
                            }
                            else{
                                Intent intent = new Intent(getBaseContext(),FlightDetails.class){
                                };
                                intent.putExtra("trip","Round Trip");
                                startActivity(intent);
                            }
                        }
                    });
                }
            }
        });

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(),FlightDetails.class);
                intent.putExtra("value",1);
                startActivity(intent);
            }
        });
        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                paxdisplay.setText(Integer.valueOf(paxdisplay.getText().toString())+1);

            }
        });
        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    paxdisplay.setText(Integer.valueOf(paxdisplay.getText().toString())-1);
            }

        });






    }
}
