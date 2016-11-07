package cz.obratilmartin.ciscocodingchallenge.graphs

import org.scalatest.FlatSpec

class GraphWalkerTest extends FlatSpec {

  info("Starting GraphWalkerTest...")

  val F = GNode("F")
  val E = GNode("E")
  val D = GNode("D", List(E, F))
  val C = GNode("C")
  val B = GNode("B")
  val A = GNode("A", List(B, C, D))

  "GraphWalkerRecursive.walkGraph" should "return a List containing every GNode in the graph" in {

    val graphWalker = new GraphWalkerRecursive
    val result = graphWalker.walkGraph(A)

    assert(result == List(A, B, C, D, E, F))
  }

  "GraphWalkerRecursive.walkGraph" should "return a single item list for one node graph" in {

    val singleNodeGraph = GNode("X")

    val graphWalker = new GraphWalkerRecursive
    val result = graphWalker.walkGraph(singleNodeGraph)

    assert(result == List(singleNodeGraph))
  }

  "GraphWalkerRecursive.paths" should "return a List of Lists, representing all possible paths through the graph starting at 'node'." in {

    val graphWalker = new GraphWalkerRecursive
    val result = graphWalker.paths(A)

    assert(result == List(
        List(A, B),
        List(A, C),
        List(A, D, E),
        List(A, D, F)
      )
    )
  }

  "GraphWalkerRecursive.paths" should "return empty list for single node graph" in {

    val graphWalker = new GraphWalkerRecursive
    val result = graphWalker.paths(GNode("X"))

    assert(result == List())
  }

}
