package GRIP.payment.home.adapter

import android.graphics.Color
import android.support.v4.content.ContextCompat
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_credit_card_cancellable.view.*
import GRIP.payment.R
import GRIP.payment.customview.CreditCardView


/**
 * Created by Priya Sindkar.
 */
class BankAccountsListAdapter : RecyclerView.Adapter<BankAccountsListAdapter.BankAccountsItemViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, p1: Int): BankAccountsItemViewHolder {
        return BankAccountsItemViewHolder(LayoutInflater.from(viewGroup.context).inflate(R.layout.item_bank_accounts, viewGroup, false))
    }

    override fun getItemCount(): Int {
        return 4
    }

    override fun onBindViewHolder(holder: BankAccountsItemViewHolder, position: Int) {
        val cardview = holder.itemView as CreditCardView
        if (position == 0) {
            cardview.constraintMain.background = ContextCompat.getDrawable(holder.itemView.context, R.drawable.amber_min)
            cardview.txtValidThru.setTextColor(ContextCompat.getColor(holder.itemView.context, R.color.colorCreditCardText))
            cardview.txtCardHolderName.setTextColor(ContextCompat.getColor(holder.itemView.context, R.color.colorCreditCardText))
            cardview.txtCardNumber.setTextColor(ContextCompat.getColor(holder.itemView.context, R.color.colorSecondaryAlpha))
            cardview.txtValidity.setTextColor(ContextCompat.getColor(holder.itemView.context, R.color.colorSecondaryAlpha))
        }
        if (position == 1) {
            cardview.constraintMain.background = ContextCompat.getDrawable(holder.itemView.context, R.drawable.blue_min)
            cardview.txtValidThru.setTextColor(ContextCompat.getColor(holder.itemView.context, R.color.colorPrimary))
            cardview.txtCardHolderName.setTextColor(ContextCompat.getColor(holder.itemView.context, R.color.colorPrimary))
            cardview.txtCardNumber.setTextColor(ContextCompat.getColor(holder.itemView.context, R.color.colorPrimary))
            cardview.txtValidity.setTextColor(ContextCompat.getColor(holder.itemView.context, R.color.colorPrimary))
        }
        if (position == 2) {
            cardview.constraintMain.background = ContextCompat.getDrawable(holder.itemView.context, R.drawable.cyan_min)
            cardview.txtValidThru.setTextColor(ContextCompat.getColor(holder.itemView.context, R.color.colorCreditCardText))
            cardview.txtCardHolderName.setTextColor(ContextCompat.getColor(holder.itemView.context, R.color.colorCreditCardText))
            cardview.txtCardNumber.setTextColor(ContextCompat.getColor(holder.itemView.context, R.color.colorSecondaryAlpha))
            cardview.txtValidity.setTextColor(ContextCompat.getColor(holder.itemView.context, R.color.colorSecondaryAlpha))
        }
        if (position == 3) {
            cardview.constraintMain.background = ContextCompat.getDrawable(holder.itemView.context, R.drawable.red_min)
            cardview.txtValidThru.setTextColor(ContextCompat.getColor(holder.itemView.context, R.color.colorPrimary))
            cardview.txtCardHolderName.setTextColor(ContextCompat.getColor(holder.itemView.context, R.color.colorPrimary))
            cardview.txtCardNumber.setTextColor(ContextCompat.getColor(holder.itemView.context, R.color.colorPrimary))
            cardview.txtValidity.setTextColor(ContextCompat.getColor(holder.itemView.context, R.color.colorPrimary))
        }
    }

    class BankAccountsItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}