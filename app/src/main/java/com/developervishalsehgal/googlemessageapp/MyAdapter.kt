package developervishalsehgal.fabdemo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.developervishalsehgal.googlemessageapp.Message
import com.developervishalsehgal.googlemessageapp.R
import kotlinx.android.synthetic.main.list_item_message.view.*

class MyAdapter(val messageItems: List<Message>, val itemClick: (Message) -> Unit) :
    RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item_message, parent, false)
        return ViewHolder(view, itemClick)
    }//ViewHolder

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(messageItems[position])
    }

    override fun getItemCount() = messageItems.size // Size


    inner class ViewHolder(itemView: View, val itemClick: (Message) -> Unit) : RecyclerView.ViewHolder(itemView) {
        fun bind(message: Message) {
            with(message) {
                itemView.setOnClickListener { itemClick(this) }
                itemView.tv_title.text = title
                itemView.tv_body.text = body
                itemView.tv_time.text = time
                itemView.imageView.setColorFilter(color)
            }
        } // ViewHolder


    }// MyAdapter

}