package GRIP.payment.home

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.view.ViewCompat
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_home.view.*
import GRIP.payment.R
import GRIP.payment.home.adapter.BankAccountsListAdapter
import GRIP.payment.receivemoney.ReceiveMoneyActivity
import GRIP.payment.sendmoney.SendMoneyActivity

/**
 * Created by Priya Sindkar.
 */
class HomeFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        initUI(root)
        return root
    }

    private fun initUI(root: View) {
        ViewCompat.setElevation(root.imgSendMoney, 16f)
        ViewCompat.setElevation(root.imgReceiveMoney, 16f)

        root.imgNotification.setOnClickListener {
            Toast.makeText(activity, "Notification List", Toast.LENGTH_SHORT).show()
        }

        root.cardSendMoney.setOnClickListener {
            startActivity(Intent(activity, SendMoneyActivity::class.java))
        }
        root.cardReceiveMoney.setOnClickListener {
            startActivity(Intent(activity, ReceiveMoneyActivity::class.java))
        }
        root.recyclerBankAccounts.setItemViewCacheSize(0)
        root.recyclerBankAccounts.setHasFixedSize(true)
        root.recyclerBankAccounts.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)

        val bankAccountsAdapter = BankAccountsListAdapter()
        root.recyclerBankAccounts.adapter = bankAccountsAdapter
    }
}