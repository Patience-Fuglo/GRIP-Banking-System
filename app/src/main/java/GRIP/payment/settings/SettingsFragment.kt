package GRIP.payment.settings

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_settings.view.*
import GRIP.payment.BaseFragment
import GRIP.payment.R

/**
 * Created by Priya Sindkar.
 */
class SettingsFragment : BaseFragment() {
    lateinit var root: View

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        root = inflater.inflate(R.layout.fragment_settings, container, false)
        initUI()

        return root
    }

    private fun initUI() {
    }
}