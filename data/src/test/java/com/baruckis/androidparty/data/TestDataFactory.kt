package com.baruckis.androidparty.data

import com.baruckis.androidparty.data.model.LoggedInUserData
import com.baruckis.androidparty.data.model.TokenData
import com.baruckis.androidparty.domain.entity.LoggedInUserEntity

object TestDataFactory {

    private const val TOKEN = "f9731b590611a5a9377fbd02f247fcdf"
    private const val USERNAME = "abc"
    private const val PASSWORD = "def"

    fun createLoggedInUserEntity(): LoggedInUserEntity {
        return LoggedInUserEntity(TOKEN, USERNAME)
    }

    fun createLoggedInUserData(): LoggedInUserData {
        return LoggedInUserData(TOKEN, USERNAME)
    }

    fun createTokenData(): TokenData {
        return TokenData(TOKEN)
    }

    val username = USERNAME
    val password = PASSWORD

}