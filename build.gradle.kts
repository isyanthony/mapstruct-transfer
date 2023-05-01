plugins {
    id("java")
    id("org.jetbrains.kotlin.jvm") version "1.7.20"
    id("org.jetbrains.intellij") version "1.13.1"
//  id("org.jetbrains.kotlin:kotlin-compiler") version "1.8.20"
}

tasks {
    buildSearchableOptions {
        enabled = false
    }
    compileJava {
        options.encoding = "UTF-8"
    }
    compileTestJava {
        options.encoding = "UTF-8"
    }
}

group = "cn.isyanthony"
version = "1.0-SNAPSHOT"

repositories {
    maven("https://maven.aliyun.com/repository/public")
    mavenCentral()
}

dependencies {
//  plugins.apply("com.intellij.java")
//  plugins.apply("com.intellij.modules.lang")
    compileOnly("org.projectlombok:lombok:1.18.26")
    annotationProcessor("org.projectlombok:lombok:1.18.26")
    implementation("org.projectlombok:lombok:1.18.26")
    implementation("ch.qos.logback:logback-classic:1.4.6")
    implementation("ch.qos.logback:logback-core:1.4.6")
    implementation("org.slf4j:slf4j-api:2.0.7")

}
// Configure Gradle IntelliJ Plugin
// Read more: https://plugins.jetbrains.com/docs/intellij/tools-gradle-intellij-plugin.html
intellij {
    version.set("2022.2.4")
    type.set("IC") // Target IDE Platform

    plugins.set(listOf(/* Plugin Dependencies */))
}

tasks {
    // Set the JVM compatibility versions
    withType<JavaCompile> {
        sourceCompatibility = "17"
        targetCompatibility = "17"
    }
    withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        kotlinOptions.jvmTarget = "17"
    }

    patchPluginXml {
        sinceBuild.set("222")
        untilBuild.set("232.*")
    }


//  signPlugin {
//    certificateChain.set(System.getenv("CERTIFICATE_CHAIN"))
//    privateKey.set(System.getenv("PRIVATE_KEY"))
//    password.set(System.getenv("PRIVATE_KEY_PASSWORD"))
//  }
//
//  publishPlugin {
//    token.set(System.getenv("PUBLISH_TOKEN"))
//  }
}
