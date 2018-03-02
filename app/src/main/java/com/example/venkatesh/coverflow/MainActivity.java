package com.example.venkatesh.coverflow;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;

import java.util.ArrayList;
import java.util.List;

import it.moondroid.coverflow.components.ui.containers.FeatureCoverFlow;

public class MainActivity extends AppCompatActivity {

    private FeatureCoverFlow coverFlow;
    private MovieAdapter movieAdapter;
    private List<Movie> movieList=new ArrayList<>();
    private TextSwitcher mTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initData();
        mTitle=(TextSwitcher)findViewById(R.id.title);
        mTitle.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                LayoutInflater inflater=LayoutInflater.from(MainActivity.this);
                TextView txt=(TextView)inflater.inflate(R.layout.layout_title,null);
                return txt;
            }
        });
        Animation in = AnimationUtils.loadAnimation(this,R.anim.slide_in_top);
        Animation out = AnimationUtils.loadAnimation(this,R.anim.slide_out_bottom);
    mTitle.setInAnimation(in);
        mTitle.setOutAnimation(out);

        //setting adapter
        movieAdapter= new MovieAdapter(movieList,this);
        coverFlow=(FeatureCoverFlow)findViewById(R.id.coverFlow);
    coverFlow.setAdapter(movieAdapter);

        coverFlow.setOnScrollPositionListener(new FeatureCoverFlow.OnScrollPositionListener() {
            @Override
            public void onScrolledToPosition(int position) {
                mTitle.setText(movieList.get(position).getName());
            }

            @Override
            public void onScrolling() {

            }
        });

    }

    private void initData() {
        movieList.add(new Movie("Tom and Jerry","http://www.disneytouristblog.com/wp-content/uploads/2017/08/disneys-hollywood-studios-arch-wdw-200x200.jpg"));
        movieList.add(new Movie("Godzilla","http://www.disneytouristblog.com/wp-content/uploads/2017/06/carthay-circle-halloween-disneyland-200x200.jpg"));
        movieList.add(new Movie("Scoobe do be do","http://www.disneytouristblog.com/wp-content/uploads/2017/07/star-wars-land-model-disney-world-disneyland-220-200x200.jpg"));
    }
}
