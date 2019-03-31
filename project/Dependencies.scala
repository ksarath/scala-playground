import sbt._

object Dependencies {

  /** Core dependencies */
  val CatsVersion           = "1.6.0"
  val CatsEffectVersion     = "1.2.0"
  val FS2Version            = "1.0.2"

  /** Platform dependencies */
  val Http4sVersion         = "0.19.0"
  val DoobieVersion         = "0.6.0"
  val CirceVersion          = "0.11.0"
  val PureConfigVersion     = "0.10.1"
  val LogbackVersion        = "1.2.3"
  val akkaVersion           = "2.5.21"

  /** Test dependencies */
  val ScalaTestVersion      = "3.0.5"
  val ScalaMockVersion      = "4.1.0"
  val H2Version             = "1.4.197"
  val FlywayVersion         = "5.2.4"

  val coreDependencies = Seq(
    "org.typelevel"         %% "cats-core"              % CatsVersion,
    "org.typelevel"         %% "cats-macros"            % CatsVersion,
    "org.typelevel"         %% "cats-effect"            % CatsEffectVersion,
  )

  val platformDependencies = Seq(
    "org.postgresql"        %  "postgresql"             % "42.2.5",
    "org.http4s"            %% "http4s-blaze-server"    % Http4sVersion,
    "org.http4s"            %% "http4s-circe"           % Http4sVersion,
    "org.http4s"            %% "http4s-dsl"             % Http4sVersion,
    "co.fs2"                %% "fs2-core"               % FS2Version,
    "co.fs2"                %% "fs2-io"                 % FS2Version,
    "co.fs2"                %% "fs2-reactive-streams"   % FS2Version,
    "co.fs2"                %% "fs2-experimental"       % FS2Version,
    "org.tpolecat"          %% "doobie-core"            % DoobieVersion,
    "org.tpolecat"          %% "doobie-h2"              % DoobieVersion,
    "org.tpolecat"          %% "doobie-hikari"          % DoobieVersion,
    "org.tpolecat"          %% "doobie-postgres"        % DoobieVersion,
    "org.flywaydb"          %  "flyway-core"            % FlywayVersion,
    "io.circe"              %% "circe-generic"          % CirceVersion,
    "com.github.pureconfig" %% "pureconfig"             % PureConfigVersion,
    "ch.qos.logback"        %  "logback-classic"        % LogbackVersion,
    "com.typesafe.akka"     %% "akka-actor"             % akkaVersion,
    "com.typesafe.akka"     %% "akka-cluster"           % akkaVersion,
    "com.typesafe.akka"     %% "akka-cluster-sharding"  % akkaVersion
  )

  val testDependencies = Seq(
    "org.scalatest"         %% "scalatest"              % ScalaTestVersion  % "it,test",
    "org.scalamock"         %% "scalamock"              % ScalaMockVersion  % "test",
    "org.http4s"            %% "http4s-blaze-client"    % Http4sVersion     % "it,test",
    "com.h2database"        %  "h2"                     % H2Version         % "it,test",
    "io.circe"              %% "circe-literal"          % CirceVersion      % "it,test",
    "io.circe"              %% "circe-optics"           % CirceVersion      % "it",
    "org.tpolecat"          %% "doobie-specs2"          % DoobieVersion     % "test",
    "org.tpolecat"          %% "doobie-scalatest"       % DoobieVersion     % "test",
    "com.typesafe.akka"     %% "akka-testkit"           % akkaVersion       % "test"
  )
}
