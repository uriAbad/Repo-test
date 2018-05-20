package uriabad.com.startapp.ui.scenes.repos.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_repo.view.*
import uriabad.com.startapp.R
import uriabad.com.startapp.ui.entities.RepoViewEntity
import uriabad.com.startapp.ui.utils.extensions.inflate

class RepoAdapter(private val buttonText: String, private val clickListener: (RepoViewEntity, Int) -> Unit)
    : RecyclerView.Adapter<RepoAdapter.RepoViewHolder>() {

    var items = ArrayList<RepoViewEntity>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
            RepoViewHolder(parent.inflate(R.layout.item_repo))

    override fun getItemCount() = items.count()

    override fun onBindViewHolder(holder: RepoViewHolder, position: Int) =
            holder.bind(items[position],buttonText, clickListener)

    class RepoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(repo: RepoViewEntity,buttonText: String, clickListener: (RepoViewEntity, Int) -> Unit) = with(repo) {
            itemView.repo_name.text = name
            itemView.action_button.text = buttonText
            itemView.action_button.setOnClickListener { clickListener(this, adapterPosition) }
        }
    }
}