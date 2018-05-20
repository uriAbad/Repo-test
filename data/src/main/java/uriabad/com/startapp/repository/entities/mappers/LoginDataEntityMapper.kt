package uriabad.com.startapp.repository.entities.mappers

import uriabad.com.startapp.model.LoginInfo
import uriabad.com.startapp.network.safe
import uriabad.com.startapp.repository.entities.LoginDataEntity

fun LoginDataEntity.toLoginInfo(): LoginInfo {
    return LoginInfo(this.bearerToken.safe(), this.user.toUserInfo(), this.status.safe(),
                     this.timestamp.safe())
}