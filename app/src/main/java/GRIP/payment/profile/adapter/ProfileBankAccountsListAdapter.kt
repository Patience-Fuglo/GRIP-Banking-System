package GRIP.payment.profile.adapter

import android.support.v4.content.ContextCompat
import android.support.v4.view.ViewCompat
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.item_credit_card_cancellable.view.*
import kotlinx.android.synthetic.main.item_profile_bank_accounts.view.*
import GRIP.payment.R
import GRIP.payment.customview.CreditCardView


/**
 * Created by Priya Sindkar.
 */
class ProfileBankAccountsListAdapter : RecyclerView.Adapter<ProfileBankAccountsListAdapter.ProfileBankAccountsItemViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, p1: Int): ProfileBankAccountsItemViewHolder {
        return ProfileBankAccountsItemViewHolder(LayoutInflater.from(viewGroup.context).inflate(R.layout.item_profile_bank_accounts, viewGroup, false))
    }

    override fun getItemCount(): Int {
        return 4
    }

    override fun onBindViewHolder(holder: ProfileBankAccountsItemViewHolder, position: Int) {
        ViewCompat.setElevation(holder.itemView.btnClose, 8f)
//        holder.itemView.btnClose.setOnTouchListener { _, p1 ->
//            if (p1?.action == MotionEvent.ACTION_DOWN) {
//                ViewCompat.setElevation(holder.itemView.btnClose, 64f)
//            } else {
//                ViewCompat.setElevation(holder.itemView.btnClose, 8f)
//            }
//            true
//        }
        val cardview = holder.itemView.creditCardView as CreditCardView
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

        holder.itemView.btnClose.setOnClickListener {
            Toast.makeText(holder.itemView.context, "Delete Account", Toast.LENGTH_SHORT).show()
        }
    }

    class ProfileBankAccountsItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}