package com.personalproject

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import com.example.helloworldapp.Models.User
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.google.gson.Gson
import java.io.BufferedReader
import java.io.InputStreamReader

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun registerButton (view: View) {
        val intent = Intent(this, RegisterActivity::class.java)
        startActivity(intent)
    }

    fun loginButton(view: View) {
        val username = findViewById<EditText>(R.id.username)
        val userField = username.text.toString()
        val password = findViewById<EditText>(R.id.password)
        val passField = password.text.toString()
        val gson = Gson()

        val users:Array<User> = gson.fromJson(ReadJSONFromAssets(baseContext, "users.json")
            , Array<User>::class.java)

        for (user in users) {
            if (passField == user.password && userField == user.username) {
                Toast.makeText(this, "LOGIN SUCCESSFUL", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, HomepageActivity::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this, "LOGIN FAILED", Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun ReadJSONFromAssets(context: Context, path: String): String {
        val identifier = "[ReadJSON]"
        try {
            val file = context.assets.open("$path")
            val bufferedReader = BufferedReader(InputStreamReader(file))
            val stringBuilder = StringBuilder()
            bufferedReader.useLines { lines ->
                lines.forEach {
                    stringBuilder.append(it)
                }
            }
            return stringBuilder.toString()
        } catch (e: Exception) {
            e.printStackTrace()
            return ""
        }
    }

}
