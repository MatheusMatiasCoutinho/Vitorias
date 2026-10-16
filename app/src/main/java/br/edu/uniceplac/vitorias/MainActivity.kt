package br.edu.uniceplac.vitorias

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.text.SpannableString
import android.text.Spanned
import android.text.style.ForegroundColorSpan
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.viewpager2.widget.ViewPager2
import br.edu.uniceplac.vitorias.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    // Timer do carrossel: troca de vídeo a cada INTERVALO_MS
    private val handler = Handler(Looper.getMainLooper())
    private val avancarVideo = object : Runnable {
        override fun run() {
            val total = binding.pagerVideos.adapter?.itemCount ?: 0
            if (total > 1) {
                val proximo = (binding.pagerVideos.currentItem + 1) % total
                binding.pagerVideos.setCurrentItem(proximo, true)
            }
            handler.postDelayed(this, INTERVALO_MS)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Impede que o conteúdo fique atrás das barras do sistema
        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
            val bars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(bars.left, bars.top, bars.right, bars.bottom)
            insets
        }

        configurarTitulo()
        configurarCarrossel()
        configurarBarraNavegacao()

        // Saída rápida: fecha todas as telas do app
        binding.btnFechar.setOnClickListener { finishAffinity() }

        // TODO: abrir Ajustes e Informações e Direitos quando as telas existirem
    }

    // O timer só roda com a tela visível (economiza bateria)
    override fun onResume() {
        super.onResume()
        handler.postDelayed(avancarVideo, INTERVALO_MS)
    }

    override fun onPause() {
        super.onPause()
        handler.removeCallbacks(avancarVideo)
    }

    /** Pinta só a palavra "sozinha" do título com a cor de destaque. */
    private fun configurarTitulo() {
        val titulo = getString(R.string.home_titulo)
        val destaque = getString(R.string.home_titulo_destaque)
        val inicio = titulo.indexOf(destaque)

        val texto = SpannableString(titulo)
        if (inicio >= 0) {
            texto.setSpan(
                ForegroundColorSpan(ContextCompat.getColor(this, R.color.vitorias_malva_claro)),
                inicio, inicio + destaque.length,
                Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
            )
        }
        binding.txtTitulo.text = texto
    }

    private fun configurarCarrossel() {
        val videos = VideoRepository.listarParaHome()

        // Sem vídeos para exibir: esconde a seção Eventos inteira
        if (videos.isEmpty()) {
            binding.grupoEventos.visibility = View.GONE
            return
        }

        binding.pagerVideos.adapter = VideoAdapter(videos) { video -> abrirVideo(video) }

        // Troca só pelo timer, não pelo dedo
        binding.pagerVideos.isUserInputEnabled = false

        // A descrição acompanha o vídeo que está na tela
        binding.txtDescricaoVideo.text = videos.first().descricao
        binding.pagerVideos.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                binding.txtDescricaoVideo.text = videos[position].descricao
            }
        })
    }

    private fun configurarBarraNavegacao() {
        // TODO: trocar pelo startActivity de cada tela quando forem criadas
        binding.barraNavegacao.navDenuncia.setOnClickListener { emBreve() }
        binding.barraNavegacao.navApoio.setOnClickListener { emBreve() }
        binding.barraNavegacao.navEmergencia.setOnClickListener { emBreve() }
    }

    private fun emBreve() {
        Toast.makeText(this, R.string.nav_em_breve, Toast.LENGTH_SHORT).show()
    }

    /** Abre o link no app do YouTube ou, se não houver, no navegador. */
    private fun abrirVideo(video: Video) {
        try {
            startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(video.link)))
        } catch (e: ActivityNotFoundException) {
            Toast.makeText(this, R.string.home_erro_abrir_video, Toast.LENGTH_SHORT).show()
        }
    }

    companion object {
        private const val INTERVALO_MS = 5_000L
    }
}