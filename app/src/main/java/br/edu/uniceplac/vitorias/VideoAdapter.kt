package br.edu.uniceplac.vitorias

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.edu.uniceplac.vitorias.databinding.ItemVideoBinding
import coil.load

/**
 * Liga a lista de vídeos ao carrossel (ViewPager2):
 * cria um card por vídeo e avisa a tela quando um deles é tocado.
 */
class VideoAdapter(
    private val videos: List<Video>,
    private val aoClicar: (Video) -> Unit
) : RecyclerView.Adapter<VideoAdapter.VideoViewHolder>() {

    class VideoViewHolder(val binding: ItemVideoBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideoViewHolder {
        val binding = ItemVideoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return VideoViewHolder(binding)
    }

    override fun onBindViewHolder(holder: VideoViewHolder, position: Int) {
        val video = videos[position]
        val contexto = holder.itemView.context

        holder.binding.imgMiniatura.load(video.miniaturaUrl) { crossfade(true) }
        holder.binding.root.contentDescription =
            contexto.getString(R.string.home_assistir_video, video.titulo)
        holder.binding.root.setOnClickListener { aoClicar(video) }
    }

    override fun getItemCount() = videos.size
}
