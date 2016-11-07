# cisco-coding-challenge

This project contains answers to questions of Cisco coding challenge. I finished all 3 exercises in scala.
It requires sbt to be installed. Project contains unit tests that covers all 3 exercises, but also contains runnable code. 

For implementation of 1) and 2) I took recursive approach with tailrec optimization for both.

You can run it using sbt:

## 1) walkGraph

`sbt walkGraph`

Prints list of all nodes in graph. By default it takes graph description from `src/main/resources/graph.json`

Custom graph description can be supplied by this command:

`sbt "walkGraph /your/own/path/to/graph.json"`

Implementation is in src/main/scala/cz/obratilmartin/ciscocodingchallenge/graphs/GraphWalker.scala

## 2) paths

`sbt paths`

Prints all possible paths from root node. By default it takes graph description from `src/main/resources/graph.json`

Custom graph description can be supplied by this command:

`sbt "paths /your/own/path/to/graph.json"`

Implementation is in src/main/scala/cz/obratilmartin/ciscocodingchallenge/graphs/GraphWalker.scala

## 3) words count

`sbt countWords`

Prints counts of words in text file. By default it takes text from `src/main/resources/cisco.txt`

Custom text file can be supplied by this command:

`sbt "countWords /your/own/path/to/text.txt"`

Implementation is in `src/main/scala/cz/obratilmartin/ciscocodingchallenge/text/WordsCounter.scala`.
