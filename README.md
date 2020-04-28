# android-kotlin-boilerplate
Boilerplate code for Android app using Google Firebase Authentication/Cloud Firestore, Dagger2 for dependency injection, and RxJava2 for async events.

## To setup and run:

- [Create a Firebase project](https://firebase.google.com/docs/android/setup) and add the `google-services.json` to your app folder.
Follow any other instructions to connect your app to the newly created project

- Once your app is connected, go to `Authentication` in the menu on the left and create a User

- Next go to `Database` in the menu on the left and click `Start collection`. Create a collection called Users.
Once that is done create the fields `email`, `imageUrl` and `username` (you can add other fields as needed but remember to modify the User data class)

- Now create a User in this collection with the same email you used when creating a User in the `Authentication` section

- Head back to Android Studio and run the project

- If setup was done correctly, you should be able to log in from the app using the credentials you used to create your User in `Authentication`

- At this point you can also register a new User from the register screen in your app
