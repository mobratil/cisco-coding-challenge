package cz.obratilmartin.ciscocodingchallenge.graphs

import com.fasterxml.jackson.databind.annotation.JsonDeserialize

@JsonDeserialize(as=classOf[GNodeImpl])
trait GNode {
  def getName: String
  def getChildren: List[GNode]
}

case class GNodeImpl(name: String, children: List[GNode]) extends GNode {
  override def getName: String = name
  override def getChildren: List[GNode] = children

  override def toString: String = name
}

object GNode {
  def apply(name: String): GNode = apply(name, List())
  def apply(name: String, children: List[GNode]): GNode = GNodeImpl(name, children)
}