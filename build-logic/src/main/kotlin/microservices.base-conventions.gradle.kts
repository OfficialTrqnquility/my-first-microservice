import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    `java-library`
    id("org.springframework.boot")
    id("io.spring.dependency-management")
    kotlin("jvm")
}


group = "me.trqnquility"
version = "0.0.1-SNAPSHOT"

repositories {
    mavenCentral()
}

extra["springCloudVersion"] = "2021.0.0"

dependencies {
    implementation("org.springframework.boot:spring-boot-starter")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
}

dependencyManagement {
    imports {
        mavenBom("org.springframework.cloud:spring-cloud-dependencies:${property("springCloudVersion")}")
    }
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "11"
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}