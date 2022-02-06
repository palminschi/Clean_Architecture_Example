package com.palmdev.domain.usecases

import com.palmdev.domain.models.UserName
import com.palmdev.domain.repository.UserRepository

class GetDataUseCase(private val userRepository: UserRepository) {

    fun execute(): UserName {
        return userRepository.getUserName()
    }
}