package edu.itesm.ubereats

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    data class Compras(var total: Double)
    var totFinal = 0.0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        totFinal = precioTotal(0.0)
        colorBotones()
        ceroPorciento.setBackgroundColor(Color.GREEN);
        inicio()

    }

    fun inicio(){
        val comprasLista = mutableListOf<Compras>()
        var porcentaje = 0.0;
        subt.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                totFinal = precioTotal(porcentaje);
            }
        })
        diezPorciento.setOnClickListener {
            porcentaje = 1.1;
            totFinal = precioTotal(porcentaje);
            colorBotones()
            diezPorciento.setBackgroundColor(Color.GREEN)
        }

        quincePorciento.setOnClickListener {
            porcentaje = 1.15;
            totFinal = precioTotal(porcentaje);
            colorBotones()
            quincePorciento.setBackgroundColor(Color.GREEN)
        }

        veintePorciento.setOnClickListener {
            porcentaje = 1.2;
            totFinal = precioTotal(porcentaje);
            colorBotones()
            veintePorciento.setBackgroundColor(Color.GREEN)
        }

        veinticincoPorciento.setOnClickListener {
            porcentaje = 1.25;
            totFinal = precioTotal(porcentaje);
            colorBotones()
            veinticincoPorciento.setBackgroundColor(Color.GREEN)
        }

        ceroPorciento.setOnClickListener {
            porcentaje = 0.0;
            totFinal = precioTotal(porcentaje);
            colorBotones()
            ceroPorciento.setBackgroundColor(Color.GREEN)
        }

        total.setOnClickListener {
            if(totFinal != 0.0){
                val totFinalClass = Compras(totFinal)
                comprasLista.add(totFinalClass)
                Log.i(  "edu.itesm.daec",  "Esta es comprasLista $comprasLista")
                sof.text = "$ 0.0"
                sf.text =  "$ 0.0"
                df.text =  "$ 0.0"
                subt.text.clear()
                total.text = " Total:                          $ 0.0"
            }else{
                Toast.makeText(this, "Inserta un subtotal válido", Toast.LENGTH_LONG).show()
            }
            val intent = Intent(this, RecyclerActivity::class.java)
            startActivity(intent)
        }

    }

    fun precioTotal(porcentaje: Double): Double{
        if (subt.text.toString() != "" ){
            val subtotal = subt.text.toString().toDouble()
            val smallOrderFee = subtotal * 0.02
            val serviceFee = subtotal * 0.05
            val deliveryFee = subtotal * 0.1
            val tot = (subtotal + smallOrderFee + serviceFee + deliveryFee)
            sof.text = "$smallOrderFee"
            sf.text = "$serviceFee"
            df.text = "$deliveryFee"
            if(porcentaje == 0.0){
                total.text = " Total:                          $ $tot"
                return tot
            }else {
                val cerop = tot * porcentaje
                total.text = " Total:                          $ $cerop"
                return cerop
            }
        }else{
            return 0.0;
        }
    }

    fun colorBotones(){
        diezPorciento.setBackgroundColor(Color.GRAY)
        quincePorciento.setBackgroundColor(Color.GRAY)
        veintePorciento.setBackgroundColor(Color.GRAY)
        veinticincoPorciento.setBackgroundColor(Color.GRAY)
        ceroPorciento.setBackgroundColor(Color.GRAY)
    }
}