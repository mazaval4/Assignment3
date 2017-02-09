package assignment3.mazaval4.bsse.asu.edu.assignment3;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import org.json.JSONArray;
import org.json.JSONObject;

/*
1. Method to create fromJson
2. Create each entry into a json object using the class
3. Add it to the library
Place is responsible for add modify remove
Place class creates itself from the json file.
        */


public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private GridLayoutManager gridLayoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        PlaceLibrary library = PlaceLibrary.getInstance();

        library.fromJson(getAssets());
        gridLayoutManager = new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(gridLayoutManager);
    }
}