package com.developervishalsehgal.googlemessageapp


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.core.widget.NestedScrollView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.appbar.AppBarLayout
import developervishalsehgal.fabdemo.MyAdapter
import kotlinx.android.synthetic.main.fragment_main.view.*

class MainFragment : androidx.fragment.app.Fragment() {

    private var fabTitle: TextView? = null
    private var appbar: AppBarLayout? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val viewOfLayout = inflater.inflate(R.layout.fragment_main, container, false)

        val activity = activity as MainActivity
        fabTitle = activity.getChatFabTitle()
        appbar = activity.getAppbarLayout()

        val recyclerView = viewOfLayout.findViewById(R.id.my_rv) as RecyclerView
        recyclerView.layoutManager = LinearLayoutManager(this.context)
        val adapter = MyAdapter(populateData()) {
            Toast.makeText(context, "Do your own actions here", Toast.LENGTH_SHORT).show()
        }
        recyclerView.adapter = adapter



        handleFab(viewOfLayout)

        return viewOfLayout
    }

    private fun populateData(): List<Message> {
        val list = mutableListOf<Message>()
        for (i in 0..20)
            list.add(i, Message("Vishal Sehgal", getString(R.string.dummy_body), "Sat", R.color.contactOne))
        return list
    }

    private fun handleFab(view: View) {
        view.nested_scroll_view.setOnScrollChangeListener(NestedScrollView.OnScrollChangeListener { v, scrollX, scrollY, oldScrollX, oldScrollY ->

            if (scrollY > oldScrollY) {
                fabTitle!!.visibility = View.GONE
                appbar!!.elevation = 10.0f

            } else if (scrollX == scrollY) {
                fabTitle!!.visibility = View.VISIBLE
                appbar!!.elevation = 0.0f

            } else {
                fabTitle!!.visibility = View.VISIBLE

            }

        })

    }


}
