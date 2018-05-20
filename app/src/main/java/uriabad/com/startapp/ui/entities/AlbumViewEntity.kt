package uriabad.com.startapp.ui.entities

import android.os.Parcel
import android.os.Parcelable

data class AlbumViewEntity(
        val id: String,
        val title: String,
        val type: String,
        val image: String,
        val duration: String,
        val subtitle: String,
        val available : Boolean
) : Parcelable {

    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readByte() != 0.toByte()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(id)
        parcel.writeString(title)
        parcel.writeString(type)
        parcel.writeString(image)
        parcel.writeString(duration)
        parcel.writeString(subtitle)
        parcel.writeByte(if (available) 1 else 0)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object {

        fun empty() = AlbumViewEntity("","","","","","",false)

        @JvmField val CREATOR = object : Parcelable.Creator<AlbumViewEntity> {
            override fun createFromParcel(parcel: Parcel) = AlbumViewEntity(parcel)
            override fun newArray(size: Int) = arrayOfNulls<AlbumViewEntity?>(size)
        }
    }

}