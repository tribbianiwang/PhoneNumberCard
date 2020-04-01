package com.zzy.phonenumbercard.activity

import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.tudaritest.util.OnRvItemClickListener
import com.wl.wanandroid.utils.StringUtils
import com.zzy.phonenumbercard.R
import com.zzy.phonenumbercard.adapter.RvCardListAdapter
import com.zzy.phonenumbercard.bean.CardDetailBean
import com.zzy.phonenumbercard.dialog.CardDetailDialog
import com.zzy.phonenumbercard.utils.AppConstants
import com.zzy.phonenumbercard.utils.CookieUtils
import com.zzy.phonenumbercard.utils.DeviceUtils
import com.zzy.phonenumbercard.utils.LogUtils
import com.zzy.phonenumbercard.viewmodel.CardDetailViewModel
import kotlinx.android.synthetic.main.activity_card_list.*

class CardListActivity : BaseActivity() {

    var city:String = ""
    lateinit var cardDetaiViewModel: CardDetailViewModel
    var cardDetailDialog:CardDetailDialog?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_card_list)
        city = intent.getStringExtra(AppConstants.TRANS_CITY)?:""
        index_toolbar.setNavigationIcon(R.drawable.icon_back)
        index_toolbar.setNavigationOnClickListener {
            finish()
        }
        tv_title.text = city+StringUtils.getString(R.string.string_card_list)
        cardDetaiViewModel = ViewModelProviders.of(this).get(CardDetailViewModel::class.java)

        lifecycle.addObserver(cardDetaiViewModel)

        var cardDetailObserver = Observer<CardDetailBean>{
            LogUtils.d("cName","cname:${it.listMBInfo.size}")
            val listMBInfo = it.listMBInfo
            var cardListAdapter = RvCardListAdapter(listMBInfo)
            rv_card.adapter = cardListAdapter

            cardListAdapter?.onItemClickListener = object :OnRvItemClickListener{
                override fun onItemClick(position: Int) {

                    cardDetailDialog = CardDetailDialog(this@CardListActivity,listMBInfo.get(position))
                    cardDetailDialog?.show()

                }

            }

        }

        cardDetaiViewModel.baseResultLiveData.observe(this,cardDetailObserver)
        cardDetaiViewModel.queryStatusLiveData.observe(this,queryStatusObserver)
        cardDetaiViewModel.errorMsgLiveData.observe(this,errorMsgObserver)

        var loginData = CookieUtils.getLoginData()
        cardDetaiViewModel.getCardDetail(loginData.loginId,loginData.password, DeviceUtils.getUniqueId(CardListActivity@this),city,AppConstants.COMMON_KEY)

    }

    override fun onDestroy() {
        super.onDestroy()
        cardDetailDialog?.cancel()
    }
}
