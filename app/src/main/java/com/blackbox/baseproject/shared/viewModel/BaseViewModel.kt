package com.blackbox.baseproject.shared.viewModel

import android.app.Application
import androidx.lifecycle.*
import io.reactivex.disposables.CompositeDisposable

abstract class BaseViewModel(application: Application) : AndroidViewModel(application),LifecycleObserver {

    protected val compositeDisposible = CompositeDisposable()

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    protected open fun onLifeCycleOwnerCreate(){

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    protected open fun onLifeCycleOwnerResume(){

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    protected open fun onLifeCycleOwnerDestroyed(){

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    protected open fun onLifeCycleOwnerPause(){

    }

    override fun onCleared() {
        super.onCleared()
        if(!compositeDisposible.isDisposed){
            compositeDisposible.dispose()
        }
    }
}