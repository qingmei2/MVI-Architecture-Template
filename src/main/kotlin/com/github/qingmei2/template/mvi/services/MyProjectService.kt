package com.github.qingmei2.template.mvi.services

import com.intellij.openapi.project.Project
import com.github.qingmei2.template.mvi.MyBundle

class MyProjectService(project: Project) {

    init {
        println(MyBundle.message("projectService", project.name))
    }
}
