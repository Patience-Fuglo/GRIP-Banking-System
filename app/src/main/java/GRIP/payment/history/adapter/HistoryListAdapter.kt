package GRIP.payment.history.adapter

import android.support.v4.content.ContextCompat
import android.support.v4.view.ViewCompat
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_history.view.*
import GRIP.payment.R
import GRIP.payment.history.model.HistoryModel


/**
 * Created by Priya Sindkar.
 */
class HistoryListAdapter(var historyItems : ArrayList<HistoryModel>) : RecyclerView.Adapter<HistoryListAdapter.HistoryItemViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, p1: Int): HistoryItemViewHolder {
        return HistoryItemViewHolder(LayoutInflater.from(viewGroup.context).inflate(R.layout.item_history, viewGroup, false))
    }

    override fun getItemCount(): Int {
        return historyItems.size
    }

    override fun onBindViewHolder(holder: HistoryItemViewHolder, position: Int) {
        val item = historyItems[position]
        val context = holder.itemView.context

        holder.itemView.txtTransactionType.text = item.title
        holder.itemView.txtTransactionFor.text = item.contactName
        holder.itemView.txtTransactionAmount.text = "${context.getString(R.string.rupee)} ${item.amount}"

        when (item.transactionType) {
            "Send Money" -> {
                ViewCompat.setElevation(holder.itemView.imgTransactionSymbol, 16f)
                holder.itemView.imgTransactionSymbol.background = ContextCompat.getDrawable(context, R.drawable.send_money_icon)
                holder.itemView.imgTransactionSymbol.setImageResource(R.drawable.ic_arrow_forward)

                holder.itemView.txtTransactionDescription.text = "Debited from\non ${item.transactionDate}"

            }
            "Electricity" -> {
                ViewCompat.setElevation(holder.itemView.imgTransactionSymbol, 0f)
                holder.itemView.imgTransactionSymbol.background = null
                holder.itemView.imgTransactionSymbol.setImageResource(R.drawable.ic_utility_electricity)
                holder.itemView.txtTransactionDescription.text = "Debited from\non ${item.transactionDate}"

            }
            "Mobile" -> {
                ViewCompat.setElevation(holder.itemView.imgTransactionSymbol, 0f)
                holder.itemView.imgTransactionSymbol.background = null
                holder.itemView.imgTransactionSymbol.setImageResource(R.drawable.ic_utility_phone)
                holder.itemView.txtTransactionDescription.text = "Debited from\non ${item.transactionDate}"

            }
            "Receive Money" -> {
                ViewCompat.setElevation(holder.itemView.imgTransactionSymbol, 16f)
                holder.itemView.imgTransactionSymbol.background = ContextCompat.getDrawable(context, R.drawable.receive_money_icon)
                holder.itemView.imgTransactionSymbol.setImageResource(R.drawable.ic_arrow_back)
                holder.itemView.txtTransactionDescription.text = "Credited to\non ${item.transactionDate}"

            }
            "Gas" -> {
                ViewCompat.setElevation(holder.itemView.imgTransactionSymbol, 0f)
                holder.itemView.imgTransactionSymbol.background = null
                holder.itemView.imgTransactionSymbol.setImageResource(R.drawable.ic_utility_gas)
                holder.itemView.txtTransactionDescription.text = "Debited from\non ${item.transactionDate}"
            }
        }
        if ( item.creditCardNumber == 1) {
            holder.itemView.imgCardLogo.setImageDrawable(ContextCompat.getDrawable(holder.itemView.context, R.drawable.ic_bank_logo_1))
        } else {
            holder.itemView.imgCardLogo.setImageDrawable(ContextCompat.getDrawable(holder.itemView.context, R.drawable.ic_bank_logo_2))
        }

    }

    class HistoryItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
}