package ba.sake.scalarizmi

import org.scalatest.matchers.should.Matchers
import org.scalatest.flatspec.AnyFlatSpec

object TestUtils {
    type FlatSpec = AnyFlatSpec

    export Matchers.*
}