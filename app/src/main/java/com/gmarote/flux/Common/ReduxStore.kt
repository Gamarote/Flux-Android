package com.gmarote.flux.Common

import com.gmarote.flux.Common.Utils.ReduxState
import com.gmarote.flux.Counter.Redux.COUNTER_REDUCER
import com.gmarote.flux.Counter.Redux.CounterState
import redux.combineReducers
import redux.createStore

/**
 * Created by Gabriel Marote on 4/8/2018.
 */

data class ReduxStore(
        var counter: CounterState = CounterState.newState() as CounterState
) {
    companion object {
        fun updateStore(prevStore: ReduxStore, newState: ReduxState, stateChanged: String): ReduxStore{
            when(stateChanged){
                "counter" -> return ReduxStore(
                        newState as CounterState
                )
                else -> return prevStore
            }
        }
    }
}

val STORE = createStore(
        combineReducers(
                COUNTER_REDUCER
        ),
        ReduxStore()
)