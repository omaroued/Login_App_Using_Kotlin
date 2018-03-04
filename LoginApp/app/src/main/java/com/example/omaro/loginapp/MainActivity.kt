package com.example.omaro.loginapp

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        var thread=object: Thread(){

            override fun run() {
                try {
                    Thread.sleep(1*1000)
                    var intent= Intent(baseContext,Login::class.java)
                    startActivity(intent)
                }catch (ex:Exception){
                    Toast.makeText(baseContext,"Error",Toast.LENGTH_LONG).show()
                }

            }
        }
        thread.start()

    }
}
