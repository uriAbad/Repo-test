package uriabad.com.startapp.network

import android.content.Context
import android.net.ConnectivityManager
import uriabad.com.startapp.dependencyinjection.qualifier.ApplicationContext
import javax.inject.Inject

class ConnectionChecker @Inject constructor(@ApplicationContext val context: Context) {

    fun thereIsConnectivity(): Boolean {
        val systemService = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        val activeNetwork = systemService.activeNetworkInfo

        if (activeNetwork == null || !activeNetwork.isConnectedOrConnecting) {
            return false
        }
        return true
    }
}