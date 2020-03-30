package com.zzy.phonenumbercard

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.tencent.mmkv.MMKV
import com.zzy.phonenumbercard.activity.BaseActivity
import com.zzy.phonenumbercard.activity.LoginActivity
import com.zzy.phonenumbercard.activity.MainActivity
import com.zzy.phonenumbercard.utils.*
import kotlinx.android.synthetic.main.activity_splash.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        ImmerBarUtils.initImmerBar(this,R.color.DarkGray)

        LogUtils.d("uniqueId--","imei${DeviceUtils.getUniqueId(this)}")
//        startAnim()

        GlobalScope.launch(Dispatchers.Main) {
            delay(1000L)
             var isLogin = MMKV.defaultMMKV().decodeBool(AppConstants.KEY_IS_LOGIN,false)
            var intent = Intent(this@SplashActivity, if(CookieUtils.getIsLogin())MainActivity::class.java else LoginActivity::class.java)
            startActivity(intent)
            finish()

        }

    }

    private fun startAnim() {
        val anim1 = ObjectAnimator.ofFloat(iv_splash, "scaleX", 0.4f, 1.0f)
        anim1.repeatCount = -1
        val anim2 = ObjectAnimator.ofFloat(iv_splash, "scaleY", 0.4f, 1.0f)
        anim2.repeatCount = -1
        val set = AnimatorSet()
        set.play(anim1).with(anim2)
        set.duration = 1000
        set.start()


    }
}
