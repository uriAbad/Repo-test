package uriabad.com.startapp.repository.entities.mappers

import uriabad.com.startapp.model.PieceSummaryInfo
import uriabad.com.startapp.network.safe
import uriabad.com.startapp.network.toCompoundDuration
import uriabad.com.startapp.repository.entities.PieceSummaryDataEntity

fun PieceSummaryDataEntity.toPieceSummaryInfo(): PieceSummaryInfo {
    return PieceSummaryInfo(this.id.safe(), this.type.safe(),this.title.safe(), this.workId.safe(),
            this.duration.safe().toCompoundDuration())
}