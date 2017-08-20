package com.android.trocadetela;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SegundaActivity extends AppCompatActivity {

	Button anteriorButton;
	Button proximoButton;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_segunda);

		anteriorButton = (Button) findViewById(R.id.anteriorButton);

		anteriorButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Intent intent = new Intent(SegundaActivity.this, MainActivity.class);
				startActivity(intent);
				finish();
			}
		});

		proximoButton = (Button) findViewById(R.id.proximoButton);

		proximoButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Intent intent = new Intent(SegundaActivity.this, TerceiraActivity.class);
				startActivity(intent);
				finish();
			}
		});

	}
}
