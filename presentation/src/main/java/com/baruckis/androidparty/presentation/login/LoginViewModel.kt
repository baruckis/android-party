package com.baruckis.androidparty.presentation.login

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.baruckis.androidparty.domain.entity.LoggedInUserEntity
import com.baruckis.androidparty.domain.usecases.LoginUseCase
import com.baruckis.androidparty.presentation.mapper.LoginPresentationMapper
import com.baruckis.androidparty.presentation.model.LoginPresentation
import com.baruckis.androidparty.presentation.state.Resource
import com.baruckis.androidparty.presentation.state.Status
import io.reactivex.observers.DisposableSingleObserver
import java.util.*
import javax.inject.Inject
import kotlin.concurrent.schedule

class LoginViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase,
    private val loginPresentationMapper: LoginPresentationMapper
) : ViewModel() {

    private val _loginResource = MutableLiveData<Resource<LoginPresentation>>()
    val loginResource: LiveData<Resource<LoginPresentation>> = _loginResource

    fun login(username: String, password: String) {
        _loginResource.postValue(Resource(Status.LOADING, null, null))

        Timer().schedule(1000){
            // do something after 1 second
            loginUseCase.execute(
                LoginSubscriber(),
                LoginUseCase.Params.authorization(username, password)
            )
        }
    }

    fun loginClick() {
        login("tesonet", "partyanimal")
    }

    override fun onCleared() {
        loginUseCase.dispose()
        super.onCleared()
    }

    inner class LoginSubscriber : DisposableSingleObserver<LoggedInUserEntity>() {

        override fun onSuccess(loggedInUser: LoggedInUserEntity) {
            _loginResource.postValue(
                Resource(
                    Status.SUCCESS,
                    loginPresentationMapper.mapTo(loggedInUser),
                    null
                )
            )

            Log.d("AndroidParty", "onSuccess - Token " + loggedInUser.token)
        }

        override fun onError(e: Throwable) {
            _loginResource.postValue(
                Resource(
                    Status.ERROR,
                    null,
                    e.localizedMessage))

            Log.d("AndroidParty", "onError")
        }

    }

}