package uriabad.com.startapp.ui.entities

import android.os.Parcel
import android.os.Parcelable

data class AddressViewEntity(val state: String) : Parcelable {

    constructor(parcel: Parcel) : this(parcel.readString())

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(state)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<AddressViewEntity> {
        override fun createFromParcel(parcel: Parcel): AddressViewEntity {
            return AddressViewEntity(parcel)
        }

        override fun newArray(size: Int): Array<AddressViewEntity?> {
            return arrayOfNulls(size)
        }
    }
}