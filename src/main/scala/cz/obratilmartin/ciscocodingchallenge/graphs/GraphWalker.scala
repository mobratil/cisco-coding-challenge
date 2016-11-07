package cz.obratilmartin.ciscocodingchallenge.graphs

import scala.annotation.tailrec

trait GraphWalker {
  def walkGraph(node: GNode): List[GNode]
  def paths(node: GNode): List[List[GNode]]
}


class GraphWalkerRecursive extends GraphWalker {
  def walkGraph(node: GNode): List[GNode] = {
    walkGraphInternal(List(node)).reverse
  }

  @tailrec
  private def walkGraphInternal(nextNodes: List[GNode], accumulator: List[GNode] = List()): List[GNode] = {
    if (nextNodes.isEmpty) accumulator
    else walkGraphInternal(nextNodes.head.getChildren ::: nextNodes.tail, nextNodes.head :: accumulator)
  }



  def paths(node: GNode): List[List[GNode]] = {
    if (node.getChildren.isEmpty) List()
    else pathsInternal(List(List(node)))
  }

  @tailrec
  private def pathsInternal(nextPaths: List[List[GNode]], accumulator: List[List[GNode]] = List()): List[List[GNode]] = {
    if (nextPaths.isEmpty) accumulator.reverse
    else {
      val nextPath = nextPaths.head
      if (nextPath.head.getChildren.isEmpty) {
        pathsInternal(
          nextPaths.tail,
          nextPaths.head.reverse :: accumulator)
      }
      else {
        pathsInternal(
          nextPath.head.getChildren.map(c => c :: nextPath) ::: nextPaths.tail,
          accumulator)
      }
    }
  }
}