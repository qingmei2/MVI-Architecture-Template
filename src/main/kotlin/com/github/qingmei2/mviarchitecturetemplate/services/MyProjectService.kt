package com.github.qingmei2.mviarchitecturetemplate.services

import com.intellij.openapi.project.Project
import com.github.qingmei2.mviarchitecturetemplate.MyBundle

class MyProjectService(project: Project) {

    init {
        println(MyBundle.message("projectService", project.name))
    }
}
