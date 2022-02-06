package com.palmdev.domain.repository

import com.palmdev.domain.models.SaveUserNameParam
import com.palmdev.domain.models.UserName

interface UserRepository {

    fun saveUserName(saveUserNameParam: SaveUserNameParam)

    fun getUserName() : UserName
}