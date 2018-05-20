package uriabad.com.startapp.ui.entities

import android.os.Parcel
import android.os.Parcelable

data class RepoViewEntity (
        val id: Long,
        val name: String,
        val description: String
) : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readLong(),
            parcel.readString(),
            parcel.readString()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeLong(id)
        parcel.writeString(name)
        parcel.writeString(description)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<RepoViewEntity> {
        override fun createFromParcel(parcel: Parcel): RepoViewEntity {
            return RepoViewEntity(parcel)
        }

        override fun newArray(size: Int): Array<RepoViewEntity?> {
            return arrayOfNulls(size)
        }
    }
}