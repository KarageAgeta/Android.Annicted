package io.gihub.karageageta.annicted.ui.watch

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import io.github.karageageta.annicted.R
import io.github.karageageta.annicted.helper.RecyclerViewAdapter
import io.github.karageageta.network.model.data.Work
import kotlinx.android.synthetic.main.item_work.view.*

class WorkListRecyclerAdapter(
        private val context: Context
) : RecyclerViewAdapter<Work>(context) {
    override fun onCreateView(
            parent: ViewGroup,
            viewType: Int
    ): RecyclerView.ViewHolder = ViewHolder(inflater.inflate(R.layout.item_work, parent, false))

    override fun onBindView(parent: ViewGroup, itemView: View, position: Int) {
        val item = getItem(position)

        Glide.with(context)
                .load(item.images.recommendedUrl)
                .into(itemView.image_work)
        itemView.text_title.text = item.title
    }

    override fun getItemCount(): Int = items.size
}