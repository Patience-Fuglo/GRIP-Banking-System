package GRIP.payment.customview

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.Window
import kotlinx.android.synthetic.main.dialog_month_selector.*
import kotlinx.android.synthetic.main.item_month.view.*
import GRIP.payment.R
import GRIP.payment.customview.listeners.OnMonthSelectedListener

/**
 * Created by Priya Sindkar.
 */
class MonthSelectorDialog (mContext : Context, var onMonthSelectedListener: OnMonthSelectedListener) : Dialog(mContext), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.dialog_month_selector)
        itemJan.setOnClickListener(this)
        itemFeb.setOnClickListener(this)
        itemMar.setOnClickListener(this)
        itemApril.setOnClickListener(this)
        itemMap.setOnClickListener(this)
        itemJune.setOnClickListener(this)
        itemJuly.setOnClickListener(this)
        itemAug.setOnClickListener(this)
        itemSept.setOnClickListener(this)
        itemOct.setOnClickListener(this)
        itemNov.setOnClickListener(this)
        itemDec.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        onMonthSelectedListener.onMonthSelected(view!!.txtMonthName.text.toString())
        dismiss()
//        when (view?.id) {
//            R.id.itemJan -> {
//                onMonthSelectedListener.onMonthSelected(view.txtMonthNumber)
////                onMonthSelectedListener.onMonthSelected(1)
//            }
//            R.id.itemFeb -> {
//                onMonthSelectedListener.onMonthSelected(2)
//            }
//            R.id.itemMar -> {
//                onMonthSelectedListener.onMonthSelected(3)
//            }
//            R.id.itemApril -> {
//                onMonthSelectedListener.onMonthSelected(4)
//            }
//            R.id.itemMap -> {
//                onMonthSelectedListener.onMonthSelected(5)
//            }
//            R.id.itemJune-> {
//                onMonthSelectedListener.onMonthSelected(6)
//            }
//            R.id.itemJuly -> {
//                onMonthSelectedListener.onMonthSelected(7)
//            }
//            R.id.itemAug-> {
//                onMonthSelectedListener.onMonthSelected(8)
//            }
//            R.id.itemSept -> {
//                onMonthSelectedListener.onMonthSelected(9)
//            }
//            R.id.itemOct -> {
//                onMonthSelectedListener.onMonthSelected(10)
//            }
//            R.id.itemNov -> {
//                onMonthSelectedListener.onMonthSelected(11)
//            }
//            R.id.itemDec -> {
//                onMonthSelectedListener.onMonthSelected(12)
//            }
//        }
    }
}