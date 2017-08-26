package com.android.cep;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

public class MainActivity extends AppCompatActivity {

	EditText cepEditText;
	ImageButton searchImageButton;
	TextView estadoTextView;
	TextView cidadeTextView;
	TextView bairroTextView;
	TextView logradouroTextView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		cepEditText = (EditText) findViewById(R.id.cepEditText);
		searchImageButton = (ImageButton) findViewById(R.id.searchImageButton);
		estadoTextView = (TextView) findViewById(R.id.estadoTextView);
		cidadeTextView = (TextView) findViewById(R.id.cidadeTextView);
		bairroTextView = (TextView) findViewById(R.id.bairroTextView);
		logradouroTextView = (TextView) findViewById(R.id.logradouroTextView);

		searchImageButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {

				// Instantiate the RequestQueue.
				String cep = cepEditText.getText().toString();
				RequestQueue queue = Volley.newRequestQueue(MainActivity.this);
				String url ="http://correiosapi.apphb.com/cep/" + cep;
				Log.i("JSON", " " + cep.length());
				// Request a string response from the provided URL.
				StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
						new Response.Listener<String>() {
							@Override
							public void onResponse(String response) {
								Log.i("JSON", response);
								Gson gson = new Gson();
								Cep endereco = gson.fromJson(response, Cep.class);
								estadoTextView.setText("Estado: " + endereco.getEstado());
								cidadeTextView.setText("Cidade: " + endereco.getCidade());
								bairroTextView.setText("Bairro: " + endereco.getBairro());
								logradouroTextView.setText("Logradouro " + endereco.getTipoDeLogradouro() + " " + endereco.getLogradouro());

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
		});


	}
}
