package thien.thua.xsthathinhu

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import thien.thua.xsthathinhu.retrofit.JumpServiceImp
import thien.thua.xsthathinhu.retrofit.RequestModel
import thien.thua.xsthathinhu.retrofit.ResponseModel
import thien.thua.xsthathinhu.utils.UiState

class JumpViewModel: ViewModel() {

    private val repo = JumpServiceImp()

    private val _urlResponse = MutableLiveData<UiState<ResponseModel>>()
    val urlResponse : LiveData<UiState<ResponseModel>>
        get() = _urlResponse

    fun getJumpUrl(packageName: String){
        val param = RequestModel(

        )
        viewModelScope.launch {
            repo.getJumpCodeUrl(param)
                .catch { err -> _urlResponse.value = UiState.Error(err) }
                .collectLatest {
                    _urlResponse.value = UiState.Success(it)
                }
        }
    }
}