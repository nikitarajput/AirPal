package team.airpal.Controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import team.airpal.Model.Meetup;
import team.airpal.R;

public class ConfirmActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm);
    }

    public void toMeetups(View v){
        AddJourneyActivity addJourney = new AddJourneyActivity();
        addJourney.createJourney();
        startActivity(new Intent(ConfirmActivity.this, MeetupsActivity.class));
    }

    public void toAddJourney(View v){
        startActivity(new Intent(ConfirmActivity.this, AddJourneyActivity.class));
    }
}
