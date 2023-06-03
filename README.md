# Keepstrong-Rates

# Table of Contents
1. [Overview](#overview)
2. [Requirements](#requirements)
3. [Usage](#usage)
4. [License](#license)

## Overview

The Rating Service in the [keepstrong-delivery](https://github.com/rsvinicius/keepstrong-delivery) project is responsible for listening to events related to review and rating updates. It acts as a listener for a RabbitMQ fanout exchange, which broadcasts events to multiple services. This service does not expose any API endpoints since it focuses solely on consuming events and performing necessary actions based on the received data.

**Please note that this is a sample implementation without actual business logic. Modify the implementation of this service to process review and rating events according to your specific requirements.**

## Requirements

To successfully set up and run the Delivery Project, the following requirements must be met:
- Java 17+
- RabbitMQ
- Eureka Server
- Eureka Gateway
- IntelliJ IDEA / Netbeans / Eclipse

## Usage

Please make sure to refer to the [keepstrong-delivery](https://github.com/rsvinicius/keepstrong-delivery) documentation for detailed instructions on how to set up and start the service successfully.

## License

The Project is licensed under the MIT License, promoting open-source collaboration and allowing users to utilize, modify, and distribute the project with minimal restrictions. This license fosters transparency and encourages the growth of open-source software.