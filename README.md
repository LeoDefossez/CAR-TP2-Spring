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

## Notes
1. How to submit an order ?
   - when printing an order click on 'CONFIRM AND SEND THE ORDER'
2. How to know if the order was taken into account in the stock app ?
   - Reload the page, if the stock has reduced, then it was taken into account
   - If not, check the log of the stock App, either no product matched the name or there was not enough quantity in stock
