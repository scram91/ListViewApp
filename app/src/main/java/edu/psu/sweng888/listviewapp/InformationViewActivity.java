package edu.psu.sweng888.listviewapp;

import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class InformationViewActivity extends MainActivity{

    //initialize TextViews and Button
    private TextView mInformationTextView;
    private TextView mInformationDescription;
    private TextView mInformationId;
    private TextView mInformationProfessor;
    Button mReturnButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //set the content view
        setContentView(R.layout.information_view_activity);
        mReturnButton = findViewById(R.id.return_button);

        ItemInformation item = (ItemInformation) getIntent().getSerializableExtra("selected_item");
        //Click listener for return buttoon will return user too MainActivity
        mReturnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(InformationViewActivity.this, MainActivity.class);
                intent.putExtra("RETURN", true);
                intent.putExtra("Item", item.getDescription());
                startActivity(intent);
            }
        });

        //Set created TextViews to defined textviews in layouts
        mInformationTextView = findViewById(R.id.information_item_title);
        mInformationDescription = findViewById(R.id.textview_item_description);
        mInformationId = findViewById(R.id.textview_item_id);
        mInformationProfessor = findViewById(R.id.textview_item_professor);

        //set Text for TextViews using methods in ItemInformation.java
        mInformationTextView.setText(item.getTitle());
        mInformationDescription.setText(item.getDescription());
        mInformationId.setText(item.getID());
        mInformationProfessor.setText("This class is taught by" + item.getProfessor());

    }
}
