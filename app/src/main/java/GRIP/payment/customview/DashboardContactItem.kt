package GRIP.payment.customview

import android.content.Context
import android.graphics.drawable.Drawable
import android.support.constraint.ConstraintLayout
import android.util.AttributeSet
import android.util.TypedValue
import android.view.View
import android.widget.TextView
import kotlinx.android.synthetic.main.item_contact_dashboard.view.*
import GRIP.payment.R

/**
 * Created by Priya Sindkar.
 */
class DashboardContactItem : ConstraintLayout {
    var contactImage: Drawable? = null
    lateinit var contactName: String
    var hasBackgroundRing = false
    var textSize = 14

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
                R.styleable.DashboardContactItem,
                0, 0)
        try {
            contactImage = attributes.getDrawable(R.styleable.DashboardContactItem_contactImage)
            contactName = attributes.getString(R.styleable.DashboardContactItem_contactName)
            hasBackgroundRing = attributes.getBoolean(R.styleable.DashboardContactItem_hasBackgroundRing, false)
            textSize = attributes.getInteger(R.styleable.DashboardContactItem_hasBackgroundRing, 14)
        } finally {
            attributes.recycle()
        }
    }

    private fun init() {
        val view = View.inflate(context, R.layout.item_contact_dashboard, null)
        addView(view)
        if (contactImage != null) {
            view.imgContact.setImageDrawable(contactImage)
            if (hasBackgroundRing) {
                view.imgContact.setBackgroundResource(R.drawable.add_circle_icon)
            }
        }
        view.txtContactName.text = contactName
        view.txtContactName.setCustomTextSize(textSize.toFloat())
    }

    private fun TextView.setCustomTextSize(size: Float) {
        setTextSize(TypedValue.COMPLEX_UNIT_SP, size)
    }
}