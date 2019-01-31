package io.keepcoding.todo.util

import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import io.keepcoding.todo.R

abstract class BottomSheetDialog : BottomSheetDialogFragment() {

    override fun getTheme(): Int = R.style.Dialog

}