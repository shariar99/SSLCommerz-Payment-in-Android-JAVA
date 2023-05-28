# SSL Payment Example

This is an Android application that demonstrates how to integrate SSLCommerz library for SSL payment integration.

## Prerequisites

- Android Studio
- Android SDK
- SSLCommerz library (add the necessary dependencies to your project)

## Getting Started

1. Clone the repository or download the source code.

   ```shell
   git clone https://github.com/shariar99/SSLCommerz-Payment-in-Android-JAVA.git

2. Open the project in Android Studio.

3. Build the project to resolve any missing dependencies.

4. Run the application on an emulator or a physical device.

## Usage

1. Open the application on your device.

2. Enter the payment amount in the provided field.

3. Click on the "Pay" button.

4. Follow the payment flow as guided by the SSLCommerz library.

5. Once the transaction is completed, you will receive a success or failure message.

## Configuration

To configure the SSLCommerz integration, you need to modify the following code in `MainActivity.java`:

      ```java
     sslCommerzInitialization = new SSLCommerzInitialization(
    "your-sslcommerz-store-id",
    "your-sslcommerz-store-password",
    Double.parseDouble(amount),
    SSLCCurrencyType.BDT,
    amount,
    "eshop",
    SSLCSdkType.TESTBOX
    );

Replace "your-sslcommerz-store-id" and "your-sslcommerz-store-password" with your own store ID and password provided by SSLCommerz.

## License
MIT License

Feel free to use this code as a reference for integrating SSLCommerz library into your own Android projects. Modify and extend it as per your requirements.

Acknowledgements
SSLCommerz - The library used for SSL payment integration.

Author
Shariar 

Please replace `"your-sslcommerz-store-id"` and `"your-sslcommerz-store-password"` in the `MainActivity.java` code with your actual store ID and password provided by SSLCommerz.


