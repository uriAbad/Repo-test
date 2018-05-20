package uriabad.com.startapp.ui.base

import uriabad.com.startapp.interactor.preferences.PreferencesInteractor
import uriabad.com.startapp.interactor.preferences.PreferencesInteractor.Companion
import javax.inject.Inject

/**
 * BasePresenter
 *
 * Default Presenter that must be subclassed from all the presenters in app. Takes care of
 * manage user data
 *
 * @property preferencesInteractor useCase for store, retrieve, and delete references from local
 * repository
 * @property saveAccountInteractor useCase for load stored account data from disk
 * @property removeAccoutInteractor useCase for remove stored account data from disk
 * @property exceptionHandler useCase for manage exceptions
 */
abstract class BasePresenter {
    @Inject protected lateinit var preferencesInteractor: PreferencesInteractor
    @Inject protected lateinit var exceptionHandler: AndroidExceptionHandler

    fun clearUserLocalData(onClearSuccess: (() -> Unit),
                           onClearError: ((String) -> Unit)) {
        preferencesInteractor.execute(
                PreferencesInteractor.PreferencesBundle(Companion.EDIT_TYPE.DROP)) { _ ->
            onClearSuccess.invoke() }
    }

    fun loadAccountData(onLoadSuccess: ((Any) -> Unit),
                        onLoadError: ((String) -> Unit)){

    }
}