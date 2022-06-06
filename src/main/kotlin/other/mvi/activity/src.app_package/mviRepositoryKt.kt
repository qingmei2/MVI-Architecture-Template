package other.mvi.activity.src.app_package

fun mviRepositoryKt(
        kotlinEscapedPackageName: String,
        dataSourceRepositoryName: String,
        remoteDataSourceName: String,
        localDataSourceName: String
) = """
package ${kotlinEscapedPackageName}

import com.github.qingmei2.mvi.base.repository.BaseRepositoryBoth
import com.github.qingmei2.mvi.base.repository.ILocalDataSource
import com.github.qingmei2.mvi.base.repository.IRemoteDataSource

class ${dataSourceRepositoryName}(
    remoteDataSource: ${remoteDataSourceName},
    localDataSource: ${localDataSourceName}
) : BaseRepositoryBoth<${remoteDataSourceName}, ${localDataSourceName}>(remoteDataSource, localDataSource)

class ${remoteDataSourceName} : IRemoteDataSource

class ${localDataSourceName} : ILocalDataSource
"""