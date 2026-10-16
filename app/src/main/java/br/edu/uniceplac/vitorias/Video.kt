package br.edu.uniceplac.vitorias

import android.net.Uri

/**
 * Um vídeo cadastrado pelo admin.
 * Os campos espelham a tela "Editar vídeo" do painel de administração.
 */
data class Video(
    val titulo: String,
    val descricao: String,
    val link: String,
    val campus: String,
    val exibirNaHome: Boolean
) {
    /** Extrai o ID do vídeo do link (youtube.com/watch?v=ID ou youtu.be/ID). */
    val youtubeId: String?
        get() {
            val uri = Uri.parse(link)
            return when (uri.host?.removePrefix("www.")?.removePrefix("m.")) {
                "youtube.com" -> uri.getQueryParameter("v")
                "youtu.be" -> uri.lastPathSegment
                else -> null
            }
        }

    /** Miniatura gerada pelo próprio YouTube: o admin não precisa cadastrar foto. */
    val miniaturaUrl: String?
        get() = youtubeId?.let { "https://img.youtube.com/vi/$it/hqdefault.jpg" }
}
