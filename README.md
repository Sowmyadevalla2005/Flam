# Arm64OpenCVCamera

This project demonstrates how to use OpenCV with an Android application to capture and process camera images in real-time.

## Project Structure

- `app/`: Contains the Android application source code (Java/Kotlin) for camera access, UI setup, and image processing.
- `gradle/`: Gradle wrapper files.
- `build.gradle.kts`: Top-level Gradle build file.
- `settings.gradle.kts`: Gradle settings file.

## Features Implemented

- **📸 Camera Feed Integration:** Captures real-time frames from the camera using `JavaCameraView`.
- **⚙️ Camera Permissions:** Enables necessary camera permissions for device camera access.
- **🖼️ Frame Processing with OpenCV:**
    - Declares and initializes `Mat` objects to store and process camera frames.
    - Implements adaptive thresholding using OpenCV's `Imgproc.adaptiveThreshold` to process camera frames when a checkbox is checked.

## Screenshots or GIF

(Please add screenshots or a GIF of the working application here)

## Setup Instructions

To build and run this project, you will need Android Studio and the Android SDK.

1.  **Clone the repository:**

    ```bash
    git clone https://github.com/your-repo/Arm64OpenCVCamera.git
    cd Arm64OpenCVCamera
    ```

2.  **Open in Android Studio:**
    Open the cloned project in Android Studio.

3.  **OpenCV Dependencies:**
    *   **OpenCV as a Gradle Dependency:** The project includes OpenCV as a Gradle dependency.
        The `app/build.gradle.kts` file declares `implementation("org.opencv:opencv:4.10.0")` which automatically downloads and configures the OpenCV library from a Maven repository. No manual setup of prebuilt binaries is required.

4.  **Gradle Sync:**
    Android Studio will automatically sync the Gradle project and download any necessary dependencies. Resolve any dependency issues that arise.

## Running the Application

1.  **Connect Device/Emulator:**
    Connect an ARM64 Android device to your computer or start an ARM64 Android Virtual Device (AVD).

2.  **Run from Android Studio:**
    In Android Studio, select the `app` module and click the "Run" button (green triangle icon). The application will be installed and launched on your selected device/emulator.

## Architecture Explanation (Frame Flow)

This Android application captures and processes camera images entirely within the Java/Kotlin layer, leveraging the OpenCV Android library.

1.  **Camera Frame Capture:**
    The application uses `JavaCameraView` to establish a real-time camera feed. `JavaCameraView` handles the intricacies of camera access and continuously delivers frames.

2.  **Frame Conversion and Processing:**
    As `JavaCameraView` provides new camera frames, they are received and converted into OpenCV `Mat` objects. OpenCV's `Imgproc.adaptiveThreshold` function is then applied to these `Mat` objects, performing adaptive thresholding based on a checkbox state.

3.  **Display:**
    The processed `Mat` objects are then displayed back on the `JavaCameraView`, providing a real-time view of the processed camera feed.

This architecture simplifies the development by keeping all image processing within the Android (Java/Kotlin) environment, utilizing the convenient features of the OpenCV Android library.

## Dependencies

This project uses:

-   **OpenCV:** For image capture and processing capabilities.
-   **AndroidX Libraries:** Standard Android support libraries for UI and application components.

## Contributing

Feel free to fork this repository, make improvements, and submit pull requests.

## License

This project is licensed under the MIT License - see the LICENSE file for details. (Note: A LICENSE file is not yet included in this project, but is a common practice and recommended for open-source projects.) 
