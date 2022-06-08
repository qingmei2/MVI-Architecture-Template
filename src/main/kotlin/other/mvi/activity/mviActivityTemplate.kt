package other.mvi.activity

import com.android.tools.idea.wizard.template.*
import com.android.tools.idea.wizard.template.impl.activities.common.MIN_API

val mviActivityTemplate
    get() = template {
//        revision = 1
        name = "MVI Activity"
        description = "创建适用于 MVI-Architecture 的 Activity"
        minApi = MIN_API
//        minBuildApi = MIN_API

        category = Category.Other
        formFactor = FormFactor.Mobile
        screens = listOf(WizardUiContext.ActivityGallery, WizardUiContext.MenuEntry, WizardUiContext.NewProject, WizardUiContext.NewModule)

        val objectKind = stringParameter {
            name = "Object Kind"
            default = "Main"
            help = "Other examples are 'Person', 'Book', etc."
            constraints = listOf(Constraint.NONEMPTY)
        }

        val packageName = stringParameter {
            name = "Package name"
            visible = { !isNewModule }
            default = "com.mycompany.myapp"
            constraints = listOf(Constraint.PACKAGE)
            suggest = { packageName }
        }

        val activityClass = stringParameter {
            name = "Activity Name"
            default = "MainActivity"
            help = ""
            suggest = { "${extractLetters(objectKind.value)}Activity" }
            constraints = listOf(Constraint.NONEMPTY)
        }

        val layoutName = stringParameter {
            name = "Layout Name"
            default = "activity_main"
            help = "请输入布局的名字"
            constraints = listOf(Constraint.CLASS, Constraint.UNIQUE, Constraint.NONEMPTY)
            suggest = { "activity_${objectKind.value.toLowerCase()}" }
        }

        val viewModelClass = stringParameter {
            name = "ViewModel Name"
            default = "MainViewModel"
            help = ""
            suggest = { "${extractLetters(objectKind.value)}ViewModel" }
            constraints = listOf(Constraint.CLASS, Constraint.UNIQUE, Constraint.NONEMPTY)
        }

        val intentClass = stringParameter {
            name = "Intent Name"
            default = "MainIntent"
            help = ""
            suggest = { "${extractLetters(objectKind.value)}Intent" }
            constraints = listOf(Constraint.CLASS, Constraint.UNIQUE, Constraint.NONEMPTY)
        }

        val viewStateClass = stringParameter {
            name = "ViewState Name"
            default = "MainViewState"
            help = ""
            suggest = { "${extractLetters(objectKind.value)}ViewState" }
            constraints = listOf(Constraint.CLASS, Constraint.UNIQUE, Constraint.NONEMPTY)
        }

        val actionClass = stringParameter {
            name = "Action Name"
            default = "MainAction"
            help = ""
            suggest = { "${extractLetters(objectKind.value)}Action" }
            constraints = listOf(Constraint.CLASS, Constraint.UNIQUE, Constraint.NONEMPTY)
        }

        val resultClass = stringParameter {
            name = "Result Name"
            default = "MainResult"
            help = ""
            suggest = { "${extractLetters(objectKind.value)}Result" }
            constraints = listOf(Constraint.CLASS, Constraint.UNIQUE, Constraint.NONEMPTY)
        }

        val processorHolderClass = stringParameter {
            name = "ActionProcessorHolder Name"
            default = "MainActionProcessorHolder"
            help = ""
            suggest = { "${extractLetters(objectKind.value)}ActionProcessorHolder" }
            constraints = listOf(Constraint.CLASS, Constraint.UNIQUE, Constraint.NONEMPTY)
        }

        val dataSourceRepositoryClass = stringParameter {
            name = "DataSourceRepository Name"
            default = "MainDataSourceRepository"
            help = ""
            visible = { false }
            suggest = { "${extractLetters(objectKind.value)}DataSourceRepository" }
            constraints = listOf(Constraint.CLASS, Constraint.UNIQUE, Constraint.NONEMPTY)
        }

        val remoteDataSourceClass = stringParameter {
            name = "RemoteDataSource Name"
            default = "MainRemoteDataSource"
            help = ""
            visible = { false }
            suggest = { "${extractLetters(objectKind.value)}RemoteDataSource" }
            constraints = listOf(Constraint.CLASS, Constraint.UNIQUE, Constraint.NONEMPTY)
        }

        val localDataSourceClass = stringParameter {
            name = "LocalDataSource Name"
            default = "MainLocalDataSource"
            help = ""
            visible = { false }
            suggest = { "${extractLetters(objectKind.value)}LocalDataSource" }
            constraints = listOf(Constraint.CLASS, Constraint.UNIQUE, Constraint.NONEMPTY)
        }

        widgets(
                PackageNameWidget(packageName),
                TextFieldWidget(objectKind),
                TextFieldWidget(activityClass),
                TextFieldWidget(layoutName),
                TextFieldWidget(viewModelClass),
                TextFieldWidget(intentClass),
                TextFieldWidget(viewStateClass),
                TextFieldWidget(actionClass),
                TextFieldWidget(resultClass),
                TextFieldWidget(processorHolderClass),
                TextFieldWidget(dataSourceRepositoryClass),
                TextFieldWidget(remoteDataSourceClass),
                TextFieldWidget(localDataSourceClass),
        )
        recipe = { data: TemplateData ->
            mviActivityRecipe(
                    moduleData = data as ModuleTemplateData,
                    kotlinEscapedPackageName = packageName.value,
                    className = activityClass.value,
                    intentClass = intentClass.value,
                    actionClass = actionClass.value,
                    resultClass = resultClass.value,
                    viewStateClass = viewStateClass.value,
                    viewModelClass = viewModelClass.value,
                    processorHolderClass = processorHolderClass.value,
                    dataSourceRepositoryName = dataSourceRepositoryClass.value,
                    remoteDataSourceName = remoteDataSourceClass.value,
                    localDataSourceName = localDataSourceClass.value,
                    layoutName.value)
        }
    }

val defaultPackageNameParameter
    get() = stringParameter {
        name = "Package name"
        visible = { !isNewModule }
        default = "com.mycompany.myapp"
        constraints = listOf(Constraint.PACKAGE)
        suggest = { packageName }
    }