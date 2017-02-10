package assignment3.mazaval4.bsse.asu.edu.assignment3;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class DisplayInfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_info);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        String value = null;

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            value = extras.getString("placename");
        }

        fillStuff(value);
        Button button= (Button) findViewById(R.id.saveButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = getApplicationContext();
                String text;
                int duration = Toast.LENGTH_SHORT;

                EditText editText1 = (EditText)findViewById(R.id.editText1);
                text = editText1.getText().toString();
                Toast toast = Toast.makeText(context, text, duration);
                toast.show();


            }
        });


    }

    public void fillStuff(String value){
        PlaceDescription pd;
        PlaceLibrary lib = PlaceLibrary.getInstance();

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

    //this will save the object that is on the screen
//    public void saveStuff(){
//        PlaceDescription pd;
//        String addressTitle;
//        String addressStreet;
//        String name;
//        String image;
//        String description;
//        String category;
//        double elevation,latitude,longitude;
//        PlaceLibrary lib = PlaceLibrary.getInstance();
//
//        EditText editText1 = (EditText)findViewById(R.id.editText1);
//        addressTitle = editText1.getText().toString();
//        EditText editText2 = (EditText)findViewById(R.id.editText2);
//        editText2.setText(pd.getAddressStreet());
//        EditText editText3 = (EditText)findViewById(R.id.editText3);
//        editText3.setText(pd.getElevation());
//        EditText editText4 = (EditText)findViewById(R.id.editText4);
//        editText4.setText(pd.getLatitude());
//        EditText editText5 = (EditText)findViewById(R.id.editText5);
//        editText5.setText(pd.getLongitude());
//        TextView editText6 = (TextView) findViewById(R.id.editText6);
//        editText6.setText(pd.getName());
//        EditText editText7 = (EditText)findViewById(R.id.editText7);
//        editText7.setText(pd.getImage());
//        EditText editText8 = (EditText)findViewById(R.id.editText8);
//        editText8.setText(pd.getDescription());
//        EditText editText9 = (EditText)findViewById(R.id.editText9);
//        editText9.setText(pd.getCategory());
//
//
//    }



}
