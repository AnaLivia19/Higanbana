package com.example.higanbana

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class AtualizarActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_atualizar)

        val posicao = intent.getIntExtra("posicao", -1)

        val produto = BancoProdutos.listaProdutos[posicao]

        val edtNome = findViewById<EditText>(R.id.edtNomeAtualizar)
        val edtQuantidade = findViewById<EditText>(R.id.edtQuantidadeAtualizar)
        val edtPreco = findViewById<EditText>(R.id.edtPrecoAtualizar)

        edtNome.setText(produto.nome)
        edtQuantidade.setText(produto.quantidade.toString())
        edtPreco.setText(produto.preco.toString())

        val btnAtualizar = findViewById<Button>(R.id.btnAtualizarProduto)
        val btnCancelar = findViewById<Button>(R.id.btnCancelarAtualizacao)

        btnAtualizar.setOnClickListener {

            produto.nome = edtNome.text.toString()
            produto.quantidade = edtQuantidade.text.toString().toInt()
            produto.preco = edtPreco.text.toString().toDouble()

            Toast.makeText(
                this,
                "Produto atualizado!",
                Toast.LENGTH_SHORT
            ).show()

            startActivity(Intent(this, EstoqueActivity::class.java))
        }

        btnCancelar.setOnClickListener {

            startActivity(Intent(this, EstoqueActivity::class.java))
        }
    }
}