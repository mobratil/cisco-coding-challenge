name := "cisco-coding-challenge"

version := "1.0"

scalaVersion := "2.11.8"

libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.0" % "test"

// https://mvnrepository.com/artifact/com.fasterxml.jackson.module/jackson-module-scala_2.11
libraryDependencies += "com.fasterxml.jackson.module" % "jackson-module-scala_2.11" % "2.8.3"

commands += Command.args("walkGraph", "<args>") { (state, args) =>
  s"run-main cz.obratilmartin.ciscocodingchallenge.WalkGraph" :: state
}

commands += Command.args("paths", "<args>") { (state, args) =>
  s"run-main cz.obratilmartin.ciscocodingchallenge.Paths" :: state
}

commands += Command.args("countWords", "<args>") { (state, args) =>
  s"run-main cz.obratilmartin.ciscocodingchallenge.CountWords" :: state
}






    