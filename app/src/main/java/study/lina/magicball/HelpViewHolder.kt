package study.lina.magicball

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class HelpViewHolder(itemView: View) :RecyclerView.ViewHolder(itemView){
    private val helpNameTextView: TextView=
        itemView.findViewById(R.id.help_name_text_view)
    fun bind(name:String){
        helpNameTextView.text= name
    }
}