package com.example.anupamsarfare.doctorblogs.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.example.anupamsarfare.doctorblogs.R;
import com.example.anupamsarfare.doctorblogs.adapters.CategoryAdapter;
import com.example.anupamsarfare.doctorblogs.models.CategoryModel;

import java.util.ArrayList;
import java.util.List;

public class Categories extends AppCompatActivity {

    private Toolbar mToolbar;
    private ListView categoriesList;
    private List<CategoryModel> categoryData;
    private CategoryAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mToolbar.setTitle("Select Categories");

        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        categoriesList = (ListView) findViewById(R.id.categoriesList);
        categoryData = new ArrayList<CategoryModel>();
        adapter = new CategoryAdapter(getApplicationContext(), categoryData);
        categoriesList.setAdapter(adapter);

        setData();

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

    public void setData(){


        for(int i=1; i<=20; i++){
            CategoryModel currentdata = new CategoryModel();
            currentdata.setId(i+"");
            currentdata.setTitle("Category : " + i);
            categoryData.add(currentdata);


        }

        adapter.notifyDataSetChanged();
    }
}
