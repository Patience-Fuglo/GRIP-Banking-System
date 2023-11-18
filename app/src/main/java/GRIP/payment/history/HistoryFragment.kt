package GRIP.payment.history

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_history.view.*
import GRIP.payment.BaseFragment
import GRIP.payment.R
import GRIP.payment.customview.CategorySelectorDialog
import GRIP.payment.customview.MonthSelectorDialog
import GRIP.payment.customview.listeners.OnCategorySelectedListener
import GRIP.payment.customview.listeners.OnMonthSelectedListener
import GRIP.payment.history.adapter.HistoryListAdapter
import GRIP.payment.history.model.HistoryModel


/**
 * Created by Priya Sindkar.
 */
class HistoryFragment : BaseFragment(), OnMonthSelectedListener, OnCategorySelectedListener {

    lateinit var root: View
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        root = inflater.inflate(R.layout.fragment_history, container, false)
        initUI()
        return root
    }

    private fun initUI() {
        root.monthSpinner.setOnClickListener {
            MonthSelectorDialog(activity!!, this).show()
        }

        root.categoriesSpinner.setOnClickListener {
            CategorySelectorDialog(activity!!, this).show()
        }


        val historyItems = ArrayList<HistoryModel>()
        historyItems.add(HistoryModel("Paid to", "Emily", "999.0", 1,"08 May 2018","Send Money"))
        historyItems.add(HistoryModel("Electricity bill paid", "Fantasy Lights", "830.0", 2,"10 Jun 2018","Electricity"))
        historyItems.add(HistoryModel("Mobile Recharged", "Vodafone Postpaid", "399.0", 2,"10 Jun 2018","Mobile"))
        historyItems.add(HistoryModel("Received from", "Salina", "1000.0", 1,"22 Jun 2018","Receive Money"))
        historyItems.add(HistoryModel("Gas Bill Paid", "Hp Gas Services", "789.0", 1,"01 Jul 2018","Gas"))

        root.recyclerHistory.setItemViewCacheSize(0)
        root.recyclerHistory.setHasFixedSize(true)
        root.recyclerHistory.layoutManager = LinearLayoutManager(activity)

        val historyAdapter = HistoryListAdapter(historyItems)
        root.recyclerHistory.adapter = historyAdapter

    }

    override fun onMonthSelected(monthNumber: String) {
        root.monthSpinner.text = monthNumber
        Toast.makeText(activity, "$monthNumber selected", Toast.LENGTH_SHORT).show()
    }

    override fun onCategorySelected(categoryName: String) {
        root.categoriesSpinner.text = categoryName
        Toast.makeText(activity, "$categoryName selected", Toast.LENGTH_SHORT).show()
    }
}