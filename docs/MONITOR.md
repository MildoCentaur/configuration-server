# Spring cloud config server monitor


spring-cloud-config-monitor provides a /monitor endpoint for the Config Server to receive notification events when the properties backed by a Git repository are changed. This will work if and only if spring.cloud.bus property is enabled.