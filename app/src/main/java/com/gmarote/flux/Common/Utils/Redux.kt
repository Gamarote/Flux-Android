package com.gmarote.flux.Common.Utils

import redux.api.Reducer

/**
 * Created by Gabriel Marote on 4/8/2018.
 */
//interface ReduxReducer<S> : Reducer<S> {
//    fun reduce(state: S, action: ReduxAction): S
//}

interface ReduxActionTypes

interface ReduxAction {
    val type: ReduxActionTypes
}

interface ReduxActionFactory {
    fun makeAction(type: ReduxActionTypes, args: (Map<String, Any>)? = null): ReduxAction?
}

interface ReduxState

interface ReduxStateFactory {
    fun newState(args: (Map<String, Any>)? = null): ReduxState
}