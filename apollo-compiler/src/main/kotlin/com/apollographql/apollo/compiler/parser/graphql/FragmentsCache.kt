package com.apollographql.apollo.compiler.parser.graphql

import com.apollographql.apollo.compiler.ir.Fragment

object FragmentsCache  {
  val fragments = mutableListOf<Fragment>()
}
