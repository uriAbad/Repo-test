package uriabad.com.startapp.ui.entities

import android.os.Parcel
import android.os.Parcelable

data class UserViewEntity(
        val id: Long,
        val fullname: String,
        val firstName: String,
        val lastName: String,
        val username: String,
        val email: String,
        val image: String,
        val address: AddressViewEntity,
        val preferences: PreferencesViewEntity,
        val subscription: SubscriptionViewEntity,
        val payments: List<PaymentViewEntity>,
        val banned: Boolean,
        val versionNumber: String) : Parcelable {

    constructor(parcel: Parcel) : this(
            parcel.readLong(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readParcelable(AddressViewEntity::class.java.classLoader),
            parcel.readParcelable(PreferencesViewEntity::class.java.classLoader),
            parcel.readParcelable(SubscriptionViewEntity::class.java.classLoader),
            parcel.createTypedArrayList(PaymentViewEntity),
            parcel.readByte() != 0.toByte(),
            parcel.readString()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeLong(id)
        parcel.writeString(fullname)
        parcel.writeString(firstName)
        parcel.writeString(lastName)
        parcel.writeString(username)
        parcel.writeString(email)
        parcel.writeString(image)
        parcel.writeParcelable(address, flags)
        parcel.writeParcelable(preferences, flags)
        parcel.writeParcelable(subscription, flags)
        parcel.writeTypedList(payments)
        parcel.writeByte(if (banned) 1 else 0)
        parcel.writeString(versionNumber)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<UserViewEntity> {
        override fun createFromParcel(parcel: Parcel): UserViewEntity {
            return UserViewEntity(parcel)
        }

        override fun newArray(size: Int): Array<UserViewEntity?> {
            return arrayOfNulls(size)
        }
    }
}