package com.example.anupamsarfare.doctorblogs.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.anupamsarfare.doctorblogs.R;
import com.example.anupamsarfare.doctorblogs.activities.BlogDetails;
import com.example.anupamsarfare.doctorblogs.activities.BlogList;
import com.example.anupamsarfare.doctorblogs.models.CategoryModel;

import java.util.List;

/**
 * Created by pratikgadekar on 12/21/15.
 */
public class CategoryAdapter extends BaseAdapter {
    private Context context;
    private List<CategoryModel> categoryData;
    private LayoutInflater inflater;

    public CategoryAdapter(Context context, List<CategoryModel> categoryData){
        this.context = context;
        this.categoryData = categoryData;
    }

    @Override
    public int getCount() {
        return categoryData.size();
    }

    @Override
    public Object getItem(int position) {
        return categoryData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(inflater == null){
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        if(convertView == null){
            convertView = inflater.inflate(R.layout.custom_category_row, null);
        }

        TextView categotyId = (TextView) convertView.findViewById(R.id.categotyId);
        TextView title = (TextView) convertView.findViewById(R.id.title);

        CategoryModel currentData = categoryData.get(position);
        categotyId.setText(currentData.getId());
        title.setText(currentData.getTitle());

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(context, BlogList.class);
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(i);

            }
        });
        return convertView;
    }
}
