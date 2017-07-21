package com.example.admin.movieappv2;



             import android.content.Context;
             import android.support.v7.widget.RecyclerView;
             import android.view.LayoutInflater;
             import android.view.View;
             import android.view.ViewGroup;
             import android.widget.ImageView;
             import android.widget.TextView;

             import com.squareup.picasso.Picasso;

             import java.util.ArrayList;


public class Adapter extends RecyclerView.Adapter<Adapter.Holder> {

    ArrayList<Movie> mylist;
    Context context;

    public Adapter(ArrayList<Movie> list, Context context) {
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
          holder.TextView_name.setText(mylist.get(position).getName());




//          Picasso.with(context).load("http://image.tmdb.org/t/p/w185" + mylist.get(position+1).getImageUrl()).into(holder.imageView_2);
//          holder.TextView_name_2.setText(mylist.get(position).getName());



//        position++;
//

       // Log.v("tessssssst*** ", "http://image.tmdb.org/t/p/w185" + mylist.get(position).getImageUrl());
    }

    @Override
    public int getItemCount() {
        return mylist.size();
    }





    static class Holder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView TextView_name;

        ImageView imageView_2;
        TextView TextView_name_2;

        public Holder(View view) {
            super(view);
            imageView = (ImageView) itemView.findViewById(R.id.FirstMovieImage);
            TextView_name = (TextView) itemView.findViewById(R.id.FirstMovieName);


//            imageView_2= (ImageView) itemView.findViewById(R.id.SecotMovieImage);
//            TextView_name_2= (TextView) itemView.findViewById(R.id.SecondtMovieName);
            //    imageView = itemView.findViewById(R.id.IV_poster);
            //  TextView_name = itemView.findViewById(R.id.TV_MovieName);
            // TextView_rate =itemView.findViewById(R.id.TV_MovieRateSec);
            //TextView_overview=itemView.findViewById(R.id.TV_MovieRateSec);
        }
    }

}


