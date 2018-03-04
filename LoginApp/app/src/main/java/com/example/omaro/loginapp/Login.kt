package com.example.omaro.loginapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AbsListView
import com.google.firebase.auth.FirebaseAuth
import android.widget.Toast

import kotlinx.android.synthetic.main.activity_login.*




class Login : AppCompatActivity() {
     var mAuth:FirebaseAuth?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        mAuth=FirebaseAuth.getInstance()

        var email=etEmail.text.toString()
        var password=etPass.text.toString()

    }

    fun buNext(view:View){
        var email=etEmail.text.toString()
        var password=etPass.text.toString()

        try {
            mAuth!!.createUserWithEmailAndPassword(email, password)
                    .addOnCompleteListener(this) { task ->
                        if (task.isSuccessful) {

                            Toast.makeText(this, "Welcome",
                                    Toast.LENGTH_SHORT).show()

                            var intent=Intent(this,Home::class.java)
                            startActivity(intent)
                        } else {
                            mAuth!!.signInWithEmailAndPassword(email, password)
                                    .addOnCompleteListener(this) { task ->
                                        if (task.isSuccessful) {

                                            Toast.makeText(this, "Welcome",
                                                    Toast.LENGTH_SHORT).show()

                                            var intent=Intent(this,Home::class.java)
                                            startActivity(intent)
                                        } else {
                                            // If sign in fails, display a message to the user.
                                            Toast.makeText(this, "Authentication failed.",
                                                    Toast.LENGTH_SHORT).show()

                                        }

                                    }


                        }

                    }
        }catch (ex:Exception){
            Toast.makeText(this, "Check your Inputs",
                    Toast.LENGTH_SHORT).show()

        }








        }






    }

