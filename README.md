# CAR - StockApp

## What is this repository?
This repository contains the implementation of an exercise completed during the **CAR** (Conception d'Applications Réparties) course.  
It provides both an application to handle stocks and an application to handle commands, and use kafka to make bridge between applications.

## How to run the project
1. **Clone** this repository to your local machine.
2. **Run** in terminal `docker compose up -d`.
3. **Access** the application kafka [http://localhost:3000](http://localhost:3000)
4. **Run** the `CommandApp` class in the commandApp folder.
5. **Run** the `StockApp` class in the stockApp folder.

## How to close the docker 
1. **Run** in terminal `docker compose down`

