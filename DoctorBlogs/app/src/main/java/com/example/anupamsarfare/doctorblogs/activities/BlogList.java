package com.example.anupamsarfare.doctorblogs.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.example.anupamsarfare.doctorblogs.R;
import com.example.anupamsarfare.doctorblogs.adapters.BlogAdapters;
import com.example.anupamsarfare.doctorblogs.models.BlogModel;

import java.util.ArrayList;
import java.util.List;

public class BlogList extends AppCompatActivity {

    private Toolbar mToolbar;
    private ListView blogList;
    private BlogAdapters adapters;
    private List<BlogModel> blogData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blog_list);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mToolbar.setTitle("Blog List");
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        blogList = (ListView) findViewById(R.id.blogList);
        blogData = new ArrayList<BlogModel>();
        adapters = new BlogAdapters(getApplicationContext(), blogData);
        blogList.setAdapter(adapters);
        setData();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_blog_list, menu);
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

        if (id == android.R.id.home) {
            finish();
            return true;
        }


        return super.onOptionsItemSelected(item);
    }

    public void setData() {
        Log.e("sandeep", "sandeep");

        for (int i = 1; i <= 30; i++) {

            BlogModel currentData = new BlogModel();
            currentData.setId(i + "");
            currentData.setBlogName("Blog Name : " + i);
            currentData.setBlogDiscriptions(getResources().getString(R.string.demo_text));
            currentData.setBlogPicUrl("http://www.clker.com/cliparts/d/E/Y/j/h/S/lungs-md.png");

            blogData.add(currentData);
        }

        adapters.notifyDataSetChanged();
    }
}
