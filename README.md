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


## Outputs

<details><summary>./gradlew test (contains all the tests)</summary>

```sh
> ./gradlew test      
Calculating task graph as configuration cache cannot be reused because file 'Lab_2\build.gradle' has changed.

BUILD SUCCESSFUL in 1s
8 actionable tasks: 8 up-to-date
```

</details>

<details><summary>./gradlew build (contains all the builds)</summary>

```sh
> ./gradlew build
Calculating task graph as configuration cache cannot be reused 
because file 'Lab_2\build.gradle' has changed.

BUILD SUCCESSFUL in 2s
32 actionable tasks: 12 executed, 20 up-to-date
Configuration cache entry stored.
```

</details>

<details><summary>./gradlew run (contains all the runs)</summary>

```sh
> ./gradlew :Lab_1:run
Calculating task graph as no cached configuration is available for tasks: :Lab_1:run

> Task :Lab_1:run
========================================
           Matrix Lab Output
========================================
Student Number: 4
C5: 4
C7: 4
C11: 4
========================================

========== Matrix A ==========
    2.6770    -6.4573    -4.0876
    4.7297     5.1048     5.1464
    2.9451     9.7313    -6.7003

========== Matrix B ==========
    3.6279    -9.3174     8.3856
   -3.9862    -7.4401    -6.3278
    5.9205     9.6657    -9.3105 

========== C = AB (matrix product) ==========
   11.2511   -16.4097   101.3669
   27.2793   -32.3047   -40.5570
  -67.7764  -164.6060    25.5016

========== Result of operation C11 ==========
Sum of max in even rows + min in odd rows: 86.3115
========================================

BUILD SUCCESSFUL in 1s
2 actionable tasks: 1 executed, 1 up-to-date
Configuration cache entry stored.
> ./gradlew :Lab_2:run
Reusing configuration cache.

> Task :Lab_2:run
Enter a string:
75% EXECUTING [11s]
You ve printed following string: Hello, I am the one

Word occurrences:
Hello: 1
world: 0
test: 0

Switch first and last word:
one, I am the Hello

BUILD SUCCESSFUL in 12s
2 actionable tasks: 1 executed, 1 up-to-date
Configuration cache entry reused.
> ./gradlew :Lab_3:run
Calculating task graph as no cached configuration is available for tasks: :Lab_3:run

> Task :Lab_3:run
Sorted by age (ascending), then health (descending):
Alice - Age: 25, Health: 80
Sam - Age: 28, Health: 120
John - Age: 30, Health: 100
Eve - Age: 35, Health: 90
Bob - Age: 40, Health: 60

Identical NPC found: Alice

BUILD SUCCESSFUL in 1s
2 actionable tasks: 1 executed, 1 up-to-date
Configuration cache entry stored.
> ./gradlew :Lab_4:run
Calculating task graph as no cached configuration is available for tasks: :Lab_4:run

> Task :Lab_4:run
Normalized text:
Hello ,world! This .is a test How ?are you test

Sentences:
Hello ,world!
This .is a test
How ?are you
test

Words in first sentence:
Hello
world

Punctuations in first sentence:
,
!

Word count: 10

First sentence after switching first and last word:
world ,Hello!

Word occurrences:
Hello: 1
world: 1
test: 2

BUILD SUCCESSFUL in 1s
2 actionable tasks: 1 executed, 1 up-to-date
Configuration cache entry stored.
> ./gradlew :Lab_5:run
Calculating task graph as no cached configuration is available for tasks: :Lab_5:run

> Task :Lab_5:run
Total taxi park cost: 137000.00
Cars sorted by fuel consumption:
Ford Fiesta: price=18000.00, fuel=5.9, speed=190
BMW 3 Series: price=35000.00, fuel=6.8, speed=240
Toyota Camry: price=25000.00, fuel=7.5, speed=210
Kia Sportage: price=27000.00, fuel=7.9, speed=195
Honda CR-V: price=32000.00, fuel=8.2, speed=200
Cars with speed in range [195, 220]:
Toyota Camry: price=25000.00, fuel=7.5, speed=210
Kia Sportage: price=27000.00, fuel=7.9, speed=195
Honda CR-V: price=32000.00, fuel=8.2, speed=200

BUILD SUCCESSFUL in 1s
2 actionable tasks: 1 executed, 1 up-to-date
Configuration cache entry stored.
> ./gradlew :Lab_6:run
Calculating task graph as no cached configuration is available for tasks: :Lab_6:run

> Task :Lab_6:run
Set1: ArraySet{Honda CR-V: price=32000.00, fuel=8.2, speed=200, Ford Fiesta: price=18000.00, fuel=5.9, speed=190}
Set2: ArraySet{Toyota Camry: price=25000.00, fuel=7.5, speed=210}
Set3: ArraySet{Toyota Camry: price=25000.00, fuel=7.5, speed=210, Honda CR-V: price=32000.00, fuel=8.2, speed=200, Ford Fiesta: price=18000.00, fuel=5.9, speed=190}
Set3 contains car1? true
Set3 after removing car2: ArraySet{Toyota Camry: price=25000.00, fuel=7.5, speed=210, Ford Fiesta: price=18000.00, fuel=5.9, speed=190}
Set1 after adding 20 cars: size=22

BUILD SUCCESSFUL in 1s
2 actionable tasks: 1 executed, 1 up-to-date
Configuration cache entry stored.
> 
```

</details>
