package com.example.nasaprvaapk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.lang.reflect.Array;
import java.util.Vector;

public class ThridActivity extends AppCompatActivity {
   final String[][] slike = {
           {"https://i.ytimg.com/vi/GHhFtkGfaWU/hqdefault.jpg",
                   "https://www.rd.com/wp-content/uploads/2018/12/50-Funny-Animal-Pictures-That-You-Need-In-Your-Life-12.jpg",
                   "https://www.rd.com/wp-content/uploads/2018/12/Monkey-with-oranges-768x1112.jpg",
           "https://i.pinimg.com/originals/99/66/8b/99668b6392673dacac789b4a5b925246.jpg",
           "https://cms.qz.com/wp-content/uploads/2018/05/china-pandas-eyes-turned-white-in-sichuan-2018-e1525405988661.jpg?quality=75&strip=all&w=410&h=230.67037692891472"} ,
           {"http://arhiva.nedeljnik.rs/media/portalnews/2018/May/01/s/Ajnstajn--profimedia-0247820067.jpg",
                   "https://www.korisnaknjiga.com/photo/picautor/p000161c0.jpg","https://www.telegraph.co.uk/content/dam/news/2016/07/12/hitler_1881083c_trans_NvBQzQNjv4Bq6f7LZ7seCW96zliyTYX6ViIMpBIiS72GQ3QPBtusw-s.jpg?imwidth=450"
,"http://www.standard.co.me/media/k2/items/cache/d0fa607db380896126161092024a2860_L.jpg"
           ,"https://i.ytimg.com/vi/jm2zjyHMGCA/maxresdefault.jpg"},
           {"https://www.forestgrove-or.gov/sites/default/files/imageattachments/library/page/16171/potato_death.jpg",
                   "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSlCDlenbVveZhw3twIiLVSdDjexAS5sYr1iW7VxuPRS0goAXn4",
                   "https://www.apple.com/ac/structured-data/images/open_graph_logo.png?201809210816"}
   };


    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thrid);

         img = (ImageView) findViewById(R.id.imgResult);

        Button btnAgain = (Button) findViewById(R.id.btnTryAgain);
        btnAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setRandomPicture(findSelected());
            }
        });

        setRandomPicture(findSelected());
    }

    private void setRandomPicture(Vector<Integer> selected) {

        int randomBroj =  (int) (Math.random() * selected.size());
        int randomKategorija = selected.get(randomBroj);
        int randomSlika = (int) (Math.random() * slike[randomKategorija].length);

        String url = slike[randomKategorija][randomSlika];
        Picasso.get()
                .load(url)
                .placeholder(R.drawable.loading)
                //.error(R.drawable.ic_launcher_background)
                .into(img);

    }

    private Vector<Integer> findSelected() {

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        Vector<Integer> izabrane = new Vector<Integer>();
        int n=0;
        String string= new String();
        for (String key : bundle.keySet()) {
            if( (Boolean) bundle.get(key))
            {
                izabrane.add(n);
            }
            n++;
        }

        return izabrane;
//        for(int k: izabrane)
//            string+=k+" ,";
//        Log.d("provera", string);


    }
}
