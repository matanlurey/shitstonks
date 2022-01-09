package xyz.shitstonks;

import com.google.common.flogger.FluentLogger;
import org.javacord.api.DiscordApi;
import org.javacord.api.DiscordApiBuilder;
import org.javacord.api.util.logging.FallbackLoggerConfiguration;

import java.util.concurrent.CompletionException;

final class Shitstonks {
  private static final FluentLogger logger = FluentLogger.forEnclosingClass();

  public static void main(String[] args) {
    FallbackLoggerConfiguration.setDebug(true);

    try {
      DiscordApi discord = new DiscordApiBuilder().setToken("TODO").login().join();
      logger.atInfo().log("Logged in as ID#:%s", discord.getOwnerId());
    } catch (CompletionException e) {
      logger.atSevere().withCause(e).log("Failed to login");
      System.exit(1);
    }
  }
}
