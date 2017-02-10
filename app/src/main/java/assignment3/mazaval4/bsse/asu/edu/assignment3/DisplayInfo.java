package assignment3.mazaval4.bsse.asu.edu.assignment3;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class DisplayInfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_info);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        PlaceDescription pd;
        String value = null;
        PlaceLibrary lib = PlaceLibrary.getInstance();
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            value = extras.getString("placename");
        }
        pd = lib.getPlaceDesc(value);
        EditText editText1 = (EditText)findViewById(R.id.editText1);
        editText1.setText(pd.getAddressTitle());
        EditText editText2 = (EditText)findViewById(R.id.editText2);
        editText2.setText(pd.getAddressStreet());
        EditText editText3 = (EditText)findViewById(R.id.editText3);
        editText3.setText(pd.getElevation());
        EditText editText4 = (EditText)findViewById(R.id.editText4);
        editText4.setText(pd.getLatitude());
        EditText editText5 = (EditText)findViewById(R.id.editText5);
        editText5.setText(pd.getLongitude());
        TextView editText6 = (TextView) findViewById(R.id.editText6);
        editText6.setText(pd.getName());
        EditText editText7 = (EditText)findViewById(R.id.editText7);
        editText7.setText(pd.getImage());
        EditText editText8 = (EditText)findViewById(R.id.editText8);
        editText8.setText(pd.getDescription());
        EditText editText9 = (EditText)findViewById(R.id.editText9);
        editText9.setText(pd.getCategory());


    }

}
