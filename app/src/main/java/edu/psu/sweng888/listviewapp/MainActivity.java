package edu.psu.sweng888.listviewapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView mListView;
    TextView mTextViewCourseDesc;
    String[] listItem;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ArrayList<ItemInformation> itemList = new ArrayList<ItemInformation>();
        itemList = loadItemData();
        InformationListAdapter adapter = new InformationListAdapter(MainActivity.this, itemList);

        mListView = findViewById(R.id.listview_items);
        mListView.setAdapter(adapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ItemInformation selectedItem = (ItemInformation) mListView.getItemAtPosition(position);

                Intent intent = new Intent(MainActivity.this, InformationViewActivity.class);
                intent.putExtra("selected_item", selectedItem);
                startActivity(intent);
            }
        });
    }

    private ArrayList<ItemInformation> loadItemData() {
        ArrayList<ItemInformation> course = new ArrayList<>();

        course.add(new ItemInformation(505, 3, "Design Patterns"));
        course.add(new ItemInformation(585, 3, "Design Patterns"));
        course.add(new ItemInformation(587, 3, "Software Systems Architecture"));

        return course;
    }
}