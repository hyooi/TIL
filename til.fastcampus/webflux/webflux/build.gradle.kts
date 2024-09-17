import org.gradle.api.internal.tasks.compile.CompileJavaBuildOperationType

plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("io.netty:netty-all:4.1.113.Final")
    implementation("org.springframework.boot:spring-boot-starter-webflux:3.3.3")
    implementation("org.springframework.boot:spring-boot-starter-actuator:3.3.3")
    implementation("org.springframework.boot:spring-boot-starter-mustache:3.3.3")

    compileOnly("org.projectlombok:lombok:1.18.30")
    annotationProcessor("org.projectlombok:lombok:1.18.30")

    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testCompileOnly("org.projectlombok:lombok:1.18.30")
    testAnnotationProcessor("org.projectlombok:lombok:1.18.30")
}

tasks.test {
    useJUnitPlatform()
}