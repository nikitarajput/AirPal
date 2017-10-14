package team.airpal.Controller;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.android.volley.AuthFailureError;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import team.airpal.Model.Journey;
import team.airpal.R;

public class AddJourneyActivity extends AppCompatActivity {
    TextInputEditText flightNumberTextInput;
    static String flightNumber;
    private static final String url = "http://deltaairlines-dev.apigee.net//v1/hack/flight/status?flightNumber=200&flightOriginDate=" + createDate();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_journey);
        flightNumberTextInput = (TextInputEditText) findViewById(R.id.flightNumber);
        getFlightInfo();
    }

    public void toConfirmActivity(View v){
        flightNumber = flightNumberTextInput.getText().toString();
        startActivity(new Intent(AddJourneyActivity.this, ConfirmActivity.class));
    }

    public void createJourney() {
        Journey currentJourney = new Journey(flightNumber);
    }

    private void getFlightInfo() {
        RequestQueue mQueue = Volley.newRequestQueue(getApplicationContext());

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(com.android.volley.Request.Method.GET, url, "",
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.d("TAG", response.toString());
                    }
                }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("TAG", error.getMessage(), error);
            }
        }){
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("Content-Type", "application/json");
                params.put("Authorization", "Bearer O68OqqGKNrb5EC2hEGE6YIVFGeae");
                return params;
            }
        };
        mQueue.add(jsonObjectRequest);
    }

    public void toMeetups(View v){
        createJourney();
        startActivity(new Intent(AddJourneyActivity.this, MeetupsActivity.class));
    }

    private static String createDate() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat timeFormat = new SimpleDateFormat("yyyy-MM-dd");
        return timeFormat.format(calendar.getTime());
    }
}
