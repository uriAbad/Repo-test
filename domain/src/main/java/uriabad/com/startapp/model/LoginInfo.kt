package uriabad.com.startapp.model

data class LoginInfo(
        val bearerToken: String,
        val user: UserInfo,
        val status: String,
        val timestamp: String
)