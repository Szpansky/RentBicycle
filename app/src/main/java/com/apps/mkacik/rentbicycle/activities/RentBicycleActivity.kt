package com.apps.mkacik.rentbicycle.activities

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.apps.mkacik.rentbicycle.R

class RentBicycleActivity : AppCompatActivity() {

    enum class SortCase {
        BRAND, COLOR, STATUS, COST
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_rent_bicycle)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    companion object {
        fun startActivity(context: Context): Intent {
            return Intent(context, RentBicycleActivity::class.java)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.rent_bicycle_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId){
            R.id.sort_by_brand_item -> sortBy(SortCase.BRAND)
            R.id.sort_by_color_item -> sortBy(SortCase.COLOR)
            R.id.sort_by_status_item -> sortBy(SortCase.STATUS)
            R.id.sort_by_cost_item -> sortBy(SortCase.COST)
            R.id.home -> onBackPressed()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun sortBy(sortCase: SortCase) {


    }
}
