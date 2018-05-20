package uriabad.com.startapp.ui.entities

import android.os.Parcel
import android.os.Parcelable

data class PieceViewEntity(
        val id: String,
        val type: String,
        val title: String,
        val image: String,
        val piece: PieceSummaryViewEntity,
        val tracks: List<TrackViewEntity>,
        val composer: ComposerViewEntity,
        val artists: List<ArtistSummaryViewEntity>
) : Parcelable {

    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readString(),
            parcel.readParcelable(PieceSummaryViewEntity::class.java.classLoader),
            parcel.createTypedArrayList(TrackViewEntity),
            parcel.readParcelable(ComposerViewEntity::class.java.classLoader),
            parcel.createTypedArrayList(ArtistSummaryViewEntity)) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(id)
        parcel.writeString(type)
        parcel.writeString(title)
        parcel.writeString(image)
        parcel.writeParcelable(piece, flags)
        parcel.writeTypedList(tracks)
        parcel.writeParcelable(composer, flags)
        parcel.writeTypedList(artists)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<PieceViewEntity> {
        override fun createFromParcel(parcel: Parcel): PieceViewEntity {
            return PieceViewEntity(parcel)
        }

        override fun newArray(size: Int): Array<PieceViewEntity?> {
            return arrayOfNulls(size)
        }
    }
}