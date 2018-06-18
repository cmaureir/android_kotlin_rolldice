package com.example.cmaureir.rolldice

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    private val MAX_DICES = 20
    private var diceAmount = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        dice.text = "1"
        results.text = "?"

        button.setOnClickListener {
            var diceText = ""
            for (i in 1..diceAmount) {
                diceText += "%02d".format((1..20).random())
                if (i < diceAmount && i%5 != 0)
                    diceText += "  "
                if (i%5 == 0)
                    diceText += "\n"
            }
            results.text = diceText
        }

        increaseDice.setOnClickListener {
            diceAmount += 1
            if (diceAmount > MAX_DICES)
                diceAmount = MAX_DICES

            dice.text = diceAmount.toString()
        }

        decreaseDice.setOnClickListener {
            diceAmount -= 1
            if (diceAmount < 1)
                diceAmount = 1

            dice.text = diceAmount.toString()
        }

        exit.setOnClickListener {
            System.exit(1)
        }

        clean.setOnClickListener {
            results.text = "?"
        }
    }

    fun ClosedRange<Int>.random() =
            Random().nextInt(endInclusive - start) +  start
}