package GRIP.payment

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import GRIP.payment.history.HistoryFragment
import GRIP.payment.home.HomeFragment
import GRIP.payment.profile.ProfileFragment
import GRIP.payment.settings.SettingsFragment

class MainActivity : AppCompatActivity() {
    var selectedFragment: Fragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        navigation.itemIconTintList = null
        inflateFragment(HomeFragment())
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }

    override fun onBackPressed() {
        if (selectedFragment is HomeFragment) {
            super.onBackPressed()
        } else {
            navigation.selectedItemId = R.id.navigation_home
            inflateFragment(HomeFragment())
        }
    }

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                inflateFragment(HomeFragment())
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_history -> {
                inflateFragment(HistoryFragment())
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_profile -> {
                inflateFragment(ProfileFragment())
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_settings -> {
                inflateFragment(SettingsFragment())
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    private fun inflateFragment(fragment: Fragment) {
        selectedFragment = fragment
        supportFragmentManager.beginTransaction().replace(R.id.frame_content, fragment)/*.addToBackStack(null)*/.commit()
    }
}
