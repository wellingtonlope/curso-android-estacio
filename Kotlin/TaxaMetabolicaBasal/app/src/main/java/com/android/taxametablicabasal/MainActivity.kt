package com.android.taxametablicabasal

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        calcularButton.setOnClickListener {
            var ok = alturaEditText.text.isNotEmpty() && pesoEditText.text.isNotEmpty() && idadeEditText.text.isNotEmpty()

            if(ok){
                var kcal: Double
                var af: Double
                if(masculinoRadioButton.isChecked){
                    if(leveRadioButton.isChecked){
                        af = 1.55
                    } else if(moderadoRadioButton.isChecked) {
                        af = 1.78
                    } else {
                        af = 2.10
                    }

                    kcal = (66.5 + (14 * pesoEditText.text.toString().toDouble()) + (5 * alturaEditText.text.toString().toDouble()) - (6.7 * idadeEditText.text.toString().toDouble())) * af

                } else {
                    if(leveRadioButton.isChecked){
                        af = 1.56
                    } else if(moderadoRadioButton.isChecked) {
                        af = 1.64
                    } else {
                        af = 1.82
                    }

                    kcal = (655 + (9.6 * pesoEditText.text.toString().toDouble()) + (1.8 * alturaEditText.text.toString().toDouble()) - (4.7 * idadeEditText.text.toString().toDouble())) * af
                }

                val df = DecimalFormat("0.00")
                var resultado = "Sua TMB é de " + df.format(kcal) + " kcal diárias"
                if(semanaCheckBox.isChecked) {
                    resultado += "\nSua TMB semanal é de " + df.format(kcal * 7) + " kcal"
                }
                if(mesCheckBox.isChecked) {
                    resultado += "\nSua TMB mensal é de " + df.format(kcal * 30) + " kcal"
                }

                Toast.makeText(applicationContext, resultado, Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(applicationContext, "Informe os valores", Toast.LENGTH_SHORT).show()
            }
        }

    }
}
