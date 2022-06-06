package other.mvi.activity.src.app_package

fun mviIntentKt(
        kotlinEscapedPackageName: String,
        intentClass: String
) = """
package ${kotlinEscapedPackageName}

import com.github.qingmei2.mvi.base.intent.IIntent

sealed class ${intentClass} : IIntent {

    object InitialIntent : ${intentClass}()
}
"""