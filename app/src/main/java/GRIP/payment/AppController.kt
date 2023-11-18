package GRIP.payment

import android.app.Application
import com.facebook.drawee.backends.pipeline.Fresco

/**
 * Created by Priya Sindkar.
 */
class AppController : Application() {
    override fun onCreate() {
        super.onCreate()
        Fresco.initialize(this)
    }
}