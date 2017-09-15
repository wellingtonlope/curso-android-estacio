package com.android.dicionario;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignificadoActivity extends AppCompatActivity {

	TextView giriaTextView;
	TextView significadoTextView;
	Button voltarButton;
	Button compartilharButton;
	TextView teste;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_significado);

		giriaTextView = (TextView) findViewById(R.id.giriaTextView);
		significadoTextView = (TextView) findViewById(R.id.significadoTextView);
		voltarButton = (Button) findViewById(R.id.voltarButton);
		compartilharButton = (Button) findViewById(R.id.compartilharButton);

		final Intent intent = getIntent();
		final Bundle bundle = intent.getExtras();
		String giria = bundle.getString("giria");
		String significado = bundle.getString("significado");

		giriaTextView.setText(giria);
		significadoTextView.setText(significado);

		voltarButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Intent intent1 = new Intent(SignificadoActivity.this, MainActivity.class);
				startActivity(intent1);
				finish();
			}
		});

		compartilharButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {

				String textMessage = "Giria: " + bundle.getString("giria") + "\nDefinição: " + bundle.getString("significado");

				// Create the text message with a string
				Intent sendIntent = new Intent();
				sendIntent.setAction(Intent.ACTION_SEND);
				sendIntent.putExtra(Intent.EXTRA_TEXT, textMessage);
				sendIntent.setType("text/plain");

				// Verify that the intent will resolve to an activity
				if (sendIntent.resolveActivity(getPackageManager()) != null) {
					startActivity(sendIntent);

				}
			}
		});


	}
}
