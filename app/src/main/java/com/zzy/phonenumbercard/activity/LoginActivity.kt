package com.zzy.phonenumbercard.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.wl.wanandroid.utils.StringUtils
import com.wl.wanandroid.utils.T
import com.zzy.phonenumbercard.R
import com.zzy.phonenumbercard.bean.LoginBean
import com.zzy.phonenumbercard.utils.AppConstants
import com.zzy.phonenumbercard.utils.DeviceUtils
import com.zzy.phonenumbercard.viewmodel.LoginViewModel
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : BaseActivity() {

    lateinit var loginViewModel:LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        loginViewModel = ViewModelProviders.of(this).get(LoginViewModel::class.java)

        lifecycle.addObserver(loginViewModel)

        var loginObserver = Observer<LoginBean>{
            T.showShort(LoginActivity@this,StringUtils.getString(R.string.login_success))
        }

        loginViewModel.baseResultLiveData.observe(this,loginObserver)
        loginViewModel.queryStatusLiveData.observe(this,queryStatusObserver)
        loginViewModel.errorMsgLiveData.observe(this,errorMsgObserver)


        bt_login.setOnClickListener {
            if(TextUtils.isEmpty(et_username.text.toString())){
                et_username.setError(StringUtils.getString(R.string.string_username_empty))

            }else  if(TextUtils.isEmpty(et_password.text.toString())){
                et_password.setError(StringUtils.getString(R.string.string_password_empty))
            }else{
                loginViewModel.startLogin(et_username.text.toString(),et_password.text.toString(),DeviceUtils.getUniqueId(LoginActivity@this),AppConstants.COMMON_KEY)
            }

        }
    }
}
