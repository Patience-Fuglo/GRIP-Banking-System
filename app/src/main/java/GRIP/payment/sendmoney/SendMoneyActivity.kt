package GRIP.payment.sendmoney

import android.content.Intent
import android.graphics.PorterDuff
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_send_money.*
import GRIP.payment.R
import GRIP.payment.addmoney.AddMoneyActivity
import GRIP.payment.sendmoney.adapter.ContactsListAdapter
import GRIP.payment.sendmoney.listener.OnContactSelected

/**
 * Created by Priya Sindkar.
 */
class SendMoneyActivity : AppCompatActivity(), OnContactSelected {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_send_money)
        initUI()
    }

    private fun initUI() {
        initTabs()

        imgBack.setOnClickListener {
            super.onBackPressed()
        }

        recyclerContacts.setItemViewCacheSize(0)
        recyclerContacts.setHasFixedSize(true)
        recyclerContacts.layoutManager = LinearLayoutManager(this)
        val contactsListAdapter = ContactsListAdapter(false, this) // default selection is phone
        recyclerContacts.adapter = contactsListAdapter

        optionsTab.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabReselected(p0: TabLayout.Tab?) {}

            override fun onTabUnselected(p0: TabLayout.Tab?) {}

            override fun onTabSelected(tab: TabLayout.Tab?) {
                if (tab != null) {
                    (tab.customView as TextView).setSelectedTabStyle()
                    if (tab.position == 0) {
                        btnAddBeneficiary.visibility = View.GONE
                        (optionsTab.getTabAt(1)?.customView as TextView)
                    } else {
                        btnAddBeneficiary.visibility = View.VISIBLE
                        (optionsTab.getTabAt(0)?.customView as TextView)
                    }.setUnSelectedTabStyle()
                    refreshContactList(tab.position == 1)
                }
            }
        })
    }

    private fun refreshContactList(isBankSelected: Boolean) {
        val contactsListAdapter = ContactsListAdapter(isBankSelected, this@SendMoneyActivity)
        recyclerContacts.adapter = contactsListAdapter
    }


    override fun onContactSelected() {
        startActivity(Intent(this, AddMoneyActivity::class.java))
    }

    private fun initTabs() {
        val tab1 = optionsTab.newTab()
        val tab1View = LayoutInflater.from(this).inflate(R.layout.item_tab_view, null)
        var view = (tab1View as TextView)
        view.setCompoundDrawablesWithIntrinsicBounds(ContextCompat.getDrawable(this, R.drawable.ic_phonebook), null, null, null)
        view.setSelectedTabStyle()
        tab1.customView = tab1View
        optionsTab.addTab(tab1)

        val tab2 = optionsTab.newTab()
        val tab2View = LayoutInflater.from(this).inflate(R.layout.item_tab_view, null)
        view = (tab2View as TextView)
        view.setText(R.string.label_bank_accounts)
        view.setCompoundDrawablesWithIntrinsicBounds(ContextCompat.getDrawable(this, R.drawable.ic_bank_icon), null, null, null)
        view.setUnSelectedTabStyle()
        tab2.customView = tab2View
        optionsTab.addTab(tab2)
    }

    fun TextView.setSelectedTabStyle() {
        setTextColor(ContextCompat.getColor(this@SendMoneyActivity, R.color.colorPrimary))
        compoundDrawables[0].setColorFilter(ContextCompat.getColor(this@SendMoneyActivity, R.color.colorPrimary), PorterDuff.Mode.SRC_ATOP)
    }

    fun TextView.setUnSelectedTabStyle() {
        setTextColor(ContextCompat.getColor(this@SendMoneyActivity, R.color.colorTertiary))
        compoundDrawables[0].setColorFilter(ContextCompat.getColor(this@SendMoneyActivity, R.color.colorTertiary), PorterDuff.Mode.SRC_ATOP)
    }
}