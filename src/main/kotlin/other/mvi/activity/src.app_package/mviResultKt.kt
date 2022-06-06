package other.mvi.activity.src.app_package

fun mviResultKt(
        kotlinEscapedPackageName: String,
        resultClass: String
) = """
package ${kotlinEscapedPackageName}

import com.github.qingmei2.mvi.base.result.IResult

sealed class ${resultClass} : IResult {

    object InitialResult : ${resultClass}()
}
"""