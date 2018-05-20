package uriabad.com.startapp.ui.entities

import android.os.Parcel
import android.os.Parcelable

data class ArtistSummaryViewEntity(
        var id: String,
        var type: String,
        var role: String,
        var name: String
): Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(id)
        parcel.writeString(type)
        parcel.writeString(role)
        parcel.writeString(name)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ArtistSummaryViewEntity> {
        override fun createFromParcel(parcel: Parcel): ArtistSummaryViewEntity {
            return ArtistSummaryViewEntity(parcel)
        }

        override fun newArray(size: Int): Array<ArtistSummaryViewEntity?> {
            return arrayOfNulls(size)
        }
    }
}