package com.yelinaung.luluaung

//import com.yelinaung.luluaung.repo.RemoteDataRepository
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.yelinaung.luluaung.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var activityMainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        activityMainBinding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        setSupportActionBar(activityMainBinding.toolbar.toolbar)
        supportActionBar!!.title = getString(R.string.app_name)


    }
}
