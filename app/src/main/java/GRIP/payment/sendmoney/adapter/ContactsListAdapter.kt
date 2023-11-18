package GRIP.payment.sendmoney.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_contacts_list.view.*
import GRIP.payment.R
import GRIP.payment.sendmoney.listener.OnContactSelected


/**
 * Created by Priya Sindkar.
 */
class ContactsListAdapter(var isBankSelected: Boolean, var onContactSelected: OnContactSelected) : RecyclerView.Adapter<ContactsListAdapter.ContactsItemViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, p1: Int): ContactsItemViewHolder {
        return ContactsItemViewHolder(LayoutInflater.from(viewGroup.context).inflate(R.layout.item_contacts_list, viewGroup, false))
    }

    override fun getItemCount(): Int {
        return 6
    }

    override fun onBindViewHolder(holderProfile: ContactsItemViewHolder, position: Int) {
        if (isBankSelected) {
            holderProfile.itemView.txtContactAccountNo.visibility = View.VISIBLE
        } else {
            holderProfile.itemView.txtContactAccountNo.visibility = View.GONE
        }
        holderProfile.itemView.setOnClickListener {
            onContactSelected.onContactSelected()
        }
    }

    class ContactsItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}