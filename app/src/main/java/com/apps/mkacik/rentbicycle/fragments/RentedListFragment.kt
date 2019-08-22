package com.apps.mkacik.rentbicycle.fragments

import android.os.Bundle
import android.view.*
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.apps.mkacik.rentbicycle.R
import com.apps.mkacik.rentbicycle.activities.RentedBicycleActivity
import com.apps.mkacik.rentbicycle.adapters.RentedAdapter
import com.apps.mkacik.rentbicycle.data.database.model.Rent
import com.apps.mkacik.rentbicycle.data.database.providers.RentProvider
import com.apps.mkacik.rentbicycle.utilities.App
import com.apps.mkacik.rentbicycle.viewModels.RentedViewModel
import com.apps.mkacik.rentbicycle.viewModels.ViewModelFactory
import kotlinx.android.synthetic.main.list_layout.*
import javax.inject.Inject

class RentedListFragment : BaseListFragment(), RentedAdapter.RentedAdapterInterface {

    @Inject
    lateinit var factory: ViewModelFactory.Factory

    private lateinit var viewModel: RentedViewModel

    companion object {
        val TAG = this::class.java.name
        const val NAME = "Rented Bicycles"
        const val SPAN_COUNT = 2

        fun newInstance(): RentedListFragment {
            return RentedListFragment()
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        injectDependencies()
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.list_layout, container, false)
        viewModel = ViewModelProviders.of(this, factory).get(RentedViewModel::class.java)
        return view
    }


    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.rented_bicycle_menu, menu)
    }


    override fun hasOptionMenuEnabled(): Boolean = true


    override fun setTitle(): CharSequence? = NAME


    override fun loadData() {
        viewModel.getRentedBicycles(object : RentProvider.GetRentBicyclesCallBack {
            override fun onSuccess(bicycleList: LiveData<List<Rent>>) {
                bicycleList.observe(this@RentedListFragment, Observer { bicycles ->
                    recycle_view.adapter = RentedAdapter(bicycles, this@RentedListFragment)
                })
            }

            override fun onFail(throwable: Throwable) {
                infoToast("ERROR ${throwable.message}")
            }
        })
    }


    private fun injectDependencies() {
        (activity?.application as App).getMyAppComponent().inject(this)
    }


    override fun getRecycleView(): RecyclerView = recycle_view


    override fun setRecycleLayoutManager(recycle: RecyclerView) {
        recycle.layoutManager = StaggeredGridLayoutManager(SPAN_COUNT, StaggeredGridLayoutManager.VERTICAL)
    }

    override fun onItemClick(rent: Rent) {
        requireContext().startActivity(RentedBicycleActivity.newIntent(requireContext(), rent))
    }
}