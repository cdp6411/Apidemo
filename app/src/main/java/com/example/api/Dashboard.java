package com.example.api;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.function.ToDoubleBiFunction;


public class Dashboard extends AppCompatActivity {
    private  static final String URL="https://www.iroidsolutions.com/interview/test.json";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        RecyclerView recyclerView =findViewById(R.id.recyclerview1);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        StringRequest stringRequest =new StringRequest(Request.Method.GET, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                GsonBuilder gsonBuilder= new GsonBuilder();
                Gson gson = gsonBuilder.serializeNulls().create();
                User[] users=gson.fromJson(response,User[].class);
                recyclerView.setAdapter(new DashboardAdapter(Dashboard.this,users));
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(Dashboard.this, "Something went wrong", Toast.LENGTH_SHORT).show();

            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(Dashboard.this);
        requestQueue.add(stringRequest);

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
