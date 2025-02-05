plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("android.extensions")
}

buildscript {
    repositories {
        jcenter()
    }

    dependencies {
        classpath(Libs.com_jfrog_bintray_gradle_bintray_plugin)
    }
}
apply(plugin = Libs.maven_publish)

android {
    compileSdkVersion(AndroidConstants.compileSdkVersions)

    defaultConfig {
        minSdkVersion(AndroidConstants.minSdkVersion)
        targetSdkVersion(AndroidConstants.targetSdkVersion)
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation(Libs.gson)
}

afterEvaluate {
    configure<PublishingExtension> {
        val artifact = "charts"
        val publishedGroupId = "com.github.aachartmodel.aainfographics"
        val libraryName = "AAChartCore-Kotlin"

        publications {
            create<MavenPublication>("maven") {
                groupId = publishedGroupId
                artifactId = artifact
                version = "1.0.0"

                artifact(tasks.getByName("sourcesJar"))
                artifact("$buildDir/outputs/aar/${artifactId}-release.aar") {
                    builtBy(tasks.getByName("assemble"))
                }

                pom {
                    packaging = "aar"
                    name.set(libraryName)
                    licenses {
                        license {
                            name.set("The Apache Software License, Version 2.0")
                            url.set("http://www.apache.org/licenses/LICENSE-2.0.txt")
                        }
                    }
                    withXml {
                        val dependenciesNode = asNode().appendNode("dependencies")
                        // note: replace with the desired configuration (ex: api, testImplementation, etc...)
                        configurations.getByName("implementation") {
                            dependencies.forEach {
                                val dependencyNode = dependenciesNode.appendNode("dependency")
                                dependencyNode.appendNode("groupId", it.group)
                                dependencyNode.appendNode("artifactId", it.name)
                                dependencyNode.appendNode("version", it.version)
                            }
                        }
                    }
                }
            }
        }
        repositories {
            val snapshotsRepoUrl = "https://packages.aliyun.com/maven/repository/2165096-snapshot-AufPz5"
            val releasesRepoUrl = "https://packages.aliyun.com/maven/repository/2165096-release-Gdw2DJ/"
            maven {
                url = uri(if (version.toString().endsWith("SNAPSHOT")) snapshotsRepoUrl else releasesRepoUrl)
                credentials{
                    username = "621d91150bc6f416e0e91d13"
                    password = "kZ-hBCgueJ4e"
                }
            }
        }

    }
}

val sourcesJar by tasks.registering(Jar::class) {
    archiveClassifier.set("sources")
    from(android.sourceSets.getByName("main").java.srcDirs)
}