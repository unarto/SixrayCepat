# PROGRESS HISTORY

## Date
2026-08-01

## Task
Rename Class Aplikasi dari Prefix `V2Ray` / `V2ray` Menjadi `SixRay`

## Files Changed
- `app/src/main/AndroidManifest.xml`
- `app/src/main/java/com/sixray/cepat/service/SixRayVpnService.kt` (renamed from `V2RayVpnService.kt`)
- `app/src/main/java/com/sixray/cepat/service/SixRayProxyOnlyService.kt` (renamed from `V2RayProxyOnlyService.kt`)
- `app/src/main/java/com/sixray/cepat/service/SixRayTestService.kt` (renamed from `V2RayTestService.kt`)
- `app/src/main/java/com/sixray/cepat/handler/SixRayServiceManager.kt` (renamed from `V2RayServiceManager.kt`)
- `app/src/main/java/com/sixray/cepat/dto/SixRayConfig.kt` (renamed from `V2rayConfig.kt`)
- `app/src/main/java/com/sixray/cepat/handler/SixRayConfigManager.kt` (renamed from `V2rayConfigManager.kt`)
- `app/src/main/java/com/sixray/cepat/dto/ServerConfig.kt`
- `app/src/main/java/com/sixray/cepat/fmt/CustomFmt.kt`
- `app/src/main/java/com/sixray/cepat/fmt/HttpFmt.kt`
- `app/src/main/java/com/sixray/cepat/fmt/Hysteria2Fmt.kt`
- `app/src/main/java/com/sixray/cepat/fmt/ShadowsocksFmt.kt`
- `app/src/main/java/com/sixray/cepat/fmt/SocksFmt.kt`
- `app/src/main/java/com/sixray/cepat/fmt/TrojanFmt.kt`
- `app/src/main/java/com/sixray/cepat/fmt/VlessFmt.kt`
- `app/src/main/java/com/sixray/cepat/fmt/VmessFmt.kt`
- `app/src/main/java/com/sixray/cepat/fmt/WireguardFmt.kt`
- `app/src/main/java/com/sixray/cepat/handler/AngConfigManager.kt`
- `app/src/main/java/com/sixray/cepat/handler/NotificationManager.kt`
- `app/src/main/java/com/sixray/cepat/handler/SettingsManager.kt`
- `app/src/main/java/com/sixray/cepat/receiver/BootReceiver.kt`
- `app/src/main/java/com/sixray/cepat/receiver/TaskerReceiver.kt`
- `app/src/main/java/com/sixray/cepat/receiver/WidgetProvider.kt`
- `app/src/main/java/com/sixray/cepat/service/QSTileService.kt`
- `app/src/main/java/com/sixray/cepat/ui/MainActivity.kt`
- `app/src/main/java/com/sixray/cepat/ui/MainRecyclerAdapter.kt`
- `app/src/main/java/com/sixray/cepat/ui/ScSwitchActivity.kt`
- `app/src/main/java/com/sixray/cepat/util/MessageUtil.kt`

## Summary
Melakukan refactor menyeluruh pada seluruh class aplikasi yang memiliki prefix `V2Ray` atau `V2ray` menjadi `SixRay`. Seluruh import, deklarasi di AndroidManifest, Intent, Service, Receiver, Notification, Factory, ViewModel, serta pemanggilan class telah diperbarui secara konsisten.

## Technical Details
Renamed Class & Files:
1. `V2RayVpnService` -> `SixRayVpnService` (`app/src/main/java/com/sixray/cepat/service/SixRayVpnService.kt`)
2. `V2RayProxyOnlyService` -> `SixRayProxyOnlyService` (`app/src/main/java/com/sixray/cepat/service/SixRayProxyOnlyService.kt`)
3. `V2RayTestService` -> `SixRayTestService` (`app/src/main/java/com/sixray/cepat/service/SixRayTestService.kt`)
4. `V2RayServiceManager` -> `SixRayServiceManager` (`app/src/main/java/com/sixray/cepat/handler/SixRayServiceManager.kt`)
5. `V2rayConfig` -> `SixRayConfig` (`app/src/main/java/com/sixray/cepat/dto/SixRayConfig.kt`)
6. `V2rayConfigManager` -> `SixRayConfigManager` (`app/src/main/java/com/sixray/cepat/handler/SixRayConfigManager.kt`)

Aturan Perlindungan yang Dipertahankan:
- Package name `com.sixray.cepat`, applicationId, dan namespace tetap utuh.
- Seluruh build configuration (Gradle, CMake, Android.mk, Workflows, Shell Script) tidak diubah.
- Referensi engine native Go/AAR (`libv2ray`, `Libv2ray`, `go.Seq`) dan process daemon (`:RunSoLibV2RayDaemon`) tetap dipertahankan sesuai aturan perlindungan engine.

## Impact Check

- UI: Seluruh UI (MainActivity, MainRecyclerAdapter, ScSwitchActivity) memanggil `SixRayServiceManager` dengan benar.
- ViewModel: Referensi config & service manager menggunakan class `SixRay*` baru.
- Storage/MMKV: Format data dan MMKV keys tidak diubah.
- Service: Deklarasi `<service>` di `AndroidManifest.xml` diperbarui ke `SixRayVpnService`, `SixRayProxyOnlyService`, dan `SixRayTestService`.
- JNI: Tidak ada perubahan signature JNI.
- Native: Tidak ada perubahan pada library native.
- Build System: Tidak ada perubahan pada script build.

## Verification

- Build status: Kompilasi kode aplikasi Kotlin berhasil tanpa error referensi class.
- Testing status: Seluruh 28 file sumber telah diperbarui dan diverifikasi secara konsisten.
- Remaining issue: Tidak ada.

## Next Step
- Melanjutkan pengembangan fitur dan pengujian koneksi VPN.

---

# PROGRESS HISTORY

## Date
2026-08-01

## Task
Migrasi Seluruh Source Proyek ke Root Directory (Menghapus folder `V2rayNG`)

## Files Changed
- `/app/` (dipindahkan dari `/V2rayNG/app/`)
- `/build.gradle.kts` (dipindahkan dari `/V2rayNG/build.gradle.kts`)
- `/gradle/` (dipindahkan dari `/V2rayNG/gradle/`)
- `/gradle.properties` (dipindahkan dari `/V2rayNG/gradle.properties`)
- `/gradlew` & `/gradlew.bat` (dipindahkan dari `/V2rayNG/gradlew*`)
- `/settings.gradle.kts` (dipindahkan dari `/V2rayNG/settings.gradle.kts`)
- `/.github/workflows/build.yml`
- `/.gitignore`
- `/PROGRESS.md`

## Summary
Memindahkan seluruh komponen proyek dari subfolder `V2rayNG/` langsung ke root directory `/`. Menyesuaikan jalur file pada workflow GitHub Actions (`build.yml`) dan `.gitignore` agar selaras dengan struktur baru tanpa folder `V2rayNG`.

## Technical Details
1. Memindahkan direktori `app/`, `gradle/`, serta file `build.gradle.kts`, `settings.gradle.kts`, `gradle.properties`, `gradlew`, dan `gradlew.bat` dari `V2rayNG/` ke root directory `/`.
2. Menghapus folder kosong `V2rayNG/`.
3. Memperbarui seluruh rute path pada `.github/workflows/build.yml` (`app/build.gradle.kts`, `app/libs/`, `app/build/outputs/apk/`, dsb.).
4. Memperbarui rute path pada `.gitignore` (`app/release/output.json`, `app/build`, `app/google-services.json`).

## Impact Check

- UI: Tidak ada perubahan langsung pada UI.
- ViewModel: Tidak ada perubahan logic ViewModel.
- Storage/MMKV: Tidak ada.
- Service: Tidak ada.
- JNI: Tidak ada.
- Native: Tidak ada.
- Build System: Sistem build Gradle kini berada langsung di root directory, memungkinkan Gradle mengenali build file dari root.

## Verification

- Build status: Executed `gradle tasks` dan `compile_applet` dari root directory, Gradle berhasil mendeteksi dan menjalankan build dari root.
- Testing status: OK, struktur folder `V2rayNG` telah dibersihkan dan dipindahkan ke root.
- Remaining issue: Tidak ada.

## Next Step
- Pengembangan dan pengujian fitur aplikasi pada struktur root baru.

---

## Date
2026-08-01

## Task
Pengubahan Nama Aplikasi menjadi `Sixray Cepat`

## Files Changed
- `metadata.json`
- `V2rayNG/app/src/main/res/values/strings.xml`
- `V2rayNG/app/src/dev/res/values/strings.xml`
- `V2rayNG/app/src/fdroid/res/values/strings.xml`
- `V2rayNG/app/src/pre_release/res/values/strings.xml`
- `V2rayNG/app/src/main/res/values-ru/strings.xml`
- `V2rayNG/app/src/main/res/values-vi/strings.xml`
- `PROGRESS.md`

## Summary
Mengubah nama aplikasi yang ditampilkan di platform AI Studio dan seluruh resource string Android (termasuk flavor dev, fdroid, pre_release, dan bahasa lokalisasi) dari `v2rayNG` menjadi `Sixray Cepat`.

## Technical Details
1. Membuat/memperbarui `/metadata.json` dengan `name`: `"Sixray Cepat"` untuk identitas proyek AI Studio platform.
2. Mengubah `<string name="app_name">` pada `V2rayNG/app/src/main/res/values/strings.xml` dari `"v2rayNG"` menjadi `"Sixray Cepat"`.
3. Mengubah nama aplikasi untuk masing-masing flavor:
   - dev: `Sixray Cepat (DEV)`
   - fdroid: `Sixray Cepat (F-Droid)`
   - pre_release: `Sixray Cepat (PR)`
4. Memperbarui string lokalisasi yang mengacu pada nama aplikasi di `values-ru` dan `values-vi`.

## Impact Check

- UI: Nama aplikasi di launcher, title bar, navigation drawer, widget, dan notifikasi kini menampilkan `Sixray Cepat`.
- ViewModel: Tidak ada perubahan logis.
- Storage/MMKV: Tidak ada perubahan key atau format data.
- Service: Label QSTileService dan nama dalam pesan service menggunakan `Sixray Cepat`.
- JNI: Tidak ada.
- Native: Tidak ada.
- Build System: Resource string versi flavor diperbarui secara konsisten.

## Verification

- Build status: Resource string valid dan terverifikasi.
- Testing status: OK.
- Remaining issue: Tidak ada.

## Next Step
- Menguji jalannya aplikasi dan fitur VPN.

---

## Date
2026-08-01

## Task
Refactor Package Name dari `com.v2ray.ang` menjadi `com.sixray.cepat`

## Files Changed
- `V2rayNG/app/build.gradle.kts`
- All source files under `V2rayNG/app/src/main/java/com/sixray/cepat/` (sebelumnya `com/v2ray/ang/`)
- All test files under `V2rayNG/app/src/test/java/com/sixray/cepat/` (sebelumnya `com/v2ray/ang/`)
- Layout & XML files (`activity_settings.xml`, `shortcuts.xml`, `shortcuts.xml` in fdroid)
- Documentation and scripts (`README.md`, `compile-hevtun.sh`, `full_description.txt`)
- `PROGRESS.md`

## Summary
Melakukan refactoring seluruh package name aplikasi dari `com.v2ray.ang` menjadi `com.sixray.cepat` di seluruh file konfigurasi, kode program Kotlin, resource XML, script, dan struktur folder project.

## Technical Details
1. Mengubah `namespace` dan `applicationId` di `V2rayNG/app/build.gradle.kts` menjadi `"com.sixray.cepat"`.
2. Mengubah seluruh deklarasi `package` dan pernyataan `import` pada file Kotlin dari `com.v2ray.ang` ke `com.sixray.cepat`.
3. Memindahkan struktur direktori sumber utama dari `V2rayNG/app/src/main/java/com/v2ray/ang` ke `V2rayNG/app/src/main/java/com/sixray/cepat`.
4. Memindahkan struktur direktori unit test dari `V2rayNG/app/src/test/java/com/v2ray/ang` ke `V2rayNG/app/src/test/java/com/sixray/cepat`.
5. Mengubah referensi package di resource XML (misalnya fragment name pada `activity_settings.xml` dan targetPackage pada `shortcuts.xml`).

## Impact Check

- UI: Referensi fragment dan shortcuts diperbarui ke package `com.sixray.cepat`.
- ViewModel: Package name dan import diperbarui ke `com.sixray.cepat`.
- Storage/MMKV: Tidak ada perubahan format data MMKV.
- Service: Seluruh service class dan intent receiver menggunakan package `com.sixray.cepat`.
- JNI: `compile-hevtun.sh` disesuaikan dengan package baru.
- Native: Tidak ada perubahan binary native interface.
- Build System: `build.gradle.kts` mengacu pada namespace & applicationId `com.sixray.cepat`.

## Verification

- Build status: Refactoring selesai tanpa ada sisa string `com.v2ray.ang` di dalam file source/config.
- Testing status: Struktur folder `com/sixray/cepat` terverifikasi ada dan valid.
- Remaining issue: Tidak ada.

## Next Step
- Melanjutkan pengembangan / pengujian fitur VPN dengan package ID baru `com.sixray.cepat`.

---

## Date
2026-08-01

## Task
Pembuatan file android_keystore.jks di directory root

## Files Changed
- android_keystore.jks
- PROGRESS.md

## Summary
Membuat file Java KeyStore (`android_keystore.jks`) di root directory proyek menggunakan JDK `keytool` untuk keperluan signing build Android.

## Technical Details
Menggunakan utility `keytool` untuk generate key pair 2048-bit RSA dengan masa berlaku 10.000 hari:
- Keystore file: `android_keystore.jks`
- Alias: `androidkey`
- Key Algorithm: `RSA (2048 bit)`
- Validity: `10000 days`
- Default Store Password / Key Password: `123456`

## Impact Check

- UI: Tidak ada
- ViewModel: Tidak ada
- Storage/MMKV: Tidak ada
- Service: Tidak ada
- JNI: Tidak ada
- Native: Tidak ada
- Build System: Menyediakan file keystore untuk signing release APK

## Verification

- Build status: File `android_keystore.jks` berhasil dibuat di root directory (ukuran 2752 bytes).
- Testing status: OK (terverifikasi via CLI `ls -la`)
- Remaining issue: Tidak ada

## Next Step
- Mengonfigurasi signing credential jika dibutuhkan pada proses CI/CD atau Gradle build.

---

# PROGRESS HISTORY

## Date
2026-08-01

## Task
Audit & Verifikasi Dampak Perubahan Package `com.v2ray.ang` ke `com.sixray.cepat`

## Files Changed
- `app/src/main/java/com/sixray/cepat/handler/SixRayServiceManager.kt`
- `app/build.gradle.kts` (minSdk disesuaikan untuk compatibility libv2ray)

## Summary
Melakukan audit menyeluruh terhadap dampak penggantian namespace dan applicationId ke `com.sixray.cepat`. Audit mencakup build configuration, JNI native codes (hevtun & tun2socks), intent broadcast, dan data persistence (MMKV). Memperbaiki error Kotlin pada pemanggilan API `libv2ray.aar` (`getIsRunning()`).

## Technical Details
- Menemukan error referensi `isRunning` pada library `libv2ray.aar`. Memperbaiki dengan memanggil `coreController.getIsRunning()`.
- Mengevaluasi `compile-hevtun.sh` yang meneruskan `PKGNAME=com/sixray/cepat/service`.
- Menganalisa workflow CI/CD `build.yml` dan mengonfirmasi hash busting otomatis akan me-rebuild `.so` native module.

## Impact Check
- UI: Tidak berdampak.
- ViewModel: Tidak berdampak.
- Storage/MMKV: **KRITIS**: Aplikasi ini akan dianggap aplikasi baru. Data lama pengguna (server, routing, setting) dari `com.v2ray.ang` TIDAK akan terbawa ke aplikasi baru ini.
- Service: Broadcast intent otomatis berubah (menggunakan `BuildConfig.APPLICATION_ID`). Tidak ada konflik antar aplikasi.
- JNI: Flag `PKGNAME` sudah diperbarui. CI akan me-rebuild JNI library untuk mendengarkan callback dari `com.sixray.cepat.service`.
- Native: Tidak ada bug atau unresolved link untuk native calls.
- Build System: Mengganti minSdk ke 24 karena library native terbaru mensyaratkannya. Hash actions sudah sinkron.

## Verification
- Build status: Kompilasi sources berhasil dieksekusi setelah mapping API library golang disesuaikan.
- Testing status: Struktur project, manifest merger, dan JNI build flags terverifikasi bersih (clean).
- Remaining issue: -

## Next Step
- Menguji fungsi VPN service dengan data akun nyata (end-to-end testing).

---

## Date
2026-08-01

## Task
Change light theme background

## Files Changed
- `app/src/main/res/drawable/bg_light_theme.xml` (created)
- `app/src/main/res/values/themes.xml`
- `app/src/main/res/values-night/themes.xml`
- `app/src/main/java/com/sixray/cepat/handler/SixRayServiceManager.kt`

## Summary
- Mengubah background tema terang dengan gradien kustom seperti yang diminta oleh pengguna (dari `#FFFFFF` ke `#87CEEB`).
- Menambahkan drawable `bg_light_theme.xml`.
- Memperbarui `AppThemeDayNight` di `values/themes.xml` untuk menggunakan `bg_light_theme`.
- Memperbarui `AppThemeDayNight` di `values-night/themes.xml` dengan latar belakang statis `@color/colorPrimary` agar tema gelap tidak terdampak oleh perubahan tema terang.
- Memperbaiki build error di `SixRayServiceManager.kt` yang disebabkan oleh perubahan signature `startLoop` di versi library `libv2ray.aar` baru.

## Technical Details
- Menambahkan `android:windowBackground` = `@drawable/bg_light_theme` pada mode Light.
- Menambahkan `android:windowBackground` = `@color/colorPrimary` pada mode Night/Dark.
- Passing argument ke-2 pada pemanggilan `coreController.startLoop(result.content, 0)`.

## Impact Check
- UI: Background aplikasi pada tema terang kini menggunakan warna gradien. Tema gelap tetap mempertahankan warna aslinya.
- ViewModel: -
- Storage/MMKV: -
- Service: -
- JNI: -
- Native: -
- Build System: Build Kotlin yang awalnya error karena library go update telah diperbaiki.

## Verification
- Build status: Berhasil, no error.
- Testing status: Tampilan UI mode light berhasil diperbarui tanpa mengganggu mode dark.
- Remaining issue: -

## Next Step
- Konfirmasi tampilan kepada pengguna.

---

## Date
2026-08-01

## Task
Verifikasi Keystore Secrets di GitHub Actions

## Files Changed
- `.github/workflows/build.yml` (Verifikasi)

## Summary
Melakukan pengecekan dan verifikasi kesesuaian antara nama variabel secret di file `.github/workflows/build.yml` dengan konfigurasi rahasia repositori di GitHub berdasarkan screenshot. 

## Technical Details
Secret yang digunakan di file konfigurasi CI/CD `build.yml` sudah sinkron dan cocok 100% dengan nama yang ada pada pengaturan GitHub:
1. `APP_KEYSTORE_ALIAS` 
2. `APP_KEYSTORE_BASE64`
3. `APP_KEYSTORE_PASSWORD`
4. `APP_KEY_PASSWORD`

## Impact Check
- UI: -
- ViewModel: -
- Storage/MMKV: -
- Service: -
- JNI: -
- Native: -
- Build System: Konfigurasi signing APK via gradlew release sudah aman dan valid menggunakan environment variable GitHub Secrets yang tepat.

## Verification
- Build status: -
- Testing status: Konfigurasi CI dipastikan tidak ada typo (typo-free).
- Remaining issue: -

## Next Step
- Fitur CI siap di-push dan dieksekusi oleh GitHub Actions untuk merilis APK (Play Store/F-Droid variant).

---

## Date
2026-08-01

## Task
Membuat Workflow GitHub Actions untuk Install Submodule

## Files Changed
- `.github/workflows/pasang_submodule.yml` (Created)

## Summary
Membuat workflow baru `Pasang Semua Submodule` (`pasang_submodule.yml`) yang dapat dieksekusi secara manual via GitHub Actions (`workflow_dispatch`). Workflow ini akan otomatis menghapus cache submodule lama lalu memasang kembali 5 submodule penting: `hysteria`, `AndroidLibXrayLite`, `badvpn` (untuk `tun2socks`), `libancillary`, dan `hev-socks5-tunnel`.

## Technical Details
- Menambahkan identity git bot untuk commit.
- Membersihkan jejak direktori submodule sebelumnya dengan `git rm -rf` dan menghapus mapping di `.gitmodules`.
- Menggunakan `git submodule add` pada masing-masing repo sesuai URL yang ada pada `.gitmodules`.
- Branch otomatis dideteksi dari push environment `HEAD:${GITHUB_REF#refs/heads/}` agar tidak conflict.

## Impact Check
- UI: -
- ViewModel: -
- Storage/MMKV: -
- Service: -
- JNI: Submodule di-manage ulang secara remote
- Native: -
- Build System: Proses perbaikan dan fetch submodule bisa dilakukan 1-click via Actions.

## Verification
- Build status: -
- Testing status: File workflow valid dan tidak ada syntax error.
- Remaining issue: -

## Next Step
- Pengguna dapat menjalankan workflow `Pasang Semua Submodule` pada tab Actions di GitHub.

---

## Date
2026-08-01

## Task
Update Workflow GitHub Actions - Pasang Submodule

## Files Changed
- `.github/workflows/pasang_submodule.yml` (Update)

## Summary
Menambahkan command `git submodule update --init --recursive` dan `git submodule sync --recursive` ke dalam workflow `pasang_submodule.yml` untuk memastikan seluruh submodule disinkronisasi dengan benar dan diambil secara keseluruhan (termasuk nested submodules) sesudah submodule di-add.

## Technical Details
Menyisipkan 2 baris eksekusi git module tepat setelah blok penambahan submodule terakhir (hev-socks5-tunnel) dan sebelum baris `git add .`:
- `git submodule update --init --recursive`
- `git submodule sync --recursive`

## Impact Check
- UI: -
- ViewModel: -
- Storage/MMKV: -
- Service: -
- JNI: Mencegah kegagalan build JNI jika terdapat internal nested submodule pada dependency.
- Native: -
- Build System: Script di GitHub Actions menjadi lebih robust dalam me-restore submodule dependencies sebelum dicommit dan push.

## Verification
- Build status: -
- Testing status: File yaml berhasil diperbarui.
- Remaining issue: -

## Next Step
- Menggunakan workflow di Actions untuk refresh keseluruhan submodule yang rusak/tertinggal pada repository GitHub.
