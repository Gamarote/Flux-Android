package com.gmarote.flux.Counter.Redux

import com.gmarote.flux.Common.Utils.ReduxAction
import com.gmarote.flux.Common.Utils.ReduxActionFactory
import com.gmarote.flux.Common.Utils.ReduxActionTypes

/**
 * Created by Gabriel Marote on 4/8/2018.
 */

class CounterAction: ReduxAction {

    override val type: ReduxActionTypes
    val value: Int

    private constructor(type: CounterActionTypes, value: Int = 1){
        this.type = type
        this.value = value
    }

    companion object: ReduxActionFactory {
        override fun makeAction(type: ReduxActionTypes, args: (Map<String, Any>)?): ReduxAction? {
            if(type == CounterActionTypes.SUB || type == CounterActionTypes.ADD){
                var _type = type as CounterActionTypes
                if(args != null && args.contains("value")){
                    try {
                        return CounterAction(_type, args["value"] as Int)
                    } catch (e: Exception){
                        throw e
                    }
                } else return CounterAction(_type)
            } else throw Error("Invalid type for Counter Action")

            return null
        }
    }
}
