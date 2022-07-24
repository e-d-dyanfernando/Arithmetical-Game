// MOBILE APPLICATION DEVELOPMENT
// Assignment 1
// 5COSC023C

// Module Leader : Torin Wirasingha
// Deadline : 22/3/2022, 13:00

// Name : E. D. D. Fernando
// UoW ID : w1839054
// IIT ID : 20200473

// The application developed will be a game which players will be using to practice their arithmetic calculative skills:

package com.example.w1839054_mad_cw_1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.widget.Button
import android.widget.PopupWindow
import androidx.constraintlayout.widget.ConstraintLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bt_about = findViewById<Button>(R.id.about)               // Calling the About button
        val bt_new_game = findViewById<Button>(R.id.new_game)         // Calling the New_Game button

        bt_about.setOnClickListener{
            val inflater = getSystemService(LAYOUT_INFLATER_SERVICE) as LayoutInflater
            val popupView = inflater.inflate(R.layout.activity_about,null)
            val width = ConstraintLayout.LayoutParams.WRAP_CONTENT
            val height = ConstraintLayout.LayoutParams.WRAP_CONTENT
            val focusable = true // lets taps outside the popup also dismiss it
            val popupWindow = PopupWindow(popupView, width, height, focusable)

            popupWindow.showAtLocation(getWindow().getDecorView(), Gravity.CENTER, 0, 0);
            popupView.findViewById<Button>(R.id.bt_close).setOnClickListener{
                popupWindow.dismiss()
            }
        }

        bt_new_game.setOnClickListener{
            val NEW_GAME = Intent(this, Game_Screen::class.java)    // Open the class - New_Game page
            startActivity(NEW_GAME)
        }
    }
}