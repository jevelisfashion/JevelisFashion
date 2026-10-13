# Jevelis Fashion — Project APK (build jarak jauh)

Project Android native awal dengan logo JF, gaya ivory/hitam/putih, dan tombol menuju katalog Winme.

## Membuat APK tanpa membebani laptop
Project ini disertai GitHub Actions untuk membangun APK di server GitHub. Kamu tetap perlu akun GitHub dan mengunggah folder project ini ke repository.

1. Ekstrak ZIP di komputer.
2. Masuk ke GitHub dan buat repository baru, misalnya `jevelis-fashion-app`.
3. Unggah semua isi folder project (termasuk folder `.github`) ke repository. Pastikan `.github/workflows/build-apk.yml` ikut terunggah.
4. Buka tab **Actions** di repository GitHub.
5. Pilih workflow **Build Jevelis Fashion APK**, lalu tekan **Run workflow**.
6. Tunggu workflow selesai dengan tanda hijau.
7. Buka hasil workflow, cari bagian **Artifacts**, lalu unduh `JevelisFashion-debug-apk`.
8. Ekstrak file artifact ZIP; di dalamnya ada `app-debug.apk`. Pindahkan APK ke HP dan instal. Jika Android menampilkan peringatan, izinkan pemasangan dari sumber yang kamu gunakan hanya jika kamu mempercayai file tersebut.

## Catatan penting
- APK belum dibangun atau diuji dalam lingkungan ini. Workflow jarak jauh yang disediakan akan membangun APK.
- Versi ini memakai halaman beranda native ringan dan tombol belanja membuka https://winme.id/jevelis-fashion di browser.
- Tombol kategori juga membuka katalog Winme; kategori belum memfilter produk di dalam APK.
- Produk, stok, pembayaran, dan pesanan tetap dikelola oleh Winme.
- Ini APK debug untuk uji coba dan dibagikan secara terbatas; belum ditandatangani sebagai rilis produksi.
- Jangan unggah kunci rahasia, password, atau API key ke repository.
