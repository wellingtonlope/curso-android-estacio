package com.android.dicionario;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SignificadoActivity extends AppCompatActivity {

	TextView giriaTextView;
	TextView significadoTextView;
	Button voltarButton;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_significado);

		giriaTextView = (TextView) findViewById(R.id.giriaTextView);
		significadoTextView = (TextView) findViewById(R.id.significadoTextView);
		voltarButton = (Button) findViewById(R.id.voltarButton);

		final Intent intent = getIntent();
		Bundle bundle = intent.getExtras();
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

	}
}
