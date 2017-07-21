package com.example.admin.movieappv2;



             import android.content.Context;
             import android.media.Image;
             import android.net.Uri;
             import android.support.v7.view.menu.MenuView;
             import android.support.v7.widget.RecyclerView;
             import android.text.Layout;
             import android.util.Log;
             import android.view.LayoutInflater;
             import android.view.View;
             import android.view.ViewGroup;
             import android.widget.ImageView;
             import android.widget.TextView;

             import com.squareup.picasso.Picasso;

             import java.net.URI;
             import java.net.URL;
             import java.util.List;



public class Adapter extends RecyclerView.Adapter<Adapter.Holder> {

    List<Movie> mylist;
    Context context;

    public Adapter(List<Movie> list, Context context) {
        this.context = context;
        mylist = list;

    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);

        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        // holder.imageView.setImageResource(R.drawable.trueimg);
        // holder.imageView.setImageURI(Uri.parse( "http://image.tmdb.org/t/p/w185/"+mylist.get(position).getImageUrl()));
        Picasso.with(context).load("http://image.tmdb.org/t/p/w185" + mylist.get(position).getImageUrl()).into(holder.imageView);
       // holder.TextView_name.setText(mylist.get(position).getName());

       // Log.v("tessssssst*** ", "http://image.tmdb.org/t/p/w185" + mylist.get(position).getImageUrl());
    }

    @Override
    public int getItemCount() {
        return mylist.size();
    }





    static class Holder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView TextView_name;


        public Holder(View view) {
            super(view);
            imageView = (ImageView) itemView.findViewById(R.id.IV_MyItem);
            TextView_name = (TextView) itemView.findViewById(R.id.TV_MovieName);


            //    imageView = itemView.findViewById(R.id.IV_poster);
            //  TextView_name = itemView.findViewById(R.id.TV_MovieName);
            // TextView_rate =itemView.findViewById(R.id.TV_MovieRateSec);
            //TextView_overview=itemView.findViewById(R.id.TV_MovieRateSec);
        }
    }

}


