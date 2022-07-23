package com.dakulangsakalam.customwebview.domain.interactor

import com.dakulangsakalam.customwebview.data.repository.JumpRepoImp
import com.dakulangsakalam.customwebview.domain.model.JumpRequest


class GetJumpUrl {
    private val repo = JumpRepoImp()

    suspend operator fun invoke(param: JumpRequest) = repo.startRequest(param)
}