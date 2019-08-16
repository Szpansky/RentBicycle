package com.apps.mkacik.rentbicycle.activities

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.apps.mkacik.rentbicycle.R
import com.apps.mkacik.rentbicycle.data.AppSharedPref
import com.apps.mkacik.rentbicycle.dialogs.FirstRunDialog
import com.apps.mkacik.rentbicycle.fragments.BicycleListFragment
import com.apps.mkacik.rentbicycle.fragments.RentedListFragment
import com.apps.mkacik.rentbicycle.fragments.WalletFragment
import com.google.android.material.navigation.NavigationView


class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {


    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.listButton -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.frame, BicycleListFragment.newInstance(), BicycleListFragment.TAG)
                    .commit()
            }
            R.id.rentedButton -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.frame, RentedListFragment.newInstance(), RentedListFragment.TAG)
                    .commit()
            }
            R.id.walletButton -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.frame, WalletFragment.newInstance(), WalletFragment.TAG)
                    .commit()
            }
        }

        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        drawerLayout.closeDrawer(GravityCompat.START)

        return true
    }


    override fun onBackPressed() {
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if(AppSharedPref().isFirstRun(this)){
            FirstRunDialog.newInstance().show(supportFragmentManager, FirstRunDialog.TAG.toString())
        }

        setContentView(R.layout.activity_main)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)
        val toggle = ActionBarDrawerToggle(
            this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        navView.setNavigationItemSelectedListener(this)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.frame, BicycleListFragment.newInstance(), BicycleListFragment.TAG).commit()
        }
    }

}
