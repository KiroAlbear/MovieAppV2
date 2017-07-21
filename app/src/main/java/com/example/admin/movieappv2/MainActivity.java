package com.example.admin.movieappv2;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ImageView imageView;
    ArrayList<Movie> mylist;
    TextView textView;
    Adapter myadapter;
    RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //  ed_MovieName=(EditText)findViewById(R.id.ET_MovieName);
        // ed_MovieRate=(EditText)findViewById(R.id.ET_MovieRate);
        //ed_MovieDescription=(EditText)findViewById(R.id.ET_MovieDescription);
//        imageView = (ImageView) findViewById(R.id.FirstMovieImage);

        //textView = (TextView) findViewById(R.id.Test);

        requestQueue = Volley.newRequestQueue(this);
        recyclerView = (RecyclerView) findViewById(R.id.RV_myView);

        String urlServer = "https://api.themoviedb.org/3/movie/top_rated?api_key=a2a6577bddba0b92a5bb9571adf4f098";

        volleyStringRquest(urlServer);


        mylist = new ArrayList<>();


        myadapter = new Adapter(mylist, this);


        recyclerView.setAdapter(myadapter);
        recyclerView.setLayoutManager(new GridLayoutManager(this,1));


        // Toast toast = Toast.makeText(this, String.valueOf(mylist.size()),Toast.LENGTH_SHORT);

    }

    public void volleyStringRquest(String Url) {
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, Url, null,

                new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray jsonArray = response.getJSONArray("results");
                            for (int i = 0; i < jsonArray.length(); i++) {
                                Movie movie = new Movie();
                                JSONObject jsonObject = jsonArray.getJSONObject(i);
                                movie.setName(jsonObject.getString("title"));
                                movie.setImageUrl(jsonObject.getString("poster_path"));
                                mylist.add(movie);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                            textView.setText("JSONException");
                        }

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        textView.setText("onErrorResponse");
                    }
                }


        );
        requestQueue.add(jsonObjectRequest);
    }

    public void getaddedINFO() {
        Movie movie = new Movie();
      /*  movie.setName(ed_MovieName.getText().toString());
        movie.setDescription(ed_MovieDescription.getText().toString());
        movie.setRate(Integer.parseInt(ed_MovieRate.getText().toString()));
        */
        mylist.add(movie);
        myadapter.notifyDataSetChanged();

    }


  /*  public void Showdata(View view){
        Intent intent=new Intent(getApplicationContext(),SconedActivity.class);
        TextView textView;
        for(int i=0;i<3;i++) {
            imageView = (ImageView)view.findViewById(R.id.IV_MyItem);
            intent.putExtra("url", imageView.);
            System.out.println(i+"  ="+textView.getText().toString()+"\n");
        }
        startActivity(intent);

    }*/
}
