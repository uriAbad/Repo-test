package uriabad.com.startapp.ui

import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class AppConfig @Inject constructor() {
    var mustUseBottomNavigation: Boolean = false
}