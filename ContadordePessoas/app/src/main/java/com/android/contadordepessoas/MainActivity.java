package com.android.contadordepessoas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

	TextView totalPessoasTextView;

	Button menosHomensButton;
	Button maisHomensButton;
	TextView totalHomensTextView;

	Button menosMulheresButton;
	Button maisMulheresButton;
	TextView totalMulheresTextView;

	Button menosCriancasButton;
	Button maisCriancasButton;
	TextView totalCriancasTextView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);


		//Homenos
		totalHomensTextView = (TextView) findViewById(R.id.totalHomensTextView);

		menosHomensButton = (Button) findViewById(R.id.menosHomensButton);
		menosHomensButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				menos(totalHomensTextView);
			}
		});

		maisHomensButton = (Button) findViewById(R.id.maisHomensButton);
		maisHomensButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				mais(totalHomensTextView);
			}
		});

		//Mulheres
		totalMulheresTextView = (TextView) findViewById(R.id.totalMulheresTextView);

		menosMulheresButton = (Button) findViewById(R.id.menosMulheresButton);
		menosMulheresButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				menos(totalMulheresTextView);
			}
		});

		maisMulheresButton = (Button) findViewById(R.id.maisMulheresButton);
		maisMulheresButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				mais(totalMulheresTextView);
			}
		});

		//Crianças
		totalCriancasTextView = (TextView) findViewById(R.id.totalCriancasTextView);

		menosCriancasButton = (Button) findViewById(R.id.menosCriancasButton);
		menosCriancasButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				menos(totalCriancasTextView);
			}
		});

		maisCriancasButton = (Button) findViewById(R.id.maisCriancasButton);
		maisCriancasButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				mais(totalCriancasTextView);
			}
		});

	}

	public void menos (TextView menosTextView) {
		if (Integer.parseInt(menosTextView.getText().toString()) > 0){
			menosTextView.setText("" + (Integer.parseInt(menosTextView.getText().toString()) - 1));
		}
		total();
	}

	public void mais (TextView maisTextView) {
		maisTextView.setText("" + (Integer.parseInt(maisTextView.getText().toString()) + 1));
		total();
	}

	public void total () {
		totalPessoasTextView = (TextView) findViewById(R.id.totalPessoasTextView);
		totalHomensTextView = (TextView) findViewById(R.id.totalHomensTextView);
		totalMulheresTextView = (TextView) findViewById(R.id.totalMulheresTextView);
		totalCriancasTextView = (TextView) findViewById(R.id.totalCriancasTextView);

		totalPessoasTextView.setText("" + (Integer.parseInt(totalHomensTextView.getText().toString()) + Integer.parseInt(totalMulheresTextView.getText().toString()) + Integer.parseInt(totalCriancasTextView.getText().toString())));
	}
}
