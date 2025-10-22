# OOPs Practice Assignment: Online Bus Ticket Booking System

## 🎯 Objective
Design and implement a **simple console-based Java application** to simulate an **Online Bus Ticket Booking System**.  
The focus is on practicing **OOP concepts** — **abstraction, inheritance, method overriding, polymorphism, constructors, and class variables** — not on database or UI complexity.

---

## 📚 Topics to Practice
- Classes, objects, constructors  
- `this` and `super` keywords  
- Instance and class variables  
- Method overloading and overriding  
- Abstract classes and methods  
- Inheritance hierarchy and dynamic method binding  
- Arrays and ArrayLists  
- Control flow, loops, switch-case, Scanner input  

---

## 🏗️ System Overview
The system allows a user to:
1. View all available buses  
2. Search buses by route (source → destination)  
3. Book a ticket  
4. View all booked tickets  
5. Exit the program  

All data is stored **in memory** using simple lists (e.g. `ArrayList<Bus>`). No database, no file storage.

---

## 🧩 Class Structure

### 1. `abstract class Bus`
**Purpose:** Base class for all bus types.  
**Fields:**
- `protected int busId`
- `protected String source`
- `protected String destination`
- `protected double fare`

**Methods:**
- `public Bus(int busId, String source, String destination, double fare)` — constructor  
- `public abstract String getBusType()` — to be implemented by child classes  
- `public void displayBusInfo()` — prints bus details (id, type, route, fare)

---

### 2. `class NonACBus extends Bus`
**Purpose:** Represents a non-AC bus.

**Fields:**
- `private boolean sleeperAvailable`

**Methods:**
- Constructor → calls `super()` using `super(busId, source, destination, fare)`  
- Overrides `getBusType()` → returns `"Non-AC Bus"`  
- Overrides `displayBusInfo()` → adds sleeper info after calling `super.displayBusInfo()`

---

### 3. `class ACBus extends Bus`
**Purpose:** Represents an AC bus with additional amenities.

**Fields:**
- `private boolean wifiAvailable`

**Methods:**
- Constructor → calls `super()`  
- Overrides `getBusType()` → returns `"AC Bus"`  
- Overrides `displayBusInfo()` → adds WiFi info after calling `super.displayBusInfo()`

---

### 4. `class LuxuryBus extends ACBus`
**Purpose:** A premium AC bus subclass.

**Fields:**
- `private boolean mealIncluded`

**Methods:**
- Constructor → calls `super()`  
- Overrides `getBusType()` → returns `"Luxury AC Bus"`  
- Overrides `displayBusInfo()` → adds meal info after calling `super.displayBusInfo()`

---

### 5. `class Ticket`
**Purpose:** Represents a booked ticket.

**Fields:**
- `private static int counter = 1000` (auto-increment ticket id)  
- `private int ticketId`  
- `private String passengerName`  
- `private Bus bus`

**Methods:**
- Constructor → assigns a unique ticketId and stores passenger info  
- `public void displayTicketInfo()` → prints passenger, bus type, route, and fare

---

### 6. `class BookingSystem`
**Purpose:** Manages all buses and tickets.

**Fields:**
- `private ArrayList<Bus> busList`  
- `private ArrayList<Ticket> ticketList`

**Methods:**
- `public void initializeBuses()` — adds a few buses to `busList` manually  
- `public void showAllBuses()`  
- `public void searchBuses(String source, String destination)`  
- `public void bookTicket(String passengerName, Bus bus)`  
- `public void showAllTickets()`

---

### 7. `public class Main`
**Purpose:** Contains the `main()` method and menu loop.

**Flow:**
1. Create a `BookingSystem` object and call `initializeBuses()`.  
2. Show menu repeatedly until user chooses Exit.

---

## 🧮 Menu Flow (Console Interaction)

### Menu Display
```
==== Online Bus Ticket Booking System ====
1. View All Buses
2. Search Buses by Route
3. Book a Ticket
4. View All Booked Tickets
5. Exit
Enter your choice:
```

---

### 1️⃣ View All Buses
```
Choice: 1

Available Buses:
Bus ID: 101 | Type: Non-AC Bus | Route: Delhi -> Jaipur | Fare: 500.0 | Sleeper: Yes
Bus ID: 102 | Type: AC Bus | Route: Delhi -> Jaipur | Fare: 750.0 | WiFi: Yes
Bus ID: 103 | Type: Luxury AC Bus | Route: Delhi -> Jaipur | Fare: 1200.0 | WiFi: Yes | Meal: Yes
```

---

### 2️⃣ Search Buses by Route
```
Choice: 2
Enter Source City: Delhi
Enter Destination City: Jaipur

Buses Found:
1) Bus ID: 101 | Non-AC Bus | Fare: 500.0
2) Bus ID: 102 | AC Bus | Fare: 750.0
3) Bus ID: 103 | Luxury AC Bus | Fare: 1200.0
```

If no buses found:
```
No buses available for this route.
```

---

### 3️⃣ Book a Ticket

**Case 1: Only one bus found**
```
Choice: 3
Enter Source City: Delhi
Enter Destination City: Jaipur

1 Bus Found: Bus ID: 101 | Non-AC Bus | Fare: 500.0
Enter Passenger Name: Rahul
Ticket booked successfully! Ticket ID: 1001
```

**Case 2: Multiple buses found**
```
Choice: 3
Enter Source City: Delhi
Enter Destination City: Jaipur

Multiple buses found:
1) Bus ID: 101 | Non-AC Bus | Fare: 500.0
2) Bus ID: 102 | AC Bus | Fare: 750.0
3) Bus ID: 103 | Luxury AC Bus | Fare: 1200.0

Enter the Bus ID you want to book: 103
Enter Passenger Name: Neha
Ticket booked successfully! Ticket ID: 1002
```

**Case 3: No buses found**
```
No buses available for this route.
```

---

### 4️⃣ View All Booked Tickets
```
Choice: 4

All Booked Tickets:
Ticket ID: 1001 | Passenger: Rahul | Non-AC Bus | Delhi -> Jaipur | Fare: 500.0
Ticket ID: 1002 | Passenger: Neha | Luxury AC Bus | Delhi -> Jaipur | Fare: 1200.0
```

If no tickets booked:
```
No tickets booked yet.
```

---

### 5️⃣ Exit
```
Choice: 5
Thank you for using the Online Bus Ticket Booking System!
```

---

## 🧠 Implementation Tips
- Use `ArrayList<Bus>` and `ArrayList<Ticket>`.
- Override `displayBusInfo()` to demonstrate **polymorphism**.
- Store buses in memory via `initializeBuses()` method only.
- Don’t use interfaces, streams, or exceptions yet.
- Use `Scanner` for input and a simple `while(true)` menu loop with `switch-case`.

---

## ✅ Completion Checklist
- [ ] Create abstract class `Bus`
- [ ] Implement subclasses: `NonACBus`, `ACBus`, `LuxuryBus`
- [ ] Create class `Ticket` with static counter
- [ ] Implement `BookingSystem` class with lists & methods
- [ ] Build `Main` class with menu-driven flow
- [ ] Test each menu option using sample I/O above

---

**Total Estimated Time:** 1.5–2 hours  
**Primary Goal:** Reinforce understanding of abstraction, inheritance, and polymorphism through a practical mini-project.
