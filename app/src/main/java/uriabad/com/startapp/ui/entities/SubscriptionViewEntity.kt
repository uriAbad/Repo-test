package uriabad.com.startapp.ui.entities

import android.os.Parcel
import android.os.Parcelable

data class SubscriptionViewEntity(val product: String, val active : Boolean, val trial : Boolean,
                                  val status : String, val paydate : String) : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readByte() != 0.toByte(),
            parcel.readByte() != 0.toByte(),
            parcel.readString(),
            parcel.readString()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(product)
        parcel.writeByte(if (active) 1 else 0)
        parcel.writeByte(if (trial) 1 else 0)
        parcel.writeString(status)
        parcel.writeString(paydate)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<SubscriptionViewEntity> {
        override fun createFromParcel(parcel: Parcel): SubscriptionViewEntity {
            return SubscriptionViewEntity(parcel)
        }

        override fun newArray(size: Int): Array<SubscriptionViewEntity?> {
            return arrayOfNulls(size)
        }
    }
}