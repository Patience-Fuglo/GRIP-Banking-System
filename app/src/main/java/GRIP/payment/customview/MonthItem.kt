package GRIP.payment.customview

import android.content.Context
import android.support.constraint.ConstraintLayout
import android.util.AttributeSet
import android.util.TypedValue
import android.view.View
import android.widget.TextView
import kotlinx.android.synthetic.main.item_month.view.*
import GRIP.payment.R

/**
 * Created by Priya Sindkar.
 */
class MonthItem : ConstraintLayout {
    lateinit var monthNumber: String

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        getAttributes(attrs)
        init()
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        getAttributes(attrs)
        init()
    }

    private fun getAttributes(attrs: AttributeSet) {
        val attributes = context.theme.obtainStyledAttributes(
                attrs,
                R.styleable.MonthItem,
                0, 0)
        try {
            monthNumber = attributes.getString(R.styleable.MonthItem_monthNumber)
        } finally {
            attributes.recycle()
        }
    }

    private fun init() {
        val view = View.inflate(context, R.layout.item_month, null)
        addView(view)
        view.txtMonthNumber.text = monthNumber

        when (monthNumber) {
            "1" -> {
                view.txtMonthName.text = "Jan"
            }
            "2" -> {
                view.txtMonthName.text = "Feb"
            }
            "3" -> {
                view.txtMonthName.text = "Mar"
            }
            "4" -> {
                view.txtMonthName.text = "Apr"
            }
            "5" -> {
                view.txtMonthName.text = "May"
            }
            "6" -> {
                view.txtMonthName.text = "Jun"
            }
            "7" -> {
                view.txtMonthName.text = "Jul"
            }
            "8" -> {
                view.txtMonthName.text = "Aug"
            }
            "9" -> {
                view.txtMonthName.text = "Sept"
            }
            "10" -> {
                view.txtMonthName.text = "Oct"
            }
            "11" -> {
                view.txtMonthName.text = "Nov"
            }
            "12" -> {
                view.txtMonthName.text = "Dec"
            }
        }
    }

    private fun TextView.setCustomTextSize(size: Float) {
        setTextSize(TypedValue.COMPLEX_UNIT_SP, size)
    }
}