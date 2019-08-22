package com.apps.mkacik.rentbicycle.fragments

import android.os.Bundle
import android.view.*
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.RecyclerView
import com.apps.mkacik.rentbicycle.R
import com.apps.mkacik.rentbicycle.adapters.BicyclesAdapter
import com.apps.mkacik.rentbicycle.data.database.entity.BicycleEntity
import com.apps.mkacik.rentbicycle.data.database.providers.BicycleProvider
import com.apps.mkacik.rentbicycle.data.database.providers.RentProvider
import com.apps.mkacik.rentbicycle.utilities.App
import com.apps.mkacik.rentbicycle.viewModels.BicyclesViewModel
import com.apps.mkacik.rentbicycle.viewModels.ViewModelFactory
import kotlinx.android.synthetic.main.list_layout.*
import javax.inject.Inject

class BicycleListFragment : BaseListFragment(), BicyclesAdapter.BicycleAdapterInterface {

    @Inject
    lateinit var factory: ViewModelFactory.Factory

    private lateinit var viewModel: BicyclesViewModel

    companion object {
        val TAG = this::class.java.name
        const val NAME = "Bicycles List"

        fun newInstance(): BicycleListFragment {
            return BicycleListFragment()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        injectDependencies()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.list_layout, container, false)
        viewModel = ViewModelProviders.of(this, factory).get(BicyclesViewModel::class.java)
        return view
    }


    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater?.inflate(R.menu.all_bicycle_menu, menu)
    }


    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        return when (item?.itemId) {
            R.id.sort_by_cost_item -> true
            R.id.sort_by_status_item -> true
            R.id.sort_by_color_item -> true
            R.id.sort_by_brand_item -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun hasOptionMenuEnabled(): Boolean = true


    override fun setTitle(): CharSequence? = NAME


    override fun loadData() {
        viewModel.getBicycles(object : BicycleProvider.GetCallBack {

            override fun onSuccess(bicycleList: LiveData<List<BicycleEntity>>) {
                bicycleList.observe(this@BicycleListFragment, Observer { bicycles ->
                    recycle_view.adapter = BicyclesAdapter(bicycles, this@BicycleListFragment)
                })
            }

            override fun onFail(throwable: Throwable) {
                infoToast("ERROR")
            }
        })
    }


    private fun injectDependencies() {
        (activity?.application as App).getMyAppComponent().inject(this)
    }


    override fun getRecycleView(): RecyclerView = recycle_view


    override fun onItemClick(bicycleEntity: BicycleEntity) {
        infoToast("ITEM CLICK")
    }


    override fun onRentClick(bicycleEntity: BicycleEntity) {
        infoToast("RENT CLICK")

        viewModel.rentBicycle(bicycleEntity, object : RentProvider.RentCallBack {
            override fun onSuccess() {
                infoToast("ADDED")
            }

            override fun onFail(throwable: Throwable) {
                infoToast("ERROR ${throwable.message}")
            }
        })
    }

    override fun onDestroy() {
        super.onDestroy()

    }
}