package assignment3.mazaval4.bsse.asu.edu.assignment3;

import android.content.res.AssetManager;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.IOException;
import java.io.InputStream;
import java.util.Hashtable;

/**
 * Created by mazaval4 on 2/8/2017.
 */

public class PlaceLibrary {

    private final static PlaceLibrary instance = new PlaceLibrary();
    Hashtable<String,PlaceDescription> library = new Hashtable<String,PlaceDescription>();

    private PlaceLibrary() {}

    public static PlaceLibrary getInstance() {
        return instance;
    }


    protected void fromJson(AssetManager assets) {
        String json = null;
        String addressTitle;
        String addressStreet;
        String name;
        String image;
        String description;
        String category;
        double elevation,latitude,longitude;
        PlaceDescription placeDescription = null;


        try {

            InputStream is = assets.open("places.json");

            int size = is.available();

            byte[] buffer = new byte[size];

            is.read(buffer);

            is.close();

            json = new String(buffer, "UTF-8");

            JSONObject obj = new JSONObject(json);

            JSONArray jsonObjectNames = obj.names();

            JSONObject jsonDescriptionObjects = null;

            for (int x = 0; x < obj.length(); x++) {

                jsonDescriptionObjects = obj.getJSONObject(jsonObjectNames.getString(x));

                addressTitle = jsonDescriptionObjects.getString("address-title");
                addressStreet = jsonDescriptionObjects.getString("address-street");
                elevation = jsonDescriptionObjects.getDouble("elevation");
                latitude  = jsonDescriptionObjects.getDouble("latitude");
                longitude = jsonDescriptionObjects.getDouble("longitude");
                name = jsonDescriptionObjects.getString("name");
                image = jsonDescriptionObjects.getString("image");
                description = jsonDescriptionObjects.getString("description");
                category = jsonDescriptionObjects.getString("category");

                placeDescription = new PlaceDescription(addressTitle,addressStreet,elevation,latitude,longitude,name,
                        image,description,category);
                library.put(jsonObjectNames.getString(x),placeDescription);
            }


        }

        catch (IOException ex) {
            ex.printStackTrace();
            android.util.Log.d("ERROR", "CANNOT PARSE JSON");
        }
        catch (org.json.JSONException ex) {
            ex.printStackTrace();
        }
    }

    //use this to both add and edit the current field
    protected void addObject(String key, PlaceDescription pd) {

        //if exists delete and replace else just put into hash table
        if(library.contains(key)) {
            library.remove(key);
            library.put(key,pd);
        }
        else{
            library.put(key,pd);
        }
    }

    //if user wants to remove the place description
    protected String removeObject(String key) {
        PlaceDescription pd = library.remove(key);
        return (pd != null) ? "Success":"Error";
    }

    //use this to populate the text views to edit
    protected PlaceDescription getPlaceDescription(String key){
        return library.get(key);
    }

    //use this to populate the text views to edit
    protected Hashtable getLibrary(){
        return library;
    }




}
