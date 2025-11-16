package org.sopt.melon.core.common.util

import android.content.Context
import android.widget.Toast

/**
 * Toast 메시지 띄우는 함수
 */
fun Context.showToast(
    message: String,
    duration: Int = Toast.LENGTH_SHORT,
) {
    Toast.makeText(this, message, duration).show()
}
