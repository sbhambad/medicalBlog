package com.example.anupamsarfare.doctorblogs.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.example.anupamsarfare.doctorblogs.AppController;
import com.example.anupamsarfare.doctorblogs.R;
import com.example.anupamsarfare.doctorblogs.activities.BlogDetails;
import com.example.anupamsarfare.doctorblogs.models.BlogModel;

import java.util.List;

/**
 * Created by pratikgadekar on 12/21/15.
 */
public class BlogAdapters extends BaseAdapter {

    private Context context;
    private List<BlogModel> blogData;
    private LayoutInflater inflater;
    private ImageLoader mLoader;

    public BlogAdapters(Context context, List<BlogModel> blogData){

        this.context = context;
        this.blogData = blogData;

    }

    @Override
    public int getCount() {
        return blogData.size();
    }

    @Override
    public Object getItem(int position) {
        return blogData.get(position);
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
            convertView = inflater.inflate(R.layout.custom_blog_row, null);
        }

        if(mLoader == null){
            mLoader = AppController.getInstance().getImageLoader();
        }

        NetworkImageView blogPic = (NetworkImageView) convertView.findViewById(R.id.blogPic);
        TextView blogTitle = (TextView) convertView.findViewById(R.id.blogTitle);
        TextView blogDiscriptions = (TextView) convertView.findViewById(R.id.blogDiscriptions);
        TextView blogId = (TextView) convertView.findViewById(R.id.blogId);

        BlogModel currentData = blogData.get(position);

        blogId.setText(currentData.getId());

        if(currentData.getBlogPicUrl() != null && !currentData.getBlogPicUrl().isEmpty()){
            blogPic.setImageUrl(currentData.getBlogPicUrl(), mLoader);
        } else {
            blogPic.setDefaultImageResId(R.drawable.lungs);
        }
        blogTitle.setText(currentData.getBlogName());
        blogDiscriptions.setText(currentData.getBlogDiscriptions());

        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, BlogDetails.class);
                i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(i);

               // Toast.makeText(context, "Click", Toast.LENGTH_SHORT).show();

            }
        });

        return convertView;
    }
}
