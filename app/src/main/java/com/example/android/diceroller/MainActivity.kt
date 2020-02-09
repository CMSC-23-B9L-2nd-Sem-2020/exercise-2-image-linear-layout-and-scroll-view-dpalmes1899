/*
 * Copyright (C) 2018 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.android.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

/**
 * DiceRoller demonstrates simple interactivity in an Android app.
 * It contains one button that updates a text view with a random
 * value between 1 and 6.
 */
class MainActivity : AppCompatActivity() {
    lateinit var Image : ImageView
    lateinit var bioText: TextView
    lateinit var headerText:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Image = findViewById(R.id.image)
        bioText = findViewById(R.id.bio_text)
        headerText =  findViewById(R.id.header)
        // Get the Button view from the layout and assign a click
        // listener to it.
        val rollButton: Button = findViewById(R.id.roll_button)
        rollButton.setOnClickListener { rollPics() }

        val retryButton: Button = findViewById(R.id.retry_button)
        retryButton.setOnClickListener{retry()}
    }

    /**
     * Click listener for the Roll button.
     */
    private fun rollPics() {
        // Toast.makeText(this, "button clicked",
        //  Toast.LENGTH_SHORT).show()
        val randomInt = (1..10).random()

        val drawableResource = when (randomInt) {
            1 -> R.drawable.phineas
            2 -> R.drawable.ferb
            3 -> R.drawable.candace
            4 -> R.drawable.doof
            5 -> R.drawable.carl
            6 -> R.drawable.baljeet
            7 -> R.drawable.vanessa
            8 -> R.drawable.isabela
            9 -> R.drawable.platypus
            else -> R.drawable.monogram
        }
        val bio = when(randomInt){
            1 -> R.string.bio_phineas
            2 -> R.string.bio_ferb
            3 -> R.string.bio_candace
            4 -> R.string.bio_doof
            5 -> R.string.bio_carl
            6 -> R.string.bio_baljeet
            7 -> R.string.bio_vanessa
            8 -> R.string.bio_isabela
            9 -> R.string.bio_platypus
            else -> R.string.bio_monogram
        }
        Image.setImageResource(drawableResource)
        bioText.setText(bio)
        headerText.setText(R.string.header2)

    }

    private fun retry() {
        Image.setImageResource(R.drawable.disney)
        bioText.setText(R.string.blank)
        headerText.setText(R.string.header_name)
    }


}
