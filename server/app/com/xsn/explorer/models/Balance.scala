package com.xsn.explorer.models

import play.api.libs.json._

case class Balance(
    address: Address,
    received: BigDecimal = BigDecimal(0),
    spent: BigDecimal = BigDecimal(0)) {

  def available: BigDecimal = received - spent
}

object Balance {
  implicit val writes: Writes[Balance] = Writes { obj =>
    val values = Map(
      "address" -> JsString(obj.address.string),
      "received" -> JsNumber(obj.received),
      "spent" -> JsNumber(obj.spent),
      "available" -> JsNumber(obj.available))

    JsObject.apply(values)
  }
}
