package GRIP.payment.history.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.item_spinner_prompt.view.*
import GRIP.payment.R

/**
 * Created by Priya Sindkar.
 */
class CustomSpinnerAdapter(mContext: Context?, var resource: Int, var objects: MutableList<String>?) : ArrayAdapter<String>(mContext, resource, objects) {
    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup?): View {
        return getCustomView(position, convertView, parent)
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        return getCustomView(position, convertView, parent)
    }

    private fun getCustomView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view = LayoutInflater.from(context).inflate(R.layout.item_spinner_prompt, parent, false)
        view.txtItemName.text = objects!![position]
        return view
    }
}
