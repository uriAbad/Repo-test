package uriabad.com.startapp.repository.entities.disk.mapper

import uriabad.com.startapp.repository.entities.AddressDataEntity
import uriabad.com.startapp.repository.entities.disk.AddressDiskEntity

fun AddressDiskEntity.toAddressDataEntity(): AddressDataEntity {
    return AddressDataEntity(state)
}

fun AddressDataEntity.toAddressDiskEntity(): AddressDiskEntity{
    return AddressDiskEntity(state)
}