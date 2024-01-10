package com.carrenting.notification;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.socket.config.annotation.*;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.Arrays;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {


    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        config.enableSimpleBroker("/topic");
        config.setApplicationDestinationPrefixes("/app");
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/websocket").setAllowedOrigins("http://127.0.0.1:5500").withSockJS();
    }

    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource(); // Erstellt eine CORS-Konfigurationsquelle basierend auf URL
        CorsConfiguration config = new CorsConfiguration();      // Erstellt ein neues CORS-Konfigurationsobjekt
        config.setAllowCredentials(true);                        // Ermöglicht das Senden von Anmeldeinformationen
        config.setAllowedOriginPatterns(Arrays.asList("http://127.0.0.1:5500/", "http://localhost:5500")); // Definiert erlaubte Ursprünge (Frontend-URLs)
        config.addAllowedHeader("");                            // Erlaubt alle Kopfzeilen
        config.addAllowedMethod("");                            // Erlaubt alle HTTP-Methoden
        source.registerCorsConfiguration("/**", config); // Registriert die CORS-Konfiguration für alle Pfade
        return new CorsFilter(source);                           // Gibt den konfigurierten CORS-Filter zurück
    }
}
