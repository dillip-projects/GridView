package com.example.scrolling_cardview;

import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;

import com.bumptech.glide.load.engine.Resource;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.TypedValue;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.example.scrolling_cardview.databinding.ActivityScrollingBinding;

import java.util.ArrayList;
import java.util.List;

public class ScrollingActivity extends AppCompatActivity {

    //step 1 : declaring some varibles

    private List<AppsModel> applist;
    private AppsAdapter myadapter;
    private RecyclerView recyclerView;

    private ActivityScrollingBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityScrollingBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Toolbar toolbar = binding.toolbar;
        setSupportActionBar(toolbar);
        CollapsingToolbarLayout toolBarLayout = binding.toolbarLayout;
        toolBarLayout.setTitle(getTitle());

        FloatingActionButton fab = binding.fab;
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        // linking id's

        recyclerView=findViewById(R.id.recylerview);
        applist= new ArrayList<>();
        myadapter=new AppsAdapter(this,applist);

        RecyclerView.LayoutManager layoutManager=new GridLayoutManager(this,3);
        recyclerView.setLayoutManager(layoutManager);

        //item decoration

        recyclerView.addItemDecoration(new GridSpacingItemDecoration(1,dpToPx(5),true));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(myadapter);


        //preparing the cards

        InsertDataIntoCards();


    }

    private void InsertDataIntoCards() {
        //add cards data and display

        int[] appscovers= new int[]{
                R.drawable.fb,
                R.drawable.youtube,
                R.drawable.insta,
                R.drawable.java,
                R.drawable.php,
                R.drawable.oracle
        };

        AppsModel a= new AppsModel("Facebook",80000,appscovers[0]);
        applist.add(a);
       a=new AppsModel("youtube",100000,appscovers[1]);
        applist.add(a);
        a=new AppsModel("instagram",100000,appscovers[2]);
        applist.add(a);
        a=new AppsModel("java",9000,appscovers[3]);
        applist.add(a);
        a=new AppsModel("php",1000,appscovers[4]);
        applist.add(a);
        a=new AppsModel("oracle",80000,appscovers[5]);
        applist.add(a);

        //don't miss to notify data change
       myadapter.notifyDataSetChanged();
    }

    private int dpToPx(int dp) {
        Resources r=getResources();
        return Math.round(TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,dp,r.getDisplayMetrics()));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_scrolling, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private class GridSpacingItemDecoration extends RecyclerView.ItemDecoration {

        private int spanCount;
        private int spcaing;
        private  boolean includeEdge;

        public GridSpacingItemDecoration(int spanCount, int spcaing, boolean includeEdge) {
            this.spanCount = spanCount;
            this.spcaing = spcaing;
            this.includeEdge = includeEdge;
        }

        @Override
        public void getItemOffsets(@NonNull  Rect outRect, @NonNull  View view, @NonNull  RecyclerView parent, @NonNull RecyclerView.State state) {
int position =parent.getChildAdapterPosition(view);
int column=position%spanCount;

if(includeEdge){
    outRect.left=spcaing-column * spcaing/spanCount;
    outRect.right=(column+1)*spcaing/spanCount;

    if(position<spanCount){
        outRect.top=spcaing;
    }

    outRect.bottom=spcaing;
}

else {
    outRect.left=column*spcaing/spanCount;
    outRect.right=spcaing-(column+1) * spcaing/spanCount;

    if(position>=spanCount){
        outRect.top=spcaing;
    }
}
        }
    }
}