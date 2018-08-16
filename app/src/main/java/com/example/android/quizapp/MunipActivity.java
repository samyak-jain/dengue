package com.example.android.quizapp;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.net.URLEncoder;

public class MunipActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceStates) {
        final Context mContext = getApplicationContext();
        super.onCreate(savedInstanceStates);
        setContentView(R.layout.activity_munip);
        Button b = (Button) findViewById(R.id.send);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText t = (EditText) findViewById(R.id.editText);
                String text = t.getText().toString();
                RequestQueue queue = Volley.newRequestQueue(mContext);
                String url = "https://powerful-bayou-71157.herokuapp.com/send?message=" + URLEncoder.encode(text);
                System.out.println(url);
                StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        System.out.println(response);
                        Toast.makeText(mContext, "Message Sent", Toast.LENGTH_LONG).show();
                    }
                },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                error.printStackTrace();
                            }
                        });

                queue.add(stringRequest);

            }
        });
    }
}
