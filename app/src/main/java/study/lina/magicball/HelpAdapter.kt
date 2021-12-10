package study.lina.magicball

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class HelpAdapter(private val helpParagraf:List<String>):RecyclerView.Adapter<HelpViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HelpViewHolder {
        val itemView=LayoutInflater.from(parent.context)
            .inflate(R.layout.help_list_item,parent,false)
        return HelpViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: HelpViewHolder, position: Int) {
        val name = helpParagraf[position]
        holder.bind(name)
    }

    override fun getItemCount(): Int {
        return helpParagraf.size
    }
}