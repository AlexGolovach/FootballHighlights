package com.renovavision.footballhighlights.presentation.list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.renovavision.footballhighlights.data.Match
import com.renovavision.footballhighlights.domain.GetHighlightsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

data class State(
    val isLoading: Boolean = true,
    val data: List<Match> = emptyList(),
    val showError: Boolean = false
)

@HiltViewModel
class HighlightsListViewModel @Inject constructor(private val useCase: GetHighlightsUseCase) : ViewModel() {

    @ExperimentalCoroutinesApi
    private val state = MutableStateFlow(State())

    @ExperimentalCoroutinesApi
    val observeState: StateFlow<State>
        get() = state

    init {
        loadHighlights()
    }

    @ExperimentalCoroutinesApi
    fun loadHighlights() {
        state.value = State()

        viewModelScope.launch {
            useCase.invoke()
                .catch { state.value = State(isLoading = false, showError = true) }
                .collect {
                    state.value = State(isLoading = false, showError = false, data = it)
                }
        }
    }
}