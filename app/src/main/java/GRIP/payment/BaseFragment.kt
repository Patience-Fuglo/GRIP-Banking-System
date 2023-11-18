package GRIP.payment

import android.support.v4.app.Fragment
import GRIP.payment.home.HomeFragment

/**
 * Created by Priya Sindkar.
 */
open class BaseFragment : Fragment() {

    fun goBack() {
        inflateFragment(HomeFragment())
    }

    private fun inflateFragment(fragment: Fragment) {
        fragmentManager!!.beginTransaction().replace(R.id.frame_content, fragment).commit()
    }
}