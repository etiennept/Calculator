package com.example.mycalculator

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private var number = ""
    private var neg = true
    private var p = 0
    private var textValue  =  ""



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
        val buttonPlus : Button  = findViewById(R.id.buttonPlus)
        val buttonMinux : Button = findViewById(R.id.buttonMinus)
        val buttonTimes  : Button = findViewById(R.id.buttonTimes)
        val buttonDiv : Button = findViewById(R.id.buttonDiv)
        val textValueView  : TextView = findViewById(R.id.value)
        val textResultView : TextView = findViewById( R.id.result)

        fun valueView(b : String){
            textValue+=b
            textValueView.setText(textValue)
        }
        fun addNumber ( x :String){
            number+x
            val z = x.toDouble()
            number = z.toString()
            valueView(number)
            val a = number(z)
            textResultView.setText(a.toString())
        }

        fun number( x : Int ){
            addNumber(x.toString())

        }
        fun operator( x  :String ){
            valueView(x)
            op(x,number.toDouble() )

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
            number( 0)
        }

        buttonPoint.setOnClickListener {
            addNumber(".")


        }

        buttonPlus.setOnClickListener {
            if (number != ""){
                operator("+")
            }
        }

        buttonMinux.setOnClickListener {
            if (number ==  "") {
                if (neg) {
                    valueView("-")
                    neg = false
                }
            }else {
                operator("-")
            }
        }


        buttonTimes.setOnClickListener {
            if( number !=  ""){
            operator( "*" )
            neg = true
            }
        }

        buttonDiv.setOnClickListener {
            if (number !=  ""){
            operator("/")
            neg = true }
        }

        buttonNew.setOnClickListener {
            new()
            number = ""
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








