# 🚆 Railway Ticket Booking System

A Java-based console application that allows users to book railway tickets, manage berth allocations (L, M, U), and handle RAC (Reservation Against Cancellation) and Waiting List (WL) queues. The system uses object-oriented programming principles and a queue-based seat allocation strategy.

---

## 🚀 Features

- 🧾 Book train tickets with passenger name, age, gender, and berth preference (L/M/U)
- ✅ Automatic berth allocation logic prioritizing senior female passengers for lower berths
- ❌ Cancel a confirmed ticket and auto-upgrade RAC and WL queues
- 📋 View confirmed, RAC, and waiting list tickets
- 📊 Check current availability of confirmed, RAC, and WL tickets
- 💡 Uses Lists and Queues for real-time allocation

---

## 🛠️ Tech Stack

- **Language**: Java  
- **Execution**: Command Line Interface (CLI)  
- **Paradigm**: Object-Oriented Programming (OOP)

---

## 📂 Project Structure

```
RAIWAY_TICKET_BOOKING_SYSTEM/
├── Passenger.java         # Contains Passenger class with personal and ticket details
├── TicketSystem.java      # Core logic for booking, cancellation, and queue management
└── ticketbooking.java     # Menu-driven main class for user interaction
```

---

## 🧑‍💻 How It Works

1. **Confirmed Tickets**: Booked if berths (L/M/U) are available.
2. **RAC Tickets**: Booked if all berths are full and RAC has space (1 slot).
3. **Waiting List (WL)**: Booked if RAC is full and WL has space (1 slot).
4. **Cancellation**: Frees a berth and promotes passengers from RAC → CNF and WL → RAC.

---

## 🧪 Sample Booking Interaction

```text
1. Book Ticket
   - Enter Name: Ramesh
   - Enter Age: 65
   - Enter Gender: female
   - Enter Berth Preference: L

   Output: Ticket Confirmed with Lower Berth

2. Cancel Ticket
   - Enter Ticket ID: T1
   Output: Ticket cancelled, RAC moved to Confirmed, WL moved to RAC
```

---

## 💻 How to Run

```bash
javac RAIWAY_TICKET_BOOKING_SYSTEM/*.java
java RAIWAY_TICKET_BOOKING_SYSTEM.ticketbooking
```

> Ensure you are compiling from the root directory above the package folder.

---

## 🙋 Author

**Shanmugapandiyan A**  
GitHub: [@your-username](https://github.com/shanmugapandiyan)

---

## 📄 License

Licensed under the [MIT License](LICENSE)
