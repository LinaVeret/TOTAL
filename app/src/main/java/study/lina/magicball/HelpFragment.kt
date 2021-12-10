package study.lina.magicball

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


class HelpFragment : Fragment() {

    lateinit var helpRecyclerView: RecyclerView
    lateinit var shopOnlainButton: Button


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view= inflater.inflate(R.layout.fragment_help, container, false)
        val helpName:List<String> = listOf("Сформулируй свой вопрос так, \n чтобы было только два варианта \n ответа: <да> или <нет>", "Нажми кнопку PUSH", "Приготовься удивляться!")
        shopOnlainButton=view.findViewById(R.id.shop_onlain_button)

        helpRecyclerView=view.findViewById(R.id.help__recycler_view)
        helpRecyclerView.layoutManager=
            LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        helpRecyclerView.adapter=HelpAdapter(helpName)
        shopOnlainButton.setOnClickListener{
            val link=Uri.parse("https://www.ozon.ru/product/magicheskiy-shar-8-325193887/?gclid=CjwKCAiAksyNBhAPEiwAlDBeLHahLSKQYuSu26846Dd3k7XegYlbB-PqjSkZI6a9XUK4aILFIoi9-hoCvr4QAvD_BwE&sh=_gfNqIYU&utm_campaign=RF_Product_Shopping_Smart_newclients_SSC&utm_medium=cpc&utm_source=google")
            val intent=Intent(Intent.ACTION_VIEW, link)
            context?.startActivity(intent
            )

        }
        return view
    }
}