# Antigravity Blocks - Android project

A native Android wrapper (WebView) around the game, which lives in
app/src/main/assets/index.html.

## Build the APK (Android Studio)
1. Install Android Studio (https://developer.android.com/studio).
2. File > Open... and choose this AntigravityBlocks folder. Let Gradle sync.
3. Build > Build Bundle(s) / APK(s) > Build APK(s).
4. Click "locate" in the popup: app-debug.apk is in app/build/outputs/apk/debug/.
5. Copy it to your phone and install it (allow "install unknown apps" when asked),
   or plug the phone in with USB debugging on and press Run.

## Edit the game
Change app/src/main/assets/index.html and rebuild.

## No Android Studio? Build in the cloud with GitHub (free)
1. Create a new GitHub repository and upload every file in this folder,
   including the hidden .github folder.
2. Open the repo\x27s Actions tab. The "Build APK" workflow runs automatically
   (or press Run workflow).
3. When it finishes, open the run and download "antigravity-blocks-apk".
   Unzip it to get app-debug.apk and install it on your phone.
