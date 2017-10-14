package team.airpal.Controller;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import team.airpal.R;

public class CreateMeetupActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_meetup);
    }

    public void toMeetupsActivity(View view){
        startActivity(new Intent(CreateMeetupActivity.this, MeetupsActivity.class));
    }
}
