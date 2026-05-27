package com.example.higanbana

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class ExcluirActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_excluir)

        val posicao = intent.getIntExtra("posicao", -1)

        val produto = BancoProdutos.listaProdutos[posicao]

        val txtProduto = findViewById<TextView>(R.id.txtProdutoExcluir)

        txtProduto.text =
            "Produto: ${produto.nome}\n" +
                    "Quantidade: ${produto.quantidade}\n" +
                    "Preço: R$ ${produto.preco}"

        val btnExcluir = findViewById<Button>(R.id.btnExcluirProduto)
        val btnCancelar = findViewById<Button>(R.id.btnCancelarExclusao)

        btnExcluir.setOnClickListener {

            AlertDialog.Builder(this)
                .setTitle("Excluir Produto")
                .setMessage("Deseja realmente excluir este produto?")
                .setPositiveButton("SIM") { _, _ ->

                    BancoProdutos.listaProdutos.removeAt(posicao)

                    Toast.makeText(
                        this,
                        "Produto excluído!",
                        Toast.LENGTH_SHORT
                    ).show()

                    startActivity(Intent(this, EstoqueActivity::class.java))
                }
                .setNegativeButton("NÃO", null)
                .show()
        }

        btnCancelar.setOnClickListener {

            startActivity(Intent(this, EstoqueActivity::class.java))
        }
    }
}