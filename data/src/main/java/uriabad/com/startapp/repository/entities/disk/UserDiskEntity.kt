package uriabad.com.startapp.repository.entities.disk

import io.realm.RealmList
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class UserDiskEntity(@PrimaryKey var id: Long = 0,
                          var fullname: String = "",
                          var firstName: String = "",
                          var lastName: String = "",
                          var username: String = "",
                          var email: String = "",
                          var image: String = "",
                          var address: AddressDiskEntity = AddressDiskEntity(),
                          var preferences: PreferencesDiskEntity = PreferencesDiskEntity(),
                          var subscription: SubscriptionDiskDataEntity = SubscriptionDiskDataEntity(),
                          var payments: RealmList<PaymentDiskEntity> = RealmList(),
                          var banned: Boolean = false,
                          var versionNumber: String = "" ) : RealmObject()