package com.plcoding.streamchatapp.util

import android.os.Bundle
import androidx.annotation.IdRes
import androidx.navigation.NavController
import androidx.navigation.NavOptions
import androidx.navigation.Navigator

fun NavController.navigateSafely(
    @IdRes restId: Int,
    args: Bundle? = null,
    navOptions: NavOptions? = null,
    navExtras: Navigator.Extras? = null
) {
    val action = currentDestination?.getAction(restId) ?: graph.getAction(restId)
    if (action != null && currentDestination?.id != action.destinationId) {
        navigate(restId, args, navOptions, navExtras)
    }
}