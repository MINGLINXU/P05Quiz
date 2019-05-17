package sg.edu.rp.c346.p05_quiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class FlightDetails extends AppCompatActivity {

    TextView tripDisplay;
    TextView feeDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flight_details);


        tripDisplay=findViewById(R.id.tripDisplay);
        feeDisplay = findViewById(R.id.feeDisplay);
        Intent intentReceived = getIntent();
        int value = intentReceived.getIntExtra("value",1);
        tripDisplay.setText("You have selected : " + value);



        Intent feetReceived = getIntent();
        double price = feetReceived.getIntExtra("price",1);
        tripDisplay.setText("Your air ticket costs : " + price);
    }
}
