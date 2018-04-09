package com.gmarote.flux.Counter.Redux

import com.gmarote.flux.Common.Utils.ReduxState
import com.gmarote.flux.Common.Utils.ReduxStateFactory
import kotlin.collections.ArrayList

/**
 * Created by Gabriel Marote on 4/8/2018.
 */
class CounterState: ReduxState {

    var value: Int
    var history: ArrayList<CounterOperations>

    private constructor(value: Int = 0, history: ArrayList<CounterOperations> = ArrayList()){
        this.value = value
        this.history = history
    }

    companion object: ReduxStateFactory {
        override fun newState(args: (Map<String, Any>)?): ReduxState {
            if(args != null){
                if(args.contains("newValue") && args.contains("history")){
                    return CounterState(args["newValue"] as Int, args["history"] as ArrayList<CounterOperations>)
                } else throw Error("Arguments must have a newValue and the history")
            }

            return CounterState()
        }
    }

    data class CounterOperations(var modifiedValue: Int, var operation: CounterActionTypes, var timestamp: Long)
}
