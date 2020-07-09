# Spring cloud config server monitor


spring-cloud-config-monitor provides a /monitor endpoint for the Config Server to receive notification events when the properties backed by a Git repository are changed. This will work if and only if spring.cloud.bus property is enabled.

##Adding the Webhook event with GitHub
You can add the  /monitor endpoint URL as the webhook URL of your repository.  No that, this will not work for localhost domain. You should have a public domain name or public ip address.