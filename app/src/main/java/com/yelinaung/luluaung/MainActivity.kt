package com.yelinaung.luluaung

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.yelinaung.luluaung.databinding.ActivityMainBinding
import retrofit2.Retrofit
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    lateinit var activityMainBinding: ActivityMainBinding

    @Inject lateinit var retrofit: Retrofit

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activityMainBinding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        setSupportActionBar(activityMainBinding.toolbar.toolbar)
        supportActionBar!!.title = getString(R.string.app_name)






    }
}
