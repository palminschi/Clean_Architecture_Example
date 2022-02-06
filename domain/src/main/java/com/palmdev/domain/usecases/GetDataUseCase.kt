package com.palmdev.domain.usecases

import com.palmdev.domain.models.UserName

class GetDataUseCase {

    fun execute(): UserName {
        return UserName(firstName = "Hello", lastName = "World")
    }
}