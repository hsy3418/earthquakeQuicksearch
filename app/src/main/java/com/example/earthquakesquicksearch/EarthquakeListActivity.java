package com.example.earthquakesquicksearch;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.example.earthquakesquicksearch.databinding.Earthquake;

import java.util.ArrayList;
import java.util.List;

public class EarthquakeListActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_earthquake_list);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Bundle b = getIntent().getExtras();
        List<Earthquake> earthquakeList= b.getParcelableArrayList("mylist");

        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        recyclerView.setHasFixedSize(true);
        //divider for recyclerview
        recyclerView.addItemDecoration(new DividerItemDecoration(this,
                DividerItemDecoration.VERTICAL));
        // use a linear layout manager
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);


        // specify an adapter (see also next example)
        //List<Earthquake> myDataset = new ArrayList<>();
        mAdapter = new MyAdapter(earthquakeList, new MyAdapter.CustomItemClickListener() {
            @Override
            public void onItemClick(View v, int position) {
               Earthquake earthquake =  earthquakeList.get(position);
               Intent intent = new Intent(EarthquakeListActivity.this, MapsActivity.class);

               Bundle bundle = new Bundle();
               bundle.putParcelable("earthquake",earthquake);

               intent.putExtras(bundle);
               EarthquakeListActivity.this.startActivity(intent);
            }
        });
        recyclerView.setAdapter(mAdapter);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
