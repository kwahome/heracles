import org.gradle.api.tasks.testing.logging.TestExceptionFormat
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.jetbrains.kotlin.gradle.plugin.KotlinSourceSet
import org.jmailen.gradle.kotlinter.tasks.LintTask

plugins {
	kotlin("jvm") version "1.3.50"
	id("org.jmailen.kotlinter") version "2.1.0"
	jacoco
}

apply(plugin = "kotlin")

group = "heracles-e2e-tests"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11

buildscript {
	repositories {
		gradlePluginPortal()
		mavenCentral()
		jcenter()
	}
	dependencies {
		classpath("org.jetbrains.kotlin:kotlin-gradle-plugin")
	}
}

repositories {
	mavenCentral()
}

val junitVersion = "4.12"
val junitJupiterVersion = "5.6.0-M1"

dependencies {
	// https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-java
	compile("org.seleniumhq.selenium:selenium-java:4.0.0-alpha-3")
	compile("io.github.bonigarcia:webdrivermanager:3.7.1")

	testCompile("junit:junit:${junitVersion}")

	// https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter-engine
	testCompile("org.junit.jupiter:junit-jupiter-engine:${junitJupiterVersion}")
	// https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter-api
	testCompile("org.junit.jupiter:junit-jupiter-api:${junitJupiterVersion}")
}

tasks.test {
	useJUnitPlatform()

	testLogging {
		exceptionFormat = TestExceptionFormat.FULL
	}
}

jacoco {
	toolVersion = "0.8.4"
}

tasks.jacocoTestReport {
	doFirst {

		val list: MutableList<String> = (project.ext.get("generatedFileNames") as MutableList<String>)
		sourceDirectories.setFrom(
				sourceSets.main.get().output.asFileTree.matching {
					// exclude main()
					exclude(list)
				}
		)

		// exclude generated classed
		val excluded: MutableList<String> = mutableListOf()
		list.forEach {
			excluded.add(it.substring(it.indexOf("io/pleo")).replace(".kt", "**"))
		}

		classDirectories.setFrom(
				sourceSets.main.get().output.asFileTree.matching {
					// exclude main()
					exclude(excluded)
				}
		)
	}

	reports {
		val mainSrc = "$rootDir/src/main/kotlin"
		val tree = fileTree("$rootDir/build/classes")

		sourceDirectories.setFrom(mainSrc)
		classDirectories.setFrom(files(tree))
		xml.isEnabled = true
		csv.isEnabled = false
		html.isEnabled = true
		xml.destination = file("$buildDir/reports/coverage/build.xml")
		html.destination = file("$buildDir/reports/coverage")
	}
}

tasks.jacocoTestCoverageVerification {
	doFirst {
		val list: MutableList<String> = (project.ext.get("generatedFileNames")
				as MutableList<String>)
		sourceDirectories.setFrom(
				sourceSets.main.get().output.asFileTree.matching {
					// exclude main()
					exclude(list)
				}
		)

		// exclude generated classed
		val excluded: MutableList<String> = mutableListOf<String>()
		list.forEach {
			excluded.add(it.substring(it.indexOf("io/pleo")).replace(".kt", "**"))
		}

		classDirectories.setFrom(
				sourceSets.main.get().output.asFileTree.matching {
					// exclude main()
					exclude(excluded)
				}
		)
	}
	violationRules {
		rule {
			limit {
				minimum = "0.7".toBigDecimal()
			}
		}
	}
}

val testCoverage by tasks.registering {
	group = "verification"
	description = "Runs the end to end tests with coverage."

	dependsOn(":test", ":jacocoTestReport", ":jacocoTestCoverageVerification")
	val jacocoTestReport = tasks.findByName("jacocoTestReport")
	jacocoTestReport?.mustRunAfter(tasks.findByName("test"))
	tasks.findByName("jacocoTestCoverageVerification")?.mustRunAfter(jacocoTestReport)
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "1.8"
	}
}

