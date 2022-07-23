package thien.thua.xsthathinhu.retrofit

import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import thien.thua.xsthathinhu.retrofit.JumpService
import thien.thua.xsthathinhu.retrofit.RequestModel
import thien.thua.xsthathinhu.retrofit.ResponseModel
import thien.thua.xsthathinhu.retrofit.RetrofitHelper

class JumpServiceImp {

    private val service: JumpService = RetrofitHelper.service()

    suspend fun getJumpCodeUrl(param: RequestModel): Flow<ResponseModel> = callbackFlow {
        trySend(service.getJumpCode(param))
        awaitClose()
    }

}