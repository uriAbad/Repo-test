package uriabad.com.startapp.ui.scenes.albums.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import uriabad.com.startapp.R
import uriabad.com.startapp.ui.entities.AlbumViewEntity
import uriabad.com.startapp.ui.utils.extensions.inflate
import uriabad.com.startapp.ui.utils.extensions.load
import kotlinx.android.synthetic.main.item_album.view.*

class AlbumsAdapter(private val clickListener: (AlbumViewEntity) -> Unit)
    : RecyclerView.Adapter<AlbumsAdapter.AlbumViewHolder>() {

    var items = ArrayList<AlbumViewEntity>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
            AlbumViewHolder(parent.inflate(R.layout.item_album))

    override fun getItemCount() = items.count()

    override fun onBindViewHolder(holder: AlbumViewHolder, position: Int) =
            holder.bind(items[position], clickListener)

    class AlbumViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(album: AlbumViewEntity, clickListener: (AlbumViewEntity) -> Unit) = with(album) {
            itemView.album_name.text = album.title
            itemView.album_image.load(album.image)
            itemView.setOnClickListener { clickListener(this) }
        }
    }
}