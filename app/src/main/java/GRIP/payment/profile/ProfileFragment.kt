package GRIP.payment.profile

import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_profile.view.*
import GRIP.payment.BaseFragment
import GRIP.payment.R
import GRIP.payment.profile.adapter.ProfileBankAccountsListAdapter

/**
 * Created by Priya Sindkar.
 */
class ProfileFragment : BaseFragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        val root = inflater.inflate(R.layout.fragment_profile, container, false)
        initUI(root)
        return root
    }

    private fun initUI(root: View) {

        root.recyclerBankAccounts.setItemViewCacheSize(0)
        root.recyclerBankAccounts.setHasFixedSize(true)
        root.recyclerBankAccounts.layoutManager = GridLayoutManager(activity, 1)

        val bankAccountsAdapter = ProfileBankAccountsListAdapter()
        root.recyclerBankAccounts.adapter = bankAccountsAdapter
    }
}