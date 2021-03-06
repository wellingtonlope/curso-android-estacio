package com.android.wh_cinematv;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity {

	ListView filmesListView;
	String[] teste = {"Pimba"};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		filmesListView = (ListView) findViewById(R.id.filmesLisView);

		ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.activity_list_item, teste);
		filmesListView.setAdapter(adapter);

		// Instantiate the RequestQueue.
		RequestQueue queue = Volley.newRequestQueue(MainActivity.this);
		String url = "https://api.themoviedb.org/3/discover/tv?api_key=b0c4074eba35af82359154f51f3ff5e5&language=pt-BR";
		// Request a string response from the provided URL.
		StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
				new Response.Listener<String>() {
					@Override
					public void onResponse(String response) {
						Gson gson = new Gson();
						ListaFilmes filmes = gson.fromJson(response, ListaFilmes.class);
					}
				}, new Response.ErrorListener() {
			@Override
			public void onErrorResponse(VolleyError error) {
				Log.i("JSON", error.getMessage());
			}
		});
		// Add the request to the RequestQueue.
		queue.add(stringRequest);
	}
}
