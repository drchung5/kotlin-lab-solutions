plugins {
  application
  kotlin("jvm") version "1.4.31" // Change version according to your needs
}

application {
  mainClassName = "com.custommentoring.Main"
}

repositories {
  jcenter()
}

dependencies {
  compile(kotlin("stdlib"))
}