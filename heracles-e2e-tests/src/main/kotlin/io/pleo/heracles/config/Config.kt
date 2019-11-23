package io.pleo.heracles.config

object Config {
    val HERACLES_HOST: String = System.getenv("HERACLES_HOST") ?: "http://localhost:3000"
}
