# Microservices Spring Boot Quiz Application

## Overview

This repository contains a Quiz Application built using Spring Boot, designed to demonstrate both Monolithic and Microservices architectures.

### Monolithic Architecture

The **Monolithic Architecture** version of the Quiz App is structured as a single-tiered software application in which different components of the application are combined into a single program from a single platform. In this version:

- **Backend**: The application is built as a single unit, where all components (Business Logic, Database Access) are tightly coupled and run as a single service.
- **Technology Stack**: Spring Boot, Spring MVC, Spring Data JPA, PostgreSQL.

### Microservices Architecture (Redesigned Version)

The **Microservices Architecture** version of the Quiz App is designed as a collection of small, autonomous services, modeled around a business domain. In this version:

- **Backend**: The application is broken down into multiple services (Question Service and Quiz Service), each running its own process and communicating with lightweight mechanisms (HTTP).
- **Technology Stack**: Spring Boot, Spring Cloud (Service Discovery, Config Server, Feign Client), Spring Data JPA, PostgreSQL

## Features

- **Monolithic Architecture**:
  - Single deployment unit.
  - Simplified development and testing.
  - Easier to deploy initially.
  - Suitable for smaller applications or rapid prototyping.

- **Microservices Architecture**:
  - Independent services enable better scalability.
  - Isolation of concerns, facilitating independent development and deployment.
  - Resilience and fault isolation.
  - Suitable for complex applications needing high scalability and flexibility.
  - Utilizes Load Balancing and API Gateway for enhanced scalability and routing flexibility.
Getting Started

## Getting Started

To get started with either version of the Quiz App, follow the instructions below:

### Prerequisites

- JDK 17 or higher
- Maven
- PostgreSQL
- Docker (for Microservices Architecture)

### Setup

1. **Clone the repository**:
   ```bash
   git clone <repository_url>
   cd spring-boot-quiz-app
   ```

2. **Setup Monolithic Architecture**:
   - Configure database connection in `application.properties`.
   - Run the application using Maven:
     ```bash
     mvn spring-boot:run
     ```

3. **Setup Microservices Architecture**:
   - Navigate to `microservices` directory.
   - Configure service properties (`application.yml`).
   - Build Docker images:
     ```bash
     docker-compose build
     ```
   - Run Docker containers:
     ```bash
     docker-compose up
     ```

## Usage

- Access the application UI at `http://localhost:8080` (Monolithic) or via individual service endpoints (Microservices).
- Explore different quiz functionalities, user management, and result tracking as per the architecture.

## Contributing

Contributions are welcome! Please fork the repository and submit a pull request for any enhancements, bug fixes, or new features.


## Acknowledgments

- This application is built using Spring Boot and demonstrates both Monolithic and Microservices architectures.
- Inspired by the need for scalable and maintainable applications in modern software development.
