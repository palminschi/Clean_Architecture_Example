package com.palmdev.data.repository

import com.palmdev.data.storage.UserStorage
import com.palmdev.data.storage.models.SaveUserNameParamData
import com.palmdev.data.storage.models.UserNameData
import com.palmdev.domain.models.SaveUserNameParam
import com.palmdev.domain.models.UserName
import com.palmdev.domain.repository.UserRepository



class UserRepositoryImpl(private val userStorage: UserStorage) : UserRepository {

    override fun saveUserName(saveUserNameParam: SaveUserNameParam) {
        val params = mapToStorage(saveUserNameParam)
        userStorage.saveName(params)
    }

    override fun getUserName(): UserName {
        return mapToDomain(userStorage.getName())
    }

    private fun mapToDomain(userNameData: UserNameData) : UserName {
        return UserName(firstName = userNameData.firstName, lastName = userNameData.lastName)
    }

    private fun mapToStorage(saveUserNameParam: SaveUserNameParam): SaveUserNameParamData{
        return SaveUserNameParamData(
            firstName = saveUserNameParam.firstName,
            lastName = saveUserNameParam.lastName)
    }
}