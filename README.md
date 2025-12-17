# Java Labs Repository

This repository contains a collection of Java laboratory works.  
Each lab is stored in a separate directory (`Lab_1`, `Lab_2`, …) with its own entry point (`App.java`).  
The project is built and run using **Gradle**.

---

## Project Structure

```
.
├── Lab_1/
│   └── src/main/java/lab_1/task/App.java
├── Lab_2/
│   └── src/main/java/lab_2/task/App.java
├── Lab_3/
│   └── src/main/java/lab_3/task/App.java
├── Lab_4/
│   └── src/main/java/lab_4/task/App.java
├── Lab_5/
│   └── src/main/java/lab_5/task/App.java
├── Lab_6/
│   └── src/main/java/lab_6/task/App.java
├── build.gradle
├── settings.gradle
└── gradlew
```

---

## Build & Run

### Build all labs
```bash
./gradlew build
```

### Run a specific lab
```bash
./gradlew :Lab_1:run
./gradlew :Lab_2:run
```

### Clean build files
```bash
./gradlew clean
```

---

## Purpose
The repository is created for educational purposes:  
- practicing Java programming  
- learning Gradle build system  
- organizing code in multi-module projects  

---

## Requirements
- [OpenJDK 25](https://jdk.java.net/25)  
- [Gradle 9.1.0](https://gradle.org/install/)

