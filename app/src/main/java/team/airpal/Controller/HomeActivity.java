package team.airpal.Controller;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;

import team.airpal.R;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    public void toAddJourney(View v){
        startActivity(new Intent(HomeActivity.this, AddJourneyActivity.class));
    }
}
