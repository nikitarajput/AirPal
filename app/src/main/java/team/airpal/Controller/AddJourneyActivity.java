package team.airpal.Controller;

import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import team.airpal.Model.Journey;
import team.airpal.R;

public class AddJourneyActivity extends AppCompatActivity {
    TextInputEditText flightNumberTextInput;
    static String flightNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_journey);
        flightNumberTextInput = (TextInputEditText) findViewById(R.id.flightNumber);
    }

    public void toConfirmActivity(View v){
        flightNumber = flightNumberTextInput.getText().toString();
        startActivity(new Intent(AddJourneyActivity.this, ConfirmActivity.class));
    }

    public void createJourney() {
        Journey currentJourney = new Journey(flightNumber);
    }
}
