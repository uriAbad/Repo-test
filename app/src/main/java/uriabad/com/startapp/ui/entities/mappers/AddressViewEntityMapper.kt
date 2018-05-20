package uriabad.com.startapp.ui.entities.mappers

import uriabad.com.startapp.model.AddressInfo
import uriabad.com.startapp.ui.entities.AddressViewEntity

fun AddressInfo.toAddressViewEntity(): AddressViewEntity {
    return AddressViewEntity(this.state)
}

fun AddressViewEntity.toAddressInfo(): AddressInfo {
    return AddressInfo(this.state)
}