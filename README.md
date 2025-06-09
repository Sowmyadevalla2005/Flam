# Arm64OpenCVCamera

This project demonstrates how to use OpenCV with an Android application targeting ARM64 architecture. It provides a basic camera interface that utilizes OpenCV for real-time edge detection and displays the processed output.

## Project Structure

- `app/`: Contains the Android application source code (Java/Kotlin) for camera access, UI setup, and JNI calls.
- `jni/`: Contains the native C++ code for OpenCV processing (e.g., Canny edge detection) and JNI interface.
- `gradle/`: Gradle wrapper files.
- `build.gradle.kts`: Top-level Gradle build file.
- `settings.gradle.kts`: Gradle settings file.

## Features Implemented

- **📸 Camera Feed Integration:** Captures real-time camera frames using Android Camera API (e.g., TextureView/SurfaceTexture).
- **🔁 Frame Processing via OpenCV (C++):**
    - Sends each camera frame to native C++ code via JNI.
    - Applies Canny Edge Detection (or Grayscale/Gaussian blur as implemented) using OpenCV.
    - The processed image is then displayed on the Android UI.
- **⚙️ Architecture:** Modular project structure with clear separation of Java/Kotlin for UI/camera and C++ for OpenCV.

## Screenshots or GIF

(Please add screenshots or a GIF of the working application here)

## Setup Instructions

To build and run this project, you will need Android Studio and the Android SDK, along with the Android NDK and OpenCV dependencies.

1.  **Clone the repository:**

    ```bash
    git clone https://github.com/your-repo/Arm64OpenCVCamera.git
    cd Arm64OpenCVCamera
    ```

2.  **Open in Android Studio:**
    Open the cloned project in Android Studio.

3.  **NDK Setup:**
    Ensure you have the Android NDK installed. Android Studio usually prompts you to install it if missing. You can check/install it via `SDK Manager -> SDK Tools -> NDK (Side by side)`.

4.  **OpenCV Dependencies:**
    *   **OpenCV as a Gradle Dependency:** The project includes OpenCV as a Gradle dependency.
        The `app/build.gradle.kts` file declares `implementation("org.opencv:opencv:4.10.0")` which automatically downloads and configures the OpenCV library from a Maven repository. No manual setup of prebuilt binaries is required.

5.  **Gradle Sync:**
    Android Studio will automatically sync the Gradle project and download any necessary dependencies. Resolve any dependency issues that arise.

## Running the Application

1.  **Connect Device/Emulator:**
    Connect an ARM64 Android device to your computer or start an ARM64 Android Virtual Device (AVD).

2.  **Run from Android Studio:**
    In Android Studio, select the `app` module and click the "Run" button (green triangle icon). The application will be installed and launched on your selected device/emulator.

## Architecture Explanation (JNI and Frame Flow)

The application's architecture is designed to leverage Android's Java/Kotlin capabilities for camera management and UI, while offloading computationally intensive image processing to native C++ code using the Java Native Interface (JNI).

1.  **Camera Frame Capture (Java/Kotlin):**
    The Android `app` module uses the Camera API (e.g., `CameraX`, `Camera2`, or `Camera1`) to capture real-time camera frames. These frames are typically received as `Image` objects or `byte[]` arrays.

2.  **JNI Call to Native Code (Java/Kotlin -> C++):**
    Once a new frame is available, the Java/Kotlin layer invokes a native C++ function via JNI. This typically involves passing the raw pixel data (e.g., `ByteBuffer` or `byte[]`) and frame metadata (width, height, format) to the C++ side.

3.  **OpenCV Processing (C++):**
    In the `jni` module, the native C++ code receives the frame data. It then converts this raw data into an OpenCV `Mat` object. OpenCV functions (e.g., `cv::Canny` for edge detection, `cv::cvtColor` for grayscale) are applied to process the `Mat`.

4.  **Display (Java/Kotlin):**
    The processed OpenCV output is then displayed back on the Android UI, creating a real-time processed camera feed.

This flow ensures that performance-critical image processing is handled efficiently in C++, while the Android framework manages camera hardware and UI presentation.

## Dependencies

This project uses:

-   **OpenCV:** For advanced image processing capabilities in C++.
-   **AndroidX Libraries:** Standard Android support libraries for UI and camera integration.

## Contributing

Feel free to fork this repository, make improvements, and submit pull requests.

## License

This project is licensed under the MIT License - see the LICENSE file for details. (Note: A LICENSE file is not yet included in this project, but is a common practice and recommended for open-source projects.) 
