package uriabad.com.startapp.ui

import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class UserDetails @Inject constructor() {
    var userID: String = ""
    var token: String = ""
}