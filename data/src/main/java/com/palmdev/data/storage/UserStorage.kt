package com.palmdev.data.storage

import com.palmdev.data.storage.models.SaveUserNameParamData
import com.palmdev.data.storage.models.UserNameData

interface UserStorage {

    fun saveName(saveUserNameParamData: SaveUserNameParamData)

    fun getName() : UserNameData

}