# Chefit Android

Chefit web sitesinin Android uygulaması. Tarifler app/src/main/assets/recipes.json içinde tutulur; arayüz ve kayıt/favori özellikleri uygulama içine gömülüdür ve çevrimdışı çalışır.

## APK üretme
1. Bu klasörün içindeki dosyaları chefit-android adlı yeni GitHub deposunun köküne yükleyin.
2. .github/workflows/build.yml dosyası main dalına yüklenince GitHub Actions otomatik olarak APK üretir. İsterseniz Actions sekmesinden Build Chefit APK / Run workflow ile elle de başlatabilirsiniz.
3. Yeşil tikli çalıştırmayı açın, Artifacts bölümünden chefit-debug-apk dosyasını indirin ve ZIP içindeki app-debug.apk dosyasını telefona aktarın.
4. Telefonda APK’yı açıp Android’in istediği durumda bu kaynağa uygulama yükleme izni verin.

Debug APK imzası kurulum için uygundur; Play Store yayını için ayrıca imzalı release oluşturulmalıdır.
