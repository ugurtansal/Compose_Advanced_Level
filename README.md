# 🚀 Advanced Android Operations / İleri Seviye Android İşlemleri

[TR]
Bu proje, modern Android geliştirme süreçlerinde kullanılan ileri seviye teknikleri ve arka plan işlemlerini kapsayan kapsamlı bir rehberdir. Uygulama içerisinde kullanıcı etkileşimini artıran bildirim mekanizmaları ve sistem kaynaklarını verimli kullanan arka plan görev yönetimi (WorkManager) pratikleri sergilenmektedir.

[EN]
This project is a comprehensive guide covering advanced techniques and background processing in modern Android development. It showcases notification mechanisms that enhance user engagement and background task management (WorkManager) practices that efficiently utilize system resources.

---

## 🛠 Features / Özellikler

[TR]
Proje kapsamında aşağıdaki ileri seviye konulara odaklanılmıştır:
* **Notification Management:** Kullanıcıya anlık bilgi akışı sağlayan bildirim kanalları ve izin yönetimi.
* **WorkManager:** Uygulama kapalı olsa dahi çalışması garanti edilen görevlerin yönetimi.
* **Task Scheduling:** Belirli kısıtlamalara (Şarj durumu, internet bağlantısı) ve zaman aralıklarına bağlı görev planlama.

[EN]
The project focuses on the following advanced topics:
* **Notification Management:** Notification channels and permission management providing real-time information flow to the user.
* **WorkManager:** Management of tasks guaranteed to run even if the app is closed.
* **Task Scheduling:** Scheduling tasks based on specific constraints (Charging status, internet connection) and time intervals.

---

## 📚 Documentation & Reference Links / Dokümantasyon ve Referanslar

[TR]
Projede kullanılan temel bileşenler için hazırlanan özel yönlendirmeler:

[EN]
Special redirects prepared for the core components used in the project:



### 🔔 Notifications / Bildirimler
[TR] Bildirim kanalları oluşturma ve kullanıcıyı uyarma sistemleri.
[EN] Systems for creating notification channels and alerting the user.
* [Notification Documentation](app/src/main/java/com/ugurtansal/traning_advanced_level/notification/Notification.kt)

### ⚙️ Work Manager / Görev Yöneticisi
[TR] Arka plan işlemlerinin en temel ve güçlü yönetim birimi.
[EN] The most basic and powerful management unit for background operations.
* [WorkManager Documentation](app/src/main/java/com/ugurtansal/traning_advanced_level/work_manager)

### ⛓️ Constraint Work Manager / Kısıtlamalı Görevler
[TR] Sadece belirli şartlar (Cihazın şarjda olması, Wi-Fi bağlılığı vb.) sağlandığında çalışan görevler.
[EN] Tasks that run only when specific conditions (Device charging, Wi-Fi connectivity, etc.) are met.
* [Constraint WorkManager Documentation](app/src/main/java/com/ugurtansal/traning_advanced_level/work_manager/ConstraintState.kt)

### ⏳ Periodic Work Manager / Periyodik Görevler
[TR] Belirli zaman aralıklarıyla (örn: her 15 dakikada bir) tekrarlanan işlemler.
[EN] Operations repeated at specific time intervals (e.g., every 15 minutes).
* [Periodic WorkManager Documentation](app/src/main/java/com/ugurtansal/traning_advanced_level/work_manager/PeriodicWorkRequest.kt)

---

## 🛠 Setup / Kurulum

[TR]
1. Bu depoyu klonlayın.
2. Android 13+ cihazlar için bildirim izinlerini kontrol edin.
3. Gradle dosyasındaki SDK sürümlerinin güncelliğini doğrulayın.

[EN]
1. Clone this repository.
2. Check notification permissions for Android 13+ devices.
3. Verify that the SDK versions in the Gradle file are up to date.
