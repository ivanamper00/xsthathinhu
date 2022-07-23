package com.dakulangsakalam.customwebview.presentation.utils

import android.content.Context
import android.content.SharedPreferences
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.net.NetworkInfo
import android.os.Build
import android.util.Log
import android.widget.Toast
import androidx.preference.PreferenceManager
import com.dakulangsakalam.customwebview.presentation.helper.SharedPrefHelper
import com.dakulangsakalam.customwebview.presentation.ui.jump.JumpActivity
import com.dakulangsakalam.customwebview.presentation.utils.writeLogs

fun Context.isNetworkConnected() : Boolean {
    val connectivityManager =
        getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            val capabilities = connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)
            if (capabilities != null) {
                when {
                    capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> writeLogs("Internet NetworkCapabilities.TRANSPORT_CELLULAR")
                    capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> writeLogs("Internet NetworkCapabilities.TRANSPORT_WIFI")
                    capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> writeLogs("Internet NetworkCapabilities.TRANSPORT_ETHERNET")
                }
                return true
            }
        } else {
            val mNetworkInfo: NetworkInfo? = connectivityManager.activeNetworkInfo
            return mNetworkInfo?.isAvailable ?: false
        }
    return false
}

fun Context.showToast(message: String){
    Toast.makeText(this, message, Toast.LENGTH_LONG).show()
}



