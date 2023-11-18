package GRIP.payment.receivemoney

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_receive_money.*
import GRIP.payment.R
import GRIP.payment.addmoney.AddMoneyActivity
import GRIP.payment.sendmoney.adapter.ContactsListAdapter
import GRIP.payment.sendmoney.listener.OnContactSelected

/**
 * Created by Priya Sindkar.
 */
class ReceiveMoneyActivity : AppCompatActivity(), OnContactSelected {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_receive_money)
        initUI()
    }

    private fun initUI() {
        imgBack.setOnClickListener {
            super.onBackPressed()
        }

        recyclerContacts.setItemViewCacheSize(0)
        recyclerContacts.setHasFixedSize(true)
        recyclerContacts.layoutManager = LinearLayoutManager(this)
        val contactsListAdapter = ContactsListAdapter(false, this) // default selection is phone
        recyclerContacts.adapter = contactsListAdapter
    }


    override fun onContactSelected() {
        startActivity(Intent(this, AddMoneyActivity::class.java))
    }
}