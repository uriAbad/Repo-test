package uriabad.com.startapp.ui.base

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
    @Inject protected lateinit var exceptionHandler: AndroidExceptionHandler
}