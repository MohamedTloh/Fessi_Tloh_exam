package config

import scopt.OParser

object Config {
  case class Config(
                     idClient: Int = -1,
                     filepath: String = " ",
                     finalpath: String = " "
                   )
  val builder = OParser.builder[Config]
  val argParser = {
    import builder._
    OParser.sequence(
      programName("Clientprog"),
      head("Client", "0.1"),
      opt[Int]('i', " idClient")
        .required()
        .action((i, c) => c.copy( idClient = i))
        .text("required integer"),
      opt[String]('o', "filepath")
        .required()
        .action((o, c) => c.copy( filepath = o))
        .text("required string"),
      opt[String]('f', "finalpath")
        .required()
        .action((f, c) => c.copy(finalpath = f))
        .text("required string"))

  }
}

