package uriabad.com.startapp.repository.entities.mappers

import uriabad.com.startapp.model.AddressInfo
import uriabad.com.startapp.network.safe
import uriabad.com.startapp.repository.entities.AddressDataEntity

fun AddressDataEntity.toAddressInfo(): AddressInfo {
    return AddressInfo(this.state.safe())
}