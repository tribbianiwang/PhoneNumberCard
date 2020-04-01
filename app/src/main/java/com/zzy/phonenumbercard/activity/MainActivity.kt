package com.zzy.phonenumbercard.activity

import android.content.Intent
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.tudaritest.util.OnRvItemClickListener
import com.wl.wanandroid.adapter.RvCityAdapter
import com.wl.wanandroid.adapter.RvProvinceAdapter
import com.zzy.phonenumbercard.R
import com.zzy.phonenumbercard.bean.CardDetailBean
import com.zzy.phonenumbercard.bean.CityBean
import com.zzy.phonenumbercard.utils.AppConstants
import com.zzy.phonenumbercard.utils.AppConstants.TRANS_CITY
import com.zzy.phonenumbercard.utils.CookieUtils
import com.zzy.phonenumbercard.utils.DeviceUtils
import com.zzy.phonenumbercard.utils.LogUtils
import com.zzy.phonenumbercard.viewmodel.CardDetailViewModel
import com.zzy.phonenumbercard.viewmodel.GetCitysViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity() {
    lateinit var getCityViewModel:GetCitysViewModel

    var cityBean:CityBean?=null
    var rvProvinceAdapter:RvProvinceAdapter?=null
    var rvCityAdapter:RvCityAdapter?=null
    var cityDatas:ArrayList<String> = ArrayList()

    

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        rv_province.layoutManager = LinearLayoutManager(this)
        rv_city.layoutManager = GridLayoutManager(this,2)

        getCityViewModel = ViewModelProviders.of(this).get(GetCitysViewModel::class.java)


        lifecycle.addObserver(getCityViewModel)




        var cityBeansObserver = Observer<CityBean>{

            cityBean = it

            setAdapter()

        }



        getCityViewModel.baseResultLiveData.observe(this,cityBeansObserver)
        getCityViewModel.queryStatusLiveData.observe(this,queryStatusObserver)
        getCityViewModel.errorMsgLiveData.observe(this,errorMsgObserver)



        getCityViewModel.getCityList(AppConstants.COMMON_KEY)

    }

    private fun setAdapter() {
        showProgress(this)
        rvProvinceAdapter = cityBean?.let { RvProvinceAdapter(it) }

        rv_province.adapter = rvProvinceAdapter
        rvProvinceAdapter?.selectedPosition = 0
        rvProvinceAdapter?.notifyDataSetChanged()
        if(cityBean?.listC_City!=null&&cityBean?.listC_City?.size?:0 >0){
            cityDatas.addAll(cityBean?.listC_City?.get(0)?.listCity as ArrayList<String>)
            rvCityAdapter = RvCityAdapter(cityDatas)
            rv_city.adapter = rvCityAdapter

            rvCityAdapter?.onRvItemClickListener = object : OnRvItemClickListener {
                override fun onItemClick(position: Int) {
                    LogUtils.d("点击了","cityBean${cityDatas.get(position)}")
                    var intent = Intent(this@MainActivity,CardListActivity::class.java)
                    intent.putExtra(TRANS_CITY,cityDatas.get(position))
                    startActivity(intent)



                }

            }

        }

        rvProvinceAdapter?.rvItemClickListener = object:OnRvItemClickListener{
            override fun onItemClick(position: Int) {
                cityDatas.clear()

                cityDatas.addAll(cityBean?.listC_City?.get(position)?.listCity as ArrayList<String>)
                rvCityAdapter?.notifyDataSetChanged()
            }

        }

        hideProgress()
    }
}
