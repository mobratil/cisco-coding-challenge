package cz.obratilmartin.ciscocodingchallenge

import com.fasterxml.jackson.databind.{DeserializationFeature, ObjectMapper}
import com.fasterxml.jackson.module.scala.DefaultScalaModule
import com.fasterxml.jackson.module.scala.experimental.ScalaObjectMapper
import cz.obratilmartin.ciscocodingchallenge.graphs.{GNodeImpl, GraphWalkerRecursive}
import cz.obratilmartin.ciscocodingchallenge.text.WordsCounter

import scala.io.Source

object WalkGraph extends App {
  val data =  if (args.isEmpty) DataLoader.loadFromResources("/graph.json")
              else DataLoader.loadFromfileSystem(args(0))

  var gNode = DataLoader.deserialize(data)

  val graphWalker = new GraphWalkerRecursive()

  var result = graphWalker.walkGraph(gNode).map(_.getName).mkString("( ", " ", " )")

  println(result)
}

object Paths extends App {
  val data =  if (args.isEmpty) DataLoader.loadFromResources("/graph.json")
              else DataLoader.loadFromfileSystem(args(0))

  var gNode = DataLoader.deserialize(data)

  val graphWalker = new GraphWalkerRecursive()

  var result = graphWalker.paths(gNode)
    .map(path => path.map(_.getName).mkString("( ", " ", " )"))
    .mkString("( ", " ", " )")

  println(result)
}

object CountWords extends App {
  val text =  if (args.isEmpty) DataLoader.loadFromResources("/cisco.txt")
              else DataLoader.loadFromfileSystem(args(0))

  val wordsCounter = new WordsCounter()

  wordsCounter.countWords(text).foreach((wordCount) => {
    println(s"${wordCount._1} ${wordCount._2}")
  })
}

object DataLoader {

  def loadFromResources(path: String) = {
    Source.fromURL(getClass.getResource(path)).mkString
  }

  def loadFromfileSystem(path: String) = {
    Source.fromFile(path).mkString
  }

  def deserialize(json: String) = {

    val mapper = new ObjectMapper() with ScalaObjectMapper
    mapper.registerModule(DefaultScalaModule)
    mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)

    mapper.readValue[GNodeImpl](json)
  }
}
