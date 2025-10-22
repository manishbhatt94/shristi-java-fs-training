# 🚌 Bus Ticket Booking System – Java Console Application

## 📘 Overview
You are required to design and implement a **Java Console Application** to simulate a simplified **Bus Ticket Booking System**.  
This project emphasizes **object-oriented programming concepts** — **abstraction, inheritance, encapsulation, and polymorphism** — while also demonstrating practical console I/O and data flow.

The application should provide an intuitive **menu-driven interface** for the user to book tickets, view available buses, and manage passenger details.

---

## 🎯 Objectives
- Practice **OOP concepts**: abstract classes, inheritance, and polymorphism.
- Work with **collections**, **basic input/output**, and **object relationships**.
- Create a clean, modular design that is easy to extend (e.g., adding new bus types).

---

## 🏗️ Class Design

### 1. `Route` Class
Represents a travel route between two cities.

#### Fields
| Variable | Type | Description |
|-----------|------|-------------|
| `routeId` | `int` | Unique route ID |
| `source` | `String` | Starting location |
| `destination` | `String` | Destination location |
| `distanceKm` | `double` | Distance in kilometers |

#### Methods
| Method | Return Type | Description |
|---------|--------------|-------------|
| `getRouteId()` | `int` | Returns route ID |
| `getSource()` | `String` | Returns source location |
| `getDestination()` | `String` | Returns destination |
| `getDistanceKm()` | `double` | Returns distance |
| `displayRouteInfo()` | `void` | Displays route details |

---

### 2. `Bus` (Abstract Class)
Represents a generic bus.  
Cannot be instantiated directly. Defines common attributes and abstract fare calculation logic.

#### Fields
| Variable | Type | Description |
|-----------|------|-------------|
| `busId` | `int` | Unique bus identifier |
| `route` | `Route` | Associated route |
| `totalSeats` | `int` | Total number of seats |
| `availableSeats` | `int` | Currently available seats |
| `baseFarePerKm` | `double` | Base fare per kilometer |

#### Methods
| Method | Return Type | Description |
|---------|--------------|-------------|
| `getBusType()` | `abstract String` | Returns type of bus |
| `calculateFare()` | `abstract double` | Abstract method for fare calculation |
| `bookSeat()` | `boolean` | Decrements available seats if any left |
| `displayBusInfo()` | `void` | Displays bus and route information |

---

### 3. `NonACBus` (Subclass of `Bus`)
A basic bus with no additional charges.

#### Fare Formula
```
fare = baseFarePerKm * route.getDistanceKm()
```

---

### 4. `ACBus` (Subclass of `Bus`)
An air-conditioned bus with higher fare.

#### Additional Field
| Variable | Type | Description |
|-----------|------|-------------|
| `wifiAvailable` | `boolean` | Indicates if Wi-Fi is available |

#### Fare Formula
```
fare = baseFarePerKm * route.getDistanceKm() * 1.25
(if wifiAvailable) fare += 50
```

---

### 5. `LuxuryBus` (Subclass of `Bus`)
A premium bus that includes optional meals.

#### Additional Field
| Variable | Type | Description |
|-----------|------|-------------|
| `mealIncluded` | `boolean` | Indicates if meal is included |

#### Fare Formula
```
fare = baseFarePerKm * route.getDistanceKm() * 1.5
(if mealIncluded) fare += 150
```

---

### 6. `Passenger` Class
Represents a passenger booking a ticket.

#### Fields
| Variable | Type | Description |
|-----------|------|-------------|
| `passengerId` | `int` | Unique passenger ID |
| `name` | `String` | Passenger’s name |
| `age` | `int` | Passenger’s age |
| `gender` | `String` | Passenger’s gender |

#### Methods
| Method | Return Type | Description |
|---------|--------------|-------------|
| `displayPassengerInfo()` | `void` | Prints passenger details |

---

### 7. `Ticket` Class
Represents a booked ticket tied to a passenger and a bus.

#### Fields
| Variable | Type | Description |
|-----------|------|-------------|
| `ticketId` | `int` | Unique ticket ID |
| `passenger` | `Passenger` | Passenger object |
| `bus` | `Bus` | Bus object |
| `fare` | `double` | Calculated total fare |

#### Methods
| Method | Return Type | Description |
|---------|--------------|-------------|
| `displayTicketInfo()` | `void` | Prints ticket details |

---

### 8. `BookingSystem` (Main Class)
Handles user interactions and manages the entire system.

#### Responsibilities
- Display **menu** and take user inputs.
- Maintain lists of buses, routes, passengers, and tickets.
- Handle ticket booking logic, ensuring seat availability.

#### Example Menu Flow

```text
====== BUS TICKET BOOKING SYSTEM ======
1. View Available Buses
2. View Routes
3. Book a Ticket
4. View All Tickets
5. Exit
======================================
Enter your choice: 3
```

#### Booking Flow Example
```text
Select a Route:
1. Bengaluru → Chennai (350 km)
2. Bengaluru → Hyderabad (580 km)
Enter route choice: 1

Select Bus Type:
1. Non-AC
2. AC
3. Luxury
Enter choice: 2

Enter passenger details:
Name: Rohan
Age: 29
Gender: Male

Wi-Fi available in bus? (true/false): true

Ticket booked successfully!
Ticket ID: 101
Bus Type: AC Bus
Fare: ₹1125.0
```

---

## 🧮 Fare Calculation Logic Summary

| Bus Type | Base Formula | Extras |
|-----------|---------------|---------|
| Non-AC | baseFarePerKm × distance | – |
| AC | baseFarePerKm × distance × 1.25 | + ₹50 if Wi-Fi |
| Luxury | baseFarePerKm × distance × 1.5 | + ₹150 if Meal |

---

## 🪑 Seat Booking Logic
- Each `Bus` maintains an internal counter `availableSeats`.
- When a booking is attempted:
  - If `availableSeats > 0`, seat count is decremented.
  - Else, system displays: **“No seats available for this bus.”**
- Seats are not individually numbered (simplified for console use).

---

## 💾 Data Management
Use **ArrayList** to maintain collections:
```java
ArrayList<Bus> buses;
ArrayList<Route> routes;
ArrayList<Ticket> tickets;
ArrayList<Passenger> passengers;
```

---

## 🧩 Key OOP Concepts Demonstrated

| Concept | Where Used |
|----------|-------------|
| **Abstraction** | `Bus` class (abstract methods like `calculateFare()`) |
| **Inheritance** | `NonACBus`, `ACBus`, `LuxuryBus` extend `Bus` |
| **Polymorphism** | Different fare calculations via overridden `calculateFare()` |
| **Encapsulation** | Private fields with public getters/setters |
| **Composition** | `Ticket` has-a `Passenger` and a `Bus` |

---

## ✅ Deliverables
1. Java source code for all classes.
2. Console output screenshots for each menu option.
3. Short README describing fare logic and assumptions.

---

## 🕒 Estimated Effort
**~6–8 hours total**, broken down as:
- Class creation & relationships – 2 hrs  
- Booking logic & fare calculation – 3 hrs  
- Menu + user I/O – 2 hrs  
- Testing & cleanup – 1 hr

---

## 🧠 Notes
- Use **clear console messages** for every operation.
- Validate all user inputs (non-negative age, valid menu choice, etc.).
- No database or file storage is required — memory-only implementation.
- Keep code modular and readable.

---

**End of Assignment Brief**
