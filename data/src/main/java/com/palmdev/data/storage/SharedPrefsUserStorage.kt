package com.palmdev.data.storage

import android.content.Context
import com.palmdev.data.storage.models.SaveUserNameParamData
import com.palmdev.data.storage.models.UserNameData

private const val SHARED_PREFS_NAME = "SHARED_PREFS_NAME"
private const val KEY_USER_FIRST_NAME = "KEY_USER_FIRST_NAME"
private const val KEY_USER_LAST_NAME = "KEY_USER_LAST_NAME"
private const val DEFAULT_NAME = "no data"

class SharedPrefsUserStorage(context: Context) : UserStorage {

    private val sharedPrefs = context.getSharedPreferences(SHARED_PREFS_NAME, Context.MODE_PRIVATE)

    override fun saveName(saveUserNameParamData: SaveUserNameParamData) {
        sharedPrefs.edit().putString(KEY_USER_FIRST_NAME, saveUserNameParamData.firstName).apply()
        sharedPrefs.edit().putString(KEY_USER_LAST_NAME, saveUserNameParamData.lastName).apply()
    }

    override fun getName(): UserNameData {
        val firstName = sharedPrefs.getString(KEY_USER_FIRST_NAME, DEFAULT_NAME) ?: DEFAULT_NAME
        val lastName = sharedPrefs.getString(KEY_USER_LAST_NAME, DEFAULT_NAME) ?: DEFAULT_NAME

        return UserNameData(firstName = firstName, lastName = lastName)
    }
}