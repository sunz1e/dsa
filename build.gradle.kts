plugins {
    id("java")
    id("groovy")
}

group = "dsa"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation("org.spockframework:spock-core:2.4-M4-groovy-4.0")
    implementation("org.apache.groovy:groovy-all:4.0.22")
//    testImplementation(platform("org.junit:junit-bom:5.10.0"))
//    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation("com.fasterxml.jackson.core:jackson-databind:2.17.2")
    implementation("commons-io:commons-io:2.16.1")

}

tasks.test {
    useJUnitPlatform()
}