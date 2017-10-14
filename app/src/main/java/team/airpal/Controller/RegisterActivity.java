package team.airpal.Controller;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import team.airpal.R;


public class RegisterActivity extends AppCompatActivity {

    EditText username, password;
    private static final String TAG = "EmailPasswordLogIn";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }


}

