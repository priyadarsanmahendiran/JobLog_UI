# 📓 JobLog - Mobile UI

**JobLog** is a simple, clean, and efficient mobile app built using **Kotlin** and **Android Jetpack** libraries.  
It enables users to **log their daily work activities** and automatically generates **daily standup reports**.

This repository contains the **Kotlin frontend** for the JobLog ecosystem.

---

## 📱 Features

- 📋 **Add, View, and Manage Work Logs**
- 📈 **Auto-generate Standup Reports** at scheduled intervals
- 🔒 **Secure Authentication** with JWT-based token system
- 🛎️ **Receive Notifications** when your standup report is ready
- 🎨 **Minimal, Clean, and Intuitive UI**

---

## 🛠️ Tech Stack

- **Kotlin** (Main Language)
- **Jetpack Compose / XML layouts** (depending on project style)
- **MVVM Architecture** (Model-View-ViewModel)
- **Retrofit** (for API calls)
- **Coroutines** (for async work)
- **Hilt / Dagger** (for Dependency Injection)
- **Firebase Cloud Messaging (FCM)** *(for push notifications)* — *(planned)*

---

## 🚀 Getting Started

### Prerequisites
- Android Studio Electric Eel or above
- Minimum SDK version: **21+**
- Kotlin version: **1.8+**
- Internet connection (for API interactions)

### Installation Steps

1. **Clone the repository**
    ```bash
    git clone https://github.com/yourusername/joblog-ui.git
    ```

2. **Open in Android Studio**

3. **Setup environment variables**
    - Create a `local.properties` file (or use Gradle secrets) to store sensitive API base URLs or tokens.

4. **Run the app on an emulator or physical device**

---

## 🔗 API Integration

- **Base URL:** _Provided by the JobLog backend_
- Authentication handled via **JWT tokens**.
- All API calls are secured with token headers.
- Refresh tokens (if applicable) will be implemented in future updates.

---

---

## 🛡️ Security Notes

- All sensitive data (like JWT token) is stored securely.
- Future enhancements will include EncryptedSharedPreferences.

---

## 🌟 What's Next?

- 🔔 Push Notifications (via FCM) for Standup Summary
- 📅 Offline logging support
- 📊 Visual charts for weekly work trends
- 👥 Multi-user / team support

---

## 🤝 Contributions

Pull requests, feedback, and ideas are welcome!  
Let's build this product together. 🚀

---

## 👨‍💻 Developed By

**Priyadarsan M**  
_"Building JobLog with ❤️ to make daily standups effortless."_

---

## 📜 License

This project is licensed under the [MIT License](LICENSE).

---