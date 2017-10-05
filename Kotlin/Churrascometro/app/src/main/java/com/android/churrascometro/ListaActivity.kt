package com.android.churrascometro

import android.annotation.TargetApi
import android.icu.text.DecimalFormat
import android.os.Build
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_lista.*
import android.support.v4.app.NavUtils
import android.view.MenuItem
import android.widget.Toast


@TargetApi(Build.VERSION_CODES.N)
class ListaActivity : AppCompatActivity() {

    var homens: Int = 0
    var mulheres: Int = 0
    var criancas: Int = 0
    val df = DecimalFormat("#0.00")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista)

        homens = intent.getIntExtra("homens", 0)
        mulheres = intent.getIntExtra("mulheres", 0)
        criancas = intent.getIntExtra("criancas", 0)

        val meat: Compra = Compra(R.drawable.meat,"Carne", "${df.format(calcMeat())} kg")
        val sausage = Compra(R.drawable.sausage, "Linguiça", "${df.format(calcSausage())} kg")
        val rice = Compra(R.drawable.rice, "Arroz", "${df.format(calcRice())} kg")
        val farofa = Compra(R.drawable.farofa, "Farofa", "${df.format(calcFarofa())} kg")
        val salad = Compra(R.drawable.salad, "Salada", "à vontade")
        val coal = Compra(R.drawable.coal, "Carvão", "${calcCoal()} sacos(8kg)")
        val salt = Compra(R.drawable.salt, "Sal grosso", "${calcSalt()} saco(s)")
        val beer = Compra(R.drawable.beer, "Cerveja", "${calcBeer()} latas")
        val liquor = Compra(R.drawable.liquor, "Cachaça", "${calcLiquor()} garrafa(s)")
        val lemon = Compra(R.drawable.lemon, "Limão", "${calcLemon()} unidades")
        val soda = Compra(R.drawable.soda, "Refrigerante", "${df.format(calcSoda())} L")
        val water = Compra(R.drawable.water, "Água", "${df.format(calcSoda())} L")

        val compras: List<Compra> = listOf(meat, sausage, rice, farofa, salad, coal, salt, beer, liquor, lemon, soda, water)

        var adapter = CompraAdapter(compras, this)

        comprasListView.adapter = adapter

    }

    fun calcMeat() = ((homens + mulheres) * 400.00 + criancas * 300.00) / 1000.00

    fun calcSausage() = (calcMeat() * 40.00) / 100.00

    fun calcRice() = ((homens + mulheres + criancas) * 90) / 1000.00

    fun calcFarofa() = ((homens + mulheres + criancas) * 110) / 1000.00

    fun calcCoal() = ((calcMeat() + calcSausage()) / 5).toInt()

    fun calcSalt() = ((calcMeat() + calcSausage()) / 25).toInt()

    fun calcBeer() = (homens + mulheres + criancas) * 6

    fun calcLiquor() = (homens + mulheres + criancas) / 15

    fun calcLemon() = (((homens + mulheres + criancas) * 300) * 2) / 300

    fun calcSoda() = ((homens + mulheres + criancas) * 500.00) / 1000.00

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.getItemId()) {
            android.R.id.home -> {
                NavUtils.navigateUpFromSameTask(this)
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
