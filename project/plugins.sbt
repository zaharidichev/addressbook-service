logLevel := sbt.Level.Info

// Plugin for code formatting:
addSbtPlugin("com.geirsson" % "sbt-scalafmt" % "0.6.3")

// Plugin for checking code style:
addSbtPlugin("org.scalastyle" %% "scalastyle-sbt-plugin" % "0.8.0")

addSbtPlugin("com.eed3si9n" % "sbt-assembly" % "0.13.0")
