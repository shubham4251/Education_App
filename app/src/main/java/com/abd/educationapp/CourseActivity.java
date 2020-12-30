package com.abd.educationapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class CourseActivity extends AppCompatActivity {
    ListView listView;
    String mTitle[] = {"Module 1", "Module 2", "Module 3", "Module 4", "Module 5"};
    String mDescription[] = {"Module Description", "Module Description", "Module Description", "Module Description", "Module Description"};
    int images[] = {R.drawable.courses, R.drawable.courses, R.drawable.courses, R.drawable.courses, R.drawable.courses};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course);

        listView = findViewById(R.id.listView);
        // now create an adapter class

        MyAdapter adapter = new MyAdapter(this, mTitle, mDescription, images);
        listView.setAdapter(adapter);
        // there is my mistake...
        // now again check this..

        // now set item click on list view
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position ==  0) {
                    Intent intent = new Intent(CourseActivity.this,ModuleActivity.class);
                    intent.putExtra("courseName","java course");
                    intent.putExtra("moduleNo","1");
                    startActivity(intent);
                }
                if (position ==  1) {
                    Toast.makeText(CourseActivity.this, "Module 2", Toast.LENGTH_SHORT).show();
                }
                if (position ==  2) {
                    Toast.makeText(CourseActivity.this, "Module 3", Toast.LENGTH_SHORT).show();
                }
                if (position ==  3) {
                    Toast.makeText(CourseActivity.this, "Module 4", Toast.LENGTH_SHORT).show();
                }
                if (position ==  4) {
                    Toast.makeText(CourseActivity.this, "Module 5", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
    class MyAdapter extends ArrayAdapter<String> {

        Context context;
        String rTitle[];
        String rDescription[];
        int rImgs[];

        MyAdapter (Context c, String title[], String description[], int imgs[]) {
            super(c, R.layout.row, R.id.textView1, title);
            this.context = c;
            this.rTitle = title;
            this.rDescription = description;
            this.rImgs = imgs;

        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            LayoutInflater layoutInflater = (LayoutInflater)getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View row = layoutInflater.inflate(R.layout.row, parent, false);
            ImageView images = row.findViewById(R.id.image);
            TextView myTitle = row.findViewById(R.id.textView1);
            TextView myDescription = row.findViewById(R.id.textView2);

            // now set our resources on views
            images.setImageResource(rImgs[position]);
            myTitle.setText(rTitle[position]);
            myDescription.setText(rDescription[position]);




            return row;
        }
    }
}