package com.example.converterjpg

import com.example.fileconvertor.PictureConverter
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.schedulers.Schedulers
import moxy.MvpPresenter


class MainPresenter(private val scheduler: Scheduler) : MvpPresenter<MainView>() {
    private val converter: PictureConverter = PictureConverter()
    private lateinit var disposable: Disposable
    fun convertFile(startPath: String) {
     disposable =  Completable.fromCallable {
             converter.convertPicture(startPath)
        }.subscribeOn(Schedulers.io())
            .observeOn(scheduler)
            .subscribe(
                {
                    viewState.showSuccessMsg()
                },
                { error ->
                    viewState.showFailMsg()
                }
            )
    }

    override fun onDestroy() {
        disposable.dispose()
        super.onDestroy()
    }

}