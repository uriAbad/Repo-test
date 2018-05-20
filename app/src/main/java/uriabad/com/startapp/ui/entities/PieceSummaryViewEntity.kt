package uriabad.com.startapp.ui.entities

import android.os.Parcel
import android.os.Parcelable

data class PieceSummaryViewEntity(
        val id: String,
        val type: String,
        val title: String,
        val workId: String,
        val duration: String
) : Parcelable {

    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(id)
        parcel.writeString(type)
        parcel.writeString(title)
        parcel.writeString(workId)
        parcel.writeString(duration)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<PieceSummaryViewEntity> {
        override fun createFromParcel(parcel: Parcel): PieceSummaryViewEntity {
            return PieceSummaryViewEntity(parcel)
        }

        override fun newArray(size: Int): Array<PieceSummaryViewEntity?> {
            return arrayOfNulls(size)
        }
    }
}