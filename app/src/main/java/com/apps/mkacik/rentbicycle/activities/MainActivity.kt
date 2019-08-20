package com.apps.mkacik.rentbicycle.activities

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.apps.mkacik.rentbicycle.R
import com.apps.mkacik.rentbicycle.data.AppSharedPref
import com.apps.mkacik.rentbicycle.data.BicycleRepo
import com.apps.mkacik.rentbicycle.data.database.entity.BicycleEntity
import com.apps.mkacik.rentbicycle.dialogs.FirstRunDialog
import com.apps.mkacik.rentbicycle.fragments.BicycleListFragment
import com.apps.mkacik.rentbicycle.fragments.RentedListFragment
import com.apps.mkacik.rentbicycle.fragments.WalletFragment
import com.apps.mkacik.rentbicycle.utilities.AppModule
import com.apps.mkacik.rentbicycle.utilities.DaggerAppComponent
import com.apps.mkacik.rentbicycle.utilities.RoomModule
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*
import javax.inject.Inject


class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener,
    FirstRunDialog.FirstRunDialogInterface {

    @Inject
    lateinit var bicycleRepo: BicycleRepo

    override fun prepareDatabase() {
        bicycleRepo.deleteData()
        val bicycles: List<BicycleEntity> = listOf(
            BicycleEntity(false, 2.2F, "Red", "Cross"),
            BicycleEntity(true, 1.2F, "Blue", "Cross"),
            BicycleEntity(false, 1.6F, "Red", "Cross"),
            BicycleEntity(false, 3.2F, "Green", "Cross"),
            BicycleEntity(true, 1.7F, "Red", "Cross"),
            BicycleEntity(false, 2.2F, "Unnamed", "Dirty"),
            BicycleEntity(false, 1.2F, "Red", "Kajak"),
            BicycleEntity(false, 0.2F, "Black", "Goral"),
            BicycleEntity(false, 1.4F, "Red", "Dirty"),
            BicycleEntity(true, 1.9F, "Pink", "Rover")
        )

        bicycleRepo.addBicycles(bicycles, object : BicycleRepo.AddListCallBack {
            override fun onSuccess() {
            }

            override fun onFail(throwable: Throwable) {
            }
        })

    }


    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.listButton -> {
                createBicycleFragment()
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

        if (AppSharedPref().isFirstRun(this) && supportFragmentManager.findFragmentByTag(FirstRunDialog.TAG) == null) {
            FirstRunDialog.newInstance().show(supportFragmentManager, FirstRunDialog.TAG)
        }

        setContentView(R.layout.activity_main)

        initThisActivity()

        DaggerAppComponent.builder()
            .appModule(AppModule(application))
            .roomModule(RoomModule(application))
            .build()
            .inject(this)


        if (savedInstanceState == null) {
            createBicycleFragment()
        }
    }

    private fun createBicycleFragment() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.frame, BicycleListFragment.newInstance(), BicycleListFragment.TAG)
            .commit()
    }

    private fun initThisActivity() {
        setSupportActionBar(toolbar)
        val toggle = ActionBarDrawerToggle(
            this, drawer_layout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close
        )
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()
        nav_view.setNavigationItemSelectedListener(this)
    }
}
