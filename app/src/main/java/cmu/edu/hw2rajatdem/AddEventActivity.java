package cmu.edu.hw2rajatdem;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

public class AddEventActivity extends AppCompatActivity {

    private EditText nameEditText;
    private EditText dateTimEditText;
    private EditText locationEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_event);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        nameEditText = (EditText) findViewById(R.id.nameEditText);
        dateTimEditText = (EditText) findViewById(R.id.dateTimEditText);
        locationEditText = (EditText) findViewById(R.id.locationEditText);
        Button saveEventButton = (Button) findViewById(R.id.saveEventButton);
        saveEventButton.setOnClickListener(saveEventButtonClicked);
    }

    View.OnClickListener saveEventButtonClicked = new
            View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    // Toast myToast = Toast.makeText(context, message, duration);
                    Context context = getApplicationContext();
                    Toast myToast = Toast.makeText(context, "New Event Created!", Toast.LENGTH_SHORT);
                    myToast.show();
                    saveEvent();
                    Intent listEvent = new Intent(AddEventActivity.this, HomeActivity.class);
                    startActivity(listEvent);
                }
            };

    private void saveEvent()
    {
        EventDao dbhelper = new EventDao(this);
        String name = nameEditText.getText().toString();
        String dateTime = dateTimEditText.getText().toString();
        String location = locationEditText.getText().toString();
        SimpleDateFormat sdf = new SimpleDateFormat("MMM dd yyyy HH:mm:ss");

        if (dateTimEditText.length() == 0) {
            //convert current DateTime to preferable
            dateTime = sdf.format(new Date());
            dateTimEditText.setText(dateTime);
        }

        if (locationEditText.getText().length()==0) {
            location = "Carnegie Mellon University";
            locationEditText.setText(location);
        }
        Log.i("Name",name);
        Log.i("Date", dateTime);
        Log.i("Location", location);
        location = dateTime+"\n"+location;
        dbhelper.insertEvent(name, dateTime, location);
    }
}
