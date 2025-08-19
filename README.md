# Clinic Appointments Frontend

This is the **React frontend** for the Clinic Appointments application.  
It connects to the backend API (built with Node.js/Express + PostgreSQL) and allows patients to book appointments and admins to manage bookings.

---

## 🚀 Features
- Patient registration & login
- Book appointments within the next 7 days
- View personal bookings
- Admin dashboard to view all bookings
- LocalStorage-based authentication persistence
- Single-page app with hash-based routing (no external router needed)

---

## 🛠 Tech Stack
- **React + Vite (TypeScript)**
- **TailwindCSS** (optional, works without styling too)
- **Framer Motion** (for animations)
- **Fetch API** for backend communication

---

## 📦 Setup & Installation

### 1. Clone the repo & install dependencies
```bash
git clone https://github.com/yourusername/clinic-appointments-frontend.git
cd clinic-appointments-frontend
npm install
```

### 2. Configure Environment Variables
Create a `.env` file in the project root and set the backend API URL:

```bash
VITE_API_BASE=https://your-api.onrender.com/api
```

### 3. Run the app in development mode
```bash
npm run dev
```

The app will be available at `http://localhost:5173` (default Vite port).

### 4. Build for production
```bash
npm run build
npm run preview
```

---

## 🔑 Authentication
- Patients and admins log in using their email/password.
- A JWT token is stored in **localStorage** for session persistence.
- API requests include the `Authorization: Bearer <token>` header.

---

## 📖 Pages

### `/#/register`
Patient registration form.

### `/#/login`
Login for both patients and admins.

### `/#/dashboard`
Patient dashboard to view & book slots and check bookings.

### `/#/admin`
Admin dashboard showing all bookings.

---

## ✅ Verification

You can test API integration by:
1. Registering a new patient.
2. Logging in.
3. Booking available slots.
4. Viewing bookings as patient/admin.

---

## 📄 License
MIT License
