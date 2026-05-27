package com.example.higanbana

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class AdicionarActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_adicionar)

        val edtNome = findViewById<EditText>(R.id.edtNome)
        val edtQuantidade = findViewById<EditText>(R.id.edtQuantidade)
        val edtPreco = findViewById<EditText>(R.id.edtPreco)
        val edtCodigo = findViewById<EditText>(R.id.edtCodigo)

        val btnSalvar = findViewById<Button>(R.id.btnSalvar)
        val btnCancelar = findViewById<Button>(R.id.btnCancelar)

        btnSalvar.setOnClickListener {

            val produto = Produto(

                edtNome.text.toString(),
                edtQuantidade.text.toString().toInt(),
                edtPreco.text.toString().toDouble(),
                edtCodigo.text.toString()
            )

            BancoProdutos.listaProdutos.add(produto)

            Toast.makeText(
                this,
                "Produto adicionado!",
                Toast.LENGTH_SHORT
            ).show()

            startActivity(Intent(this, EstoqueActivity::class.java))
        }

        btnCancelar.setOnClickListener {

            startActivity(Intent(this, EstoqueActivity::class.java))
        }
    }
}