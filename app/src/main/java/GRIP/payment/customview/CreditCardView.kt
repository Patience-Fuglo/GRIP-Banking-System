package GRIP.payment.customview

import android.content.Context
import android.graphics.drawable.Drawable
import android.support.v7.widget.CardView
import android.util.AttributeSet
import android.util.DisplayMetrics
import android.util.TypedValue
import android.view.View
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.item_credit_card_cancellable.view.*
import GRIP.payment.R


/**
 * Created by Priya Sindkar.
 */
class CreditCardView : CardView {
    var cardViewBackground: Drawable? = null
    lateinit var creditCardLogo: Drawable
    lateinit var cardBalanceValue: String
    lateinit var cardNumber: String
    lateinit var cardValidity: String
    lateinit var cardHolderName: String
    lateinit var cardVisaImage: Drawable
    var isCreditCardForGrid = false

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
                R.styleable.CreditCardView,
                0, 0)
        try {
            cardViewBackground = attributes.getDrawable(R.styleable.CreditCardView_cardViewBackground)
            creditCardLogo = attributes.getDrawable(R.styleable.CreditCardView_creditCardLogo)
            cardBalanceValue = attributes.getString(R.styleable.CreditCardView_cardBalanceValue)
            cardNumber = attributes.getString(R.styleable.CreditCardView_cardNumber)
            cardValidity = attributes.getString(R.styleable.CreditCardView_cardValidity)
            cardHolderName = attributes.getString(R.styleable.CreditCardView_cardHolderName)
            cardVisaImage = attributes.getDrawable(R.styleable.CreditCardView_cardVisaImage)
            isCreditCardForGrid = attributes.getBoolean(R.styleable.CreditCardView_isCreditCardForGrid, true)
        } finally {
            attributes.recycle()
        }
    }

    private fun init() {
        val view = View.inflate(context, R.layout.item_credit_card_cancellable, null)
        addView(view)
        if (cardViewBackground != null) {
            view.constraintMain.background = cardViewBackground
        }
        view.txtBalanceValue.text = cardBalanceValue
        view.txtCardNumber.text = cardNumber
        view.txtCardHolderName.text = cardHolderName
        view.txtValidity.text = cardValidity
        view.imgVisa.setImageDrawable(cardVisaImage)

        if(isCreditCardForGrid) {
            view.btnClose.visibility = View.VISIBLE
        } else {
            view.btnClose.visibility = View.GONE
        }

        if (isCreditCardForGrid) {
            view.txtBalance.setCustomTextSize(10f)
            view.txtBalanceValue.setCustomTextSize(14f)
            view.txtCardNumber.setCustomTextSize(14f)
            view.txtValidThru.setCustomTextSize(10f)
            view.txtValidity.setCustomTextSize(14f)
            view.txtCardHolderName.setCustomTextSize(14f)
        }
    }
}

private fun TextView.setCustomTextSize(size: Float) {
    setTextSize(TypedValue.COMPLEX_UNIT_SP, size)
}

fun View.dpToPx(dp: Int): Int {
    val displayMetrics = context.resources.displayMetrics
    return Math.round(dp * (displayMetrics.xdpi / DisplayMetrics.DENSITY_DEFAULT))
}