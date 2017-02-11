package assignment3.mazaval4.bsse.asu.edu.assignment3;

import android.os.Bundle;
import android.renderscript.Double2;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Calculations extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculations);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button add = (Button) findViewById(R.id.calcButton);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText name1 = (EditText) findViewById(R.id.name1);
                EditText name2 = (EditText) findViewById(R.id.name2);

                TextView circle = (TextView) findViewById(R.id.greatCircleResult);
                circle.setText(Double.toString(calculateCircle(name1.getText().toString(),name2.getText().toString())));
                TextView bearing = (TextView) findViewById(R.id.bearingResult);
                bearing.setText(Double.toString(bearing(name1.getText().toString(),name2.getText().toString())));
            }

        });
    }

    public Double calculateCircle(String name1, String name2)
    {
        PlaceLibrary pl = PlaceLibrary.getInstance();

        PlaceDescription pd1 = pl.getPlaceDesc(name1);
        PlaceDescription pd2 = pl.getPlaceDesc(name2);


        double x1 = Math.toRadians(Double.parseDouble(pd1.getLatitude()));
        double x2 = Math.toRadians(Double.parseDouble(pd1.getLongitude()));
        double y1 = Math.toRadians(Double.parseDouble(pd2.getLatitude()));
        double y2 = Math.toRadians(Double.parseDouble(pd2.getLongitude()));

        /*************************************************************************
         * Compute using Haverside formula
         *************************************************************************/
        double a = Math.pow(Math.sin((x2-x1)/2), 2)
                + Math.cos(x1) * Math.cos(x2) * Math.pow(Math.sin((y2-y1)/2), 2);

        // great circle distance in radians
        double angle2 = 2 * Math.asin(Math.min(1, Math.sqrt(a)));

        // convert back to degrees
        angle2 = Math.toDegrees(angle2);

        // each degree on a great circle of Earth is 60 nautical miles
        double distance2 = 60 * angle2;

        return distance2;
    }

    public  double bearing(String name1,String name2){

        PlaceLibrary pl = PlaceLibrary.getInstance();

        PlaceDescription pd1 = pl.getPlaceDesc(name1);
        PlaceDescription pd2 = pl.getPlaceDesc(name2);

        double latitude1 = Math.toRadians(Double.parseDouble(pd1.getLatitude()));
        double longitude1 = Double.parseDouble(pd1.getLongitude());

        double latitude2 = Math.toRadians(Double.parseDouble(pd2.getLatitude()));
        double longitude2 = Double.parseDouble(pd2.getLongitude());


        double longDiff= Math.toRadians(longitude2-longitude1);
        double y= Math.sin(longDiff)*Math.cos(latitude2);
        double x=Math.cos(latitude1)*Math.sin(latitude2)-Math.sin(latitude1)*Math.cos(latitude2)*Math.cos(longDiff);

        return (Math.toDegrees(Math.atan2(y, x))+360)%360;
    }

}
