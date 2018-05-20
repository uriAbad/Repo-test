package uriabad.com.startapp.ui.entities

import android.os.Parcel
import android.os.Parcelable

data class PreferencesViewEntity(val notificationPermission: Boolean,
                                 val quality : String,
                                 val autoQualitySelected: Boolean) : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readByte() != 0.toByte(),
            parcel.readString(),
            parcel.readByte() != 0.toByte()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeByte(if (notificationPermission) 1 else 0)
        parcel.writeString(quality)
        parcel.writeByte(if (autoQualitySelected) 1 else 0)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<PreferencesViewEntity> {
        override fun createFromParcel(parcel: Parcel): PreferencesViewEntity {
            return PreferencesViewEntity(parcel)
        }

        override fun newArray(size: Int): Array<PreferencesViewEntity?> {
            return arrayOfNulls(size)
        }
    }
}