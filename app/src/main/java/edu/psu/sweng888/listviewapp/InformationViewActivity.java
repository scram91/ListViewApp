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

    private TextView mInformationTextView;
    private TextView mInformationDescription;

    Button mReturnButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.information_view_activity);
        mReturnButton = findViewById(R.id.return_button);
        mReturnButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(InformationViewActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        ItemInformation item = (ItemInformation) getIntent().getSerializableExtra("selected_item");
        mInformationTextView = findViewById(R.id.information_text_view);
        mInformationDescription = findViewById(R.id.information_description);
        mInformationTextView.setText(item.getDescription());
        mInformationDescription.setText("AAAAAAA");

    }
}
