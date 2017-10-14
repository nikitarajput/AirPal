package team.airpal.Controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import team.airpal.R;

public class MeetupsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meetups);
    }

    public void toCreateMeetupActivity(View view){
        startActivity(new Intent(MeetupsActivity.this, CreateMeetupActivity.class));
    }
}
