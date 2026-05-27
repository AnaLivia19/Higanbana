package com.example.higanbana

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class EstoqueActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_estoque)

        val lista = findViewById<ListView>(R.id.listViewProdutos)

        val produtosTexto = mutableListOf<String>()

        for (produto in BancoProdutos.listaProdutos) {

            produtosTexto.add(
                "Nome: ${produto.nome}\n" +
                        "Quantidade: ${produto.quantidade}\n" +
                        "Preço: R$ ${produto.preco}\n" +
                        "Código: ${produto.codigo}"
            )
        }

        val adapter = ArrayAdapter(
            this,
            R.layout.item_produto,
            R.id.txtProduto,
            produtosTexto
        )

        lista.adapter = adapter

        val btnAdicionar = findViewById<Button>(R.id.btnAdicionar)
        val btnInicio = findViewById<Button>(R.id.btnEstoque)

        btnAdicionar.setOnClickListener {

            startActivity(Intent(this, AdicionarActivity::class.java))
        }

        btnInicio.setOnClickListener {

            startActivity(Intent(this, MainActivity::class.java))
        }

        lista.setOnItemClickListener { _, _, position, _ ->

            val intent = Intent(this, AtualizarActivity::class.java)

            intent.putExtra("posicao", position)

            startActivity(intent)
        }

        lista.setOnItemLongClickListener { _, _, position, _ ->

            val intent = Intent(this, ExcluirActivity::class.java)

            intent.putExtra("posicao", position)

            startActivity(intent)

            true
        }
    }
}