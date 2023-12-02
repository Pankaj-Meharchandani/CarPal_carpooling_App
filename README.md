# CarPal: A Carpooling App for Android

CarPal is an app that allows users to find and share rides with other people who are going in the same direction. Users can sign up, log in, and reset their password using the app. The app uses SQLite to store user data locally. The app also integrates Google Maps API to show the current location and destination of the users.

## Features

- **User authentication**: Users can create an account, log in, and reset their password using the app. The app validates the user input and encrypts the password before storing it in the SQLite database.
- **Location search**: Users can search for their destination using the app. The app uses Google Places API to autocomplete the search query and show the results on the map.
- **Ride matching**: Users can find other users who are going in the same direction and request to join their ride. The app uses Firebase Realtime Database to store and retrieve the ride information and match the users based on their location and destination.
- **Ride sharing**: Users can accept or reject the ride requests from other users. The app uses Firebase Cloud Messaging to send and receive notifications and Firebase Storage to store and display the user profile pictures.

## Installation

To run the app, you need to have Android Studio installed on your computer. You can download it from [here](^1^). You also need to have a Google account and enable the Google Maps, Google Places, Firebase, and Cloud Messaging services for your project. You can follow the instructions from [here](^2^) to set up your project.

To clone the repository, open the terminal and run the following command:

```
git clone https://github.com/Pankaj-Meharchandani/CarPal_carpooling_App.git
```

To open the project, launch Android Studio and select **Open an existing project**. Navigate to the folder where you cloned the repository and select it. Android Studio will automatically sync the project and download the necessary dependencies.

To run the app, connect your device or emulator and click on the **Run** button. The app will be installed and launched on your device or emulator.

## Contribution

This app is still in progress and needs some improvements. If you want to help me with this project, you are welcome to do so. You can fork the repository, make some changes, and create a pull request. I will review your code and merge it if it is suitable. Some of the pending tasks are:

- Fix the maps issue
- Add a rating system for the users
- Add a payment system for the rides
- Add more features and functionalities

## License

This project is licensed under the MIT License. See the [LICENSE](^3^) file for more details.
