package com.abd.educationapp.ui.home;

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

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.abd.educationapp.CourseActivity;
import com.abd.educationapp.MainActivity;
import com.abd.educationapp.R;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    ListView listView;
    String mTitle[] = {"Java For Beginners", "Course 2", "Course 3", "Course 4", "Course 5"};
    String mDescription[] = {"course Description", "course Description", "course Description", "course Description", "course Description"};
    int images[] = {R.drawable.courses, R.drawable.courses, R.drawable.courses, R.drawable.courses, R.drawable.courses};

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);


        listView = root.findViewById(R.id.listView);
        // now create an adapter class

        MyAdapter adapter = new MyAdapter(getActivity(), mTitle, mDescription, images);
        listView.setAdapter(adapter);
        // there is my mistake...
        // now again check this..

        // now set item click on list view
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position ==  0) {
                    Intent intent = new Intent(getActivity(), CourseActivity.class);
                    intent.putExtra("courseName","Java Course");
                    startActivity(intent);
                }
                if (position ==  1) {
                    Toast.makeText(getActivity(), "Course 2", Toast.LENGTH_SHORT).show();
                }
                if (position ==  2) {
                    Toast.makeText(getActivity(), "Course 3", Toast.LENGTH_SHORT).show();
                }
                if (position ==  3) {
                    Toast.makeText(getActivity(), "Course 4", Toast.LENGTH_SHORT).show();
                }
                if (position ==  4) {
                    Toast.makeText(getActivity(), "Course 5", Toast.LENGTH_SHORT).show();
                }
            }
        });
        return root;
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
            LayoutInflater layoutInflater = (LayoutInflater) context.getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
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