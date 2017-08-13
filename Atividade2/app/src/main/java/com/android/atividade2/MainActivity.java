package com.android.atividade2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    ImageButton buttonMenos1;
    ImageButton buttonMais1;
    TextView textviewQuantidade1;

	ImageButton buttonMenos2;
	ImageButton buttonMais2;
	TextView textviewQuantidade2;

	ImageButton buttonMenos3;
	ImageButton buttonMais3;
	TextView textviewQuantidade3;

	TextView textviewTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

		//botija 5kg
        buttonMenos1 = (ImageButton) findViewById(R.id.buttonMenos1);
        buttonMais1 = (ImageButton) findViewById(R.id.buttonMais1);
		textviewQuantidade1 = (TextView) findViewById(R.id.textviewQuantidade1);

		buttonMenos1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				if (Integer.parseInt((String) textviewQuantidade1.getText()) > 0){
					textviewQuantidade1.setText("" + (Integer.parseInt((String) textviewQuantidade1.getText()) - 1));
				}
				total();
			}
		});
		buttonMais1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				textviewQuantidade1.setText("" + (Integer.parseInt((String) textviewQuantidade1.getText()) + 1));
				total();
			}
		});

		//botija 8kg
		buttonMenos2 = (ImageButton) findViewById(R.id.buttonMenos2);
		buttonMais2 = (ImageButton) findViewById(R.id.buttonMais2);
		textviewQuantidade2 = (TextView) findViewById(R.id.textviewQuantidade2);

		buttonMenos2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				if (Integer.parseInt((String) textviewQuantidade2.getText()) > 0){
					textviewQuantidade2.setText("" + (Integer.parseInt((String) textviewQuantidade2.getText()) - 1));
				}
				total();
			}
		});
		buttonMais2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				textviewQuantidade2.setText("" + (Integer.parseInt((String) textviewQuantidade2.getText()) + 1));
				total();
			}
		});

		//botija 13kg
		buttonMenos3 = (ImageButton) findViewById(R.id.buttonMenos3);
		buttonMais3 = (ImageButton) findViewById(R.id.buttonMais3);
		textviewQuantidade3 = (TextView) findViewById(R.id.textviewQuantidade3);

		buttonMenos3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				if (Integer.parseInt((String) textviewQuantidade3.getText()) > 0){
					textviewQuantidade3.setText("" + (Integer.parseInt((String) textviewQuantidade3.getText()) - 1));
				}
				total();
			}
		});
		buttonMais3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				textviewQuantidade3.setText("" + (Integer.parseInt((String) textviewQuantidade3.getText()) + 1));
				total();
			}
		});
    }

	public void total(){
		float total;
		total = (float) (Integer.parseInt((String) textviewQuantidade1.getText()) * 36.50);
		total += (float) (Integer.parseInt((String) textviewQuantidade2.getText()) * 49.00);
		total += (float) (Integer.parseInt((String) textviewQuantidade3.getText()) * 69.60);
		textviewTotal = (TextView) findViewById(R.id.textviewTotal);
		DecimalFormat df = new DecimalFormat("0.00");
		textviewTotal.setText("R$ " + df.format(total));
	}
}
