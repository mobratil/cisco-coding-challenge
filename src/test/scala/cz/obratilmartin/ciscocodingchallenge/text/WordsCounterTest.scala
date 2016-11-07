package cz.obratilmartin.ciscocodingchallenge.text

import org.scalatest.FlatSpec

class WordsCounterTest extends FlatSpec {

  info("Starting WordsCounterTest...")

  "WordsCounter.countWords" should "produce a count of all the different \"words\" in a text file" in {

    val text = "Scala is cool language and Cisco is best company in the world!"

    val wordsCounter = new WordsCounter()
    val result = wordsCounter.countWords(text)

    val expectedResult = Map(
      "Scala" -> 1,
      "is" -> 2,
      "cool" -> 1,
      "language" -> 1,
      "and" -> 1,
      "Cisco" -> 1,
      "best" -> 1,
      "company" -> 1,
      "in" -> 1,
      "the" -> 1,
      "world" -> 1)

    assert(result == expectedResult)
  }

  "WordsCounter.countWords" should "return empty map for text without words" in {

    val text = "          . ! ... "

    val wordsCounter = new WordsCounter()
    val result = wordsCounter.countWords(text)

    val expectedResult = Map()

    assert(result == expectedResult)
  }

}
