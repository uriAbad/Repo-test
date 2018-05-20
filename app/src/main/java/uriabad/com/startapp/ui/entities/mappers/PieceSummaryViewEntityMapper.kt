package uriabad.com.startapp.ui.entities.mappers

import uriabad.com.startapp.model.PieceSummaryInfo
import uriabad.com.startapp.ui.entities.PieceSummaryViewEntity

fun PieceSummaryInfo.toPieceSummaryViewEntity(): PieceSummaryViewEntity{
    return PieceSummaryViewEntity(this.id, this.type, this.title, this.workId, this.duration)
}