package team.airpal.Controller;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import team.airpal.Model.Meetup;
import team.airpal.R;

public class CreateMeetupActivity extends AppCompatActivity {
    TextInputEditText title;
    TextInputEditText description;
    TextInputEditText location;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_meetup);
        title = (TextInputEditText) findViewById(R.id.title);
        description = (TextInputEditText) findViewById(R.id.description);
        location = (TextInputEditText) findViewById(R.id.Location);
    }

    public void toMeetupsActivity(View view){
        Meetup meetup = new Meetup(title.getText().toString(),
                description.getText().toString(), location.getText().toString());
        startActivity(new Intent(CreateMeetupActivity.this, MeetupsActivity.class));
    }
}
