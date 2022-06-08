package other.mvi.activity

import com.android.tools.idea.wizard.template.*
import other.mvi.activity.src.app_package.*
import other.mvi.activity.res.layout.mviActivityXml

fun RecipeExecutor.mviActivityRecipe(
        moduleData: ModuleTemplateData,
        kotlinEscapedPackageName: String,
        className: String,
        intentClass: String,
        actionClass: String,
        resultClass: String,
        viewStateClass: String,
        viewModelClass: String,
        processorHolderClass: String,
        dataSourceRepositoryName: String,
        remoteDataSourceName: String,
        localDataSourceName: String,
        layoutName: String
) {
    val (projectData, srcOut, resOut) = moduleData
    val ktOrJavaExt = projectData.language.extension
//    generateManifest(
//            moduleData = moduleData,
//            activityClass = { className },
//            activityTitle = className,
//            packageName = kotlinEscapedPackageName,
//            isLauncher = false,
//            hasNoActionBar = false,
//            generateActivityTitle = true,
//            requireTheme = false,
//            useMaterial2 = false
//    )

    val mviActivity = mviActivityKt(projectData.applicationPackage, kotlinEscapedPackageName, className, intentClass, viewStateClass, viewModelClass, layoutName)
    val mviAction = mviActionKt(kotlinEscapedPackageName, actionClass)
    val mviActionProcessor = mviActionProcessorHolderKt(processorHolderClass, kotlinEscapedPackageName, dataSourceRepositoryName, resultClass, actionClass)
    val mviDI = mviActivityDIModuleKt(processorHolderClass, kotlinEscapedPackageName, dataSourceRepositoryName, className, viewModelClass, remoteDataSourceName, localDataSourceName)
    val mviViewModel = mviActivityViewModelKt(kotlinEscapedPackageName, intentClass, actionClass, resultClass, viewStateClass, viewModelClass, processorHolderClass)
    val mviIntent = mviIntentKt(kotlinEscapedPackageName, intentClass)
    val mviRepo = mviRepositoryKt(kotlinEscapedPackageName, dataSourceRepositoryName, remoteDataSourceName, localDataSourceName)
    val mviResult = mviResultKt(kotlinEscapedPackageName, resultClass)
    val mviViewState = mviViewStateKt(kotlinEscapedPackageName, viewStateClass)
    val mviXml = mviActivityXml()

    save(mviActivity, srcOut.resolve("${className}.${ktOrJavaExt}"))
    save(mviAction, srcOut.resolve("${actionClass}.${ktOrJavaExt}"))
    save(mviActionProcessor, srcOut.resolve("${processorHolderClass}.${ktOrJavaExt}"))
    save(mviDI, srcOut.resolve("${className}DIModule.${ktOrJavaExt}"))
    save(mviViewModel, srcOut.resolve("${viewModelClass}.${ktOrJavaExt}"))
    save(mviIntent, srcOut.resolve("${intentClass}.${ktOrJavaExt}"))
    save(mviRepo, srcOut.resolve("${dataSourceRepositoryName}.${ktOrJavaExt}"))
    save(mviResult, srcOut.resolve("${resultClass}.${ktOrJavaExt}"))
    save(mviViewState, srcOut.resolve("${viewStateClass}.${ktOrJavaExt}"))
    save(mviXml, resOut.resolve("layout/${layoutName}.xml"))
}