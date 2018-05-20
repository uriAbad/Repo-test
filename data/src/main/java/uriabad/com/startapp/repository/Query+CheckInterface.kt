package uriabad.com.startapp.repository

import uriabad.com.startapp.repository.query.Query

fun Query.implements(kInterface: Class<*>): Boolean {
    return kInterface.isAssignableFrom(this::class.java)
}