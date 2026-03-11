intro_android_demo
==================

Demo of app exercises for Intro to Android App Development

## Java Version

This project uses **Java 8** (1.8) with the Android Gradle Plugin. The codebase leverages the following Java 8 features:

- **Lambda expressions** for concise event handlers and callbacks (e.g., `OnClickListener`, `OnItemClickListener`, `OnChildClickListener`)
- **Method references** for cleaner delegation to existing methods (e.g., `this::secondButtonClicked`)
- **Diamond operator** (`<>`) for improved type inference on generic constructors
- **Try-with-resources** for automatic resource management (e.g., `InputStream`, `ByteArrayOutputStream`)

## Setup and Running

### Prerequisites
- **Java 8 JDK** (JDK 1.8) or higher
- **Android Studio** 3.5 or higher (recommended)
- **Android SDK** with API level 28 (Android 9.0 Pie)
- **Android Build Tools** 28.0.3

### Steps to Run
1. Clone the repository:
   ```
   git clone https://github.com/COG-GTM/intro_android_demo.git
   ```
2. Open the project in Android Studio.
3. Let Android Studio sync the Gradle files and download any missing SDK components.
4. Connect an Android device (API 21+) or start an emulator.
5. Click **Run** (or use `./gradlew build` from the command line) to build and deploy the app.

### Building from Command Line
```
./gradlew build check --daemon
```

<img src="http://i.imgur.com/DzkMzcy.png" width="250" />&nbsp;
<img src="http://i.imgur.com/VJWFW9Q.png" width="250" />

## Sample Listing

 - Chapter 1: App Fundamentals
   - Basic TextViews Example
 - Chapter 2: User Interface
   - Linear Layout Demo
 - Chapter 3: View Controls
    - Layout Gravity
    - Basic Views
    - View Attributes
    - Simple ListView
 - Chapter 4: User Interactions
   - Basic Click Handlers
   - Handling ListView Clicks
   - Action Bar Demo
 - Chapter 5: User Flows
   - Explicit Intents
   - Implicit Intents
   - Intent with Results
 - Chapter 6: Networking
   - Basic Image Download
   - AsyncTask Example
   - Smart Image Download
 - Chapter 7: Advanced Views
   - Toast Inputs
   - Spinner Toast
   - TimePicker
   - ProgressBar
   - GridView
 - Chapter 8: Preferences
   - Persist Settings
 - Chapter 9: Content Providers
   - Contact List
 - Chapter 10: Publishing
   - APK Instructions
