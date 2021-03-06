package team.airpal.Controller;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import team.airpal.Model.Journey;
import team.airpal.R;

public class AddJourneyActivity extends AppCompatActivity {

    TextInputEditText flightNumberTextInput;
    private Journey currentJourney;
    static String flightNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_journey);
        flightNumberTextInput = (TextInputEditText) findViewById(R.id.flightNumber);
    }

    public void createJourney() {
        currentJourney = new Journey(flightNumber);
        Toast.makeText(AddJourneyActivity.this, "Journey created!.",
                Toast.LENGTH_SHORT).show();
    }

    private void getFlightInfo(String flightNumber) {
        String url = "http://deltaairlines-dev.apigee.net//v1/hack/flight/status?flightNumber=" + flightNumber + "&flightOriginDate=" + createDate();
        RequestQueue mQueue = Volley.newRequestQueue(getApplicationContext());

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(com.android.volley.Request.Method.GET, url, "",
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.d("TAG", response.toString());
                        JSONObject flightDetails = response;
                        parseData(flightDetails);
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
        flightNumber = flightNumberTextInput.getText().toString();
        getFlightInfo(flightNumber);
        startActivity(new Intent(AddJourneyActivity.this, MeetupsActivity.class));
    }

    public void parseData(JSONObject data) {
        String departureAirportCode = "";
        String arrivalAirportCode = "";
        String departureTime = "";
        String arrivalTime = "";
        JSONArray flightDetails = new JSONArray();
        try {
            flightDetails = data.getJSONObject("flightStatusResponse").getJSONObject("statusResponse").getJSONObject("flightStatusTO").getJSONArray("flightStatusLegTOList");
        }
        catch (JSONException e) {
            Toast.makeText(AddJourneyActivity.this, "Journey could not be added.",
                    Toast.LENGTH_SHORT).show();
        }
        for (int i = 0; i < flightDetails.length(); i++)
        {
            try {
                departureAirportCode = flightDetails.getJSONObject(i).getString("departureAirportCode");
                arrivalAirportCode = flightDetails.getJSONObject(i).getString("arrivalAirportCode");
                String depart = flightDetails.getJSONObject(0).getString("departureLocalTimeScheduled");
                String arrive = flightDetails.getJSONObject(0).getString("arrivalLocalTimeEstimatedActual");
                try {
                    DateFormat oldDepartFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
                    Date departureDate = oldDepartFormat.parse(depart);
                    DateFormat newDepartFormat = new SimpleDateFormat("MM/dd/yyyy hh:mm");
                    departureTime = newDepartFormat.format(departureDate);
                    DateFormat oldArriveFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
                    Date arrivalDate = oldArriveFormat.parse(arrive);
                    DateFormat newArriveFormat = new SimpleDateFormat("MM/dd/yyyy hh:mm");
                    arrivalTime = newArriveFormat.format(arrivalDate);
                } catch (ParseException e) {
                    Toast.makeText(AddJourneyActivity.this, "Journey could not be added.",
                            Toast.LENGTH_SHORT).show();
                }
            }
            catch (JSONException e) {
                Toast.makeText(AddJourneyActivity.this, "Journey could not be added.",
                        Toast.LENGTH_SHORT).show();
            }
        }
        System.out.println(departureAirportCode + " " + departureTime + " to " + arrivalAirportCode + " " + arrivalTime);
        createJourney();
        currentJourney.setDepartureAirport(departureAirportCode);
        currentJourney.setDestinationAirport(arrivalAirportCode);
        currentJourney.setEndTime(arrivalTime);
    }

    private static String createDate() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat timeFormat = new SimpleDateFormat("yyyy-MM-dd");
        return timeFormat.format(calendar.getTime());
    }
}
