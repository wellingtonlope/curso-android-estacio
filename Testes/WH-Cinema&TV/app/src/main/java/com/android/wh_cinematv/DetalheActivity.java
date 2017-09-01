package com.android.wh_cinematv;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

public class DetalheActivity extends AppCompatActivity {

	ImageView capaImageView;
	TextView tituloTextView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_detalhe);
		tituloTextView = (TextView) findViewById(R.id.tituloTextView);

		// Instantiate the RequestQueue.
		RequestQueue queue = Volley.newRequestQueue(DetalheActivity.this);
		String url = "https://api.themoviedb.org/3/movie/211672?api_key=b0c4074eba35af82359154f51f3ff5e5&language=pt-BR";
		// Request a string response from the provided URL.
		StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
				new Response.Listener<String>() {
					@Override
					public void onResponse(String response) {
						Log.i("JSON", response);
						Gson gson = new Gson();
						Filme filme = gson.fromJson(response, Filme.class);
						tituloTextView.setText(filme.getTitle());
					}
				}, new Response.ErrorListener() {
			@Override
			public void onErrorResponse(VolleyError error) {
				Log.i("JSON", error.getMessage());
			}
		});
		// Add the request to the RequestQueue.
		queue.add(stringRequest);

		capaImageView = (ImageView) findViewById(R.id.capaImageView);
		Picasso.with(DetalheActivity.this).load("https://images-na.ssl-images-amazon.com/images/M/MV5BMjMwODgxMDU4OV5BMl5BanBnXkFtZTgwMDMzNDQ3MjI@._V1_SY1000_CR0,0,675,1000_AL_.jpg").into(capaImageView);
	}
}
