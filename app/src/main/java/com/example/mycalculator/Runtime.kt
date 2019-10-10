package com.example.mycalculator

class Runtime {
    var left = 0.0
    var right = 1.0
    var a = true

    fun number(n : Double):Double {
        if(a ){
            return n*right+left
        }
        else {
            return right/n+left
        }
    }

    fun eee() {
        left+=right
        right= 1.0
        a = true
    }


    fun op  (op  :String , n : Double ){
        if(a){
            right*= n
        }
        else{
            right/=n
        }
        when( op  ){
            "+"->{
                eee()
            }
            "-"->{
                eee()
                neg()
            }
            "*"->{
                a = true
            }
            "/" ->{
                a = false
            }
        }


    }

    fun neg(){
        right *=-1
    }

}