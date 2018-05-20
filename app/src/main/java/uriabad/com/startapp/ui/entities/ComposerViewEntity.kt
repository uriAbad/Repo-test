package uriabad.com.startapp.ui.entities

import android.os.Parcel
import android.os.Parcelable

data class ComposerViewEntity(
        val id: String,
        val type: String,
        val name: String
): Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readString(),
            parcel.readString()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(id)
        parcel.writeString(type)
        parcel.writeString(name)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<ComposerViewEntity> {
        override fun createFromParcel(parcel: Parcel): ComposerViewEntity {
            return ComposerViewEntity(parcel)
        }

        override fun newArray(size: Int): Array<ComposerViewEntity?> {
            return arrayOfNulls(size)
        }
    }
}