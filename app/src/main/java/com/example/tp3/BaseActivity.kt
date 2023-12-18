package com.example.tp3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.app.Activity
import android.app.Dialog
import android.widget.Toast
import com.example.tp3.R

open class BaseActivity : AppCompatActivity() {
    private lateinit var pb:Dialog
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base)
    }

    fun showProgressBar()
    {
        pb = Dialog(this)
        pb.setContentView(R.layout.progress_bar)
        pb.setCancelable(false)
        pb.show()
    }

    fun hideProgressBar()
    {
        pb.dismiss()
    }

    fun showToast(activity: Activity, msg:String)
    {
        Toast.makeText(activity,msg, Toast.LENGTH_SHORT).show()
    }
}