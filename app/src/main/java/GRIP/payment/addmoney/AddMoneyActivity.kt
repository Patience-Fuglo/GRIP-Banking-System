package GRIP.payment.addmoney

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_add_amount.*
import GRIP.payment.R

/**
 * Created by Priya Sindkar.
 */
class AddMoneyActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_amount)

        initUI()
    }

    private fun initUI() {
        imgBack.setOnClickListener {
            super.onBackPressed()
        }
    }
}