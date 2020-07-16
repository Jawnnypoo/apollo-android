import com.android.build.gradle.BaseExtension
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

apply(plugin = "com.android.library")
apply(plugin = "com.apollographql.apollo")
apply(plugin = "kotlin-android")

extensions.findByType(BaseExtension::class.java)!!.apply {
    compileSdkVersion(groovy.util.Eval.x(project, "x.androidConfig.compileSdkVersion").toString().toInt())

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    defaultConfig {
        minSdkVersion(groovy.util.Eval.x(project, "x.androidConfig.minSdkVersion").toString())
        targetSdkVersion(groovy.util.Eval.x(project, "x.androidConfig.targetSdkVersion").toString())
    }
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}

dependencies {
    add("implementation", "com.apollographql.apollo:apollo-android-support")
    add("implementation", "com.apollographql.apollo:apollo-runtime")
    add("implementation", groovy.util.Eval.x(project, "x.dep.kotlin.stdLib"))
}

configure<com.apollographql.apollo.gradle.api.ApolloExtension> {
    generateKotlinModels.set(true)
}
