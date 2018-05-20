package uriabad.com.startapp.repository.entities.disk

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class RepoDiskEntity (
        @PrimaryKey var _id : Long = 0L,
        var name: String = "",
        var description: String = ""
) : RealmObject()