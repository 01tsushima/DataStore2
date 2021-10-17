package com.datastore.test.core.base

import android.content.res.Resources
import androidx.annotation.StringRes
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.datastore.test.core.EventFlow
import com.datastore.test.core.JobManager
import com.datastore.test.core.StateEventFlow
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

abstract class BaseViewModel : ViewModel() {

    private val jobManager = JobManager(viewModelScope)

    private val theme = EventFlow<Resources.Theme>()

    private val loadingState by lazy { StateEventFlow(false) }
    private val messageEvent by lazy { EventFlow<String>() }

    protected fun CoroutineScope.execute(/*errorHandler: ErrorHandler,*/function: suspend () -> Unit) {
        launch(Dispatchers.IO) {
            loadingState.postState(true)
            try {
                function()
            } catch (e: Throwable) {
                messageEvent.postEvent(e.localizedMessage)
            } finally {
                loadingState.postState(false)
            }
        }
    }

    protected suspend fun <T> execute(/*errorHandler: ErrorHandler,*/function: suspend () -> T): T? {
        loadingState.postState(true)
        return try {
            function()
        } catch (e: Throwable) {
            messageEvent.postEvent(e.localizedMessage)
            null
        } finally {
            loadingState.postState(false)
        }
    }

    protected fun CoroutineScope.observe(tag: Any, function: suspend () -> Unit) = jobManager.launch(tag) {
        this@observe.launch { function() }
    }

    /**
     * Retry all subscriptions if somewhere catch error
     * */
    fun retry() = jobManager.retry()

    protected fun getString(@StringRes strId: Int) =
        theme.value.peekContent?.resources?.getString(strId).orEmpty()
}