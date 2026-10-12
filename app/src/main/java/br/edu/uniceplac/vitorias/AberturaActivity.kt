package br.edu.uniceplac.vitorias

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import br.edu.uniceplac.vitorias.databinding.ActivityAberturaBinding

class AberturaActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAberturaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityAberturaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Impede que o conteúdo fique atrás das barras do sistema
        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
            val bars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(bars.left, bars.top, bars.right, bars.bottom)
            insets
        }

        // Botão VITÓRIAS: vai para a Home
        binding.btnEntrar.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            finish() // fecha a abertura: o "voltar" da Home não retorna para cá
        }
    }
}