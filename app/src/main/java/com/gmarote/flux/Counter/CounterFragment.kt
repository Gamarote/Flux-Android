package com.gmarote.flux.Counter

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.AttributeSet
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.gmarote.flux.Common.STORE
import com.gmarote.flux.Counter.Redux.CounterAction
import com.gmarote.flux.Counter.Redux.CounterActionTypes

import com.gmarote.flux.R
import kotlinx.android.synthetic.main.fragment_counter.view.*

class CounterFragment : Fragment() {
    val TAG = "CounterFragment"

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        var view = inflater.inflate(R.layout.fragment_counter, container, false)

        STORE.subscribe {
            Log.i(TAG, STORE.state.counter.history.toString())
            view.counter.text = STORE.state.counter.value.toString()
        }

        view.addXBtn.setOnClickListener {
            Log.i(TAG, "entrou")
            if(view.valueInput.text.isNullOrEmpty()){
                Toast.makeText(context, "Preencha o campo de valor", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            Log.i(TAG, "ta aqui")

            STORE.dispatch(CounterAction.makeAction(CounterActionTypes.ADD, mapOf("value" to view.valueInput.text.toString().toInt())))
        }

        view.add1Btn.setOnClickListener {
            STORE.dispatch(CounterAction.makeAction(CounterActionTypes.ADD))
        }

        view.subXBtn.setOnClickListener {
            if(view.valueInput.text.isNullOrEmpty()){
                Toast.makeText(context, "Preencha o campo de valor", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            STORE.dispatch(CounterAction.makeAction(CounterActionTypes.SUB, mapOf("value" to view.valueInput.text.toString().toInt())))
        }

        view.sub1Btn.setOnClickListener {
            STORE.dispatch(CounterAction.makeAction(CounterActionTypes.SUB))
        }

        return view
    }
}
