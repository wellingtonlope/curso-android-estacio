package com.android.dicionario;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

	String[][] girias = {{"Maceta", "Pixe", "Oitchenta", "Galeroso"}, {"Algo grande", "Algo que fede", "Venezuelas que vendem o corpo por dinheiro", "Jovens que não seguem a lei"}};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		ListView dicionarioListView = (ListView) findViewById(R.id.dicionarioListView);

		ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_list_item_1, girias[0]);
		dicionarioListView.setAdapter(adapter);

		dicionarioListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
				Intent intent = new Intent(MainActivity.this, SignificadoActivity.class);
				Bundle bundle = new Bundle();
				bundle.putString("giria", girias[0][i]);
				bundle.putString("significado", girias[1][i]);
				intent.putExtras(bundle);
				startActivity(intent);
			}
		});

	}
}
