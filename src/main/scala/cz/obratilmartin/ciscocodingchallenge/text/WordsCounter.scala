package cz.obratilmartin.ciscocodingchallenge.text

import scala.collection.immutable.ListMap
import scala.util.matching.Regex

class WordsCounter {
  def countWords(input: String): Map[String, Int] = {
    val counts = WordsCounter.pattern.findAllMatchIn(input)
      .map(_.matched)
      .toSeq
      .groupBy(identity)
      .toSeq
      .map(x => (x._1, x._2.size))
      .sortBy(c => c._2)
      .reverse

    new ListMap() ++ counts
  }
}

object WordsCounter {
  val pattern = new Regex("""\b[A-Za-z0-9]+\b""")
}
