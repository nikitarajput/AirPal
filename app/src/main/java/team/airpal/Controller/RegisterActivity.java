package team.airpal.Controller;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import team.airpal.Model.User;
import team.airpal.R;


public class RegisterActivity extends AppCompatActivity {

    TextInputEditText name, age, email, password;
    private static final String TAG = "Register";
    private static final String TAG2 = "AddToDatabase";
    private FirebaseAuth mAuth;
    private DatabaseReference mDatabase;
    private String userID;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        name = (TextInputEditText)findViewById(R.id.name);
        age = (TextInputEditText)findViewById(R.id.age);
        email = (TextInputEditText)findViewById(R.id.email);
        password = (TextInputEditText)findViewById(R.id.password);
        mAuth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference();
    }

    public void register(View v) {
        mAuth.createUserWithEmailAndPassword(email.getText().toString(), password.getText().toString())
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                FirebaseUser user = mAuth.getCurrentUser();
                                userID = user.getUid();
                                writeNewUser(name.getText().toString(), email.getText().toString(), password.getText().toString(), Integer.parseInt(age.getText().toString()));
                                Log.d(TAG, TAG2 + "createdUser");
                                Toast.makeText(RegisterActivity.this, "Registration successful!.",
                                        Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(RegisterActivity.this, HomeActivity.class));
                            } else {
                                Toast.makeText(RegisterActivity.this, "Registration failed. Please try again.",
                                        Toast.LENGTH_SHORT).show();
                            }
                        }
                    });
    }

    private void writeNewUser(String name, String email, String password, int age) {
        User user = new User(name, email, password, age);
        mDatabase.child("users").child(userID).setValue(user);
    }

    public void toHomeActivity(View view){
        startActivity(new Intent(RegisterActivity.this, HomeActivity.class));
    }
}

