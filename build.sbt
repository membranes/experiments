ThisBuild / version := "0.1.0-SNAPSHOT"
ThisBuild / scalaVersion := "2.12.18"


lazy val root = (project in file(".")).
  enablePlugins(SbtPlugin).
  settings(
    name := "experiments",
    idePackagePrefix := Some("pattern.intelligence"),

    resolvers ++= Seq(
	  "Maven Central" at "https://repo1.maven.org/maven2/",
	  "Artima Maven Repository" at "https://repo.artima.com/releases",
	  "JBoss Enterprise Maven Repository" at "https://maven.repository.redhat.com/ga/",
    "Sonatype OSS Snapshots" at "https://oss.sonatype.org/content/repositories/snapshots"
    ),

    assembly / mainClass := Some("ExperimentsApp"),

    libraryDependencies ++= Seq(
      "org.apache.spark" % "spark-sql_2.12" % "3.5.1" % "compile",
      "com.typesafe" % "config" % "1.4.3",
      "joda-time" % "joda-time" % "2.12.7",
      "org.joda" % "joda-convert" % "2.2.3",
      "org.apache.logging.log4j" % "log4j-core" % "2.23.1",
      "org.apache.logging.log4j" % "log4j-api" % "2.23.1",
      "software.amazon.awssdk" % "s3" % "2.25.43",
      "software.amazon.awssdk" % "sts" % "2.25.43",
      "software.amazon.awssdk" % "aws-sdk-java" % "2.25.43" % "provided",
      "software.amazon.awssdk" % "url-connection-client" % "2.25.43",
      "software.amazon.awssdk" % "apache-client" % "2.25.43" % Test,
      "software.amazon.awssdk" % "ssooidc" % "2.25.43",
      "software.amazon.awssdk" % "sso" % "2.25.43",
      "software.amazon.awssdk" % "regions" % "2.25.43",
      "org.slf4j" % "slf4j-api" % "2.0.13",
      "org.slf4j" % "slf4j-simple" % "2.0.13" % Test,
      "org.slf4j" % "jcl-over-slf4j" % "2.0.13",
      "commons-io" % "commons-io" % "2.16.1",
	    "com.fasterxml.jackson.core" % "jackson-core" % "2.17.0",
      "com.fasterxml.jackson.core" % "jackson-annotations" % "2.17.0",
      "com.fasterxml.jackson.core" % "jackson-databind" % "2.17.0",
      "org.scalatest" %% "scalatest" % "3.3.0-SNAP4",
      "org.scalactic" %% "scalactic" % "3.3.0-SNAP4"
    ),

    buildInfoKeys := Seq[BuildInfoKey](name, version, scalaVersion, sbtVersion),
    buildInfoPackage := "buildInfoText"

  )

ThisBuild / assemblyMergeStrategy := {
  case PathList("META-INF", _*) => MergeStrategy.discard
  case x => MergeStrategy.first
}
