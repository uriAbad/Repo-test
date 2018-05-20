package uriabad.com.startapp.ui.entities

import android.os.Parcel
import android.os.Parcelable

data class TrackViewEntity(
        val id: String,
        val type: String,
        val movementId: String,
        val title: String,
        val available: Boolean,
        val isrc: String,
        val duration: String
) : Parcelable {

    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readByte() != 0.toByte(),
            parcel.readString(),
            parcel.readString())

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(id)
        parcel.writeString(type)
        parcel.writeString(movementId)
        parcel.writeString(title)
        parcel.writeByte(if (available) 1 else 0)
        parcel.writeString(isrc)
        parcel.writeString(duration)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<TrackViewEntity> {
        override fun createFromParcel(parcel: Parcel): TrackViewEntity {
            return TrackViewEntity(parcel)
        }

        override fun newArray(size: Int): Array<TrackViewEntity?> {
            return arrayOfNulls(size)
        }
    }
}