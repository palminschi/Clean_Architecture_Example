package com.palmdev.data.repository

import android.content.Context
import com.palmdev.domain.models.SaveUserNameParam
import com.palmdev.domain.models.UserName
import com.palmdev.domain.repository.UserRepository

private const val SHARED_PREFS_NAME = "SHARED_PREFS_NAME"
private const val KEY_USER_FIRST_NAME = "KEY_USER_FIRST_NAME"
private const val KEY_USER_LAST_NAME = "KEY_USER_LAST_NAME"
private const val DEFAULT_NAME = "no data"

class UserRepositoryImpl(context: Context) : UserRepository {

    private val sharedPrefs = context.getSharedPreferences(SHARED_PREFS_NAME, Context.MODE_PRIVATE)

    override fun saveUserName(saveUserNameParam: SaveUserNameParam) {
        sharedPrefs.edit().putString(KEY_USER_FIRST_NAME, saveUserNameParam.firstName).apply()
        sharedPrefs.edit().putString(KEY_USER_LAST_NAME, saveUserNameParam.lastName).apply()
    }

    override fun getUserName(): UserName {
        val firstName = sharedPrefs.getString(KEY_USER_FIRST_NAME, DEFAULT_NAME) ?: DEFAULT_NAME
        val lastName = sharedPrefs.getString(KEY_USER_LAST_NAME, DEFAULT_NAME) ?: DEFAULT_NAME

        return UserName(firstName = firstName, lastName = lastName)
    }
}