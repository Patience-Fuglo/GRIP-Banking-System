package GRIP.payment.customview

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.Window
import kotlinx.android.synthetic.main.dialog_category_selector.*
import GRIP.payment.R
import GRIP.payment.customview.listeners.OnCategorySelectedListener
import GRIP.payment.customview.listeners.OnMonthSelectedListener

/**
 * Created by Priya Sindkar.
 */
class CategorySelectorDialog (mContext : Context, var onCategorySelectedListener: OnCategorySelectedListener) : Dialog(mContext), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        setContentView(R.layout.dialog_category_selector)
        txtMobileUtility.setOnClickListener(this)
        txtElectricityUtility.setOnClickListener(this)
        txtBroadbandUtility.setOnClickListener(this)
        txtGasUtility.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        dismiss()
        when (view?.id) {
            R.id.txtMobileUtility -> {
                onCategorySelectedListener.onCategorySelected("Mobile")
            }
            R.id.txtElectricityUtility -> {
                onCategorySelectedListener.onCategorySelected("Electricity")
            }
            R.id.txtBroadbandUtility -> {
                onCategorySelectedListener.onCategorySelected("Broadband")
            }
            R.id.txtGasUtility -> {
                onCategorySelectedListener.onCategorySelected("Gas Bill")
            }
        }
    }
}