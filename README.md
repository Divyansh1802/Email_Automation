# Email_Automation
A Spring Boot microservices-based AI email automation system using Eureka for service discovery, centralized Config Server, OTP authentication, Gemini-powered email generation, and SMTP-based email delivery.

#  AI Email Automation Platform (Microservices)

The **AI Email Automation Platform** is a secure, scalable, and cloud-ready microservices-based application built using **Spring Boot** and **Spring Cloud**. The platform automates professional email generation and delivery using **AI-powered content generation** while ensuring strong security through **OTP-based authentication**.

---

## Overview

This system enables users to log in securely using a one-time password (OTP). Once authenticated, users can provide natural language prompts to generate professional emails powered by the **Gemini API**. Generated emails can be copied or sent directly to recipients through the platform, with the logged-in user automatically added to **CC**.

The application follows a **microservices architecture**, where each service is independently deployable, containerized using **Docker**, and orchestrated using **Docker Compose**.

---

##  Microservices Architecture

All services are registered with **Eureka Service Discovery**, enabling dynamic service-to-service communication without hard-coded URLs.

### Services Included:
- **User Service** – Handles user authentication and OTP verification
- **AI Service** – Generates email content using the Gemini API
- **Email Service** – Sends emails via SMTP and manages CC functionality
- **Config Server** – Centralized external configuration management
- **Eureka Server** – Service registration and discovery

---

## Authentication Flow

1. User initiates login
2. OTP is generated and sent to the user's email
3. User verifies OTP
4. Access is granted upon successful verification

This approach eliminates password management and enhances security.

---

##  AI Email Generation

The **AI Service** integrates with the **Gemini API** to generate context-aware, professional emails.  
Users can provide prompts describing tone, purpose, or content requirements, and the AI generates a structured email draft accordingly.

---

## Email Automation

Using the **Email Service**, users can:
- Copy the generated email content
- Send emails directly from the platform
- Automatically include themselves in **CC** for transparency and record-keeping

---

##  Centralized Configuration

The **Spring Cloud Config Server** manages:
- API keys (Gemini, SMTP)
- Database configurations
- Environment-specific properties

Configurations are externalized and can be updated without rebuilding services.

---

##  Docker & Docker Compose

All microservices are **fully Dockerized** and managed using **Docker Compose**, enabling:
- Easy local setup
- Consistent environments
- One-command startup for all services

Each service runs in its own container and communicates via Eureka.

---

##  Key Features

- OTP-based secure authentication
- AI-powered email generation
- Automated email sending with CC support
- Microservices architecture with Eureka
- Centralized configuration using Config Server
- Fully Dockerized and Docker Compose–orchestrated
- Cloud-native and scalable design

---

##  Tech Stack

- **Backend:** Spring Boot, Spring Cloud
- **Service Discovery:** Eureka
- **Configuration:** Spring Cloud Config Server
- **AI Integration:** Gemini API
- **Email:** SMTP
- **Containerization:** Docker, Docker Compose
- **Database:** MongoDB / PostgreSQL (as applicable)

---

##  Future Enhancements

- JWT-based authorization
- API Gateway integration
- Rate limiting and monitoring
- Kubernetes deployment
- Email templates and scheduling

---

Developed by **Divyansh Upadhyay**


