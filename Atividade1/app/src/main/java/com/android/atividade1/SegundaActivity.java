package com.android.atividade1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SegundaActivity extends AppCompatActivity {

    Button buttonAnterior;
    Button buttonProximo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);

        buttonAnterior = (Button) findViewById(R.id.buttonAnterior);
        buttonProximo = (Button) findViewById(R.id.buttonProximo);

        buttonAnterior.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SegundaActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        buttonProximo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SegundaActivity.this, TerceiraActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
