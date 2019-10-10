package com.example.mycalculator

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {


    var number = 0.0
    var run = Runtime()

    var neg = true
    var p = 0
    var textValue  =  ""



    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        val button1: Button = findViewById(R.id.button1)
        val button2: Button = findViewById(R.id.button2)
        val button3: Button = findViewById(R.id.button3)
        val button4: Button = findViewById(R.id.button4)
        val button5: Button = findViewById(R.id.button5)
        val button6: Button = findViewById(R.id.button6)
        val button7: Button = findViewById(R.id.button7)
        val button8: Button = findViewById(R.id.button8)
        val button9: Button = findViewById(R.id.button9)
        val button0: Button = findViewById(R.id.button0)
        val buttonPoint: Button  = findViewById(R.id.buttonPoint)
        val buttonNew : Button = findViewById(R.id.buttonNew)
        val buttonplus : Button  = findViewById(R.id.buttonPlus)
        val buttonminux : Button = findViewById(R.id.buttonMinus)
        val buttontimes  : Button = findViewById(R.id.buttonTimes)
        val buttondiv : Button = findViewById(R.id.buttonDiv)
        val textValueView  : TextView = findViewById(R.id.value)
        val textResultView : TextView = findViewById( R.id.result)

        fun valueView(b : String){
            textValue+=b
            textValueView.setText(textValue)
        }

        fun number( x : Short ){
            valueView(x.toString())
            if(p == 0){
                number *= 10.0
                number += x.toDouble()
            }
            else{
                number+= x.toDouble()/p
                p*=10
            }

            var a = run.number(number)
            var b =  a.toString()
            textResultView.setText(b)
        }

        fun operator(  x  :String  ){
            valueView(x)
            p = 0
            run.op(x, number)
            number = 0.0
        }


        button1.setOnClickListener {
            number(1)
        }
        button2.setOnClickListener {
            number(2)
        }
        button3.setOnClickListener {
            number(3)
        }
        button4.setOnClickListener {
            number(4)
        }
        button5.setOnClickListener {
            number(5)
        }
        button6.setOnClickListener {
            number(6)
        }
        button7.setOnClickListener {
            number(7)
        }
        button8.setOnClickListener {
            number(8)
        }
        button9.setOnClickListener {
            number(9)
        }
        button0.setOnClickListener {
            if(number != 0.0 ){
                number( 0)
            }

        }

        buttonPoint.setOnClickListener {
            if (p ==0 ){
                valueView(".")
                p = 10
            }
        }

        buttonplus.setOnClickListener {
            if (number != 0.0){
                operator("+")
            }
        }

        buttonminux.setOnClickListener {
            if (number == 0.0) {
                if (neg) {
                    valueView("-")
                    neg = false
                }
            }else {
                operator("-")
            }
        }


        buttontimes.setOnClickListener {
            if( number !=  0.0){
            operator( "*" )
            neg = true
            }
        }

        buttondiv.setOnClickListener {
            if (number !=  0.0){
            operator("/")
            neg = true }
        }

        buttonNew.setOnClickListener {
            number = 0.0
            run = Runtime()
            neg = true
            p = 0
            textValue  = ""
            textValueView.setText("")
            textResultView.setText("")
        }
    }



    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}








