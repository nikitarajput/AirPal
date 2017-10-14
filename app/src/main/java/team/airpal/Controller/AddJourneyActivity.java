package team.airpal.Controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import team.airpal.R;

public class AddJourneyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_journey);
    }

    public void toConfirmActivity(View v){
        startActivity(new Intent(AddJourneyActivity.this, ConfirmActivity.class));
    }
}
