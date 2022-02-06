package com.palmdev.domain.usecases

import com.palmdev.domain.models.SaveUserNameParam
import com.palmdev.domain.repository.UserRepository

class SaveDataUseCase(private val userRepository: UserRepository) {

    fun execute(saveUserNameParam : SaveUserNameParam) {
        userRepository.saveUserName(saveUserNameParam)
    }
}