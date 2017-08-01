val globalSettings = Seq(
  version := "1.0",
  scalaVersion := "2.11.8"
)

(unmanagedClasspath in Compile) += file("lib/tensorflow-prediction-client-1.0-SNAPSHOT.jar")
(unmanagedClasspath in Compile) += file("lib/prometheus-hystrix-2.0.0.jar")

lazy val settings = (project in file("."))
                    .settings(name := "prediction-tensorflow")
                    .settings(globalSettings:_*)
                    .settings(libraryDependencies ++= deps)
        .settings(javaOptions += "-Xmx10G")

val springBootVersion = "1.5.2.RELEASE"
val springCloudVersion = "1.2.6.RELEASE"
val grpcVersion = "1.0.0"
val protobufVersion = "3.0.0"
val prometheusSimpleClientVersion = "0.0.21"
val prometheusSimpleClientHotspotVersion = "0.0.21"
val commonsCompressVersion = "1.13"
val commonsIOVersion = "1.3.2"
val tensorflowVersion = "1.2.0-rc1"

lazy val deps = Seq(
  "io.prometheus" % "simpleclient_hotspot" % prometheusSimpleClientHotspotVersion,
  "io.prometheus" % "simpleclient_spring_boot" % prometheusSimpleClientVersion,
  "org.springframework.boot" % "spring-boot-starter-web"   % springBootVersion,
  "org.springframework.boot" % "spring-boot-starter-actuator" % springBootVersion,
  "org.springframework.cloud" % "spring-cloud-starter-hystrix" % springCloudVersion,
//  "io.fabric8" % "spring-cloud-starter-kubernetes-netflix" % "0.1.6",
//  "io.fabric8" % "kubernetes-client" % "2.2.2",
  "org.apache.httpcomponents" % "httpclient" % "4.5.3",
  "org.springframework.cloud" % "spring-cloud-starter-zuul" % springCloudVersion,
  "org.springframework.boot" % "spring-boot-starter-web" % springBootVersion,
  "org.scala-lang.modules" %% "scala-parser-combinators" % "1.0.4",
  "io.grpc" % "grpc-netty" % grpcVersion,
  "io.grpc" % "grpc-protobuf" % grpcVersion,
  "io.grpc" % "grpc-stub" % grpcVersion,
  "com.google.protobuf" % "protobuf-java" % protobufVersion,
  "org.apache.commons" % "commons-compress" % commonsCompressVersion,
  "org.apache.commons" % "commons-io" % commonsIOVersion,
  "org.tensorflow" % "tensorflow" % tensorflowVersion
)
