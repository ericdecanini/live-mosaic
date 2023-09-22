package com.bumble.puzzyx.component.gridpuzzle.operation

import androidx.compose.animation.core.AnimationSpec
import com.bumble.appyx.components.backstack.BackStack
import com.bumble.appyx.components.backstack.operation.Push
import com.bumble.appyx.interactions.core.model.transition.BaseOperation
import com.bumble.appyx.interactions.core.model.transition.Operation
import com.bumble.appyx.utils.multiplatform.Parcelize
import com.bumble.puzzyx.component.gridpuzzle.GridPuzzle
import com.bumble.puzzyx.component.gridpuzzle.GridPuzzleModel
import com.bumble.puzzyx.component.gridpuzzle.GridPuzzleModel.State

@Parcelize
class Assemble(
    override var mode: Operation.Mode
) : BaseOperation<State>() {

    override fun isApplicable(state: GridPuzzleModel.State): Boolean =
        true

    override fun createFromState(baseLineState: GridPuzzleModel.State): GridPuzzleModel.State =
        baseLineState

    override fun createTargetState(fromState: GridPuzzleModel.State): GridPuzzleModel.State =
        fromState.copy(
            puzzleMode = GridPuzzleModel.PuzzleMode.ASSEMBLED
        )
}

fun GridPuzzle.assemble(
    mode: Operation.Mode = Operation.Mode.IMMEDIATE,
    animationSpec: AnimationSpec<Float>? = null
) {
    operation(operation = Assemble(mode), animationSpec = animationSpec)
}