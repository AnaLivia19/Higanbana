package com.example.higanbana

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_login)

        val edtUsuario = findViewById<EditText>(R.id.edtUsuario)
        val edtSenha = findViewById<EditText>(R.id.edtSenha)

        val btnEntrar = findViewById<Button>(R.id.btnEntrar)
        val btnInicio = findViewById<Button>(R.id.btnInicio)

        btnEntrar.setOnClickListener {

            if (
                edtUsuario.text.toString() == "Ana" &&
                edtSenha.text.toString() == "1327"
            ) {

                startActivity(
                    Intent(this, EstoqueActivity::class.java)
                )

            } else {

                Toast.makeText(
                    this,
                    "Usuário ou senha inválidos",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

        btnInicio.setOnClickListener {

            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}