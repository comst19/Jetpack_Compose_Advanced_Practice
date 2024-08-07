pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "FastcampusSNS"
include(":app")
include(":domain")
include(":presentation")
include(":data")
include(":assistedinjection")
include(":hltextensionapp")
include(":annotations")
include(":compiler")
include(":DynamicFeature")
