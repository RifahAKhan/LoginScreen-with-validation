package com.example.anim_splash_screen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Patterns
import android.view.View
import android.view.View.OnClickListener
import android.widget.Toast
import com.example.anim_splash_screen.databinding.ActivityMainBinding
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity(){

    private lateinit var binding: ActivityMainBinding
    lateinit var loginButton: MaterialButton
    lateinit var email: TextInputEditText
    lateinit var password: TextInputEditText
    lateinit var phone: TextInputEditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        emailFocusListener()
        passwordFocusListener()
        phoneFocusListener()

        email= findViewById(R.id.emailEditText)
        password=findViewById(R.id.passwordEditText)
        phone = findViewById(R.id.phoneEditText)
        loginButton=findViewById(R.id.loginButton)


        loginButton.setOnClickListener(object : OnClickListener {
            override fun onClick(p0: View?) {
                var emailInput = email.getText().toString()
                var passwordInput = password.getText().toString()
                var phoneInput = phone.getText().toString()
                if(!emailInput.isEmpty() && !passwordInput.isEmpty() && !phoneInput.isEmpty()){
                    startActivity(Intent(this@MainActivity,LoginScreen::class.java))
                }
                else{
                    Toast.makeText(applicationContext,"Please don't leave any fields empty",Toast.LENGTH_LONG).show()
                }
            }

        })

    }


    private fun emailFocusListener() {
       binding.emailEditText.setOnFocusChangeListener { _, focused ->
           if(!focused){
               binding.emailContainer.helperText = validEmail()
           }
       }
    }

    private fun validEmail(): String? {
        val emailText = binding.emailEditText.text.toString()
        if(!Patterns.EMAIL_ADDRESS.matcher(emailText).matches()){
            return "Invalid Email Address"
        }
        return null
    }

    private fun passwordFocusListener() {
        binding.passwordEditText.setOnFocusChangeListener { _, focused ->
            if(!focused){
                binding.passwordContainer.helperText = validPassword()
            }
        }
    }

    private fun validPassword(): String? {
        val passwordText = binding.passwordEditText.text.toString()
        if(passwordText.length < 10){
            return "Minimum 10 Character Password"
        }
        if(!passwordText.matches(".*[A-Z].*".toRegex())){
            return "Must Contain 1 Upper-case Character"
        }
        if(!passwordText.matches(".*[a-z].*".toRegex())){
            return "Must Contain 1 Lower-case Character"
        }
        if(!passwordText.matches(".*[@#\$^&+=].*".toRegex())){
            return "Must Contain 1 Special Character(@#\$^&+=)"
        }
        return null
    }

    private fun phoneFocusListener() {
        binding.phoneEditText.setOnFocusChangeListener { _, focused ->
            if(!focused){
                binding.phoneContainer.helperText = validPhone()
            }
        }
    }

    private fun validPhone(): String? {
        val phoneText = binding.phoneEditText.text.toString()
        if(!phoneText.matches(".*[0-9].*".toRegex())){
            return "Must be all Digits"
        }
        if(phoneText.length != 10){
            return "Must be 10 Digits"
        }
        return null
    }


    fun callLoginScreen(view: View) {
        startActivity(Intent(this@MainActivity,LoginScreen::class.java))

    }

    fun callCreateAccountScreen(view: View) {
        startActivity(Intent(this@MainActivity,CreateAccountScreen::class.java))

    }




}