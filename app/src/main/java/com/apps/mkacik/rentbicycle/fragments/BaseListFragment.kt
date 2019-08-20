package com.apps.mkacik.rentbicycle.fragments

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

abstract class BaseListFragment : Fragment() {

    fun infoToast(info: String) {
        Toast.makeText(context, info, Toast.LENGTH_SHORT).show()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setHasOptionsMenu(hasOptionMenuEnabled())
        activity!!.title = setTitle()
        setRecycleLayoutManager(getRecycleView())
        loadData()
    }

    abstract fun hasOptionMenuEnabled(): Boolean

    abstract fun setTitle(): CharSequence?

    abstract fun loadData()

    abstract fun getRecycleView(): RecyclerView

    open fun setRecycleLayoutManager(recycle: RecyclerView) {
        recycle.layoutManager = LinearLayoutManager(context)
    }
}