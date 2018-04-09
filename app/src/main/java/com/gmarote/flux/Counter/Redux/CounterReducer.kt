package com.gmarote.flux.Counter.Redux

import android.util.Log
import com.gmarote.flux.Common.ReduxStore
import com.gmarote.flux.Common.Utils.ReduxAction
import redux.api.Reducer
import javax.security.auth.login.LoginException

/**
 * Created by Gabriel Marote on 4/8/2018.
 */

val COUNTER_REDUCER = Reducer { store: ReduxStore, actionObj: Any ->
    val state = store.counter

    try {
        val actionObj = actionObj as ReduxAction
    } catch (e: Exception){
        return@Reducer store
    }

    when (actionObj.type) {
        CounterActionTypes.ADD -> {
            val action = actionObj as CounterAction

            var newValue = state.value + action.value
            var newRegister = CounterState.CounterOperations(
                    action.value,
                    action.type as CounterActionTypes,
                    System.currentTimeMillis()
            )

            var history = state.history
            history.add(newRegister)

            var newState = CounterState.newState(mapOf("newValue" to newValue, "history" to history)) as CounterState

            return@Reducer ReduxStore.updateStore(store, newState, "counter")
        }
        CounterActionTypes.SUB -> {
            val action = actionObj as CounterAction

            var newValue = state.value - action.value
            var newRegister = CounterState.CounterOperations(
                    action.value,
                    action.type as CounterActionTypes,
                    System.currentTimeMillis()
            )

            var history = state.history
            history.add(newRegister)

            var newState = CounterState.newState(mapOf("newValue" to newValue, "history" to history)) as CounterState

            return@Reducer ReduxStore.updateStore(store, newState, "counter")
        }
        else -> return@Reducer store
    }
}
