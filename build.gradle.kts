import net.ltgt.gradle.errorprone.errorprone

plugins {
    application
    java
    idea
    id("net.ltgt.errorprone") version "2.0.2"
    id("com.github.sherter.google-java-format") version "0.9"
}

group = "xyz.shitstonks"
version = "0.1.0"

repositories {
    mavenCentral()
}

dependencies {
    compileOnly("com.google.auto.value:auto-value-annotations:1.9")

    implementation("com.google.flogger:flogger:0.7.4")
    implementation("com.google.flogger:flogger-log4j2-backend:0.7.4")
    implementation("com.google.flogger:flogger-system-backend:0.7.4")
    implementation("com.google.code.gson:gson:2.8.9")
    implementation("com.google.guava:guava:31.0.1-jre")
    implementation("com.google.inject:guice:5.0.1")
    implementation("info.picocli:picocli:4.6.2")
    implementation("org.apache.logging.log4j:log4j-core:2.17.0")
    implementation("org.javacord:javacord:3.3.2")

    annotationProcessor("info.picocli:picocli-codegen:4.6.2")
    annotationProcessor("com.google.auto.value:auto-value:1.9")

    errorprone("com.google.errorprone:error_prone_core:2.10.0")

    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.2")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
    testImplementation("com.google.testparameterinjector:test-parameter-injector:1.7")
    testImplementation("com.google.truth:truth:1.1.3")
}

tasks.test {
    useJUnit()
}

tasks.withType<JavaCompile>().configureEach {
    options.errorprone.disableWarningsInGeneratedCode.set(true)
}

application {
    mainClass.set("xyz.shitstonks.Shitstonks")
}
