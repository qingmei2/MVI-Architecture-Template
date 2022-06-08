package other.mvi

import com.android.tools.idea.wizard.template.Template
import com.android.tools.idea.wizard.template.WizardTemplateProvider
import other.mvi.activity.mviActivityTemplate

class PluginTemplateProviderImpl : WizardTemplateProvider() {
    override fun getTemplates(): List<Template> = listOf(
        // activity的模板
        mviActivityTemplate,
        // fragment的模板
//        mviFragmentTemplate
    )
}