package edu.itesm.ubereats

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_recycler.*


class RecyclerActivity : AppCompatActivity() {

    private val titulos = arrayOf("Subtotal","Small Order Fee","Service Fee","Delivery Fee", "Total")
    private val subtitulos = arrayOf("$ 1234","$ 5678","$ 9012","$ 3456","$ 123456")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler)
        initRecycler()
    }
    fun initRecycler(){
        recyclerUber.layoutManager = LinearLayoutManager(this)
        val adapter = RecyclerViewAdapter(titulos,subtitulos)
        recyclerUber.adapter = adapter;
    }
}