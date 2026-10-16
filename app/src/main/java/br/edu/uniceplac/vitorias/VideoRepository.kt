package br.edu.uniceplac.vitorias

/**
 * Fonte dos vídeos.
 * Por enquanto é uma lista fixa. Quando o banco existir, só esta classe muda;
 * a tela continua igual.
 */
object VideoRepository {

    // TODO: trocar pelos links reais dos eventos
    private val videos = listOf(
        Video(
            titulo = "Palestra Campus",
            descricao = "13º Evento de Psicologia para identificar opressões e indícios de possíveis causas que podem acontecer",
            link = "https://www.youtube.com/watch?v=BFOaXCBStp4",
            campus = "Taguatinga",
            exibirNaHome = true
        ),
        Video(
            titulo = "Agosto Lilás",
            descricao = "Campanha Agosto Lilás: conscientização pelo fim da violência contra a mulher",
            link = "https://www.youtube.com/watch?v=BFOaXCBStp4",
            campus = "Taguatinga",
            exibirNaHome = true
        ),
        Video(
            titulo = "Roda de Conversa",
            descricao = "Roda de conversa sobre a rede de apoio e os direitos garantidos pela Lei Maria da Penha",
            link = "https://www.youtube.com/watch?v=BFOaXCBStp4",
            campus = "Taguatinga",
            exibirNaHome = false
        )
    )

    /** Vídeos que aparecem no carrossel da Home. */
    fun listarParaHome(): List<Video> = videos.filter { it.exibirNaHome }
}
