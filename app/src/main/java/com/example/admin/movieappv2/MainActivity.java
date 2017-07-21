package com.example.admin.movieappv2;


        import android.content.ClipData;
        import android.content.Intent;
        import android.net.Uri;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.support.v7.widget.GridLayoutManager;
        import android.support.v7.widget.LinearLayoutManager;
        import android.support.v7.widget.RecyclerView;
        import android.util.Log;
        import android.view.View;
        import android.widget.EditText;
        import android.widget.ImageView;
        import android.widget.TextView;

        import com.android.volley.Request;
        import com.android.volley.RequestQueue;
        import com.android.volley.Response;
        import com.android.volley.VolleyError;
        import com.android.volley.toolbox.JsonObjectRequest;
        import com.android.volley.toolbox.JsonRequest;
        import com.android.volley.toolbox.StringRequest;
        import com.android.volley.toolbox.Volley;

        import org.json.JSONArray;
        import org.json.JSONException;
        import org.json.JSONObject;

        import java.net.URL;
        import java.util.ArrayList;
        import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText ed_MovieName;
    EditText ed_MovieRate;
    EditText ed_MovieDescription;
    RecyclerView recyclerView;
    ImageView imageView;
    List<Movie> mylist;
    Adapter myadapter;
    RequestQueue requestQueue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //  ed_MovieName=(EditText)findViewById(R.id.ET_MovieName);
        // ed_MovieRate=(EditText)findViewById(R.id.ET_MovieRate);
        //ed_MovieDescription=(EditText)findViewById(R.id.ET_MovieDescription);
        imageView=(ImageView)findViewById(R.id.IV_MyItem);
        requestQueue= Volley.newRequestQueue(this);
        recyclerView=(RecyclerView)findViewById(R.id.RV_myView);

        String urlServer="https://api.themoviedb.org/3/movie/top_rated?api_key=a2a6577bddba0b92a5bb9571adf4f098";

        volleyStringRquest(urlServer);


        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        mylist =new ArrayList<>();



        myadapter=new Adapter(mylist,this);

        recyclerView.setAdapter(myadapter);
    }
    public void volleyStringRquest(String Url) {
        final JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, Url, (JSONObject) null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                JSONArray jsonArray=null;
                try {
                    jsonArray=response.getJSONArray("results");
                    JSONObject jsonObject=null;
                    for(int i=0;i<jsonArray.length();i++){
                        Movie movie=new Movie();
                        jsonObject=jsonArray.getJSONObject(i);
                        movie.setImageUrl(jsonObject.getString("poster_path"));
                        movie.setMovie_id(jsonObject.getString("id"));
                        movie.setDescription(jsonObject.getString("overview"));
                        movie.setRate(jsonObject.getInt("vote_average"));
                        movie.setName(jsonObject.getString("title"));
                        movie.setPopularity(jsonObject.getInt("popularity"));
                        mylist.add(movie);
                        myadapter.notifyDataSetChanged();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                //System.out.println("URL*** "+jsonObject.getString("poster_path"));

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        requestQueue.add(jsonObjectRequest);

    }

    public void getaddedINFO() {
        Movie movie=new Movie();
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
