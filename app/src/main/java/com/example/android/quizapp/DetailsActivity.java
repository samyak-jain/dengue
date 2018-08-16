package com.example.android.quizapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        TextView head = (TextView) findViewById(R.id.head);
        head.setText(Html.fromHtml("<h1> Information <h1>", Html.FROM_HTML_MODE_COMPACT));
        TextView myTextView = (TextView) findViewById(R.id.a1);
        myTextView.setText(Html.fromHtml("<h2>Dengue Fever</h2>", Html.FROM_HTML_MODE_COMPACT));
        TextView myTextView1 = (TextView) findViewById(R.id.a2);
        myTextView1.setText(Html.fromHtml("<h2>Symptomps</h2>", Html.FROM_HTML_MODE_COMPACT));
        TextView myTextView2 = (TextView) findViewById(R.id.a3);
        myTextView2.setText(Html.fromHtml("<h2>Treatment</h2>", Html.FROM_HTML_MODE_COMPACT));
        TextView myTextView3 = (TextView) findViewById(R.id.a4);
        myTextView3.setText(Html.fromHtml("<h2>Prevention</h2>", Html.FROM_HTML_MODE_COMPACT));

    }
}
