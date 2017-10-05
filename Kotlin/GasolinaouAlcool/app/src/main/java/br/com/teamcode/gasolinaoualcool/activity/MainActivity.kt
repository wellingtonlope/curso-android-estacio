package br.com.teamcode.gasolinaoualcool.activity

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import br.com.livroandroid.carros.extensions.setupToolbar
import br.com.teamcode.gasolinaoualcool.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupToolbar(R.id.toolbar)

        calcularButton.setOnClickListener {
            val ok = alcoolEditText.text.isNotEmpty() && gasolinaEditText.text.isNotEmpty()

            if(ok) {
                val percentual = alcoolEditText.text.toString().toDouble() / gasolinaEditText.text.toString().toDouble()

                if(percentual <= 0.70) {
                    resultadoTextView.text = "Melhor usar álcool"
                } else {
                    resultadoTextView.text = "Melhor usar gasolina"
                }
            }
        }

    }
}
